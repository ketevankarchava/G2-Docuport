@ayaz
Feature: Docuport Smoke Test Feature

  @SmokeTest @ui
  Scenario: Login as an advisor
    When user is on Docuport Login Page
    And the user enters username "username" and password "password"
    And clicks the Login button
    Then user validate left navigate items
      | Home            |
      | Received docs   |
      | My uploads      |
      | Clients         |
      | Invitations     |
      | Users           |
      | Leads           |
      | Bookkeeping     |
      | 1099 Form       |
      | Reconciliations |
Then the user clicks the Logout button