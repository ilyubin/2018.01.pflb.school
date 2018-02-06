package ok.automation.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import ok.automation.models.api.ApiRequest;
import ok.automation.models.api.errors.ErrorResponse;
import ok.automation.models.api.group.getCounters.GroupGetCountersRequest;
import ok.automation.models.api.group.getCounters.GroupGetCountersResponse;
import ok.automation.models.api.group.getInfo.GroupGetInfoRequest;
import ok.automation.models.api.group.getInfo.GroupGetInfoResponse;
import ok.automation.tech.extensions.HashHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiSteps {

    private static final Logger _log = LoggerFactory.getLogger(ApiSteps.class);
    private static final EnvironmentVariables _env = SystemEnvironmentVariables.createEnvironmentVariables();

    @Step
    public Response get_group_counters(GroupGetCountersRequest request) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParameter("group_id", request.groupId);
        apiRequest.addParameter("counterTypes", request.counterTypes);
        apiRequest.addParameter("method", "group.getCounters");
        Response response = apiRequest.send();
        assertThat(response.statusCode()).isEqualTo(200);
        return response;
    }

    @Step
    public GroupGetCountersResponse get_group_counters_ok(GroupGetCountersRequest request) {
        Response response = get_group_counters(request);
        GroupGetCountersResponse r = response.as(GroupGetCountersResponse.class);
        return r;
    }

    @Step
    public ErrorResponse get_group_counters_error(GroupGetCountersRequest request) {
        Response response = get_group_counters(request);
        ErrorResponse r = response.as(ErrorResponse.class);
        return r;
    }

    @Step
    public Response get_group_info(GroupGetInfoRequest request) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParameter("uids", request.uids);
        apiRequest.addParameter("move_to_top", request.move_to_top);
        apiRequest.addParameter("fields", request.fields);
        apiRequest.addParameter("method", "group.getInfo");
        Response response = apiRequest.send();
        assertThat(response.statusCode()).isEqualTo(200);
        return response;
    }

    @Step
    public GroupGetInfoResponse get_group_info_ok(GroupGetInfoRequest request) {
        Response response = get_group_info(request);
        GroupGetInfoResponse r = response.as(GroupGetInfoResponse.class);
        return r;
    }

    @Step
    public ErrorResponse get_group_info_error(GroupGetInfoRequest request) {
        Response response = get_group_info(request);
        ErrorResponse r = response.as(ErrorResponse.class);
        return r;
    }

    @Step
    public Response get_tag_mentions() {
        Map<String, String> params = new HashMap<>();
        params.put("query", "harrypotter");
        params.put("method", "search.tagMentions");
        params.put("filter", "{" +
                "\"since\":\"1990-05-30 00:00:00\"," +
                "\"types\":[\"USER_TOPIC\", \"USER_PHOTO\", \"USER_VIDEO\", \"GROUP_TOPIC\", \"GROUP_PHOTO\", \"GROUP_VIDEO\"]," +
                "\"until\":\"2017-05-30 00:00:00\"" +
                "}");
        Response response = sendGetRequest(params);
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
        Response response = sendGetRequest(params);
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

        String format = "json";
        String sessionSecretKey = System.getProperty("apiSessionSecretKey");
        String accessToken = System.getProperty("apiAccessToken");
        String applicationKey = System.getProperty("apiApplicationKey");

        Map<String, String> sortedParams = new TreeMap<>(params);
        sortedParams.putIfAbsent("application_key", applicationKey);
        sortedParams.putIfAbsent("format", format);
        StringBuilder sigSource = new StringBuilder();
        StringBuilder args = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedParams.entrySet()) {
            sigSource.append(entry.getKey()).append('=').append(entry.getValue());
            if (args.length() > 0)
                args.append('&');
            args.append(entry.getKey()).append('=').append(entry.getValue());
        }
        sigSource.append(sessionSecretKey);
        String sig = HashHelper.getMD5(sigSource.toString());
        String url = String.format("%s?%s&sig=%s&access_token=%s", baseUrl, args, sig, accessToken);
        return url;
    }

    private Response sendGetRequest(Map<String, String> params) {
        String request = getRequestUrl(params);
        _log.info("request  - | {} |", request);
        Response response = SerenityRest.get(request);
        _log.info("response - | {} | {} |", response.statusCode(), response.body().asString());
        return response;
    }

}
