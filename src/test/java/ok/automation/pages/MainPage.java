package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://ok.ru")
public class MainPage extends PageObject {

    @FindBy(css=".mctc_name_tx")
    private WebElementFacade userNameInHeader;

    public String getUserName() {
        return userNameInHeader.getText();
    }

    @FindBy(css=".input_placeholder")
    private WebElementFacade buttonNewPost;

    public void clickNewPost() {
        buttonNewPost.click();
    }

    @FindBy(css="[data-initial-text-to-modify]")
    private WebElementFacade fieldPost;

    public void fillPost(String text) {
        fieldPost.type(text);
    }

    @FindBy(css="[data-action=\"submit\"]")
    private WebElementFacade buttonPost;

    public void submitPost() {
        buttonPost.click();
    }

    @FindBy(css=".media-text_cnt")
    private WebElementFacade formPost;

    public String getLastPost() {
        return formPost.getText();
    }
}