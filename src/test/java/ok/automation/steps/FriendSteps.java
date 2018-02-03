package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.models.ui.User;
import ok.automation.pages.SearchPage;
import ok.automation.pages.friend.FriendIngoingRequestsPage;
import ok.automation.pages.friend.FriendOutgoingRequestsPage;
import ok.automation.pages.friend.FriendPage;
import ok.automation.pages.friend.FriendSearchPage;
import ok.automation.tech.interfaces.ISteps;

import java.util.ArrayList;
import java.util.List;

public class FriendSteps implements ISteps {

    SearchPage searchPage;
    FriendPage friendPage;
    FriendSearchPage friendSearch;
    FriendOutgoingRequestsPage outgoingRequests;
    FriendIngoingRequestsPage ingoingRequests;

    @Step
    public void open_page() {
        friendPage.openPage();
    }

    @Step
    public void search_for(String searchRequest) {
        friendPage.openPage();
        friendSearch.searchFor(searchRequest);
    }

    @Step
    public void search_for(User friend) {
        if(friend.fullName.isEmpty()){
            friendPage.openPage();
            friendPage.switchLetterFilter("#");
        }else {
            search_for(friend.fullName);
        }
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
    public User get_first_friend_with_name() {
        User friend = new User();
        friend.fullName = friendPage.getFirstFriendWithNameName();
        friend.id = friendPage.getFirstFriendWithNameUserId();
        return friend;
    }

    @Step
    public User get_non_friend_user_by_name(String name) {
        searchPage.open();
        searchPage.searchFor(name);
        User user = new User();
        user.fullName = searchPage.getFirstNonFriendUserName();
        user.id = searchPage.getFirstNonFriendUserId();
        return user;
    }

    @Step
    public void add_user_to_friends(User user) {
        friendPage.addUserToFriendsById(user.id);
    }

    @Step
    public String get_user_name_in_outgoing_requests_by_id(String userId) {
        friendPage.openPage();
        outgoingRequests.openPage();
        if (outgoingRequests.hasUserWithId(userId)) {
            return outgoingRequests.getUserNameById(userId);
        }
        return null;
    }

    @Step
    public User get_first_user_in_ingoing_requests() {
        friendPage.openPage();
        ingoingRequests.openPage();
        User user = new User();
        user.id = ingoingRequests.getFirstUserId();
        user.fullName = ingoingRequests.getFirstUserName();
        return user;
    }

    @Step
    public void accept_user_ingoing_request(User user) {
        ingoingRequests.acceptUserWithId(user.id);
    }

    @Step
    public String get_found_friend_name_by_id(String userId) {
        return friendSearch.getFriendNameOnPageById(userId);
    }


}