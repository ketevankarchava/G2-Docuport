package io.loop.pages;

import io.loop.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Received')]")
    public WebElement receivedDocs;
    @FindBy(xpath = "//span[contains(text(),'Clients')]")
    public WebElement clients;
    @FindBy(xpath = "//span[contains(text(),'Users')]")
    public WebElement users;

    @FindBy(xpath = "//span[.='Batch1 Group1']")
    public WebElement batch1Group;

    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logOut;

    @FindBy(xpath = "//span[.='John Smith']")
    public WebElement userJohnSmith;

}
