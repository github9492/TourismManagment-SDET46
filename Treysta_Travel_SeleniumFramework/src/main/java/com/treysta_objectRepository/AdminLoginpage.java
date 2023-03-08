package com.treysta_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class is use for the login action of  admin .
 * @author Dell
 *
 */
public class AdminLoginpage {
	@FindBy(xpath="//input[@class='name']")private WebElement adminLoginButton  ;
	
	@FindBy(xpath="//input[@class='password']")private WebElement adminPasswordButton;
	
	@FindBy(xpath="//input[@class='login']")private WebElement  loginButton;
	
	@FindBy(xpath="//a[@href='../index.php']")private WebElement backToHomePage;
	
	
	/**
	 * Initialization
	 * @param driver
	 */
	public AdminLoginpage(WebDriver driver) {
		PageFactory.initElements(driver,this);;
	}
/**
 * This method is used for login action
 * @param adminName
 * @param adminPassword
 */
	public void loginAction(String adminName, String adminPassword) {
		adminLoginButton.sendKeys(adminName);
		adminPasswordButton.sendKeys(adminPassword);
		loginButton.click();
	}
	/**
	 * This method is use to click on back to home page 
	 */
	public void clickOnBackToHome() {
		backToHomePage.click();
	}
	
}
