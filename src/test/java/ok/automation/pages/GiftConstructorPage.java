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

    public void fillTextField(String text){
        //getDriver().switchTo().frame(frameId);
        textField.type(text);
        //getDriver().switchTo().defaultContent();
    }

    public void selectColor(){
        //getDriver().switchTo().frame(frameId);
        color.click();
        //getDriver().switchTo().defaultContent();
    }

    public void selectFont(){
        //getDriver().switchTo().frame(frameId);
        font.click();
        //getDriver().switchTo().defaultContent();
    }

    public void clickGiftReadyButton(){
        //getDriver().switchTo().frame(frameId);
        giftReadyButton.click();
        getDriver().switchTo().defaultContent();
    }

    public void selectTextGift(){
        getDriver().switchTo().frame(frameId);
        textGiftIcon.click();
        //getDriver().switchTo().defaultContent();

    }







}
