package com.treysta_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.treysta_genericUtilities.miscellaneous.WebDriverUtilities;

public class UpdatePageDataPage {
	@FindBy(xpath="//select[@name='menu1']") private WebElement selectMenu;
	@FindBy(xpath="//div[@class=' nicEdit-main' or @class=' nicEdit-main  ']") private WebElement aboutTxtField ;
	@FindBy(xpath="//div[@class='//div[@class=' nicEdit-main                       ']") private WebElement aboutTxtFieldData ;

	@FindBy(id="submit") private WebElement updateBtn ;
	
	
	public UpdatePageDataPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectMenu(WebDriverUtilities d ,String text) {
		d.handleDropdown(text, selectMenu);
		
	}
	public void aboutTxtFieldClearText() {
		aboutTxtField.clear();;
	}
	public void aboutTxtFieldSendText(String value) {
		
		aboutTxtFieldData.sendKeys(value);
	}
	public void clickUpdate() {
		updateBtn.click();
	}
	
}
