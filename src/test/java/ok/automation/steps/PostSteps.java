package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.MainPage;

public class PostSteps implements ISteps {

    MainPage mainPage;

    @Step
    public void open_page() {
    }

    @Step
    public void create_text_post(String text) {

    }

    @Step
    public String last() {
        return "";
    }
}