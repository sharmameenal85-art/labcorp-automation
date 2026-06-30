Feature: KAN-6 Sprint Agent - Validate UI Elements on Main Page

  @KAN-6 @happy_path @smoke @regression
  Scenario: Verify all UI elements are displayed on the main page
    Given I am on the main page
    When I check for the presence of the header
    And I check for the presence of the footer
    And I check for the presence of the search bar
    And I check for the presence of the main content area
    Then I should see all UI elements displayed correctly on the main page