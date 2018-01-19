package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.MainPage;
import ok.automation.tech.extensions.ISteps;

public class PostSteps implements ISteps {

    MainPage mainPage;

    @Step
    public void open_page() {
        mainPage.open();
    }

    @Step
    public void create_text_post(String text) {
//        mainPage.fillPost(text);
//        mainPage.submitPost();
    }

    @Step
    public String last() {
//         String post = mainPage.getLastPost();
        return "";
    }
}