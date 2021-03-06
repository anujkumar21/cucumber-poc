package com.poc.pages;

import com.poc.utils.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;


public class WelcomePage {
    final static String EXPECTED_HEADING = "Welcome to the-internet";
    final static String EXPECTED_TITLE = "The Internet";
    private static final Logger logger = LogManager.getLogger(WelcomePage.class);
    final String xpathLink = "//ul/li/a";
    WebDriver driver;
    Services services;
    String xpathLinkUsingAttribute = "//a[contains(@href,'**lnkTxt**')]";
    String xpathLinkUsingIndex = "//ul/li[**index**]/a"; // ul/li[1]/a
    String xpathLinkUsingText = "//ul/li/a[text()='**lnkTxt**']"; //////// preferred

    public WelcomePage(WebDriver driver) {
        logger.info("# WelcomePage - Constructor: " + driver);
        this.driver = driver;
        this.services = new Services(driver);
    }

    public void clickOnLinkText(String lnkTxt) {
        logger.info("# Clicking on link: " + lnkTxt);
        WebElement linkEle = driver.findElement(By.linkText(lnkTxt)); // Link Text
        linkEle.click();
    }

    public void clickOnLinkUsingXpath() {
        logger.info("# Clicking on Link using XPATH ");
        services.clickOnElement(xpathLink); // Using XPATH
    }

    public void clickOnLinkUsingXpath(int index) {
        logger.info("# Clicking on Link using XPATH ");

        String xpath = xpathLinkUsingIndex.replace("**index**", index + "");
        logger.info("# Xpath buy Index: " + xpath);
        services.clickOnElement(xpath); // Using XPATH index
    }

    /**
     * This method is to click on the link by xpath
     *
     * @param lnkTxt visible link text.
     */
    public void clickOnLinkUsingXpath(String lnkTxt) {
        logger.info("# Clicking on Link using XPATH ");
        String xpath1 = xpathLinkUsingText.replace("**lnkTxt**", lnkTxt);
        logger.info("# Xpath buy Link Text: " + xpath1);
        services.clickOnElement(xpath1); // Using XPATH
    }

    public void clickOnLinkUsingXpathAttribute(String lnkTxt) {
        logger.info("# Clicking on Link using XPATH & Attribute.");
        String xpath2 = xpathLinkUsingAttribute.replace("**lnkTxt**", lnkTxt);
        logger.info("# Xpath by Link Text: " + xpath2);
        services.clickOnElement(xpath2); // Using XPATH
    }

    public void clickOnPartialLinkText(String lnkTxt) {
        logger.info("# Clicking on Partial Link: " + lnkTxt);
        WebElement linkEle = driver.findElement(By.partialLinkText(lnkTxt)); // Partial Link Text
        linkEle.click();
    }

    /**
     * Verifying Welcome page heading.
     */
    public void verifyWelcomePageHeading() {

        WebElement headingEle = driver.findElement(By.className("heading")); // Class Name

        String actualHeading = headingEle.getText();
        assertEquals(EXPECTED_HEADING, actualHeading);
    }

    public void verifyWelcomePageTitle() {

        String actualTitle = driver.getTitle();
        logger.info("# Title: " + actualTitle);
        assertEquals(EXPECTED_TITLE, actualTitle);
    }

}
