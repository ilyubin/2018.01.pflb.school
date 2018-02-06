package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.HeaderToolbar;
import ok.automation.pages.MainPage;
import ok.automation.pages.MessagesPage;
import ok.automation.tech.interfaces.ISteps;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class MessageSteps implements ISteps {

    MainPage mainPage;
    HeaderToolbar headerToolbar;
    MessagesPage messagesPage;

    @Step
    public void open_page() {
        mainPage.open();
        headerToolbar.openMessages();
    }

    @Step
    public void create_message(String friend, String text) {
        findFriend(friend);
        send_message(text);
    }

    @Step
    private void send_message(String text) {
        messagesPage.typeMessage(text);
        messagesPage.submitMessage();
    }

    @Step
    private void findFriend(String friend) {
        messagesPage.findFriend(friend);
    }

    @Step
    public void changeMessage(String friend,String message) {
        findFriend(friend);
        messagesPage.changeMessage(message);
    }

    @Step
    public String readMessage() {
        return messagesPage.readMessage();
    }
}