package com.qa.sfly.pages;

import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getPageTitle() {
        System.out.println("search Page title is : " + driver.getTitle());
        return driver.getTitle();
    }
}
