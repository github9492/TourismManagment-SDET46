package practiceSelenium;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateUserAccount {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		String expTestScriptName ="TourismCreatePackageTest";
		DataFormatter df = new DataFormatter();
		FileInputStream fis= new FileInputStream("./src/test/resources/ExcelData/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		Map<String, String> map = new HashedMap<>();
		for(int i =1; i<=rowCount;i++) {
			String testScriptname = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptname.equalsIgnoreCase(expTestScriptName)) {
				for(int j=1; j<sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j)); 
					String value =df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);

				}
				break;
			}

		}
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		FileInputStream fis2 = new FileInputStream("./src/test/resources/commonData/commonData.properties");
		Properties p = new Properties();
		p.load(fis2);
		String url=p.getProperty("url");
		String admin=p.getProperty("admin");
		String pswrd=p.getProperty("password");
		int timeunit = Integer.parseInt(p.getProperty("timeunit"));
		driver.manage().timeouts().implicitlyWait(timeunit,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.name("fname")).sendKeys("Gaurav");
		driver.findElement(By.name("mobilenumber")).sendKeys("999999999");
		driver.findElement(By.cssSelector("[placeholder='Email id']")).sendKeys("gkk@gmail.com");
		driver.findElement(By.name("password")).sendKeys("gk@1123");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.linkText("/ Sign In")).click();
		driver.findElement(By.cssSelector("[placeholder='Enter your Email']")).sendKeys("gkk@gmail.com");
		driver.findElement(By.id("password")).sendKeys("gk@1123");
		driver.findElement(By.name("signin")).click();
		driver.findElement(By.linkText("My Profile")).click();
		driver.findElement(By.linkText("/ Logout")).click();
		driver.findElement(By.linkText("Admin Login")).click();
		driver.findElement(By.name("username")).sendKeys(admin);
		driver.findElement(By.name("password")).sendKeys(pswrd);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//span[text()='Manage Users']")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,10000)");
}
}