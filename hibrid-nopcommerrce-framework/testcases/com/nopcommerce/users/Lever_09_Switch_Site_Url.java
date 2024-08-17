package com.nopcommerce.users;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.users.UserAddressPO;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserOrderPO;
import pageObjects.nopCommerce.users.UserRewardPointPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPO;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class Lever_09_Switch_Site_Url extends BaseTest {
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPO userLoginPage;
    private UserCustomerInfoPO userCustomerInfoPage;
    private BaseTest baseTest;
    private UserAddressPO userAddressPage;
    private UserOrderPO userOrderPage;
    private UserRewardPointPO userRewardPointPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    private String userUrl, adminUrl;
    String fisrtName, lastName, day, month, year, emailAddress, companyName, password;
    String adminEmailAddress, adminPassword;


    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {

        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        driver = getBrowserDriver(browserName, this.userUrl);
        userHomePage = PageGenerator.getUserHomePage(driver);
        fisrtName = "Dua";
        lastName = "Lipa";
        day = "6";
        month = "August";
        year = "2000";
        emailAddress = "dualipa" + generateRandomNumber() + "@yopmail.com";
        companyName = "MISA";
        password = "12345678@Abc";
        adminPassword ="admin";
        adminEmailAddress="admin@yourstore.com";

        userRegisterPage = userHomePage.openRegisterPage();

        userRegisterPage.clickToMaleRadio();
        userRegisterPage.enterToFirstNameTextBox(fisrtName);
        userRegisterPage.enterToEmailTextBox(emailAddress);
        userRegisterPage.enterToLastNameTextBox(lastName);
        userRegisterPage.selectDayDropdown(day);
        userRegisterPage.selectMonthDropdown(month);
        userRegisterPage.selectYearDropdown(year);
        userRegisterPage.enterToCompanyTextBox(companyName);
        userRegisterPage.enterToPasswordTextBox(password);
        userRegisterPage.enterToConfirmPasswordTextBox(password);
        userRegisterPage.clickToRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
        userRegisterPage.clickToLogoutLink();
    }

    @Test
    public void Role_01_User_Site_To_Admin_Site() {
        userLoginPage = userRegisterPage.openLoginPage();

        userHomePage = userLoginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

//        Step để order 1 sản phẩm nào đó rồi qua trang admin để verify cái order ở trên với Quyền Admin
        userHomePage.openPageUrl(driver,this.adminUrl);
//        Chuwa login
        adminLoginPage= PageGenerator.getAdminLoginPage(driver);
//        Login vào trang admin
        adminLoginPage.enterToEmailTextbox(adminEmailAddress);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminDashboardPage= adminLoginPage.clickToLoginButton();

    }

    @Test
    public void Role_02_Admin_Site_To_User_Site() {
//        vaof trang customer lafm casc step khasc
        adminDashboardPage.openPageUrl(driver,this.userUrl);
        userHomePage= PageGenerator.getUserHomePage(driver);
    }

    @Test
    public void User_03_MyAccount() {

        userCustomerInfoPage = userHomePage.openCustomerInforPage();

        Assert.assertTrue(userCustomerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(userCustomerInfoPage.getFirstNameTextBoxValue(), fisrtName);
        Assert.assertEquals(userCustomerInfoPage.getValueLastNameTexBoxValue(), lastName);
        Assert.assertEquals(userCustomerInfoPage.getDayDropdownSelectedValue(), day);
        Assert.assertEquals(userCustomerInfoPage.getMonthDropdownSelectedValue(), month);
        Assert.assertEquals(userCustomerInfoPage.getYearDropdownSelectedValue(), year);
        Assert.assertEquals(userCustomerInfoPage.getMailTextBoxValue(), emailAddress);
        Assert.assertEquals(userCustomerInfoPage.getCompanyTextBoxValue(), companyName);

    }

    @Test
    public void User_04_Switch_Page() {


    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }
}
