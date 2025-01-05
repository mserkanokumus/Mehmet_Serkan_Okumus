package cases;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.CareersPage;
import pages.GlobalElements;
import pages.HomePage;
import utilities.DriverManager;
import utilities.EnvironmentManager;

public class VerifyCareersPage {

    DriverManager driverManager;
    HomePage homePage;
    CareersPage careersPage;
    GlobalElements globalElements;

    @BeforeClass
    public void setup() {
        driverManager = new DriverManager();
        driverManager.DriverSetup("");
        driverManager.driver.get(EnvironmentManager.getBaseUrl());

        homePage = new HomePage(driverManager.driver);
        globalElements = new GlobalElements(driverManager.driver);
        careersPage = new CareersPage(driverManager.driver);
    }

    @Test(priority = 1)
    public void verifyHomePage() {
        try {
            Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed!");
            System.out.println("Home page is displayed successfully.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    public void navigateToCareersPage() {
        globalElements.getCompanyMenu().click();
        globalElements.getCareersLink().click();
    }

    @Test(priority = 3)
    public void verifyCareersPageElements() {
        Assert.assertTrue(careersPage.lifeAtInsider().isDisplayed(), "The 'Life at Insider' header is not visible!");
        System.out.println("'Life at Insider' header is displayed successfully.");

        Assert.assertTrue(careersPage.locationsHeader().isDisplayed(), "The 'Locations' header is not visible!");
        System.out.println("'Locations' header is displayed successfully.");

        Assert.assertTrue(careersPage.teamsHeader().isDisplayed(), "The 'Teams' header is not visible!");
        System.out.println("'Teams' header is displayed successfully.");
    }

    @AfterClass
    public void tearDown() {
        driverManager.TearDown();
    }
}
