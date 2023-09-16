package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.zeromq.timer.ZTimer;

import java.util.concurrent.TimeUnit;

public class Topic_04_Selenium_Relative {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    @BeforeClass
    public void beforeClass(){
        if (osName.contains("Windows")){
            System.setProperty("webdriver.gecko.driver",projectPath + "\\browserDrivers\\geckodriver.exe");
        }
        else {
            System.setProperty("webdriver.gecko.driver",projectPath + "/browserDrivers/geckodriver.exe");
        }
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_relative() {
        driver.get("https://www.thegioididong.com/");
        driver.findElement(By.xpath("//footer//div[@class='footer__col']//a[text()='Tích điểm Quà tặng VIP']")).click();
    }
}
