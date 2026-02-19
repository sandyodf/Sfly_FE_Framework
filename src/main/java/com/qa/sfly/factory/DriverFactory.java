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

public class  DriverFactory {
    WebDriver driver;
    Properties prop;

    public WebDriver initiateBrowser(Properties props) {
        String browser = props.getProperty("browser").toLowerCase();
        System.out.println("browser is envoked using ngrok "+browser);
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

        String envName = System.getProperty("env");
        FileInputStream ip = null;
        prop = new Properties();

        try {
            if (envName == null) {
                // System.out.println("env is null, hence running the tests on QA env by
                // default...");
//                log.warn("env is null, hence running the tests on QA env by default...");
                ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
            } else {
                System.out.println("Running tests on env: " + envName);
//                log.info("Running tests on env: " + envName);
                switch (envName.toLowerCase().trim()) {
                    case "qa":
                        ip = new FileInputStream("src/main/resources/config/configqa.properties");
                        break;
                    case "dev":
                        ip = new FileInputStream("src/main/resources/config/configdev.properties");
                        break;
//                    case "stage":
//                        ip = new FileInputStream("src/main/resources/config/configqa.properties");
//                        break;
//                    case "uat":
//                        ip = new FileInputStream("src/test/resources/config/uat.config.properties");
//                        break;
                    case "prod":
                        ip = new FileInputStream("src/main/resources/config/configprod.properties");
                        break;

                    default:
//                        log.error("----invalid env name---" + envName);
//                        throw new FrameworkException("===INVALID ENV NAME==== : " + envName);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
