package ok.automation.features.api;

import io.restassured.response.Response;
import ok.automation.models.api.ErrorResponse;
import ok.automation.models.api.group.getCounters.GroupGetCountersRequest;
import ok.automation.models.api.group.getCounters.GroupGetCountersResponse;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupGetCountersStory extends BaseFeatureApi {

    @Test
    public void get_group_counters_200() {
        GroupGetCountersRequest request = new GroupGetCountersRequest();
        request.groupId = "54635655856155";
        request.counterTypes = new String[]{
                "VIDEOS", "THEMES", "SUGGESTED_TOPICS", "SUGGESTED_PRODUCTS",
                "PROMO_TOPICS_ON_MODERATION", "PRODUCTS", "PRESENTS", "PHOTO_ALBUMS",
                "PHOTOS", "OWN_PRODUCTS", "MODERATORS", "MEMBERS",
                "MAYBE", "LINKS", "JOIN_REQUESTS", "DELAYED_TOPICS",
                "CATALOGS", "BLACK_LIST"
        };
        Response response = api.get_group_counters(request);
        assertThat(response.statusCode()).isEqualTo(200);
        GroupGetCountersResponse r = response.as(GroupGetCountersResponse.class);
        assertThat(r.counters.themes).isPositive();
    }

    @Test
    public void get_group_counters_error_if_invalid_groupId() {
        GroupGetCountersRequest request = new GroupGetCountersRequest();
        request.groupId = "InvalidGroupId";
        request.counterTypes = new String[]{"THEMES"};
        Response response = api.get_group_counters(request);
        assertThat(response.statusCode()).isEqualTo(200);
        ErrorResponse r = response.as(ErrorResponse.class);
        assertThat(r.error_msg).contains(String.format("Invalid group_id [%s]", request.groupId));
    }
}
