package ok.automation.features.api;

import net.thucydides.core.annotations.WithTagValuesOf;
import ok.automation.factories.api.GroupGetUserGroupsByIdsFactory;
import ok.automation.models.api.errors.ErrorResponse;
import ok.automation.models.api.group.getUserGroupsByIds.GroupGetUserGroupsByIdsRequest;
import ok.automation.models.api.group.getUserGroupsByIds.GroupGetUserGroupsByIdsResponse;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupGetUserGroupsByIdsStory extends BaseFeatureApi {

    @Test
    @WithTagValuesOf({"read", "smoke", "env:stage"})
    public void get_user_groups_by_ids_should_be_succes_for_all_uids_and_fields() {
        GroupGetUserGroupsByIdsRequest request = GroupGetUserGroupsByIdsFactory.withAllUids();
        GroupGetUserGroupsByIdsResponse[] r = api.get_user_groups_by_ids_ok(request);
        assertThat(r).extracting("groupId").containsOnly(GroupGetUserGroupsByIdsFactory.GROUP_ID);
        assertThat(r).extracting("userId").isSubsetOf(GroupGetUserGroupsByIdsFactory.UIDS);
    }

    @Test
    public void get_user_groups_by_ids_should_return_error_if_missing_required_group_id() {
        GroupGetUserGroupsByIdsRequest request = GroupGetUserGroupsByIdsFactory.withAllUids();
        request.group_id = null;
        ErrorResponse r = api.get_user_groups_by_ids_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains("Missing required parameter group_id");
    }

    @Test
    public void get_user_groups_by_ids_should_return_error_if_empty_required_group_id() {
        GroupGetUserGroupsByIdsRequest request = GroupGetUserGroupsByIdsFactory.withAllUids();
        request.group_id = "";
        ErrorResponse r = api.get_user_groups_by_ids_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains("Missing required parameter group_id");
    }

    @Test
    public void get_user_groups_by_ids_should_return_error_if_invalid_group_id() {
        GroupGetUserGroupsByIdsRequest request = GroupGetUserGroupsByIdsFactory.withAllUids();
        request.group_id = String.format("invalidGroupId-%s", UUID.randomUUID());
        ErrorResponse r = api.get_user_groups_by_ids_error(request);
        assertThat(r.error_code).isEqualTo(160);
        assertThat(r.error_msg).contains(String.format("Invalid group_id [%s]", request.group_id));
    }

    @Test
    public void get_user_groups_by_ids_should_return_error_if_missing_required_uids() {
        GroupGetUserGroupsByIdsRequest request = GroupGetUserGroupsByIdsFactory.withAllUids();
        request.uids = null;
        ErrorResponse r = api.get_user_groups_by_ids_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains("Missing required parameter uids");
    }

    @Test
    public void get_user_groups_by_ids_should_return_error_if_empty_uids() {
        GroupGetUserGroupsByIdsRequest request = GroupGetUserGroupsByIdsFactory.withAllUids();
        request.uids = new String[]{""};
        ErrorResponse r = api.get_user_groups_by_ids_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains("Missing required parameter uids");
    }

    // TODO: С одной стороны система правильно делает, что возвращает пустой массив, но с другой - ID пользователей имеет неверный формат
    @Test
    public void get_user_groups_by_ids_should_return_error_if_invalid_uids() {
        GroupGetUserGroupsByIdsRequest request = GroupGetUserGroupsByIdsFactory.withAllUids();
        request.uids = new String[]{String.format("invalidUid-%s", UUID.randomUUID())};
        ErrorResponse r = api.get_user_groups_by_ids_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains(String.format("Invalid UID value %s", request.uids[0]));
    }

    @Test
    @WithTagValuesOf({"read"})
    public void get_user_groups_by_ids_should_return_empty_array_if_user_is_not_at_group() {
        GroupGetUserGroupsByIdsRequest request = GroupGetUserGroupsByIdsFactory.withAllUids();
        request.uids = new String[]{"566211137494"};
        GroupGetUserGroupsByIdsResponse[] r = api.get_user_groups_by_ids_ok(request);
        assertThat(r).hasSize(0);
    }

    @Test
    @WithTagValuesOf({"read", "smoke", "env:stage"})
    public void get_user_groups_by_ids_should_return_one_element_if_user_was_repeated_in_request() {
        String uid = "591420938271";
        GroupGetUserGroupsByIdsRequest request = GroupGetUserGroupsByIdsFactory.withAllUids();
        request.uids = new String[]{uid, uid, uid};
        GroupGetUserGroupsByIdsResponse[] r = api.get_user_groups_by_ids_ok(request);
        assertThat(r)
                .hasSize(1)
                .extracting("userId").containsOnly(uid);
    }
}
