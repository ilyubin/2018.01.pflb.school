package ok.automation.models.api.base;

public class LikeSummary {
    public Integer count;
    public String[] friend_ids;
    public Friend[] friends;
    public String impression_id;
    public Long last_like_date_ms;
    public String like_id;
    public Boolean like_possible;
    public String like_unavailable_reason;
    public String[] liker_refs;
    public Reaction[] reactions;
    public Boolean self;
    public String self_reaction;
    public Boolean unlike_possible;
}
