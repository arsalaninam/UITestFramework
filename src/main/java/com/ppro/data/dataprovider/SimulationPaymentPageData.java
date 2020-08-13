package com.ppro.data.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * A data provider class to provide test data for Simulation Payment Page related test cases
 *
 * @author Arsalan Inam
 */
public class SimulationPaymentPageData {

    @DataProvider
    public static Object[][] validPaymentInputCombinationsWithResultMessage() {
        return new Object[][]{
                {"100", "EUR", "DE", "Transaction Succeded"},
                {"10000000000", "EUR", "DE", "Transaction Succeded"},
                {"100000000000000000000000", "EUR", "DE", "Transaction Succeded"}
        };
    }

    @DataProvider
    public static Object[][] invalidPaymentInputCombinationsWithResultMessage() {
        return new Object[][]{
                {"100", "AUD", "DE", "Transaction Failed"},
                {"100", "SGD", "DE", "Transaction Failed"},
                {"100", "EUR", "AU", "Transaction Failed"},
                {"100", "AUD", "AU", "Transaction Failed"},
                {"100", "SGD", "AU", "Transaction Failed"},
                {"100", "EUR", "SG", "Transaction Failed"},
                {"100", "AUD", "SG", "Transaction Failed"},
                {"100", "SGD", "SG", "Transaction Failed"}
        };
    }

    @DataProvider
    public static Object[][] invalidAmountButValidCountryAndCurrencyCombinationsWithResultMessage() {
        return new Object[][]{
                {"0", "EUR", "DE", "Transaction Failed"},
                {"-1", "EUR", "DE", "Transaction Failed"},
                {"-10000", "EUR", "DE", "Transaction Failed"}
        };
    }
}