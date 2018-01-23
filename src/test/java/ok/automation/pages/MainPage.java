package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://ok.ru")
public class MainPage extends PageObject {

    @FindBy(css=".mctc_name_tx")
    private WebElementFacade userNameInHeader;

    @FindBy(css=".input_placeholder")
    private WebElementFacade postField;

    @FindBy(css=".posting_itx-w [data-initial-text-to-modify]")
    private WebElementFacade popupPostField;

    @FindBy(css=".posting_footer [data-action=submit]")
    private WebElementFacade popupShareButton;

    public String getUserName() {
        return userNameInHeader.getText();
    }

    public void initNewPost() {
        postField.click();
    }

    public void fillPost(String text) {
        popupPostField.click();
        popupPostField.sendKeys(text);
    }

    public void submitPost() {
        popupShareButton.click();
    }

    public String getLastPost() {
        return _getPostByIndex(0);
    }

    public String _getPostByIndex(int index) {
        WebElementFacade post = findBy(String.format("#hook_Block_MainFeedsContent .feed-w:nth-of-type(%s) .media-text_cnt", index + 3));
        return post.getText();
    }
}