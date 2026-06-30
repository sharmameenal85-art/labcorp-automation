package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class KAN8TestPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By jobTitleLocator = By.id("job-title"); // TODO: Verify the correct selector
    private By jobDescriptionLocator = By.id("job-description"); // TODO: Verify the correct selector
    private By jobRequirementsLocator = By.id("job-requirements"); // TODO: Verify the correct selector
    private By applyNowButtonLocator = By.id("apply-now-button"); // TODO: Verify the correct selector
    private By loginPageIdentifier = By.id("login-form"); // TODO: Verify the correct selector

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Navigate to the Job Details Page
    public void navigateToJobDetailsPage(String jobDetailsURL) {
        driver.get(jobDetailsURL);
    }

    // Verify job title, description, and requirements
    public void verifyJobDetails(String expectedTitle, String expectedDescription, String expectedRequirements) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleLocator));
        String actualTitle = driver.findElement(jobTitleLocator).getText();
        String actualDescription = driver.findElement(jobDescriptionLocator).getText();
        String actualRequirements = driver.findElement(jobRequirementsLocator).getText();

        Assertions.assertEquals(expectedTitle, actualTitle, "Job title does not match");
        Assertions.assertEquals(expectedDescription, actualDescription, "Job description does not match");
        Assertions.assertEquals(expectedRequirements, actualRequirements, "Job requirements do not match");
    }

    // Click on 'Apply Now' button and navigate to the Apply Now page
    public void clickApplyNowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(applyNowButtonLocator)).click();
    }

    // Verify the job details on Apply Now Page
    public void verifyApplyNowPageJobDetails(String expectedTitle, String expectedDescription, String expectedRequirements) {
        verifyJobDetails(expectedTitle, expectedDescription, expectedRequirements);
    }

    // Test scenario for happy path
    @Test
    public void testVerifyJobDetailsMatchOnApplyNowPage() {
        String jobDetailsURL = "http://localhost:3000/job-details"; // TODO: Verify the correct URL
        String expectedTitle = "Sample Job Title"; // TODO: Verify the correct job title
        String expectedDescription = "Sample Job Description"; // TODO: Verify the correct job description
        String expectedRequirements = "Sample Job Requirements"; // TODO: Verify the correct job requirements

        // Navigate to Job Details Page and verify details
        navigateToJobDetailsPage(jobDetailsURL);
        verifyJobDetails(expectedTitle, expectedDescription, expectedRequirements);

        // Click 'Apply Now' and verify details on Apply Now Page
        clickApplyNowButton();
        verifyApplyNowPageJobDetails(expectedTitle, expectedDescription, expectedRequirements);
    }

    // Test scenario for security test
    @Test
    public void testAccessApplyNowPageWithoutAuthentication() {
        String applyNowPageURL = "http://localhost:3000/apply-now"; // TODO: Verify the correct URL

        // Directly navigate to Apply Now Page without authentication
        driver.get(applyNowPageURL);

        // Verify if redirected to login page or shown an error due to lack of authentication
        boolean isLoginPageDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageIdentifier)).isDisplayed();
        Assertions.assertTrue(isLoginPageDisplayed, "User was not redirected to the login page as expected.");
    }
}