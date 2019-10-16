import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewIssuePage;
import pages.PageObject;

import java.util.concurrent.TimeUnit;

public class JiraTestSuite extends PageObject {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginToJiraTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.loginToJira("webinar5", "webinar5");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(this.driver.findElement(createButton).isDisplayed());
    }

    @Test
    public void createIssue() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.loginToJira("webinar5", "webinar5");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(this.driver.findElement(createButton).isDisplayed());

        NewIssuePage newIssuePage = new NewIssuePage(driver);
        newIssuePage.clickOnCreateNewIssueButton();
        newIssuePage.enterIssueSummarty("New Issue");
        newIssuePage.clickSubmitIssueButton();
        Assert.assertEquals(driver.findElement(createButton).isDisplayed(), true);
    }


    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
