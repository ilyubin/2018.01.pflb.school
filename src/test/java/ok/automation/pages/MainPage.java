package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://ok.ru")
public class MainPage extends PageObject {

    @FindBy(css=".mctc_name_tx")
    private WebElementFacade userNameInHeader;

    @FindBy(css="#hook_Block_PostingForm a[data-l*=input]")
    private WebElementFacade postFieldHolder;

    @FindBy(css=".posting_itx-w [data-initial-text-to-modify]")
    private WebElementFacade popupPostField;

    @FindBy(css=".posting_footer [data-action=submit]")
    private WebElementFacade popupPostSubmit;

    @FindBy(xpath="(//div[@class='feed-list']//div[@class='media-text_cnt'])[1]")
    private WebElementFacade lastPost;

    @FindBy(xpath="//div[@class='feed-list']//div[@class='media-text_cnt']")
    private List<WebElementFacade> allPosts;

    public String getUserName() {
        return userNameInHeader.getText();
    }

    public void fillPost(String text) {
        postFieldHolder.click();
        popupPostField.type(text);
    }

    public void submitPost() {
        popupPostSubmit.click();
    }

    public String getLastPost() {
        return lastPost.getText();
    }
}