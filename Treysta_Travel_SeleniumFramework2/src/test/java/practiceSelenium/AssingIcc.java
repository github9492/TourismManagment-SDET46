package practiceSelenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssingIcc {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String CountryName="Australia";
		String formate="ODI Team Rankings";
		driver.get("https://www.icc-cricket.com/homepage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[normalize-space(text())='Rankings']")).click();
		driver.findElement(By.xpath("//a[normalize-space(text())='Overview']  ")).click();
		

		String rnk = driver.findElement(By.xpath("//h4[text()='"+formate+"']/ancestor::div[@class='rankings-block__container rankings-block__container--teams']//div[text()='"+CountryName+"']/following-sibling::div | //h4[text()='"+formate+"']/ancestor::div[@class='rankings-block__container rankings-block__container--teams']//td[contains(.,'"+CountryName+"')]/following-sibling::td")).getText();

            System.out.println(CountryName +"----> "+ rnk);
            driver.close();
	}
}
  