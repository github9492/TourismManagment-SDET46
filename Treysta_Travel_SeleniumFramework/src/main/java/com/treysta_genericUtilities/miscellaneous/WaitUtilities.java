package com.treysta_genericUtilities.miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Dell
 *
 */
public class WaitUtilities {
	private WebDriverWait wait;
	/**
	 * Here we are initializing the wait for reuseablity .
	 * @param driver
	 */

	public WaitUtilities(WebDriver driver) {
		wait = new WebDriverWait(driver, 20);	
	}
	public void impWait(WebDriver driver, long timeunit) {

		driver.manage().timeouts().implicitlyWait(timeunit,TimeUnit.SECONDS);
	}

	public void waitElementToBeClickable( WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}


	public void waitForElementToBeSelected(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}


	public void waitForTextToBePresentInElement(WebElement element, String text)
	{
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void waitForElementToinvisible( WebElement element)
	{
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	/**
	 * 
	 * @param element
	 */
	public void waitForElementTovisibilityOf( WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	/**
	 * This method is used for custom wait 
	 * @param pollingTime
	 * @param duration
	 * @param element
	 */
	public void waitTillClick(long pollingTime , int duration , WebElement element) {
		int count =0;
		while(count<duration) {
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				count = count+((int)pollingTime/1000);
			}
		}
	}
 





}