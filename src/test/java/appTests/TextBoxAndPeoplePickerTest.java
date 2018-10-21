package appTests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utilities.CommonUtility;
import functionLib.*;
import pageObjects.TextBoxAndPeoplePickerPage;

public class TextBoxAndPeoplePickerTest {
public WebDriver driver;	   
JavascriptExecutor js;  
String tempStr = null;
TextBoxAndPeoplePickerPage tPP;


@BeforeClass
public void login()throws Exception
{		
	driver = FunctionLibrary.launchBrowser();
	String un = CommonUtility.getProperty("UserName");
	String pw = CommonUtility.getProperty("Passoword");
	Login lg= new Login(driver);
	tPP = new TextBoxAndPeoplePickerPage(driver);
	js = (JavascriptExecutor) driver;
	//Navigate to dashboard
	lg.login(un, pw);

	//Navigate to TextBoxAndPeoplePickerPage
	tPP.navigateToTextBoxAndPeoplePickerPage();
	
}
//Validate '*' visible upon selection radio button - 'YES'
	@Test (priority = 0)	
	public void validateAstrixVisibleIsRequiredYES()throws Exception
	{		
		//Select Is RequiredRadioButton - YES
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtn);
		js.executeScript(tempStr);			

		tempStr = tPP.asterixVisible();
	    System.out.println("tempStr......................."+ tempStr);	
	    String count= (String) js.executeScript(tempStr);	

	    System.out.println("count......................."+ count);
	    assertTrue(count.equals("*"));
	}
	
	@Test (priority = 1)	
	public void validateIsRequiredYES()throws Exception
	{		
		//Select Is RequiredRadioButton - YES
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtn);
		js.executeScript(tempStr);			
		js.executeScript(tPP.updateBtn);
		tempStr = tPP.getText(tPP.errMsgNameText1);

		String errMSG= (String) js.executeScript(tempStr);	

	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("This field is required."));
	}
	
	@Test (priority = 2)	
	public void validateAstrixVisibleIsRequiredNO()throws Exception
	{		
		//Select Is RequiredRadioButton - NO
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtn);
		js.executeScript(tempStr);			

		tempStr = tPP.asterixVisible();

	    String count= (String) js.executeScript(tempStr);	

	    System.out.println("count......................."+ count);	
	    assertTrue(count.equals(""));

	}
	
	@Test (priority = 3) 
	public void validateIsRequiredNO()throws Exception
	{		
		
		//Select Is RequiredRadioButton - NO
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtn);
		js.executeScript(tempStr);

		js.executeScript(tPP.updateBtn);

		tempStr = tPP.getText(tPP.errMsgNameText1);
		String errMSG= (String) js.executeScript(tempStr);	

	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals(""));
	}
	
	@Test (priority = 4)	
	public void validateAstrixVisibleIsRequiredNEITHER()throws Exception
	{		
		//Select Is RequiredRadioButton - NEITHER
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtn);
		js.executeScript(tempStr);			

		tempStr = tPP.asterixVisible();

	    String count= (String) js.executeScript(tempStr);	

	    System.out.println("count......................."+ count);	
	    assertTrue(count.equals(""));

	}
	
	@Test (priority = 5) 
	public void validateIsRequiredNEITHER()throws Exception
	{		
		//Select Is RequiredRadioButton - NEITHER
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtn);
		js.executeScript(tempStr);	

		js.executeScript(tPP.updateBtn);	

		tempStr = tPP.getText(tPP.errMsgNameText1);
		String errMSG= (String) js.executeScript(tempStr);	

	    System.out.println("errMSG......................."+ errMSG);			
	    assertTrue(errMSG.equals(""));

	}
	
}