package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.concurrent.TimeUnit;

public class Topic_05_Order_Misa {
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
    public void Register_01_Empty_() {
        driver.get("https://teststore.misa.vn/v2/quote?pid=217");
//action
        driver.findElement(By.xpath("//div[@class='btn-buy btn-buy-recommend']")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("span[@title='Thêm mã khuyến mãi']")));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//span[@title='Thêm mã khuyến mãi']")).click();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//input[@placeholder='Nhập mã khuyến mại']")).sendKeys("QUJ37C5X");
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//button[@title='Đồng ý']")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@title='Tiếp tục']")).click();
        // .assertEquals(drive);
    }

}
