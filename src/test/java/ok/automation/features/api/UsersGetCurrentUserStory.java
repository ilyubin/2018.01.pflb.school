package ok.automation.features.api;

import io.restassured.response.Response;
import ok.automation.models.api.users.getCurrentUser.UsersGetCurrentUserResponse;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersGetCurrentUserStory extends BaseFeatureApi {

    @Test
    public void get_current_user() {
        Response response = api.get_current_user();
        assertThat(response.statusCode()).isEqualTo(200);
        UsersGetCurrentUserResponse r = response.as(UsersGetCurrentUserResponse.class);
        assertThat(r.name).contains(r.first_name).contains(r.last_name);
    }
}
