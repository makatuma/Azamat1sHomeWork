package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json","junit:target/cucumber.xml",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/com.WebOrder/",
        glue = "StepDefinitions",
        monochrome = false,
        dryRun = false
)
public class WebOrderRegressionRunner {
}