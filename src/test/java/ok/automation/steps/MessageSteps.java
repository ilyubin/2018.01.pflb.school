package ok.automation.steps;

import net.thucydides.core.annotations.Step;
import ok.automation.pages.HeaderToolbar;
import ok.automation.pages.MainPage;
import ok.automation.pages.MessagesPage;
import ok.automation.tech.interfaces.ISteps;

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
        messagesPage.findFriend(friend);
        messagesPage.typeMessage(text);
        messagesPage.submitMessage();
    }

    @Step
    public String get_last_message() {
        return messagesPage.getLastMessage();
    }

    @Step
    public void changeMessage(String friend,String message) {
        messagesPage.findFriend(friend);
        messagesPage.changeMessage(message);
    }

    @Step
    public String readMessage() {
        return messagesPage.readMessage();
    }
}