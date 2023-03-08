  
package com.treysta_genericUtilities.miscellaneous;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * In this calss all the method related to webdriver are present .
 */

public class WebDriverUtilities {

	private WebDriver driver;

/**
 * This is the constructor
 */
	public  WebDriverUtilities(){
	}
	
	public  WebDriverUtilities(WebDriver driver){
		this.driver =driver;
	}
	/**
	 * This is method for the synchronization of multiple element
	 * @param driver
	 * @param timeunit
	 */
	public void impWait(WebDriver driver, long timeunit) {
		
		driver.manage().timeouts().implicitlyWait(timeunit,TimeUnit.SECONDS);
	}

	/**
	 * This method will give full screen of window
	 * @param driver
	 */
	public void fullscreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}

	/**
	 * This method will fetch the title of the web page
	 * @param driver
	 */
	public void getTitleOfWebPage(WebDriver driver)
	{
		driver.getTitle();
	}
	/**
	 * This method will maximize the window when its called
	 * @param driver
	 */

	/**
	 * This method will remove the value present in web element
	 * @param element
	 */
	public void clearElement(WebElement element)
	{
		element.clear();
	}

	/**
	 * This method will return tag name of web element
	 * @param element
	 * @return 
	 */
	public String getTagNameOfElement(WebElement element)
	{
		return element.getTagName();
	}

	

	/**
	 * This method will handle dropdown based on index value
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will handle dropdown based on value
	 * @param element
	 * @param value
	 * @return
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 *  This method will handle dropdown based on visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method will give all the options present in dropdown
	 * @param element
	 * @return
	 */
	public List<WebElement> getAllOptionsOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		return sel.getOptions();
	}

	/**
	 * This method will return true if dropdown is multiselect
	 * @param element
	 * @return
	 */
	public boolean checkForMultiSelectDDropdown(WebElement element)
	{
		Select sel = new Select(element);
		return sel.isMultiple();
	}

	/**
	 * This method will deselect the option by index
	 * @param element
	 * @param index
	 */
	public void deSelectOptionInDropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}

	/**
	 * This method will deselect the option by value
	 * @param element
	 * @param value
	 */
	public void deSelectOptionInDropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}

	/**
	 * This method will deselect the option by visible text
	 * @param text
	 * @param element
	 */
	public void deSelectOptionInDropdown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}

	/**
	 * This method will deselect all option in dropdown
	 * @param element
	 */
	public void deSelectOptionInDropdown(WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectAll();
	}

	/**
	 * This method will give all the selected options of the dropdown
	 * @param element
	 */
	public void getAllSelectedOptionOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		sel.getAllSelectedOptions();
	}

	/**
	 * This method will give the only first selected options of the drop down
	 * @param element
	 */
	public void getFirstSelectedOptionOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		sel.getFirstSelectedOption();
	}

	/**
	 * This method will press and release the enter key
	 * @throws AWTException
	 */
	Robot r;
	public void pressEnterKey()
	{
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch to frame based on name or id
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}

	/**
	 * This method will switch to frame based on web element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}

	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will switch to parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}

	/**
	 * This method will switch to window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> allWindows=driver.getWindowHandles();
		for(String indWindow:allWindows)
		{
			String currentWinTitle = driver.switchTo().window(indWindow).getTitle();
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	/**
	 * This method will take screenshot of web page and save it in screenshot folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(String screenShotName, JavaUtilities jUtil)
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./src/test/resources/ScreenShot/"+screenShotName+"_"+jUtil.getCurrentDate()+".png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return trg.getAbsolutePath(); //used for extent reports
	}
	
	public String takeScreenShot()
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}


	
	/**
	 * This method will take screenshot of web element and save it in screenshot folder
	 * @param element
	 * @param elementName
	 * @param jUtil
	 * @return
	 */
	public String takeScreenShot(WebElement element, String elementName, JavaUtilities jUtil)
	{
		File src = element.getScreenshotAs(OutputType.FILE);
		File trg = new File("./ScreenShot/elements"+elementName+"_"+jUtil.getCurrentDate()+".png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return trg.getAbsolutePath();
	}

}
