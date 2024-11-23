package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.baseClass;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter; // Deal with the UI of the report
	public ExtentReports extent; // Populate common information in the report.
	public ExtentTest test; // Updating the status of the test cases in the report.

	public void onStart(ITestContext context) {
		//This method executes only at once at the start of the execution.
//		observer = new ExtentObserver(System.getProperty(("user.dir") + "/ExtentReport/extentReport.html");
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReport/extentReport"+ timestamp +".html");
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setReportName("My Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	
		extent.setSystemInfo("browser", "chrome");
	}
	
    public void onTestSuccess(ITestResult result) {
        // Creating a new test in ExtentReport whenever any test get passed.
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test Case passes is: " + result.getName());
    }
    
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Case failed is: " + result.getName());
        test.log(Status.FAIL, "The test case is failed due to: " + result.getThrowable());
        
        try {
            String screenshotPath = baseClass.captureScreenshots(result.getName());
            test.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            test.fail("ScreenShot capturing failed.");
        }

    }
    
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Case skipped is: " + result.getName());
    }
    
    public void onFinish(ITestContext context) {
        // Flush the ExtentReports
        extent.flush();
    }
}
