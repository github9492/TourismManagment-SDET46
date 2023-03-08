package com.treysta_genericUtilities.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.treysta_genericUtilities.annotation.Report;
import com.treysta_genericUtilities.mainconfiguration.MainClass;
import com.treysta_genericUtilities.miscellaneous.ReportUtility;
import com.treysta_genericUtilities.miscellaneous.UtilitiesInstanceTransfer;
/**
 * This contains several method present in ITestListener and IsuiteListener 
 * @author Dell
 *
 */
public class ExtendsReportListener implements ITestListener ,ISuiteListener {
	private ReportUtility report;
	public static ReportUtility sreport;
	/**
	 * This method Will execute after the @BeforeSuite
	 * In this method we are initializing extent report path, report title, report name, browser.
	 * 
	 */
	@Override
	public void onStart(ISuite suite) {

		System.out.println("onStart ---> Suite");
		report = new ReportUtility();

		sreport = report;

	}
/**
 * This method will save the report 
 */
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onTestStart --> Test");
		report.saveReport();
	}
/**
 * This method will execute before the execution of the test script
 * In this method we are taking instance of the driver  and initializing author , category.
 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart -> Test");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.category());
		report.addAuthor(UtilitiesInstanceTransfer.getExtentTest(), reportAnnotation.author());
		report.addCategory(UtilitiesInstanceTransfer.getExtentTest(), reportAnnotation.category());

	}
/**
 * This method is used to take screenshot after test success.
 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess -> Test");
		report.pass(UtilitiesInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+ "is pass");
	}
/**
 * This method is used to take screenshot after test Failure.
 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure -> Test");

		report.fail(UtilitiesInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+ "is fail",result.getThrowable());

		String screenShotPath = null;

		screenShotPath = MainClass.class.cast(result.getMethod().getInstance()).webDriverUtilities.takeScreenShot();

		report.attachScreenShot(UtilitiesInstanceTransfer.getExtentTest(),screenShotPath, result.getMethod().getMethodName(), "base64");

	}
/**
 * This method is used to take screenshot after test skipped.
 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped -> Test");
		report.skip(UtilitiesInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+" is skipped",result.getThrowable());

	}
/**
 * This method is used to take screenshot after test success with successPercentage.
 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage -> Test");
	}
/**
 * This method is used to take screenshot after onTestFailedWithTimeout.
 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout -> Test");
	}

/**
 * This method will execute after the execution of all the method and save the  report.
 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish -> Test");
		//	report.saveReport();
	}
}


