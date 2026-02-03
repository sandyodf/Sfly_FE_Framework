package com.qa.sfly.factory;

import com.qa.sfly.exceptions.BrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    WebDriver driver;
    Properties prop;

    public WebDriver initiateBrowser(Properties props) {
        String browser = props.getProperty("browser").toLowerCase();
        switch (browser.trim().toLowerCase()) {
            case "chrome":
                OptionsManger op = new OptionsManger(props);
                driver = new ChromeDriver(op.getChromeOptionsValue());
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Invalid browser " + browser);
                throw new BrowserException("Invalid browser");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("loginUrl"));
        return driver;

    }

    public Properties initProp() {
        prop = new Properties();
        try {
            FileInputStream fo = new FileInputStream("src/main/resources/config/config.properties");
            prop.load(fo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

}
