package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import ok.automation.tech.extensions.PageObjectExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("/gifts")
public class GiftPage extends PageObjectExtension {

    @FindBy(css=".gift_a")
    private WebElementFacade giftImg;

    @FindBy(css=".search-input_ic ic18.ic18_anim-procces")
    private WebElementFacade waitIcon;

    @FindBy(css=".modal-new_payment-frame")
    private WebElementFacade payFrame;

    @FindBy(css=".gifts-sidebanner_tx")
    private WebElementFacade giftCreationBanner;

    @FindBy(css=".ugrid_cnt .ucard-v")
    private WebElementFacade firstFriendImg;

    @FindBy(css="#proceedButton")
    private WebElementFacade touchButton;

    @FindBy(css=".button-pro_tx")
    private WebElementFacade getCodeButton;

    @FindBy(id="gf-search-input")
    private WebElementFacade searchInput;

    @FindBy(id="gf-search-lupa")
    private WebElementFacade searchButton;

    @FindBy(css="#hook_Block_GiftsFrontContentRBx>.gift-front_cnt>.__search")
    private WebElementFacade giftResultSearch;

    public void giftImgClick(){
        giftImg.click();
    }

    public void clickGiftCreationBanner(){
        giftCreationBanner.click();
    }

    public void clickFriendPhoto(){firstFriendImg.click();}

    public void clickTouchButton(){
        getDriver().switchTo().frame(payFrame);
        touchButton.click();
    }

    public String getButtonName(){
        return getCodeButton.getText();
    }

    public void fillSearchInput(String textSearch) {
        searchInput.type(textSearch);
    }

    public boolean giftCard() {
        WebDriverWait driverWait = new WebDriverWait(getDriver(), 5); //TODO How does this line take away in PageObjectExtension.java?
        driverWait.until(ExpectedConditions.visibilityOf(giftResultSearch));
        return true;
    }
}
