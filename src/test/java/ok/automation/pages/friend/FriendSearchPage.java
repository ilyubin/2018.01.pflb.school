package ok.automation.pages.friend;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

import static ok.automation.pages.friend.FriendPage.hasAnyElementInEndlessBlock;

@DefaultUrl("https://ok.ru")
public class FriendSearchPage extends PageObject {

    @FindBy(id = "search")
    private WebElementFacade searchField;

    @FindBy(id = "searchResults")
    private WebElementFacade friendsBlock;

    @FindBy(css = "#hook_Block_MyFriendsFriendSearchPagingB .gs_result_list > div > .ucard-v")
    private List<WebElementFacade> friendsOnPage;

    @FindBy(id = "hook_Loader_MyFriendsGlobalSearchPagingBLoader")
    private WebElementFacade usersEndlessBlock;

    public void searchFor(String request) {
        searchField.typeAndEnter(request);
    }

    public int getFriendsOnPageAmount() {
        return friendsOnPage.size();
    }

    public String getFriendNameOnPageByIndex(int index) {
        return friendsOnPage.get(index).findElement(By.cssSelector(".shortcut-wrap")).getText();
    }

    public String getFriendNameOnPageById(String userId) {
        return friendsBlock.findElement(By.cssSelector(String.format("a[href*='%s'][data-l*='User_name']", userId))).getText();
    }

    public String addFirstUserAndGetId() {
        WebElementFacade futureFriend = usersEndlessBlock.find(By.xpath("//div[@id='hook_Loader_MyFriendsGlobalSearchPagingBLoader']/div/div/div[contains(@class, 'ucard-v') and descendant::span[contains(@class,'button-pro')]]"));
        futureFriend.find(By.className("button-pro")).click();
        return futureFriend.find(By.cssSelector("span[data-id]"))
                .getAttribute("data-id");
    }

    public boolean hasUsers() {
        return usersEndlessBlock.containsElements(By.className("ucard-v"));
    }

    public boolean canAddAnyUserToFriends() {
        return hasAnyElementInEndlessBlock(withAction(), usersEndlessBlock, By.cssSelector(".ucard-v .button-pro"));
    }

}
