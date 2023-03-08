package practiceSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.treysta_genericUtilities.miscellaneous.WebBrowserUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssingFetchingPrice {
	
	@Test
	public void price() {
		WebBrowserUtilities wb = new WebBrowserUtilities();
		WebDriver driver = wb.setBrowser("chrome");
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click(); 
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("laptop");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		 List<WebElement> priceoflappy = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1'][not(number(translate(text(),'₹,',' '))>30000 and number(translate(text(),'₹,',' '))<50000) ]"));
		for(WebElement lpp : priceoflappy) {
			String text = lpp.getText();
			int no = Integer.parseInt(text);
			System.out.println(no);
		}

}
}
