package ok.automation.tech.extensions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Supplier;

public abstract class PageObjectExtension extends PageObject {

    protected void moveToElement(WebElementFacade element) {
        withAction().moveToElement(element).build().perform();
    }

    protected void moveToElementAndClick(WebElementFacade element) {
        withAction().moveToElement(element).click().build().perform();
    }

    protected void doInFrame(String frameId, Runnable... f){
        getDriver().switchTo().frame(frameId);
        for(int i = 0; i < f.length; i++)
            f[i].run();
        getDriver().switchTo().parentFrame();
    }

    protected String doInFrame(String frameId, Supplier<String> f){
        getDriver().switchTo().frame(frameId);
        String result = f.get();
        getDriver().switchTo().parentFrame();
        return result;
    }

}
