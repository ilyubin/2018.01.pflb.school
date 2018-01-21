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
        if (friendPage.usersFoundResultNotEmpty() && friendPage.canAddAnyUserToFriends()) {
            return friendPage.addFirstFoundUserToFriendsAndGetId();
        }
        return null;
    }

    @Step
    public void open_out_requests_page() {
        friendPage.openFriendOutRequestsPage();
    }

    @Step
    public String get_user_name_in_friends_out_requests_by_id(String userId) {
        if (friendPage.usersOutRequestsNotEmpty() && friendPage.hasUserInOutRequestListWithId(userId)) {
            return friendPage.getUserNameInFriendsOutRequestById(userId);
        }
        return null;
    }
}