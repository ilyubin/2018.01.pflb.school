package ok.automation.steps;

import ok.automation.pages.AvatarPage;
import ok.automation.pages.MainPage;
import net.thucydides.core.annotations.Step;
import ok.automation.tech.extensions.ISteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class AvatarSteps implements ISteps {

    MainPage mainPage;
    AvatarPage avatarPage;

    @Step
    public void open_page() {
        mainPage.open();
    }

    @Step
    public void create_text_description(String text) {
        mainPage.clickAvatar();
        avatarPage.clickAddDescription();
        avatarPage.fillDescription(text);
        avatarPage.clickSaveDescription();
    }

    @Step
    public String avatarDescription() {
        String post = avatarPage.getAvatarDescription();
        return post;
    }

    @Step
    public void create_text_comment(String text) {
        mainPage.clickAvatar();
        avatarPage.fillComment(text);
        avatarPage.clickAddComment();
    }

    @Step
    public String avatarComment() {
        String post = avatarPage.getAvatarComment();
        return post;
    }

    @Step
    public void edit_photo() {
        mainPage.hoverToAvatar();
        mainPage.clickEditAvatar();
        avatarPage.clickOkEditAvatar();
    }
}