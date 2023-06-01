package resources;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {


 public static ExtentReports getExtentReportsObject(){
     ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//index.html");
     reporter.config().setReportName("Web Automation Results");
     reporter.config().setDocumentTitle("Test Results");
     ExtentReports reports = new ExtentReports();
     reports.attachReporter(reporter);
     reports.setSystemInfo("Tester","Asif");
     return reports;
 }

}
