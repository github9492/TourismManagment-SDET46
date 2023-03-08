package com.treysta_genericUtilities.mainconfiguration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.treysta_genericUtilities.miscellaneous.JavaUtilities;
import com.treysta_genericUtilities.miscellaneous.WebBrowserUtilities;
import com.treysta_genericUtilities.miscellaneous.WebDriverUtilities;

public class BaseClassPractice {
	public WebDriverUtilities wUtil;
	public WebBrowserUtilities wbUtil;
	public JavaUtilities jUtil;
	public WebDriver driver;
	
	@BeforeSuite
	public void bsSetup() {	
	System.out.println("BeforeSuite - 1");		
	}
@BeforeClass
public void bcSetup() {
	System.out.println("BeforeClass -1");
	}
@BeforeTest
public void baseClassPractice() {
	System.out.println("BeforeTest -pehle 1");
	
	wbUtil=new WebBrowserUtilities();
	driver= wbUtil.setBrowser("chrome");
	wUtil = new WebDriverUtilities();
	jUtil = new JavaUtilities();
	
	
	
}
@BeforeMethod
public void bmSetup() {
	System.out.println("BeforeMethod -1");
	}
@Test
public void test() {
	System.out.println("Test -1");	
}
@AfterClass
public void acTearDown() {
	System.out.println("AfterClass-1");
}
@AfterMethod 
public void amTearDown() {
	System.out.println("AfterMethod -1");
}
@AfterTest
public void atTearDown() {
	System.out.println("AfterTest -1");
	driver.close();
}
@AfterSuite
public void asTearDown() {
	System.out.println("AfterSuit -1");
}

}
