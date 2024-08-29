package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentReportManager implements ITestListener {
	    private static ExtentReports extent;
	    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	    public void onStart(ITestContext context) {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(".\\reports"+ "extent.html");
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle("Test Report");
	        htmlReporter.config().setReportName("Test Report");

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	    }

	   
	    public void onTestStart(ITestResult result) {
	        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
	        test.set(extentTest);
	    }

	    
	    public void onTestSuccess(ITestResult result) {
	        test.get().log(Status.PASS, "Test Passed");
	    }

	    
	    public void onTestFailure(ITestResult result) {
	        test.get().log(Status.FAIL, "Test Failed");
	        
//	        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
//	        try {
//	            test.get().addScreenCaptureFromPath(screenshotPath);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
	    }

	    
	    public void onTestSkipped(ITestResult result) {
	        test.get().log(Status.SKIP, "Test Skipped");
	    }

	    
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	}



