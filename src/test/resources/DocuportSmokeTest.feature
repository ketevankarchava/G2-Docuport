@SmokeTest @UI
Scenario: Login as and advisor to Docuport and upload a document, verify the document was successfully uploaded
Given user is on Docuport Login Page
When the user enters username ""b1g1_advisor@gmail.com"" and password ""Group1""
Then user clicks on ""My uploads"" and uploads a file
And user verifies file was uploaded succcesfully"