package io.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/html-reports/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
        features = "src/test/resources/feature",
        glue = "io/loop/step_definitions",
        dryRun = false,
        tags = "@SmokeTest",
        monochrome = true,
        publish = false
)


public class CukesTest {
}
