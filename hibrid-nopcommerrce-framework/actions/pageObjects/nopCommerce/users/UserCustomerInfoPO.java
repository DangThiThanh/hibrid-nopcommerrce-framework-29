package pageObjects.nopCommerce.users;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {
    public UserCustomerInfoPO(WebDriver driver) {
        super(driver);
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
        waitForElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getYearDropdownSelectedValue(){
        waitForElementClickable(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
       return getSelectItemInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getMonthDropdownSelectedValue(){
        waitForElementClickable(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
        return getSelectItemInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
    }
    public String getDayDropdownSelectedValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
        return getSelectItemInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String getFirstNameTextBoxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttributeValue(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getValueLastNameTexBoxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttributeValue(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX,"value");
    }

    public String getMailTextBoxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttributeValue(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX,"value");
    }

    public String getCompanyTextBoxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttributeValue(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX,"value");
    }


}
