package ok.automation.tech.extensions;

import com.github.javafaker.Faker;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import ok.automation.steps.UserSteps;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import static net.thucydides.core.annotations.ClearCookiesPolicy.Never;

@RunWith(SerenityRunner.class)
public class BaseFeature {

    @Managed(clearCookies=Never)
    public WebDriver webdriver;

    protected String okLogin = System.getProperty("okLogin");
    protected String okPass = System.getProperty("okPass");
    protected String okName = System.getProperty("okName");

    protected Faker fake = new Faker();

    @Steps
    private UserSteps _user;

    private static boolean _setUpIsDone = false;

    @Before
    public void setUp() {
        if (_setUpIsDone)
            return;
        _user.open_login_page();
        _user.loginToOkRu(okLogin, okPass);
        _setUpIsDone = true;
    }
}
