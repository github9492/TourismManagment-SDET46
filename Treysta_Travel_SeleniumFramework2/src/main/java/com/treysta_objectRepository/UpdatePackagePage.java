package com.treysta_objectRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.treysta_genericUtilities.miscellaneous.JavaScriptUtilites;

	public class UpdatePackagePage {
		
		@FindBy(id = "packagename") private WebElement packageNameTxtField;
		@FindBy(id = "packagelocation") private WebElement packageLocationTxtField;
		@FindBy(id = "packageprice") private WebElement packagePriceTxtField;
		@FindBy(name = "submit") private WebElement submitBtn;
		
		public UpdatePackagePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void packageNameTxtField(String data)
		{
			packageNameTxtField.clear();
			packageNameTxtField.sendKeys(data);
		}
		
		public void packageLocationTxtField(String data)
		{
			packageLocationTxtField.clear();
			packageLocationTxtField.sendKeys(data);
		}
		
		public void packagePriceTxtField(String price)
		{
			packagePriceTxtField.clear();
			packagePriceTxtField.sendKeys(price);
		}
		
		public void submitBtnAction(JavaScriptUtilites j)
		{
			j.scrollDown();
			submitBtn.click();
		}

	}


