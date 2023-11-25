package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Radio_Box {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC001_Defaul_Checkbox() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        By dualZonecheckbox= By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input");
        //click vào check box
//        case 1 Nếu như app này ở ra mà check box đã đợc chọn thì sao
//        case 2 Nếu như app này mở ra mà checkbox chưa đc chọn
        if(!driver.findElement(dualZonecheckbox).isSelected()){
            driver.findElement(dualZonecheckbox).click();
            sleepInSeconds(2);
        }
        //verify check box đã được chọn thành công
        Assert.assertTrue(driver.findElement(dualZonecheckbox).isSelected());

        // Bỏ chọn check box
        if(driver.findElement(dualZonecheckbox).isSelected()){
            driver.findElement(dualZonecheckbox).click();
            sleepInSeconds(2);
        }
        //Verify check box đã được chọn thành công thì bỏ chọn
        unCheckToElement(dualZonecheckbox);
    }

    @Test
    public void TC002_Default_Telerik_Radio() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By petroRadio = By.xpath("//label[text()='1.4 Petrol, 92kW']/preceding-sibling::input");
        By dieseRadio = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::input");
        checkToElement(dieseRadio);
        Assert.assertTrue(driver.findElement(petroRadio).isSelected());
        Assert.assertFalse(driver.findElement(dieseRadio).isSelected());

        checkToElement(petroRadio);
        Assert.assertTrue(driver.findElement( dieseRadio).isSelected());
        Assert.assertFalse(driver.findElement(petroRadio).isSelected());

    }
    @Test
    public void TC004_SelectAll_CheckBox() {
        driver.get("https://automationfc.github.io/multiple-fields/");
//        div.form-single-column input[type='checkbox']
        List<WebElement> allCheckbox = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
//        Chọn check box 29 thằng
        for (WebElement checkbox : allCheckbox){
            if (!checkbox.isSelected()){
                checkbox.click();
                sleepInSeconds(1);
            }
        }
        // Verify tất cả các checkbox
        for (WebElement checkbox : allCheckbox){
            Assert.assertTrue(checkbox.isSelected());
        }
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        allCheckbox = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
        // chọn 1 check box / radio nào đó trong tất cả các check box/radio
        for (WebElement checkbox : allCheckbox){
           if(checkbox.getAttribute("value").equals("Heart Attack")){
               checkbox.click();
               sleepInSeconds(1);
           }
        }
        // Verify các check box còn lại k đc check ngoại trừ heart attack đã đc check
        for (WebElement checkbox : allCheckbox){
            if(checkbox.getAttribute("value").equals(" Heart Attack ")){
                Assert.assertTrue(checkbox.isSelected());
            }
            else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }
    }
    @Test
    public void TC005_Custom_Radio() {
        driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");

//        Case 1: dùng thẻ input để click ==> thẻ input bị che bởi 1 element khác = Failed
//        Case 2: dùng thẻ div bên ngoài để click
//        Dùng thẻ div để verify
        driver.findElement(By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/input")).click();
        sleepInSeconds(3);
//        Case 3 : Dùng thẻ div bên ngoài để click ==> passed
//                  dùng thẻ input để verify
//

//        Case 4:
//        Dùng thẻ input để click
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].click();");
        ((JavascriptExecutor)driver).executeScript("");
        By registerRadio= By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/input");
        


    }
    @Test
    public void TC006_Custom_Radio() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By canThoRadio = By.xpath("//div[@aria-label='Cần Thơ']");
//        By quangNamCheck By.xpath("//div[@aria-label='Cần Thơ']");

        // verify radio is not selected
        Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"),"false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ and @aria-checked='true'] ")).isDisplayed());


    }
    public void checkToElement(By byXpath){
        if(!driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }
    public void unCheckToElement(By byXpath){
        if(driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
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
