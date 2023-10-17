package webdriver;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebBrowser_Example {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC001_VerifyUrl() {
        driver.get("http://live.guru99.com/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//div[@class='buttons-set']/a[@title='Create an Account']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //sout
        //System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
    }

    @Test
    public void TC002_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.xpath("//input[@type='email']")).isDisplayed()) {
            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Viet duong hong lac");
            System.out.println("Element is  displayed");
        }
        else {
            System.out.println("Element is not displayed");
        }

//        if (driver.findElement(By.xpath("//textarea[@id='edu']]")).isDisplayed()) {
//            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Viet duong hong lac 2");
//        }


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
