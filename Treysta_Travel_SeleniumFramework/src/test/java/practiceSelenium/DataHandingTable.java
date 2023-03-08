package practiceSelenium;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataHandingTable {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		String data="amazon91";
		
		
		// get the control on table first after getting one of one  traverse to child tr - means table row and then go for 
		// the table data present in first row eg: go for "organization". in this we had use td[3] it is not "group index" it is index value in table. it is use only when table is static.



		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]")); // tr = table row , td= table data , tbody = tableBody 
		for(WebElement element : list) {
			String actorg= element.getText();
			if(data.contains(actorg)) {
				System.out.println("organization present in the list ----> Tc pass");
				break; //  it will terminate the loop , why we use it because if the data will be match in first or second   iteration then  it will stop.
			}


		}
	}


}

