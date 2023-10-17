package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_07_TextBox_TextArea {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Login_01_Empty_Email_And_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("advice-required-entry-pass")).getText(), "This is a required field.");

    }

    @Test
    public void Login_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("input#email")).sendKeys("123@345.567");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test
    public void Login_03_Invalid_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("input#email")).sendKeys("dangthithanh12h@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void Login_04_Incorect_Email_Or_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("dangthithanh12h@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456789");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-smg span")).getText(), "Invalid login or password.");

        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("1234565555");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-smg span")).getText(), "Invalid login or password.");

    }

    @Test
    public void Login_05_Login_Sucess() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(3);
        String firstName = "Dang", lastName = "thi thanh", email = getEmailAddress(), passWord = "12345678@Abc";
        String fullName = firstName + " " + lastName;
//        fullName=firstName.concat(" "+lastName);


//        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-smg span")).getText(),"Invalid login or password.");
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(email);
        driver.findElement(By.cssSelector("input#password")).sendKeys(passWord);

        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(passWord);
        driver.findElement(By.cssSelector("button[title='Register']")).click();
//        sleepInSeconds(3600);
//        System.out.println(driver.findElement(By.cssSelector("li.success-msg span")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(), "Hello, " + fullName + "!");
        String content = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div")).getText();
        Assert.assertTrue(content.contains(fullName));
        Assert.assertTrue(content.contains(email));
        //logout
        driver.findElement(By.cssSelector("a.skip-account")).click();
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        sleepInSeconds(5);
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("input#email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#pass")).sendKeys(passWord);

        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(), "Hello, " + fullName + "!");
        content = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div")).getText();
        Assert.assertTrue(content.contains(fullName));
        Assert.assertTrue(content.contains(email));

        //verify Account
        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute("value"), email);


    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "automation" + rand.nextInt(9999) + "@gmail.com";
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
