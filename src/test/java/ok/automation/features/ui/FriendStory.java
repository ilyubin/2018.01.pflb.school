package ok.automation.features.ui;

import net.thucydides.core.annotations.Steps;
import ok.automation.steps.FriendSteps;
import ok.automation.steps.UserSteps;
import ok.automation.tech.extensions.BaseFeature;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FriendStory extends BaseFeature {

    @Steps
    private FriendSteps _friend;

    @Steps
    private UserSteps _user;

    @Before
    public void open_friend_page() {
        _friend.open_page();
    }

    @Test
    public void search_friend() {
        String friendName = _friend.get_last_friend_name();
        _friend.search_for(friendName);
//        _friend.get_found_friends_names().forEach(name -> assertThat(name).contains(friendName));
        assertThat(_friend.get_found_friends_names()).allMatch(name -> name.contains(friendName));
    }

    @Test
    public void send_request_to_friend() {
        String request = "Harry Potter";
        _friend.search_for(request);
        String userId = _friend.add_first_found_user_to_friends_and_get_id();
        _friend.open_outgoing_requests_page();
        assertThat(request).isEqualToIgnoringCase(_friend.get_user_name_in_friends_out_requests_by_id(userId));
    }

    @Test
    public void accept_friend_request() {
        _friend.open_in_requests_page();
        String userId = _friend.get_first_user_id_in_ingoing_requests();
        String userName = _friend.get_first_user_name_in_ingoing_requests();
        _friend.accept_ingoing_request_with_user_id(userId);
        _friend.open_page();
        _friend.search_for(userName);
        assertThat(userName).isEqualTo(_friend.get_found_friend_name_by_id(userId));
    }
} 