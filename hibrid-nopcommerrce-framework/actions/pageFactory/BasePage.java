
package pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
// Hàm static có thể truy cập được trực tiếp từ phạm vi class


    public void clickToElement(WebElement element){
        element.click();
    }
    public void sendKeyToElement(WebElement element , String key) {
        element.sendKeys(key);
    }
    public void selectItemInDropdown(WebElement element, String textItem) {
        new Select(element).selectByVisibleText(textItem);
    }

    public String getSelectItemInDropdown(WebElement element) {
               return new Select(element).getFirstSelectedOption().getText();
    }
    public String getElementAttributeValue(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }
    public String getElementText(WebElement element) {

        return element.getText();
    }
    public boolean isElementDisplayed(WebElement element) {
        return  element.isDisplayed();
    }
    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }
    public void waitForElementVisible( WebDriver driver, WebElement  element){
        new WebDriverWait(driver,Duration.ofSeconds(15)).
                until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementSelected(WebDriver driver, WebElement  element){
        new WebDriverWait(driver,Duration.ofSeconds(15)).
                until(ExpectedConditions.elementToBeSelected(element));
    }
    public void waitForElementClickable(WebDriver driver, WebElement  element){
        new WebDriverWait(driver,Duration.ofSeconds(15)).
                until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void main(String[] args) {


    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
