package com.treysta_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.treysta_genericUtilities.miscellaneous.JavaScriptUtilites;

public class TourPackagePage {

 @FindBy(xpath="//a[text()='Create']")private WebElement createButton;
 @FindBy(xpath="//a[text()='Manage']")private WebElement manageButton;
 
 public TourPackagePage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 public void createAction() {
	 createButton.click(); 
 }
 
 public void manageAction() {
	 manageButton.click(); 
	 
 }
 
}
