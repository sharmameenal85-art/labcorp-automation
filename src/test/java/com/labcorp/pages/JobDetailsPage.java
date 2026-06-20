package com.labcorp.pages;

import com.labcorp.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobDetailsPage {
    WebDriver driver= DriverFactory.getDriver();
    private By jobTitle = By.cssSelector("h1.job-title");

    private By applyNowButton = By.xpath("//button[contains(text(),'Apply Now')]");
    private By jobType = By.cssSelector("au-target job-category");
    private By jobDescription = By.cssSelector("au-target job-description");
    private By jobId = By.xpath("//*[contains(text(),'2617100')]");
    private By ApplyNow= By.xpath("//*[@data-ph-at-id='apply-text']");

    public String getJobTitle() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(jobTitle)
        ).getText();
    }
    public String getJobId() {
        return driver.findElement(jobId).getText().trim();
    }
    public String getJobDescription(){
        return driver.findElement(jobDescription).getText();
    }


    public void clickApplyNowButton(){
        driver.findElement(ApplyNow).click();
    }

}
