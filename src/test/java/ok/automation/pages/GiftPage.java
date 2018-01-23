package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("/gifts")
public class GiftPage extends PageObject {

    @FindBy(css="#gf-search-input")
    private WebElementFacade searchInputField;

    @FindBy(css=".gift_a")
    private WebElementFacade giftImg;

    @FindBy(css=".search-input_ic ic18.ic18_anim-procces")
    private WebElementFacade waitIcon;

    @FindBy(css=".gifts-sidebanner_tx")
    private WebElementFacade giftCreationBanner;

    @FindBy(css=".ugrid_cnt .ucard-v")
    private WebElementFacade firstFriendImg;

    @FindBy(css="#proceedButton")
    private WebElementFacade touchButton;

    public void fillSearchFiled(String text) {
        searchInputField.type(text);
    }

    public String getFoundGiftInfo(){
        return giftImg.getAttribute("href");
    }

    public void giftImgClick(){
        giftImg.click();
    }

    public void waitForSearching(){
        while(waitIcon.isDisplayed());
    }

    public void clickGiftCreationBanner(){
        giftCreationBanner.click();
    }

    public void clickFriendPhoto(){firstFriendImg.click();}

    public void clickTouchButton(){
        //while(to.isDisplayed());
        touchButton.waitUntilClickable();
        touchButton.click();
    }


}
