package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ActionsHelper;

public class CareersPage {
    private WebDriver driver;
    private ActionsHelper actionsHelper;

    private final By lifeAtInsiderHeader = By.xpath("//h2[@class='elementor-heading-title elementor-size-default' and text()='Life at Insider']");
    private final By locationsHeader = By.xpath("//*[@id=\"career-our-location\"]/div/div/div/div[1]/h3");
    private final By teamsHeader = By.linkText("See all teams");

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        this.actionsHelper = new ActionsHelper(driver);
    }

    public WebElement lifeAtInsider() {
        return actionsHelper.waitForElementToBeVisible(lifeAtInsiderHeader);
    }

    public WebElement locationsHeader() {
        return actionsHelper.waitForElementToBeVisible(locationsHeader);
    }

    public WebElement teamsHeader() {
        return actionsHelper.waitForElementToBeVisible(teamsHeader);
    }
}
