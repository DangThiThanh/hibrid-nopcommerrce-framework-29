package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;
    public void clickToMaleRadio() {
        waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
        checkTheCheckboxOrRadio(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void enterToLastNameTextBox(String lastName) {
        waitForElementVisible(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }
    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickable(driver, RegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(driver,  RegisterPageUI.DAY_DROPDOWN,day);
    }

    public void selectMonthDropdown(String month) {
        waitForElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(driver,  RegisterPageUI.MONTH_DROPDOWN,month);
    }

    public void selectYearDropdown(String year) {
        waitForElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(driver,  RegisterPageUI.YEAR_DROPDOWN,year);
    }

    public void enterToCompanyTextBox(String companyName) {
        waitForElementVisible(driver,RegisterPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.COMPANY_TEXTBOX,companyName);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfirmPasswordTextBox(String confirmPassword) {
        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
    } public void clickToLoginLink() {
        waitForElementClickable(driver, RegisterPageUI.LOGIN_LINK);
        clickToElement(driver, RegisterPageUI.LOGIN_LINK);
    }



}
