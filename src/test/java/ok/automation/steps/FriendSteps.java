package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.FrendsBlock;
import ok.automation.pages.FriendPage;
import ok.automation.pages.MainPage;
import ok.automation.tech.extensions.ISteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class FriendSteps implements ISteps {

    MainPage mainPage;

    FrendsBlock frendsBlock;

    FriendPage friendPage;

    @Step
    public void open_page() {

    }

    @Step
    public void openFriendPage() {
        frendsBlock.selectFriend();
    }

    @Step
    public void present() {
        friendPage.clickPresent();
    }
}