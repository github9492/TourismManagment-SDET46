package com.treysta_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.treysta_genericUtilities.miscellaneous.JavaScriptUtilites;

public class PackageListPage {

	@FindBy(xpath="//h4[text()='Package Name: Andaman93']") private WebElement packageElement;
	@FindBy(xpath="//a[@href='package-details.php?pkgid=144']") private WebElement detailsButton;
	
	
	public PackageListPage(WebDriver driver ){
		PageFactory.initElements(driver, this);
	}
	
	public void declaredPackage(JavaScriptUtilites j) {
		j.scrollToElement(packageElement);
	}
	
	public void detailsButton() {
		detailsButton.click();
	}
	
}
