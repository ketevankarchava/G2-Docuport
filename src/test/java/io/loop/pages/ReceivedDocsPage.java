package io.loop.pages;

import io.loop.utils.BrowserUtils;
import io.loop.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ReceivedDocsPage {


    public ReceivedDocsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[contains(text(),'Search')]")
    public WebElement searchButton;

    @FindBy(xpath = "//label[contains(text(),'Document name')]/following-sibling::input")
    public WebElement documentName;

    @FindBy(xpath = "//div[@class='mb-3 col-sm-6 col-md-4 col-12'][2]")
    public WebElement tagsDropdown;

    @FindBy(xpath = "//input[@role='button']")
    public WebElement uploadDate;

    @FindBy(xpath = "//input[@id='input-523']")
    public WebElement uploadedBy;

    public void clickButton(String button){
        switch (button.toLowerCase().trim()){
            case "search":
                BrowserUtils.waitForClickable(searchButton, 10).click();
                break;
            default: throw new IllegalArgumentException("Not such a button: " + button);
        }
    }

    public void insertField(String field, String input){
        switch (field.toLowerCase().trim()){
            case "document name":
                BrowserUtils.waitForVisibility(documentName, 10).sendKeys(input);
                break;
            case "tags":
                WebElement dropdown = tagsDropdown;
                dropdown.click();
                BrowserUtils.waitForVisibility(dropdown, 10).sendKeys(input);
                if (dropdown.getText().contains(input)) {
                    dropdown.sendKeys(input);
                }else throw new IllegalArgumentException("No such a tag: " + input);
                break;
            default: throw new IllegalArgumentException("No such a field: " + field );
        }
    }

}