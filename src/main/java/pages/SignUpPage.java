package pages;

import base.BasePage;
import utils.CredentialsGenerator;
import org.openqa.selenium.By;

public class SignUpPage extends BasePage {


    By pageContainer = By.xpath("//android.view.ViewGroup[@content-desc='agro403']");
    By signUpButton = By.xpath("//android.view.ViewGroup[@content-desc='agro012']/android.widget.TextView");
    By firstNameField = By.xpath("//android.widget.EditText[@content-desc='agro404']");
    By lastNameField = By.xpath("//android.widget.EditText[@content-desc='agro405']");
    By emailField = By.xpath("//android.widget.EditText[@content-desc='agro406']");
    By phoneField = By.xpath("//android.widget.EditText[@content-desc='agro1406']");
    By addressField = By.xpath("//android.widget.EditText[@content-desc='agro411']");
    By citySelectMenu = By.xpath("//android.view.ViewGroup[@content-desc='agro1005']/android.widget.Spinner");
    By menuSelection = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.ListView/android.widget.CheckedTextView[8]");
    By passwordField = By.xpath("//android.widget.EditText[@content-desc='agro407']");
    By retypePasswordField = By.xpath("//android.widget.EditText[@content-desc='agro408']");
    By termsCheckbox = By.xpath("//android.view.ViewGroup[@content-desc='agro403']/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView");
    By closeButton = By.xpath("//android.view.ViewGroup[@content-desc='agroCAButton'][1]/android.widget.TextView");
    By createAccountButton = By.xpath("//android.view.ViewGroup[@content-desc='agroCAButton'][2]/android.widget.TextView");
    By profileMenu = By.xpath("//android.view.ViewGroup[@content-desc='parcelsMenu002']/android.widget.TextView");
    By errorToast = By.xpath( "//android.widget.Toast");

    String firstName = CredentialsGenerator.generateName();
    String lastName = CredentialsGenerator.generateName();
    String email = CredentialsGenerator.generateEmail();
    String phone = CredentialsGenerator.generatePhone();
    String password = CredentialsGenerator.generatePassword();
    String address = CredentialsGenerator.generateAddress();
    String differentPassword = CredentialsGenerator.generatePassword();

    public void clickOnSignUpButton() {

        waitForElement(signUpButton, 3);
        clickOn(signUpButton);
    }

    public void enterFirstName() {

        waitForElement(firstNameField, 3);
        sendText(firstNameField, firstName );
    }

    public void enterLastName() {

        waitForElement(lastNameField, 3);
        sendText(lastNameField, lastName);
    }

    public void enterEmail() {

        waitForElement(emailField, 3);
        sendText(emailField, email );
        removeKeyboard();
    }

    public void enterPhone() {

        waitForElement(phoneField, 3);
        sendText(phoneField, phone);
        removeKeyboard();
    }

    public void enterAddress() {

        waitForElement(addressField, 3);
        sendText(addressField, address );
        removeKeyboard();
    }

    public void selectCity() {

        waitForElement(citySelectMenu, 3);
        clickOn(citySelectMenu);
        clickOn(menuSelection);
    }

    public void enterPassword() {

        waitForElement(passwordField, 3);
        sendText(passwordField, password);
        removeKeyboard();
    }

    public void confirmPassword() {

        waitForElement(retypePasswordField, 3);
        sendText(retypePasswordField, password);
        removeKeyboard();
    }

    public void confirmPasswordDifferent() {

        waitForElement(retypePasswordField, 3);
        sendText(retypePasswordField, differentPassword);
        removeKeyboard();
    }

    public void clickOnTerms() {

        waitForElement(termsCheckbox, 3);
        clickOn(termsCheckbox);
        clickOn(termsCheckbox);
    }

    public void uncheckTerms() {

        waitForElement(termsCheckbox, 3);
        clickOn(termsCheckbox);
    }

    public void clickOnCreateAccount() {

        waitForElement(createAccountButton, 3);
        clickOn(createAccountButton);
    }

    public void clickOnClose() {

        waitForElement(closeButton, 3);
        clickOn(closeButton);
    }

    public boolean requiredDataMissingToast() {

        waitForElement(errorToast, 3);
        String errorText = getElementText(errorToast);
        return errorText.contains("Please enter all fields");
    }

    public boolean passwordsDoNotMatchDisplayedToast() {

        waitForElement(errorToast, 3);
        String errorText = getElementText(errorToast);
        return errorText.contains("Passwords do not match");
    }


    public void swipeToButtons() {

        waitForElement(pageContainer, 3);
        removeKeyboard();

        int x = (int) (getContainerWidth(pageContainer) / 2);

        double screenHeightStart = getContainerHeight(pageContainer) * 0.70;
        int scrollStart = (int) screenHeightStart;

        double screenHeightEnd = getContainerHeight(pageContainer) * 0.20;
        int scrollEnd = (int) screenHeightEnd;

        swipeDown(scrollStart, scrollEnd, x);

    }

    @Override
    public boolean exist() {
        return waitForElement(profileMenu, 3);
    }

}
