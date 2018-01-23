package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.FriendPage;
import ok.automation.tech.extensions.ISteps;

import java.util.ArrayList;
import java.util.List;

public class FriendSteps implements ISteps {

    FriendPage friendPage;

    @Step
    public void open_page() {
        friendPage.openFriendPage();
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
        friendPage.searchFor(searchRequest);
    }

    @Step
    public List<String> get_found_friends_names() {
        int foundFriendsAmount = friendPage.getFoundFriendsOnPageAmount();
        List<String> friendsNames = new ArrayList<>(foundFriendsAmount);
        for (int i = 0; i < foundFriendsAmount; i++) {
            friendsNames.add(friendPage.getFoundFriendNameOnPageByIndex(i));
        }
        return friendsNames;
    }

    @Step
    public String add_first_found_user_to_friends_and_get_id() {
        if (friendPage.hasUsersInFoundResult() && friendPage.canAddAnyFoundUserToFriends()) {
            return friendPage.addFirstFoundUserToFriendsAndGetId();
        }
        return null;
    }

    @Step
    public String get_found_friend_name_by_id(String userId) {
        return friendPage.getFoundFriendNameOnPageById(userId);
    }

    /* Исходящие заявки OutRequests */

    @Step
    public void open_out_requests_page() {
        friendPage.openFriendOutRequestsPage();
    }

    @Step
    public String get_user_name_in_friends_out_requests_by_id(String userId) {
        if (friendPage.hasUsersOutRequests() && friendPage.isUserWithIdInOutRequests(userId)) {
            return friendPage.getUserNameByIdInOutRequests(userId);
        }
        return null;
    }

    /* Исходящие заявки InRequests*/

    @Step
    public void open_in_requests_page() {
        friendPage.openFriendInRequestsPage();
    }

    @Step
    public String get_first_user_name_in_in_requests() {
        if (friendPage.hasUsersInRequests()) {
            return friendPage.getFirstUserNameInInRequests();
        }
        return null;
    }

    @Step
    public String get_first_user_id_in_in_requests() {
        if (friendPage.hasUsersInRequests()) {
            return friendPage.getFirstUserIdInInRequests();
        }
        return null;
    }

    @Step
    public void accept_in_request_with_user_id(String userId) {
        friendPage.acceptUserWithIdInRequest(userId);
    }

}