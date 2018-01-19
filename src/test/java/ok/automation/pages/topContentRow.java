package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class topContentRow {

    @FindBy(css="a[hrefattrs*=NavMenu_User_Presents]")
    private WebElementFacade giftsHeaderButton;

}
