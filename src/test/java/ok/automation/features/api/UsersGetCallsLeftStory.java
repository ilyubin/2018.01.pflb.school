package ok.automation.features.api;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
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
        Response response = _api.get_call_left();
        assertThat(response.statusCode()).isEqualTo(200);
    }
}
