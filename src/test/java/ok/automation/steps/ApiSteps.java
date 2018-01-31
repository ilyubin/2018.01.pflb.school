package ok.automation.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import ok.automation.tech.extensions.Md5Helper;
import org.omg.CORBA.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger("|");

    private EnvironmentVariables _env = SystemEnvironmentVariables.createEnvironmentVariables();

    @Step
    public Response get_group_counters(String groupId, String counterTypes){
        String baseUrl = _env.getProperty("api.base_url");
        String application_key = "CBAOIFDMEBABABABA";

        String format = "json";

        String method = "group.getCounters";
        String sessionSecretKey = "78465ba5b808a28f344d645c6160bb80";
        String sig = getSigForGroupGetCounters(application_key, counterTypes, groupId,sessionSecretKey );
        String token = "tkn1YX95MI8gXZC4fjRUV1pfsRyR5ydwyuT3fspvrOefLoqfYWs2nNFeQQnyxUgxAACud";
        String request = baseUrl +
                "?application_key=" + application_key +
                "&counterTypes=" + counterTypes +
                "&format=" + format +
                "&group_id=" + groupId +
                "&method=" + method +
                "&sig=" + sig +
                "&access_token=" + token;
        LOGGER.info("request - |{}|", request);
        Response response = SerenityRest.get(request);
        LOGGER.info("response - |{}|{}|", response.statusCode(), response.body().asString());
        return response;
    }

    @Step
    private String getSigForGroupGetCounters(
            String applicationKey, String counterTypes, String groupId, String sessionSecretKey
    ) {
        String text = String.format(
                "application_key=%scounterTypes=%sformat=jsongroup_id=%smethod=group.getCounters%s",
                applicationKey, counterTypes, groupId, sessionSecretKey
        );
        return Md5Helper.getMD5Hash(text);
    }
}
