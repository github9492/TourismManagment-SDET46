package com.treysta_objectRepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.treysta_genericUtilities.miscellaneous.JavaUtilities;
import com.treysta_genericUtilities.miscellaneous.WaitUtilities;


public class PackageDetailsPage {
	
	private WebDriver driver;
	private String selectDatePartialLocator = "%s";
	private String datePartialLinkText = "%s";
	@FindBy(xpath = "//input[@class='special' and @name='comment']") private WebElement commentTxtField;
	@FindBy(xpath = "//button[text()='Book']") private WebElement bookBtn;
	
	/**
	 * This method is used to convert partial locator String into WebElement
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElementOfid(String partialLocator, String replaceData)
	{
		String Locator = String.format(partialLocator, replaceData);
		return driver.findElement(By.id(Locator));
	} 

	private WebElement convertToWebElementOfLinkText(String partialLinkText, String replaceData)
	{
		String linkText = String.format(partialLinkText, replaceData);
		return driver.findElement(By.linkText(linkText));
	}
	
	/**
	 * initialization
	 * @param driver
	 */
	public PackageDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to perform click action on a particular module of calendar
	 * @param linkName
	 */
	public void clickOnDateField(LinkNames linkName)
	{
		convertToWebElementOfid(selectDatePartialLocator, linkName.getLink()).click();
	}
	
	/**
	 * This method is used to perform click action on a particular date
	 * @param date
	 */
	public void clickOnDate(String date)
	{
		convertToWebElementOfLinkText(datePartialLinkText, date).click();
	}
	
	public void commentTxtField(String value )
	{
		commentTxtField.sendKeys(value);
	}
	
	public void bookBtnAction()
	{
		bookBtn.click();
	}
}
