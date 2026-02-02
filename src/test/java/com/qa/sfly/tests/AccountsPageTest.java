package com.qa.sfly.tests;

import com.qa.sfly.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void loginSetup(){
        homepage=   loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void acc_pageTitle(){
        String pageTitle = homepage.getPageTitle();
        Assert.assertEquals(pageTitle,"My Account");
    }

    @Test
    public void acc_IsAccTest(){
        boolean Myc = homepage.isMyAccDisplayed();
        Assert.assertTrue(Myc);
    }
    @Test
    public void acc_IsMyOrderTest(){
        boolean acc_IsMyOrderTest = homepage.isMyOrderDisplayed();
        Assert.assertTrue(acc_IsMyOrderTest);

    }

    @Test
    public void searchProductTest(){
        searchpage= homepage.searchForProduct("Macbook");
     String searchTitle=   searchpage.getPageTitle();
        Assert.assertEquals(searchTitle,"Search - Macbook");
    }
    @Test
    public void selectProductTest(){
//        searchpage= homepage.searchForProduct("Macbook");
        searchpage.selectProduct("MacBook Air");
    }

}
