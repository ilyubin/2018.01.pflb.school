package ok.automation.features.post;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ok.automation.features.BaseFeatures;
import ok.automation.steps.PostSteps;
import org.junit.Test;

public class PostStory extends BaseFeatures {

    @Steps
    private PostSteps _post;

    @Test @Pending
    public void create_text_post() {
    }
} 