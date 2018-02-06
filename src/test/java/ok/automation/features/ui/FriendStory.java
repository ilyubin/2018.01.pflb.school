package ok.automation.features.ui;

import net.thucydides.core.annotations.Steps;
import ok.automation.models.ui.User;
import ok.automation.steps.FriendSteps;
import ok.automation.tech.extensions.BaseFeatureUi;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FriendStory extends BaseFeatureUi {

    @Steps
    private FriendSteps _friend;

    @Before
    public void open_friend_page() {
        _friend.open_page();
    }

    @Test
    public void search_friend() {
        User friend = _friend.get_first_friend_with_name();
        _friend.search_for(friend);
        assertThat(_friend.get_found_friends_names()).allMatch(name -> name.contains(friend.fullName));
    }

    @Test
    public void send_friend_request_to_user() {
        String name = "ив";
        User user = _friend.get_non_friend_user_by_name(name);
        _friend.add_user_to_friends(user);
        assertThat(_friend.get_user_name_in_outgoing_requests_by_id(user.id))
                .containsIgnoringCase(name)
                .containsIgnoringCase(user.fullName);
    }

    @Test
    public void accept_friend_request() {
        User user = _friend.get_first_user_in_ingoing_requests();
        _friend.accept_user_ingoing_request(user);
        _friend.search_for(user);
        assertThat(user.fullName).isEqualTo(_friend.get_found_friend_name_by_id(user.id));
    }
} 