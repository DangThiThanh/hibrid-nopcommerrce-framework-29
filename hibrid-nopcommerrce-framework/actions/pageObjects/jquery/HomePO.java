package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;
import pageUIs.nopCommerce.users.UserCustomerInfoPageUI;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA);
        clickToElement(driver, HomePageUI.LOAD_DATA);
    }

    public void enterToTextboxByIndex(String rowIndex, String columnName, String valueToSendkey) {

//        Từ column name làm sao để lấy ra được column index
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLLING_COLUMN_NUMBER, columnName).size() + 1;

//        Convert nó qua dạng text(String)
        String columnIndex = String.valueOf(columnIndexNumber);

//      Truyền 2 giá trị : rowIndex/ columnIndex vào locator tương tác và sendkey
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);
    }


    public void selectToDropDownByIndex(String rowIndex, String columnName, String valueToSelect) {
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLLING_COLUMN_NUMBER, columnName).size() + 1;

        String columnIndex = String.valueOf(columnIndexNumber);

        selectItemInDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX, valueToSelect, rowIndex, columnIndex);

    }

    public void checkToCheckBoxByIndex(String rowIndex, String columnName, boolean checkOrUnCheck) {

        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLLING_COLUMN_NUMBER, columnName).size() + 1;

        String columnIndex = String.valueOf(columnIndexNumber);

        if (checkOrUnCheck) {
            checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        } else {
            uncheckTheCheckbox(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        }
    }

    public void clickToIconByIndex(String rowIndex, String iconName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX, rowIndex, iconName);
        clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX, rowIndex, iconName);
    }

    // Thanh tự làm vcho Table_04_Get_All_Row_By_Column
    public void getAllValueInCloumnName(String columnName) {

        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLLING_COLUMN_NUMBER, columnName).size() + 1;

        String columnIndex = String.valueOf(columnIndexNumber);

        List<WebElement> listWebElement = getListElement(driver, HomePageUI.DYNAMIC_VALUE_BY_COLUMN, columnIndex);
        var allValue = new ArrayList<String>();

        for (int i = 0; i < listWebElement.size(); i++) {
            allValue.add(listWebElement.get(i).getAttribute("value"));
        }

        System.out.println(allValue);

    }

    //     Thầy làm
    public  List<String>  getAllValueAtCloumnName(String columnName) {

        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLLING_COLUMN_NUMBER_2, columnName).size() + 1;

        String columnIndex = String.valueOf(columnIndexNumber);

        List<WebElement> allValueAtColumn  = getListElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, columnIndex);

        List<String> allTextValue =new ArrayList<String>();

        for(WebElement element : allValueAtColumn){

            allTextValue.add(element.getText());
        }

        System.out.println(allTextValue);
        return allTextValue;
    }

    public  List<String> getAllValueAtRow(String rowIndex) {


        List<WebElement> allValueAtColumn  = getListElement(driver, HomePageUI.ALL_VALUE_BY_ROW_INDEX, rowIndex);

        List<String> allTextValue =new ArrayList<String>();

        for(WebElement element : allValueAtColumn){

            allTextValue.add(element.getText());
        }
        System.out.println(allTextValue);
        return allTextValue;

    }

    public void openPgaeByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        sleepInSeconds(2);
    }

    public boolean isPageNumberActived(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        return getElementAttributeValue(driver, HomePageUI.DYNAMIC_PAGE_LINK, "class", pageNumber).endsWith("active");
    }

    public void enterToTextboxByHeaderName(String headerName, String valueToSendkey) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_HEADER_NAME, headerName);
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_HEADER_NAME, valueToSendkey, headerName);
        pressKeyboardToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_HEADER_NAME, Keys.ENTER, headerName);
    }

    public boolean isRowDataValueDisplay(String female, String country, String male, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ROW, female, country, male, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_DATA_ROW, female, country, male, total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);


    }

    public void editRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
    }


    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_LOADED_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_LOADED_BY_FILE_NAME, fileName);
    }

    public void clickToUploadButton(WebDriver driver) {
    }
}
