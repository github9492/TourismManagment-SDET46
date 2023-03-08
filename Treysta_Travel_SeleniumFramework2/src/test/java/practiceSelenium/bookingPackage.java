package practiceSelenium;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bookingPackage {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
			public static void main(String[] args) {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
			driver.findElement(By.linkText("/ Sign In")).click();
			driver.findElement(By.cssSelector("[placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");
			driver.findElement(By.id("password")).sendKeys("Test@123");
			driver.findElement(By.name("signin")).click();
			driver.findElement(By.linkText("Tour Packages")).click();
			WebElement wb = driver.findElement(By.xpath("//h4[text()='Package Name: Mp Tourism']"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true)",wb);
			driver.findElement(By.xpath("//a[@href='package-details.php?pkgid=23']")).click();
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			jse1.executeScript("window.scrollBy(0,500)");
			driver.findElement(By.id("datepicker")).click();
			driver.findElement(By.linkText("2")).click();
			driver.findElement(By.id("datepicker1")).click();
			driver.findElement(By.linkText("11")).click();
			driver.findElement(By.name("comment")).sendKeys("ugidfdfiug");
			driver.findElement(By.xpath("//button[text()='Book']")).click();
			String expected = "Booked Successfully";
			String actual = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
			if(actual.contains(expected))
			{
				System.out.println("pass: package booked successfully");
			}
			else
			{
				System.out.println("errror");
			}
			driver.findElement(By.linkText("/ Logout")).click();
			driver.findElement(By.linkText("Admin Login")).click();
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("Test@123");
			driver.findElement(By.name("login")).click();
			driver.findElement(By.xpath("//span[text()='Manage Booking']")).click();
			jse1.executeScript("window.scrollBy(0,20000)");
			driver.findElement(By.xpath("//table[@id='table']/tbody/tr[last()]/td[last()]//a[text()='Confirm']")).click();
			Alert alt = driver.switchTo().alert();
			alt.accept();
			String expectedText2 = "Booking Confirm successfully";
			String actualText2= driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
			if(actualText2.contains(expectedText2))
			{
				System.out.println("pass: package booking confirm successfully");
			}
			else
			{
				System.out.println("error");
			}
			driver.findElement(By.xpath("//span[text()='Administrator']")).click();
			driver.findElement(By.xpath("//a[@href='logout.php']")).click();
			driver.findElement(By.linkText("Back to home")).click();
			driver.findElement(By.linkText("/ Sign In")).click();
			driver.findElement(By.cssSelector("[placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");
			driver.findElement(By.id("password")).sendKeys("Test@123");
			driver.findElement(By.name("signin")).click();
			driver.findElement(By.linkText("My Tour History")).click();
			String expectedText = "Confirmed";
			String actualText = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[7]")).getText();
			if(actualText.equals(expectedText))
			{
				System.out.println("sucessfully booked");
			}
			else
			{
				System.out.println("Booking failed");
			}
			
		}

	}


