package io.loop.pages;

import io.loop.utils.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientsPage {
    public ClientsPage()  {PageFactory.initElements(Driver.getDriver(), this);}

    public static final Logger log = LogManager.getLogger();

    @FindBy(xpath = "//div[@class='v-data-footer__pagination']")
    public WebElement pagination;

    @FindBy(xpath = "//span[@class ='v-btn__content']//span[.='Create new client']")
    public WebElement createNewClientButton;

    @FindBy(xpath = "//span[.='Personal']")
    public WebElement personalButton;

    @FindBy(xpath = "//div[.='First name']//input")
    public WebElement firstName;

    @FindBy(xpath = "//div[.='Last name']//input")
    public WebElement lastName;

    @FindBy(xpath = "//div[@class='v-input--selection-controls__ripple']")
    public WebElement createNewUserCheckbox;

    @FindBy(xpath = "//div[.='Email address']//input")
    public WebElement emailAddress;

    @FindBy(xpath = "//div[.='Advisor']//i")
    public WebElement advisor;

    @FindBy(xpath = "//div[.='Batch1 Group1']")
    public WebElement batch1Group;

    @FindBy (xpath = "//div[.='Phone number']//input")
    public WebElement phoneNumber;

    @FindBy (xpath = "//div[.='Password']//input")
    public WebElement password;

    @FindBy (xpath = "//div[.='Confirm password']//input")
    public WebElement confirmPassword;

    @FindBy (xpath = "//button[@type='submit']//span/..")
    public WebElement submitButton;

    @FindBy (xpath = "//div[.='This field is required']")
    public WebElement errorMessage;


}