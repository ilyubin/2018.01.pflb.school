package ok.automation.models.api;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import ok.automation.tech.extensions.HashHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.TreeMap;

public class ApiRequest {

    private static final Logger _log = LoggerFactory.getLogger(ApiRequest.class);
    private static final EnvironmentVariables _env = SystemEnvironmentVariables.createEnvironmentVariables();
    private static final String BASE_URL = _env.getProperty("api.base_url");
    private static final String FORMAT = "json";
    private static final String SESSION_SECRET_KEY = System.getProperty("apiSessionSecretKey");
    private static final String ACCESS_TOKEN = System.getProperty("apiAccessToken");
    private static final String APPLICATION_KEY = System.getProperty("apiApplicationKey");

    private Map<String, String> parameters = new TreeMap<>();

    public ApiRequest(){
        parameters.put("application_key", APPLICATION_KEY);
        parameters.put("format", FORMAT);
    }

    public void addParameter(String key, String value){
        parameters.put(key, value);
    }

    public void addParameter(String key, Boolean value){
        parameters.put(key, value.toString());
    }

    public void addParameter(String key, String... value){
        parameters.put(key, mergeArray(",", value));
    }

    public Response send(){
        Map<String, String> parameters = new TreeMap<>(this.parameters);
        parameters.putIfAbsent("sig", getSig());
        parameters.putIfAbsent("access_token", ACCESS_TOKEN);

        Response response = SerenityRest.rest().formParams(parameters).get(BASE_URL);
        _log.info("response - | {} | {} |", response.statusCode(), response.body().asString());
        return response;
    }

    private String getSig(){
        StringBuilder sigSource = new StringBuilder();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            sigSource.append(entry.getKey()).append('=').append(entry.getValue());
        }
        sigSource.append(SESSION_SECRET_KEY);
        return HashHelper.getMD5(sigSource.toString());
    }

    private static String mergeArray(String separator, String... strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i > 0) sb.append(separator);
            sb.append(strings[i]);
        }
        return sb.toString();
    }

}
