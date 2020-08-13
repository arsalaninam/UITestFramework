package com.ppro.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ppro.constant.TestConstant.PAGE_LOAD_TIMEOUT;

public class TestUtil {

    /************************************************************************************************
     * Explicit Wait for visibility of an element
     *
     * @param driver - WebDriver instance
     * @param element - Element to be Displayed
     ************************************************************************************************/

    public static void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    /************************************************************************************************
     * Explicit Wait for element to be clickable
     *
     * @param driver - WebDriver instance
     * @param element - Element to be Clickable
     ************************************************************************************************/

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /************************************************************************************************
     * Explicit Wait for visibility of an element and enters text to the text box
     *
     * @param driver - WebDriver instance
     * @param element - Element to be Displayed
     * @param keys - Value to send in text box
     ************************************************************************************************/

    public static void sendKeysToTextBox(WebDriver driver, WebElement element, String keys) {
        waitForElementToBeClickable(driver, element);
        element.sendKeys(keys);
    }

    /************************************************************************************************
     *
     * @param driver - WebDriver instance
     * @param element - Dropdown WebElement
     * @param value - Value to be selected from dropdown list
     ************************************************************************************************/

    public static void selectValueFromDropdown(WebDriver driver, WebElement element, String value){
        TestUtil.waitForVisibilityOfElement(driver, element);
        Select currencyList = new Select(element);
        currencyList.selectByValue(value);
    }

}
