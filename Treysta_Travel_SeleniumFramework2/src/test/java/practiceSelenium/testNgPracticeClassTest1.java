package practiceSelenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNgPracticeClassTest1 {
@BeforeClass
public void bcSetup() {
		
	System.out.println("BeforeClass -2");
	}

@BeforeTest
public void btSetuo() {
 System.out.println("BeforeTest-2");
}

@BeforeMethod
public void bmSetup() {
	System.out.println("BeforeMethod -2");
	}
@Test
public void test() {
	System.out.println("Test");	
}
@AfterClass
public void acTearDown() {
	System.out.println("AfterClass -2");
}
@AfterMethod 
public void amTearDown() {
	System.out.println("AfterMethod-2");
}
@AfterTest
public void atTearDown() {
	System.out.println("AfterTest-2");
}
@AfterSuite
public void asTearDown() {
	System.out.println("AfterSuit-2");
}
}
