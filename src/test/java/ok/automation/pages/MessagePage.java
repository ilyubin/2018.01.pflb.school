package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

/**
 * Created by teacher on 06.02.2018.
 */
@DefaultUrl("https://ok.ru")
public class MessagePage extends PageObject {

    @FindBy(css="#msg_toolbar_button")
    private WebElementFacade messageButtonInToolbar;

    @FindBy(css="form[action*=MessagesController] div[contenteditable]")
    private WebElementFacade friends;

    @FindBy(css="[contenteditable]")
    private WebElementFacade userNameInHeader;

    @FindBy(css="[title=\"Отправить\"]")
    private WebElementFacade userName;

    public String getUserName() {
        return userNameInHeader.getText();
    }

    @FindBy(css="[data-save]")
    private WebElementFacade shareButton;

    public void submitPost() {
        shareButton.click();
        }
    public void fillMessageField(String text) {
        messageButtonInToolbar.click();
        friends.click();
        userNameInHeader.typeAndEnter(text);
    }

    @FindBy(css="[data-tid=\"67898914310997\"] .media-text_a")
    private WebElementFacade lastPost;
    public String getLastPost() {
        return lastPost.getText();
    }
}
