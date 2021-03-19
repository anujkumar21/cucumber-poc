package com.poc.stepDefinitions;

import com.poc.pages.PageFactory;
import com.poc.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver driver;
    PageFactory pageFactory;

    @Before
    public void setUp() {
        driver = DriverManager.getWebDriver();
        PageFactory.setInstance(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Given("Launch application")
    public void launch_application() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", null); // stick it in the report
        }
        DriverManager.removeWebDriver();
    }

}
