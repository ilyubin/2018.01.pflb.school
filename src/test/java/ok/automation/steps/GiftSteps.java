package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.WebElementFacade;
import ok.automation.pages.GiftConstructorPage;
import ok.automation.pages.GiftPage;
import ok.automation.pages.MainPage;
import ok.automation.pages.TopContentRow;
import ok.automation.tech.extensions.ISteps;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class GiftSteps implements ISteps {

    GiftPage giftPage;

    GiftConstructorPage giftConstructorPage;

    TopContentRow topContentRow;

    @Step
    public void open_gift_page() {
        topContentRow.openGiftPage();
    }

    @Step
    public void open_page() {
        giftPage.open();
    }

    @Step
    public void select_gift(){
        giftPage.giftImgClick();
    }

    @Step
    public void create_text_gift(){
        giftConstructorPage.selectTextGift();
    }

    @Step
    public void input_text(String text){
        giftConstructorPage.fillTextField(text);
    }

    @Step
    public void select_font_color(String element){
        giftConstructorPage.selectColor(element);
    }

    @Step
    public void select_font_style(){
        giftConstructorPage.selectFont();
    }

    @Step
    public void complete_gift_creation(){
        giftConstructorPage.clickGiftReadyButton();
    }

    @Step
    public void create_own_gift(){
        giftPage.clickGiftCreationBanner();
    }

    @Step
    public void select_friend(){
        giftPage.clickFriendPhoto();
    }

    @Step
    public void send(){
        giftPage.clickTouchButton();
    }

    @Step
    public String getButtonName(){
        return giftPage.getButtonName();
    }

    @Step
    public String getCongats(){
        return  giftConstructorPage.congrats();
    }


}