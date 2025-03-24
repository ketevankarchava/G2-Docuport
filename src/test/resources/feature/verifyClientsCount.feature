Feature: As a data consumer, I want UI user account to be in DB.

  @SmokeTest
  Scenario: verify UI total account for users matches the DB count
    Given the "advisor" on the home page
    And the user navigates to "clients" on the "leftNavigation" bar
    When the user gets total user count
    Then verify user count information match in DB for 45 advisor_user_id

