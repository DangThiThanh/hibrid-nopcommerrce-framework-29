package com.nopcommerce.users;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Lever_06_Page_Generator extends BaseTest {

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private BaseTest baseTest;

    String fisrtName, lastName, day, month, year, emailAddress, companyName, password;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {

        driver= getBrowserDriver(browserName);

        homePage= PageGenerator.getHomePage(driver);

//        homePage = new HomePageObject(driver);
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
        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);
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
        registerPage.clickToLoginLink();
//        Từ Register page qua login page
//        Từ page đó được sinh ra và bắt đầu làm những action của page đó
        loginPage = new LoginPageObject(driver);
        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);
        loginPage.clickToLoginButton();
//         Từ Login pá
        homePage = new HomePageObject(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void User_03_MyAccount() {

        homePage.clickToMyAccountLink();
        customerInfoPage = new CustomerInfoPageObject(driver);
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
