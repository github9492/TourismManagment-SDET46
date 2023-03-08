package practiceSelenium;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class assing {
	static {
		 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	 }
	 public static void main(String arg []) throws InterruptedException {
		System.out.println("Enter country name ");
		 Scanner sc = new Scanner(System.in);
		 String ss= sc.nextLine();
	 WebDriver driver = new ChromeDriver();
 
	 driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
	 Thread.sleep(3000);
	 driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	 driver.manage().window().maximize();
	String text= driver.findElement(By.xpath("//span[contains(text(),'"+ss+"')]//descendant::span")).getText();
	 System.out.println(text);
	 driver.close();
}
}