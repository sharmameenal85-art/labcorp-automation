Feature: Automate REST API Validation Using REST Assured

  @KAN-9 @happy_path @smoke
  Scenario: Verify API returns successful response for valid request
    Given an API endpoint with valid parameters
    When a GET request is sent to the API
    Then the response status code should be 200
    And the response body should contain the expected data

  @KAN-9 @negative_tests @regression
  Scenario: Verify API responds with error for invalid parameters
    Given an API endpoint with invalid parameters
    When a GET request is sent to the API
    Then the response status code should be 400 or an appropriate error code
    And an error message should be returned in the response

  @KAN-9 @ui_validations @regression
  Scenario: Verify UI layout and alignment on different devices
    Given access to the UI page on various devices and screen sizes
    When observing the layout and alignment of UI components
    Then the UI layout and elements should be consistently aligned across devices
    And there should be no overlap or misalignment of elements