package ok.automation.pages.friend;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static ok.automation.pages.friend.FriendPage.hasAnyElementInEndlessBlock;

@DefaultUrl("https://ok.ru")
public class FriendOutgoingRequestsPage extends PageObject {

    @FindBy(css = "div[data-block='OutgoingFriendshipRequests']")
    private WebElementFacade usersEndlessBlock;

    public boolean hasUsers() {
        return usersEndlessBlock.containsElements(By.className("ucard-w-list_i"));
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
