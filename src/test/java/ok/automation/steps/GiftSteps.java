package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class GiftSteps implements ISteps {

    MainPage mainPage;

    @Step
    public void open_page() {

    }
}