package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_13_Alert_Java {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC001_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        sleepInSeconds(2);
        Alert alert =driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
//        Khi minh acept / cancel thif alert mat han luon
        alert.accept();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.xpath("")),"");
    }


    @Test
    public void TC003_Prompt_Alert() {


    }
    @Test
    public void TC004_Authentication_Pass_To_URL() {
    String ussername="admin";
    String password ="admin";
    //cách 1: truyền thẳng username/password vào URL
        // Trick - ByPass
        driver.get("");

    }
    @Test
    public void TC006_Authen_Selenium_4x() {


    }
    @Test
    public void TC004_Authen_Alert() {


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
