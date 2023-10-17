package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {
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
        //WebElement emailAddressTextBox=driver.findElement(By.id("email"));
        String homePageUrl="https://www.facebook.com/?locale=vi_VN";
        driver.get(homePagesUrl);
        driver.get(this.homePagesUrl);
        //handle window láy ra id của cửa sổ hiện tại
        driver.getWindowHandles();

        //cookies - Framework
        driver.manage().getCookies();

        //get ra những log ở Dev tool - framework
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // chowf cho page ddc load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        /**/
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
//        thao tác với hítory của web page (back/forword)
        driver.navigate().to("https://www.facebook.com/?locale=vi_VN");
        driver.navigate().to( new URL("https://www.facebook.com/?locale=vi_VN"));
        driver.switchTo().alert().sendKeys("test");
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
//        ấy ra ID của cửa số/ tab hiện tại
//        handle windown/tab
        String homePageWindownID=driver.getWindowHandle();
        driver.switchTo().window(homePageWindownID);
//        switch/handle frame (iframe)
        driver.switchTo().frame(0);
        driver.switchTo().frame("756375638975");
        driver.switchTo().frame(driver.findElement(By.id("")));



    }
}
