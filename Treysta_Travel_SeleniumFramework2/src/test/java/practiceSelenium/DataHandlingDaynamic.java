package practiceSelenium;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataHandlingDaynamic {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		String colName="Organization Name";
		// First we have to iterate the header...
		// get the control on table first then take control on tr ie -> header we can specifie the index in header then iterate td.. 0,1,2,.. in list it start with 0  but coming to xpath
		// index it will start form 1 . so we have to increment with +1 .  in this program we have increment with +2 because in html code organigation is inside anchor tag .. to match the positon ofcolumn name.
		//  IMP ------>>here we have to match the index of header with the  td to java define  index....
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td/a"));//tr = table row , td= table data , tbody = tableBody
		int count = 0; 
		for(int i=0;i<list.size();i++) {
			String actHeader = list.get(i).getText();
			if(colName.equals(actHeader)) {
				count=i+2;
				break;
			}
		}
		
		// here we try to inspect the data from the next page , first we will inspect the  next page element and write the xpath...eg :(1 of 2).
		//

		String strPages = driver.findElement(By.xpath("//a[text()='Create Mail Merge templates ']/following::span[@name]")).getText();
		int pages = Integer.parseInt(strPages.split(" ")[1]); // here we are using text function to spilt from the space and taking index 1 because "of' is at 0 index and return type of this is string of array.  
		String orgName ="chethan123";                          // so we are converting the string in integer by using Interger.parseInt method.
		
		boolean flag =false; // To break the outer loop we are using this...
		
		for(int i=0; i< pages; i++) {
			List<WebElement> listOrg = driver.findElements(By.xpath("//table[@class='1vt small']/tbody/tr/td["+count+"]"));
			for(WebElement webElement : listOrg) {
				String actorg = webElement.getText();
				System.out.println(actorg);
				if(actorg.equals(orgName)) {
					driver.findElement(By.xpath("//a[text()='"+orgName+"']/../preceding-sibling::td/input")).click();
					flag =true;
					break;

				}
			}
			
			if(flag)
			{
				break;
			}
//			else {
//				driver.findElement(By.xpath("//a[@title='Next']")).click();
//
//				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("status")))); // we use this because when we are clicking on next it will take some time..
//			}


		}
	}
}


