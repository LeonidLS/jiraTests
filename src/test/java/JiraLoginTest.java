import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JiraLoginTest extends BaseClass {

    private By userName = By.xpath("//*[@id='login-form-username']");
    private By password = By.xpath("//*[@id='login-form-password']");
    private By loginButton = By.xpath("//*[@id='login']");
    private By createButton = By.xpath("//*[@id='create_link']");

    @Test //(priority = 1)
    public void jiraLoginPageTest() {
        System.out.println("@Test1");
       // this.driver.get("https://jira.hillel.it/");
        try {
            driver.findElement(userName).sendKeys("webinar5");
            driver.findElement(password).sendKeys("webinar5");
            driver.findElement(loginButton).click();

        } catch (NoSuchElementException | StaleElementReferenceException exception) {
            System.out.println("Web UI element wasn't found, or has been changed unexpectedly");
        }

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(createButton));

        Assert.assertTrue(this.driver.findElement(createButton).isDisplayed());
    }
}
