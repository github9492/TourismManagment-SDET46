package com.treysta_objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Link;

public class UserHomePage {
	
	private WebDriver driver; 
	
	
	private String tabPartialXpath ="//a[.='%s']";
	
	/**
	 * This method is used to convert partial Xpath String into webelement 
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String partialXpath , String replaceData) {
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	//intiallization 
	/**
	 * 
	 * @param driver
	 */
	public UserHomePage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLink(LinkNames link) {
		convertToWebElement(tabPartialXpath,link.getLink()).click();
	}
	
	
}
