package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPO;
import pageObjects.nopCommerce.users.UserRegisterPO;

import java.time.Duration;

public class Lever_03_Page_Object extends BaseTest {
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private BaseTest baseTest;
    String fisrtName, lastName, day, month, year, emailAddress, companyName, password;




    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        homePage = new UserHomePO(driver);
        fisrtName = "Dua ";
        lastName = "Lipa";
        day = "6";
        month = "August";
        year = "2000";
        emailAddress = "dualipa" + generateRandomNumber() + "@yopmail.com";
        companyName = "MISA";
        password = "12345678@Abc";
    }



    @Test
    public void User_01_Register() {
        homePage.openRegisterPage();
        registerPage = new UserRegisterPO(driver);
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextBox(fisrtName);
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToLastNameTextBox(lastName);
        registerPage.selectDayDropdown(day);
        registerPage.selectMonthDropdown(month);
        registerPage.selectYearDropdown(year);
        registerPage.enterToCompanyTextBox(companyName);
        registerPage.enterToPasswordTextBox(password);
        registerPage.enterToConfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }
    @Test
    public void User_02_Login() {
        registerPage.clickToLogoutLink();
        registerPage.openLoginPage();
//        Từ Register page qua login page
//        Từ page đó được sinh ra và bắt đầu làm những action của page đó
        loginPage = new UserLoginPO(driver);
        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);
        loginPage.clickToLoginButton();
//         Từ Login pá
        homePage = new UserHomePO(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }
    @Test
    public void User_03_MyAccount() {

        homePage.openCustomerInforPage();
        customerInfoPage = new UserCustomerInfoPO(driver);
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextBoxValue(), fisrtName);
        Assert.assertEquals(customerInfoPage.getValueLastNameTexBoxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(), day);
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(), month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(), year);
        Assert.assertEquals(customerInfoPage.getMailTextBoxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextBoxValue(), companyName);

    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }
}
