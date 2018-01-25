package ok.automation.features.gift;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import ok.automation.steps.FriendSteps;
import ok.automation.steps.UserSteps;
import ok.automation.tech.extensions.BaseFeature;
import ok.automation.steps.GiftSteps;
import ok.automation.steps.TopContentRowSteps;
import org.junit.Before;
import org.junit.Test;

public class GiftStory extends BaseFeature {

    @Steps
    private GiftSteps _gift;

    @Steps
    private UserSteps _user;

    @Steps
    private TopContentRowSteps _row;

    @Steps
    private FriendSteps _friend;

    @Before
    public void open_login_page() {
        _user.open_login_page();
        _user.loginToOkRu(okLogin, okPass);
        _gift.open_page();
    }

    @Test
    public void search_gift() {
        _gift.look_for_gift("День рождения");
    }

    @Test
    public void try_to_send_gift() {
          _gift.select_gift();
          _gift.select_friend();
          _gift.send();
    }

    @Test
    public void try_to_create_own_gift() {
        _gift.create_own_gift();
        _gift.create_text_gift();
        //_gift.input_text("Поздравляю");
        _gift.select_font_style();
        _gift.select_orange_fontColor();
        _gift.complete_gift_creation();

    }
} 