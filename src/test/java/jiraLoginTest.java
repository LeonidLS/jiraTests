import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class jiraLoginTest {

    private WebDriver driver;

    private By userName = By.xpath("//*[@id='login-form-username']");
    private By password = By.xpath("//*[@id='login-form-password']");
    private By loginButton = By.xpath("//*[@id='login']");

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\learning\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Test
    public void jiraLoginPageTest() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/");
        try {
            this.driver.findElement(userName).sendKeys("Leon");
            this.driver.findElement(password).sendKeys("killer");
            this.driver.findElement(loginButton).click();
            Thread.sleep(5000);
        } catch (NoSuchElementException | StaleElementReferenceException exception) {
            System.out.println("Web UI element wasn't found, or has been changed unexpectedly");
        }
    }

    @AfterTest
    public void finalize() {
        this.driver.quit();
    }
}
