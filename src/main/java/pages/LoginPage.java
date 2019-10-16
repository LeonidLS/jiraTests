package pages;

import org.openqa.selenium.WebDriver;

import static pages.PagesURLs.loginPage;

public class LoginPage extends PageObject {
    WebDriver driver = null;
    CommonActions commonActions = null;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.commonActions = new CommonActions(driver);
    }

    public void navigate() {
        driver.get(loginPage);
    }

    public void enterUserName(String userNameString) {
        commonActions.sendTextToElement(userName, userNameString);
    }

    public void enterUsePassword(String userPasswordString) {
        commonActions.sendTextToElement(password, userPasswordString);
    }

    public void clickOnLoginButton() {
        commonActions.findElementAndClick(loginButton);
    }

    public void loginToJira(String name, String password) {
        enterUserName(name);
        enterUsePassword(password);
        clickOnLoginButton();
    }
}
