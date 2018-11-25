package appTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
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

import pageObjects.TextBoxAndPeoplePickerPage;
import Utilities.CommonUtility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import functionLib.FunctionLibrary;
import functionLib.Login;

public class TextBoxAndPeoplePickerTest {
public WebDriver driver;	   
JavascriptExecutor js;  
String tempStr = null;
boolean flag = false;
TextBoxAndPeoplePickerPage tPP;
ExtentReports extent;
ExtentTest logger;
Login lg;


@BeforeClass
public void login()throws Exception
{		
	driver = FunctionLibrary.launchBrowser();
	String un = CommonUtility.getProperty("UserName");
	String pw = CommonUtility.getProperty("Passoword");
	Login lg= new Login(driver);
	//Navigate to TextBoxAndPeoplePickerPage
	//js = (JavascriptExecutor) driver;
	lg.login(un, pw);
	//tPP = new TextBoxAndPeoplePickerPage(driver);
	//tPP.navigateToTextBoxAndPeoplePickerPage();
	
}

@BeforeTest

public void startReport(){ 
		
extent = new ExtentReports (".\\test-output\\STMExtentReport.html", true);
        
extent.loadConfig(new File(".\\extent-config.xml"));
	
}

//Validate '*' visible upon selection radio button - 'YES'
	@Test (priority = 1)	
	public void validateAstrixVisibleIsRequiredYES()throws Exception
	{		
		//Select Is Required Radio Button - YES
		logger = extent.startTest("TC-001:VerifyAstrickIcon", "Verify '*' is displayed - Is Required - YES");
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIR);
		js.executeScript(tempStr);
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIR);
  		js.executeScript(tempStr);
  		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIR);
  		js.executeScript(tempStr);
  		  		
  		flag = FunctionLibrary.isDisplayed(tPP.astrixVisibleIR);
  	    System.out.println("astrix......................."+ flag);
	    assertEquals(flag, true);
  	    logger.log(LogStatus.PASS, "Astrick symbol successfully verified");
	}
	
//Validate Error Message "This field is required" when updated with entering text box1 value	
	@Test (priority = 2)	
	public void validateIsRequiredYES_ErrorMsg1()throws Exception
	{		
		//Validate second error message
		logger = extent.startTest("TC-002:VerifyErrormessage1", "Verify Error is displayed - Is Required - YES - Click update");
		FunctionLibrary.enterText(tPP.textBoxIsOptional, "test");
		FunctionLibrary.click(tPP.updateBtn);
		tempStr = tPP.getText(tPP.errMsgNameIRText1);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("This field is required."));
	    logger.log(LogStatus.PASS, "This field is required. Error message successfully verified");
	}
	
//Validate Error Message "Your form contains 1 item(s) in need of attention, see details below." when updated with entering text box1 value
	
	@Test (priority = 3)	
	public void validateIsRequiredYES_ErrorMsg2()throws Exception
	{		
		//Validate first error message
		logger = extent.startTest("TC-003:VerifyErrormessage2", "Verify Error is displayed - Is Required - YES - Click update");
		tempStr = tPP.getText(tPP.errMsgNameText2);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("Your form contains 1 item(s) in need of attention, see details below."));
	    
	    logger.log(LogStatus.PASS, "Error Message Your form contains 1 item(s) in need of attention, see details below. when updated with entering text box1 value: Successfully verified");
	}
	
	@Test (priority = 4)	
	public void validateIsRequiredNO_ErrorMsg1()throws Exception
	{		
		//Validate second error message
		logger = extent.startTest("TC-002:VerifyErrormessage1", "Verify Error is displayed - Is Required - NO - Click update");
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIR);
		tempStr = tPP.getText(tPP.errMsgNameIRText1);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("This field is required."));
	    logger.log(LogStatus.PASS, "This field is required. Error message successfully verified");
	}
	
