package com.qa.sfly.pages;

import com.qa.sfly.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    private ElementUtil elem;

    public SearchPage(WebDriver driver) {
        this.driver=driver;
        this.elem = new ElementUtil(driver);
    }

    public String getPageTitle() {
        System.out.println("search Page title is : " + driver.getTitle());
        return driver.getTitle();
    }

    public ProductInfoPage selectProduct(String product){
        elem.getWebElement(By.linkText(product)).click();
        return new ProductInfoPage(driver);
    }
}
