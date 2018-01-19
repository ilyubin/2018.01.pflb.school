package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://ok.ru")
public class MainPage extends PageObject {

    @FindBy(css=".mctc_name_tx")
    private WebElementFacade userNameInHeader;

    @FindBy(css="div[class=\"input_placeholder\"]")
    private WebElementFacade postTextArea;

    @FindBy(xpath="//*[@id=\"hook_Block_pfnull\"]/div/div[1]/div[1]/div[2]")
    private WebElementFacade writePost;

    @FindBy(css = "div[class=\"posting_submit button-pro\"]")
    private WebElementFacade submitPostButton;

    @FindBy(xpath="(//div[@class='feed-list']//div[@class='media-text_cnt'])[1]")
    private WebElementFacade post;

    public String getUserName() {
        return userNameInHeader.getText();
    }

    public void fillPost(String text){
        postTextArea.click();
        writePost.sendKeys(text);
    }

    public void submitPost(){
        submitPostButton.click();
    }
    public String getLastPost() {
        return post.getText();
    }
}