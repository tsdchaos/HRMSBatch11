Feature: Modify Employee Details
  Background:
    When user is logged in with valid admin credentials
    When user navigates to employee list page

  @Test @Smoke @Edit
  Scenario: Admin edits employee details after searching by name
    When user enters valid employee name
    And user clicks on search button
    Then user sees employee information is displayed
    Then user clicks on Edit button
    And edits required fields
      |DLN|SSN|Married|DOB|Smoker|
      |123456|123-45-6789|Single|01/01/1978|false|
    Then user clicks on save button
