package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MessagesPage extends PageObject {


    public void submitMessage() {
        find(By.cssSelector(".chat_write button")).click();
    }

    public void typeMessage(String text) {
        find(By.cssSelector("[id^=field_txt]")).type(text);
    }

    public void findFriend(String friend){
        find(By.id("ConversationsListSearch_field_query")).type(friend);
        find(By.xpath(String.format("//div[contains(text(), '%s')]/ancestor::div[@tsid]/a", friend))).click();
    }

    public String getLastMessage() {
        return find(By.cssSelector(".js-messages-list .msg:last-of-type .msg_tx_cnt")).getText();
    }

    public void changeMessage(String message) {
        find(By.xpath("//div[@id='hook_Block_ConversationContent']//div[@class='js-messages-list']/div/div[10]/div//div[@class='msg_tx_cnt']/span[@class='js-copy-text']/span")).click();
        find(By.xpath("//div[@id='hook_Block_ConversationContent']//div[@class='js-messages-list']/div/div[10]/div//a[@title='Отредактировать сообщение']")).click();
        find(By.cssSelector("[data-check-attach-on-submit=\"true\"] [contenteditable]")).type(message);
        find(By.cssSelector("[title=\"Отправить\"]")).click();
    }

    public String readMessage() {
        return find(By.xpath("//div[@id='hook_Block_ConversationContent']//div[@class='js-messages-list']/div/div[10]/div//div[@class='msg_tx_cnt']/span[@class='js-copy-text']/span")).getText();
    }
}