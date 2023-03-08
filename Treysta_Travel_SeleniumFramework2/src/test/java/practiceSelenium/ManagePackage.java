package practiceSelenium;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManagePackage {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData/commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String url=p.getProperty("url");
		String admin=p.getProperty("admin");
		String pswrd=p.getProperty("password");
		 int timeunit = Integer.parseInt(p.getProperty("timeunit"));
		 
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeunit,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()= 'Admin Login']")).click();
		driver.findElement(By.xpath("//input[@class='name']")).sendKeys(admin);
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys(pswrd);
		driver.findElement(By.xpath("//input[@class='login']")).click();
		WebElement target = driver.findElement(By.xpath("//span[text()=' Tour Packages']"));
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
		driver.findElement(By.xpath("//a[text()='Create']")).click();
		driver.findElement(By.id("packagename")).sendKeys("Mp Tourism");
		driver.findElement(By.id("packagetype")).sendKeys("Family");
		driver.findElement(By.id("packagelocation")).sendKeys("up");
		driver.findElement(By.id("packageprice")).sendKeys("60000");
		driver.findElement(By.id("packagefeatures")).sendKeys("Free Breakfast,luch and dinner is included");
		driver.findElement(By.id("packagedetails")).sendKeys("welcome to up");

		driver.findElement(By.id("packageimage")).sendKeys("C:\\Users\\Dell\\Desktop\\IMG_20211219_083839.jpg");
		JavascriptExecutor  j =(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,5000)");
	
		driver.findElement(By.name("submit")).click();
		String text = "Package Created Successfully";
		String actual = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if(actual.contains(text)) {
			System.out.println("package created sucessfull");
			
		}
		else
		{
			System.out.println("fail in creating package");
		
		
		}
		driver.findElement(By.xpath("//span[text()=' Tour Packages']")).click();
		driver.findElement(By.xpath("//a[text()='Manage']")).click();
		
		String page = "Manage Packages";
		String mangpage = driver.findElement(By.xpath("//li[text()='Manage Packages']")).getText();
		if(mangpage.contains(page)) {
			System.out.println(" sucessfully landed on manage page ");
		}
		else {
			System.out.println("error in navigating to manage page ");
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,20000)");
		
		driver.findElement(By.xpath("(//button[text()='View Details'])[last()]")).click();
		driver.findElement(By.id("packageprice")).clear();
		driver.findElement(By.id("packageprice")).sendKeys("2222222");
		js.executeScript("window.scrollBy(0,20000)");
		driver.findElement(By.xpath("//button[@class='btn-primary btn']")).click();
		String text1 = "Package Updated Successfully";
		String actual1 = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if(actual1.contains(text1)) {
			System.out.println("Updated succesfully");
			
		}
		else
		{
			System.out.println("update unsuccesful");
		
		
		}
		
		
		driver.close();
	}

}
