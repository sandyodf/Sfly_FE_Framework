package com.qa.sfly.tests;

import com.qa.sfly.base.BaseTest;
import com.qa.sfly.pages.ProductInfoPage;
import com.qa.sfly.pages.SearchPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class SearchPageTest extends BaseTest {

    @BeforeClass
    public void accountLogin() {
        homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @DataProvider
    public Object[][] getProductInfoData(){

        return  new Object[][]{
                {"macbook","MacBook Air"},
//                {"macbook","MacBook"},
//                {"macbook","MacBook Pro"},
//                {"imac","iMac"},
//                {"samsung","Samsung SyncMaster 941BW"},
//                {"samsung","Samsung Galaxy Tab 10.1"},

        };

    }
    @DataProvider
    public Object[][] getPIPData(){

        return  new Object[][]{
                {"macbook","MacBook Air","Apple","Product 17","700","Out Of Stock!"},
//                {"macbook","MacBook"},
//                {"macbook","MacBook Pro"},
//                {"imac","iMac"},
//                {"samsung","Samsung SyncMaster 941BW"},
//                {"samsung","Samsung Galaxy Tab 10.1"},

        };

    }
//    @Test(dataProvider = "getProductInfoData")
//    public void selectProductHeaderTest(String product ,String displayedprod) {
//        SearchPage macbook = homepage.searchForProduct(product);
//        pip = macbook.selectProduct(displayedprod);
//        String productHeaderInfo = pip.getProductHeaderInfo();
//        Assert.assertEquals(productHeaderInfo, displayedprod);
//    }

    @Test(dataProvider = "getPIPData")
    public void selectProductImagesTest(String productsearch,String product,String brand, String productCode,String rewardpoints ,String Availability) {

//        Assert.assertEquals(imagesCount, 4);
        SearchPage sp=homepage.searchForProduct(productsearch);
        ProductInfoPage pip= sp.selectProduct(product);
        HashMap<String, Object> productDetailMap = pip.getProductDetailMap();
        System.out.println("test "+productDetailMap);
        SoftAssert sf = new SoftAssert();
        sf.assertEquals(productDetailMap.get("Brand"),brand);
        sf.assertEquals(productDetailMap.get("Product Code"),productCode);
        sf.assertEquals(productDetailMap.get("Reward Points"),rewardpoints);
        sf.assertEquals(productDetailMap.get("Availability"),Availability);
//        sf.assertEquals(productDetailMap.get("productPrice"),"$1,202.00");
        sf.assertAll("Asserting all product values");

    }
}
