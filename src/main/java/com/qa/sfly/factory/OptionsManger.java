package com.qa.sfly.factory;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class OptionsManger {
     Properties optionsProps;

    public OptionsManger(Properties optionsProps) {
        this.optionsProps = optionsProps;
    }

    public ChromeOptions getChromeOptionsValue(){
        ChromeOptions co = new ChromeOptions();

        if (Boolean.parseBoolean(optionsProps.getProperty("headless"))){
            co.addArguments("--headless");
        }
        if (Boolean.parseBoolean(optionsProps.getProperty("incognito"))){
            co.addArguments("--incognito");
        }

        return co;

    }

}
