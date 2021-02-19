package loginTests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;

public class SignIn extends BaseTest {

    SignInPage signInPage = new SignInPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        setup();
    }

    @Test(groups = {"Smoke"})
    public void isLoggedIn() {

        signInPage.enterEmail();
        signInPage.enterPassword();
        signInPage.clickOnSignInButton();

        boolean homePageIsVisible = signInPage.exist();
        Assert.assertTrue(homePageIsVisible);

    }

    @Test(groups = {"Basic regression"})
    public void isNotLoggedInWithInvalidAccount() {

        signInPage.enterInvalidEmail();
        signInPage.enterInvalidPassword();
        signInPage.clickOnSignInButton();

        boolean invalidCredentialsMessageDisplayed = signInPage.validateWrongCredentialsToast();
        Assert.assertTrue(invalidCredentialsMessageDisplayed);

    }

    @Test(groups = {"Basic regression"})
    public void isNotLoggedInWithInvalidPassword() {

        signInPage.enterEmail();
        signInPage.enterInvalidPassword();
        signInPage.clickOnSignInButton();

        boolean invalidCredentialsMessageDisplayed = signInPage.validateWrongCredentialsToast();
        Assert.assertTrue(invalidCredentialsMessageDisplayed);

    }

    @Test(groups = {"Basic regression"})
    public void isNotLoggedInWithoutCredentials() {

        signInPage.clickOnSignInButton();

        boolean credentialsRequiredMessageDisplayed = signInPage.validateRequiredCredentialsToast();
        Assert.assertTrue(credentialsRequiredMessageDisplayed);

    }

    @AfterMethod
    public void tearDown(){

        teardown();
    }
}
