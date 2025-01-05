package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ActionsHelper;

import java.util.List;

public class QualityAssurancePage {
    private WebDriver driver;
    private ActionsHelper actionsHelper;

    private final By qualityAssuranceHeader = By.xpath("//h1[contains(text(), 'Quality Assurance')]");
    private final By acceptAllButton = By.id("wt-cli-accept-all-btn");
    private final By seeAllQAJobsButton = By.xpath("//a[text()='See all QA jobs']");
    private final By allOpenPositionsHeader = By.xpath("//h3[contains(text(), 'All open positions')]");
    private final By qaDepartmentFilter = By.xpath("//span[contains(@title, 'Quality Assurance')]");
    private final By locationDropdown = By.id("select2-filter-by-location-container");
    private final By istanbulOption = By.xpath("//li[contains(text(),'Istanbul, Turkey')]");
    private final By jobListItems = By.className("position-list-item");
    private final By jobLocationClass = By.className("position-location");
    private final By jobTeamClass = By.className("position-department");
    private final By firstViewRoleButton = By.xpath("//a[contains(text(), 'View Role')]");
    private final By jobWrapper = By.xpath("//div[contains(@class, 'position-list-item-wrapper')]");

    public QualityAssurancePage(WebDriver driver) {
        this.driver = driver;
        this.actionsHelper = new ActionsHelper(driver);
    }

    public WebElement getAcceptAllButton() {
        return actionsHelper.waitForElementToBeVisible(acceptAllButton);
    }

    public WebElement getSeeAllQAJobsButton() {
        return actionsHelper.waitForElementToBeVisible(seeAllQAJobsButton);
    }

    public WebElement getAllOpenPositionsHeader() {
        return actionsHelper.waitForElementToBeVisible(allOpenPositionsHeader);
    }

    public WebElement getQualityAssuranceHeader() {
        return actionsHelper.waitForElementToBeVisible(qualityAssuranceHeader);
    }

    public WebElement getQaDepartmentFilter() {
        return actionsHelper.waitForElementToBeVisible(qaDepartmentFilter);
    }

    public WebElement getLocationDropdown() {
        return actionsHelper.waitForElementToBeVisible(locationDropdown);
    }

    public WebElement getIstanbulOption() {
        return actionsHelper.waitForElementToBeVisible(istanbulOption);
    }

    public List<WebElement> getJobListItems() {
        actionsHelper.waitForElementToBeVisible(jobListItems);
        return driver.findElements(jobListItems);
    }

    public String getJobTeam(WebElement job) {
        WebElement departmentElement = job.findElement(jobTeamClass);
        return departmentElement.getText();
    }

    public String getJobLocation(WebElement job) {
        WebElement locationElement = job.findElement(jobLocationClass);
        return locationElement.getText();
    }

    public WebElement getFirstViewRoleButton() {
        return actionsHelper.waitForElementToBeVisible(firstViewRoleButton);
    }

    public WebElement getJobWrapper() {
        return actionsHelper.waitForElementToBeVisible(jobWrapper);
    }
}
