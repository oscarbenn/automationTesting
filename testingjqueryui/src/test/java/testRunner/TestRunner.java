package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                    glue = {"stepDefinitions"},
                    tags = "@smokeFeature",
                    monochrome = false,
                    plugin = {"pretty", "html:target/htmlReport/reports.html",
                                        "json:target/jsonReport/reports.json",
                                        "junit:target/junitReport/reports.xml"}
                )
class TestRunner {

}
