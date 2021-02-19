package pages;

import base.BasePage;
import base.Config;
import org.openqa.selenium.By;

public class SignInPage extends BasePage {

    Config conf = new Config();

    By signInButton = By.id("co.cvik.user:id/sign_in_button");
    By emailField  = By.xpath("//android.widget.EditText[@content-desc='agro005']");
    By passwordField  = By.xpath("//android.widget.EditText[@content-desc='agro006']");
    By signUpButton = By.xpath("//android.view.ViewGroup[@content-desc='agro012']/android.widget.TextView");
    By forgotPasswordLink = By.xpath("//android.widget.TextView[@content-desc='agro008'']");
    By profileMenu = By.xpath("//android.view.ViewGroup[@content-desc='parcelsMenu002']/android.widget.TextView");
    By errorToast = By.xpath( "//android.widget.Toast");

    public void enterEmail() {

        waitForElement(emailField, 3);
        sendText(emailField, conf.getProperties("email"));
    }

    public void enterPassword () {

        waitForElement(passwordField, 3);
        sendText(passwordField, conf.getProperties("password"));
    }

    public void enterInvalidEmail() {

        waitForElement(emailField, 3);
        sendText(emailField, conf.getProperties("invalidEmail") );
    }

    public void enterInvalidPassword () {

        waitForElement(passwordField, 3);
        sendText(passwordField, conf.getProperties("invalidPassword"));
    }

    public void clickOnSignInButton () {

        removeKeyboard();
        waitForElement(signInButton, 3);
        clickOn(signInButton);
        clickOn(signInButton);
    }

    public void clickOnSignUpButton () {

        waitForElement(signUpButton, 3);
        clickOn(signUpButton);
    }

    public void clickOnForgotPassword () {

        waitForElement(forgotPasswordLink, 3);
        clickOn(forgotPasswordLink);
    }

    public boolean validateWrongCredentialsToast() {

        waitForElement(errorToast, 3);
        String errorText = getElementText(errorToast);
        return errorText.contains("Wrong email or password");
    }

    public boolean validateRequiredCredentialsToast() {

        waitForElement(errorToast, 3);
        String errorText = getElementText(errorToast);
        return errorText.contains("Email and password are required");
    }

    public boolean signInButtonExists() {
        return waitForElement(signInButton, 3);
    }

}


