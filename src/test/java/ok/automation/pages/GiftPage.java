package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class GiftPage {

    @FindBy(css="#gf-search-input")
    private WebElementFacade searchInputField;

    @FindBy(css=".gift_a")
    private WebElementFacade gift;

    public void fillSearchFiled(String text) {
        searchInputField.type(text);
    }

    public String getFoundGiftInfo(){
        return gift.getAttribute("href");
    }

}
