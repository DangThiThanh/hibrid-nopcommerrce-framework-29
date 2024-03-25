package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_28_Wait_07 {
    WebDriver driver;
    WebElement element;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC001_Only_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.facebook.com/?locale=vi_VN");
        //Khi vòa tìm thấy element luôn
//        Không cần chờ hết time out


    }

    @Test
    public void TC002_Only_Implicit_Not_Found() {


    }
    @Test
    public void TC003_Only_Explicit() {


    }
    @Test
    public void TC004_Only_Explicit_Not_Found() {


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