//Validate Error Message "Your form contains 1 item(s) in need of attention, see details below." when updated with entering text box1 value
	
	@Test (priority = 5)	
	public void validateIsRequiredNO_ErrorMsg2()throws Exception
	{		
		//Validate first error message
		logger = extent.startTest("TC-003:VerifyErrormessage2", "Verify Error is displayed - Is Required - NO - Click update");
		tempStr = tPP.getText(tPP.errMsgNameText2);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("Your form contains 1 item(s) in need of attention, see details below."));
	    
	    logger.log(LogStatus.PASS, "Error Message Your form contains 1 item(s) in need of attention, see details below. when updated with entering text box1 value: Successfully verified");
	}
	
	@Test (priority = 6)	
	public void validateIsRequiredNEITHER_ErrorMsg1()throws Exception
	{		
		//Validate second error message
		logger = extent.startTest("TC-002:VerifyErrormessage1", "Verify Error is displayed - Is Required - NEITHER - Click update");
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtnIR);
		js.executeScript(tempStr);
		tempStr = tPP.getText(tPP.errMsgNameIRText1);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("This field is required."));
	    logger.log(LogStatus.PASS, "This field is required. Error message successfully verified");
	}
	
//Validate Error Message "Your form contains 1 item(s) in need of attention, see details below." when updated with entering text box1 value
	
	@Test (priority = 7)	
	public void validateIsRequiredNEITHER_ErrorMsg2()throws Exception
	{		
		//Validate first error message
		logger = extent.startTest("TC-003:VerifyErrormessage2", "Verify Error is displayed - Is Required - NEITHER - Click update");
		tempStr = tPP.getText(tPP.errMsgNameText2);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("Your form contains 1 item(s) in need of attention, see details below."));
	    
	    logger.log(LogStatus.PASS, "Error Message Your form contains 1 item(s) in need of attention, see details below. when updated with entering text box1 value: Successfully verified");
	}
	
	@Test (priority = 8)	
	public void validateAstrixVisibleIsRequiredNO()throws Exception
	{		
//Validate * is not displayed when NO radio button selected
		logger = extent.startTest("TC-004:VerifyAstrickSymbolforNO", "Verify * is not displyed - Is Required - NO");
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIR);
		js.executeScript(tempStr);	
		Thread.sleep(1000);
		flag = FunctionLibrary.isDisplayed(tPP.astrixVisibleIR);
  	    System.out.println("astrix......................."+ flag);
	    assertEquals(flag, false);
	    logger.log(LogStatus.PASS, "Astrick is not displayed when NO selected: successfully verified");

	}
	
	@Test (priority = 9)	
	public void validateAstrixVisibleIsRequiredNEITHER()throws Exception
	{		
//Validate * is not displayed when NO radio button selected
		logger = extent.startTest("TC-004:VerifyAstrickSymbolforNO", "Verify * is not displyed - Is Required - NEITHER");
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtnIR);
		js.executeScript(tempStr);	
		Thread.sleep(1000);
		flag = FunctionLibrary.isDisplayed(tPP.astrixVisibleIR);
  	    System.out.println("astrix......................."+ flag);
	    assertEquals(flag, false);
	    logger.log(LogStatus.PASS, "Astrick is not displayed when NEITHER selected: successfully verified");

	}
	
		
	//Validate '*' visible upon selection radio button - 'NO'
	@Test (priority = 10)	
	public void validateAstrixVisibleIsOptionalYES()throws Exception
	{		
		//Select Is Optional Radio Button - NO
		logger = extent.startTest("TC-001:Verify Astrick Icon", "Verify '*' is displayed - Is Optional - NO");
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIO);
		js.executeScript(tempStr);	
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIO);
	    js.executeScript(tempStr);
	    tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIO);
	    js.executeScript(tempStr);
	 		
		flag = FunctionLibrary.isDisplayed(tPP.astrixVisibleIO);
	    System.out.println("astrix......................."+ flag);
	    assertEquals(flag, true);
	    logger.log(LogStatus.PASS, "Astrick symbol for IsOptional NO successfully verified");
	}
	
	@Test (priority = 11)	
	public void validateIsOptionalNO_ErrorMsg1()throws Exception
	{		
		//Validate second error message
		logger = extent.startTest("TC-010:Verify Error message", "Verify Error is displayed - Is Optional - NO - Click update");
		tPP.textBoxIsOptional.clear();
		FunctionLibrary.enterText(tPP.textBoxIsRequired, "test");
		FunctionLibrary.click(tPP.updateBtn);
		tempStr = tPP.getText(tPP.errMsgNameIOText1);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("This field is required."));
	    logger.log(LogStatus.PASS, "Is Optional Textbox ErrorMsg successfully verified");
	}
	
	@Test (priority = 12)	
	public void validateIsOptionalNO_ErrorMsg2()throws Exception
	{		
		//Validate first error message
		logger = extent.startTest("TC-011:Verify Error message2", "Verify Error2 is displayed - Is Optional - NO - Click update");
		tempStr = tPP.getText(tPP.errMsgNameText2);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("Your form contains 1 item(s) in need of attention, see details below."));
	    
	    logger.log(LogStatus.PASS, "Is Optional Textbox ErrorMsg2 successfully verified");
	}
	
	@Test (priority = 13)	
	public void validateAstrixVisibleIsOptionalNEITHER()throws Exception
	{		
		//Select Is Optional Radio Button - NO
		logger = extent.startTest("TC-001:Verify Astrick Icon", "Verify '*' is displayed - Is Optional - NEITHER");
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtnIO);
		js.executeScript(tempStr);	
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIO);
	    js.executeScript(tempStr);
	    tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtnIO);
	    js.executeScript(tempStr);
	 		
		flag = FunctionLibrary.isDisplayed(tPP.astrixVisibleIO);
	    System.out.println("astrix......................."+ flag);
	    assertEquals(flag, true);
	    logger.log(LogStatus.PASS, "Astrick symbol for IsOptional NO successfully verified");
	}
	
	@Test (priority = 14)	
	public void validateIsOptionalNEITHER_ErrorMsg1()throws Exception
	{		
		//Validate second error message
		logger = extent.startTest("TC-010:Verify Error message", "Verify Error is displayed - Is Optional - NEITHER - Click update");
		Thread.sleep(3000);
		FunctionLibrary.click(tPP.updateBtn);
		tempStr = tPP.getText(tPP.errMsgNameIOText1);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("This field is required."));
	    logger.log(LogStatus.PASS, "Is Optional Textbox ErrorMsg successfully verified");
	}
	
	@Test (priority = 15)	
	public void validateIsOptionalNEITHER_ErrorMsg2()throws Exception
	{		
		//Validate first error message
		logger = extent.startTest("TC-011:Verify Error message2", "Verify Error2 is displayed - Is Optional - NEITHER - Click update");
		tempStr = tPP.getText(tPP.errMsgNameText2);
		String errMSG= (String) js.executeScript(tempStr);	
	    System.out.println("errMSG......................."+ errMSG);
	    assertTrue(errMSG.equals("Your form contains 1 item(s) in need of attention, see details below."));
	    
	    logger.log(LogStatus.PASS, "Is Optional Textbox ErrorMsg2 successfully verified");
	}
	
	@Test (priority = 16)	
	public void validateIsOptionalYES()throws Exception
	{		
		//Select Is Optional RadioButton - YES
		logger = extent.startTest("TC-012:Verify Astrick Symbol for YES", "Verify * is not displyed - Is Optional - YES");
		FunctionLibrary.enterText(tPP.textBoxIsOptional, "test");
		tPP.textBoxIsOptional.clear();
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIO);
		js.executeScript(tempStr);	
		Thread.sleep(1000);
		flag = FunctionLibrary.isDisplayed(tPP.astrixVisibleIO);
	    System.out.println("astrix......................."+ flag);
	    assertEquals(flag, false);
	    logger.log(LogStatus.PASS, "Astrick Symbol for YES RadioButton successfully verified");

	}
	
