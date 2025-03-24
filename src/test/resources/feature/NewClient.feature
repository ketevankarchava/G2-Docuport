@smoke @docuportCreateNewClient
Feature: Docuport New Client Creation Feature Login as an Advisor

  Background: user is on Docuport login page
  @ui
  Scenario Outline: Create a new "Personal" client and login as a new client

    Given the user is logged in as an advisor
    When the user creates a new client with the following details:
      | First name   | Last name   | Email address  | Phone number   | Password          | Confirm password  |
      | <First Name> | <Last Name> | <Client Email> | <Phone Number> | <Client Password> | <Client Password> |
    And the user validates that new client was created "<First Name>" and "<Last Name>"
    And the user logs out as an advisor
    Then the user should be able to log in as a new client using:
      | Email address  | Password          |
      | <Client Email> | <Client Password> |
    Then the user name "<First Name>" and "<Last Name>" should be displayed in the top right
    Examples:
      | First Name | Last Name | Client Email            | Phone Number | Client Password|
      | John       | Smith     | johnsmith0788@gmail.com | 3453457898   | Password1      |


