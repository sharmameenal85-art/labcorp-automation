package com.labcorp.pages;

import com.labcorp.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplyPage {

    WebDriver driver= DriverFactory.getDriver();


    private By applicationHeader =  By.cssSelector("h2.css-124gh4t");
    private By jobTitle = By.xpath("//*[@id=\"mainContent\"]/div/main/div/div/h3");
    private By acceptCookies=  By.cssSelector("button[data-automation-id='legalNoticeAcceptButton']");

    public ApplyPage() throws InterruptedException {
    }
    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                        ExpectedConditions.elementToBeClickable(acceptCookies))
                .click();
    }

    public String getApplicationHeader(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(applicationHeader)
        ).getText();
    }

    public String getJobTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitle)
        ).getText();

    }
}
