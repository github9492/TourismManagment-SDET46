package com.treysta_objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * All the elements of the admin home page are present.
 * @author Dell
 *
 */
public class AdminHomePage {
private WebDriver driver;
	@FindBy(xpath="//span[text()='Administrator']")private WebElement administratorLink;
	private String tabPartialXpath ="//span[.='%s']"; 
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
	
	/**
	 * intialization
	 * @param driver
	 */
	public AdminHomePage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Business  Logic
	 * @param tabName
	 */
	public void clickTab(TabNames tabName) {
		convertToWebElement(tabPartialXpath,tabName.getTab()).click();
	}
	/**
	 * This methos is use to click on the administrator link.
	 */
	public void administratorClick() {
		administratorLink.click();
	}

}
