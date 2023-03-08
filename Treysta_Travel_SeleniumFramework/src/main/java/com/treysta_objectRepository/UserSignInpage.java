package com.treysta_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSignInpage {
@FindBy(css="[placeholder='Enter your Email']")private WebElement emailTextField  ;

	
	@FindBy(id="password")private WebElement userPasswordButton;
	
	
	@FindBy(name="signin")private WebElement  signinButton;
	
	
	public UserSignInpage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);;
	}

	public void loginAction(String adminEmail, String adminPassword) {
		
		emailTextField.sendKeys(adminEmail);
	
		userPasswordButton.sendKeys(adminPassword);
		signinButton.click();
	}

}
