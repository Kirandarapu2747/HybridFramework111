package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Utilities.ReadConfig;

public class BaseClass {
	public  WebDriver driver;
	public static Logger log;
	
	ReadConfig rc=new ReadConfig();
	
	public String URL=rc.getApplicationURL();
	public String Username=rc.getUsername();
	public String Passwordd=rc.getPassword();
	
	@BeforeClass
	@Parameters("browser")
	
	public void openApplication(String br) {
		
		if(br.equals("chrome")) {
		driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(br.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(URL);
		driver.manage().window().maximize();
		
		log=Logger.getLogger(this.getClass());
		PropertyConfigurator.configure(System.getProperty("user.dir") +"\\Log4j.properties");
	}
	
	@AfterClass
	public void CloseApplication() {
		
		driver.close();
	}
	
public void captureScreen(WebDriver driver,String name) throws IOException {
		
		//initialize
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./Screenshots/"+name+".png");
		FileUtils.copyFile(src, target);
		log.info("screenshot is taken");
	}
	

}
