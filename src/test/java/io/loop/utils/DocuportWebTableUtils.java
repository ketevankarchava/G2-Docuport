package io.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocuportWebTableUtils {

    /**
     * @param driver
     * @param emailAddress
     * @param field
     * @return
     */

    public static String returnAnyField(WebDriver driver, String emailAddress, String field) throws InterruptedException {
        WebElement element = null;
        String xpath = "";

        switch (field.toLowerCase().trim()) {
            case "full name":
                xpath = "//td[2][normalize-space()='" + emailAddress + "']/preceding-sibling::td//span[2]";
                break;
            case "username":
                xpath = "//td[2][normalize-space()='" + emailAddress + "']/following-sibling::td[1]";
                break;
            case "inviter":
                xpath = "//td[2][normalize-space()='" + emailAddress + "']/following-sibling::td[2]";
                break;
            case "phone number":
                xpath = "//td[2][normalize-space()='" + emailAddress + "']/following-sibling::td[3]/span";
                break;
            case "role":
                xpath = "//td[2][normalize-space()='" + emailAddress + "']/following-sibling::td[3]/span/span";
                break;

            default:
                throw new InterruptedException("There is not such a field: " + field);
        }

        element = driver.findElement(By.xpath(xpath));
        return element.getText().trim();
    }


}