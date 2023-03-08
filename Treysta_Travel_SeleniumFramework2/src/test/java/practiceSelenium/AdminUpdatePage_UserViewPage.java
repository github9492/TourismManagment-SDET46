package practiceSelenium;

import org.testng.annotations.Test;

import com.treysta_genericUtilities.enums.MicrosoftExcel;
import com.treysta_genericUtilities.mainconfiguration.MainClass;
import com.treysta_objectRepository.AdminHomePage;
import com.treysta_objectRepository.AdminLoginpage;
import com.treysta_objectRepository.AdministratorPage;
import com.treysta_objectRepository.HomePage;
import com.treysta_objectRepository.LinkNames;
import com.treysta_objectRepository.TabNames;
import com.treysta_objectRepository.UpdatePageDataPage;
import com.treysta_objectRepository.UserSignInpage;

public class AdminUpdatePage_UserViewPage extends MainClass {
@Test
	public void adminUpdatePage_UserViewPage() throws InterruptedException {
	
	String aboutus = mfExcelUtl.getData(MicrosoftExcel.ADMIN.getSheetName(),"Update Page Date","about us ");
	System.out.println(aboutus);
	AdminLoginpage adminLoginPage = new AdminLoginpage(driver);
	AdminHomePage adminHomePage = new AdminHomePage(driver);
	UpdatePageDataPage updatePageDataPage = new UpdatePageDataPage(driver);
	AdministratorPage administratorPage = new AdministratorPage(driver);
	UserSignInpage UserSignInPage = new UserSignInpage(driver);
	HomePage homePage = new  HomePage(driver);
	
	homePage.clickTab(LinkNames.ADMIN_LOGIN);
	adminLoginPage.loginAction(admin, pswrd);
	adminHomePage.clickTab(TabNames.MANAGE_PAGES);
	updatePageDataPage.selectMenu(webDriverUtilities, "aboutus");
	Thread.sleep(3000);
	updatePageDataPage.aboutTxtFieldClearText();
	
	updatePageDataPage.aboutTxtFieldSendText(aboutus);
	updatePageDataPage.clickUpdate();
	
	//validation
	adminHomePage.clickTab(TabNames.ADMINISTRATOR);
	administratorPage.adminLogoutAction();
	adminLoginPage.clickOnBackToHome();
	homePage.clickTab(LinkNames.SIGN_IN);
	UserSignInPage.loginAction(userEmail, pswrd);
	homePage.clickTab(LinkNames.ABOUT);
	
	
	// validation
	
	
	
	
	
	}
}
