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
    private WebElementFacade postInput;

    @FindBy(css=".posting_itx")
    private WebElementFacade postInputField;

    @FindBy(css=".posting_submit")
    private WebElementFacade shareButton;

    @FindBy(css=".media-text_cnt_tx")
    private WebElementFacade lastPost;

    public String getUserName() {
        return userNameInHeader.getText();
    }

    public void fillPost(String text){
        postInput.click();
        postInputField.type(text);
    }

    public void submitPost(){
        shareButton.click();
    }

    public String getLastPost() {
        return lastPost.getText();
    }
}