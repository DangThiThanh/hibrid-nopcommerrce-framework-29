package javaOOP;

public class StringFormat {

//    public static void clickToDeleteIcon(String locator, String female) {
//        System.out.println("delete to icon: " + String.format(locator, female));
//    }
//    public static void clickToDeleteIcon(String locator,String country, String female) {
//        System.out.println("delete to icon: " + String.format(locator,country, female));
//    }
    public static void clickToDeleteIcon(String locator,String ... restParameter){
        System.out.println("delete to icon: " + String.format(locator,(Object[]) restParameter));
    }

    public static void main(String[] args) {
        String DELETE_ICON_BY_DEMALE = "//td[@data-key='females' and text()='%s']/preceding-sibling::td/button[@class='qgrd-edit-row-btn']";
        String DELETE_ICON_BY_DEMALE_COUNTRY = "//td[@data-key='country' and text()='%s']/preceding-sibling::" +
                "td[@data-key='%s' and text()='%s']/preceding-sibling::td/button[@class='qgrd-edit-row-btn']";

        clickToDeleteIcon(DELETE_ICON_BY_DEMALE, "123456");
        clickToDeleteIcon(DELETE_ICON_BY_DEMALE_COUNTRY,"AFRICA"," thanh test","12253515");

    }
}
