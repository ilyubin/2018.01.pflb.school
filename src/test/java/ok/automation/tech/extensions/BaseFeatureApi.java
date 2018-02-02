package ok.automation.tech.extensions;

import com.github.javafaker.Faker;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import ok.automation.steps.ApiSteps;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class BaseFeatureApi {

    protected String okApplicationKey = System.getProperty("okApplicationKey");
    // TODO

    protected Faker fake = new Faker();

    @Steps
    protected ApiSteps api;
}
