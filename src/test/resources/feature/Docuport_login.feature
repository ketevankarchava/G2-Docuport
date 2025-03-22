Feature: Docuport Smoke Test Feature

@SmokeTest @UI
Scenario: Verify successful login with valid credentials

  Given user is on Docuport Login Page
  When the user enters username "b1g1_advisor@gmail.com" and password "Group1"
  And clicks the Login button
  #And user clicks continue button
  Then the user should be redirected to home page for advisor