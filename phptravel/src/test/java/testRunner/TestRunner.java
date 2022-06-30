package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
 @CucumberOptions(features = "src/test/resources/features",
                    glue= {"stepDefinitions"},
                    tags = "@smoke",
                    monochrome = false,
                    plugin = {"pretty", "html:target/reports.html",
                                        "json:target/reports.json",
                                        "junit:target/reports.xml"}
                )
class TestRunner {

}
