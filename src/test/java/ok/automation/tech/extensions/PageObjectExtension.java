package ok.automation.tech.extensions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectExtension extends PageObject {

    protected void _scroll(WebElementFacade element) {
        withAction().moveToElement(element).build().perform();
    }

}
