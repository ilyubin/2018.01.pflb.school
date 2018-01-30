package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.GiftConstructorPage;
import ok.automation.pages.GiftPage;
import ok.automation.tech.extensions.ISteps;

public class GiftSteps implements ISteps {

    GiftPage giftPage;

    GiftConstructorPage giftConstructorPage;

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

    @Step
    public String getButtonName(){
        return giftPage.getButtonName();
    }

    @Step
    public String getCongats(){
        return  giftConstructorPage.congrats();
    }

    @Step
    public void search_gift(String textSearch){
        giftPage.fillSearchInput(textSearch);
    }

    @Step
    public boolean check_result_search_gift() {
        return giftPage.giftCard();
    }
}