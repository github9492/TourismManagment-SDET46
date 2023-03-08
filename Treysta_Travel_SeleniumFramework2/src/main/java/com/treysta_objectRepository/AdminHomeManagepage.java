package com.treysta_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.treysta_genericUtilities.miscellaneous.JavaScriptUtilites;
/**
 * This class contains the element of admin home manage page .;.
 * @author Dell
 *
 */
public class AdminHomeManagepage {
	private WebDriver driver;
	
@FindBy(xpath="//table/tbody/tr[last()]/td//button") private WebElement scrolltoLast;
@FindBy(id="packageprice")private WebElement editPackagePrice;


/**
 * initialization
 * @param driver
 */
public AdminHomeManagepage  (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
/**
 * This method will fetch the last package .
 */
 public void fetchLastPackage(JavaScriptUtilites j) {
	 j.scrollDown();
	 scrolltoLast.click();
 }
/**
 * This method is use to clear the package price 
 */
 public void clearPackagePrice() {
	 editPackagePrice.clear();
 }
}
