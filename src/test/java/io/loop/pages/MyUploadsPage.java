package io.loop.pages;

import io.loop.utils.BrowserUtils;
import io.loop.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyUploadsPage {


    public MyUploadsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Upload file')]/../..")
    public WebElement uploadFile;

    @FindBy(xpath = "//span[contains(text(),'Upload documents')]/../..")
    public WebElement uploadDocuments;

    @FindBy(xpath = "//span[contains(text(),' Upload ')]")
    public WebElement upload;

    @FindBy(xpath = "//span[contains(text(),'Search')]")
    public WebElement searchDropdown;

    @FindBy(xpath = "//button/span[contains(text(),'Search')]")
    public WebElement searchButton;

    @FindBy(xpath = "//p[@class='mb-0 subtitle-1']")
    public WebElement resultMessage;

    @FindBy(xpath = "//h1[.='My uploads']")
    public WebElement myUploads;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileUploadInput;

    @FindBy(xpath = "//label[.='Client']")
    public WebElement clientDropdown;

    @FindBy(xpath = "//div[@class='v-list-item__title' and .='Abc']")
    public WebElement abcOption;

    @FindBy(xpath = "//label[.='Service']")
    public WebElement serviceDropdown;

    @FindBy(xpath = "//div[@role='listbox']/div/div/div[@class='v-list-item__title' and .='Bookkeeping']")
    public WebElement bookkeepingOption;

    @FindBy(xpath = "//div[@class='v-text-field__slot']/label[.='Document name']/following-sibling::input")
    public WebElement searchByDocumentName;

    @FindBy(xpath = "//span[@class='ma-1 v-chip v-chip--clickable v-chip--label v-chip--outlined theme--dark v-size--small']/span[@class='v-chip__content' and contains(text(),'IRS/State Letter')]")
    public WebElement IrsDocTypeSelection;

    @FindBy(xpath = "//h6[contains(text(),'Quarter')]/../..//div//span[@class='v-chip__content' and contains(text(),'Q4')]")
    public WebElement quarterQ4Option;
    public void clickButton(String button) {
        switch (button.toLowerCase().trim()) {
            case "upload documents":
                BrowserUtils.waitForClickable(uploadDocuments, 10).click();
                break;
            case "upload":
                BrowserUtils.waitForClickable(upload, 10).click();
                break;
            case "search dropdown":
                BrowserUtils.waitForClickable(searchDropdown, 10).click();
                break;
            case "upload file":
                BrowserUtils.waitForClickable(uploadFile, 10).click();
                break;

            default:
                throw new IllegalArgumentException("Not such a button: " + button);
        }
    }

    public void insertField(String field, String input) {
    }
}