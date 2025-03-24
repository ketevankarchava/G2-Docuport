package io.loop.step_definitions;

import io.cucumber.java.en.*;
import io.loop.pages.POM;
import io.loop.utils.ConfigurationReader;
import io.loop.utils.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class InvalidClientCreationStepDefs {

    POM pages = new POM();
    private static final Logger LOG = LogManager.getLogger();

    @Given("I am logged in as an {string}")
    public void i_am_logged_in_as_an(String role) throws InterruptedException {


        Driver.getDriver().get(ConfigurationReader.getProperties("docuportUiUrl"));


        pages.getLoginPage().login(Driver.getDriver(), role);

        Thread.sleep(5000);

    }
    @Given("I can see the {string} module in the left navigation bar")
    public void i_can_see_the_module_in_the_left_navigation_bar(String client) {



        Assert.assertTrue(pages.getLeftNavigatePage().clientsButton.isDisplayed());

    }
    @Given("I navigate to the {string} section")
    public void i_navigate_to_the_section(String client) {

        pages.getLeftNavigatePage().clickButton(client);


    }
    @When("I click on the {string} button")
    public void i_click_on_the_button(String createNewClient) throws InterruptedException {

        pages.getClientsPage().createNewClientButton.click();
        pages.getClientsPage().personalButton.click();

        Thread.sleep(5000);

    }
    @When("I leave all the fields empty")
    public void i_leave_all_the_fields_empty() {


    }
    @When("I click the {string} button")
    public void i_click_the_button(String saveButton) {

        pages.getClientsPage().submitButton.click();



    }
    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String message) {

        Assert.assertEquals(pages.getClientsPage().errorMessage.getText(), message);



    }
    @Then("the new client should not be created")
    public void the_new_client_should_not_be_created() {


    }

}
