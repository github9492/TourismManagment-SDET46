package travel.trs.user;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.treysta_genericUtilities.annotation.Report;
import com.treysta_genericUtilities.mainconfiguration.MainClass;
import com.treysta_objectRepository.AdminHomePage;
import com.treysta_objectRepository.AdminLoginpage;
import com.treysta_objectRepository.AdministratorPage;
import com.treysta_objectRepository.LinkNames;
import com.treysta_objectRepository.ManageBookingPage;
import com.treysta_objectRepository.PackageDetailsPage;
import com.treysta_objectRepository.PackageListPage;
import com.treysta_objectRepository.TabNames;
import com.treysta_objectRepository.UserHomePage;
import com.treysta_objectRepository.UserLogoutPage;
import com.treysta_objectRepository.UserSignInpage;

public class BookPackageTest extends MainClass{
	@Report(author="Anushree", category ="regression")
	@Test(groups = { "Regression","Major"})

	public void bookPackageTest() {

		String comment = mfExcelUtl.getData(admin, "BookPackageTest","comment");
		UserSignInpage userSignInpage =new UserSignInpage(driver);
		UserHomePage userHomePage = new  UserHomePage(driver);
		PackageListPage PackageListPage = new PackageListPage(driver);
		PackageDetailsPage packageDetailsPage = new  PackageDetailsPage(driver);
		UserLogoutPage userLogout = new UserLogoutPage(driver);
		AdminLoginpage adminLogin= new AdminLoginpage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		ManageBookingPage ManageBookingPage  = new ManageBookingPage(driver);
		AdministratorPage administratorPage = new  AdministratorPage(driver);
		waitUtilities.impWait(driver, timeunit);
		homePage.clickTab(LinkNames.SIGN_IN);
		userSignInpage.loginAction(userEmail, pswrd);
		userHomePage.clickLink(LinkNames.TOUR_PACKAGES);
		PackageListPage.declaredPackage(javaScriptUtilities);
		PackageListPage.detailsButton();
		javaScriptUtilities.scrollDown();
		packageDetailsPage.clickOnDateField(LinkNames.FROM_DATE);
		packageDetailsPage.clickOnDate("25");
		packageDetailsPage.clickOnDateField(LinkNames.TO_DATE);
		packageDetailsPage.clickOnDate("28");
		packageDetailsPage.commentTxtField(comment);
		javaScriptUtilities.scrollDown();
		packageDetailsPage.bookBtnAction();
		String expected = "Booked Successfully";
		String actual = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(actual.contains(expected),"BPT--->1 Booking not Verified  in history pages");
		
		userLogout.logOutAction(javaScriptUtilities);
		homePage.clickTab(LinkNames.ADMIN_LOGIN);
		adminLogin.loginAction(admin, pswrd);
		adminHomePage.clickTab(TabNames.MANAGE_BOOKING);
		javaScriptUtilities.scrollDown();
		ManageBookingPage.lastElementOfPageConfirm();
		popups.confirmAlert(driver);
		
		String actual1 = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		String expected2 = "Booking Confirm successfully";
		sf.assertTrue(actual1.contains(expected2),"BPT--->1 Booking not Confirm");
	
		adminHomePage.administratorClick();
		administratorPage.adminLogoutAction();
		adminLogin.clickOnBackToHome();
		homePage.clickTab(LinkNames.SIGN_IN);
		userSignInpage.loginAction(userEmail, pswrd);
		userHomePage.clickLink(LinkNames.MY_TOUR_HISTORY);
		javaScriptUtilities.scrollDown();
		
		actual = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[7]")).getText();
		expected  = "Confirmed";
	
		sf.assertTrue(actual.contains(expected),"BPT--->2 Booking not Verified  in history pages");
	
	}

}
