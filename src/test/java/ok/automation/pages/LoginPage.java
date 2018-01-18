package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://ok.ru")
public class LoginPage extends PageObject {

    @FindBy(id="field_email")
    private WebElementFacade fieldLogin;

    @FindBy(id="field_password")
    private WebElementFacade fieldPassword;

    @FindBy(css="[data-l$=\"loginButton\"]")
    private WebElementFacade buttonLogin;

    public void fillLoginForm(String login, String password) {
        fieldLogin.type(login);
        fieldPassword.type(password);
    }

    public void submitLoginForm() {
        buttonLogin.click();
    }
}