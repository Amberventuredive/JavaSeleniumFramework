package com.learnautomation.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.base.BaseClass;

public class ExtentTestNGITestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();
	private static ThreadLocal test = new ThreadLocal();

	public synchronized void onFinish(ITestContext context) {
		System.out.println("LOG:INFO- Reports getting ready");
		extent.flush();
		System.out.println("LOG:INFO- Reports ready");
	}

	public synchronized void onTestStart(ITestResult result) {
		ExtentTest parent = extent.createTest(result.getMethod().getMethodName());
		parentTest.set(parent);
	}

	public synchronized void onTestSuccess(ITestResult result) {
		parentTest.get().pass("Test Passed");
	}

	public synchronized void onTestFailure(ITestResult result) 
	{
		parentTest.get().fail("Test Failed " + result.getThrowable().getMessage());
	}

	public synchronized void onTestSkipped(ITestResult result) {
		parentTest.get().skip("Test Skipped");
	}

}
