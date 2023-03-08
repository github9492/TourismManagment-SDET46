package practiceSelenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.treysta_genericUtilities.mainconfiguration.BaseClassPractice;

public class TesNgPracticeCalss extends BaseClassPractice {
	
	@Test
	public void test1() {
		System.out.print(Thread.currentThread().getId());
		driver.get("http://rmgtestingserver/domain/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
@Test
public void getProject() {
	driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
	Assert.fail();
}
}  
