package practiceSelenium;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookPackage {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
			driver.findElement(By.linkText("/ Sign In")).click();
			driver.findElement(By.cssSelector("[placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");
			driver.findElement(By.id("password")).sendKeys("Test@123");
			driver.findElement(By.name("signin")).click();
			driver.findElement(By.linkText("Tour Packages")).click();
			WebElement wb = driver.findElement(By.xpath("//h4[text()='']"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true)",wb);
			driver.findElement(By.xpath("//a[@href='package-details.php?pkgid=23']")).click();
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			jse1.executeScript("window.scrollBy(0,500)");
			driver.findElement(By.id("datepicker")).click();
			driver.findElement(By.linkText("5")).click();
			driver.findElement(By.id("datepicker1")).click();
			driver.findElement(By.linkText("15")).click();
			driver.findElement(By.name("comment")).sendKeys("xyz");
			driver.findElement(By.xpath("//button[text()='Book']")).click();


	}
}
