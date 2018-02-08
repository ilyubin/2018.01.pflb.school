package ok.automation.features.api;

import net.thucydides.core.annotations.WithTagValuesOf;
import ok.automation.factories.api.UsersGetCurrentUserFactory;
import ok.automation.models.api.errors.ErrorResponse;
import ok.automation.models.api.users.getCurrentUser.UsersGetCurrentUserRequest;
import ok.automation.models.api.users.getCurrentUser.UsersGetCurrentUserResponse;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersGetCurrentUserStory extends BaseFeatureApi {

    @Test
    @WithTagValuesOf({"read", "smoke", "env:stage"})
    public void get_current_user_should_be_succes_for_all_fields() {
        UsersGetCurrentUserRequest request = UsersGetCurrentUserFactory.withAllFields();
        UsersGetCurrentUserResponse r = api.get_current_user_ok(request);
        assertThat(r.name).contains(r.first_name).contains(r.last_name);
    }

    @Test
    public void get_current_user_should_return_error_if_invalid_field() {
        UsersGetCurrentUserRequest request = UsersGetCurrentUserFactory.withAllFields();
        request.fields = new String[]{String.format("invalidField-%s", UUID.randomUUID())};
        ErrorResponse r = api.get_current_user_error(request);
        assertThat(r.error_code).isEqualTo(100);
        assertThat(r.error_msg).contains(String.format("Invalid parameter fields value  : [%s]", request.fields[0]));
    }
}
