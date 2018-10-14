package appTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Utilities.CommonUtility;
import functionLib.CommanFunctions;
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
	CommanFunctions function;
	@FindBy(xpath = "(//input[contains(@name,'RadioButton11743')])[1]")WebElement yesRadiobuttonLocator;
	
	@Test
	public void login()throws Exception
	{
		
		driver = FunctionLibrary.launchBrowser();
		String un = CommonUtility.getProperty("UserName");
		String pw = CommonUtility.getProperty("Passoword");
		Login lg= new Login(driver);
		lg.login(un, pw);
		FunctionLibrary.click(yesRadiobuttonLocator);
		
	    System.out.println(".......................");
		//function = new CommanFunctions(driver);
		yesButtonValidation();
		noButtonValidation();
		neitherButtonValidation();
	}
	
	
	public void yesButtonValidation()
	{
		By pathStar= By.xpath(astricxpath);		
		 
		boolean flag = function.isRequired(yesRadiobuttonLocator,pathStar,"");
		System.out.println("flag: "+flag);
	}
	
	public void noButtonValidation()
	{
		By pathStar= By.xpath(astricxpath);
		boolean flag = function.isRequired(noRadiobuttonLocator,pathStar,"");
		System.out.println("flag: "+flag);
	}
	
	public void neitherButtonValidation()
	{
		By pathStar= By.xpath(astricxpath);
		boolean flag = function.isRequired(neitherRadiobuttonLocator,pathStar,"");
		System.out.println("flag: "+flag);
	}
	
	public void errorMessageValidation()
	{
		By pathStar= By.xpath(astricxpath);
		boolean flag = function.isRequired(yesRadiobuttonLocator,pathStar,"");
		System.out.println("flag: "+flag);
	}
	
	
}
