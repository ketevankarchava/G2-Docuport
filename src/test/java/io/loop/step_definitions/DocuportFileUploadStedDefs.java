package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loop.pages.LeftNavigatePage;
import io.loop.pages.MyUploadsPage;
import io.loop.utils.DocuportUtils;
import io.loop.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class DocuportFileUploadStedDefs {



    @Given("login as {string} to Docuport page")
    public void login_as_to_docuport_page(String str) throws InterruptedException {
    DocuportUtils.login(Driver.getDriver(), str);
    }
    @Then("user clicks on my uploads")
    public void user_clicks_on() throws InterruptedException {
        LeftNavigatePage navigatePage = new LeftNavigatePage();
        MyUploadsPage myUploadsPage = new MyUploadsPage();
        navigatePage.myUploads.click();
        Assert.assertTrue(myUploadsPage.myUploads.isDisplayed());
        Thread.sleep(1000);


    }
    @Then("user uploads {string} and verify")
    public void user_uploads_and_verify(String str) throws InterruptedException, IOException {
        MyUploadsPage myUploadsPage = new MyUploadsPage();
        File file = new File(str);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        int dotIndex = str.lastIndexOf(".");
        String nameNoExt = str.substring(0, dotIndex);
        String ext = str.substring(dotIndex);
        String newfileName = nameNoExt+"_"+UUID.randomUUID()+ext;
        File newFile = new File(file.getParent(),newfileName);
        Files.copy(file.toPath(),newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        String absolutePath = newFile.getAbsolutePath();

        myUploadsPage.uploadDocuments.click();
        Thread.sleep(1000);
        myUploadsPage.fileUploadInput.sendKeys(absolutePath);
        Thread.sleep(2000);
        try {
            myUploadsPage.clientDropdown.click();
        }catch(ElementClickInterceptedException e){
            jse.executeScript("arguments[0].click();", myUploadsPage.clientDropdown);
        }
        Thread.sleep(1000);
        myUploadsPage.abcOption.click();
        Thread.sleep(1000);
        try {
            myUploadsPage.serviceDropdown.click();
        }catch(ElementClickInterceptedException e){
            jse.executeScript("arguments[0].click();", myUploadsPage.serviceDropdown);
        }
        Thread.sleep(1000);
        myUploadsPage.bookkeepingOption.click();
        Thread.sleep(1000);
        myUploadsPage.IrsDocTypeSelection.click();
        Thread.sleep(1000);
        myUploadsPage.quarterQ4Option.click();
        Thread.sleep(1000);
        myUploadsPage.upload.click();
        Thread.sleep(1000);
        myUploadsPage.searchDropdown.click();
        Thread.sleep(1000);
        myUploadsPage.searchByDocumentName.sendKeys(newfileName);
        myUploadsPage.searchButton.click();
       Thread.sleep(1000);
        WebElement fileElement = Driver.getDriver().findElement(By.xpath("//tbody//td/span[.='"+newfileName+"']"));
        Assert.assertTrue(fileElement.isDisplayed());

    }

}
