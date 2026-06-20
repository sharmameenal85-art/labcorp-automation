package com.labcorp.runners;

import com.labcorp.pages.ApplyPage;
import com.labcorp.pages.CareersPage;
import com.labcorp.pages.HomePage;
import com.labcorp.pages.JobDetailsPage;
import com.labcorp.utils.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class careersTest {

    @Test
    public void navigateToCareer() throws InterruptedException {
        WebDriver driver= DriverFactory.getDriver();
        HomePage   homePage = new HomePage();
        CareersPage careersPage = new CareersPage();



        homePage.openHomePage();
       homePage.acceptCookies();
        homePage.clickCareers();

        //Search for Job
        careersPage.searchJob("Automation Engineer", "Lead Test Automation Engineer");


        //Captures values in test
        JobDetailsPage jobDetailsPage = new JobDetailsPage();

        String jobTitle = jobDetailsPage.getJobTitle();
//        String jobID = jobDetailsPage.getJobId();

        System.out.println("Job Title: " + jobTitle);

        //Assert Value
        Assert.assertEquals("Lead Test Automation Engineer", jobTitle);
        jobDetailsPage.clickApplyNowButton();


        //Apply page assertions
        ApplyPage applyPage   = new ApplyPage();
 //       applyPage.acceptCookies();
     Thread.sleep(5000);

      Assert.assertEquals("Start Your Application", applyPage.getApplicationHeader());
       Assert.assertEquals("Lead Test Automation Engineer", applyPage.getJobTitle());


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverFactory.quitDriver();

    }
}
