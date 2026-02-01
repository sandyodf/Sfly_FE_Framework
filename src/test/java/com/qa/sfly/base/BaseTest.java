package com.qa.sfly.base;

import com.qa.sfly.factory.DriverFactory;
import com.qa.sfly.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Properties prop;
    DriverFactory driverfactory;
    protected LoginPage lp;

    @BeforeTest
    public void setup() {
        driverfactory = new DriverFactory();
        prop = driverfactory.initProp();
        driver = driverfactory.initiateBrowser(prop);

         lp = new LoginPage(driver);
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
