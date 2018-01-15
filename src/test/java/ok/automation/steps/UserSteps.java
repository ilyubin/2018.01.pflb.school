package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.LoginPage;
import ok.automation.pages.MainPage;

public class UserSteps {

    LoginPage loginPage;
    MainPage mainPage;

    @Step
    public void open_login_page() {
        loginPage.open();
    }

    @Step
    public void loginToOkRu(String login, String pass) {
        loginPage.fillLoginForm(login, pass);
        loginPage.submitLoginForm();
    }

    @Step
    public String nameInHeader() {
        return mainPage.getUserName();
    }
}