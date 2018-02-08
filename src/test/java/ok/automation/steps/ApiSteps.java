package ok.automation.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import ok.automation.tech.helpers.ApiRequest;
import ok.automation.models.api.errors.ErrorResponse;
import ok.automation.models.api.group.getCounters.GroupGetCountersRequest;
import ok.automation.models.api.group.getCounters.GroupGetCountersResponse;
import ok.automation.models.api.group.getInfo.GroupGetInfoRequest;
import ok.automation.models.api.group.getInfo.GroupGetInfoResponse;
import ok.automation.models.api.search.tagMentions.SearchTagMentionsRequest;
import ok.automation.models.api.search.tagMentions.SearchTagMentionsResponse;
import ok.automation.models.api.users.getCurrentUser.UsersGetCurrentUserRequest;
import ok.automation.models.api.users.getCurrentUser.UsersGetCurrentUserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiSteps {

    private static final Logger _log = LoggerFactory.getLogger(ApiSteps.class);

    @Step
    public Response get_group_counters(GroupGetCountersRequest request) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParameter("group_id", request.groupId);
        apiRequest.addParameter("counterTypes", request.counterTypes);
        apiRequest.addParameter("method", request.method);
        Response response = apiRequest.send();
        assertThat(response.statusCode()).isEqualTo(200);
        return response;
    }

    @Step
    public GroupGetCountersResponse get_group_counters_ok(GroupGetCountersRequest request) {
        return get_group_counters(request).as(GroupGetCountersResponse.class);
    }

    @Step
    public ErrorResponse get_group_counters_error(GroupGetCountersRequest request) {
        return get_group_counters(request).as(ErrorResponse.class);
    }

    @Step
    public Response get_group_info(GroupGetInfoRequest request) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParameter("uids", request.uids);
        apiRequest.addParameter("move_to_top", request.move_to_top);
        apiRequest.addParameter("fields", request.fields);
        apiRequest.addParameter("method", request.method);
        Response response = apiRequest.send();
        assertThat(response.statusCode()).isEqualTo(200);
        return response;
    }

    @Step
    public GroupGetInfoResponse[] get_group_info_ok(GroupGetInfoRequest request) {
        return get_group_info(request).as(GroupGetInfoResponse[].class);
    }

    @Step
    public ErrorResponse get_group_info_error(GroupGetInfoRequest request) {
        return get_group_info(request).as(ErrorResponse.class);
    }

    @Step
    public Response get_tag_mentions(SearchTagMentionsRequest request) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParameter("query", request.query);
        apiRequest.addParameter("method", request.method);
        apiRequest.addParameter("filter", request.filter);
        Response response = apiRequest.send();
        assertThat(response.statusCode()).isEqualTo(200);
        return response;
    }

    @Step
    public SearchTagMentionsResponse get_tag_mentions_ok(SearchTagMentionsRequest request) {
        return get_tag_mentions(request).as(SearchTagMentionsResponse.class);
    }

    @Step
    public ErrorResponse get_tag_mentions_error(SearchTagMentionsRequest request) {
        return get_tag_mentions(request).as(ErrorResponse.class);
    }

    @Step
    public Response get_current_user(UsersGetCurrentUserRequest request) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParameter("method", request.method);
        apiRequest.addParameter("fields", request.fields);
        Response response = apiRequest.send();
        assertThat(response.statusCode()).isEqualTo(200);
        return response;
    }

    @Step
    public UsersGetCurrentUserResponse get_current_user_ok(UsersGetCurrentUserRequest request) {
        return get_current_user(request).as(UsersGetCurrentUserResponse.class);
    }

    @Step
    public ErrorResponse get_current_user_error(UsersGetCurrentUserRequest request) {
        return get_current_user(request).as(ErrorResponse.class);
    }


}
