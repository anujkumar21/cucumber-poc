package com.poc.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Init {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.out.println("*** SETUP ***");

		System.out.println("Init - Driver: " + driver);
		// Initializing web driver
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // Implicit wait.

		System.out.println("Init - Driver: " + driver);
		driver.get("https://the-internet.herokuapp.com/");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("*** TEARDOWN ***");
		driver.quit();
	}

}
