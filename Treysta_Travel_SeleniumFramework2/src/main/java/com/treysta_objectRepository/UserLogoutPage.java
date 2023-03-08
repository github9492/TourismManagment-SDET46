package com.treysta_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.treysta_genericUtilities.miscellaneous.JavaScriptUtilites;
import com.treysta_genericUtilities.miscellaneous.JavaUtilities;
import com.treysta_genericUtilities.miscellaneous.WaitUtilities;

public class UserLogoutPage {

	private WebDriver driver;
	@FindBy(linkText="/ Logout")private WebElement logOutBtn;
	
	
	
	
	public UserLogoutPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logOutAction(JavaScriptUtilites j) {
		j.scrollUp();
		logOutBtn.click();
		
	}
	
	
	
	}
	

