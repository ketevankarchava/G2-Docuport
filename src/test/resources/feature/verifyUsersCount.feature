Feature: Docuport Smoke Test Feature

  @SmokeTest
  Scenario: verify UI total account for users matches the DB count
    Given the "advisor" on the home page
    And the user navigates to "users" on the "leftNavigation" bar
    And the user clicks the search button
    And the user clicks the all radio button
    And the users clicks the filter search button
    When the user gets total user count
    Then verify user count information match in DB