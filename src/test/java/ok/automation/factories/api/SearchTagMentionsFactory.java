package ok.automation.factories.api;

import ok.automation.models.api.search.tagMentions.SearchTagMentionsRequest;

public abstract class SearchTagMentionsFactory {
    public static final String QUERY = "harrypotter";
    public static final String METHOD = "search.tagMentions";
    public static final String FILTER = "{" +
            "\"since\":\"1990-05-30 00:00:00\"," +
            "\"types\":[\"USER_TOPIC\", \"USER_PHOTO\", \"USER_VIDEO\", \"GROUP_TOPIC\", \"GROUP_PHOTO\", \"GROUP_VIDEO\"]," +
            "\"until\":\"2017-05-30 00:00:00\"" +
            "}";

    public static SearchTagMentionsRequest withAllTypes() {
        SearchTagMentionsRequest data = new SearchTagMentionsRequest();
        data.query = QUERY;
        data.method = METHOD;
        data.filter = FILTER;
        return data;
    }
}
