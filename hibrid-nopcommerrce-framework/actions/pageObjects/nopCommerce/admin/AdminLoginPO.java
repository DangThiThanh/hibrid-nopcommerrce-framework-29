package pageObjects.nopCommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    private WebDriver driver;
    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String emailAddress) {
        getByLocator("abc");
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        getElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX).clear();
        sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        getElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX).clear();
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public AdminDashboardPO clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashboardPage(driver);
    }


}
