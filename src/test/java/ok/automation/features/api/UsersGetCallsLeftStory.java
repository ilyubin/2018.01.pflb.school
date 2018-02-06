package ok.automation.features.api;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import ok.automation.models.api.users.getCallsLeft.UsersGetCallsLeftRequest;
import ok.automation.models.api.users.getCallsLeft.UsersGetCallsLeftResponse;
import ok.automation.steps.ApiSteps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class UsersGetCallsLeftStory {

    @Steps
    private ApiSteps _api;

    @Test
    public void get_call_left() {
        UsersGetCallsLeftRequest request = new UsersGetCallsLeftRequest();
        request.uid = "";
        request.method = "users.getCallsLeft";
        request.methods = new String[] {
            "users.getCallsLeft"
        };
        UsersGetCallsLeftResponse response = _api.get_call_left_positive(request);
    }
}
