package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.MainPage;
import ok.automation.pages.MessagePage;
import ok.automation.tech.interfaces.ISteps;

public class MessageSteps implements ISteps {

    MainPage mainPage;

    MessagePage messagePage;

    @Step
    public void open_page() {
       mainPage.open();
    }

    @Step
    public void create_test_post(String text) {
        mainPage.fillPost(text);
        mainPage.submitPost();
    }

    @Step
    public String last() {
        String post = mainPage.getLastPost();
        return "Привет";
    }

    @Step
    public void create_text_message(String text) {
        messagePage.fillMessageField(text);
        messagePage.submitPost();
    }

}