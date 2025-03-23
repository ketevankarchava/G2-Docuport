package io.loop.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.*;
import io.loop.utils.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        //BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.EXTRA_LARGE);
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
        loginPage.loginButton.click();

    }

    @Given("the user navigates to {string} on the {string} bar")
    public void the_user_navigates_to_page(String button, String navigationBar) {
        switch (button.toLowerCase().trim()) {
            case "clients":
                homePage.clients.click();
                break;
            case "users":
                homePage.users.click();
                break;
            default: throw new IllegalArgumentException("not a valid button");
        }

    }

    @When("the user gets total user count")
    public void the_user_gets_total_user_count() {
        BrowserUtils.justWait(3000);
//        System.out.println(clientsPage.pagination.getText());
        returnPagination = clientsPage.pagination.getText();
        String[] parts = returnPagination.split(" ");
        if (parts.length >= 3) {
            uiUserCount = parts[2];
        } else {
            throw new RuntimeException("pagination " + returnPagination);
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
        List<String> actualLeftNav = new ArrayList<>();
        for (int i = 0; i < leftNavigatePage.actualLeftNav.size(); i++) {
            actualLeftNav.add(leftNavigatePage.actualLeftNav.get(i).getText());
        }

        assertEquals("Actual DOES NOT match expected",expectedLeftNav, actualLeftNav);

    }

}
