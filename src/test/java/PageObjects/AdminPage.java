package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	
	
	//create constructor
	public static WebDriver driver;
	public static Select sc;
	
	public AdminPage( WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//ul[@class='oxd-main-menu']/li[1]/a/span")
	WebElement btnAdmin;
	
	@FindBy(xpath="//div[@class='orangehrm-paper-container']/div/button")
	WebElement btnAdd;
	
	@FindBy(xpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")
	WebElement dropuserrole;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-wrapper']/div/input")
	WebElement txtusername;
	
	//create associated methods
	
	public void clickAdminbtn() {
		btnAdmin.click();
	}
	
	public void clickAddbtn() {
		btnAdd.click();
	}
	
	public void selectUserrole() {
		sc=new Select(dropuserrole);
		sc.selectByIndex(0);
	}
	
	public void SetNewUsername(String user) {
		txtusername.sendKeys(user);
	}

}
