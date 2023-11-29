package com.onlinebanking.kredvista.GenericUtils;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		//to get the test method name
		String methodName=result.getMethod().getMethodName();
		
		//It gives the name of the test method in the extent report
		test=report.createTest(methodName);
		Reporter.log(methodName+"-----TestScript execution starts from here-----");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		
		//Print the status of execution in the extent report
		test.log(Status.PASS, methodName+"===> PASSED");

		Reporter.log(methodName+"----- Testscript executed successfully----");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		//get the system date 
		String scriptPath=methodName+ new JavaUtils().systemDateInFormat();
		//screenshot will be added in the extent report, pathname will not override
		test.addScreenCaptureFromPath(scriptPath);
		
		try {
			WebDriverUtils.getScreenShot(BaseClass.sdriver, methodName);
		} catch (IOException e) {
			
		}
		
		//capture the exception in the extent report
		test.log(Status.FAIL, result.getThrowable());
		
		//print the failed report status in extent report
		test.log(Status.FAIL, methodName+"===> FAILED");
		
		Reporter.log(methodName+"----- testscript execution failed----");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		
		//print the status of skipped execution in the
		test.log(Status.SKIP, methodName+"===> Skipped");
		//capture the exception in extent report
		test.log(Status.SKIP, result.getThrowable());
		
		Reporter.log(methodName+"----- testscript execustion is skipped-----");

		
	}

	@Override
	public void onStart(ITestContext context) {
		
		//create path of report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/report.html");
		
		//customize the extent report
		htmlReport.config().setDocumentTitle("SDET-52");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("OnlineBanking");
		
		report=new ExtentReports();
		
		//attaching the reports in the extent report
		report.attachReporter(htmlReport);
		
		//setSystemInfo is used to give customized information about the testscript, browser, reporter etc
		//Give browser info where the testscript is running
		report.setSystemInfo("Base-browser", "chrome");
		//Give information of application url 
		report.setSystemInfo("url", "http://rmgtestingserver/domain/Online_Banking_System/");
		//give reporter name
		report.setSystemInfo("Reporter", "Sonali");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		//to clean the older reports//consolidate the report
		report.flush();
	}

}
