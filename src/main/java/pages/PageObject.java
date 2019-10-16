package pages;
import org.openqa.selenium.By;

public class PageObject {
    //LoginPage Locators
    protected By userName = By.xpath("//*[@id='login-form-username']");
    protected By password = By.xpath("//*[@id='login-form-password']");
    protected By loginButton = By.xpath("//*[@id='login-form-submit']");
    protected By createButton = By.xpath("//*[@id='create_link']");

    //Create Issue Locators
    protected By createIssue = By.xpath("//*[@id='create_link']");
    protected By summaryContent = By.xpath("//*[@id='summary']");
    protected By createIssueSubmitButton = By.xpath("//*[@id='create-issue-submit']");
}
