package com.example.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.time.Duration;

public class KAN9TestSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private Response response;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        RestAssured.baseURI = "http://yourapi.com"; // TODO: Replace with actual API base URI
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I send a GET request to the API endpoint with valid parameters")
    public void iSendGETRequestWithValidParameters() {
        response = RestAssured.given()
                .queryParam("param", "value") // TODO: Replace with actual parameters
                .when()
                .get("/yourEndpoint"); // TODO: Replace with actual endpoint
    }

    @Then("I receive a successful response with status code 200")
    public void iReceiveSuccessfulResponse() {
        response.then().statusCode(200);
    }

    @And("The response body contains expected data")
    public void responseBodyContainsExpectedData() {
        response.then().body("key", equalTo("expectedValue")); // TODO: Replace with actual key-value
    }

    @Given("I send a GET request to the API endpoint with invalid parameters")
    public void iSendGETRequestWithInvalidParameters() {
        response = RestAssured.given()
                .queryParam("invalidParam", "invalidValue") // TODO: Replace with actual invalid parameters
                .when()
                .get("/yourEndpoint"); // TODO: Replace with actual endpoint
    }

    @Then("I receive an error response with status code 400 or an appropriate error code")
    public void iReceiveErrorResponse() {
        response.then().statusCode(400); // TODO: Adjust status code if needed
    }

    @And("An error message is returned")
    public void errorMessageIsReturned() {
        response.then().body("error", notNullValue()); // TODO: Verify specific error message
    }

    @Given("I access the UI page on various devices and screen sizes")
    public void iAccessUIPageOnVariousDevices() {
        driver.get("http://yourapplication.com"); // TODO: Replace with actual application URL
    }

    @Then("I observe the layout and alignment of UI components")
    public void iObserveUILayout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header"))); // TODO: Use appropriate selector
        WebElement header = driver.findElement(By.id("header")); // TODO: Use appropriate selector
        Assertions.assertTrue(header.isDisplayed(), "Header is not displayed");

        // TODO: Add more assertions and selectors to check other UI elements
    }

    @And("UI layout and elements are consistently aligned across devices")
    public void uiLayoutConsistentlyAligned() {
        // Verify no overlap or misalignment occurs
        WebElement someElement = driver.findElement(By.id("someElement")); // TODO: Use correct locator
        Assertions.assertTrue(someElement.isDisplayed(), "UI element is misaligned or overlapped");
        // TODO: Add additional checks for various screen sizes/devices
    }
}