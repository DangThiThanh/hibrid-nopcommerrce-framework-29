package webdriver;
    import java.util.concurrent.TimeUnit;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.locators.RelativeLocator;
    import org.testng.Assert;
    import org.testng.annotations.AfterClass;
    import org.testng.annotations.BeforeClass;
    import org.testng.annotations.Test;
public class Topic_03_Selenium_Relative {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    @Test
    public void TC_01_relative(){
        //drive.get('');
            By loginButtonBy = By.cssSelector("button.login-button");
         WebElement loginButtonElement=driver.findElement(By.cssSelector(("button.login-button")));
         // Remenber me check box
        By rememberMeCheckBoxBy= By.id("RememberMe");
        By forgotPasswordText = By.cssSelector("input#Password");
//        WebElement remenberMeTextElement = driver.findElement(RelativeLocator.with(By.tabName("lable")).
//                above(loginButtonBy)
//                .toRightOf(rememberMeCheckBoxBy)
//                .toLeftOf(forgotPasswordText)
//                .below()
//        )
    }


}
