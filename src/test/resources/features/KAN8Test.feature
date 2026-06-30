Feature: Validate Apply Now Page Information Matches Job Details

  @KAN-8 @happy_path @smoke
  Scenario: Verify Job Details Match on Apply Now Page
    Given I am on the Job Details Page
    When I verify the job title, description, and requirements displayed
    And I click on the 'Apply Now' button
    Then I should be navigated to the Apply Now Page
    And the job title, description, and requirements should match those on the Job Details Page

  @KAN-8 @security_test @regression
  Scenario: Access Apply Now Page Without Authentication
    Given I open a new browser session
    When I navigate directly to the Apply Now Page URL
    Then I should be redirected to the login page or see an error message indicating that authentication is required