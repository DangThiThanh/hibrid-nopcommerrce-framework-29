package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.UserAddressPO;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserOrderPO;
import pageObjects.nopCommerce.users.UserRewardPointPO;
import pageUIs.BasePageUI;
import pageUIs.jquery.HomePageUI;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
// Hamd static có thể truy cập được trực tiếp từ phạm vi class

    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).click();
    }

    public WebElement getElement(WebDriver driver, String localtor) {
        return driver.findElement(getByLocator(localtor));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }
    public List<WebElement> getListElement(WebDriver driver, String locator, String... restParameter) {
        return driver.findElements(getByLocator(castParameter(locator, restParameter)));
    }

    public By getByXPath(String localtor) {
        return By.xpath(localtor);
    }

    //    Truyền tham số vào loại gì thì sẽ trả về kiểu BY tương ứng
    protected By getByLocator(String prefixLocator) {
        By by = null;
        if (prefixLocator.toUpperCase().startsWith("CSS")) {
            by = By.cssSelector(prefixLocator.substring(4));
        } else if (prefixLocator.toUpperCase().startsWith("ID")) {
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.toUpperCase().startsWith("CLASS")) {
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.toUpperCase().startsWith("TAGNAME")) {
            by = By.tagName(prefixLocator.substring(8));
        } else if (prefixLocator.toUpperCase().startsWith("NAME")) {
            by = By.name(prefixLocator.substring(5));
        } else if (prefixLocator.toUpperCase().startsWith("XPATH")) {
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not support");
        }

        return by;
    }

    private String castParameter(String locator, String... restParameter) {
        return String.format(locator, (Object[]) restParameter);
    }

    public String getElementText(WebDriver driver) {
        return driver.findElement(By.cssSelector("")).getText();

    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
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

    public void refreshCurrentPage(WebDriver driver) {

        driver.navigate().refresh();

//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.navigate().back();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.navigate().forward();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.quit();
    }

    public String alert() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("thanh");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
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
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
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



    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(keyToSend);
    }
    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend, String... restParameter) {
        getElement(driver, castParameter(locator,restParameter)).clear();
        getElement(driver, castParameter(locator,restParameter)).sendKeys(keyToSend);
    }



    public void selectItemInDropdown(WebDriver driver, String locator, String textItem) {
        new Select(getElement(driver, locator)).selectByVisibleText(textItem);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String textItem, String... restParameter ) {
        new Select(getElement(driver, castParameter(locator, restParameter))).selectByVisibleText(textItem);
    }

    public String getSelectItemInDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSeconds(2);
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));
        sleepInSeconds(2);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public String getElementAttributeValue(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }
    public String getElementAttributeValue(WebDriver driver, String locator, String attributeName, String restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }
    public String getElementText(WebDriver driver, String locator, String restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getText();
    }


    public String getCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public void getHexaColorFromRGBA(WebDriver driver, String locator) {
        getCssValue(driver, locator, "Backgroud-color");

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

    public void checkToCheckboxRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }
    public void checkToCheckboxRadio(WebDriver driver, String locator , String... restParameter) {
        if (!getElement(driver, castParameter(locator, restParameter)).isSelected()) {
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }

    public void uncheckTheCheckbox(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }
    public void uncheckTheCheckbox(WebDriver driver, String locator, String... restParameter) {
        if (getElement(driver, castParameter(locator, restParameter)).isSelected()) {
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }
    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, castParameter(locator,restParameter)).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultPage(WebDriver driver, String locator) {
        driver.switchTo().defaultContent();
    }

    public void clickToElementByAction(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        actions.click(getElement(driver, locator)).perform();
    }

    public void releaseLeftMouse(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        actions.release();
    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(driver, locator)).perform();
    }

    public void rightClickElement(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        actions.contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourcelLocator, String targetLocator) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop((getElement(driver, sourcelLocator)), (getElement(driver, targetLocator))).perform();
    }


    public void pressKeyboardToElement(WebDriver driver, String locator, Keys keys) {
        Actions actions = new Actions(driver);
        actions.sendKeys(getElement(driver, locator), keys).perform();
    }
    public void pressKeyboardToElement(WebDriver driver, String locator, Keys keys, String... restParameter) {
        Actions actions = new Actions(driver);
        actions.sendKeys(getElement(driver, castParameter(locator, restParameter)), keys).perform();
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("wwindow.location= '" + url + "'");
    }

    public void highLightElement(String locator, WebDriver driver) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style',arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("argument[0].click();", getElement(driver, locator));
        sleepInSeconds(2);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("argument[0].scrollInToView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDown(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("argument[0].scrollInToView(false);", getElement(driver, locator));
    }

    public void setAttributeInDom(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("argument[0].setAttribute('" + attributeName + "','" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDom(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript(" return argument[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendKeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("argument[0].setAttribute(' value','" + value + "');", getElement(driver, locator));
    }

    public void getAttributeInDom(WebDriver driver, String locator, String attributeName) {
        ((JavascriptExecutor) driver).executeScript("argument[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMassage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript(" return argument[0].validationMessage;", getElement(driver, locator));
    }


    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementVisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator, restParameter))));
    }


    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }
    public void waitForElementSelected(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator, restParameter))));
    }

    public void waitForElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }
    public void waitForElementClickable(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator, restParameter))));
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames){
//        Lấy ra đường dẫn của thư mục upload file
        String filePath= GlobalConstants.UPLOAD_PATH;
        String fullFileName= "";
        for(String file: fileNames){
            fullFileName +=  filePath + file + "\n";
        }
        fullFileName= fullFileName.trim();
        getElement(driver, HomePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }

    //          Switch Page Object sử dụng cho test case số Lever_07_Switch_Page_Object
    public UserRewardPointPO openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
        clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPO openCustomerInforpage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.CUSTOMER_INFOR_LINK);
        clickToElement(driver, BasePageUI.CUSTOMER_INFOR_LINK);
        return new UserCustomerInfoPO(driver);
    }

    public UserAddressPO openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
        clickToElement(driver, BasePageUI.ADDRESS_LINK);
        return new UserAddressPO(driver);
    }

    public UserOrderPO openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ORDER_LINK);
        clickToElement(driver, BasePageUI.ORDER_LINK);
        return new UserOrderPO(driver);
    }


    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
