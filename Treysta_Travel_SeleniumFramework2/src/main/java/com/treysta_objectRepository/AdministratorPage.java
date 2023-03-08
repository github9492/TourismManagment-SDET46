package com.treysta_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * All element of the administrator page are present.
 * @author Dell
 *
 */
public class AdministratorPage {	
	@FindBy(xpath="//a[@href='change-password.php']")private WebElement profileBtn;
	@FindBy(xpath="//a[@href='logout.php']")private WebElement logOutBtn;
	
	/**
	 * intialization
	 * @param driver
	 */
	public AdministratorPage (WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method  is use to logout action.
	 */
	public void adminLogoutAction() {
		logOutBtn.click();
	}
	/**
	 * This method is used to click the profile button 
	 */
	public void adminProfileAction() {
		profileBtn.click();
	}

}
