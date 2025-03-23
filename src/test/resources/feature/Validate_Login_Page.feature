Feature: Docuport Smoke Test Feature

@SmokeTest
Scenario: Verify the Docuport login page loads successfully
Given user is on Docuport Login Page
Then the login page should be displayed with username and password fields
And the ""Login"" button should be visible"