package com.nopcommerce.users;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;

public class Lever_14_Log4J extends BaseTest {

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
        log.info("User_01_Register - STEP 01: Open Register page");
        registerPage = homePage.openRegisterPage();

        log.info("User_01_Register - STEP 02: Click to Male radio button");
        registerPage.clickToMaleRadio();

        log.info("User_01_Register - STEP 03: Enter to Firstname textbox with value: " + fisrtName);
        registerPage.enterToFirstNameTextBox(fisrtName);

        log.info("User_01_Register - STEP 04: Enter to Email textbox with value: " + emailAddress);
        registerPage.enterToEmailTextBox(emailAddress);

        log.info("User_01_Register - STEP 05: Enter to  LastName with value: " + lastName);
        registerPage.enterToLastNameTextBox(lastName);

        log.info("User_01_Register - STEP 06: Enter to Day textbox with value: " + day);
        registerPage.selectDayDropdown(day);

        log.info("User_01_Register - STEP 07: Enter to Month textbox with value: " + month);
        registerPage.selectMonthDropdown(month);

        log.info("User_01_Register - STEP 08: Enter to Year textbox with value: " + year);
        registerPage.selectYearDropdown(year);

        log.info("User_01_Register - STEP 09: Enter to CompanyName textbox with value: " + companyName);
        registerPage.enterToCompanyTextBox(companyName);

        log.info("User_01_Register - STEP 10: Enter to Password textbox with value: " + password);
        registerPage.enterToPasswordTextBox(password);

        log.info("User_01_Register - STEP 11: Enter to ConfirmPassword textbox with value: " + password);
        registerPage.enterToConfirmPasswordTextBox(password);

        log.info("User_01_Register - STEP 12: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - STEP 13: Verify success massage is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @Test
    public void User_02_Login() {
        registerPage.clickToLogoutLink();

        loginPage = registerPage.openLoginPage();

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
    public void User_04_Dynamic_Page() {
//        Customer Infor --> Address
        addressPage = (UserAddressPO) customerInfoPage.openSidebarLinkByPageName("Addresses");

//        Address --> Reward point
        rewardPointPage = (UserRewardPointPO) addressPage.openSidebarLinkByPageName("Reward points");


//        Reward point --> Order
        orderPage = (UserOrderPO) rewardPointPage.openSidebarLinkByPageName("Orders");


//        Order --> Address
        addressPage = (UserAddressPO) orderPage.openSidebarLinkByPageName("Addresses");


//        Address --> Customer Infor
        customerInfoPage = (UserCustomerInfoPO) addressPage.openSidebarLinkByPageName("Customer info");


    }

    @Test
    public void User_05_Dynamic_Page() {
//        Customer Infor --> Address
        customerInfoPage.openSidebarLinkByPageNames("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

//        Address --> Reward point
        addressPage.openSidebarLinkByPageNames("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPointPage(driver);


//        Reward point --> Order
        rewardPointPage.openSidebarLinkByPageNames("Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);


//        Order --> Address
        orderPage.openSidebarLinkByPageName("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);


//        Address --> Customer Infor
        addressPage.openSidebarLinkByPageName("Customer info");
        customerInfoPage = PageGenerator.getUserCustomerPage(driver);


    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }
}
