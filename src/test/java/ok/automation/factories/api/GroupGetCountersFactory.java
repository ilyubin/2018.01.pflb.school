package ok.automation.factories.api;

import ok.automation.models.api.group.getCounters.GroupGetCountersRequest;

public class GroupGetCountersFactory {
    public static final String METHOD = "group.getCounters";
    public static final String GROUP_ID = "54635655856155";
    public static final String[] COUNTER_TYPES = {
            "VIDEOS", "THEMES", "SUGGESTED_TOPICS", "SUGGESTED_PRODUCTS",
            "PROMO_TOPICS_ON_MODERATION", "PRODUCTS", "PRESENTS", "PHOTO_ALBUMS",
            "PHOTOS", "OWN_PRODUCTS", "MODERATORS", "MEMBERS",
            "MAYBE", "LINKS", "JOIN_REQUESTS", "DELAYED_TOPICS",
            "CATALOGS", "BLACK_LIST"
    };

    public static GroupGetCountersRequest withAllCounterTypes() {
        GroupGetCountersRequest request = new GroupGetCountersRequest();
        request.method = METHOD;
        request.groupId = GROUP_ID;
        request.counterTypes = COUNTER_TYPES;
        return request;
    }
}
