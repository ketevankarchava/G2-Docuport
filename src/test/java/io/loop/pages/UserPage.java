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

    public void clickRadioButton (String radioButtonNames) {
        for (WebElement eachRadioButton : radioButtons) {
            if (eachRadioButton.getText().equals(radioButtonNames)) {
                eachRadioButton.click();
                break;
            }
        }
    }
}
