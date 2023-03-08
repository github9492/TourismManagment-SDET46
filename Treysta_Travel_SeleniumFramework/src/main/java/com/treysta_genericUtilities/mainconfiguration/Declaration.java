package com.treysta_genericUtilities.mainconfiguration;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.treysta_genericUtilities.external_resources.MicrosoftExcelUtilities;
import com.treysta_genericUtilities.external_resources.PropertyUtilities;
import com.treysta_genericUtilities.miscellaneous.JavaScriptUtilites;
import com.treysta_genericUtilities.miscellaneous.JavaUtilities;
import com.treysta_genericUtilities.miscellaneous.PopupsUtilities;
import com.treysta_genericUtilities.miscellaneous.ReportUtility;
import com.treysta_genericUtilities.miscellaneous.WaitUtilities;
import com.treysta_genericUtilities.miscellaneous.WebBrowserUtilities;
import com.treysta_genericUtilities.miscellaneous.WebDriverUtilities;
import com.treysta_objectRepository.HomePage;
/**
 * This class contains the declaration of all the generic utilities and common data and common page.
 * @author Dell
 *
 */
public class Declaration {

	protected MicrosoftExcelUtilities  mfExcelUtl ;
	protected PropertyUtilities propUtlities ;
	public JavaUtilities javaUtilities;
	protected WebBrowserUtilities webBrowserUtilities;
	public WebDriverUtilities webDriverUtilities;
	protected String browser;
	protected String url;
	protected String admin;
	protected String pswrd;
	protected String userEmail;
	protected int timeunit;
	protected HomePage homePage;
	protected WebDriver driver;
	protected PopupsUtilities popups;
	protected WaitUtilities waitUtilities;
	protected JavaScriptUtilites javaScriptUtilities;
	protected ReportUtility report;
	public ExtentTest test;
	
}