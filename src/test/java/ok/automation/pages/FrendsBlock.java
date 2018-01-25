package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class FrendsBlock extends PageObject {
    @FindBy(css=".ellip-i")
    private WebElementFacade firstFriend;

    public  void selectFriend(){
        firstFriend.click();
    }
}
