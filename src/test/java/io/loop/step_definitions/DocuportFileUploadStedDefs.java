package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.loop.utils.BrowserUtils;
import io.loop.utils.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.awt.*;

public class DocuportFileUploadStedDefs {

    private static final Logger LOG = LogManager.getLogger();

    @Given("user uploads document")
    public void user_uploads_document() throws AWTException {

        WebElement fileInput = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Upload documents')]/../.."));
        fileInput.sendKeys("C:\\Users\\KETO\\Desktop\\text.txt.txt");
        //BrowserUtils.uploadFileForWindows("\"C:\\Users\\KETO\\Desktop\\text.txt.txt\"");
        LOG.info("user uploads document");
    }


}
