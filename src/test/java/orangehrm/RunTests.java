package orangehrm;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by User on 24/01/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = "html:target/CucumberReports", tags = "@login")
public class RunTests {
}
