package appTests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CheckBoxandRadioButton;
import pageObjects.TextBoxAndPeoplePickerPage;
import Utilities.CommonUtility;

import com.relevantcodes.extentreports.ExtentTest;

import functionLib.FunctionLibrary;
import functionLib.Login;

public class CheckBoxandRadioButtonTest {
	
	public WebDriver driver;	   
	JavascriptExecutor js;  
	String tempStr = null;
	CheckBoxandRadioButton cBR;
	TextBoxAndPeoplePickerPage tPP;
	ExtentTest logger;
	
			
	@BeforeClass
	
	public void login()throws Exception
	{		
		driver = FunctionLibrary.launchBrowser();
		String un = CommonUtility.getProperty("UserName");
		String pw = CommonUtility.getProperty("Passoword");
		Login lg= new Login(driver);
		cBR = new CheckBoxandRadioButton(driver);
		tPP = new TextBoxAndPeoplePickerPage(driver);
		
		
		lg.login(un, pw);		
        
		//Navigate to TextBoxAndPeoplePickerPage
		cBR.navigateToCheckBoxAndDropdownPage();
		
	}
	
	//Validate '*' visible upon selection radio button - 'YES'
	/*@Test (priority = 0)	
	public void validateAstrixVisibleIsRequiredYES()throws Exception
	{		
		//Select Is RequiredRadioButton - YES
		tempStr = tPP.selectRadioButton("YES" , cBR.radioBtn1);
		js.executeScript(tempStr);			
		String count= cBR.getText();		
	    System.out.println("count......................."+ count);
	    assertTrue(count.equals("*"));
	}
	
	@Test (priority = 1)	
	public void validateAstrixVisibleIsRequiredNO()throws Exception
	{		
		//Select Is RequiredRadioButton - NO
		tempStr = tPP.selectRadioButton("NO" , cBR.radioBtn1);
		js.executeScript(tempStr);		
		String count= cBR.getText();		
	    System.out.println("count......................."+ count);
	    assertTrue(count.equals(""));
	}
	
	
	
	@Test (priority = 3)
	public void ValidateErrorMessage()
	{
		tempStr = tPP.selectRadioButton("YES" , cBR.radioBtn1);
		js.executeScript(tempStr);
		
		tempStr = tPP.selectRadioButton("YES" , cBR.radioBtn2);
		js.executeScript(tempStr);
		cBR.getErrorMessage();
		tempStr = tPP.getText(cBR.errorMessageRadioButton1);
		String tempStr1 = tPP.getText(cBR.errorMessageRadioButton1_checkBox);
		
		String errMSG1= (String) js.executeScript(tempStr1);	
	    System.out.println("errMSG......................."+ errMSG1);
		
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    String errorMessage = "Your form contains 1 item(s) in need of attention, see details below.";
	    String errorMessage1 = "This field is required.";
	    assertTrue(errorMessage.equalsIgnoreCase(errMSG));
	    assertTrue(errorMessage1.equalsIgnoreCase(errMSG1));
	    logger.log(LogStatus.PASS, "ErrormessageforNo successfully verified");
	
	}*/
	
