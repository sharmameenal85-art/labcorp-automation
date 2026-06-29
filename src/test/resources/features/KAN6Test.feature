```
Feature: KAN-6 - Sprint agent - Validate UI elements on main page

  @KAN-6 @smoke @regression
  Scenario: Validate all main page UI elements load correctly
    Given the main page is open
    When all UI elements such as headers, footers, buttons, and labels are checked for visibility
    Then all UI elements should be visible and correctly formatted on the main page

  @KAN-6 @smoke @regression
  Scenario: Verify behavior with invalid input in text fields
    Given the main page is open
    When invalid characters are entered into input fields
    And the fields are submitted or interacted with
    Then validation error messages should be displayed and invalid input should not be accepted

  @KAN-6 @smoke @regression
  Scenario: Test input field boundary with maximum allowable characters
    Given the main page is open
    When maximum allowed characters are entered into an input field
    And the input is submitted
    Then application should accept the input and handle it correctly without errors

  @KAN-6 @smoke @regression
  Scenario: Test input field boundary with minimum allowable characters
    Given the main page is open
    When minimum required characters are entered into an input field
    And the input is submitted
    Then application should accept the input and process it correctly

  @KAN-6 @smoke @regression
  Scenario: Verify SQL injection protection
    Given the main page is open
    When SQL injection scripts are entered into input fields
    And the input is submitted
    Then application should sanitize input and reject potential SQL injection attempts

  @KAN-6 @smoke @regression
  Scenario: Check unauthorized access to main page
    When an attempt is made to access the main page without proper authentication
    Then access should be denied and the user should be redirected to the login page

  @KAN-6 @smoke @regression
  Scenario: Ensure user session management is secure
    Given the main page is open
    When signed in with valid credentials
    And logged out
    Then user should be redirected to the login page after logout, preventing unauthorized access

  @KAN-6 @smoke @regression
  Scenario: Check all button labels on the main page
    Given the main page is open
    When all buttons are checked for correct labels as per the design specifications
    Then all button labels should be correct and match the design documentation

  @KAN-6 @smoke @regression
  Scenario: Verify layout consistency across devices
    Given the main page is open on various devices/browsers
    When the layout is checked for consistency and responsiveness
    Then UI should display consistently across devices and maintain responsiveness
```