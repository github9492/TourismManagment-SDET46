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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBaseTesting {
	public static void main(String args []) {
		String project_id ="Ty_ROJ_" + new Random().nextInt();
		String projectName = "Treysta" + new Random().nextInt();
		
		 Connection connection = null;
		try {
		Driver dbdriver= new Driver();
		DriverManager.registerDriver(dbdriver);

		connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

		Statement statment = connection.createStatement();
		int result = statment.executeUpdate("insert into project(project_id,created_by,created_on,project_name,status,team_size)values('"+project_id+"','gk','07/02/2023','"+projectName+"','on going',5 );");
	    if(result==1) {
		System.out.println("data base successfully added");
		}
	    
	    ResultSet result2 = statment.executeQuery("select * from project");
	    while(result2.next()){
			String createdProName = result2.getString("project_name");
			if(createdProName.equals(projectName)) {

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
				System.out.println("data base closed");
			}

/*		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.get("http://rmgtestingserver:8084/");

		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block text-uppercase']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		List<WebElement> allProjectList = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		for(WebElement createdprojectName : allProjectList) {
			String text=createdprojectName.getText();
			if(text.equals(projectName)) {
				System.out.println("project verified");
				break;
			}
	}
	driver.close();
	
		*/
	}
}
