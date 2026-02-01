package com.qa.sfly.pages;

import com.qa.sfly.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {
    private WebDriver driver;

    private ElementUtil elem;

    private  final By MyOrders_link = By.xpath("//h2[text()='My Orders']");
    private  final By MyAccounts_link = By.xpath("//h2[text()='My Account']");

    private final By search_btn =By.name("search");

    private final By click_search =By.cssSelector("button[class='btn btn-default btn-lg']");





    public AccountsPage(WebDriver driver){
        this.driver = driver;
        this.elem = new ElementUtil(driver);

    }

    public String getPageTitle(){
        System.out.println("Accounts Page title is : "+ driver.getTitle());
        return driver.getTitle();
    }

    public boolean isMyAccDisplayed(){
        return elem.getWebElement(MyAccounts_link,10).isDisplayed();
    }

    public boolean isMyOrderDisplayed(){
        return elem.getWebElement(MyOrders_link,10).isDisplayed();
    }

    public SearchPage searchForProduct(String product){
        elem.getWebElement(search_btn).sendKeys(product);
        elem.getWebElement(click_search).click();
        return new SearchPage(driver);

    }
}
