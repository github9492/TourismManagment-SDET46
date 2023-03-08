package practiceSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.treysta_genericUtilities.mainconfiguration.MainClass;


public class Practice23 extends MainClass {
	
	@Test
	public void assingment() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/womens/player-rankings/odi");
		List<WebElement> alloptions = driver.findElements(By.xpath("//a[text()='Meg Lanning']/parent::td/parent::tr/following-sibling::tr/child::td//a"));
     for (WebElement name : alloptions) {
		System.out.println(name.getText());
	}
	     
	}

}
