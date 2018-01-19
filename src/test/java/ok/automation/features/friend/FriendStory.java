package ok.automation.features.friend;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ok.automation.steps.UserSteps;
import ok.automation.tech.extensions.BaseFeature;
import ok.automation.steps.FriendSteps;
import org.junit.BeforeClass;
import org.junit.Test;

public class FriendStory extends BaseFeature {

    @Steps
    private FriendSteps _friend;

    @Steps
    private UserSteps _user;

    @BeforeClass
    public void beforeClass(){
        _user.loginToOkRu(okLogin, okPass);
    }

    @Test
    public void open_friend_page(){
        _friend.openFriendPage();
    }

    @Test @Pending
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
    }

    @Test @Pending
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
    }

    @Test @Pending
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
} 