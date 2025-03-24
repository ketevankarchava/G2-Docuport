@smoke @negative
Feature: Create new client with empty input

  As an Advisor
  I want to be unable to create a new client with empty input
  So that the system prevents invalid data submission.

  Background:
    Given I am logged in as an "Advisor"
    And I can see the "Clients" module in the left navigation bar

  @ui @@emptyInput
  Scenario: Unable to create a new client with empty input
    Given I navigate to the "Clients" section
    When I click on the "Create New Client" button
    And I leave all the fields empty
    And I click the "Save" button
    Then I should see an error message "This field is required"
    And the new client should not be created