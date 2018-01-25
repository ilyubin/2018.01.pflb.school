package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

public class AvatarPage extends PageObject{

    @FindBy(id="plp_descrChgLnk")
//    @FindBy(css="#plp_descrAddLnk") // TODO fix for first time add description
    private WebElementFacade buttonAddDescription;
    public void clickAddDescription() {
        buttonAddDescription.click();
    }

    @FindBy(css="[data-too-long-msg]")
    private WebElementFacade fieldDescription;
    public void fillDescription(String text) {
        fieldDescription.type(text);
    }

    @FindBy(id="plp_descrInpBtn")
    private WebElementFacade buttonSaveDescription;
    public void clickSaveDescription() {
        buttonSaveDescription.click();
    }

    @FindBy(id="plp_descrCntText")
    private WebElementFacade avatarDescription;
    public String getAvatarDescription() {
        return avatarDescription.getText();
    }

    @FindBy(css="[action*=CommentBlock] [id^=field]")
    private WebElementFacade fieldComment;
    public void fillComment(String text) {
        _scroll(fieldComment);
        fieldComment.type(text);
    }

    private void _scroll(WebElementFacade element) {
        withAction().moveToElement(element).build().perform();
    }

    @FindBy(css=".comments_add-controls .form-actions_yes")
    private WebElementFacade buttonAddComment;
    public void clickAddComment() {
        buttonAddComment.waitUntilVisible();
        buttonAddComment.click();
    }

    @FindBy(xpath="//div[@class='comments_lst_cnt']/div[last()]//div[@class='comments_text textWrap']")
    private WebElementFacade avatarComment;
    public String getAvatarComment() {
        return avatarComment.getText();
    }

    @FindBy(id="hook_FormButton_button_plpscp_confirm")
    private WebElementFacade buttonOkEditAvatar;
    public void clickOkEditAvatar() {
        buttonOkEditAvatar.click();
    }
}
