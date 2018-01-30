package ok.automation.features.api;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import ok.automation.steps.ApiSteps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class ApiStory {

    @Steps
    private ApiSteps _api;

    @Test
    public void get_group_counters() {
        Response response = _api.get_group_counters();
        assertThat(response.statusCode()).isEqualTo(200);
    }
}
