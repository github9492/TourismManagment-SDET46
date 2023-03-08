package com.treysta_genericUtilities.webAction;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InteractionUtility {
	private WebDriver driver;
	private Actions act;
	/**
	 * This  method is used to initialize the action class.
	 * @param driver
	 */
	public InteractionUtility(WebDriver driver) {
		act = new Actions(driver);
	}
	/**
	 * This  method is use to perform action on a particular element.
	 * @param element
	 */
	
	public void mouseHover(WebDriver driver ,WebElement element) {
		act.moveToElement(element).perform();
	}
/**
 * This method is used to double click on particular element.
 * @param element
 */
	public void doubleClick(WebElement element) {
		act.doubleClick().perform();
	}
	
	/**
	 * This method is use to right click on a particular element.
	 * @param element
	 */
	public void rightClick(WebElement element) {
		act.contextClick(element).perform();
	}
	/**
	 * This method is use to right click .
	 */
	public void rightClick() {
		act.contextClick().perform();
	}
	/**
	 * This method is use to perform enter function.
	 */
	public void enter() {
		act.keyDown(Keys.ENTER).perform();
	}
	/**
	 * This method is use to click and hold the element.
	 * @param driver
	 */
	public void clickAndHoldAction()
	{
		act.clickAndHold().perform();
	}
	/**'
	 * This method is use to drag and drop to the particular element.
	 * @param srcElement
	 * @param tarElement
	 */
	
	public void dragAndDropAction( WebElement srcElement, WebElement tarElement)
	{
		act.dragAndDrop(srcElement, tarElement).perform();
	}


}
