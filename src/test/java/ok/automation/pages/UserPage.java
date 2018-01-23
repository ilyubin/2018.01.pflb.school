package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class UserPage extends PageObject{

    @FindBy(css="#action_menu_send_gift_a")
    private WebElementFacade present;

    public void clickPresentButton(){
        present.click();
    }

}
