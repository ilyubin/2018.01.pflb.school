package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@DefaultUrl("https://ok.ru")
public class FriendPage extends PageObject {

    @FindBy(css = "#hook_Block_MainContainer")
    private WebElementFacade mainContainer;

    /* Общие кнопки */

    @FindBy(css = "#hook_Block_HeaderTopFriendsInToolbar a")
    private WebElementFacade friendsHeaderButton;

    @FindBy(css = ".nav-side a[hrefattrs*=OnlineFriends]")
    private WebElementFacade friendsOnlineButton;

    @FindBy(css = "#hook_Block_UserFriendsCatalogRB [hrefattrs*=OutgoingFriendRequests]")
    private WebElementFacade friendOutRequestsButton;

    @FindBy(css = "#hook_Block_UserFriendsCatalogRB [hrefattrs*=userFriendRequest]")
    private WebElementFacade friendInRequestsButton;

    @FindBy(css = "input#search")
    private WebElementFacade searchField;

    @FindBy(id = "hook_Loader_MyFriendsSquareCardsPagingBLoader")
    private WebElementFacade welcomeFriendBlock;

    /* Поиск среди друзей по имени */

    @FindBy(id = "searchResults")
    private WebElementFacade foundFriendsBlock;

    @FindBy(css = "#hook_Block_MyFriendsFriendSearchPagingB .gs_result_list > div > .ucard-v")
    private List<WebElementFacade> foundFriendsOnPage;

    @FindBy(id = "hook_Loader_MyFriendsGlobalSearchPagingBLoader")
    private WebElementFacade foundUsersResultEndlessBlock;

    /* Запросы в друзья */

    @FindBy(css = "div[data-block='OutgoingFriendshipRequests']")
    private WebElementFacade outRequestsUsersEndlessBlock; // Исходящие запросы

    @FindBy(id = "hook_Loader_UserFriendRequestMRBLoader")
    private WebElementFacade inRequestsUsersEndlessBlock; // Входящие запросы

    /* Переходы на подстраницы */

    public void openFriendPage() {
        friendsHeaderButton.click();
    }

    public void openFriendOutRequestsPage() {
        withAction().moveToElement(mainContainer).perform();
        friendOutRequestsButton.click();
    }

    public void openFriendInRequestsPage() {
        withAction().moveToElement(mainContainer).perform();
        friendInRequestsButton.click();
    }

    /* Главная страница */

    public String getFirstFriendName() {
        return welcomeFriendBlock.find(By.xpath("(//div[@id='hook_Loader_MyFriendsSquareCardsPagingBLoader']//a[@class='o'])[1]")).getText();
    }

    public String getLastFriendName() {
        return welcomeFriendBlock.find(By.xpath("(//div[@id='hook_Loader_MyFriendsSquareCardsPagingBLoader']//a[@class='o'])[last()]")).getText();
    }

    /* Поиск среди друзей */

    public void searchFor(String searchRequest) {
        searchField.typeAndEnter(searchRequest);
    }

    public int getFoundFriendsOnPageAmount() {
        return foundFriendsOnPage.size();
    }

    public String getFoundFriendNameOnPageByIndex(int index) {
        return foundFriendsOnPage.get(index).findElement(By.cssSelector(".shortcut-wrap")).getText();
    }

    public String getFoundFriendNameOnPageById(String userId) {
        return foundFriendsBlock.findElement(By.cssSelector(String.format("a[href*='%s'][data-l*='User_name']", userId))).getText();
    }

    /* Поиск среди других пользователей */

    public boolean hasUsersInFoundResult() {
        return foundUsersResultEndlessBlock.containsElements(By.cssSelector(".ucard-v"));
    }

    public boolean canAddAnyFoundUserToFriends() {
        return hasAnyElementInEndlessBlock(foundUsersResultEndlessBlock, By.cssSelector(".ucard-v .button-pro"));
    }

    public String addFirstFoundUserToFriendsAndGetId() {
        WebElementFacade futureFriend = foundUsersResultEndlessBlock.find(By.xpath("//div[@id='hook_Loader_MyFriendsGlobalSearchPagingBLoader']/div/div/div[contains(@class, 'ucard-v') and descendant::span[contains(@class,'button-pro')]]"));
        futureFriend.find(By.cssSelector(".button-pro")).click();
        return futureFriend.find(By.cssSelector("a[href^=\"/profile/\"]"))
                .getAttribute("href")
                .split("\\D+")[1];
    }

    /* Исходящие запросы: OutRequests */

    public boolean hasUsersOutRequests() {
        return outRequestsUsersEndlessBlock.containsElements(By.cssSelector(".ucard-w-list_i"));
    }

    public boolean isUserWithIdInOutRequests(String userId) {
        String selector = String.format("div[data-entity-id='%s']", userId);
        return hasAnyElementInEndlessBlock(outRequestsUsersEndlessBlock, By.cssSelector(selector));
    }

    public String getUserNameByIdInOutRequests(String userId) {
        return outRequestsUsersEndlessBlock.find(By.cssSelector(String.format("div[data-entity-id='%s']", userId)))
                .find(By.cssSelector("div.ellip-i > a")).getText();
    }

    /* Входящие запросы: InRequest */

    public boolean hasUsersInRequests() {
        return inRequestsUsersEndlessBlock.containsElements(By.cssSelector(".ucard-w-list_i"));
    }

    public String getFirstUserNameInInRequests() {
        WebElementFacade futureFriend = inRequestsUsersEndlessBlock.find(By.cssSelector("div.ucard-w-list_i"));
        return futureFriend.find(By.cssSelector("div.ellip-i > a")).getText();
    }

    public String getFirstUserIdInInRequests() {
        WebElementFacade futureFriend = inRequestsUsersEndlessBlock.find(By.cssSelector("div.ucard-w-list_i"));
        return futureFriend.find(By.cssSelector("div.entity-item")).getAttribute("data-entity-id");
    }

    public void acceptUserWithIdInRequest(String userId) {
        find(By.cssSelector(String.format("span[data-l*=inviteFromButton][data-entity-id='%s']", userId))).click();
    }

    /* Полезные методы */

    private boolean hasAnyElementInEndlessBlock(WebElementFacade endlessBlock, By elementSelector) {
        int pageBefore = Integer.parseInt(endlessBlock.getAttribute("data-page"));
        int pageAfter = 0;
        boolean containsElement = endlessBlock.containsElements(elementSelector);
        By showMoreLinkSelector = By.cssSelector("a.link-show-more");
        while (!containsElement && pageBefore != pageAfter) {
            while (pageBefore != pageAfter) {
                pageBefore = pageAfter;
                WebElementFacade lastChildInList = endlessBlock.find(By.xpath("div[1]/div[last()]"));
                withAction().moveToElement(lastChildInList).perform();
                pageAfter = Integer.parseInt(endlessBlock.getAttribute("data-page"));
                containsElement = endlessBlock.containsElements(elementSelector);
                if (containsElement) {
                    break;
                }
            }
            if (!containsElement && endlessBlock.containsElements(showMoreLinkSelector)) {
                WebElementFacade showMoreLink = endlessBlock.find(showMoreLinkSelector);
                withAction().moveToElement(showMoreLink).click().build().perform();
                pageAfter = 0;
            }
        }
        return containsElement;
    }
}