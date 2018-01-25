package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class GiftConstructorPage extends PageObject {

    private String frameId = "appMain_Div";

    @FindBy(css="li[data-color*='#ff8100']")
    private WebElementFacade color;

    @FindBy(css="#id-text_input']")
    private WebElementFacade textField;

    @FindBy(css="div[data-font_index*='1']")
    private WebElementFacade font;

    @FindBy(css="#id-ready_present_btn .con-btn_back")
    private WebElementFacade giftReadyButton;

    @FindBy(css="#id-start_text_present_btn")
    private WebElementFacade textGiftIcon;

    @FindBy(css=".pts_congrats")
    private WebElementFacade congratsText;

    public void fillTextField(String text){
        textField.type(text);
    }

    public void selectColor(){
        color.click();
    }

    public void selectFont(){
        font.click();
    }

    public void clickGiftReadyButton(){
        giftReadyButton.click();
    }

    public void selectTextGift(){
        getDriver().switchTo().frame(frameId);
        textGiftIcon.click();
    }

    public String congrats(){
        congratsText.waitUntilPresent();
        return congratsText.getText();
    }







}
