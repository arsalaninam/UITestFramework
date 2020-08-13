package com.ppro.base;

import com.ppro.page.SimulationPaymentPage;
import com.ppro.util.WebEventListener;
import com.ppro.util.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.ppro.constant.TestConstant.IMPLICIT_WAIT;
import static com.ppro.constant.TestConstant.PAGE_LOAD_TIMEOUT;

public class TestBase extends PropertyReader {

    //WebDriver instance
    protected static WebDriver driver;

    //SimulationPage instance
    protected SimulationPaymentPage simulationPaymentPage;

    /******************************************************************************************
     * This method will load the browser name from properties file, opens that browser,
     * maximizes it, deletes the cookies, sets the timeouts of the page and will redirects to
     * desired url mentioned in the config.properties file.
     * Also, this method will register an event listener for WebDriver. It will help to log all
     * the activities automatically that are being performed by Selenium WebDriver.
     ******************************************************************************************/

    protected static void initialization() {

        String browserName = properties.getProperty("browserName");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
        WebEventListener eventListener = new WebEventListener();
        driver = e_driver.register(eventListener);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }

    /***********************************************************
     * This method will get executed before every test method
     **********************************************************/

    @BeforeMethod
    public void setUp() {
        initialization();
        simulationPaymentPage = new SimulationPaymentPage();
    }

    /***********************************************************
     * This method will get executed after every test method
     **********************************************************/

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
