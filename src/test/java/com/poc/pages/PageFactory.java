package com.poc.pages;

import org.openqa.selenium.WebDriver;

public final class PageFactory {

	private WelcomePage welcomePage;
	private CheckboxesPage checkboxesPage;
	private DropdownPage dropdownPage;
	private static PageFactory pageFactory;

	private PageFactory(WebDriver driver) {
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
