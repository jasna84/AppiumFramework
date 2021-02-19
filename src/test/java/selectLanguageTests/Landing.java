package selectLanguageTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;

public class Landing extends BaseTest {

    LandingPage landingPage = new LandingPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        setup();
    }

    @Test(groups = {"Smoke"})
    public void landingPageOpens() {
        boolean landingPageIsVisible = landingPage.exist();
        Assert.assertTrue(landingPageIsVisible);
   }

}
