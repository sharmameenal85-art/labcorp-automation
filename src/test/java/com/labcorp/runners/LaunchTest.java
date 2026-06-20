package com.labcorp.runners;

import com.labcorp.utils.DriverFactory;
import org.junit.Test;

public class LaunchTest {


    @Test
    public void openLabCorp() {
        DriverFactory.getDriver()
        .get("https://www.labcorp.com");
        try {
            Thread.sleep(5000);

        } catch (Exception e) {
        }
        DriverFactory.quitDriver();
    }
}
