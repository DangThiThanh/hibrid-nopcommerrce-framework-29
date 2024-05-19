package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
    public CustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
//    Hàm khỏi tạo (Constructor function)
//    1: Cùng tên với tên class
//    2: Không có kiểu trả về (data type)
//    3: Chạy đầu tiên khi class này được gọi (new HomePageObject)
//    4: Có tham số hoặc không
//    5: Không tựdefifine hàm khời tạo thì jvm sẽ mặc định tạo ra 1 hàm khởi tạo rỗng


    public boolean isGenderMaleSelected(){
        waitForElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getYearDropdownSelectedValue(){
        waitForElementClickable(driver,CustomerInfoPageUI.YEAR_DROPDOWN);
       return getSelectItemInDropdown(driver,CustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getMonthDropdownSelectedValue(){
        waitForElementClickable(driver,CustomerInfoPageUI.MONTH_DROPDOWN);
        return getSelectItemInDropdown(driver,CustomerInfoPageUI.MONTH_DROPDOWN);
    }
    public String getDayDropdownSelectedValue() {
        waitForElementClickable(driver,CustomerInfoPageUI.DAY_DROPDOWN);
        return getSelectItemInDropdown(driver,CustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String getFirstNameTextBoxValue() {
        waitForElementVisible(driver,CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttributeValue(driver,CustomerInfoPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getValueLastNameTexBoxValue() {
        waitForElementVisible(driver,CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttributeValue(driver,CustomerInfoPageUI.LAST_NAME_TEXTBOX,"value");
    }

    public String getMailTextBoxValue() {
        waitForElementVisible(driver,CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttributeValue(driver,CustomerInfoPageUI.EMAIL_TEXTBOX,"value");
    }

    public String getCompanyTextBoxValue() {
        waitForElementVisible(driver,CustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttributeValue(driver,CustomerInfoPageUI.COMPANY_TEXTBOX,"value");
    }
}
