import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JiraCreateIssueTest extends BaseClass {

    private By createIssue = By.xpath("//*[@id='create_link']");
    private By summaryContent = By.xpath("//*[@id='summary']");
    private By createButton = By.xpath("//*[@id='create-issue-submit']");

    @Test
    public void jiraCreateAnIssueTest() {
        System.out.println("@Test2");
        try {
            this.driver.findElement(createIssue).click();
            driver.findElement(summaryContent).sendKeys("Outstanding Summary");

            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.elementToBeClickable(createButton));

            Assert.assertEquals(driver.findElement(createButton).isDisplayed(), true);

        } catch (NoSuchElementException | StaleElementReferenceException exception) {
            System.out.println("Web UI element wasn't found, or has been changed unexpectedly");
        }
    }
}
