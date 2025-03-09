package io.loop.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.loop.utils.BrowserUtils;
import io.loop.utils.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {

    private static final Logger LOG = LogManager.getLogger();

    @Before
    public void setUp(Scenario scenario){
        Driver.getDriver();
        BrowserUtils.myScenario = scenario;
        LOG.info("....................START AUTOMATION...............LOOPCAMP");
    }

    @After
    public void tearDown(Scenario scenario){
        // only takes screenshot when scenario is failed
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        LOG.info("....................END AUTOMATION...............LOOPCAMP");
      //  Driver.closeDriver();
    }

    //@AfterStep
    public void takeScreenshot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
}
