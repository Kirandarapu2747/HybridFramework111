package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig() {
		//configuration of properties file
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testing.properties");
	 try {
		 FileInputStream fis=new FileInputStream(f);
		 pro=new Properties();
		 pro.load(fis);
		 
	 }catch(Exception e) {
		 System.out.println(e.getMessage());
	 }
	
	
	}
	
	//create corresponding methods
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
		
	}
	
	public String getUsername() {
		String uname=pro.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		String pword=pro.getProperty("password");
		return pword;
	}

}
