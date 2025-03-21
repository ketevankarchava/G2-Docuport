package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.HomePage;
import io.loop.pages.LoginPage;
import io.loop.utils.BrowserUtils;
import io.loop.utils.ConfigurationReader;
import io.loop.utils.DocuportConstants;
import io.loop.utils.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class DocuportStepDefs {
    LoginPage loginPage= new LoginPage();
    HomePage homePage= new HomePage();
    private static final Logger LOG = LogManager.getLogger();

    @Given("user is on Docuport Login Page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuportUiUrl"));

    }
    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String string, String string2) {
     loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
     loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
        LOG.info("user enters username");
    }
    @When("clicks the Login button")
    public void clicks_the_login_button() {
    loginPage.loginButton.click();
        LOG.info("user clicks login button");

//    }
//    @When("user clicks continue button")
//    public void user_clicks_continue_button() {

    }
    @Then("the user should be redirected to home page for advisor")
    public void the_user_should_be_redirected_to_home_page_for_advisor() {
    assertTrue("Home page is not displayed", BrowserUtils.waitForVisibility(homePage.receivedDocs,10).isDisplayed());
        LOG.info("Home page is successfully displayed");

    }



}


