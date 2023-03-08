package travel.trs.admin;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.treysta_genericUtilities.annotation.Report;
import com.treysta_genericUtilities.enums.MicrosoftExcel;
import com.treysta_genericUtilities.mainconfiguration.MainClass;
import com.treysta_genericUtilities.miscellaneous.UtilitiesInstanceTransfer;
import com.treysta_objectRepository.AdminHomePage;
import com.treysta_objectRepository.AdminLoginpage;
import com.treysta_objectRepository.AdministratorPage;
import com.treysta_objectRepository.CreatePackagePage;
import com.treysta_objectRepository.LinkNames;
import com.treysta_objectRepository.TabNames;
import com.treysta_objectRepository.TourPackagePage;
import com.treysta_objectRepository.UserHomePage;
import com.treysta_objectRepository.UserSignInpage;

public class TourismCreatePackageTest extends MainClass{
	@Report(author="Ram", category ="Regression")
	@Test(groups = { "Sanity"})
		
public void tourismCreatePackageTest() {

		AdminLoginpage adminLogin = new AdminLoginpage(driver);
		AdminHomePage adminHome = new AdminHomePage(driver); 
		CreatePackagePage createPacakage = new CreatePackagePage(driver);
		TourPackagePage tourPackagePage =new TourPackagePage(driver);
		AdministratorPage administratorPage =new AdministratorPage(driver);
		UserSignInpage userSignIn = new UserSignInpage(driver);
		UserHomePage userHomePage = new UserHomePage(driver);
		waitUtilities.impWait(driver, timeunit);
		homePage.clickTab(LinkNames.ADMIN_LOGIN);
		Assert.fail();
		adminLogin.loginAction(admin, pswrd); 
		adminHome.clickTab(TabNames.TOUR_PACKAGES);
		tourPackagePage.createAction();
		createPacakage.setDataIntoTextField(mfExcelUtl.getData(MicrosoftExcel.ADMIN.getSheetName(),"TourismCreatePackageTest"),javaScriptUtilities);
		createPacakage.submitAction();
		
		String actual = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		String expected = "Package Created Successfully";
		Assert.assertTrue(actual.contains(expected), "TCP -1----->Package Created Successfully  ");
	  //  report.info(UtilitiesInstanceTransfer.getExtentTest(),"required object for pom class created sucessfully");

		adminHome.administratorClick();
		administratorPage.adminLogoutAction();
		adminLogin.clickOnBackToHome();
		homePage.clickTab(LinkNames.SIGN_IN);
		userSignIn.loginAction(userEmail,pswrd );
		userHomePage.clickLink(LinkNames.TOUR_PACKAGES);
		
		
		actual =driver.getTitle();
		expected = " Package List";
		Assert.assertTrue(actual.contains(expected), "TCP -2-----> Package List  ");
	
	}
}
