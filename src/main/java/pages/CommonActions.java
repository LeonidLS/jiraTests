package pages;

import org.openqa.selenium.*;

public class CommonActions {

    WebDriver driver;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    protected void findElementAndClick(By element) {
        try {
            driver.findElement(element).click();
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e) {
            e.printStackTrace();
        }
    }

    protected void sendTextToElement(By element, String textEntry) {
        try {
            driver.findElement(element).sendKeys(textEntry);
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e) {
            e.printStackTrace();
        }
    }


}
