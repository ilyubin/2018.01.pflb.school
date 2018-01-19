package ok.automation.features.gift;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ok.automation.tech.extensions.BaseFeature;
import ok.automation.steps.GiftSteps;
import org.junit.Test;

public class GiftStory extends BaseFeature {

    @Steps
    private GiftSteps _gift;

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