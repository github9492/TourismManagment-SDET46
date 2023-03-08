package practiceSelenium;

import org.testng.annotations.Test;

public class SendingDataFromCMD {
	@Test
	public void main() {
		String cmdData= System.getProperty("url");
		System.out.println(cmdData);
	}
	
	}


  