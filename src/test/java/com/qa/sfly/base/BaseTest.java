package com.qa.sfly.base;

import com.qa.sfly.factory.DriverFactory;
import com.qa.sfly.pages.AccountsPage;
import com.qa.sfly.pages.LoginPage;
import com.qa.sfly.pages.ProductInfoPage;
import com.qa.sfly.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    protected  Properties prop;
    DriverFactory driverfactory;
    protected LoginPage loginpage;

    protected AccountsPage homepage;

    protected SearchPage searchpage;

    protected ProductInfoPage pip;

    @BeforeTest
    public void setup() {
        driverfactory = new DriverFactory();
        prop = driverfactory.initProp();
        driver = driverfactory.initiateBrowser(prop);

        loginpage = new LoginPage(driver);
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
