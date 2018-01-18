package ok.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

//@DefaultUrl("https://ok.ru")
public class FriendPage extends PageObject {

    @FindBy(css="#hook_Block_HeaderTopFriendsInToolbar a")
    private WebElementFacade friendsHeaderButton;

    @FindBy(css=".nav-side a[hrefattrs*=OnlineFriends]")
    private WebElementFacade friendsOnlineButton;

    @FindBy(css="[data-l*=\"BY_NAME\"]")
    private WebElementFacade searchByFirstAndLastNameButton;

    @FindBy(css="[data-l*=\"COLLEAGUES\"]")
    private WebElementFacade findColleaguesButton;

    @FindBy(css="[data-l*=\"SCHOOL_FRIENDS\"]")
    private WebElementFacade findSchoolOrUniversityFriendsButton;

    @FindBy(css="#hook_Block_MyFriendsNewPageMRB a[data-l*=sendMessage][hrefattrs*=\"585960467204\"]")
    private WebElementFacade writeFriendButton;
    
}