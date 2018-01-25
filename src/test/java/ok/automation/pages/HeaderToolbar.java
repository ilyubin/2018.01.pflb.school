package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class HeaderToolbar extends PageObject {

    @FindBy(css="#hook_Block_HeaderTopFriendsInToolbar a")
    private WebElementFacade friendsHeaderButton;

    private WebElementFacade friendsHeaderButton() {
        return find(By.cssSelector("#hook_Block_HeaderTopFriendsInToolbar a"));
    }
}