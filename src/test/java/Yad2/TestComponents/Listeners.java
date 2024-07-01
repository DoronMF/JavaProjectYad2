package Yad2.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Yad2.Resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result ) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //unique thread id
		System.out.println("Creating test: " + result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result ) {
		test.log(Status.PASS, "Well done this TEST PASSED");
	}
	
	@Override
	public void onTestFailure(ITestResult result ) {
		test.log(Status.FAIL, "Unfortuntely this TEST FAILED");
		extentTest.get().fail(result.getThrowable());
		
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result ) {
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result ) {
		
	}

	
	@Override
	public void onStart(ITestContext context) {
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}


}
