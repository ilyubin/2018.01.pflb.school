package ok.automation.pages.friend;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ok.automation.pages.friend.FriendPage.hasAnyElementInEndlessBlock;

@DefaultUrl("https://ok.ru")
public class FriendOutgoingRequestsPage extends PageObject {

    @FindBy(css = "#hook_Block_UserFriendsCatalogRB [hrefattrs*='OutgoingFriendRequests']")
    private WebElementFacade friendsOutgoingRequestsButton;

    @FindBy(css = "div[data-block='OutgoingFriendshipRequests']")
    private WebElementFacade usersEndlessBlock;

    public void openPage() {
        friendsOutgoingRequestsButton.click();
        waitForLoading();
    }

    public void waitForLoading(){
        By by = By.xpath("//div[@id='hook_Block_NavigationProgressBar']//div[@role='progressbar']");
        waitFor(ExpectedConditions.attributeContains(by, "class", "__complete"));
    }

    public boolean hasUserWithId(String userId) {
        String selector = String.format("div[data-entity-id='%s']", userId);
        return hasAnyElementInEndlessBlock(withAction(), usersEndlessBlock, By.cssSelector(selector));
    }

    public String getUserNameById(String userId) {
        return usersEndlessBlock.find(By.cssSelector(String.format("div[data-entity-id='%s']", userId)))
                .find(By.cssSelector("div.ellip-i > a")).getText();
    }
}
