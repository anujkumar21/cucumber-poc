package com.poc.pages;

import com.poc.utils.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;


public class CheckboxesPage {
    final static String TXT_HEADING = "Checkboxes";
    private static final Logger logger = LogManager.getLogger(CheckboxesPage.class);
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
            assertTrue(ele.isSelected());
        } else {
            if (ele.isSelected())
                ele.click();
            assertFalse(ele.isSelected());
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
        assertEquals(TXT_HEADING, actualHeading);

    }

    public void verifyCheckboxStatus(int index, boolean isSelected) {
        String xpath = xpathCheckboxIndex.replace("**index**", index + "");
        assertEquals(driver.findElement(By.xpath(xpath)).isSelected(), isSelected);
    }

    public void verifyAllCheckboxStatus(boolean isSelected) {
        List<WebElement> chkbxs = driver.findElements(By.xpath(xpathCheckboxes));
        for (WebElement chkbx : chkbxs)
            assertEquals(chkbx.isSelected(), isSelected);
    }

}
