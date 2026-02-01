package com.qa.sfly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private final By email_txt = By.id("input-email");
    private final By password_txt = By.id("input-password");
    private final By forgotPassword = By.partialLinkText("Forgotten Password");
    private  final By submitBtn = By.xpath("//input[@type='submit']");

    private final By newCustomerText = By.xpath("//p[contains(text(),'By creating an account')]");

//    deepu.odf1@yopmail.com/Sandy@123
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public String getPageTitle(){
        System.out.println("Page title is : "+ driver.getTitle());
        return driver.getTitle();
    }

    public String getPageUrl(){
        System.out.println("Page url is : "+ driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    public String getNewCustText(){
        return driver.findElement(newCustomerText).getText();
    }

    public boolean isForgotPasswordLinkDisplayed(){
        return driver.findElement(forgotPassword).isDisplayed();
    }

    public  String doLogin(String username , String password){
        driver.findElement(email_txt).sendKeys(username);
        driver.findElement(password_txt).sendKeys(password);
        driver.findElement(submitBtn).click();
        return getPageTitle();
    }
}