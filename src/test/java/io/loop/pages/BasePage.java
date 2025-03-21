package io.loop.pages;

import io.loop.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

@FindBy (xpath = "//div[@role='listbox']/a")
    public List<WebElement> allModule;

    public void clickOnModule(String module) {
        for(WebElement eachmoduleElement : allModule) {
            if(eachmoduleElement.getText().equals(module)) {
                eachmoduleElement.click();
                break;
            }
        }
    }


}
