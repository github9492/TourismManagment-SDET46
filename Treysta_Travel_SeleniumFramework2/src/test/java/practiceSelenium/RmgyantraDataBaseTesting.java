package practiceSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgyantraDataBaseTesting {
	public static void main(String arg[]) {
		String project="Tourism managment"+ new Random().nextInt(100);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.get("http://rmgtestingserver:8084/");

		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block text-uppercase']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(project);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Jhon");
		WebElement dropDown = driver.findElement(By.xpath("//label[@class='col-sm-2 col-form-label']/following-sibling ::select[@name='status']"));
		Select s = new Select(dropDown);
		s.selectByValue("On Going");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		String actualMsg ="Project bfjgg Successfuly Added";
		WebElement popup = driver.findElement(By.xpath("//div[contains(text(),'Successfuly Added')]"));
		wait.until(ExpectedConditions.invisibilityOf(popup));
		String expMsg = driver.findElement(By.xpath("//div[contains(text(),'Successfuly Added')]")).getText();
		if(actualMsg.contains(expMsg)) {

			System.out.println("project created successfully");

		}
		else {
			System.out.println("unsucessfull");
		}

		List<WebElement> allProjectList = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		for(WebElement projectName : allProjectList) {
			String text=projectName.getText();
			if(text.equals(project)) {
				System.out.println("project verified");
			}
		}
		
		/// checking in data base 

		Connection connection=null;
		
		
		try {
			Driver dbdriver= new Driver();
			DriverManager.registerDriver(dbdriver);

			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

			Statement statment = connection.createStatement();
			ResultSet result = statment.executeQuery("select * from project");
			while(result.next()){
				String projectName = result.getString("project_name");
				if(projectName.equals(project)) {

					System.out.println("data present in data base");
					break;
				}
			}
		}
		catch(SQLException e ){

		}

		finally {


			try {
				connection.close();
			} catch (SQLException e) {


			}

			System.out.println("Data Base closed ");
			driver.close();
		}
	}

}