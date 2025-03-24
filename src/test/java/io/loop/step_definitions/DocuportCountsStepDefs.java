package io.loop.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.*;
import io.loop.utils.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class DocuportCountsStepDefs {
    LoginPage loginPage = new LoginPage();
    ClientsPage clientsPage = new ClientsPage();
    UserPage userPage = new UserPage();
    HomePage homePage = new HomePage();
    LeftNavigatePage leftNavigatePage = new LeftNavigatePage();
    String returnPagination;
    String uiUserCount;
    private static final Logger LOG = LogManager.getLogger();


    @Given("the {string} on the home page")
    public void the_on_the_home_page(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuportUiUrl"));

        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton)).click();

        wait.until(ExpectedConditions.visibilityOf(homePage.clients));
        LOG.info("Logged in and home page loaded.");
    }


    @Given("the user navigates to {string} on the {string} bar")
    public void the_user_navigates_to_page(String button, String navigationBar) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        switch (button.toLowerCase().trim()) {
            case "clients":
                wait.until(ExpectedConditions.elementToBeClickable(homePage.clients)).click();
                LOG.info("Clicked on Clients button");
                break;

            case "users":
                wait.until(ExpectedConditions.elementToBeClickable(homePage.users)).click();
                LOG.info("Clicked on Users button");
                break;

            default:
                throw new IllegalArgumentException("Not a valid button: " + button);
        }
    }

    @When("the user gets total user count")
    public void the_user_gets_total_user_count() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(clientsPage.pagination));

        returnPagination = clientsPage.pagination.getText();
        String[] parts = returnPagination.split(" ");
        if (parts.length >= 3) {
            uiUserCount = parts[2];
            LOG.info("UI user count is: " + uiUserCount);
        } else {
            throw new RuntimeException("Pagination text not as expected: " + returnPagination);
        }
    }


    @And("the user clicks the search button")
    public void theUserClicksTheSearchButton() {
        userPage.searchButton.click();
    }

    @And("the user clicks the all radio button")
    public void theUserClicksTheAllRadioButton() {
        userPage.clickRadioButton("All");
    }

    @And("the users clicks the filter search button")
    public void theUsersClicksTheFilterSearchButton() {
        BrowserUtils.waitForClickable(userPage.searchFilterButton,3);
        userPage.searchFilterButton.click();
        BrowserUtils.justWait(2000);
        uiUserCount = userPage.pagination.getText().split(" ")[2];
    }

    @Then("verify user count information match in DB for {int} advisor_user_id")
    public void verify_user_count_information_match_in_db(int advisor_user_id) {
        DB_Utility.createConnection(ConfigurationReader.getProperties("docuportDbUrl"), ConfigurationReader.getProperties("docuportDbUsername"), ConfigurationReader.getProperties("docuportDbPassword"));
        DB_Utility.runQuery("select count(*) from document.clients where advisor_user_id = " + advisor_user_id + ";");
        String dbClientsCount = DB_Utility.getCellValue(1, 1);
//        System.out.println(dbClientsCount);
        assertEquals("expected does not match actual. returned from the DB " + dbClientsCount + " returned from the UI " + uiUserCount, dbClientsCount, uiUserCount);
        LOG.info("returned from the DB: " + dbClientsCount + " returned from the UI: " + uiUserCount);
        DB_Utility.destroy();
    }


    @Then("verify user count information match in DB")
    public void verifyUserCountInformationMatchInDB() {
        DB_Utility.createConnection(ConfigurationReader.getProperties("docuportDbUrl"), ConfigurationReader.getProperties("docuportDbUsername"), ConfigurationReader.getProperties("docuportDbPassword"));
        DB_Utility.runQuery("select count(*) from identity.users;");
        String dbClientsCount = DB_Utility.getCellValue(1, 1);
        assertEquals("expected didnt match", dbClientsCount, uiUserCount);
        LOG.info("returned from the DB: " + dbClientsCount + " returned from the UI: " + uiUserCount);
        DB_Utility.destroy();


    }

    @Then("user validate left navigate items")
    public void user_validate_left_navigate_items(List<String> expectedLeftNav) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(leftNavigatePage.actualLeftNav));


        List<String> actualLeftNav = new ArrayList<>();
        for (int i = 0; i < leftNavigatePage.actualLeftNav.size(); i++) {
            actualLeftNav.add(leftNavigatePage.actualLeftNav.get(i).getText());
        }

        assertEquals("Actual DOES NOT match expected", expectedLeftNav, actualLeftNav);
    }


}
