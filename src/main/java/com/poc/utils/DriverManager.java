package com.poc.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null)
            driver = new FirefoxDriver();
        return driver;
    }

    public static void removeWebDriver() {

        if (DriverManager.driver != null) {
            driver.quit();
            DriverManager.driver = null;
        }
    }

}
