package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;

public class Demo_DropDown_Custom {
    WebDriver driver;

    // Tường minh: trạng thái cụ thể cho element
    // Visible / Invisible / Presense / Number / Clickable / ..
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Ngầm định: Không rõ ràng cho 1 trạng thái cụ thể nào của element hết
        // Cho việc tìm element - findElement(s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        // 1: Click vào 1 thẻ để cho nó xổ hết các item bên trong dropdown ra
        driver.findElement(By.cssSelector("span#number-button")).click();
        sleepInSeconds(10);

        // 2.1: Nó sẽ xổ ra chứa hết tất cả item
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));

        List<WebElement> allElements = driver.findElements(By.cssSelector("ul#number-menu  div"));

        for (WebElement element : allElements) {
            String textElement = element.getText();
            System.out.println("Text item = " + textElement);

            if (textElement.equals("8")) {
                element.click();
                break;
            }
        }
    }
    // 2.2 - Nó sẽ xổ ra nhưng chỉ chứa 1 phần và đang load thêm
    // 3.1 - Nếu như item cần chọn nó hiển thị thì click vào
    // 3.2 - Nếu như item cần chọn nằm bên dưới thì 1 số trường hợp cần scroll xuống để hiển thị lên rồi mới chọn (Angular/ React/ VueJS/..)
    // 4 - Trước khi click cần kiểm tra nếu như text của item bằng vs item cần chọn thì click vào

    @Test
    public void TC_02_() {
    }

    @Test
    public void TC_03_() {
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
