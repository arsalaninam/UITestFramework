package com.ppro.testcase;

import com.ppro.base.TestBase;
import com.ppro.data.dataprovider.SimulationPaymentPageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ppro.constant.LogConstant.*;

public class SimulationPaymentPageTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(SimulationPaymentPageTest.class);

    /*****************************************************************************************************************
     * Test Case : Test to verify that user is able to see "Transaction Succeded" message on Screen with valid
     * payment combinations.
     *
     * - Navigate to the URL https://automation-test-exercise.netlify.app/
     * - User enters the valid amount, valid country, and valid currency combinations for the desired payment
     * - User clicks 'Pay' button
     * - Assert that user is able to see "Transaction Succeeded" message on the page
     ****************************************************************************************************************/

    @Test(dataProvider = "validPaymentInputCombinationsWithResultMessage", dataProviderClass = SimulationPaymentPageData.class)
    public void testUserIsAbleToSeeSuccessfulTransactionMessageWithValidPaymentInputCombinations(String amount, String currency,
                                                                                       String country, String expectedMessage) {

        log.info(TEST_TRANSACTION_SUCCEEDED_MESSAGE_IS_DISPLAYED_WITH_VALID_INPUT_COMBINATIONS);

        simulationPaymentPage.enterAmount(amount);
        simulationPaymentPage.selectCurrencyFromDropDown(currency);
        simulationPaymentPage.selectCountryFromDropDown(country);
        simulationPaymentPage.clickPayButton();
        String actualMessage = simulationPaymentPage.getTransactionResultMessage();

        Assert.assertEquals(actualMessage, expectedMessage);
    }


    /*****************************************************************************************************************
     * Test Case : Test to verify that user is able to see "Transaction Failed" message on Screen with invalid
     * payment combinations.
     *
     * - Navigate to the URL https://automation-test-exercise.netlify.app/
     * - User enters the valid amount, invalid country and invalid currency combinations for the desired payment
     * - User clicks 'Pay' button
     * - Assert that user is able to see "Transaction Failed" message on the page
     ****************************************************************************************************************/

    @Test(dataProvider = "invalidPaymentInputCombinationsWithResultMessage", dataProviderClass = SimulationPaymentPageData.class)
    public void testUserIsAbleToSeeFailedTransactionMessageWithValidPaymentInputCombinations(String amount, String invalidCurrency,
                                                                                             String invalidCountry, String expectedMessage) {

        log.info(TEST_TRANSACTION_FAILED_MESSAGE_IS_DISPLAYED_WITH_INVALID_INPUT_COMBINATIONS);

        simulationPaymentPage.enterAmount(amount);
        simulationPaymentPage.selectCurrencyFromDropDown(invalidCurrency);
        simulationPaymentPage.selectCountryFromDropDown(invalidCountry);
        simulationPaymentPage.clickPayButton();
        String actualMessage = simulationPaymentPage.getTransactionResultMessage();

        Assert.assertEquals(actualMessage, expectedMessage);
    }


    /*****************************************************************************************************************
     * Test Case : Test to verify that user is able to see "Transaction Failed" message on Screen with invalid
     * amount but valid country and currency combination.
     *
     * - Navigate to the URL https://automation-test-exercise.netlify.app/
     * - User enters the invalid amount but valid country and valid currency combinations for the desired payment
     * - User clicks 'Pay' button
     * - Assert that user is able to see "Transaction Failed" message on the page
     ****************************************************************************************************************/

    @Test(dataProvider = "invalidAmountButValidCountryAndCurrencyCombinationsWithResultMessage",
            dataProviderClass = SimulationPaymentPageData.class)
    public void testUserIsAbleToSeeFailedTransactionMessageWithInvalidAmountButValidCountryAndCurrentcyInputCombinations(String amount,
                                                                                                                         String invalidCurrency,
                                                                                                                         String invalidCountry,
                                                                                                                         String expectedMessage) {

        log.info(TEST_TRANSACTION_FAILED_MESSAGE_IS_DISPLAYED_WITH_INVALID_AMOUNT_BUT_VALID_COUNTRY_AND_CURRENCY_COMBINATIONS);

        simulationPaymentPage.enterAmount(amount);
        simulationPaymentPage.selectCurrencyFromDropDown(invalidCurrency);
        simulationPaymentPage.selectCountryFromDropDown(invalidCountry);
        simulationPaymentPage.clickPayButton();
        String actualMessage = simulationPaymentPage.getTransactionResultMessage();

        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
