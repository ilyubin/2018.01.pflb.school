package ok.automation.steps;

import ok.automation.pages.MainPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class AvatarSteps implements ISteps {

    MainPage mainPage;

    @Step
    public void open_page() {

    }
}