package ok.automation.features.ui;

import net.thucydides.core.annotations.Steps;
import ok.automation.models.ui.GiftCustomStyles;
import ok.automation.tech.extensions.BaseFeatureUi;
import ok.automation.steps.GiftSteps;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftStory extends BaseFeatureUi {

    @Steps
    private GiftSteps _gift;

    @Before
    public void open_login_page() {
        _gift.open_page();
    }

    @Test
    public void search_gift() {
        String textSearch = "gift";
        _gift.search_gift(textSearch);
        assertThat(_gift.check_result_search_gift()).isEqualTo(true);
    }

    @Test
    public void try_to_send_gift() {
          _gift.select_gift();
          _gift.select_friend();
          _gift.send();
          assertThat(_gift.getButtonName()).isEqualTo("Get code");// проверяем кнопку "получить код", тк нет возможности двигаться дальше
    }

    @Test
    public void try_to_create_own_gift() {
        _gift.create_own_gift();
        _gift.create_text_gift();
        _gift.select_font_style();
        _gift.input_text("Поздравляю");
        _gift.select_font_color(GiftCustomStyles.colors.get(GiftCustomStyles.COLORS.BLACK));
        _gift.complete_gift_creation();
        assertThat(_gift.getCongats()).isEqualTo("Well done! You've just created your own custom gift!");
    }
} 