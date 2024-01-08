package TestCases;

import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void logintest() throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername();
		Thread.sleep(2000);
		lp.setPassword();
		Thread.sleep(2000);
		lp.ClickLoginbtn();
		
	}

}
