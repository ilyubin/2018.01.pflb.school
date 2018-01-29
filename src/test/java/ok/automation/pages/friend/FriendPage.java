package ok.automation.pages.friend;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("https://ok.ru")
public class FriendPage extends PageObject {

    @FindBy(css = "#hook_Block_MainContainer")
    private WebElementFacade mainContainer;

    /* Общие кнопки */

    @FindBy(css = "#hook_Block_HeaderTopFriendsInToolbar a")
    private WebElementFacade friendsHeaderButton;

    public void openPage() {
        friendsHeaderButton.click();
    }

    @FindBy(css = ".nav-side a[hrefattrs*=OnlineFriends]")
    private WebElementFacade friendsOnlineButton;

    @FindBy(css = "#hook_Block_UserFriendsCatalogRB [hrefattrs*='OutgoingFriendRequests']")
    private WebElementFacade friendsOutgoingRequestsButton;

    public void openOutgoingRequestsPage() {
        withAction().moveToElement(mainContainer).click(friendsOutgoingRequestsButton).build().perform();
    }

    @FindBy(css = "#hook_Block_UserFriendsCatalogRB [hrefattrs*='userFriendRequest']")
    private WebElementFacade friendsIngoingRequestsButton;

    public void openIngoingRequestsPage() {
        withAction().moveToElement(mainContainer).click(friendsIngoingRequestsButton).build().perform();
    }

    /* Главная страница */

    @FindBy(id = "hook_Loader_MyFriendsSquareCardsPagingBLoader")
    private WebElementFacade welcomeFriendBlock;

    public String getFirstFriendName() {
        return welcomeFriendBlock.find(By.xpath("(*//a[@class='o'])[1]")).getText();
    }

    public String getLastFriendName() {
        return welcomeFriendBlock.find(By.xpath("(*//a[@class='o'])[last()]")).getText();
    }

    /* Полезные методы */

    static boolean hasAnyElementInEndlessBlock(Actions actions, WebElementFacade endlessBlock, By elementSelector) {
        int pageBefore = Integer.parseInt(endlessBlock.getAttribute("data-page"));
        int pageAfter = 0;
        boolean containsElement = endlessBlock.containsElements(elementSelector);
        By showMoreLinkSelector = By.cssSelector("a.link-show-more");
        while (!containsElement && pageBefore != pageAfter) {
            while (pageBefore != pageAfter) {
                pageBefore = pageAfter;
                WebElementFacade lastChildInList = endlessBlock.find(By.xpath("div[1]/div[last()]"));
                actions.moveToElement(lastChildInList).perform();
                pageAfter = Integer.parseInt(endlessBlock.getAttribute("data-page"));
                containsElement = endlessBlock.containsElements(elementSelector);
                if (containsElement) {
                    break;
                }
            }
            if (!containsElement && endlessBlock.containsElements(showMoreLinkSelector)) {
                WebElementFacade showMoreLink = endlessBlock.find(showMoreLinkSelector);
                actions.moveToElement(showMoreLink).click().perform();
                pageAfter = 0;
            }
        }
        return containsElement;
    }

}
