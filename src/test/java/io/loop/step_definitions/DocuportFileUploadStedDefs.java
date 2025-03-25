package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.loop.utils.BrowserUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.awt.*;

public class DocuportFileUploadStedDefs {

    private static final Logger LOG = LogManager.getLogger();

    @Given("user uploads document")
    public void user_uploads_document() throws AWTException {
        BrowserUtils.uploadFileForWindows("\"C:\\Users\\KETO\\Desktop\\text.txt.txt\"");
        LOG.info("user uploads document");
    }


}
