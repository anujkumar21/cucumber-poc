package com.poc.pages;

import com.poc.utils.Services;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;


/**
 * @author AnujKumar
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
        assertEquals(expectedOption, actualOption);
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

        assertEquals(visibleTxt, actualOption);
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
        assertEquals(expectedOption, actualOption);
    }

    /**
     * This function is to verify dropdown page heading.
     */
    public void verifyDropDownPage() {

        Services services = new Services(driver);
        services.waitForElement(xpathHeading);

        WebElement element = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = element.getText();
        assertEquals(HEADING, actualHeading);

    }

    public void verifySelectOptioInDropDown(String expectedOpt) {
        WebElement element = driver.findElement(By.xpath(xpathDropdown));
        Select select = new Select(element);
        assertEquals(expectedOpt, select.getFirstSelectedOption().getText());
    }

}
