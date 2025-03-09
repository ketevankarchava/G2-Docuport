package io.loop.pages;

import io.loop.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='gbqfbb']//preceding-sibling::input")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']" )
    public WebElement captcha;

    @FindBy (xpath = "//div[@class='wvKXQ']")
    public WebElement capital;

    /**
     * handles captcha on google website
     * @param driver
     * @param captchaElement
     * @author KK
     */

    public void handleCaptcha(WebDriver driver, WebElement captchaElement) {
        try {
            WebElement iframe = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
            driver.switchTo().frame(iframe);

            if (captchaElement.isDisplayed()) {
                captchaElement.click();
            }
            driver.switchTo().defaultContent();
        }catch (NoSuchElementException e) {
            System.out.println("No CAPTCHA found, continuing execution...");
        }
    }

}
