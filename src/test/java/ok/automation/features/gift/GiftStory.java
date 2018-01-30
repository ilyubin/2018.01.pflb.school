package ok.automation.features.gift;

import net.thucydides.core.annotations.Steps;
import ok.automation.tech.extensions.BaseFeature;
import ok.automation.steps.GiftSteps;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftStory extends BaseFeature {

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
          assertThat(_gift.getButtonName()).isEqualTo("Получить код");// проверяем кнопку "получить код", тк нет возможности двигаться дальше
    }

    @Test
    public void try_to_create_own_gift() {
        _gift.create_own_gift();
        _gift.create_text_gift();
        //_gift.input_text("Поздравляю");
        _gift.select_font_style();
        _gift.select_orange_fontColor();
        _gift.complete_gift_creation();
        assertThat(_gift.getCongats()).isEqualTo("Отличная работа! Вы только что сделали подарок своими руками!");
    }
} 