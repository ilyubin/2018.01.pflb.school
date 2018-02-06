package ok.automation.features.api;

import io.restassured.response.Response;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupGetInfoStory extends BaseFeatureApi {

    @Test
    public void get_group_info() {
        Response response = api.get_group_info();
        assertThat(response.statusCode()).isEqualTo(200);
        List<String> names = response.path("name");
        assertThat(names).containsExactly("Гифки", "Рамблер", "ТСВ");
    }
}
