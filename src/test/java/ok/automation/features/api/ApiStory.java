package ok.automation.features.api;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

public class ApiStory {

    @Test
    public void get_group_counters() {
        Response response = SerenityRest.get("https://api.ok.ru/fb.do" +
                "?application_key=CBAOIFDMEBABABABA" +
                "&counterTypes=themes" +
                "&format=json" +
                "&group_id=54635655856155" +
                "&method=group.getCounters" +
                "&sig=e0fbaa256aa62c3f5b760c24daadc6a2" +
                "&access_token=tkn1YX95MI8gXZC4fjRUV1pfsRyR5ydwyuT3fspvrOefLoqfYWs2nNFeQQnyxUgxAACud");
        System.out.println("statusCode = " + response.statusCode());
        response.body().prettyPrint();
    }
}
