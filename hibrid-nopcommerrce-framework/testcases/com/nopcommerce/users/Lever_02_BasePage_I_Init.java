package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;


public class Lever_02_BasePage_I_Init {
    private WebDriver driver;
    BasePage basePage ;
    String fisrtName, lastName, day, month, year, emailAddress, companyName, password;
//
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        basePage = new BasePage();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
    public void TC_01_Register() {

        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        basePage.waitForElementClickable(driver,"//input[@id='gender-female']");
        basePage.clickToElement(driver,"//input[@id='gender-female']");
        basePage.sendKeyToElement(driver,"//input[@id='FirstName']", fisrtName);
        basePage.sendKeyToElement(driver,"//input[@id='LastName']", lastName);
        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthDay']",day);
        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']",month);
        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthYear']",year);
        basePage.sendKeyToElement(driver,"//input[@id='Email']", emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id='Company']", companyName);
        basePage.sendKeyToElement(driver,"//input[@id='Password']", password);
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']", password);
        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals( basePage.getElementText(driver ,"//div[@class='result']"), "Your registration completed");
    }

    @Test
    public void TC_02_Login() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-login']");
        basePage.clickToElement(driver,"//a[@class='ico-login']");
        basePage.sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id='Password']",password);
        basePage.waitForElementClickable(driver,"//button[contains(@class,'login-button')]");
        basePage.clickToElement(driver,"//button[contains(@class,'login-button')]");

        Assert.assertTrue(basePage.isElementDisplayed(driver,"//a[@class='ico-account' and text()='My account']"));

    }

    @Test
    public void TC_03_MyAccount() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-account']");
        basePage.clickToElement(driver,"//a[@class='ico-account']");
        Assert.assertTrue(basePage.isElementSelected(driver,"//input[@id='gender-female']"));
        Assert.assertEquals(basePage.getElementAttributeValue(driver,"//input[@id='FirstName']","value"),fisrtName);
        Assert.assertEquals(basePage.getElementAttributeValue(driver,"//input[@id='LastName']","value"),lastName);

        Assert.assertEquals(basePage.getSelectItemInDropdown(driver,"//select[@name='DateOfBirthDay']"),day);
        Assert.assertEquals(basePage.getSelectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']"),month);
        Assert.assertEquals(basePage.getSelectItemInDropdown(driver,"//select[@name='DateOfBirthYear']"),year);
        Assert.assertEquals(basePage.getElementAttributeValue(driver,"//input[@id='Company']","value"),companyName);


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    private int generateRandomNumber(){
        return new Random().nextInt(9999);
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
