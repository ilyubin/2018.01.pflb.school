package ok.automation.features.ui;

import net.thucydides.core.annotations.Steps;
import ok.automation.tech.extensions.BaseFeature;
import ok.automation.steps.PostSteps;
import ok.automation.steps.UserSteps;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostStory extends BaseFeature {

    @Steps
    private PostSteps _post;

    @Steps
    private UserSteps _user;

    @Before
    public void open_login_page() {
        _post.open_page();
    }

    @Test
    public void create_text_post() {
        String text = fake.lorem().sentence();
        _post.create_text_post(text);
        assertThat(_post.last()).isEqualTo(text);
    }
}
