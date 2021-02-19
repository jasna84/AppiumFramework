package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    By selectCountrySpinner  = By.id("co.cvik.user:id/spinner");
    By spinnerOptionSR  =  By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
    By spinnerOptionSM = By.id("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
    By spinnerOptionBIH = By.id("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
    By spinnerOptionCG = By.id("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
    By continueButton = By.id( "co.cvik.user:id/next_button");

    public void clickOnCountrySpinner () {
        waitForElement(selectCountrySpinner, 3);
        clickOn(selectCountrySpinner);
    }

    public void clickOnSpinnerOptionSR() {
        clickOnCountrySpinner();
        waitForElement(spinnerOptionSR, 3);
        clickOn(spinnerOptionSR);
    }

    public void clickOnSpinnerOptionSM() {
        clickOnCountrySpinner();
        waitForElement(spinnerOptionSM, 3);
        clickOn(spinnerOptionSM);
    }

    public void clickOnSpinnerOptionBIH() {
        clickOnCountrySpinner();
        waitForElement(spinnerOptionBIH, 3);
        clickOn(spinnerOptionBIH);
    }

    public void clickOnSpinnerOptionCG() {
        clickOnCountrySpinner();
        waitForElement(spinnerOptionCG, 3);
        clickOn(spinnerOptionCG);
    }

    public void clickOnContinueButton () {
        removeKeyboard();
        waitForElement(continueButton, 3);
        clickOn(continueButton);
    }

    @Override
    public boolean exist() {
        return waitForElement(selectCountrySpinner, 3);
    }
}
