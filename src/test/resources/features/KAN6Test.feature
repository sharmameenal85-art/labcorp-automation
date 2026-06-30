Feature: KAN-6 - Sprint agent - Validate UI elements on main page

  @KAN-6 @happy_path @smoke
  Scenario: Validate main page UI loads with correct elements
    Given I navigate to the main page URL
    When I wait for the page to load completely
    Then the main page should display all UI elements correctly

  @KAN-6 @boundary_test @regression
  Scenario: Check main page responsiveness at minimum screen resolution
    Given I set the browser screen resolution to the minimum supported size
    When I navigate to the main page URL
    Then the main page UI elements should adjust and display correctly at the minimum resolution

  @KAN-6 @security_test @regression
  Scenario: Ensure main page does not expose user data without authentication
    Given I access the main page without being logged in
    Then sensitive user data should not be visible or accessible

  @KAN-6 @security_test @regression
  Scenario: Test input fields for SQL injection vulnerabilities
    Given I enter SQL injection code into input fields on the main page
    When I submit the input
    Then the application should handle the input safely and not execute unintended operations