package com.poc.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public final class PageFactory {

    private static final Logger logger = LogManager.getLogger(PageFactory.class);
    private static PageFactory pageFactory;
    private WelcomePage welcomePage;
    private CheckboxesPage checkboxesPage;
    private DropdownPage dropdownPage;

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
