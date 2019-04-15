package com.poc.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.poc.utils.Services;

/**
 * 
 * @author AnujKumar
 *
 */
public class DropdownPage {

	public static final String HEADING = "Dropdown List";
	public static String xpathDropdown = "//div[@class='example']//select";
	public static String xpathHeading = "//div[@class='example']//h3";
	WebDriver driver;

	public DropdownPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Select by Index
	 * 
	 * @param index
	 * @param expectedOption
	 */
	public void selectDropdown(int index, String expectedOption) {

		WebElement element = driver.findElement(By.xpath(xpathDropdown));
		Select select = new Select(element);
		select.selectByIndex(index);

		String actualOption = select.getFirstSelectedOption().getText();
		assertEquals(actualOption, expectedOption,
				"Actual " + actualOption + " should be same as expected " + expectedOption);
	}

	/**
	 * Select by Visible Text
	 * 
	 * @param visibleTxt
	 */
	public void selectDropdown(String visibleTxt) {

		WebElement element = driver.findElement(By.xpath(xpathDropdown));
		Select select = new Select(element);
		select.selectByVisibleText(visibleTxt);

		String actualOption = select.getFirstSelectedOption().getText();

		assertEquals(actualOption, visibleTxt, "Actual " + actualOption + " should be same as expected " + visibleTxt);
	}

	/**
	 * Select by Value
	 * 
	 * @param val
	 * @param expectedOption
	 */
	public void selectDropdown(String val, String expectedOption) {

		WebElement element = driver.findElement(By.xpath(xpathDropdown));
		Select select = new Select(element);
		select.selectByValue(val);

		String actualOption = select.getFirstSelectedOption().getText();
		assertEquals(actualOption, expectedOption,
				"Actual " + actualOption + " should be same as expected " + expectedOption);
	}

	/**
	 * This function is to verify dropdown page heading.
	 */
	public void verifyDropDownPage() {

		Services services = new Services(driver);
		services.waitForElement(xpathHeading);

		WebElement element = driver.findElement(By.xpath(xpathHeading));
		String actualHeading = element.getText();
		assertEquals(actualHeading, HEADING, "Actual " + actualHeading + " should be same as expected " + HEADING);

	}

}
