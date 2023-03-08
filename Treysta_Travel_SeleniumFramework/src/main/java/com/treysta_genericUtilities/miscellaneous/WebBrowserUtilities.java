package com.treysta_genericUtilities.miscellaneous;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * In this class we store the launching browser method.
 * @author Dell
 *
 */
public class WebBrowserUtilities {
	private WebDriver driver;
	/**
	 * This method is use to open application in specific browser. 
	 * @param Browser
	 * @return
	 */
	public  WebDriver setBrowser(String Browser) {

		switch(Browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("enter proper key");
			break;
		}
		return driver;
	}
	/**
	 * This method is used to send the specific url.
	 * @param url
	 */
	public void getUrl( String url) {
		driver.get(url);
	}

	/**
	 * This method is use to maximize the browser size .
	 */
	public void  maximizeBrowser() {
	driver.manage().window().maximize();
	}
	

	/**
	 * This method is used to resize the browser application according to the choice.
	 * @param width
	 * @param height
	 */
	public void resizeBrowser(int width , int height) {
		driver.manage().window().setSize(new Dimension(width ,height));
	}
	/**
	 * This method is used the close all the windows.
	 */
	public void closedBrowser() {
		driver.quit();
	}
	/**
	 * This method is use to close all the tab except parent tab.
	 */
	public void closedTab() {
		driver.close();
	}



	

}

