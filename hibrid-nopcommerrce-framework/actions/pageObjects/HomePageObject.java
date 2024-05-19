package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {


    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    public RegisterPageObject clickToRegisterLink( ) {
        waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
       clickToElement(driver,HomePageUI.REGISTER_LINK);
       return new RegisterPageObject(driver);
    }

    public boolean isMyAccountLinkDisplayed() {

        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }


    public void clickToMyAccountLink() {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
    }
}
