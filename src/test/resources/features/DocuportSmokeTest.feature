Feature: Docuport Smoke Test Feature

@SmokeTest @UI
Scenario: Login as and advisor to Docuport and upload a document, verify the document was successfully uploaded
Given login as "advisor" to Docuport page
  Then user clicks on my uploads
  And user uploads "PavloUploadFile.png" and verify
