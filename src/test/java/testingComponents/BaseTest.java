package testingComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver mDriver;
    public LandingPage landingPage;
    public WebDriver initializeDriver(){

        //used to get the properties file to read data
        String browserName="";

        try{
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
        properties.load(fileInputStream);
        browserName = System.getProperty("browser") !=null ? System.getProperty("browser"):  properties.getProperty("browser");

        System.out.println("Received browser: "+browserName);
        // System.getProperty("browser") is set when calling test with command prompt using maven

        }
        catch (Exception ignored){

        }

        switch (browserName){

            case "firefox":{
                WebDriverManager.firefoxdriver().setup();
                System.out.println("firefox is selected");
                mDriver=new FirefoxDriver();
                break;
            }

            case "edge":{
                WebDriverManager.edgedriver().setup();
                System.out.println("edge is selected");
                mDriver= new EdgeDriver();
                break;
            }

            default: {
                WebDriverManager.chromedriver().setup();
                System.out.println("default/chrome is selected");
                mDriver = new ChromeDriver();
                break;
            }
        }
        mDriver.manage().window().maximize();
        return mDriver;
    }

    @BeforeMethod
    public void launchApplication(){
        mDriver = initializeDriver();
        landingPage= new LandingPage(mDriver);
        landingPage.goToLandingPage();
       // return landingPage;
    }


    @AfterMethod
    public void tearDown(){
        mDriver.close();
    }


}
