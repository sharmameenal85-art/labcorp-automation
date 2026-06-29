```java
package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.labcorp.utils.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class KAN6TestSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("the main page is opened")
    public void openMainPage() {
        driver.get("https://example.com/main"); // replace with the actual main page URL
    }

    @Then("ensure all UI elements are visible and properly displayed")
    public void validateAllUIElements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("header")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("footer")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("label")));
        // Additional assertions can be added to validate formatting
    }

    @When("invalid characters are entered into input fields")
    public void enterInvalidCharacters() {
        WebElement inputField = driver.findElement(By.id("inputField")); // replace with actual ID
        inputField.sendKeys("!@#$%^&*()");
    }

    @Then("application displays validation error messages")
    public void validationErrorMessages() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage"))); // replace with actual ID
        // Add assertions to verify error message
    }

    @When("maximum allowed characters are entered into an input field")
    public void enterMaxCharacters() {
        WebElement inputField = driver.findElement(By.id("inputField")); // replace with actual ID
        String maxChars = "a".repeat(255); // assuming 255 is the max for the example
        inputField.sendKeys(maxChars);
    }

    @Then("application accepts the input and handles it correctly")
    public void acceptsMaxInput() {
        // Perform assertions to ensure acceptance and proper handling
    }

    @When("minimum required characters are entered into an input field")
    public void enterMinCharacters() {
        WebElement inputField = driver.findElement(By.id("inputField")); // replace with actual ID
        inputField.sendKeys("abc"); // assuming 3 is the minimum requirement
    }

    @Then("application processes the input correctly")
    public void acceptsMinInput() {
        // Perform assertions to ensure correct processing
    }

    @When("SQL injection scripts are entered into input fields")
    public void enterSQLInjection() {
        WebElement inputField = driver.findElement(By.id("inputField")); // replace with actual ID
        inputField.sendKeys("'; DROP TABLE users; --");
    }

    @Then("application sanitizes input")
    public void sanitizedSQLInput() {
        // Verify SQL input is not executed, e.g., check for error messages or minimal logs
    }

    @When("attempting to access the main page without authentication")
    public void unauthorizedAccess() {
        // simulate unauthorized access
        driver.get("https://example.com/main");
    }

    @Then("access is denied and user is redirected to login")
    public void redirectedToLogin() {
        wait.until(ExpectedConditions.urlContains("login")); // verify redirect to login page
    }

    @When("user signs in with valid credentials and logs out")
    public void userSignsInAndOut() {
        WebElement loginButton = driver.findElement(By.id("loginButton")); // replace with actual ID
        loginButton.click();
        WebElement logoutButton = driver.findElement(By.id("logoutButton")); // replace with actual ID
        logoutButton.click();
    }

    @Then("user is redirected to login after logout")
    public void redirectToLoginAfterLogout() {
        wait.until(ExpectedConditions.urlContains("login")); // verify redirect to login page
    }

    @Then("verify all button labels are correct")
    public void verifyButtonLabels() {
        WebElement button = driver.findElement(By.id("submitButton")); // replace with actual ID
        assert button.getText().equals("Submit"); // replace with actual expected label
        // Continue with other buttons
    }

    @When("the page is opened on various devices")
    public void openPageOnVariousDevices() {
        // This would generally be handled by a responsive design check library or visual inspection
    }

    @Then("UI displays consistently")
    public void validateUILayout() {
        // Assert that responsive checks show consistency across devices, using tools or manual validation
    }
}
```