package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.Set;

public class DriverManager {
    public WebDriver driver;
    private static final String DEFAULT_BROWSER = "chrome";

    public void DriverSetup(String browser) {
        if (browser == null || browser.isEmpty()) {
            browser = DEFAULT_BROWSER;
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver(options);
                break;

            default:
                throw new IllegalArgumentException("Unsupported Browser: " + browser);
        }
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Call DriverSetup() first.");
        }
        return driver;
    }

    public void switchToNewTab() {
        Set<String> windowHandles = getDriver().getWindowHandles();
        String originalWindow = getDriver().getWindowHandle();

        if (windowHandles.size() > 1) {
            for (String handle : windowHandles) {
                if (!handle.equals(originalWindow)) {
                    getDriver().switchTo().window(handle);
                    break;
                }
            }
        } else {
            System.out.println("No new tab opened.");
        }
    }

    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
