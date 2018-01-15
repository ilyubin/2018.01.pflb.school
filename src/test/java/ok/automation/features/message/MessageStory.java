package ok.automation.features.message;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ok.automation.features.BaseFeatures;
import ok.automation.steps.AvatarSteps;
import ok.automation.steps.GiftSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

public class MessageStory extends BaseFeatures {

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