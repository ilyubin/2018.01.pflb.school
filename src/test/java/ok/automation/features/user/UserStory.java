package ok.automation.features.user;

import net.thucydides.core.annotations.Steps;
import ok.automation.features.BaseFeatures;
import ok.automation.steps.UserSteps;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStory extends BaseFeatures {

    @Steps
    private UserSteps _user;

    @Before
    public void open_login_page() {
        _user.open_login_page();
    }

    @Test
    public void should_be_able_login_to_ok_ru() {
        _user.loginToOkRu(okLogin, okPass);
        assertThat(_user.nameInHeader()).isEqualTo(okName);
    }
}