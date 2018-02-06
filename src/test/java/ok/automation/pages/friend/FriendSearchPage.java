package ok.automation.pages.friend;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@DefaultUrl("https://ok.ru")
public class FriendSearchPage extends PageObject {

    @FindBy(id = "search")
    private WebElementFacade searchField;

    @FindBy(xpath = "//div[starts-with(@id, 'hook_Block_MyFriends')]//div[starts-with(@id, 'hook_Block_MyFriends') and descendant::div[contains(@class, 'ucard-v')]]")
    private WebElementFacade friendsBlock;

    @FindBy(css = "#hook_Block_MyFriendsFriendSearchPagingB .gs_result_list > div > .ucard-v")
    private List<WebElementFacade> friendsOnPage;

    public void searchFor(String request) {
        searchField.typeAndEnter(request);
        waitForSearching();
    }

    public void waitForSearching(){
        By by = By.cssSelector("div.it_w.search-input.search-input_active");
        waitFor(ExpectedConditions.not(ExpectedConditions.attributeContains(by, "class", "search-input_searching")));
    }

    public void waitForLoading(){
        By by = By.xpath("//div[@id='hook_Block_NavigationProgressBar']//div[@role='progressbar']");
        waitFor(ExpectedConditions.attributeContains(by, "class", "__complete"));
    }

    public int getFriendsOnPageAmount() {
        return friendsOnPage.size();
    }

    public String getFriendNameOnPageByIndex(int index) {
        return friendsOnPage.get(index).findElement(By.cssSelector(".shortcut-wrap")).getText();
    }

    public String getFriendNameOnPageById(String userId) {
        return friendsBlock.findElement(By.xpath(String.format("*//div[contains(@class, 'ellip')]/a[contains(@hrefattrs,'%s')]", userId))).getText();
    }

}
