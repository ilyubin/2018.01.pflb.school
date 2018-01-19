package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.MainPage;
import ok.automation.tech.extensions.ISteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class MessageSteps implements ISteps {

    MainPage mainPage;

    @Step
    public void open_page() {

    }
}