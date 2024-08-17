package jquery.cases;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class Lever_11_Data_Table extends BaseTest {
    private HomePO homePage;


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver= getBrowserDriver(browserName,url);

        homePage= PageGenerator.getHomePage(driver);

    }

//    @Test
    public void Table_01() {
        homePage.openPgaeByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActived("15"));
        homePage.openPgaeByNumber("5");
        Assert.assertTrue(homePage.isPageNumberActived("5"));
        homePage.openPgaeByNumber("12");
        Assert.assertTrue(homePage.isPageNumberActived("12"));

    }

//    @Test
    public void Table_02_Search() {
//enter to text box
        homePage.enterToTextboxByHeaderName( "Country","Angola");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueDisplay("276880","Angola","276472","553353"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName( "Males","407124");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueDisplay("384187","Afghanistan","407124","791312"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName( "Females","750");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueDisplay("750","Aruba","756","1504"));
        homePage.refreshCurrentPage(driver);

    }

//    @Test
    public void Table_03_Delete_Edit() {
        // click to delete button
        homePage.enterToTextboxByHeaderName( "Country","Afghanistan");
        homePage.sleepInSeconds(3);
        homePage.deleteRowByCountryName("Afghanistan");
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName( "Country","Algeria");
        homePage.sleepInSeconds(3);
        homePage.deleteRowByCountryName("Algeria");
        homePage.refreshCurrentPage(driver);

        // click to edit button
        homePage.enterToTextboxByHeaderName( "Country","Argentina");
        homePage.sleepInSeconds(3);
        homePage.editRowByCountryName("Argentina");
        homePage.refreshCurrentPage(driver);
    }

//     thanh tự làm
//    @Test
    public void Table_04_Get_All_Row_By_Column(){
        homePage.openPageUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.clickToLoadDataButton();
        homePage.getAllValueInCloumnName("Member Since");
    }

//     Thầy làm:

    @Test
    public void Table_05_Get_All_Value_Row_By_Column(){

        homePage.getAllValueAtCloumnName("Country");
        homePage.getAllValueAtRow("4");

    }

//    @Test
    public void User_04_Action_By_Index(){
        homePage.openPageUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

//    có thể thao tác với bất cứ row nào và column

        homePage.clickToLoadDataButton();

//        homePage.enterToTextboxByIndex("4","Contact Person","ThanhDT");
//
//
//        homePage.enterToTextboxByIndex("2","Company","DuongPV");
//
//
//
//        homePage.selectToDropDownByIndex("6","Country","Hong Kong");
//        homePage.sleepInSeconds(3);
//
//        homePage.selectToDropDownByIndex("8","Country","Taiwan");
//        homePage.sleepInSeconds(3);
//
//        homePage.checkToCheckBoxByIndex("6","NPO?",true);
//
//        homePage.checkToCheckBoxByIndex("5","NPO?",false);
//        Sau mỗi sự kiện đã theo tác thì index của row bị cập nhật lạo

        homePage.clickToIconByIndex("8","Move Up");
        homePage.sleepInSeconds(3);

        homePage.clickToIconByIndex("6","Remove");
        homePage.sleepInSeconds(3);

        homePage.clickToIconByIndex("4","Insert");
        homePage.sleepInSeconds(3);

    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }
}
