package cases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.OpenPositionsPage;
import pages.QualityAssurancePage;
import utilities.ActionsHelper;
import utilities.DriverManager;
import utilities.EnvironmentManager;

import java.util.List;

public class VerifyApplicationForm {
    DriverManager driverManager;
    QualityAssurancePage qualityAssurancePage;
    OpenPositionsPage openPositionsPage;
    ActionsHelper actionsHelper;

    @BeforeClass
    public void setup() {
        driverManager = new DriverManager();
        driverManager.DriverSetup("");
        driverManager.driver.get(EnvironmentManager.getBaseUrl() + "/careers/quality-assurance/");

        qualityAssurancePage = new QualityAssurancePage(driverManager.driver);
        openPositionsPage = new OpenPositionsPage(driverManager.driver);
        actionsHelper = new ActionsHelper(driverManager.driver);

        qualityAssurancePage.getAcceptAllButton().click();
    }

    @Test(priority = 4)
    public void verifyQualityAssurancePage() {
        Assert.assertTrue(qualityAssurancePage.getQualityAssuranceHeader().isDisplayed());
        System.out.println("Quality Assurance page is displayed successfully.");
    }

    @Test(priority = 5)
    public void verifyOpenPositionsPage(){
        qualityAssurancePage.getSeeAllQAJobsButton().click();
        Assert.assertTrue(qualityAssurancePage.getAllOpenPositionsHeader().isDisplayed());
        System.out.println("Open positions page is displayed successfully.");
    }

    @Test(priority = 6)
    public void checkJobList() {
        qualityAssurancePage.getQaDepartmentFilter();
        actionsHelper.waitForPageToLoad();
        qualityAssurancePage.getLocationDropdown().click();
        qualityAssurancePage.getIstanbulOption().click();
        actionsHelper.waitForPageToLoad();

        actionsHelper.scrollToElement(qualityAssurancePage.getLocationDropdown());

        List<WebElement> jobList = qualityAssurancePage.getJobListItems();

        for (WebElement job : jobList) {
            String jobLocation = qualityAssurancePage.getJobLocation(job);
            String jobTeam = qualityAssurancePage.getJobTeam(job);

            actionsHelper.hoverOverElement(qualityAssurancePage.getJobWrapper());

            qualityAssurancePage.getFirstViewRoleButton();

            Assert.assertEquals(jobTeam != null ? jobTeam : "", "Quality Assurance", "Job department does not match!");
            Assert.assertEquals(jobLocation, "Istanbul, Turkey", "Job department does not match!");
        }
    }

    @Test(priority = 7)
    public void verifyApplicationPageContents() {
        actionsHelper.hoverOverElement(qualityAssurancePage.getLocationDropdown());
        qualityAssurancePage.getFirstViewRoleButton().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driverManager.switchToNewTab();
        Assert.assertTrue(openPositionsPage.getApplicationFormHeader().isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driverManager.TearDown();
    }
}
