package io.loop.step_definitions;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DocuportUploadFileAndVerify {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void docuportLoginAndUpload() {
        // Step 1: Open Docuport Login Page
        driver.get("https://beta.docuport.app/login");

        // Step 2: Enter Username and Password
        driver.findElement(By.id("username")).sendKeys("b1g1_advisor@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Group1");

        // Step 3: Click Login Button
        driver.findElement(By.id("loginButton")).click();

        // Step 4: Verify Login Success
        String expectedUrl = "https://docuport.example.com/dashboard";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");

        // Step 5: Navigate to "My Uploads"
        driver.findElement(By.xpath("//a[contains(text(),'My uploads')]")).click();

        // Step 6: Upload a File
        WebElement uploadElement = driver.findElement(By.id("fileUpload"));
        uploadElement.sendKeys("\"C:\\Users\\Windows User\\OneDrive\\Desktop\\HTML\\OlafVlog\\Screenshot 2025-01-05 000412.png\""); // Replace with actual file path

        // Step 7: Click Upload Button
        driver.findElement(By.id("uploadButton")).click();

        // Step 8: Verify File Uploaded Successfully
        WebElement successMessage = driver.findElement(By.id("uploadSuccessMessage"));
        Assert.assertTrue("File upload failed!", successMessage.isDisplayed());
        Assertions.assertTrue(successMessage.getText().contains("successfully uploaded"), "Incorrect success message!");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit(); // Close the browser after test execution
    }
}

