package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features",          // Path to your .feature files
        glue = {"StepDefinition", "Hooks"},                    // Package containing step defs
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        monochrome = true
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
