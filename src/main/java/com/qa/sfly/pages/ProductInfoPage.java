package com.qa.sfly.pages;

import com.qa.sfly.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;
import java.util.List;

public class ProductInfoPage {
    private  WebDriver driver;
    private ElementUtil elementutil;

    private final By noOfImages =By.cssSelector("ul.thumbnails > li");

    private final By productHeader =By.cssSelector("div[class='col-sm-4'] h1");

    private final By  productMetaData =By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");

    private final By  productPrice =By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");


    LinkedHashMap<String,Object> productMap;


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

    public LinkedHashMap<String,Object> getProductDetailMap(){
        productMap = new LinkedHashMap<>();
        productMap.put("productHeader",getProductHeaderInfo());
        productMap.put("productImages",getImagesOfProduct());
        getProductMetaData();
        getProductPrice();
return productMap;
    }


    private void getProductMetaData(){
      List<WebElement> metadata= elementutil.getWebElements(productMetaData,10);
        System.out.println("No of elements " +metadata.size());
      for (WebElement elee : metadata){
          System.out.println(elee.getText() );
          String[] data= elee.getText().split(":");
          String valueKey = data[0];
          String valueOfKey = data[1].trim();
          productMap.put(valueKey,valueOfKey);
          productMap.put("productImages",getImagesOfProduct());
          System.out.println(productMap);

      }

    }
    private void getProductPrice(){
        List<WebElement> webElements = elementutil.getWebElements(productPrice, 10);
        String priceOfProduct = webElements.get(0).getText();
        String priceTaxOfProduct = webElements.get(1).getText();
        productMap.put("productPrice",priceOfProduct);
        productMap.put("extraPrice",priceTaxOfProduct);
        System.out.println("=="+productMap);
    }
}
