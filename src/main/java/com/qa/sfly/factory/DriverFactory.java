package com.qa.sfly.factory;

import com.qa.sfly.exceptions.BrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    WebDriver driver;

    public WebDriver initiateBrowser(String browser){

        switch (browser.trim().toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Invalid browser "+browser);
                throw  new BrowserException("Invalid browser");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        return driver;

    }

}
