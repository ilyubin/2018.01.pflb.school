package ok.automation.features.friend;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ok.automation.steps.FriendSteps;
import ok.automation.steps.UserSteps;
import ok.automation.tech.extensions.BaseFeature;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FriendStory extends BaseFeature {

    private boolean loggedIn = false;

    @Steps
    private FriendSteps _friend;

    @Steps
    private UserSteps _user;

    @Before
    public void open_friend_page() {
        if (!loggedIn) {
            _user.open_login_page();
            _user.loginToOkRu(okLogin, okPass);
            loggedIn = true;
        }
        _friend.open_page();
    }

    @Test
    public void search_friend() {
        String request = "Sherlock";
        _friend.search_for(request);
        _friend.get_found_friends_names().forEach(name -> assertThat(name).contains(request));
    }

    @Test
    public void send_request_to_friend() {
        String request = "Harry Potter";
        _friend.search_for(request);
        String userId = _friend.add_first_found_user_to_friends_and_get_id();
        _friend.open_out_requests_page();
        assertThat(request).isEqualToIgnoringCase(_friend.get_user_name_in_friends_out_requests_by_id(userId));
    }

    @Test
    @Pending
    public void accept_friend_request() {
        
    }
} 