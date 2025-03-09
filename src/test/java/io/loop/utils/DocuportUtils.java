package io.loop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class DocuportUtils {

/**
 * logins to docuport application
 * @param driver, which is initialized in the test base
 * @param role, comes from docuport constants
 * author KK
 */

public static void login(WebDriver driver, String role) throws InterruptedException {
    driver.get(ConfigurationReader.getProperties("docuportBETA"));
    WebElement username = driver.findElement(By.xpath("//label[.='Username or email']/following-sibling::input"));
    WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

    switch (role.toLowerCase()){
        case "client":
            username.sendKeys(DocuportConstants.USERNAME_CLIENT);
            password.sendKeys(DocuportConstants.PASSWORD);
            break;

        case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;

        case "advisor":
            username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
            password.sendKeys(DocuportConstants.PASSWORD);
            break;

        case "employee":
            username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
            password.sendKeys(DocuportConstants.PASSWORD);
            break;
        default: throw new InterruptedException("There is no such a role" + role);

    }

    loginButton.click();

    if (role.toLowerCase().equals("client")){
        Thread.sleep(3000);
        WebElement con = driver.findElement(By.xpath("//button[@type='submit']"));
        con.click();
        Thread.sleep(3000);
    }
}

/**
 * logs out from docuport application
 * @param driver
 * @author KK
 */

public static void logout(WebDriver driver) {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
    WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
    userIcon.click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
    WebElement logoutButton = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
    logoutButton.click();
}

}
