```java
package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.*;

public class KAN6TestPage {

    private WebDriver driver = new ChromeDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private By headerLocator = By.id("header"); // TODO: Verify the real selector
    private By footerLocator = By.id("footer"); // TODO: Verify the real selector
    private By searchBarLocator = By.id("search-bar"); // TODO: Verify the real selector
    private By mainContentLocator = By.id("main-content"); // TODO: Verify the real selector

    public KAN6TestPage() {
        driver.get("http://localhost:3000");
    }

    @Given("the user navigates to the main page")
    public void navigateToMainPage() {
        // Navigation is handled in the constructor
    }

    @Then("the header should be displayed")
    public void verifyHeaderDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        Assertions.assertTrue(driver.findElement(headerLocator).isDisplayed(), "Header is not displayed");
    }

    @Then("the footer should be displayed")
    public void verifyFooterDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(footerLocator));
        Assertions.assertTrue(driver.findElement(footerLocator).isDisplayed(), "Footer is not displayed");
    }

    @Then("the search bar should be displayed")
    public void verifySearchBarDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBarLocator));
        Assertions.assertTrue(driver.findElement(searchBarLocator).isDisplayed(), "Search bar is not displayed");
    }

    @Then("the main content area should be displayed")
    public void verifyMainContentDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainContentLocator));
        Assertions.assertTrue(driver.findElement(mainContentLocator).isDisplayed(), "Main content area is not displayed");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```