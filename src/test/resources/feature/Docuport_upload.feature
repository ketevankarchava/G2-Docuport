Feature: Docuport Smoke Test Feature

  @SmokeTest
  Scenario: Login as and advisor to Docuport and upload a document, verify the document was successfully uploaded
    Given the "advisor" on the home page
    And the user navigates to "My uploads" on the "leftNavigation" bar
    And user uploads document