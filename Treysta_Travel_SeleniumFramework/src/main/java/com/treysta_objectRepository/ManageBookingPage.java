package com.treysta_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * All the element of  manage booking page are present in the class
 * @author Dell
 *
 */
public class ManageBookingPage {
	
	private WebDriver driver;

	@FindBy(xpath="//table[@id='table']/tbody/tr[last()]/td[last()]//a[text()='Confirm']")private WebElement lastElementofpageconfirm;
	
	@FindBy(xpath="//table[@id='table']/tbody/tr[last()]/td[last()]//a[text()='Cancel']")private WebElement lastElementofpagecancel;
	
	public ManageBookingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void lastElementOfPageConfirm() {
		lastElementofpageconfirm.click();
	}
	public void lastElementOfPageCancel() {
		lastElementofpagecancel.click();
	}

}
