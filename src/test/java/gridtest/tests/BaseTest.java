package gridtest.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import gridtest.PropertyReader;

import gridtest.tests.commons.Commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {
    public WebDriver driver;
    public String hubURL, baseURL;
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
    public Commons commons = new Commons();

    @Parameters({"browser", "destination"})
    @BeforeTest
    public void startTest(String browser, String destination) throws MalformedURLException {

        hubURL = new PropertyReader().readProperty("hubURL");
        baseURL = new PropertyReader().readProperty("baseURL");
        System.out.println("Initialization of BaseTest...");
        System.out.println("Selected Configuration: ");
        System.out.println("   Browser - " + browser);
        System.out.println("   Destination - " + destination);

        //Backup values if configuration was forgotten
        //input parameters must be marked as @Optional then:
        //(@Optional String browser, @Optional String destination)
        //if (destination == null){ destination = "local"; }
        //if (browser == null){ browser = "chrome"; }

        if (destination.equalsIgnoreCase("local")) {
            if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
        else if (destination.equalsIgnoreCase("remote")) {
            if (browser.equalsIgnoreCase("firefox")) {
                driver = new RemoteWebDriver(new URL(hubURL), capabilityFirefox());
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browser.equalsIgnoreCase("chrome")) {
                driver = new RemoteWebDriver(new URL(hubURL), capabilityChrome());
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
        else {
            throw new IllegalArgumentException("Configuration is not correct!");
        }

    }

    private DesiredCapabilities capabilityFirefox() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("firefox");
        return capability;
    }
    private DesiredCapabilities capabilityChrome() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("chrome");
        return capability;
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }

}
