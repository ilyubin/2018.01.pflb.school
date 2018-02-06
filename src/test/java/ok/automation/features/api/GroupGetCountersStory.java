package ok.automation.features.api;

import ok.automation.models.api.errors.ErrorResponse;
import ok.automation.models.api.group.getCounters.GroupGetCountersRequest;
import ok.automation.models.api.group.getCounters.GroupGetCountersResponse;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupGetCountersStory extends BaseFeatureApi {

    public static final String GROUP_ID = "54635655856155";

    @Test
    public void get_group_counters() {
        GroupGetCountersRequest request = new GroupGetCountersRequest();
        request.groupId = GROUP_ID;
        request.counterTypes = new String[]{
                "VIDEOS", "THEMES", "SUGGESTED_TOPICS", "SUGGESTED_PRODUCTS",
                "PROMO_TOPICS_ON_MODERATION", "PRODUCTS", "PRESENTS", "PHOTO_ALBUMS",
                "PHOTOS", "OWN_PRODUCTS", "MODERATORS", "MEMBERS",
                "MAYBE", "LINKS", "JOIN_REQUESTS", "DELAYED_TOPICS",
                "CATALOGS", "BLACK_LIST"
        };
        GroupGetCountersResponse r = api.get_group_counters_ok(request);
        assertThat(r.counters.themes).isPositive();
    }

    @Test
    public void get_group_counters_should_return_error_if_invalid_groupId() {
        GroupGetCountersRequest request = new GroupGetCountersRequest();
        request.groupId = "invalidGroupId";
        request.counterTypes = new String[]{"THEMES"};
        ErrorResponse r = api.get_group_counters_error(request);
        assertThat(r.error_code).isEqualTo(160);
        assertThat(r.error_msg).contains(String.format("Invalid group_id [%s]", request.groupId));
    }

    @Test
    public void get_group_counters_should_return_error_if_invalid_counterTypes() {
        GroupGetCountersRequest request = new GroupGetCountersRequest();
        request.groupId = GROUP_ID;
        request.counterTypes = new String[]{"INVALID"};
        ErrorResponse r = api.get_group_counters_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains(String.format("Invalid parameter counterTypes value  : [%s]", request.counterTypes[0]));
    }
}
