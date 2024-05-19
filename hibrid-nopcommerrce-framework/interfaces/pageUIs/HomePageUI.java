package pageUIs;

public class HomePageUI {
    public static  final String  REGISTER_LINK="//a[@class='ico-register']";
    // public: gọi hàm/ biến ra sử dụng bình thường
    // private/ default: khác package ko dùng được
    // protected: các class bên PO ko kế thừa PUI nên ko áp dụng
    // static: cho phép gọi trực tiếp từ class
    // final: ngăn việc update lại giá trị trong quá trình chạy
    // String: Vì cái By locator của Selenium đều nhận vào String
    // REGISTER_LINK: static final để quy ước 1 biến là HẰNG SỐ trong JAVA
    // Convention cho hằng số: phải viết hoa - nhiều hơn 1 từ thì phải dùng dấu _ để phân tách

    public  static final String MY_ACCOUNT_LINK="//a[@class='ico-account']";




}
