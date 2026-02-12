package com.qa.sfly.base;

import com.qa.sfly.factory.DriverFactory;
import com.qa.sfly.pages.AccountsPage;
import com.qa.sfly.pages.LoginPage;
import com.qa.sfly.pages.ProductInfoPage;
import com.qa.sfly.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    protected  Properties prop;
    DriverFactory driverfactory;
    protected LoginPage loginpage;

    protected AccountsPage homepage;

    protected SearchPage searchpage;

    protected ProductInfoPage pip;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserName) {
        driverfactory = new DriverFactory();
        prop = driverfactory.initProp();
        if (browserName !=null){
            prop.setProperty("browser",browserName);
        }
        driver = driverfactory.initiateBrowser(prop);

        loginpage = new LoginPage(driver);
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
