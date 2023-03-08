package practiceSelenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AllLinks {
 static {
	 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
 }
 public static void main(String arg []) {
 ChromeDriver driver = new ChromeDriver();
 driver.get("https://www.amazon.in/");
 List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
 int count = alllinks.size();
 System.out.println(count);
 for (int i =0; i<count ; i++) {
	 String text = alllinks.get(i).getText();
 
      System.out.println(text);
 }
 driver.close();
 }
 
}