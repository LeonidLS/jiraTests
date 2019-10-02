import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class JiraCreateIssueTest extends Init {

    private By createIssue = By.xpath("//*[@id='create_link']");
    private By summaryContent = By.xpath("//*[@id='summary']");
    private By createButton = By.xpath("//*[@id='create-issue-submit']");
    private By setReporter = By.xpath("//*[@id='reporter-field']");

    @Test
    public void jiraLoginPageTest() throws InterruptedException {
        driver.get("https://jira.hillel.it/");
        try {
            driver.findElement(createIssue).click();
            Thread.sleep(1000);
            driver.findElement(summaryContent).sendKeys("Outstanding Summary");
            driver.findElement(setReporter).sendKeys("Leonid");
            driver.findElement(createButton).click();
            Thread.sleep(20000);
        } catch (NoSuchElementException | StaleElementReferenceException exception) {
            System.out.println("Web UI element wasn't found, or has been changed unexpectedly");
        }
    }

    @AfterTest
    public void finalize() {
        driver.quit();
    }
}
