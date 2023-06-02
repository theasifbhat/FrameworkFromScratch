package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class UtilityMethods {

    public static String saveScreenshotAndReturnPath(String fileName, WebDriver driver)  throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+"\\reports\\"+fileName+".png");
        FileUtils.copyFile(source,dest);
        return System.getProperty("user.dir")+"\\reports\\"+ fileName+".png";

    }

}