//Validate text box is visible for YES	
	@Test (priority = 17)	
	public void validateIsVisibleforYES()throws Exception
	{		
	//Select Is Visible RadioButton - YES
	logger = extent.startTest("TC-015:Verify IsVisible TextBox", "Verify the text box is visible - Is Visible - YES");
	tPP.textBoxIsRequired.clear();
	
	tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIV);
	js.executeScript(tempStr);
		 		
	flag = FunctionLibrary.isDisplayed(tPP.textBoxIsVisible);
    System.out.println("TextBoxVisible................"+ flag);
    assertEquals(flag, true);
    logger.log(LogStatus.PASS, "Is Visible with YES successfully verified");
}
	
	@Test (priority = 18)	
	public void validateIsVisibleNO()throws Exception
	{		
		//Select Is RequiredRadioButton - NO
		logger = extent.startTest("TC-016:VerifyIsVisibleTextBox", "Verify the text box is not visible - Is Visible - NO");
		 
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIV);
		js.executeScript(tempStr);	
		Thread.sleep(5000);
		flag = FunctionLibrary.isDisplayed(tPP.textBoxIsVisible);
  	    System.out.println("TextBoxVisible......................."+ flag);
	    assertEquals(flag, false);
	    logger.log(LogStatus.PASS, "Is Visible with NO successfully verified");

	}
	
	@Test (priority = 19)	
	public void validateIsVisibleNEITHER()throws Exception
	{		
		//Select Is RequiredRadioButton - NO
		logger = extent.startTest("TC-016:VerifyIsVisibleTextBox", "Verify the text box is not visible - Is Visible - NO");
		 
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtnIV);
		js.executeScript(tempStr);	
		Thread.sleep(5000);
		flag = FunctionLibrary.isDisplayed(tPP.textBoxIsVisible);
  	    System.out.println("TextBoxVisible......................."+ flag);
	    assertEquals(flag, false);
	    logger.log(LogStatus.PASS, "Is Visible with NO successfully verified");

	}

	@Test (priority = 20)	
	public void validateIsHiddenforYES()throws Exception
		{		
//Select Is Hidden RadioButton - YES
		logger = extent.startTest("TC-018:VerifyIsHiddenTextBox", "Verify the text box is not displayed - IsHidden- YES");

		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIH);
		js.executeScript(tempStr);
	 		
		flag = FunctionLibrary.isDisplayed(tPP.textBoxIsHidden);
		System.out.println("TextBoxVisible................"+ flag);
		assertEquals(flag, false);
		logger.log(LogStatus.PASS, "Is Hidden with YES successfully verified");
		}

	@Test (priority = 21)	
	public void validateIsHiddenAlertforYES()throws Exception
	{		
//Select Is Hidden Radio Button - NO
		logger = extent.startTest("TC-019:VerifyIsHiddenAlertMessage", "Verify Is Hidden Aleart Message");

		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIH);
		js.executeScript(tempStr);
		Thread.sleep(5000);
		FunctionLibrary.enterText(tPP.textBoxIsHidden, tPP.IsHiddenText);
		Thread.sleep(5000);
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIH);
		js.executeScript(tempStr);
	 		
		flag = FunctionLibrary.isDisplayed(tPP.hideAlert);
		System.out.println("TextBoxVisible................"+ flag);
		assertEquals(flag, true);
		logger.log(LogStatus.PASS, "Is Hidden with NO successfully verified");
		}
	
	
	@Test (priority = 22)	
	public void validatetextBoxvisibleIsHiddenNO()throws Exception
	{		
	//Select Is RequiredRadioButton - NO
		logger = extent.startTest("TC-020:VerifyIsHiddenTextBox", "Verify the text box is displayed - Is Hidden - NO");
	
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIH);
		js.executeScript(tempStr);	
	
		flag = FunctionLibrary.isDisplayed(tPP.textBoxIsHidden);
	    System.out.println("TextBoxVisible......................."+ flag);
	    assertEquals(flag, true);
	    logger.log(LogStatus.PASS, "Is Hidden with NO successfully verified");

}
	
	@Test (priority = 23)	
	public void validatetextBoxvisibleIsHiddenNEITHER()throws Exception
	{		
	//Select Is RequiredRadioButton - NO
		logger = extent.startTest("TC-020:VerifyIsHiddenTextBox", "Verify the text box is displayed - Is Hidden - NO");
	
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtnIH);
		js.executeScript(tempStr);	
	
		flag = FunctionLibrary.isDisplayed(tPP.textBoxIsHidden);
	    System.out.println("TextBoxVisible......................."+ flag);
	    assertEquals(flag, true);
	    tPP.textBoxIsHidden.clear();
	    logger.log(LogStatus.PASS, "Is Hidden with NO successfully verified");

}

	
	@Test (priority = 24)	
	public void validateIsReadonlyforYES()throws Exception
	{		
//Select Is Visible RadioButton - YES
		logger = extent.startTest("TC-018:VerifyIsReadonlyTextBox", "Verify the text box is disabled - Is Read only - YES");
		
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIRO);
		js.executeScript(tempStr);
		
		Thread.sleep(5000);
			       
		By str = By.xpath(tPP.textBoxIsReadonly_disabled);
	    flag = FunctionLibrary.elementExists(str);
	 		
		System.out.println("TextBoxVisible 21................"+ flag);
		assertEquals(flag, true);
		logger.log(LogStatus.PASS, "Is Readonly with YES successfully verified");
		}

	@Test (priority = 25)	
	public void validateIsReadonlyNO()throws Exception
	{		
	//Select Is RequiredRadioButton - NO
		logger = extent.startTest("TC-019:VerifyIsReadonlyTextBox", "Verify text box is enabled - Is Readonly - NO");
	 
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIRO);
		js.executeScript(tempStr);	
		Thread.sleep(5000);
		flag = FunctionLibrary.isDisplayed(tPP.textBoxIsReadonly_enabled);
		System.out.println("TextBoxVisible......................."+ flag);
		assertEquals(flag, true);
		logger.log(LogStatus.PASS, "Is Readonly with NO successfully verified");

	}
	
	@Test (priority = 26)	
	public void validateIsReadonlyNEITHER()throws Exception
	{		
	//Select Is RequiredRadioButton - NO
		logger = extent.startTest("TC-019:VerifyIsReadonlyTextBox", "Verify text box is enabled - Is Readonly - NO");
	 
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtnIRO);
		js.executeScript(tempStr);	
		Thread.sleep(5000);
		flag = FunctionLibrary.isDisplayed(tPP.textBoxIsReadonly_enabled);
		System.out.println("TextBoxVisible......................."+ flag);
		assertEquals(flag, true);
		logger.log(LogStatus.PASS, "Is Readonly with NO successfully verified");

	}


	@Test (priority = 27)	
	public void validateIsInvalidforYES()throws Exception
	{		
//Select Is Visible RadioButton - YES
		logger = extent.startTest("TC-018:VerifyIsInvalidErrorYES", "Verify error message - Is Invalid - YES");
		
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIN);
		js.executeScript(tempStr);
	 		
		flag =  tPP.textInvalidError.isDisplayed();

		assertEquals(flag, true);
		logger.log(LogStatus.PASS, "Is Invalid with YES successfully verified");
	}


	@Test (priority = 28)	
	public void validateIsSetToforYES()throws Exception
	{		
//Select Is Visible RadioButton - YES
		logger = extent.startTest("TC-018:VerifyIsSetToYES", "Verify Yes Is Selected text - Is SetTo - YES");
		
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIST);
		js.executeScript(tempStr);

		Thread.sleep(5000);

		String Expected_text = "Yes Is Selected";
		String str = "return $('input[id=\"Textbox81768\"]').val()";
		String Actual_text = (String) js.executeScript(str);
		
		Thread.sleep(5000);

		System.out.println(Expected_text); 		
		Assert.assertEquals(Actual_text,Expected_text);

		logger.log(LogStatus.PASS, "Is Set to Yes with YES successfully verified");
	}

	

	@Test (priority = 29)	
	public void validateIsSetToforNO()throws Exception
	{		
//Select Is Visible RadioButton - YES
		logger = extent.startTest("TC-018:VerifyIsSetToNO", "Verify No Is Selected - IsSetTo - NO");
		Thread.sleep(6000);
		
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIST);
		js.executeScript(tempStr);

		String Expected_text = "No is selected";
		String str = "return $('input[id=\"Textbox81768\"]').val()";
		String Actual_text = (String) js.executeScript(str);
	 		
		Assert.assertEquals(Actual_text,Expected_text);

		logger.log(LogStatus.PASS, "Is Set to NO with YES successfully verified");
	}
	
	@Test (priority = 30)	
	public void validateIsSetToforNEITHER()throws Exception
	{		
//Select Is Visible RadioButton - YES
		logger = extent.startTest("TC-018:VerifyIsSetToNO", "Verify No Is Selected - IsSetTo - NO");
		Thread.sleep(6000);
		
		tempStr = tPP.selectRadioButton("NEITHER" , tPP.radioBtnIST);
		js.executeScript(tempStr);

		String Expected_text = "No is selected";
		String str = "return $('input[id=\"Textbox81768\"]').val()";
		String Actual_text = (String) js.executeScript(str);
	 		
		Assert.assertEquals(Actual_text,Expected_text);

		logger.log(LogStatus.PASS, "Is Set to NO with YES successfully verified");
	}
	
	@Test (priority = 31) 
	public void validateIsRequiredNOUpdate()throws Exception
	{		
//Validate Is Required Update with No radio button
		logger = extent.startTest("TC-004:VerifyIsrequiredUpdateButton", "Verify valued is saved - Is Required - NO - Update");
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIR);
		js.executeScript(tempStr);
		tPP.textBoxIsOptional.clear();
		FunctionLibrary.enterText(tPP.textBoxIsOptional, "IR_NO");
		Thread.sleep(5000);
		FunctionLibrary.click(tPP.updateBtn);
		String expectedTitle = "Radio Button - Text Box";
		String actualTitle = tPP.radioButtoncheckboxPageTitle.getText();
		Assert.assertEquals(actualTitle, expectedTitle);	    
		tPP.textBoxSearch.sendKeys("IR_NO");
		Thread.sleep(3000);
		FunctionLibrary.waitForElement(tPP.deleteButton);
		tPP.deleteButton.click();
		tPP.deleteAlert.click();
		Thread.sleep(3000);
		FunctionLibrary.waitForElement(tPP.createNewButton);
	    tPP.createNewButton.click();
	    logger.log(LogStatus.PASS, "IsRequired Update Button with NO successfully verified");
	    
	}
	
	@Test (priority = 32) 
	public void validateIsOptionalUpdate()throws Exception
	{		
//Validate Is Optional Update with YES radio button
		logger = extent.startTest("TC-004:VerifyIsrequiredUpdateButton", "Verify valued is saved - Is Required - NO - Update");
		Thread.sleep(5000);
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIO);
		js.executeScript(tempStr);
		FunctionLibrary.enterText(tPP.textBoxIsOptional, "Automation_Is Required");
		FunctionLibrary.click(tPP.updateBtn);
		String expectedTitle = "Radio Button - Text Box";
		String actualTitle = tPP.radioButtoncheckboxPageTitle.getText();
		Assert.assertEquals(actualTitle, expectedTitle);	    
				
		logger.log(LogStatus.PASS, "Is Optional Update Button with YES successfully verified");
				
		tPP.textBoxSearch.sendKeys("Automation_Is Required");
		Thread.sleep(4000);
		FunctionLibrary.waitForElement(tPP.deleteButton);
		tPP.deleteButton.click();
				
		tPP.deleteAlert.click();
	    Thread.sleep(3000);
		FunctionLibrary.waitForElement(tPP.createNewButton);
		tPP.createNewButton.click();
			    
		Thread.sleep(5000);
	}
	
	@Test (priority = 33)	
	public void validateIsHiddenAlertTextYES()throws Exception
	{		
//Select Is Visible RadioButton - YES
		logger = extent.startTest("TC-019:VerifyIsHiddenAlertTextMessage", "Verify text box value is not displayed - Is Hidden - Yes");
		
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIH);
		js.executeScript(tempStr);
		Thread.sleep(5000);
		FunctionLibrary.enterText(tPP.textBoxIsHidden, tPP.IsHiddenText);
		Thread.sleep(5000);
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIH);
		js.executeScript(tempStr);
		tPP.textBoxIsOptional.clear();
		FunctionLibrary.enterText(tPP.textBoxIsOptional, "HideTest");
		FunctionLibrary.waitForElement(tPP.updateBtn);
		FunctionLibrary.click(tPP.updateBtn);
		Thread.sleep(5000);

		//flag = tPP.validateSearchTextBoxResult(tPP.IsHiddenTextSearchResult, tPP.IsHiddenText);	
		tPP.textBoxSearch.clear();
		tPP.textBoxSearch.sendKeys(tPP.IsHiddenText);
		Thread.sleep(5000);
		String str = tPP.IsHiddenText;
		By textValue1 = By.xpath(String.format(str, tPP.IsHiddenText));
	    flag = FunctionLibrary.elementExists(textValue1);
	    System.out.println("No such Element Exception"+flag);
		assertEquals(flag, false);
		logger.log(LogStatus.PASS, "Is Hidden Alert seach text with YES successfully verified");
		
		tPP.textBoxSearch.clear();
		tPP.textBoxSearch.sendKeys("HideTest");
		Thread.sleep(4000);
		FunctionLibrary.waitForElement(tPP.deleteButton);
		tPP.deleteButton.click();	
		tPP.deleteAlert.click();
		
		Thread.sleep(3000);
		FunctionLibrary.waitForElement(tPP.createNewButton);
		tPP.createNewButton.click();
		Thread.sleep(5000);
		
	}
	
	@Test (priority = 34) 
	public void validatePositiveUpdate()throws Exception
	{
		logger = extent.startTest("TC-009:VerifyIsrequiredYesRadioButton", "Verify valued is saved - Is Required - YES - Update");
		
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIR);
		js.executeScript(tempStr);
		FunctionLibrary.enterText(tPP.textBoxIsRequired, tPP.IsrequiredText);
		
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIO);
		js.executeScript(tempStr);
		FunctionLibrary.enterText(tPP.textBoxIsOptional, tPP.IsoptionalText);
		
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIV);
		js.executeScript(tempStr);
		FunctionLibrary.enterText(tPP.textBoxIsVisible, tPP.IsvisibleText);
		
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIH);
		js.executeScript(tempStr);
		FunctionLibrary.enterText(tPP.textBoxIsHidden, tPP.IsHiddenText);
		
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIRO);
		js.executeScript(tempStr);
		FunctionLibrary.enterText(tPP.textBoxIsReadonly_enabled, tPP.IsReadonlyText);
		
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIN);
		js.executeScript(tempStr);
		FunctionLibrary.enterText(tPP.textBoxIsInvalid, tPP.IsInvalidText);
		
		Thread.sleep(3000);
		
		FunctionLibrary.click(tPP.updateBtn);
		Thread.sleep(5000);
		
	}
	@Test (priority = 35) 
	public void validateIsRequiredYesRadioButton()throws Exception
	{		
//Validate Is Required Update with Yes radio button
		
		logger = extent.startTest("TC-009:VerifyIsrequiredYesRadioButton", "Verify valued is saved - Is Required - YES - Update");
						
		flag = tPP.validateSearchTextBoxResult(tPP.IsrequiredTextSearchResult, tPP.IsrequiredText);	
		Assert.assertTrue(flag);
		
		logger.log(LogStatus.PASS, "Is Required Update with YES: successfully verified");
		
		Thread.sleep(5000);
	}
	
	@Test (priority = 36) 
	public void validateIsOptionalNORadioButton()throws Exception
	{		
		//Validate Update with No radio button
		logger = extent.startTest("TC-014:Verify Isoptional NO RadioButton", "Verify value is saved - Is Optional - NO - Update");
		
		flag = tPP.validateSearchTextBoxResult(tPP.IsOptionalTextSearchResult, tPP.IsoptionalText);	
		Assert.assertTrue(flag);
		logger.log(LogStatus.PASS, "Is optional Update with NO: successfully verified");
		
		}
	@Test (priority = 37) 
	public void validateIsVisibleNORadioButton()throws Exception
	{		
		//Validate Update with No radio button
		logger = extent.startTest("TC-017:VerifyIsVisibleYESRadioButton", "Verify value is saved - Is Visible - YES - Update");
		
		flag = tPP.validateSearchTextBoxResult(tPP.IsVisibleTextSearchResult, tPP.IsvisibleText);	
		Assert.assertTrue(flag);
					
		logger.log(LogStatus.PASS, "Is Visible YES RadioButton successfully verified");
		}
	@Test (priority = 38) 
	public void validateIsHiddenNORadioButton()throws Exception
	{		
	//Validate Update with No radio button
		logger = extent.startTest("TC-021:VerifyIsHiddenNORadioButton", "Verify the value is saved - Is Hidden - NO");
	
		flag = tPP.validateSearchTextBoxResult(tPP.IsHiddenTextSearchResult, tPP.IsHiddenText);	
		Assert.assertTrue(flag);
			
		logger.log(LogStatus.PASS, "Is Hidden NO RadioButton successfully verified");
		}

	@Test (priority = 39) 
	public void validateIsReadonlyNOUpdate()throws Exception
	{		
	//Validate Update with No radio button
		logger = extent.startTest("TC-020:VerifyIsReadonlyNORadioButton", "Verify value is saved - Is Readonly-NO");
	
		flag = tPP.validateSearchTextBoxResult(tPP.IsReadOnlyTextSearchResult, tPP.IsReadonlyText);	
		Assert.assertTrue(flag);
	
		logger.log(LogStatus.PASS, "Is Readonly valued with NO successfully verified");
		}
	
	@Test (priority = 40) 
	public void validateIsInvalidNORadioButton()throws Exception
	{		
	//Validate Update with No radio button
		logger = extent.startTest("TC-020:VerifyIsInvalidNORadioButton", "Verify value is saved - Is Invalid-NO");
 		
		flag = tPP.validateSearchTextBoxResult(tPP.IsInvalidTextSearchResult, tPP.IsInvalidText);	
		Assert.assertTrue(flag);
	
		tPP.deleteButton.click();
	
		System.out.println("Delete alert:  "+tPP.deleteAlert.getText());
		tPP.deleteAlert.click();
	
		logger.log(LogStatus.PASS, "Is Invalid text with NO: successfully verified");
		Thread.sleep(3000);
		FunctionLibrary.waitForElement(tPP.createNewButton);
		tPP.createNewButton.click();
			    
		Thread.sleep(5000);
		}

	@Test (priority = 41)	
	public void validateIsSetToTextNo()throws Exception
	{		
	//Select Is RequiredRadioButton - NO
		logger = extent.startTest("TC-019:VerifyIsSetToYES", "Verify NO Is Selected value is saved - Is SetTo - NO");
	 
		tempStr = tPP.selectRadioButton("NO" , tPP.radioBtnIST);
		js.executeScript(tempStr);	
	
		tPP.textBoxIsOptional.clear();
		FunctionLibrary.enterText(tPP.textBoxIsOptional, "test");
	
		tPP.updateBtn.click();
	
		Thread.sleep(5000);
	
		flag = tPP.validateSearchTextBoxResult(tPP.IsSetToSearchResult,"No is selected");
		assertEquals(flag, true);
	
		FunctionLibrary.waitForElement(tPP.deleteButton);
	
		tPP.deleteButton.click();
	
		System.out.println("Delete alert:  "+tPP.deleteAlert.getText());
		tPP.deleteAlert.click();
	
		logger.log(LogStatus.PASS, "NO Is Selected is saved: successfully verified");
		Thread.sleep(3000);
		FunctionLibrary.waitForElement(tPP.createNewButton);
		tPP.createNewButton.click();
			    
		Thread.sleep(5000);

		}
