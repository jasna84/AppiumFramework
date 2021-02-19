package selectLanguageTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.SignInPage;

public class SelectLanguages extends BaseTest {

    LandingPage landingPage = new LandingPage();
    SignInPage signInPage = new SignInPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        setup();
    }

    @Test(groups = {"Smoke"})
    public void serbianLanguageIsSelected() {

        landingPage.clickOnCountrySpinner();
        landingPage.clickOnSpinnerOptionSR();
        landingPage.clickOnContinueButton();
        boolean signInButtonIsVisible = signInPage.signInButtonExists();
        Assert.assertTrue(signInButtonIsVisible);
    }
}
