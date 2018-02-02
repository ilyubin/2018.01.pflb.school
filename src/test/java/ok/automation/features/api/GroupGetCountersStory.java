package ok.automation.features.api;

import io.restassured.response.Response;
import ok.automation.models.api.group.getCounters.GroupGetCountersResponse;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupGetCountersStory extends BaseFeatureApi {

    @Test
    public void get_group_counters() {
        Response response = api.get_group_counters();
        assertThat(response.statusCode()).isEqualTo(200);
        GroupGetCountersResponse r = response.as(GroupGetCountersResponse.class);
        assertThat(r.counters.themes).isPositive();
    }
}