@Test (priority = 42)	
	public void validateIsSetToText()throws Exception
	{		
	//Select Is RequiredRadioButton - NO
		logger = extent.startTest("TC-019:VerifyIsSetToYES", "Verify the value is saved - IsSetTo - YES");
	 
		tempStr = tPP.selectRadioButton("YES" , tPP.radioBtnIST);
		js.executeScript(tempStr);
	
		tPP.textBoxIsOptional.clear();
		FunctionLibrary.enterText(tPP.textBoxIsOptional, "test");
	
		tPP.updateBtn.click();
	
		Thread.sleep(5000);
	
		flag = tPP.validateSearchTextBoxResult(tPP.IsSetToSearchResult,"Yes Is Selected");
	
		assertEquals(flag, true);
	
		tPP.deleteButton.click();
	
		System.out.println("Delete alert:  "+tPP.deleteAlert.getText());
		tPP.deleteAlert.click();
		
		Thread.sleep(5000);
	
		FunctionLibrary.waitForElement(tPP.createNewButton);
		tPP.createNewButton.click();
		logger.log(LogStatus.PASS, "Yes Is Selected saved: successfully verified");

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
		
	public void closeBrowser() throws InterruptedException{
		
	FunctionLibrary.closeBrowser(tPP.logoutButton, tPP.ConfirmLogout);

	}
	
	}
	
