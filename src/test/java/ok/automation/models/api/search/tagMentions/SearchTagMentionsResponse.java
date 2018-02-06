package ok.automation.models.api.search.tagMentions;

import ok.automation.tech.extensions.BaseModel;

public class SearchTagMentionsResponse extends BaseModel {
    public Integer all;
    public Integer groupPhotos;
    public Integer groupTopics;
    public Integer groupVideos;
    public String query;
    public Integer userPhotos;
    public Integer userTopics;
    public Integer userVideos;
}
