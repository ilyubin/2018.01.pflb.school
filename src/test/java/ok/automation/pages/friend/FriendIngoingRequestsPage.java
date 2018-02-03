package ok.automation.pages.friend;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DefaultUrl("https://ok.ru")
public class FriendIngoingRequestsPage extends PageObject {

    @FindBy(css = "#hook_Block_UserFriendsCatalogRB [hrefattrs*='userFriendRequest']")
    private WebElementFacade friendsIngoingRequestsButton;

    @FindBy(id = "hook_Block_UserFriendRequestMRB")
    private WebElementFacade usersEndlessBlock;

    public void openPage() {
        friendsIngoingRequestsButton.click();
        waitForLoading();
    }

    public void waitForLoading(){
        By by = By.xpath("//div[@id='hook_Block_NavigationProgressBar']//div[@role='progressbar']");
        waitFor(ExpectedConditions.attributeContains(by, "class", "__complete"));
    }

    private WebElementFacade getFirstUser() {
        return usersEndlessBlock.find(By.cssSelector("div.ucard-w-list_i"));
    }

    public String getFirstUserName() {
        return getFirstUser().find(By.cssSelector("div.ellip-i > a")).getText();
    }

    public String getFirstUserId() {
        return getFirstUser().find(By.cssSelector("span[data-id]")).getAttribute("data-id");
    }

    public void acceptUserWithId(String userId) {
        find(By.cssSelector(String.format("span[data-l*=inviteFromButton][data-entity-id='%s']", userId))).click();
    }
}
