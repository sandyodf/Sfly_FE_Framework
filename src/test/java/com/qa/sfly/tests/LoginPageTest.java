package com.qa.sfly.tests;

import com.qa.sfly.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginTitleTest() {
        String pageTitle = lp.getPageTitle();
        Assert.assertEquals(pageTitle, "Account Login");
    }

    @Test
    public void loginUrlTest() {
        String pageUrl = lp.getPageUrl();
        Assert.assertTrue(pageUrl.contains("=account/login"));
    }

    @Test
    public void forgotPasswordLinkTest() {
        boolean link = lp.isForgotPasswordLinkDisplayed();
        Assert.assertTrue(link);
    }

    @Test
    public void newCustomerLinkTextTest() {
        String pageTitle = lp.getNewCustText();
        Assert.assertEquals(pageTitle, "By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.");
    }

    @Test(priority = Short.MAX_VALUE)
    public void loginPageTest() {
        String s = lp.doLogin("deepu.odf1@yopmail.com", "Sandy@123");
        Assert.assertEquals(s, "My Account");
    }
}
