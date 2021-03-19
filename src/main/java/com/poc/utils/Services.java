package com.poc.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Services {
    private static final Logger logger = LogManager.getLogger(Services.class);

    private final WebDriver driver;
    private final WebDriverWait wait;

    public Services(WebDriver driver) {
        this.driver = driver;// Now when we create instance of Services, we have to pass the driver, &
        // hence this driver value get initialized.
        wait = new WebDriverWait(driver, 10, 1);
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
            logger.info("# Element is present by xpath: " + xpath);
            return true;
        } catch (NoSuchElementException ex) {
            logger.info("# Element is not present by xpath: " + xpath);
            return false;
        }
    }

    /**
     * This function is to wait for particular element present on page.
     *
     * @param locator xpath
     */
    public void waitForElement(String locator) {
        logger.info("# Waiting for element by xpath: " + locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        logger.info("# Got element by xpath: " + locator);
    }

    public void waitForElementById(String locator) {
        logger.info("# Waiting for element by id: " + locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
        logger.info("# Got element by id: " + locator);
    }

}
