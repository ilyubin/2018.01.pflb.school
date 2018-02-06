package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import ok.automation.tech.extensions.PageObjectExtension;
import org.openqa.selenium.By;

public class GiftConstructorPage extends PageObjectExtension {

    private String frameId = "appMain_Div";

    @FindBy(css="li[data-color*='#ff8100']")
    private WebElementFacade color;

    @FindBy(xpath="//*[@id=\"id-text_input\"]']")
    private WebElementFacade textField;

    @FindBy(css="div[data-font_index*='1']")
    private WebElementFacade font;

    @FindBy(css="#id-ready_present_btn .con-btn_back")
    private WebElementFacade giftReadyButton;

    @FindBy(css="#id-start_text_present_btn")
    private WebElementFacade textGiftIcon;

    @FindBy(css=".pts_congrats")
    private WebElementFacade congratsText;

    public void fillTextField(String text) {
        String js = String.format("document.getElementById('id-text_input').value= \"%s\"",text);
        doInFrame(frameId, () -> evaluateJavascript(js));
    }

    public void selectColor(String element){
        doInFrame(frameId, () -> find(By.cssSelector(element)).click());
    }

    public void selectFont(){
        doInFrame(frameId, () -> font.click());
    }

    public void clickGiftReadyButton(){
        doInFrame(frameId, () -> giftReadyButton.click());
    }

    public void selectTextGift(){
        doInFrame(frameId, () -> textGiftIcon.click());
    }

    public String congrats(){
        return doInFrame(frameId, () -> congratsText.getText());
    }

}
