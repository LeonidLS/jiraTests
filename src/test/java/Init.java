import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {

    protected static WebDriver driver;

    public static void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\learning\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
}
