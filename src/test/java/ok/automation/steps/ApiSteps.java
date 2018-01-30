package ok.automation.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiSteps {

    protected static final Logger LOGGER = LoggerFactory.getLogger("|");
    private EnvironmentVariables _env =
            SystemEnvironmentVariables.createEnvironmentVariables();

    @Step
    public Response get_group_counters(){
        String baseUrl = _env.getProperty("api.base_url");
        String request = baseUrl +
                "?application_key=CBAOIFDMEBABABABA" +
                "&counterTypes=themes" +
                "&format=json" +
                "&group_id=54635655856155" +
                "&method=group.getCounters" +
                "&sig=e0fbaa256aa62c3f5b760c24daadc6a2" +
                "&access_token=tkn1YX95MI8gXZC4fjRUV1pfsRyR5ydwyuT3fspvrOefLoqfYWs2nNFeQQnyxUgxAACud";
        LOGGER.info("request  - | {} |", request);
        Response response = SerenityRest.get(request);
        LOGGER.info("response - | {} | {} |", response.statusCode(), response.body().asString());
        return response;
    }

}
