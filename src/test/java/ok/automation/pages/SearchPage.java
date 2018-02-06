package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import ok.automation.pages.friend.FriendPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DefaultUrl("https://ok.ru/search")
public class SearchPage extends PageObject {

    @FindBy(xpath = "//input[@name='st.query']")
    private WebElementFacade searchField;

    public void searchFor(String searchRequest) {
        searchField.typeAndEnter(searchRequest);
        waitForSearching();
    }

    public void waitForSearching(){
        waitFor(ExpectedConditions.not(ExpectedConditions.attributeContains(By.cssSelector("div.it_w.search-input.search-input_active"), "class", "search-input_searching")));
    }

    @FindBy(id = "hook_Loader_PortalSearchResultsLoader")
    private WebElementFacade resultEndlessBlock;

    private WebElementFacade getFirstNonFriendUser() {
        By by = By.xpath("*//div[contains(@class, 'ucard-v') and descendant::a[contains(@href,'AddFriendButton')]/span[contains(@class, 'button-pro')]]");
        if(FriendPage.hasAnyElementInEndlessBlock(withAction(), resultEndlessBlock, by)){
            return resultEndlessBlock.find(by);
        }
        return null;
    }

    public String getFirstNonFriendUserName() {
        return getFirstNonFriendUser().find(By.cssSelector("a.o")).getText();
    }

    public String getFirstNonFriendUserId() {
        return getFirstNonFriendUser().find(By.cssSelector("span[data-id]")).getAttribute("data-id");
    }

}
