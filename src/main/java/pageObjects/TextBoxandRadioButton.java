package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utilities.CommonUtility;
import functionLib.FunctionLibrary;
import functionLib.Login;




public class TextBoxandRadioButton {
	
	//@FindBy(xpath = "//a[@role='tab'][contains(.,'Text Box and People Picker')]")
	//@FindBy(xpath = "//a[@role='tab'][contains(.,'GR All Test - RB')]")
	//span[@class='aciTreeText'][contains(.,'GR All Test - RB')]
	
	//@FindBy(xpath = "//span[@class='aciTreeText'][contains(.,'GR All Test - RB')]")
	
public WebDriver driver;
	   
	
	
	@Test
	public void login()throws Exception
	{
		System.out.println(".....................");
		driver = FunctionLibrary.launchBrowser();
		String un = CommonUtility.getProperty("UserName");
		String pw = CommonUtility.getProperty("Passoword");
		Login lg= new Login(driver);
		lg.login(un, pw);
	}

}
