package ok.automation.features.message;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ok.automation.tech.extensions.BaseFeature;
import ok.automation.steps.GiftSteps;
import org.junit.Test;

public class MessageStory extends BaseFeature {

    @Steps
    private GiftSteps _gift;

    @Test @Pending
    public void send_message_to_friend() {
    }

    @Test @Pending
    public void edit_message() {
    }

    @Test @Pending
    public void delete_message() {
    }
} 