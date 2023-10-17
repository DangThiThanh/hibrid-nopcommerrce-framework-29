package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands {
    // Các câu lệnh để thao tác với Browser
    // driver
    WebDriver driver;
    String homePagesUrl;
    // Các câu lệnh thao tác với Element
    // element
    WebElement element;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        // implicitlyWait dùng để chờ tìm ra các element
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println(driver.toString());
    }
    @Test
    public void TC_01_() throws MalformedURLException {
        //Tìm và trẻ về 1 element
        driver.findElement(By.id(""));
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).sendKeys("");
        // Tìm và lưu nó vào 1 biến WebElement (chưa tương tác)
        // Khi có dùng biến này ít nhất từ 2 lần trở lên
        WebElement fullNameTextbox = driver.findElement(By.id(""));
        fullNameTextbox.clear();
        fullNameTextbox.sendKeys("Automation FC");
        fullNameTextbox.getAttribute("value");
        //dùng để xoá dữ liệu trong 1 files cho phép nhập
        // text box / textArea / Dropdown
        driver.findElement(By.id("")).clear();
        driver.findElement(By.id("")).sendKeys("");
        // trả về 1 element khớp với điều kiện
        WebElement fullNameTextBox= driver.findElement(By.id(""));
        // Trả về nhiều element khớp với điều kiện
        List<WebElement> textboxes=driver.findElements(By.cssSelector(""));
        // Dung de verify  1 checkbox/radio/dropdown da duoc chon hay chua
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());
        //Dropdown (default/custom)

    }
}
