import com.greenapp.Constants;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.URI;


@RunWith(Cucumber.class)
@CucumberOptions(format ={"html:target/cucumber-html-report", "json:target/cucumber.json"},
    tags = {"@test"},
    features ="src/test/resources/features",
    glue = {"com.greenapp.stepDefinitions"} )

public class APIRunner {

    public APIRunner() {

    }

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = URI.create(Constants.baseURL).toString() ;
    }

}
