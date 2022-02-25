package com.cg.util;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport extends TestListenerAdapter{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	@Override
	public void onStart(ITestContext testContext) {
		sparkReporter = new ExtentSparkReporter("C:\\Users\\mhasanla\\eclipse-workspace\\RestAssuredAPITesting\\test-output\\myExtentReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Rest ApiTesting Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Daneyal");
	}
	
	
	@Override
	public void onTestSuccess(ITestResult status) {
		test = extent.createTest(status.getName());
		test.log(Status.PASS, "Test Case Passesed "+status.getName());
		
	}
	@Override
	public void onTestFailure(ITestResult status) {
		test = extent.createTest(status.getName());
		test.log(Status.FAIL, "Test Case Failed "+status.getName());
	}
	
	@Override
	public void onTestSkipped(ITestResult status) {
		test = extent.createTest(status.getName());
		test.log(Status.SKIP, "Test Case Skipped "+status.getName());
	}
	
	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
