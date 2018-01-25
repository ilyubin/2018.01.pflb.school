package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

public class AvatarPage extends PageObject{

    @FindBy(css="#plp_descrChgLnk")
//    @FindBy(css="#plp_descrAddLnk") // TODO fix for first time add description
    private WebElementFacade buttonAddDescription;

    public void clickAddDescription() {
        buttonAddDescription.click();
    }

    @FindBy(css="[data-too-long-msg]")
    private WebElementFacade fieldDescription;

    public void fillDescription(String text) {
        fieldDescription.type(text);
    }

    @FindBy(css="[name=\"plp_descrInpBtn\"]")
    private WebElementFacade buttonSaveDescription;

    public void clickSaveDescription() {
        buttonSaveDescription.click();
    }

    @FindBy(css="#plp_descrCntText")
    private WebElementFacade avatarDescription;

    public String getAvatarDescription() {
        return avatarDescription.getText();
    }
}