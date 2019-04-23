package com.poc.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.poc.utils.Services;

public class CheckboxesPage {
	static Logger logger = Logger.getLogger(CheckboxesPage.class.getName());

	final static String TXT_HEADING = "Checkboxes";
	static String xpathHeading = "//div[@class='example']/h3";

	WebDriver driver = null;
	Services services = null;
	String xpathCheckboxes = "//input";
	String xpathCheckboxIndex = "//input[**index**]";

	public CheckboxesPage(WebDriver driver) {
		logger.info("# CheckboxesPage - Constructor: " + driver);
		this.driver = driver;
		services = new Services(driver);
	}

	private void changeStatus(WebElement ele, boolean toSelect) {
		
		if (toSelect) {
			if (!ele.isSelected())
				ele.click();
			assertTrue(ele.isSelected(), "Checkbox is not Selecled.");
		} else {
			if (ele.isSelected())
				ele.click();
			assertFalse(ele.isSelected(), "Checkbox is Selecled.");
		}
	}

	public void clickOnCheckboxes() {

		services.waitForElement(xpathCheckboxes);
		WebElement ele = driver.findElement(By.xpath(xpathCheckboxes));
		ele.click();

	}

	public void selectAllChecboxes(boolean toSelect) {

		services.waitForElement(xpathCheckboxes);

		List<WebElement> eleList = driver.findElements(By.xpath(xpathCheckboxes));

		for (int i = 0; i < eleList.size(); i++) {
			System.out.println(eleList.get(i));
			changeStatus(eleList.get(i), toSelect);
		}

	}

	public void selectCheckboxes(int index, boolean toSelect) {

		String xpath = xpathCheckboxIndex.replace("**index**", index + "");

		services.waitForElement(xpath);

		WebElement ele = driver.findElement(By.xpath(xpath));
		changeStatus(ele, toSelect);

	}

	public void verifyCheckboxesPage() {

		WebElement eleHeading = driver.findElement(By.xpath(xpathHeading));
		String actualHeading = eleHeading.getText();
		assertEquals(actualHeading, TXT_HEADING,
				"Heading " + actualHeading + " should be same as expected " + TXT_HEADING);

	}

	public void verifyCheckboxStatus(int index, boolean isSelected) {
		String xpath = xpathCheckboxIndex.replace("**index**", index + "");
		assertTrue(driver.findElement(By.xpath(xpath)).isSelected() == isSelected);
	}

	public void verifyAllCheckboxStatus(boolean isSelected) {
		List<WebElement> chkbxs = driver.findElements(By.xpath(xpathCheckboxes));
		for (WebElement chkbx : chkbxs)
			assertTrue(chkbx.isSelected() == isSelected);
	}

}
