package com.uiFramework.inszoom.regrationTesting.helper.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;

public class ExtentListener implements ITestListener {
	private Logger oLog = LoggerHelper.getLogger(ExtentListener.class);

	public static ExtentReports extent;
	public static ExtentTest test;

	public void onFinish(ITestContext arg0) {
		// extent.flush();
		Reporter.log(arg0.getName() + " Test Finished..");
		oLog.info(arg0.getName() + " Test Finished..");
	}

	public void onStart(ITestContext arg0) {
		// extent = ExtentManager.getInstance();
		// test = extent.createTest(arg0.getName());
		// test = extent.createTest(arg0.getCurrentXmlTest().getName());
		Reporter.log(arg0.getCurrentXmlTest().getName() + " Class Started..");
		oLog.info(arg0.getCurrentXmlTest().getName() + " Class Started..");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {
		// test.log(Status.FAIL, arg0.getThrowable());
		Reporter.log(arg0.getMethod().getMethodName() + " Test Failed.." + arg0.getThrowable());
		oLog.error(arg0.getMethod().getMethodName() + " Test Failed.." + arg0.getThrowable());
	}

	public void onTestSkipped(ITestResult arg0) {
		// test.log(Status.SKIP, arg0.getThrowable());
		Reporter.log(arg0.getMethod().getMethodName() + " Test Skipped.." + arg0.getThrowable());
		oLog.warn(arg0.getMethod().getMethodName() + " Test Skipped.." + arg0.getThrowable());
	}

	public void onTestStart(ITestResult arg0) {
		// test.log(Status.INFO, arg0.getName()+" started..");
		Reporter.log(arg0.getMethod().getMethodName() + " Test Started..");
		oLog.info(arg0.getMethod().getMethodName() + " Test Started..");
	}

	public void onTestSuccess(ITestResult arg0) {
		// test.log(Status.INFO, arg0.getName()+" Passed..");
		Reporter.log(arg0.getMethod().getMethodName() + " Test Passed..");
		oLog.info(arg0.getMethod().getMethodName() + " Test Passed..");
	}

}
