package com.labcorp.pages;

import com.labcorp.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver= DriverFactory.getDriver();

    private By careersLink= By.linkText("Careers");
    private By acceptCookies= By.id("onetrust-accept-btn-handler");


    public void openHomePage() {
        driver.get("https://www.labcorp.com");
    }

    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.elementToBeClickable(acceptCookies))
                .click();
    }

    public void clickCareers() {
        driver.findElement(careersLink).click();
//        driver.switchTo().alert().dismiss();
    }



}
