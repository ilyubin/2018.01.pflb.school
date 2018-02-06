package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class MessagesPage extends PageObject {


    public void submitMessage() {
        find(By.cssSelector("[title=\"Отправить\"]")).click();
    }

    public void typeMessage(String text) {
        find(By.cssSelector("[data-check-attach-on-submit=\"true\"] [contenteditable]")).type(text);
    }

    public void findFriend(String friend){
        find(By.cssSelector("[maxlength=\"50\"]")).type(friend);
        find(By.cssSelector(".chats_i_ovr")).click();
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