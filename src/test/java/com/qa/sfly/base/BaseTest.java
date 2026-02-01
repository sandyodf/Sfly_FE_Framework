package com.qa.sfly.base;

import com.qa.sfly.factory.DriverFactory;
import com.qa.sfly.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver driver;
    DriverFactory driverfactory;
    protected LoginPage lp;

    @BeforeTest
    public void setup() {
        driverfactory = new DriverFactory();
        driver = driverfactory.initiateBrowser("chrome");
         lp = new LoginPage(driver);
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
