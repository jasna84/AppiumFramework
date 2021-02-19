package signUpTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUp extends BaseTest {

    SignUpPage signUpPage = new SignUpPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        setup();
        signUpPage.clickOnSignUpButton();

    }

    @Test(groups = {"Smoke"})
    public void validSignUpWithAllInformation() {

        signUpPage.enterFirstName();
        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.selectCity();
        signUpPage.enterPassword();
        signUpPage.confirmPassword();
        signUpPage.swipeToButtons();
        signUpPage.clickOnTerms();
        signUpPage.clickOnCreateAccount();

        boolean homePageIsVisible = signUpPage.exist();
        Assert.assertTrue(homePageIsVisible);

    }

    @Test(groups = {"Basic regression"})
    public void validSignUpWithRequiredInformation() {

        signUpPage.enterFirstName();
        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.selectCity();
        signUpPage.enterPassword();
        signUpPage.confirmPassword();
        signUpPage.swipeToButtons();
        signUpPage.clickOnTerms();
        signUpPage.clickOnCreateAccount();

        boolean homePageIsVisible = signUpPage.exist();
        Assert.assertTrue(homePageIsVisible);
    }

    @Test(groups = {"Basic regression"})
    public void signUpWithNoName() {

        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.selectCity();
        signUpPage.enterPassword();
        signUpPage.confirmPassword();
        signUpPage.swipeToButtons();
        signUpPage.clickOnTerms();
        signUpPage.clickOnCreateAccount();

        boolean requiredDataMissingDisplayed = signUpPage.requiredDataMissingToast();
        Assert.assertTrue(requiredDataMissingDisplayed);

    }

    @Test(groups = {"Basic regression"})
    public void signUpWithNoLastName() {

        signUpPage.enterFirstName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.selectCity();
        signUpPage.enterPassword();
        signUpPage.confirmPassword();
        signUpPage.swipeToButtons();
        signUpPage.clickOnTerms();
        signUpPage.clickOnCreateAccount();

        boolean requiredDataMissingDisplayed = signUpPage.requiredDataMissingToast();
        Assert.assertTrue(requiredDataMissingDisplayed);

    }

    @Test(groups = {"Basic regression"})
    public void signUpWithNoEmail() {

        signUpPage.enterFirstName();
        signUpPage.enterLastName();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.selectCity();
        signUpPage.enterPassword();
        signUpPage.confirmPassword();
        signUpPage.swipeToButtons();
        signUpPage.clickOnTerms();
        signUpPage.clickOnCreateAccount();

        boolean requiredDataMissingDisplayed = signUpPage.requiredDataMissingToast();
        Assert.assertTrue(requiredDataMissingDisplayed);

    }

    @Test(groups = {"Basic regression"})
    public void signUpWithNoCity() {

        signUpPage.enterFirstName();
        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.enterPassword();
        signUpPage.confirmPassword();
        signUpPage.swipeToButtons();
        signUpPage.clickOnTerms();
        signUpPage.clickOnCreateAccount();

        boolean requiredDataMissingDisplayed = signUpPage.requiredDataMissingToast();
        Assert.assertTrue(requiredDataMissingDisplayed);

    }

    @Test(groups = {"Basic regression"})
    public void signUpWithNoPassword() {

        signUpPage.enterFirstName();
        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.selectCity();
        signUpPage.confirmPassword();
        signUpPage.swipeToButtons();
        signUpPage.clickOnTerms();
        signUpPage.clickOnCreateAccount();

        boolean requiredDataMissingDisplayed = signUpPage.requiredDataMissingToast();
        Assert.assertTrue(requiredDataMissingDisplayed);

    }

    @Test(groups = {"Basic regression"})
    public void signUpWithNoConfirmedPassword() {

        signUpPage.enterFirstName();
        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.selectCity();
        signUpPage.swipeToButtons();
        signUpPage.enterPassword();
        signUpPage.clickOnTerms();
        signUpPage.clickOnCreateAccount();

        boolean requiredDataMissingDisplayed = signUpPage.requiredDataMissingToast();
        Assert.assertTrue(requiredDataMissingDisplayed);

    }

    @Test(groups = {"Basic regression"})
    public void signUpWithNoTermsChecked() {

        signUpPage.enterFirstName();
        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.selectCity();
        signUpPage.enterPassword();
        signUpPage.confirmPassword();
        signUpPage.swipeToButtons();
        signUpPage.clickOnTerms();
        signUpPage.uncheckTerms();
        signUpPage.clickOnCreateAccount();

        boolean requiredDataMissingDisplayed = signUpPage.requiredDataMissingToast();
        Assert.assertTrue(requiredDataMissingDisplayed);

    }

    @Test(groups = {"Basic regression"})
    public void signUpWithNoMatchingPasswords() {

        signUpPage.enterFirstName();
        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.selectCity();
        signUpPage.enterPassword();
        signUpPage.confirmPasswordDifferent();
        signUpPage.swipeToButtons();
        signUpPage.clickOnTerms();
        signUpPage.clickOnCreateAccount();

        boolean passwordsDoNotMatchDisplayed = signUpPage.passwordsDoNotMatchDisplayedToast();
        Assert.assertTrue(passwordsDoNotMatchDisplayed);

    }

    @AfterMethod
    public void tearDown(){

        teardown();
    }
}
