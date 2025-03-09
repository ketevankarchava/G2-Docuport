package io.loop.pages;

import io.loop.utils.BrowserUtils;
import io.loop.utils.Driver;
import io.loop.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class ProductPage {

    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickCategory(String category){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[contains(.,'"+category+"')]"));
        BrowserUtils.waitForClickable(element,10).click();
    }

    public String getProductPrice(String product){
        String actualPrice = Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='"+product+"']/../../h5")).getText();
        return actualPrice.substring(1);
    }
}