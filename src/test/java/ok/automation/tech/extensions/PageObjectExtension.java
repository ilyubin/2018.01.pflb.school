package ok.automation.tech.extensions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PageObjectExtension extends PageObject {
    protected void _scroll(WebElementFacade element) {
        withAction().moveToElement(element).build().perform();
    }
}
