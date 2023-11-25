package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_15_Popup {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC001_Random_In_DOM() {
        driver.get("https://www.javacodegeeks.com/");
        By newLetterPopup= By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");
//        Nếu hển thị  thì closed nó đy
        if(driver.findElement(newLetterPopup).isDisplayed()){
            System.out.println("popup hiển thị");
            driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none']) div.lepopup-element-html-content")).click();
        sleepInSeconds(2);

        }
    }

    @Test
    public void TC002_Login() {

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
