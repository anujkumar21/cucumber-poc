package com.poc.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Services {

	WebDriver driver = null;

	public Services(WebDriver driver) {
		this.driver = driver;// Now when we create instance of Services, we have to pass the driver, &
		// hence this driver value get initialized.
	}

	public String assertAndGetText(String locator) {
		waitForElement(locator);
		return driver.findElement(By.xpath(locator)).getText().trim();
	}

	public void assertAndTypeById(String locator, String txt) {
		waitForElementById(locator);
		driver.findElement(By.id(locator)).clear();
		driver.findElement(By.id(locator)).sendKeys(txt);
	}

	/**
	 * This function is to click on element.
	 * 
	 * @param xpath need xpath of the element.
	 */
	public void clickOnElement(String xpath) {
		waitForElement(xpath);
		WebElement ele = driver.findElement(By.xpath(xpath)); // Using XPATH
		ele.click();

	}

	/**
	 * This function is to check if element is present or not.
	 * 
	 * @param xpath String
	 * @return true or false
	 */
	public boolean isElementPresent(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * This function is to wait for particular element present on page.
	 * 
	 * @param locator xpath
	 */
	public void waitForElement(String locator) {

		System.out.println("# Waiting for element by xpath: " + locator);
		WebDriverWait wait = new WebDriverWait(driver, 30, 1);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

	}

	public void waitForElementById(String locator) {

		System.out.println("# Waiting for element by id: " + locator);
		WebDriverWait wait = new WebDriverWait(driver, 30, 1);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));

	}

}
