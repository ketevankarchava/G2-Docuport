Feature: Docuport Smoke Test Feature

  @SmokeTest @UI
  Scenario: Verify user can successfully log out

    Given the "advisor" on the home page
    When the user clicks the Logout button
    Then the user should be redirected to the login page