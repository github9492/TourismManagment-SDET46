package practiceSelenium;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createUser {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.name("fname")).sendKeys("Gaurav");
		driver.findElement(By.name("mobilenumber")).sendKeys("999999999");
		driver.findElement(By.cssSelector("[placeholder='Email id']")).sendKeys("gkkk@gmail.com");
		driver.findElement(By.name("password")).sendKeys("gk@123");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.linkText("/ Sign In")).click();
		driver.findElement(By.cssSelector("[placeholder='Enter your Email']")).sendKeys("gkkk@gmail.com");
		driver.findElement(By.id("password")).sendKeys("gk@123");
		driver.findElement(By.name("signin")).click();
		driver.findElement(By.linkText("My Profile")).click();
		driver.findElement(By.linkText("/ Logout")).click();
		driver.findElement(By.linkText("Admin Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//span[text()='Manage Users']")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,10000)");
}
}