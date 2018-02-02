package ok.automation.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import ok.automation.tech.extensions.HashHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ApiSteps {

    protected static final Logger LOGGER = LoggerFactory.getLogger("|");
    private EnvironmentVariables _env =
            SystemEnvironmentVariables.createEnvironmentVariables();

    @Step
    public Response get_group_counters() {
        String[] counterTypes = new String[]{
                "VIDEOS", "THEMES", "SUGGESTED_TOPICS", "SUGGESTED_PRODUCTS",
                "PROMO_TOPICS_ON_MODERATION", "PRODUCTS", "PRESENTS", "PHOTO_ALBUMS",
                "PHOTOS", "OWN_PRODUCTS", "MODERATORS", "MEMBERS",
                "MAYBE", "LINKS", "JOIN_REQUESTS", "DELAYED_TOPICS",
                "CATALOGS", "BLACK_LIST"
        };
        Map<String, String> params = new HashMap<>();
        params.put("group_id", "54635655856155");
        params.put("method", "group.getCounters");
        params.put("counterTypes", mergeElementsForUri(counterTypes));
        String request = getRequestUrl(params);
        LOGGER.info("request  - | {} |", request);
        Response response = SerenityRest.get(request);
        LOGGER.info("response - | {} | {} |", response.statusCode(), response.body().asString());
        return response;
    }

    @Step
    public Response get_group_info() {
        String[] fields = new String[]{
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
        Map<String, String> params = new HashMap<>();
        params.put("uids", mergeElementsForUri("52462642987098", "57407629951036", "53427798343931"));
        params.put("method", "group.getInfo");
        params.put("fields", mergeElementsForUri(fields));
        String request = getRequestUrl(params);
        LOGGER.info("request  - | {} |", request);
        Response response = SerenityRest.get(request);
        LOGGER.info("response - | {} | {} |", response.statusCode(), response.body().asString());
        return response;
    }

    @Step
    public Response get_tag_mentions() {
        Map<String, String> params = new HashMap<>();
        params.put("query", "harrypotter");
        params.put("method", "search.tagMentions");
        String request = getRequestUrl(params);
        LOGGER.info("request  - | {} |", request);
        Response response = SerenityRest.get(request);
        LOGGER.info("response - | {} | {} |", response.statusCode(), response.body().asString());
        return response;
    }

    @Step
    public Response get_current_user() {
        String[] fields = new String[]{
                "ACCESSIBLE", "AGE", "ALLOWS_ANONYM_ACCESS", "ALLOWS_MESSAGING_ONLY_FOR_FRIENDS",
                "BECOME_VIP_ALLOWED", "BIRTHDAY", "BLOCKED", "BLOCKS", "CAN_VCALL", "CAN_VMAIL",
                "CITY_OF_BIRTH", "COMMON_FRIENDS_COUNT", "CURRENT_LOCATION", "CURRENT_STATUS",
                "CURRENT_STATUS_DATE", "CURRENT_STATUS_DATE_MS", "CURRENT_STATUS_ID", "CURRENT_STATUS_MOOD",
                "CURRENT_STATUS_TRACK_ID", "EMAIL", "FIRST_NAME", "FRIEND", "FRIEND_INVITATION",
                "FRIEND_INVITE_ALLOWED", "GENDER", "GROUP_INVITE_ALLOWED", "HAS_EMAIL", "HAS_PHONE",
                "HAS_SERVICE_INVISIBLE", "INTERNAL_PIC_ALLOW_EMPTY", "INVITED_BY_FRIEND", "IS_ACTIVATED",
                "LAST_NAME", "LAST_ONLINE", "LAST_ONLINE_MS", "LOCALE", "LOCATION", "LOCATION_OF_BIRTH",
                "MODIFIED_MS", "NAME", "ODKL_BLOCK_REASON", "ODKL_EMAIL", "ODKL_LOGIN", "ODKL_MOBILE",
                "ODKL_MOBILE_STATUS", "ODKL_USER_OPTIONS", "ODKL_USER_STATUS", "ODKL_VOTING", "ONLINE",
                "PHOTO_ID", "PIC1024X768", "PIC128MAX", "PIC128X128", "PIC180MIN", "PIC190X190", "PIC224X224",
                "PIC240MIN", "PIC288X288", "PIC320MIN", "PIC50X50", "PIC600X600", "PIC640X480", "PIC_1",
                "PIC_2", "PIC_3", "PIC_4", "PIC_5", "PIC_BASE", "PIC_FULL", "PIC_MAX", "PREMIUM", "PRESENTS",
                "PRIVATE", "PYMK_PIC224X224", "PYMK_PIC288X288", "PYMK_PIC600X600", "PYMK_PIC_FULL", "REF",
                "REGISTERED_DATE", "REGISTERED_DATE_MS", "RELATIONS", "RELATIONSHIP", "SEND_MESSAGE_ALLOWED",
                "SHOW_LOCK", "STATUS", "UID", "URL_CHAT", "URL_CHAT_MOBILE", "URL_PROFILE", "URL_PROFILE_MOBILE",
                "VIP"
        };
        Map<String, String> params = new HashMap<>();
        params.put("method", "users.getCurrentUser");
        params.put("fields", mergeElementsForUri(fields));
        String request = getRequestUrl(params);
        LOGGER.info("request  - | {} |", request);
        Response response = SerenityRest.get(request);
        LOGGER.info("response - | {} | {} |", response.statusCode(), response.body().asString());
        return response;
    }

    private String mergeElementsForUri(String... elements) {
        return mergeArray(",", elements);
    }

    private String mergeArray(String separator, String... strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i > 0) sb.append(separator);
            sb.append(strings[i]);
        }
        return sb.toString();
    }

    private String getRequestUrl(Map<String, String> params) {
        String baseUrl = _env.getProperty("api.base_url");
        String sessionSecretKey = "78465ba5b808a28f344d645c6160bb80";
        String accessToken = "tkn1YX95MI8gXZC4fjRUV1pfsRyR5ydwyuT3fspvrOefLoqfYWs2nNFeQQnyxUgxAACud";
        Map<String, String> sortedParams = new TreeMap<>(params);
        sortedParams.putIfAbsent("application_key", "CBAOIFDMEBABABABA");
        sortedParams.putIfAbsent("format", "json");
        StringBuilder sigSource = new StringBuilder();
        StringBuilder args = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedParams.entrySet()) {
            sigSource.append(entry.getKey()).append('=').append(entry.getValue());
            if (args.length() > 0) args.append('&');
            args.append(entry.getKey()).append('=').append(entry.getValue());
        }
        sigSource.append(sessionSecretKey);
        String sig = HashHelper.getMD5(sigSource.toString());
        String url = String.format(
                "%s?%s&sig=%s&access_token=%s",
                baseUrl, args, sig, accessToken
        );
        return url;
    }

}
