```java
package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.*;

public class KAN6TestPage {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Locators
    private By someElement = By.id("someElementId"); // TODO: Verify locator

    public KAN6TestPage() {
        driver.get("http://localhost:3000");
    }

    @Given("the user navigates to the main page URL")
    public void navigateToMainPage() {
        driver.navigate().to("http://localhost:3000");
        waitForPageLoad();
    }

    @Then("the main page loads displaying all UI elements correctly")
    public void validateMainPageUILoads() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(someElement));
        // TODO: Add assertions to validate all necessary elements
    }

    @When("the browser screen resolution is set to minimum supported size")
    public void setMinimumScreenResolution() {
        driver.manage().window().setSize(new Dimension(800, 600)); // Example for minimum size, adjust as necessary
    }

    @Then("main page UI elements adjust and display correctly at the minimum resolution")
    public void checkUIAtMinResolution() {
        waitForPageLoad();
        // TODO: Add assertions to check UI elements adjust correctly
    }

    @Given("the user accesses the main page without being logged in")
    public void accessMainPageWithoutLogin() {
        driver.navigate().to("http://localhost:3000");
        waitForPageLoad();
    }

    @Then("sensitive user data is not visible or accessible")
    public void ensureNoSensitiveDataExposed() {
        // TODO: Check elements to ensure no sensitive information is visible
        Assertions.assertFalse(driver.getPageSource().contains("sensitiveData"));
    }

    @When("the user enters SQL injection code into input fields on the main page")
    public void testSQLInjection() {
        WebElement inputField = driver.findElement(By.id("inputFieldId")); // TODO: Verify locator
        inputField.sendKeys("'; DROP TABLE users; --");
        inputField.submit();
    }

    @Then("the application handles the input safely and does not execute unintended operations")
    public void checkSQLInjectionHandling() {
        waitForPageLoad();
        // TODO: Validate that SQL injection code did not execute
    }

    private void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```