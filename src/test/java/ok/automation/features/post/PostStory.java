package ok.automation.features.post;

import net.thucydides.core.annotations.Steps;
import ok.automation.features.BaseFeatures;
import ok.automation.steps.PostSteps;
import ok.automation.steps.UserSteps;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostStory extends BaseFeatures {

    @Steps
    private PostSteps _post;

    @Steps
    private UserSteps _user;

    @Before
    public void open_login_page() {
        _user.open_login_page();
    }

    @Test
    public void create_text_post() {
        String text = fake.lorem().sentence();
        _post.create_text_post(text);
        assertThat(_post.last()).isEqualTo(text);
    }
} 