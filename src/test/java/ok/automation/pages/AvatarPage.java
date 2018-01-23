package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

/**
 * Created by user on 19.01.2018.
 */
@DefaultUrl("https://ok.ru")
public class AvatarPage extends PageObject{

    @FindBy(css="#plp_descrChgLnk")
    private WebElementFacade buttonAddDescription;
    public void clickAddDescription() {
        buttonAddDescription.click();
    }

    @FindBy(css="[data-too-long-msg]")
    private WebElementFacade fieldDescription;
    public void fillDescription(String text) {
        fieldDescription.type(text);
    }

    @FindBy(css="[name=\"plp_descrInpBtn\"]")
    private WebElementFacade buttonSaveDescription;
    public void clickSaveDescription() {
        buttonSaveDescription.click();
    }

    @FindBy(css="#plp_descrCntText")
    private WebElementFacade avatarDescription;
    public String getAvatarDescription() {
        return avatarDescription.getText();
    }

    @FindBy(css="[contenteditable]")
    private WebElementFacade fieldComment;
    public void fillComment(String text) { fieldComment.type(text); }

    @FindBy(css="[data-l=\"t\\,submit\"]")
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

    @FindBy(css="[contenteditable]")
    private WebElementFacade textBoxComment;
    public void clickTextBoxComment() { textBoxComment.click();
    }
}
