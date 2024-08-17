package com.nopcommerce.users;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.users.UserAddressPO;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserOrderPO;
import pageObjects.nopCommerce.users.UserRewardPointPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPO;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class Lever_08_Page_Navigation extends BaseTest {

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

        driver= getBrowserDriver(browserName);
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


        registerPage =  homePage.openRegisterPage();

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

        loginPage=registerPage.openLoginPage();

        homePage = loginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void User_03_MyAccount() {

        customerInfoPage = homePage.openCustomerInforPage();

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextBoxValue(), fisrtName);
        Assert.assertEquals(customerInfoPage.getValueLastNameTexBoxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(), day);
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(), month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(), year);
        Assert.assertEquals(customerInfoPage.getMailTextBoxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextBoxValue(), companyName);

    }

    @Test
    public void User_04_Switch_Page(){
//        Customer Infor --> Address
           addressPage=customerInfoPage.openAddressPage(driver);
//          Add new address ở bên dưới
//        ....

//        Address --> Reward point
        rewardPointPage=addressPage.openRewardPointPage(driver);
//        Người dùng thao tác với trang RewardPoint
//        ....

//        Reward point --> Order
        orderPage= rewardPointPage.openOrderPage(driver);


//        Order --> Address
        addressPage = orderPage.openAddressPage(driver);


//        Address --> Customer Infor
        customerInfoPage = addressPage.openCustomerInforpage(driver);



    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }
}
