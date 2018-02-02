package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.friend.FriendIngoingRequestsPage;
import ok.automation.pages.friend.FriendOutgoingRequestsPage;
import ok.automation.pages.friend.FriendPage;
import ok.automation.pages.friend.FriendSearchPage;
import ok.automation.tech.interfaces.ISteps;

import java.util.ArrayList;
import java.util.List;

public class FriendSteps implements ISteps {

    FriendPage friendPage;
    FriendSearchPage friendSearch;
    FriendOutgoingRequestsPage outgoingRequests;
    FriendIngoingRequestsPage ingoingRequests;

    @Step
    public void open_page() {
        friendPage.openPage();
    }

    /* Главная страница */

    @Step
    public String get_first_friend_name() {
        return friendPage.getFirstFriendName();
    }

    @Step
    public String get_last_friend_name() {
        return friendPage.getLastFriendName();
    }

    /* Поиск среди друзей по имени */

    @Step
    public void search_for(String searchRequest) {
        friendSearch.searchFor(searchRequest);
    }

    @Step
    public List<String> get_found_friends_names() {
        int foundFriendsAmount = friendSearch.getFriendsOnPageAmount();
        List<String> friendsNames = new ArrayList<>(foundFriendsAmount);
        for (int i = 0; i < foundFriendsAmount; i++) {
            friendsNames.add(friendSearch.getFriendNameOnPageByIndex(i));
        }
        return friendsNames;
    }

    @Step
    public String add_first_found_user_to_friends_and_get_id() {
        if (friendSearch.hasUsers() && friendSearch.canAddAnyUserToFriends()) {
            return friendSearch.addFirstUserAndGetId();
        }
        return null;
    }

    @Step
    public String get_found_friend_name_by_id(String userId) {
        return friendSearch.getFriendNameOnPageById(userId);
    }

    /* Исходящие заявки OutRequests */

    @Step
    public void open_outgoing_requests_page() {
        friendPage.openOutgoingRequestsPage();
    }

    @Step
    public String get_user_name_in_friends_out_requests_by_id(String userId) {
        if (outgoingRequests.hasUsers() && outgoingRequests.hasUserWithId(userId)) {
            return outgoingRequests.getUserNameById(userId);
        }
        return null;
    }

    /* Исходящие заявки InRequests*/

    @Step
    public void open_in_requests_page() {
        friendPage.openIngoingRequestsPage();
    }

    @Step
    public String get_first_user_name_in_ingoing_requests() {
        if (ingoingRequests.hasUsers()) {
            return ingoingRequests.getFirstUserName();
        }
        return null;
    }

    @Step
    public String get_first_user_id_in_ingoing_requests() {
        if (ingoingRequests.hasUsers()) {
            return ingoingRequests.getFirstUserId();
        }
        return null;
    }

    @Step
    public void accept_ingoing_request_with_user_id(String userId) {
        ingoingRequests.acceptUserWithId(userId);
    }

}