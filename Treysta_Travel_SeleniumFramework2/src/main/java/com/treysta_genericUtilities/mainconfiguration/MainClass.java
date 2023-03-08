package com.treysta_genericUtilities.mainconfiguration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.treysta_genericUtilities.constants.FrameWorkConstant;
import com.treysta_genericUtilities.enums.PropertyKey;
import com.treysta_genericUtilities.external_resources.MicrosoftExcelUtilities;
import com.treysta_genericUtilities.external_resources.PropertyUtilities;
import com.treysta_genericUtilities.listener.ExtendsReportListener;
import com.treysta_genericUtilities.miscellaneous.JavaScriptUtilites;
import com.treysta_genericUtilities.miscellaneous.JavaUtilities;
import com.treysta_genericUtilities.miscellaneous.PopupsUtilities;
import com.treysta_genericUtilities.miscellaneous.WaitUtilities;
import com.treysta_genericUtilities.miscellaneous.WebBrowserUtilities;
import com.treysta_genericUtilities.miscellaneous.WebDriverUtilities;
import com.treysta_objectRepository.HomePage;
/**
 * This class  contains TestNg configuration of common action.
 * @author Dell
 *
 */
public class MainClass extends Declaration {
/**
 * This method is used to initialize the generic utilities class and common data 
 * @param browser
 */
	@Parameters(value="browser")
	@BeforeClass(alwaysRun = true)
	public void beforeTestSetUp(@Optional String browser)
	{
		mfExcelUtl =  new MicrosoftExcelUtilities(FrameWorkConstant.TEST_PROPERTY_EXCEL_PATH);
		propUtlities = new PropertyUtilities(FrameWorkConstant.TEST_PROPERTY_FILE_PATH);
	
		webBrowserUtilities = new WebBrowserUtilities();
		javaUtilities=new JavaUtilities();
		
		popups = new PopupsUtilities();
		if(browser==null||browser.isEmpty()|| browser.equals(" ")) {
		browser=propUtlities.getPropertyData(PropertyKey.BROWSER);
		}
		this.browser=browser;
		url=propUtlities.getPropertyData(PropertyKey.URL);
		admin=propUtlities.getPropertyData(PropertyKey.ADMIN);
		pswrd=javaUtilities.decode(propUtlities.getPropertyData(PropertyKey.PASSWORD));
		userEmail=propUtlities.getPropertyData(PropertyKey.USER);
		timeunit = Integer.parseInt(propUtlities.getPropertyData(PropertyKey.TIMEUNIT));
		
		driver = webBrowserUtilities.setBrowser(browser);
		webDriverUtilities= new WebDriverUtilities(driver);
		javaScriptUtilities = new JavaScriptUtilites(driver);
		waitUtilities= new WaitUtilities(driver);
		homePage = new HomePage(driver);
		waitUtilities= new WaitUtilities(driver);
		javaScriptUtilities	= new JavaScriptUtilites(driver);
		webDriverUtilities.impWait(driver, timeunit);
		webBrowserUtilities.getUrl(url);
		webBrowserUtilities.maximizeBrowser();
		report= ExtendsReportListener.sreport;
	}
	
	/**
	 * This method is used to close the browser.
	 */
	@AfterClass(alwaysRun = true)
	public void afterClassTearDown() {
		driver.quit();
		mfExcelUtl.close();
	}
	
	

}
