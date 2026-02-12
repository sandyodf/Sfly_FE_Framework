package com.qa.sfly.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Flipkart {


    @Test
    public void flipkartLoginTest(){

        By wishlist =By.xpath("//a[contains(@href,'orders')]/../following-sibling::li/a[contains(@href,'wish')]");
       By loginbutton =By.linkText("Login");

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/account/login?ret=%2Faccount%2F%3Frd%3D0%26link%3Dhome_account");
        WebElement loginMenu = driver.findElement(loginbutton);


        Actions actions = new Actions(driver);
        actions.moveToElement(loginMenu).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myProfile = wait.until(ExpectedConditions
                .visibilityOfElementLocated(wishlist));

        myProfile.click();   // normal Selenium click

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]"))).sendKeys("9492215736");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //button[text()='Request OTP']"))).click();


    }
}
