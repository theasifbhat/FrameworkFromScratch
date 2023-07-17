package testingComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LandingPage;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    public WebDriver mDriver;
    public LandingPage landingPage;

    public WebDriver initializeDriver() {

        //used to get the properties file to read data
        String browserName = "";

        WebDriver driver;

        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\GlobalData.properties");
            properties.load(fileInputStream);
            browserName = System.getProperty("browser") != null ? System.getProperty("browser") : properties.getProperty("browser");

            System.out.println("Received browser: " + browserName);
            // System.getProperty("browser") is set when calling test with command prompt using maven

        } catch (Exception ignored) {

        }

        switch (browserName) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                System.out.println("firefox is selected");
                driver = new FirefoxDriver();
            }
            case "firefoxHeadless" -> {
                WebDriverManager.firefoxdriver().setup();
                System.out.println("firefox headless is selected");
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
                driver.manage().window().setSize(new Dimension(1440, 900));
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                System.out.println("edge is selected");
                driver = new EdgeDriver();
            }
            case "edgeHeadless" -> {
                WebDriverManager.edgedriver().setup();
                System.out.println("edge headless is selected");
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                driver = new EdgeDriver(options);
                driver.manage().window().setSize(new Dimension(1440, 900));
            }
            case "chromeHeadless" -> {
                WebDriverManager.chromedriver().setup();
                System.out.println("chrome is selected");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                driver.manage().window().setSize(new Dimension(1440, 900));
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                System.out.println("default/chrome is selected");
                driver = new ChromeDriver();
            }
        }

        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public void launchApplication() {
        mDriver = initializeDriver();
        landingPage = new LandingPage(mDriver);
        landingPage.goToLandingPage();
        // return landingPage;
    }


    @AfterMethod
    public void tearDown() {
        try {
            if (mDriver != null) {
                mDriver.quit();
                System.out.println("Driver is closed ");
            } else {
                System.out.println("Driver is null ");
            }
        } catch (Exception e) {
            // Log or handle the exception appropriately
            System.out.println("Exception occurred while closing the browser: " + e.getMessage());
        }
    }


}
