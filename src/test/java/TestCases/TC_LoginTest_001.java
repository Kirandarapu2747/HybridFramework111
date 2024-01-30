package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void logintest() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(Username);
		log.info("username is entered");
		Thread.sleep(2000);
		lp.setPassword(Passwordd);
		log.info("password is entered");
		
		Thread.sleep(2000);
		lp.ClickLoginbtn();
		log.info("login btn clicking activity is completed");
		
		String exp_result="Adactin.com - Search Hotel";
		
		String Act_Result=driver.getTitle();
		
		if(Act_Result.equals(exp_result)) {
			Assert.assertTrue(true);
			log.info("Testcase is Passed");
		}
		else {
			
			captureScreen(driver,"logintest");
			log.info("Screenshot is taken");
			Assert.assertTrue(false);
			
		}
		
		
	}

}
