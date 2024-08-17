package commons;

import java.io.File;

public class GlobalConstants {

    public static final long SHORT_TIMEOUT = 30;
    public static final long LONG_TIMEOUT = 30;

//    DOWLOAD/ UPLOAD FILE


    public static final String SEPARATOR = System.getProperty("file.separator");

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;
}