	//.......................IsOptional.................................................
	/*@Test (priority = 4)
	public void validateAstrixVisibleIsOptinalYES()throws Exception
	{		
		//Select Is RequiredRadioButton - YES
		tempStr = tPP.selectRadioButton("YES" , cBR.radioBtn2);
		js.executeScript(tempStr);			
		String count= cBR.getStar2Text();		
	    System.out.println("count......................."+ count);
	    assertTrue(count.equals(""));
	}
	
	@Test (priority = 5)
	public void validateAstrixVisibleIsIsOptinalNO()throws Exception
	{		
		//Select Is RequiredRadioButton - YES
		tempStr = tPP.selectRadioButton("NO" , cBR.radioBtn2);
		js.executeScript(tempStr);			
		String count= cBR.getStar2Text();		
	    System.out.println("count......................."+ count);
	    assertTrue(count.equals("*"));
	}
	
	
	

	@Test (priority = 7)
	public void ValidateErrorMessageIsOptional()
	{
				
		tempStr = tPP.selectRadioButton("NO" , cBR.radioBtn2);
		js.executeScript(tempStr);
		cBR.getErrorMessage();
		tempStr = tPP.getText(cBR.errorMessageRadioButton1);
		String tempStr1 = tPP.getText(cBR.errorMessageRadioButton2_checkBox);
		
		String errMSG1= (String) js.executeScript(tempStr1);	
	    System.out.println("errMSG......................."+ errMSG1);
		
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    String errorMessage = "Your form contains 1 item(s) in need of attention, see details below.";
	    String errorMessage1 = "This field is required.";
	    assertTrue(errorMessage.equalsIgnoreCase(errMSG));
	    assertTrue(errorMessage1.equalsIgnoreCase(errMSG1));
	    logger.log(LogStatus.PASS, "ErrormessageforNo successfully verified");
	
	}
	
	
	
	

	
	*/
	//...........................................IS VISIBLE ...........................
	/*@Test (priority = 7)
	public void validateIsVisibleYES()throws Exception
	{		
		//Select Is RequiredRadioButton - YES
		tempStr = tPP.selectRadioButton("YES" , cBR.radioBtn3);
		js.executeScript(tempStr);			
		
		tempStr = tPP.selectRadioButton("TRUE" , cBR.radioBtn4);
		js.executeScript(tempStr);
		
		tempStr = tPP.selectRadioButton("FALSE" , cBR.radioBtn4);
		js.executeScript(tempStr);
		
		String checkBox= cBR.getcheckText();
	    System.out.println("count......................."+ checkBox);
	    assertTrue(checkBox.equals("Checkbox List 3"));
	}
	
	@Test (priority = 8)
	public void validateIsVisibleNO()throws Exception
	{		
		//Select Is RequiredRadioButton - YES
		tempStr = tPP.selectRadioButton("NO" , cBR.radioBtn3);
		js.executeScript(tempStr);			
		
		tempStr = tPP.selectRadioButton("TRUE" , cBR.radioBtn3);
		js.executeScript(tempStr);
		
		tempStr = tPP.selectRadioButton("FALSE" , cBR.radioBtn3);
		js.executeScript(tempStr);
		
		String checkBox= cBR.getcheckText();
	    System.out.println("count......................."+ checkBox);
	    assertTrue(checkBox.equals("Checkbox List 3"));
	}
	

	
	//.................IS HIDDEN....................................
	
	@Test (priority = 10)
	public void validateIsHiddenRadioButton()throws Exception
	{		
		tempStr = tPP.selectRadioButton("YES" , cBR.radioBtn_Hidden);
		js.executeScript(tempStr);
		tempStr = tPP.getText(cBR.errorMessageRadioButton4_Hidden);			
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("×NoticeHidden field values will not be saved.  Please verify you want to do this before updating."));
	    //logger.log(LogStatus.PASS, "ErrormessageforNo successfully verified");
		
	}
	
	@Test (priority = 11)
	public void validateIsHiddenRadioButtonNO()throws Exception
	{		
		tempStr = tPP.selectRadioButton("NO" , cBR.radioBtn_Hidden);
		js.executeScript(tempStr);
		
		tempStr = tPP.selectRadioButton("TRUE" , cBR.radioBtn_Hidden1);
		js.executeScript(tempStr);
		
		tempStr = tPP.selectRadioButton("FALSE" , cBR.radioBtn_Hidden1);
		js.executeScript(tempStr);		
		tempStr = cBR.getcheckText4();		
	    System.out.println("errMSG......................."+ tempStr);
	    assertTrue(tempStr.equals("Checkbox List 4"));
	    //logger.log(LogStatus.PASS, "ErrormessageforNo successfully verified");
		
	}*/
	
	//.........................IS READ-ONLY.........................
	
	/*@Test (priority = 12)
	public void validateIsReadOnlyButton()throws Exception
	{		
		tempStr = tPP.selectRadioButton("YES" , cBR.radioBtn5);
		js.executeScript(tempStr);
		tempStr = cBR.getAttributs();				
	    System.out.println("errMSG......................."+ tempStr);
	   assertTrue("true".equals(tempStr));
	    //logger.log(LogStatus.PASS, "ErrormessageforNo successfully verified");
		
	}
	
	@Test (priority = 13)
	public void validateIsReadOnlyButtonNO()throws Exception
	{		
		tempStr = tPP.selectRadioButton("NO" , cBR.radioBtn5);
		js.executeScript(tempStr);
					
	    System.out.println("errMSG......................."+ tempStr);
	    assertTrue(null==tempStr);
	  
	}*/
	
	//.........................IS INVALID.........................
	@Test (priority = 12)
	public void validateIsInvalidButton()throws Exception
	{		
		tempStr = tPP.selectRadioButton("YES" , cBR.radioBtn_Invalid);
		js.executeScript(tempStr);
		tempStr = tPP.getText(cBR.errorMessageRadioButton4_Invalid);			
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);			
	   
	   assertTrue("true".equals(tempStr));
	    //logger.log(LogStatus.PASS, "ErrormessageforNo successfully verified");
		
	}
	
}
