package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_30_Wait_Fluent {
    WebDriver driver;
    WebElement element;
    FluentWait<WebDriver> fluentDriver;
    FluentWait<WebElement> fluentElement;
    FluentWait<String> fluentString;
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        fluentDriver = new FluentWait<WebDriver>(driver);
    }

    @Test
    public void TC008_Fluent_Wait() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
//        Chờ cho hello world text hiển thị trong 10s
//        Setting
        fluentDriver.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
//        Condition
        fluentDriver.until(new Function<WebDriver, Boolean>() {

            @Override
            public Boolean apply(WebDriver webDriver) {
                return  driver.findElement(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")).isDisplayed();
            }
        });
//        Condition
        String  helloText = fluentDriver.until(new Function<WebDriver, String>() {

            @Override
            public String apply(WebDriver webDriver) {
                return  driver.findElement(By.xpath("//div[@id='finish']//h4")).getText();
            }
        });
        Assert.assertEquals(helloText,"Hello World!");
    }
// Timeout k đủ thì exception
    @Test
    public void TC007_Fluent_Wait() {
        driver.get("https://automationfc.github.io/fluent-wait/");
        WebElement countTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));
        fluentElement = new FluentWait<WebElement>(countTime);
        fluentElement.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(java.util.NoSuchElementException.class);
        fluentElement.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                String text=webElement.getText();
                System.out.println(text);
                return text.endsWith("00");
            }
        });
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
