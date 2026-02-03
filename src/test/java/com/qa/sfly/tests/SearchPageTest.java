package com.qa.sfly.tests;

import com.qa.sfly.base.BaseTest;
import com.qa.sfly.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class SearchPageTest extends BaseTest {

    @BeforeClass
    public void accountLogin() {
        homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void selectProductHeaderTest() {
        SearchPage macbook = homepage.searchForProduct("Macbook");
        pip = macbook.selectProduct("MacBook Air");
        String productHeaderInfo = pip.getProductHeaderInfo();
        Assert.assertEquals(productHeaderInfo, "MacBook Air");
    }

    @Test
    public void selectProductImagesTest() {
        int imagesCount = pip.getImagesOfProduct();
        Assert.assertEquals(imagesCount, 4);
        HashMap<String, Object> productDetailMap = pip.getProductDetailMap();
        System.out.println("test "+productDetailMap);
        SoftAssert sf = new SoftAssert();
        sf.assertEquals(productDetailMap.get("Brand"),"Apple");
        sf.assertEquals(productDetailMap.get("Product Code"),"Product 17");
        sf.assertEquals(productDetailMap.get("Reward Points"),"700");
        sf.assertEquals(productDetailMap.get("Availability"),"Out Of Stock!");
        sf.assertEquals(productDetailMap.get("productPrice"),"$1,202.00");
        sf.assertAll("Asserting all product values");

    }
}
