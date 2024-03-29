package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue="steps",
        tags="Regression",
        dryRun = false,
        monochrome = false,
        plugin = {"html:target/cucumber-reports",
                "pretty"}
)
public class Runner {
}
