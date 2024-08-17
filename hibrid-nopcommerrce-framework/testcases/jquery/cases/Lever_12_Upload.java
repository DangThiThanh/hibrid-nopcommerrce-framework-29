package jquery.cases;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class Lever_12_Upload extends BaseTest {
    private HomePO homePage;

    private  String anh1, anh2, anh3;


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver= getBrowserDriver(browserName,url);

        homePage= PageGenerator.getHomePage(driver);

        anh1="anh1.png";
        anh2="anh2.jpg";
        anh3="anh3.jpg";
    }

    @Test
    public void Upload_01() {
//        Lây ra được những đường dẫn của file/thư mục cho đúng
//        tất cả các OS: Window/ MAC/ LINUX đều chạy được
//        Có thể upload 1 lần 1 file -> dùng 1 hàm
        homePage.uploadMultipleFiles(driver,anh1);
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);

//        có thể upload 1 lần nhiều file
        homePage.uploadMultipleFiles(driver,anh1, anh2);
        homePage.refreshCurrentPage(driver);

        homePage.uploadMultipleFiles(driver,anh1, anh2);
//        Verify load file lên
        Assert.assertTrue(homePage.isFileLoadedByName(anh1));
        Assert.assertTrue(homePage.isFileLoadedByName(anh2));
        Assert.assertTrue(homePage.isFileLoadedByName(anh3));
//        Click Upload button tại từng file

        homePage.clickToUploadButton(driver);


//        Có thể verify -> dùng 1 hàm
//        Assert.assertTrue(homePage.isFileUpload);
//        có cần care tới open dialog k

    }

    @Test
    public void User_02_Login() {


    }

    @Test
    public void User_03_MyAccount() {



    }

//    @Test
//    public void User_04_Action_By_Index(){
////    có thể thao tác với bất cứ row nào và column
//        driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
//        homePage.clickToLoadDataButton();
//
//        homePage.enterToTextboxByIndex("4","Contact Person","Blondy Boggis");
//
//        homePage.enterToTextboxByIndex("2","Contact Person","Paulie Poel");
//
//        homePage.selectToDropDownByIndex("6","Country","Hong Kong");
//
//        homePage.selectToDropDownByIndex("8","Country","Japan");
//
//        homePage.checkToCheckBoxByIndex("6","NPO?",true);
//
//        homePage.checkToCheckBoxByIndex("5","NPO?",false);
//
//        homePage.clickToIconByIndex("5","NPO?","false");
//


//    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }
}
