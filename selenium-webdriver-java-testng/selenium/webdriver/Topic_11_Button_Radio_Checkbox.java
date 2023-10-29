package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;
import java.time.Duration;

public class Topic_11_Button_Radio_Checkbox {
    WebDriver driver;
    WebElement element;
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC001_VerifyBtn() {
        driver.get("https://egov.danang.gov.vn/reg");
        WebElement registerButton =driver.findElement(By.cssSelector("input.egov-button"));
        // Verify button bị disable khi chưa click vào check box
        Assert.assertFalse(registerButton.isEnabled());
         driver.findElement(By.cssSelector("input#chinhSach")).click();
         sleepInSeconds(2);
         //Verify button khi check box chính sách và điều kiện
        Assert.assertTrue(registerButton.isEnabled());

        //Lấy ra mãu màu nền btn
        String registerBackgroundColorRGB = registerButton.getCssValue("background-color");
        Color registerbackgroundColor  = Color.fromString(registerBackgroundColorRGB);
        String registerbackgroundHexa= registerbackgroundColor.asHex();
        Assert.assertEquals(registerbackgroundHexa.toLowerCase(),"#ef5a00");
        System.out.println(registerbackgroundHexa.toUpperCase());

    }

    @Test
    public void TC002_Fahasa_Button() {
        driver.get("https://www.fahasa.com/customer/account/create");
        // chuyển qua tab đăng nhập
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        sleepInSeconds(2);
        WebElement loginButton= driver.findElement(By.cssSelector("button.fhs-btn-login"));
        //Verify login button is disabled
        Assert.assertFalse(loginButton.isEnabled());
        // Verify login button = background
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000" );
        //Nhập email / Password
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("dangthithanh12h@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("1234567@Abc");
        sleepInSeconds(2);
        //Verify login button is disabled
        Assert.assertTrue(loginButton.isEnabled());
        // Verify login button = background
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#c92127" );

    }
    @Test
    public void TC003_Checkbox() {

    }
    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
