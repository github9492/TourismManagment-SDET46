package practiceSelenium;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TourismCreatePackage {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()= 'Admin Login']")).click();
		driver.findElement(By.xpath("//input[@class='name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@class='login']")).click();
		WebElement target = driver.findElement(By.xpath("//span[text()=' Tour Packages']"));
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
		driver.findElement(By.xpath("//a[text()='Create']")).click();
		driver.findElement(By.id("packagename")).sendKeys("Bihar Tourism");
		driver.findElement(By.id("packagetype")).sendKeys("Family");
		driver.findElement(By.id("packagelocation")).sendKeys("Bihar");
		driver.findElement(By.id("packageprice")).sendKeys("500000");
		driver.findElement(By.id("packagefeatures")).sendKeys("Free Breakfast,luch and dinner is included");
		driver.findElement(By.id("packagedetails")).sendKeys("This package include all the famous as well as monument present in bihar including zoo and famous park");

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
			driver.close();

		}
		driver.findElement(By.xpath("//span[text()='Administrator']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		driver.findElement(By.xpath("//a[@href='../index.php']")).click();
		driver.findElement(By.xpath("//a[text()='/ Sign In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@123");
		driver.findElement(By.name("signin")).click();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.findElement(By.xpath("//a[@href='package-list.php']")).click();
		String Title = " Package List";
		String acpTitle =driver.getTitle();
		if(Title.contentEquals(acpTitle)) {
			System.out.println("package list page dispalyed");
		}
		else {
			System.out.println("something went wrong");
		}


	}


}
