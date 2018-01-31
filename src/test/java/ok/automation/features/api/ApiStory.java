package ok.automation.features.api;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import ok.automation.models.group.getCounters.GroupGetCountersResponse;
import ok.automation.steps.ApiSteps;
import ok.automation.steps.AvatarSteps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class ApiStory {

    @Steps
    private ApiSteps _apiSteps;

    @Test
    public void get_group_counters() {
        String groupId = "54635655856155";
        String counterTypes = "themes";
        Response response = _apiSteps.get_group_counters(groupId,counterTypes);
        assertThat(response.statusCode()).isEqualTo(200);

        GroupGetCountersResponse r = response.as(GroupGetCountersResponse.class);
        assertThat(r.counters.themes).isPositive();
        //System.out.println("statusCode = " + response.statusCode());
    }
}
