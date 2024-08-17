package javaOOP;

import java.io.File;

public class SystemInformation {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        System.out.println(osName);
//        Lấy ra đường dẫn tương đối
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String danangImagePath=projectPath + File.separator +"uploadFiles"+  File.separator +"anh1.jpg";
        System.out.println(danangImagePath);

    }
}
