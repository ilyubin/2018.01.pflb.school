package ok.automation.pages.friend;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://ok.ru")
public class FriendIngoingRequestsPage extends PageObject {

    @FindBy(css = "#hook_Loader_UserFriendRequestMRBLoader")
    private WebElementFacade usersEndlessBlock;

    public boolean hasUsers() {
        return usersEndlessBlock.containsElements(By.className("ucard-w-list_i"));
    }

    public String getFirstUserName() {
        WebElementFacade futureFriend = usersEndlessBlock.find(By.cssSelector("div.ucard-w-list_i"));
        return futureFriend.find(By.cssSelector("div.ellip-i > a")).getText();
    }

    public String getFirstUserId() {
        WebElementFacade futureFriend = usersEndlessBlock.find(By.cssSelector("div.ucard-w-list_i"));
        return futureFriend.find(By.cssSelector("span[data-id]")).getAttribute("data-id");
    }

    public void acceptUserWithId(String userId) {
        find(By.cssSelector(String.format("span[data-l*=inviteFromButton][data-entity-id='%s']", userId))).click();
    }
}
