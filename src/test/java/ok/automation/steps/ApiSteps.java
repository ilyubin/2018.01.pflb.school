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
