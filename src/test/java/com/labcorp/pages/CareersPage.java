package com.labcorp.pages;

import com.labcorp.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CareersPage {

    WebDriver driver= DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private By SearchBox = By.id("typehead");
    private By searchButton = By.id("ph-search-backdrop");
    private By automationJob =
            By.xpath("//a[@data-ph-at-id='job-link']");

    public void searchJob(String jobName, String jobTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement search =
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchBox));

        search.click();
        search.sendKeys(jobName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();

        List<WebElement> jobs = driver.findElements(automationJob);
        for(WebElement job:jobs){
            if(job.getText().trim().equalsIgnoreCase(jobTitle)){
                System.out.println("Clicking: " + job.getText());
                job.click();

                break;
            }
        }


    }

}
