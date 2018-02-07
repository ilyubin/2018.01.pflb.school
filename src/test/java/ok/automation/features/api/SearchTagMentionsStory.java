package ok.automation.features.api;

import net.thucydides.core.annotations.WithTagValuesOf;
import ok.automation.factories.api.SearchTagMentionsFactory;
import ok.automation.models.api.search.tagMentions.SearchTagMentionsRequest;
import ok.automation.models.api.search.tagMentions.SearchTagMentionsResponse;
import ok.automation.tech.extensions.BaseFeatureApi;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTagMentionsStory extends BaseFeatureApi {

    @Test
    @WithTagValuesOf({"read", "smoke", "env:stage"})
    public void get_tag_mentions() {
        SearchTagMentionsRequest request = SearchTagMentionsFactory.withAllTypes();
        SearchTagMentionsResponse r = api.get_tag_mentions_ok(request);
        assertThat(r.all).isPositive();
    }
}
