package ok.automation.features.ui;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ok.automation.steps.MessageSteps;
import ok.automation.tech.extensions.BaseFeatureUi;
import ok.automation.steps.GiftSteps;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageStory extends BaseFeatureUi {

    @Steps
    private MessageSteps _message;

    @Before
    public void open_messages_page() {
        _message.open_page();
    }

    @Test
    public void send_message_to_friend() {
        String friend = "John McClain";
        String text = fake.lorem().sentence(7);
        _message.create_message(friend, text);
    }

    @Test
    public void edit_message() {
        String friend = "John McClain";
        String message=fake.lorem().sentence(7);
        _message.changeMessage(friend,message);
        assertThat(_message.readMessage()).isEqualTo(message);
    }

    @Test @Pending
    public void delete_message() {
    }
} 