package practiceSelenium;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assing3Filp {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click(); 
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("laptop");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		List<WebElement> lappyName = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		int count = lappyName.size();
		List<WebElement> Allprice = driver.findElements(By.xpath("//div[@class='_4rR01T']/parent::div/following-sibling::div//div[@class='_30jeq3 _1_WHN1']"));
		int count2 = Allprice.size();
		for(int j= 0;j<count2 ;j++) {
			String text1 = Allprice.get(j).getText().substring(1).replaceAll(",", "");
			int no = Integer.parseInt(text1);
			for(int i=0;i<count;i++) { 
				if(no>=30000 && no<=40000){
					String text=lappyName.get(i).getText();
					System.out.println(text +"------->" + no);
					}

			}
		}
	
		  /*   for(WebElement p : Allprice) {
		String text = p.getText().substring(1).replaceAll(",", "");
		int no = Integer.parseInt(text);
		if(no>=20000 && no<=30000) {
			if(int i = o ;i<count :i++)
			System.out.println(no);
			System.out.println();*/

   // driver.close();

	}
}