package io.loop.step_definitions;

import freemarker.core.Environment;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import io.loop.pages.POM;
import io.loop.utils.BrowserUtils;
import io.loop.utils.ConfigurationReader;
import io.loop.utils.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.jcajce.provider.symmetric.SEED;
import org.junit.Assert;

import java.util.*;
import java.util.stream.Collectors;

public class Create_New_Client_StepDefs {

    POM pages = new POM();
    private static final Logger LOG = LogManager.getLogger();


    @Given("the user is logged in as an advisor")
    public void the_user_is_logged_in_as_an_advisor() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuportUiUrl"));
        pages.getLoginPage().login(Driver.getDriver(), "Advisor");

    }
    @When("the user creates a new client with the following details:")
    public void the_user_creates_a_new_client_with_the_following_details(List<Map<String,Object>> clientInfo) throws InterruptedException {

    int index = 0;

     //BrowserUtils.waitForClickable(pages.getLeftNavigatePage().clientsButton, 10).click();
        pages.getLeftNavigatePage().clickButton("Clients");
        pages.getClientsPage().createNewClientButton.click();
        pages.getClientsPage().personalButton.click();
        pages.getClientsPage().firstName.sendKeys(clientInfo.get(index).get("First name").toString());
        pages.getClientsPage().lastName.sendKeys(clientInfo.get(index).get("Last name").toString());
        BrowserUtils.waitForClickable(pages.getClientsPage().createNewUserCheckbox, 10).click();
        pages.getClientsPage().emailAddress.sendKeys(clientInfo.get(index).get("Email address").toString());
        pages.getClientsPage().advisor.click();
        pages.getClientsPage().batch1Group.click();
        pages.getClientsPage().phoneNumber.sendKeys(clientInfo.get(index).get("Phone number").toString());
        pages.getClientsPage().password.sendKeys(clientInfo.get(index).get("Password").toString());
        pages.getClientsPage().confirmPassword.sendKeys(clientInfo.get(index).get("Confirm password").toString());
        pages.getClientsPage().submitButton.click();

        Thread.sleep(5000);





    }
    @When("the user validates that new client was created {string} and {string}")
    public void the_user_validates_that_new_client_was_created_and(String firstName, String lastName) {

        BrowserUtils.waitForClickable(pages.getLeftNavigatePage().usersButton,10).click();
        pages.getUsersPage().firstSearchButton.click();
        pages.getUsersPage().firstNameBox.sendKeys(firstName);
        pages.getUsersPage().lastNameBox.sendKeys(lastName);
        pages.getUsersPage().emailAddressBox.sendKeys("johnsmith0788@gmail.com");

        BrowserUtils.waitForClickable(pages.getUsersPage().secondSearchButton, 10).click();
        Assert.assertTrue("User name is not displayed",  pages.getUsersPage().userValidation.isDisplayed());


    }
    @When("the user logs out as an advisor")
    public void the_user_logs_out_as_an_advisor() throws InterruptedException {

        pages.getHomePage().batch1Group.click();

        BrowserUtils.waitForClickable(pages.getHomePage().logOut,10).click();

        Thread.sleep(5000);


    }
    @Then("the user should be able to log in as a new client using:")
    public void the_user_should_be_able_to_log_in_as_a_new_client_using(List<Map<String,Object>> userCredentials) {

        BrowserUtils.waitForClickable(pages.getLoginPage().usernameInput, 10).sendKeys(userCredentials.get(0).get("Email address").toString());

        System.out.println(userCredentials);

        BrowserUtils.waitForClickable(pages.getLoginPage().passwordInput, 10).sendKeys(userCredentials.get(0).get("Password").toString());

        pages.getLoginPage().loginButton.click();



    }
    @Then("the user name {string} and {string} should be displayed in the top right")
    public void the_user_name_and_should_be_displayed_in_the_top_right(String firstName, String lastName) {

        Assert.assertEquals(firstName + " " + lastName, pages.getHomePage().userJohnSmith.getText());

    }
}
