package pages;

import org.openqa.selenium.WebDriver;

public class NewIssuePage extends PageObject {

    WebDriver driver = null;
    CommonActions commonActions = null;

    public NewIssuePage(WebDriver driver) {
        this.driver = driver;
        commonActions = new CommonActions(driver);
    }

    public void clickOnCreateNewIssueButton() {
        commonActions.findElementAndClick(createButton);
    }

    public void enterIssueSummarty(String issueSummaryToEnter) {
        commonActions.sendTextToElement(summaryContent, issueSummaryToEnter);
    }

    public void clickSubmitIssueButton() {
        commonActions.findElementAndClick(createIssueSubmitButton);
    }
}

