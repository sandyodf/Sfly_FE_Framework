package com.qa.sfly.tests;

import com.qa.sfly.base.BaseTest;
import com.qa.sfly.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {

    @BeforeClass
    public void accountLogin(){
        homepage=  loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void selectProductHeaderTest(){
        SearchPage macbook = homepage.searchForProduct("Macbook");
        pip= macbook.selectProduct("MacBook Air");
        String productHeaderInfo = pip.getProductHeaderInfo();
        Assert.assertEquals(productHeaderInfo,"MacBook Air");
    }
    @Test
    public void selectProductImagesTest(){
      int imagesCount=  pip.getImagesOfProduct();
      Assert.assertEquals(imagesCount,4);
      pip.getProductMetaData();

    }
}
