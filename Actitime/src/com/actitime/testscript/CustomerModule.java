package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generics.ListenerImplementation.class)
public class CustomerModule extends BaseClass{

	@Test
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("CreateCustomer",true);
		FileLib f=new FileLib();
		String expectedCustName = f.getExcelData("CreateCustomer", 1, 2);
		String custDescription = f.getExcelData("CreateCustomer", 1, 3);
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustOption().click();
		t.getEnterCustTbx().sendKeys(expectedCustName);
		t.getEnterCustdescr().sendKeys(custDescription);
		t.getSelectdropDown().click();
		t.getOurCompany().click();
		t.getCreateCustBtn().click();
		Thread.sleep(4000);
		String actualCustName = t.getActualCustCreated().getText();
		Assert.assertEquals(actualCustName, expectedCustName);
	}
}
