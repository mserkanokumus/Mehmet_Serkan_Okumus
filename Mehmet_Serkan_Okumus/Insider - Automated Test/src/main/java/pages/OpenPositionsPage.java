package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ActionsHelper;

public class OpenPositionsPage {
    private WebDriver driver;
    private ActionsHelper actionsHelper;

    private final By applicationFormHeader = By.xpath("//h2[text()='Senior Software Quality Assurance Engineer']");

    public OpenPositionsPage(WebDriver driver) {
        this.driver = driver;
        this.actionsHelper = new ActionsHelper(driver);
    }

    public WebElement getApplicationFormHeader() {
        return actionsHelper.waitForElementToBeVisible(applicationFormHeader);
    }
}
