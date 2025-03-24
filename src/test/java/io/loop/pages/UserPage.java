package io.loop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserPage extends BasePage {

@FindBy (xpath = "//span[@class='subtitle-2 text-none']")
    public WebElement searchButton;

@FindBy (xpath = "//div[@class='v-data-footer__pagination']")
    public WebElement pagination;

@FindBy (xpath = "//label[.='First name']")
    public WebElement firstName;


    @FindBy (xpath = "//div[@role='radiogroup']/div")
    public List<WebElement> radioButtons;

    @FindBy (xpath = "//span[.=' Search ']")
    public WebElement searchFilterButton;

    @FindBy (xpath = "(//span[.='Search'])[1]")
    public WebElement firstSearchButton;

    @FindBy(xpath = "//span[.=' Search ']")
    public WebElement secondSearchButton;

    @FindBy (xpath = "//label[.='First name']//following-sibling::input")
    public WebElement firstNameBox;

    @FindBy (xpath = "//label[.='Last name']//following-sibling::input")
    public WebElement lastNameBox;

    @FindBy (xpath = "//label[.='Email address']//following-sibling::input")
    public WebElement emailAddressBox;

    @FindBy(xpath = "//td[.='John Smith']")
    public WebElement userValidation;

    @FindBy(xpath = "//label[.='Phone number']//following-sibling::input")
    public WebElement PhoneNumberBox;

    @FindBy(xpath = "//span[@class='ml-2']")
    public WebElement resultFullName;

    public void clickRadioButton (String radioButtonNames) {
        for (WebElement eachRadioButton : radioButtons) {
            if (eachRadioButton.getText().equals(radioButtonNames)) {
                eachRadioButton.click();
                break;
            }
        }
    }
}
