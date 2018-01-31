package ok.automation.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import ok.automation.tech.extensions.Md5Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApiSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger("|");

    private EnvironmentVariables _env = SystemEnvironmentVariables.createEnvironmentVariables();

    @Step
    public Response get_group_counters() {
        String baseUrl = _env.getProperty("api.baseUrl");
        String applicationKey = "CBAOIFDMEBABABABA";
        String counterTypes = "themes";
        String groupId = "54635655856155";
        String sessionSecretKey = "78465ba5b808a28f344d645c6160bb80";
        String sig = getSigForGroupGetCounters(applicationKey,counterTypes, groupId, sessionSecretKey);//"e0fbaa256aa62c3f5b760c24daadc6a2";
        String request = baseUrl +
                "?application_key=" +
                applicationKey +
                "&counterTypes=" + counterTypes +
                "&format=json" +
                "&group_id=" + groupId +
                "&method=group.getCounters" +
                "&sig=" + sig +
                "&access_token=tkn1YX95MI8gXZC4fjRUV1pfsRyR5ydwyuT3fspvrOefLoqfYWs2nNFeQQnyxUgxAACud";
        LOGGER.info("request  - | {} |", request);
        Response response = SerenityRest.get(request);
        LOGGER.info("response - | {} | {} |", response.statusCode(), response.body().asString());
        return response;
    }

    private String getSigForGroupGetCounters(
            String applicationKey, String counterTypes, String groupId, String sessionSecretKey
    ) {
    String text = String.format(
                "application_key=%scounterTypes=%sformat=jsongroup_id=%smethod=group.getCounters%s",
                applicationKey, counterTypes, groupId, sessionSecretKey
        );
    return Md5Helper.getMD5Hash(text);}

}
