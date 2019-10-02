import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JiraLoginTest extends Init {

    private By userName = By.xpath("//*[@id='login-form-username']");
    private By password = By.xpath("//*[@id='login-form-password']");
    private By loginButton = By.xpath("//*[@id='login']");

    @BeforeTest
    public void callInit() {
        Init.init();
    }

    @Test(priority = 1)
    public void jiraLoginPageTest() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/");
        try {
            driver.findElement(userName).sendKeys("Leon");
            driver.findElement(password).sendKeys("killer");
            driver.findElement(loginButton).click();
            Thread.sleep(5000);
        } catch (NoSuchElementException | StaleElementReferenceException exception) {
            System.out.println("Web UI element wasn't found, or has been changed unexpectedly");
        }
    }
}
