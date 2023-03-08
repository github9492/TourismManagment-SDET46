package practiceSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class testNgPracticeClassTest {
	
	public WebDriver driver;
	@BeforeSuite
	public void bsSetup() {	
	System.out.println("BeforeSuite - 1");		
	}
@BeforeClass
public void bcSetup() {
	System.out.println("BeforeClass -1");
	}
@BeforeTest
public void btSetup() {
	System.out.println("BeforeTest -pehle 1");
	
}
@BeforeMethod
public void bmSetup() {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	System.out.println("BeforeMethod -1");
	}
@Test
public void test() {
	//	driver.get("https://www.icc-cricket.com/rankings/womens/player-rankings/odi");
	//	List<WebElement> alloptions = driver.findElements(By.xpath("//a[text()='Meg Lanning']/parent::td/parent::tr/following-sibling::tr/child::td//a"));
    // for (WebElement name : alloptions) {
	//	System.out.println(name.getText());
	System.out.println("practice class");
	}
	

@AfterClass
public void acTearDown() {
	System.out.println("AfterClass-1");
}
@AfterMethod 
public void amTearDown() {
	System.out.println("AfterMethod -1");
}
@AfterTest
public void atTearDown() {
	System.out.println("AfterTest -1");
}
@AfterSuite
public void asTearDown() {
	System.out.println("AfterSuit -1");
}

}
