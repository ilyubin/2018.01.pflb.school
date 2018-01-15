package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class MainPage extends PageObject {

    @FindBy(css=".mctc_name_tx")
    private WebElementFacade userNameInHeader;

    public String getUserName() {
        return userNameInHeader.getText();
    }
}