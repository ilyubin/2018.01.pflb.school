package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class GiftConstructorPage extends PageObject {

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
        getDriver().switchTo().frame("appMain_Div");
        textGiftIcon.click();
        getDriver().switchTo().defaultContent();

    }







}
