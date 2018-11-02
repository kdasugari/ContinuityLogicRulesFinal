package appTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.CommonUtility;
import functionLib.*;
import pageObjects.TextBoxAndPeoplePickerPage;

public class TextBoxAndPeoplePickerTest {
public WebDriver driver;	   
JavascriptExecutor js;  
String tempStr = null;
boolean flag = false;
TextBoxAndPeoplePickerPage tPP;
ExtentReports extent;
ExtentTest logger;


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

@BeforeTest

public void startReport(){ 
		
extent = new ExtentReports (".\\test-output\\STMExtentReport.html", true);
        
extent.loadConfig(new File(".\\extent-config.xml"));
	
}

//Validate '*' visible upon selection radio button - 'YES'
	@Test (priority = 0)	
	public void validateAstrixVisibleIsRequiredYES()throws Exception
	{		
		//Select Is RequiredRadioButton - YES
		logger = extent.startTest("TC-001:VerifyAstrickIcon", "VerifyAstrickIcon");
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtn);
		js.executeScript(tempStr);			
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtn);
  		js.executeScript(tempStr);
  		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtn);
  		js.executeScript(tempStr);
  		
  		flag = FunctionLibrary.isDisplayed(tPP.astrixVisible);
  	    System.out.println("astrix......................."+ flag);
	    assertEquals(flag, true);
  	    logger.log(LogStatus.PASS, "Astrick symbol successfully verified");
	}
	
	@Test (priority = 1)	
	public void validateIsRequiredYES_ErrorMsg1()throws Exception
	{		
		//Validate second error message
		logger = extent.startTest("TC-002:VerifyErrormessage1", "IsRequiredTextboxErrorMsg");
		FunctionLibrary.enterText(tPP.textBoxIsOptional, "test");
		FunctionLibrary.click(tPP.updateBtn);
		tempStr = tPP.getText(tPP.errMsgNameText1);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("This field is required."));
	    logger.log(LogStatus.PASS, "IsRequiredTextboxErrorMsg successfully verified");
	}
	
	@Test (priority = 2)	
	public void validateIsRequiredYES_ErrorMsg2()throws Exception
	{		
		//Validate first error message
		logger = extent.startTest("TC-003:VerifyErrormessage2", "IsRequiredTextboxErrorMsg");
		tempStr = tPP.getText(tPP.errMsgNameText2);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("Your form contains 1 item(s) in need of attention, see details below."));
	    
	    logger.log(LogStatus.PASS, "IsRequiredTextboxErrorMsg2 successfully verified");
	}
	
	@Test (priority = 3)	
	public void validateAstrixVisibleIsRequiredNO()throws Exception
	{		
		//Select Is RequiredRadioButton - NO
		logger = extent.startTest("TC-004:VerifyAstrickSymbolforNO", "VerifyAstrickSymbolforNoRadioButton");
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtn);
		js.executeScript(tempStr);	
		Thread.sleep(1000);
		flag = FunctionLibrary.isDisplayed(tPP.astrixVisible);
  	    System.out.println("astrix......................."+ flag);
	    assertEquals(flag, false);
	    logger.log(LogStatus.PASS, "AstrickSymbolforNoRadioButton successfully verified");

	}
	
	@Test (priority = 4) 
	public void validateIsRequiredNO()throws Exception
	{		
		
		//Select Is RequiredRadioButton - NO
		logger = extent.startTest("TC-005:VerifyErrorMsgforNO", "VerifyErrormessageforNo");
   		tempStr = tPP.getText(tPP.errMsgNameText1);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("This field is required."));
	    logger.log(LogStatus.PASS, "ErrormessageforNo successfully verified");
	}

	@Test (priority = 5)	
	public void validateAstrixVisibleIsRequiredNEITHER()throws Exception
	{		
		//Select Is RequiredRadioButton - NEITHER
		logger = extent.startTest("TC-006:VerifyAstrickSymbolforNEITHER", "VerifyAstrickSymbolforNEITHERRadioButton");
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtn);
		js.executeScript(tempStr);			

		flag = FunctionLibrary.isDisplayed(tPP.astrixVisible);
  	    System.out.println("astrix......................."+ flag);
	    assertEquals(flag, false);
	    logger.log(LogStatus.PASS, "AstrickSymbolforNEITHERRadioButton successfully verified");
	}
	
	@Test (priority = 6) 
	public void validateIsRequiredNEITHER()throws Exception
	{		
		//Select Is RequiredRadioButton - NEITHER
		logger = extent.startTest("TC-007:VerifyErrorMsgforNEITHER", "VerifyErrormessageforNEITHER");
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtn);
		js.executeScript(tempStr);	

		tempStr = tPP.getText(tPP.errMsgNameText1);
		String errMSG= (String) js.executeScript(tempStr);	

	    System.out.println("errMSG......................."+ errMSG);			
	    assertTrue(errMSG.equals("This field is required."));
	    logger.log(LogStatus.PASS, "ErrormessageforNEITHER successfully verified");

	}
	@Test (priority = 7) 
	public void validateIsRequiredUpdate()throws Exception
	{		
		//Validate Update with No radio button
		logger = extent.startTest("TC-008:VerifyIsrequiredUpdateButton", "VerifyIsrequiredUpdateButtonwithNO");
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtn);
		js.executeScript(tempStr);
		FunctionLibrary.click(tPP.updateBtn);
		String expectedTitle = "Radio Button - Text Box";
		String actualTitle = tPP.radioButtoncheckboxPageTitle.getText();
		Assert.assertEquals(actualTitle, expectedTitle);	    
		logger.log(LogStatus.PASS, "IsRequiredUpdateButtonwithNO successfully verified");
	}
	
	@AfterMethod
	
	public void getResult(ITestResult result){
			
	if(result.getStatus() == ITestResult.FAILURE){
				
	logger.log(LogStatus.FAIL, "Test Case Failed : "+result.getName());
				
	logger.log(LogStatus.FAIL, "Test Case Failed due to "+result.getThrowable());
			
	}
	else 
	if(result.getStatus() == ITestResult.SKIP){
				
	logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			
	}
		
	extent.endTest(logger);
		}
		
	@AfterTest
		public void endReport(){
	               
	extent.flush();
	               
	 extent.close();
	    
	}
		
	@AfterClass
		
	public void closeBrowser(){
		
	FunctionLibrary.closeBrowser();

	}
	
	}
	
