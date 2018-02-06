package ok.automation.factories;

import ok.automation.models.api.group.getCounters.GroupGetCountersRequest;

public class GroupGetCountersFactory {

    public static final String GROUP_ID = "54635655856155";
    public static final String[] COUNTER_TYPES = {
            "VIDEOS", "THEMES", "SUGGESTED_TOPICS", "SUGGESTED_PRODUCTS",
            "PROMO_TOPICS_ON_MODERATION", "PRODUCTS", "PRESENTS", "PHOTO_ALBUMS",
            "PHOTOS", "OWN_PRODUCTS", "MODERATORS", "MEMBERS",
            "MAYBE", "LINKS", "JOIN_REQUESTS", "DELAYED_TOPICS",
            "CATALOGS", "BLACK_LIST"
    };

    public static GroupGetCountersRequest withAllCounters() {
        GroupGetCountersRequest data = new GroupGetCountersRequest();
        data.groupId = GROUP_ID;
        data.counterTypes = COUNTER_TYPES;
        return data;
    }

    public static GroupGetCountersRequest withThemes() {
        GroupGetCountersRequest data = new GroupGetCountersRequest();
        data.groupId = GROUP_ID;
        data.counterTypes = new String[]{"THEMES"};
        return data;
    }
}
