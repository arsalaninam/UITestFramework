package com.ppro.page;

import com.ppro.base.TestBase;
import com.ppro.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimulationPaymentPage extends TestBase {

    public SimulationPaymentPage()  {
        PageFactory.initElements(driver, this);
    }

    /********************************************************************************
     * Defining Page Factory : Object Repository of Simulation Payment Page
     ********************************************************************************/

    @FindBy(id = "amount")
    private WebElement amountTextBox;

    @FindBy(id= "currency")
    private WebElement currencyDropDown;

    @FindBy(id = "country")
    private WebElement countryDropDown;

    @FindBy(xpath = "//button[contains(text(),\"Pay\")]")
    private WebElement payButton;

    @FindBy(xpath = "//p[@id='pay']")
    private WebElement transactionResultMessage;

    /*************************************************
     * Methods : Actions of Simulation Payment Page
     *************************************************/

    public String getPageTitle() {
        TestUtil.waitForVisibilityOfElement(driver, amountTextBox);
        return driver.getTitle();
    }

    public void enterAmount(String amount){
        TestUtil.sendKeysToTextBox(driver, amountTextBox, amount);
    }

    public void selectCurrencyFromDropDown(String value){
        TestUtil.selectValueFromDropdown(driver, currencyDropDown, value);
    }

    public void selectCountryFromDropDown(String value){
        TestUtil.selectValueFromDropdown(driver, countryDropDown, value);
    }

    public void clickPayButton(){
        TestUtil.waitForElementToBeClickable(driver, payButton);
        payButton.click();
    }

    public String getTransactionResultMessage(){
        TestUtil.waitForVisibilityOfElement(driver, transactionResultMessage);
        return transactionResultMessage.getText();
    }

}
