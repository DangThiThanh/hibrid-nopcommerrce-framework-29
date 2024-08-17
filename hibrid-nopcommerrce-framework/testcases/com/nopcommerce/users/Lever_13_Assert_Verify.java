package com.nopcommerce.users;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;

public class Lever_13_Assert_Verify extends BaseTest {

    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private BaseTest baseTest;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;

    String fisrtName, lastName, day, month, year, emailAddress, companyName, password;



    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {

        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getUserHomePage(driver);
        fisrtName = "Dua";
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
        registerPage = homePage.openRegisterPage();
//        Assert 01
        verifyEquals(registerPage.getRegisterPageTitle(), "Register.");

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
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed abc abc");

    }

    @Test
    public void User_02_Login() {
        registerPage.clickToLogoutLink();

        loginPage = registerPage.openLoginPage();

        homePage = loginPage.loginToSystem(emailAddress, password);

      verifyTrue(homePage.isMyAccountLinkDisplayed());
        verifyTrue(false);
    }

    @Test
    public void User_03_MyAccount() {

        customerInfoPage = homePage.openCustomerInforPage();

        verifyTrue(customerInfoPage.isGenderMaleSelected());
        verifyEquals(customerInfoPage.getFirstNameTextBoxValue(), fisrtName);
        verifyEquals(customerInfoPage.getValueLastNameTexBoxValue(), lastName);
        verifyEquals(customerInfoPage.getDayDropdownSelectedValue(), day);
        verifyEquals(customerInfoPage.getMonthDropdownSelectedValue(), month);
        verifyEquals(customerInfoPage.getYearDropdownSelectedValue(), year);
        verifyEquals(customerInfoPage.getMailTextBoxValue(), emailAddress);
        verifyEquals(customerInfoPage.getCompanyTextBoxValue(), companyName);

    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }
}
