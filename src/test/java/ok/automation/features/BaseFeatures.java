package ok.automation.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BaseFeatures {

    @Managed
    public WebDriver webdriver;

    protected String okLogin = System.getProperty("okLogin");
    protected String okPass = System.getProperty("okPass");
    protected String okName = System.getProperty("okName");
}
