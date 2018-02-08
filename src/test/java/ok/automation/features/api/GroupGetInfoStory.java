package ok.automation.features.api;

import net.thucydides.core.annotations.WithTagValuesOf;
import ok.automation.factories.api.GroupGetInfoFactory;
import ok.automation.models.api.errors.ErrorResponse;
import ok.automation.models.api.group.getInfo.GroupGetInfoRequest;
import ok.automation.models.api.group.getInfo.GroupGetInfoResponse;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupGetInfoStory extends BaseFeatureApi {

    @Test
    @WithTagValuesOf({"read", "smoke", "env:stage"})
    public void get_group_info_should_be_succes_for_all_uids_and_fields() {
        GroupGetInfoRequest request = GroupGetInfoFactory.withAllFields();
        GroupGetInfoResponse[] r = api.get_group_info_ok(request);
        assertThat(r).extracting("name").containsExactly(GroupGetInfoFactory.NAMES);
        assertThat(r).extracting("access_type").containsOnly("OPEN");
        assertThat(r).extracting("country").containsOnly("Russia", "Moldova");
    }

    @Test
    public void get_group_info_should_return_error_if_missing_required_uids() {
        GroupGetInfoRequest request = GroupGetInfoFactory.withAllFields();
        request.uids = null;
        ErrorResponse r = api.get_group_info_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains("Missing required parameter uids");
    }

    @Test
    public void get_group_info_should_return_error_if_empty_uids() {
        GroupGetInfoRequest request = GroupGetInfoFactory.withAllFields();
        request.uids = new String[]{""};
        ErrorResponse r = api.get_group_info_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains("Missing required parameter uids");
    }

    @Test
    public void get_group_info_should_return_error_if_invalid_uids() {
        GroupGetInfoRequest request = GroupGetInfoFactory.withAllFields();
        request.uids = new String[]{String.format("invalidGroupId-%s", UUID.randomUUID())};
        ErrorResponse r = api.get_group_info_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains(String.format("Invalid UID value %s", request.uids[0]));
    }

    @Test
    public void get_group_info_should_return_error_if_invalid_fields() {
        GroupGetInfoRequest request = GroupGetInfoFactory.withAllFields();
        request.fields = new String[]{String.format("invalidField-%s", UUID.randomUUID())};
        ErrorResponse r = api.get_group_info_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains(String.format("Invalid parameter fields value  : [%s]", request.fields[0]));
    }
}
