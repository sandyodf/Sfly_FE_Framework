package com.qa.sfly.tests;

import com.qa.sfly.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qa.sfly.constants.AppConstants.*;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginTitleTest() {
        String pageTitle = loginpage.getPageTitle();
        Assert.assertEquals(pageTitle, LOGIN_PAGE_TITLE);
    }

    @Test
    public void loginUrlTest() {
        String pageUrl = loginpage.getPageUrl();
        Assert.assertTrue(pageUrl.contains(LOGIN_PAGE_URL));
    }

    @Test
    public void forgotPasswordLinkTest() {
        boolean link = loginpage.isForgotPasswordLinkDisplayed();
        Assert.assertTrue(link);
    }

    @Test
    public void newCustomerLinkTextTest() {
        String pageTitle = loginpage.getNewCustText();
        Assert.assertEquals(pageTitle, NEW_ACCOUNT_TEXT);
    }

    @Test(priority = Short.MAX_VALUE)
    public void loginPageTest() {
        loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
}
