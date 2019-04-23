package com.poc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public final class PageFactory {

	static Logger logger = Logger.getLogger(PageFactory.class.getName());

	private WelcomePage welcomePage;
	private CheckboxesPage checkboxesPage;
	private DropdownPage dropdownPage;
	private static PageFactory pageFactory;

	private PageFactory(WebDriver driver) {
		logger.info("# PageFactory constructor - " + driver);
		welcomePage = new WelcomePage(driver);
		checkboxesPage = new CheckboxesPage(driver);
		dropdownPage = new DropdownPage(driver);
	}

	public static PageFactory getInstance() {
		return pageFactory;
	}

	public static void setInstance(WebDriver driver) {
		pageFactory = new PageFactory(driver);
	}

	public WelcomePage getWelcomePage() {
		return welcomePage;
	}

	public CheckboxesPage getCheckboxesPage() {
		return checkboxesPage;
	}

	public DropdownPage getDropdownPage() {
		return dropdownPage;
	}

}
