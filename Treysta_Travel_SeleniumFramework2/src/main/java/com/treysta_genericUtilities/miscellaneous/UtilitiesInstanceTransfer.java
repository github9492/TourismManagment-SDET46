package com.treysta_genericUtilities.miscellaneous;

import com.aventstack.extentreports.ExtentTest;
/**
 * This class is used to create multiple copy of  instance of the test.
 * @author Dell
 *
 */

public class UtilitiesInstanceTransfer {

	private static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<>();
/**
 * This method is used to get the instance.
 * @return
 */
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
/**
 *  This method is used to set the instance.
 * @param setExtentTest
 */
	public static void setExtentTest(ExtentTest setExtentTest) {
	 extentTest.set(setExtentTest);
	}
}
