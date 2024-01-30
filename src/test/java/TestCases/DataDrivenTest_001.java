package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Utilities.XLUtils;

public class DataDrivenTest_001 extends BaseClass {

	
	@Test(dataProvider="Exceldata11")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(user);
	    log.info("username is entered");
		lp.setPassword(pwd);
		log.info("password is entered");
		
		lp.ClickLoginbtn();
		log.info("login button clicking activity is completed");
		Thread.sleep(4000);
		
	
		
		
	}
	
	@DataProvider(name="Exceldata11")
	String [][]getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\Exceldata11.xlsx";
	    int rownum=XLUtils.getRowCount(path, "Sheet1");
	    int colnum=XLUtils.getcellcount(path, "Sheet1", 1);
	    
	    String logindata[][]=new String [rownum][colnum];
	    
	    for(int i=1;i<=rownum;i++) {
	    	
	    	for(int j=0;j<colnum;j++) {
	    		logindata[i-1][j]=XLUtils.getcellData(path, "Sheet1", i, j);
	    	}
	    	
	    }
	return logindata;
	}
}
