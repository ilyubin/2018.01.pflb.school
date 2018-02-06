package ok.automation.pages.friend;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DefaultUrl("https://ok.ru")
public class FriendPage extends PageObject {

    @FindBy(id = "hook_Block_MainContainer")
    private WebElementFacade mainContainer;

    @FindBy(css = "#hook_Block_HeaderTopFriendsInToolbar a")
    private WebElementFacade friendsHeaderButton;

    public void openPage() {
        friendsHeaderButton.click();
        waitForLoading();
    }

    public void waitForLoading(){
        By by = By.xpath("//div[@id='hook_Block_NavigationProgressBar']//div[@role='progressbar']");
        waitFor(ExpectedConditions.attributeContains(by, "class", "__complete"));
    }

    @FindBy(id = "hook_Loader_MyFriendsSquareCardsPagingBLoader")
    private WebElementFacade friendsGrid;

    private WebElementFacade getFirstFriendWithName() {
        return friendsGrid.find(By.xpath("(ul/li/div[descendant::a[contains(@class, 'o') and text() and not(text() = ' ')]])[1]"));
    }

    public String getFirstFriendWithNameName() {
        return getFirstFriendWithName().find(By.cssSelector("a.o")).getText();
    }

    public String getFirstFriendWithNameUserId() {
        return getFirstFriendWithName().find(By.cssSelector("span[data-id]")).getAttribute("data-id");
    }

    public void switchLetterFilter(String letter){
        By by = By.xpath(String.format("//div[contains(@class, 'filter')]/a[text()='%s']", letter));
        find(by).click();
        waitFor(ExpectedConditions.attributeContains(by, "class", "__active"));
    }

    public void addUserToFriendsById(String userId) {
        String xpath = String.format("//a[contains(@href, 'id=%s') and contains(@href, 'cmd=AddFriendButton')]", userId);
        find(By.xpath(xpath)).click();
    }

    public static boolean hasAnyElementInEndlessBlock(Actions actions, WebElementFacade endlessBlock, By elementSelector) {
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
