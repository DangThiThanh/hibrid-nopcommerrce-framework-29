package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInforPageFactory extends BasePage{
    private WebDriver driver;
    public CustomerInforPageFactory(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="gender-male")
    private WebElement genderMaleRadio;

    @FindBy(id="FirstName")
    private WebElement firstNameTextbox;

    @FindBy(id="LastName")
    private WebElement lastNameTextbox;

    @FindBy(name="DateOfBirthDay")
    private WebElement dayDropdown;

    @FindBy(name="DateOfBirthMonth")
    private WebElement monthDropdown;

    @FindBy(name="DateOfBirthYear")
    private WebElement yearDropdown;

    @FindBy(id="Email")
    private WebElement emailTextbox;

    @FindBy(id="Company")
    private WebElement companyTextbox;
    public boolean isGenderMaleSelected() {
        waitForElementVisible(driver, genderMaleRadio);
        return isElementSelected(genderMaleRadio);
    }

    public String getValueLastNameTexBoxValue() {
        waitForElementVisible(driver,lastNameTextbox);
        return getElementAttributeValue(lastNameTextbox, "value");
    }

    public String getFirstNameTextBoxValue() {
        waitForElementVisible(driver,firstNameTextbox);
        return getElementAttributeValue(firstNameTextbox, "value");
    }

    public String getDayDropdownSelectedValue() {
        waitForElementClickable(driver, dayDropdown);
        return getSelectItemInDropdown(dayDropdown);
    }

    public String getMonthDropdownSelectedValue() {
        waitForElementClickable(driver, monthDropdown);
        return getSelectItemInDropdown(monthDropdown);
    }

    public String  getYearDropdownSelectedValue() {
        waitForElementClickable(driver, yearDropdown);
        return getSelectItemInDropdown(yearDropdown);
    }

    public String getMailTextBoxValue() {
        waitForElementVisible(driver,emailTextbox);
        return getElementAttributeValue(emailTextbox, "value");
    }

    public String getCompanyTextBoxValue() {
        waitForElementVisible(driver,companyTextbox);
        return getElementAttributeValue(companyTextbox, "value");
    }
}
