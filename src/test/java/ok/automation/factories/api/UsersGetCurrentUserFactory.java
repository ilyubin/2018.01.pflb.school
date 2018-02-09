package ok.automation.factories.api;

import ok.automation.models.api.users.getCurrentUser.UsersGetCurrentUserRequest;

public abstract class UsersGetCurrentUserFactory {
    public static final String METHOD = "users.getCurrentUser";
    public static final String[] FIELDS = {
            "ACCESSIBLE", "AGE", "ALLOWS_ANONYM_ACCESS", "ALLOWS_MESSAGING_ONLY_FOR_FRIENDS",
            "BECOME_VIP_ALLOWED", "BIRTHDAY", "BLOCKED", "BLOCKS", "CAN_VCALL", "CAN_VMAIL",
            "CITY_OF_BIRTH", "COMMON_FRIENDS_COUNT", "CURRENT_LOCATION", "CURRENT_STATUS",
            "CURRENT_STATUS_DATE", "CURRENT_STATUS_DATE_MS", "CURRENT_STATUS_ID", "CURRENT_STATUS_MOOD",
            "CURRENT_STATUS_TRACK_ID", "EMAIL", "FIRST_NAME", "FORBIDS_MENTIONING", "FRIEND",
            "FRIEND_INVITATION", "FRIEND_INVITE_ALLOWED", "GENDER", "GROUP_INVITE_ALLOWED",
            "HAS_EMAIL", "HAS_PHONE", "HAS_SERVICE_INVISIBLE", "INTERNAL_PIC_ALLOW_EMPTY",
            "INVITED_BY_FRIEND", "LAST_NAME", "LAST_ONLINE", "LAST_ONLINE_MS", "LOCALE", "LOCATION",
            "LOCATION_OF_BIRTH", "MODIFIED_MS", "NAME", "ODKL_BLOCK_REASON", "ODKL_EMAIL", "ODKL_LOGIN",
            "ODKL_MOBILE", "ODKL_MOBILE_STATUS", "ODKL_USER_OPTIONS", "ODKL_USER_STATUS", "ODKL_VOTING",
            "ONLINE", "PHOTO_ID", "PIC1024X768", "PIC128MAX", "PIC128X128", "PIC180MIN", "PIC190X190",
            "PIC224X224", "PIC240MIN", "PIC288X288", "PIC320MIN", "PIC50X50", "PIC600X600", "PIC640X480",
            "PIC_1", "PIC_2", "PIC_3", "PIC_4", "PIC_5", "PIC_BASE", "PIC_FULL", "PIC_MAX", "PREMIUM",
            "PRESENTS", "PRIVATE", "PYMK_PIC224X224", "PYMK_PIC288X288", "PYMK_PIC600X600", "PYMK_PIC_FULL",
            "REF", "REGISTERED_DATE", "REGISTERED_DATE_MS", "RELATIONS", "RELATIONSHIP", "SEND_MESSAGE_ALLOWED",
            "SHOW_LOCK", "STATUS", "UID", "URL_CHAT", "URL_CHAT_MOBILE", "URL_PROFILE", "URL_PROFILE_MOBILE", "VIP"
    };

    public static UsersGetCurrentUserRequest withAllFields() {
        UsersGetCurrentUserRequest data = new UsersGetCurrentUserRequest();
        data.method = METHOD;
        data.fields = FIELDS;
        return data;
    }

    public static UsersGetCurrentUserRequest withFields(String... fields) {
        UsersGetCurrentUserRequest data = new UsersGetCurrentUserRequest();
        data.method = METHOD;
        data.fields = fields;
        return data;
    }
}
