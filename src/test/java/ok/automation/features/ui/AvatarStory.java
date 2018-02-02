package ok.automation.features.ui;

import net.thucydides.core.annotations.Steps;
import ok.automation.tech.extensions.BaseFeatureUi;
import ok.automation.steps.AvatarSteps;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class AvatarStory extends BaseFeatureUi {

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

    @Test
    public void add_comment() {
        String text = String.format("Comment-%s", UUID.randomUUID());
        _avatar.create_text_comment(text);
        assertThat(_avatar.comment()).isEqualTo(text);
    }

    @Test
    public void edit_photo_without_changes() {
        String url = _avatar.photoUrl();
        _avatar.edit_photo();
        assertThat(_avatar.photoUrl()).isEqualTo(url);
    }
} 