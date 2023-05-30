package testingComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LandingPage;

import java.io.FileInputStream;
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
        browserName = properties.getProperty("browser");

        }
        catch (Exception e){

        }

        switch (browserName){

            case "firefox":{
                WebDriverManager.firefoxdriver().setup();
                mDriver=new FirefoxDriver();
            }

            case "edge":{
                WebDriverManager.edgedriver().setup();
                mDriver= new EdgeDriver();
            }

            default: {
                WebDriverManager.chromedriver().setup();
                mDriver = new ChromeDriver();
            }
        }
        mDriver.manage().window().maximize();
        return mDriver;
    }

    @BeforeMethod
    public LandingPage launchApplication(){
        mDriver = initializeDriver();
        landingPage= new LandingPage(mDriver);
        landingPage.goToLandingPage();
        return landingPage;
    }


    @AfterMethod
    public void tearDown(){
        mDriver.close();
    }


}
