package practiceSelenium;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssingOlympic {
//	static {
//		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
//	}
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://olympics.com/en/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
		
		String m="gold"; // it should be in lower case 
		String playerName ="Mikaela SHIFFRIN";  //it should be in Upper case
		
		
		String nme = driver.findElement(By.xpath("//span[text()='"+playerName+"']")).getText();
		//older xpath without using xpath axes ---->(By.xpath("//span[text()='Mikaela SHIFFRIN']/../../../../div[1]/span")).getText();
		
		String Text = driver.findElement(By.xpath("//span[text()='"+playerName+"']/ancestor::li//span[@class='result-medal result-medal--"+m+"']")).getText();
		System.out.println(nme +"------> "+ Text  + "  Gold  " );
		
		driver.close();
	}
}