package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_User_Interactions {
    WebDriver driver;
    Actions actions;
    String fullName;
    WebElement element;
    public  String getFullName(){
        return fullName;
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC001_Hover() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageInput= driver.findElement(By.cssSelector("input#age"));
        actions.moveToElement(ageInput).perform();
        sleepInSeconds(10);
        System.out.println(driver.findElement(By.cssSelector("div.ui-helper-hidden-accessible")).getText());
       Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-helper-hidden-accessible")).getText(),"We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC002_Hover_Menu_Fahasa() {
        driver.get("https://www.fahasa.com/");
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='icon_menu']"))).perform();
        sleepInSeconds(2);
        WebElement liBachHoaOnline = driver.findElement(By.xpath("//a[@title='Bách Hóa Online - Lưu Niệm']"));
        actions.moveToElement(liBachHoaOnline).perform();
        sleepInSeconds(2);
        WebElement liThietBiSo= driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']"));
        actions.click(liThietBiSo).perform();
        sleepInSeconds(1);
        Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong")).getText(),"THIẾT BỊ SỐ - PHỤ KIỆN SỐ");

    }
    @Test
    public void TC003_Hover_Menu_Fahasa() {
        driver.get("https://www.fahasa.com/");
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='icon_menu']"))).perform();
        List<WebElement> menuElements = driver.findElements(By.xpath("//ul[contains(@class,'verticalmenu')]/li"));
        for (WebElement element : menuElements) {
            String textElement = element.getText();
            actions.moveToElement(element).perform();
            sleepInSeconds(2);
            boolean isHovered = driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//span[@class='menu-title']")).getText().equalsIgnoreCase(textElement);
            if(isHovered){
                System.out.println("Element: " + textElement + " đã hover và hiện menu");
            }else {
                System.out.println("Element: " + textElement + " đã hover nhưng không hiện menu");
            }
        }
    }

    @Test
    public void TC004_Click_Hold() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumbers = driver.findElements(By.xpath("//ol[@class='ui-selectable']//li[contains(@class,'ui-state-default')]"));
        actions.clickAndHold(allNumbers.get(0)).pause(2000).moveToElement(allNumbers.get(3)).release().perform();
        sleepInSeconds(2);
        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        System.out.println(allNumbersSelected.size());
    }

    @Test
    public void TC005_Double_Click() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement elementDoubleClick = driver.findElement(By.xpath("//button[text()='Double click me']"));
        actions.doubleClick(elementDoubleClick).perform();
        sleepInSeconds(2);

    }
    @Test
    public void TC006_Right_Click() {

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
