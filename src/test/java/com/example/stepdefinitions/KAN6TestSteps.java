```java
package com.example.stepdefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.*;

public class KAN6TestSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void setupClass() {
        // WebDriverManager setup for ChromeDriver can be done here if using WebDriverManager
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // For local setup
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I navigate to the main page")
    public void navigateToMainPage() {
        driver.get("http://example.com"); // TODO: Replace with the actual URL of the main page
    }
    
    @Then("I verify the presence of header, footer, search bar, and main content area")
    public void verifyUIElements() {
        // Verify header
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header"))); // TODO: Replace with actual ID or CSS selector for header
        
        // Verify footer
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer"))); // TODO: Replace with actual ID or CSS selector for footer
        
        // Verify search bar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-bar"))); // TODO: Replace with actual ID or CSS selector for search bar
        
        // Verify main content area
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".main-content"))); // TODO: Replace with actual CSS selector for main content area
    }
}
```