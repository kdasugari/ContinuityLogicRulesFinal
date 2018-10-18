package appTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Utilities.CommonUtility;
import functionLib.FunctionLibrary;
import functionLib.Login;

public class TextBoxandRadioButtonTest {
	
public WebDriver driver;	   
	
	//@FindBy(xpath = "(//input[contains(@value,'YES')])[1]") WebElement yesRadiobuttonLocator;	
	@FindBy(xpath = "(//input[contains(@value,'NO')])[1]") WebElement noRadiobuttonLocator;
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Update')])[2]") WebElement updateEle;
	//@FindBy(xpath = "(//span[@class='required'][contains(.,'*')])[14]") WebElement astricEle;
	String  astricxpath = "(//span[@class='required'][contains(.,'*')])[14]";
	@FindBy(xpath = "(//input[contains(@value,'NEITHER')])[1]") WebElement neitherRadiobuttonLocator;
//	@FindBy(xpath = "//label[text()='Radio Button 1']//..//input[@value='YES']") WebElement yesRadiobuttonLocator;
	@FindBy(xpath = "//a[text()='Text Box and People Picker']") WebElement textBoxPicker;
	@FindBy(xpath = "//label[text()='IS REQUIRED']") WebElement radioButtonPage;
	
	
	@Test
	public void login()throws Exception
	{		
		driver = FunctionLibrary.launchBrowser();
		String un = CommonUtility.getProperty("UserName");
		String pw = CommonUtility.getProperty("Passoword");
		Login lg= new Login(driver);
		lg.login(un, pw);
//	    FunctionLibrary.waitForElement(radioButtonPage);
//		FunctionLibrary.click(yesRadiobuttonLocator);
//		((JavascriptExecutor) driver).executeScript("return $(\"input[value='NEITHER']\").prop(\"checked\", true).trigger(\"click\");");
		String yesRadiobuttonLocator = "return $(\"input[value='" + "YES" + "']\").prop(\"checked\", true).trigger(\"click\");";
		((JavascriptExecutor) driver).executeScript(yesRadiobuttonLocator);
	                                                           		
	    System.out.println(".......................");
		//function = new CommanFunctions(driver);
		yesButtonValidation();
		noButtonValidation();
		neitherButtonValidation();
	}
	
	
	public void yesButtonValidation()
	{
		By pathStar= By.xpath(astricxpath);		
		 
//		boolean flag = function.isRequired(yesRadiobuttonLocator,pathStar,"");
//		System.out.println("flag: "+flag);
	}
	
	public void noButtonValidation()
	{
		By pathStar= By.xpath(astricxpath);
//		boolean flag = FunctionLibrary.(noRadiobuttonLocator,pathStar,"");
//		System.out.println("flag: "+flag);
	}
	
	public void neitherButtonValidation()
	{
		By pathStar= By.xpath(astricxpath);
//		boolean flag = function.isRequired(neitherRadiobuttonLocator,pathStar,"");
//		System.out.println("flag: "+flag);
	}
	
	public void errorMessageValidation()
	{
		By pathStar= By.xpath(astricxpath);
//		boolean flag = function.isRequired(yesRadiobuttonLocator,pathStar,"");
//		System.out.println("flag: "+flag);
	}
	
	
}
