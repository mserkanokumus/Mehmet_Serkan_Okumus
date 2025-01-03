package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ActionsHelper;

public class GlobalElements {
    private WebDriver driver;
    private ActionsHelper actionsHelper;

    private final By companyMenu = By.linkText("Company");
    private final By careersLink = By.linkText("Careers");

    public GlobalElements(WebDriver driver) {
        this.driver = driver;
        this.actionsHelper = new ActionsHelper(driver);
    }

    public WebElement getCompanyMenu() {
        return actionsHelper.waitForElementToBeVisible(companyMenu);
    }
    public WebElement getCareersLink() {
        return actionsHelper.waitForElementToBeVisible(careersLink);
    }
}
