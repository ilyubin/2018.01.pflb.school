package ok.automation.features.api;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

public class UsersGetCallsLeftStory {
    @Test
    public void get_call_left() {
        Response response = SerenityRest.get("https://api.ok.ru/fb.do" +
            "?application_key=CBAEHQDMEBABABABA" +
            "&format=json" +
            "&method=users.getCallsLeft" +
            "&methods=users.getCallsLeft" +
            "&sig=ae829b9b24c8a71e18890dc3c58b4a6d" +
            "&access_token=tkn1gbUo3a4XnEusQuPL7gIiIvYvzg6xtLJV0sPChsOx08jYUT5pshTUQs6pfQyTGVK4e");
        System.out.println(response.statusCode());
    }
}
