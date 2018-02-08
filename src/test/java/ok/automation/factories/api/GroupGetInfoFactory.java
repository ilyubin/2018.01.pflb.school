package ok.automation.factories.api;

import ok.automation.models.api.group.getInfo.GroupGetInfoRequest;

public abstract class GroupGetInfoFactory {
    public static final String METHOD = "group.getInfo";
    public static final String[] UIDS = {"52462642987098", "57407629951036", "53427798343931"};
    public static final String[] NAMES = {"Гифки", "Рамблер", "ТСВ"};
    public static final boolean MOVE_TO_TOP = false;
    public static final String[] FIELDS = {
            "ABBREVIATION", "ACCESS_TYPE", "ADDRESS", "ADD_PHOTOALBUM_ALLOWED",
            "ADD_THEME_ALLOWED", "ADD_VIDEO_ALLOWED", "ADMIN_ID", "ADVANCED_PUBLICATION_ALLOWED",
            "AGE_RESTRICTED", "BLOCKED", "BUSINESS", "CATALOG_CREATE_ALLOWED",
            "CATEGORY", "CHANGE_AVATAR_ALLOWED", "CHANGE_TYPE_ALLOWED", "CITY",
            "COMMENT_AS_OFFICIAL", "COMMUNITY", "CONTENT_AS_OFFICIAL", "COUNTRY",
            "CREATED_MS", "DELETE_ALLOWED", "DESCRIPTION", "EDIT_ALLOWED",
            "END_DATE", "FEED_SUBSCRIPTION", "FRIENDS_COUNT", "GRADUATE_YEAR",
            "HOMEPAGE_NAME", "HOMEPAGE_URL", "INVITATION_SENT", "INVITE_ALLOWED",
            "JOIN_ALLOWED", "LEAVE_ALLOWED", "LOCATION_ID", "LOCATION_LATITUDE",
            "LOCATION_LONGITUDE", "LOCATION_ZOOM", "MAIN_PAGE_TAB", "MAIN_PHOTO",
            "MANAGE_MEMBERS", "MEMBERS_COUNT", "MESSAGES_ALLOWED", "MESSAGING_ALLOWED",
            "MIN_AGE", "NAME", "NOTIFICATIONS_SUBSCRIPTION", "PARTNER_PROGRAM_ALLOWED",
            "PARTNER_PROGRAM_STATUS", "PENALTY_POINTS_ALLOWED", "PHONE", "PHOTOS_TAB_HIDDEN",
            "PHOTO_ID", "PIC_AVATAR", "POSSIBLE_MEMBERS_COUNT", "PREMIUM", "PRIVATE",
            "PRODUCTS_TAB_HIDDEN", "PRODUCT_CREATE_ALLOWED", "PRODUCT_CREATE_SUGGESTED_ALLOWED",
            "PRODUCT_CREATE_ZERO_LIFETIME_ALLOWED", "PROMO_THEME_ALLOWED", "PUBLISH_DELAYED_THEME_ALLOWED",
            "REF", "REQUEST_SENT", "SCOPE_ID", "SHOP_VISIBLE_ADMIN", "SHOP_VISIBLE_PUBLIC",
            "SHORTNAME", "START_DATE", "STATS_ALLOWED", "STATUS", "SUBCATEGORY_ID", "SUGGEST_THEME_ALLOWED",
            "TRANSFERS_ALLOWED", "UID", "VIDEO_TAB_HIDDEN", "YEAR_FROM", "YEAR_TO"
    };

    public static GroupGetInfoRequest withAllFields() {
        GroupGetInfoRequest data = new GroupGetInfoRequest();
        data.method = METHOD;
        data.uids = UIDS;
        data.move_to_top = MOVE_TO_TOP;
        data.fields = FIELDS;
        return data;
    }
}
