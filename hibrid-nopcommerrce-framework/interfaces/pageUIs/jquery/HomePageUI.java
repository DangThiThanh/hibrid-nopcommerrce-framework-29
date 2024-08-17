package pageUIs.jquery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_LINK = "Xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_HEADER_NAME = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_DATA_ROW = "xpath=//td[@data-key='females'and text()='%s']/following-sibling::" +
            "td[@data-key='country' and text()='%s']/following-sibling::" +
            "td[@data-key='males' and text()='%s']/following-sibling::" +
            "td[@data-key='total' and text()='%s']";
    public static final String DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::" +
            "td[@class='qgrd-actions']/button[contains(@class,'remove')]";
    public static final String DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::" +
            "td[@class='qgrd-actions']/button[contains(@class,'edit')]";
    public static final String LOAD_DATA = "css=button#load";

    public static final String DYNAMIC_PRECEDING_SIBLLING_COLUMN_NUMBER = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]/input";
    public static final String DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
//    cách 2 lấy thẳng dropDownlist luôn
//public static final String DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX  ="xpath=//td[%s]//select[@id='tblAppendGrid_country_%s']";

    public static final String DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//input[@type='checkbox']";

    public static final String DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td//button[starts-with(@title,'%s')]";

    //    Thanh tự làm  Table_04_Get_All_Row_By_Column
    public static final String DYNAMIC_VALUE_BY_COLUMN = "xpath=//td[%s]/input";

    //  Thầy Làm
    public static final String DYNAMIC_PRECEDING_SIBLLING_COLUMN_NUMBER_2= "xpath=//div[text()='Country']/ancestor::th/preceding-sibling::th";
    public static final String ALL_VALUE_BY_COLUMN_INDEX= "xpath=//td[%s]";
    public static final String ALL_VALUE_BY_ROW_INDEX= "xpath=//tr[%s]/td[@data-key]";

    //    Jquery
    public static final String  UPLOAD_FILE_TYPE ="css=input[type='file']";
    public static final String  FILE_LOADED_BY_FILE_NAME ="xpath=//p[@class='name' and text()='%s']";
    public static final String  UPLOAD_BUTTON ="Css=td>button.start";
    public static final String  FILE_UPLOAD_SUCCESS_BY_FILE_NAME ="Css=//p[@class='name']/a[@title='%s']";
}
