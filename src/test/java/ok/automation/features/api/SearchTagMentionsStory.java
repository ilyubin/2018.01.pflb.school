package ok.automation.features.api;

import io.restassured.response.Response;
import ok.automation.models.api.search.tagMentions.SearchTagMentionsResponse;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTagMentionsStory extends BaseFeatureApi {

    @Test
    public void get_tag_mentions() {
        Response response = api.get_tag_mentions();
        assertThat(response.statusCode()).isEqualTo(200);
        SearchTagMentionsResponse r = response.as(SearchTagMentionsResponse.class);
        assertThat(r.all).isPositive();
    }
}
