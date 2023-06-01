package testingComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import helpers.UtilityMethods;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterUtility;

public class Listeners implements ITestListener {

    ExtentReports extentReport = ExtentReporterUtility.getExtentReportsObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started");
        test = extentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        WebDriver driver;
        String filePath="";
        try{
           driver = (WebDriver) result.getTestClass().getRealClass().getField("mDriver").get(result.getInstance());
           filePath = UtilityMethods.saveScreenshotAndReturnPath(result.getMethod().getMethodName(),driver);
        }

        catch (Exception e){
            e.printStackTrace();
        }


        test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());


    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
    extentReport.flush();

    }

}
