import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JiraCreateIssueTest extends Init {

    private By createIssue = By.xpath("//*[@id='create_link']");
    private By summaryContent = By.xpath("//*[@id='summary']");
    private By createButton = By.xpath("//*[@id='create-issue-submit']");
    private By setReporter = By.xpath("//*[@id='reporter-field']");


    @Test(priority = 2)
    public void jiraLoginPageTest() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
        try {
            driver.findElement(createIssue).click();
            driver.findElement(summaryContent).sendKeys("Outstanding Summary");
            driver.findElement(setReporter).sendKeys("Leonid");
            driver.findElement(createButton).click();
        } catch (NoSuchElementException | StaleElementReferenceException exception) {
            System.out.println("Web UI element wasn't found, or has been changed unexpectedly");
        }
    }

    @AfterTest
    public void finalize() {
        driver.quit();
    }
}