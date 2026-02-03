package com.qa.sfly.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtil {
  private  WebDriver driver;
    public ElementUtil(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getWebElement(By locator){
      return   driver.findElement(locator);

    }
  public WebElement getWebElement(By locator,int time){
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
    return   wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

  }

  public List<WebElement> getWebElements(By locator, int time){
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
    return   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

  }
}
