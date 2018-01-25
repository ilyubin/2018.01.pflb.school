package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.GiftConstructorPage;
import ok.automation.pages.GiftPage;
import ok.automation.pages.MainPage;
import ok.automation.tech.extensions.ISteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class GiftSteps implements ISteps {

    GiftPage giftPage;

    GiftConstructorPage giftConstructorPage;

    @Step
    public void open_page() {
        giftPage.open();

    }

    @Step
    public void look_for_gift(String text){
        giftPage.fillSearchFiled(text);
        giftPage.waitForSearching();
        //giftPage.getFoundGiftInfo();
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
    public void select_orange_fontColor(){
        giftConstructorPage.selectColor();
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


}