package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation Testing");
            System.out.println("Email TextBox is displayed");
        } else {
            System.out.println("Email TextBox is not displayed");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#under_18")).sendKeys("Automation Testing");
            System.out.println("Age Under18 is displayed");
        } else {
            System.out.println("Age Under18 is not displayed");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
            System.out.println("Edu TextArea is displayed");
        } else {
            System.out.println("Edu TextArea is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            driver.findElement(By.xpath("//h5[text()='Name: User5']")).sendKeys("Automation Testing");
            System.out.println("Name User5 is displayed");
        } else {
            System.out.println("Name User5 is not displayed");
        }
    }

    @Test
    public void TC_02_Enabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()) {
            System.out.println("Email TextBox is enabled");
        } else {
            System.out.println("Email TextBox is not enabled");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isEnabled()) {
            System.out.println("Age Under18 is enabled");
        } else {
            System.out.println("Age Under18 is not enabled");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isEnabled()) {
            System.out.println("Edu TextArea is enabled");
        } else {
            System.out.println("Edu TextArea is not enabled");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isEnabled()) {
            System.out.println("Name User5 is enabled");
        } else {
            System.out.println("Name User5 is not enabled");
        }
    }

    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());

        driver.findElement(By.cssSelector("input#java")).click();
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());
    }

    @Test
    public void TC_04_MailChimp() {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("duongpd12@gmail.com");

        // Case 1: Number
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345");
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // Case 2: LowerCase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("abcdef");
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // Case 3: UpperCase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("ABCDEF");
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // Case 4: Special Chars
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("/@$%!@");
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // Case 5: Max Length
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345678");
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());

        // Case 6: Valid
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Auto@123");
        sleepInSeconds(3);

        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());

        // Case 7: Empty
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("button[id='create-account-enabled']")).click();
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
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
