package ok.automation.features.api;

import ok.automation.factories.api.GroupGetInfoFactory;
import ok.automation.models.api.group.getInfo.GroupGetInfoRequest;
import ok.automation.models.api.group.getInfo.GroupGetInfoResponse;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupGetInfoStory extends BaseFeatureApi {

    @Test
    public void get_group_info() {
        GroupGetInfoRequest request = GroupGetInfoFactory.withAllFields();
        GroupGetInfoResponse response = api.get_group_info_ok(request);

    }
}
