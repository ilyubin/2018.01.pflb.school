package ok.automation.features.avatar;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ok.automation.steps.UserSteps;
import ok.automation.tech.extensions.BaseFeature;
import ok.automation.steps.AvatarSteps;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AvatarStory extends BaseFeature {

    @Steps
    private AvatarSteps _avatar;

    @Before
    public void open_login_page() {
        _avatar.open_page();
    }

    @Test
    public void add_a_description() {
        String text = fake.lorem().sentence();
        _avatar.create_text_description(text);
        assertThat(_avatar.avatarDescription()).isEqualTo(text);
    }

    @Test @Pending
    public void add_comment() {
    }

    @Test @Pending
    public void edit_photo_without_changes() {
    }
} 