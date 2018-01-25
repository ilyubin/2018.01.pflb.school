package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.GiftPage;
import ok.automation.pages.TopContentRow;
import ok.automation.tech.extensions.ISteps;

public class TopContentRowSteps implements ISteps {
    TopContentRow topContentRow;

    @Step
    public void open_page() {

    }

    @Step
    public void open_gift_page() {
        topContentRow.openGiftPage();
    }

}
