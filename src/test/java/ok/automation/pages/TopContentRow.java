package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class TopContentRow extends PageObject {

    @FindBy(css="a[hrefattrs*=NavMenu_User_Presents]")
    private WebElementFacade giftsHeaderButton;

    public void openGiftPage(){
        giftsHeaderButton.click();
    }



}
