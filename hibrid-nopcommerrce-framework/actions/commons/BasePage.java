package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public void clickToElement(WebDriver driver) {
        driver.findElement(By.cssSelector("")).click();
    }

    public String getElementText(WebDriver driver) {
        return driver.findElement(By.cssSelector("")).getText();

    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.getCurrentUrl();
    }

    public String getTitle(String url) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        String title = driver.getTitle();
        driver.quit();
        return title;
    }

    public String getCurrentUrl(String url) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        driver.quit();
        return currentUrl;
    }

    public String getPageSource(String url) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        String pageSource = driver.getPageSource();
        driver.quit();
        return pageSource;
    }

    public void navigationPage(WebDriver driver, String url) {
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(url);
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.quit();
    }

    public String alert() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("thanh");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());


//Store the alert text in a variable
        String text = alert.getText();
        alert.accept();
        this.sleepInSeconds(2);

//Press the OK button
//        alert.accept();
        driver.quit();
        return text;
    }

    public Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void getTextToAlert(WebDriver driver) {
        waitAlertPresence(driver).getText();
    }

    public void dismissToAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public WebElement getElement(WebDriver driver, String localtor) {
        return driver.findElement(By.xpath(localtor));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String key) {
        getElement(driver, locator).sendKeys(key);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String textItem) {
        new Select(getElement(driver, locator)).selectByVisibleText(textItem);
    }

    public void getSelectItemInDropdown(WebDriver driver, String locator) {
        new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSeconds(2);
        new WebDriverWait(driver, Duration.ofSeconds(15));
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));
        sleepInSeconds(2);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }

    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getTextElement(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public void getHexaColorFromRGBA(WebDriver driver, String locator) {
        getCssValue(driver, locator,"Backgroud-color");

    }
//    public void getListElementNumber (WebDriver driver, String locator){
//        return getListElement(driver,locator).size();
//    }


    public List<Integer> getElementSize(WebDriver driver, String locator) {
        Dimension size = getElement(driver, locator).getSize();
        int a = size.getHeight();
        int b = size.getHeight();
        List<Integer> result = new ArrayList<Integer>();
        result.add(a);
        result.add(b);
        return result;
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        WebElement checkBox = getElement(driver, locator);
        if (!checkBox.isSelected()) {
            checkBox.click(); // Chọn ô kiểm nếu chưa được chọn
        }
    }

    public void uncheckTheCheckbox(WebDriver driver, String locator) {
        WebElement checkBox = getElement(driver, locator);
        if (checkBox.isSelected()) {
            checkBox.click(); // bỏ tích ô kiểm nếu  được chọn
        }
    }

    public boolean isControlDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }
    public void  switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver,locator));
    }
    public void  switchToDefaultPage(WebDriver driver, String locator) {
        driver.switchTo().defaultContent();
    }
    public void doubleClickToElement(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        actions.doubleClick(getElement(driver, locator)).perform();
    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(driver, locator)).perform();
    }

    public void rightClick(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        actions.contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDrop(WebDriver driver, String sourcelLocator, String targetLocator) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop((getElement(driver, sourcelLocator)), (getElement(driver, targetLocator))).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys kyes) {
        Actions actions = new Actions(driver);
        actions.sendKeys(getElement(driver, locator),kyes).perform();
    }
    public void waitForElementVisible(WebDriver driver, String locator){

    }


    public static void main(String[] args) {
        BasePage basePage = new BasePage();
        System.out.println(basePage.navigationPage(new ChromeDriver(), "https://vnexpress.net/");

    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
