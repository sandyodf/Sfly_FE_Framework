package com.qa.sfly.pages;

import com.qa.sfly.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class ProductInfoPage {
    private  WebDriver driver;
    private ElementUtil elementutil;

    private final By noOfImages =By.cssSelector("ul.thumbnails > li");

    private final By productHeader =By.cssSelector("div[class='col-sm-4'] h1");

    private final By  productMetaData =By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");

    private final By  productPrice =By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");


    HashMap<String,Object> productMap;

    public ProductInfoPage(WebDriver driver) {
        this.driver =driver;
        this.elementutil = new ElementUtil(this.driver);
    }

    public int getImagesOfProduct(){
     return elementutil.getWebElements(noOfImages,10).size();

    }

    public String getProductHeaderInfo(){
        return elementutil.getWebElement(productHeader).getText();
    }


    public void getProductMetaData(){
      List<WebElement> metadata= elementutil.getWebElements(productMetaData,10);

      for (WebElement elee : metadata){
         String[] data= elee.getText().split(":");
          System.out.println("Dd"+data[0]);
          System.out.println("Dd"+data[1]);
      }

    }

}
