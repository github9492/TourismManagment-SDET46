package travel.trs.admin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.treysta_genericUtilities.annotation.Report;
import com.treysta_genericUtilities.enums.MicrosoftExcel;
import com.treysta_genericUtilities.mainconfiguration.MainClass;
import com.treysta_genericUtilities.miscellaneous.JavaScriptUtilites;
import com.treysta_genericUtilities.miscellaneous.WaitUtilities;
import com.treysta_objectRepository.AdminHomeManagepage;
import com.treysta_objectRepository.AdminHomePage;
import com.treysta_objectRepository.AdminLoginpage;
import com.treysta_objectRepository.CreatePackagePage;
import com.treysta_objectRepository.HomePage;
import com.treysta_objectRepository.LinkNames;
import com.treysta_objectRepository.TabNames;
import com.treysta_objectRepository.TourPackagePage;
import com.treysta_objectRepository.UpdatePackagePage;

public class ManagePackageTest extends MainClass  {
	@Report(author="gaurav", category ="sanity")
	@Test (groups = { "Regression","minor"})
	public  void managePackageTest(){

		String price = Integer.toString(javaUtilities.getRandomNumber(1000));

		
		AdminLoginpage adminLogin = new AdminLoginpage(driver);
		HomePage homePage = new HomePage(driver);
		AdminHomePage adminHome = new AdminHomePage(driver); 
		CreatePackagePage createPacakage = new CreatePackagePage(driver);
		TourPackagePage tourPackagePage =new TourPackagePage(driver);
		AdminHomeManagepage adminHomeManagepage= new AdminHomeManagepage(driver);
		UpdatePackagePage updatePackagePage = new UpdatePackagePage(driver);

		waitUtilities.impWait(driver, timeunit);
		homePage.clickTab(LinkNames.ADMIN_LOGIN);
		WebElement abc = driver.findElement(By.xpath("//input[@class='name']"));
		javaScriptUtilities.highlight(abc);
		adminLogin.loginAction(admin, pswrd); 
		adminHome.clickTab(TabNames.TOUR_PACKAGES);
		tourPackagePage.createAction();
		createPacakage.setDataIntoTextField(mfExcelUtl.getData(MicrosoftExcel.ADMIN.getSheetName(),"TourismCreatePackageTest"),javaScriptUtilities);
		createPacakage.submitAction();


		
		String actual = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		String expected = "Package Created Successfully";
		Assert.assertTrue(actual.contains(expected),"MPT ----> 1 Package not Created Successfully ");
	
		adminHome.clickTab(TabNames.TOUR_PACKAGES);
		tourPackagePage.manageAction();


       Assert.fail();

		expected = "HomeManage Packages";
		actual = driver.findElement(By.xpath("//li[text()='Manage Packages']")).getText();
		Assert.assertTrue(actual.contains(expected),"MPT ---->1 Package page displayed Successfully");
		
		adminHomeManagepage.fetchLastPackage(javaScriptUtilities);
		updatePackagePage.packagePriceTxtField(price);
		
		updatePackagePage.submitBtnAction(javaScriptUtilities);

		expected = "Package Updated Successfully";
		actual= driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		Assert.assertTrue(actual.contains(expected),"MPT ---->2 Package not Updated Successfully");
	
	
	}

}
