package ok.automation.pages;

import com.google.common.base.Supplier;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.function.BiPredicate;

@DefaultUrl("/gifts")
public class GiftPage extends PageObject {

    @FindBy(css="#gf-search-input")
    private WebElementFacade searchInputField;

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
        getDriver().switchTo().frame(payFrame);
        touchButton.click();
    }

    public String getButtonName(){
        return getCodeButton.getText();
    }

    @FindBy(css="#gf-search-input")
    private WebElementFacade searchInput;

    /**
     * Заполнение формы поиска подарка
     * @param giftName - название подарка для поиска
     */
    public void searchGiftInputFill(String giftName) {
        searchInput.type(giftName);
    }

    @FindBy(css="#gf-search-lupa")
    private WebElementFacade searchButton;

    /**
     * Запуск поиска подарка
     */
    public void searchGiftButtonClick() {
        searchButton.click();
    }


//    getCountResultSearchGift() {
//        webdriver.FindElement(By.Id("id_tb")).FindElements(By.TagName("tr")).Count
//    }
}
