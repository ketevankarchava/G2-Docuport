package io.loop.pages;

import io.loop.utils.BrowserUtils;
import io.loop.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[.='Batch1 Group1']")
    public WebElement batch1Group1button;


    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logoutButton;


    public void clickLogOutButton(String field, String input) {
        switch (field.toLowerCase().trim()) {
            case "batch1group1":
                BrowserUtils.waitForVisibility(batch1Group1button,10).sendKeys(input);
                break;

                case "logout":
                    BrowserUtils.waitForVisibility(logoutButton,10).sendKeys(input);
                    break;
                    default:throw new IllegalArgumentException("No such a field: " + field );
        }
    }
}