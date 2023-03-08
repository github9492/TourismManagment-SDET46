package com.treysta_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class USerSingupPage {
	
	@FindBy(name = "fname")private WebElement fNameTextfield;
	
	@FindBy(name = "mobilenumber")private WebElement moblieNumTextfield;
	
	@FindBy(css = "[placeholder='Email id']")private WebElement emailTextfield;
	
	@FindBy(name = "password")private WebElement paswordTextfield;
	
	@FindBy(id="submit") private WebElement createAccountBtn;
	
	public USerSingupPage(WebDriver driver) {
		PageFactory.initElements(driver,this); 
	}
	
public void createAccountAction(String fname,String mNum ,String email,String pswd ) {
	fNameTextfield.sendKeys(fname);
	moblieNumTextfield.sendKeys(mNum);
	emailTextfield.sendKeys(email);
	paswordTextfield.sendKeys(pswd);
	createAccountBtn.click();
	
	
}
}
