package io.loop.pages;

import io.loop.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientsPage {
    public ClientsPage()  {PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(xpath = "//div[@class='v-data-footer__pagination']")
    public WebElement pagination;


}