package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {
    WebDriver driver;
    @Test
    public void verifyTestNG(){
        driver=new FirefoxDriver();
        driver.get("https://www.facebook.com");
        //trong java có nhiêu thư viện để vẻify dữ liệu
        // Testing framework (Unit/Intergration/UI Automation Test)
        //khi mong muốn đk trả về là đúng thì dùng assertTrue để verify
        Assert.assertTrue(driver.getPageSource().contains(("Facebook helps yop connect and share with the people")));

        //Mong muốn điều kiện trả về  là sai thì dùng assertFalse
        Assert.assertFalse(driver.getPageSource().contains("Create a new account"));
        // các hàm trả về dữ liệu là boolean
        //quy tắc bắt đầu là tiền tố isXXX
        driver.findElement(By.id("")).isDisplayed();
    }
}
