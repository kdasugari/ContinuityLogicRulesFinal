package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import functionLib.FunctionLibrary;

public class CheckBoxandRadioButton {
	public WebDriver driver;
	@FindBy(xpath = "//span[text()='GR All Test - RB']")	WebElement grAllTestRB;	
	@FindBy(xpath = "//a[@id='btncreatenewitem169']") 	WebElement createNewButton;	
	@FindBy(xpath = "//a[@role='tab'][contains(.,'Check Box ad Dropdown')]") WebElement CheckBoxAndDropdown;
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Update')])[2]") WebElement update;
	
	
	public String radioBtn1 			= "RadioButton11925";	
	//radiobutton2
	public String radioBtn2 			= "RadioButton21928";
	public String radioBtn3 			= "RadioButton31931";
	public String radioBtn4			= "RadioButton31932";
	public String radioBtn5			="RadioButton51937";
	public String  radioBtn_Hidden = "RadioButton41934";
	public String  radioBtn_Hidden1 = "CheckboxList41935";
	public String  radioBtn_Invalid="RadioButton71943";
	public String  errorMessageRadioButton1 = "fllErrorSummaryContainer1690";
	public String errorMessageRadioButton1_checkBox = "CheckboxList11926-error";	
	public String errorMessageRadioButton2_checkBox = "CheckboxList21929-error";
	public String errorMessageRadioButton4_Hidden = "hiddenDataLossAlerterRadioButton41934";
	public String errorMessageRadioButton4_Invalid = "hiddenInvalidAlerterRadioButton71943";
	public String radioButton4_check ="CheckboxList41935";
	@FindBy(xpath = "(//span[contains(.,'*')])[14]") WebElement star1;
	@FindBy(xpath = "(//span[@class='required'][contains(.,'*')])[16]") WebElement star2;

	@FindBy(xpath = "//label[contains(.,'Checkbox List 4')]") WebElement checkboxList4;
	@FindBy(xpath = "//label[contains(.,'Checkbox List 3')]") WebElement checkboxList3;
	public CheckBoxandRadioButton(WebDriver driver){
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}

	
	public void navigateToCheckBoxAndDropdownPage() throws InterruptedException{
	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView();", grAllTestRB);
	    FunctionLibrary.waitForElement(grAllTestRB);
	    grAllTestRB.click();
	    FunctionLibrary.waitForElement(CheckBoxAndDropdown);
	    CheckBoxAndDropdown.click();
	    System.out.println("after one minute");	
	    FunctionLibrary.waitForElement(createNewButton);
	    createNewButton.click(); 
	    Thread.sleep(20000);
	    System.out.println("Waiting..................one minute");
	}
	
	public String getText()
	{
		System.out.println(star1.getText());
		return star1.getText();
		
		
		
	}
	
	public String getStar2Text()
	{
		System.out.println(star2.getText());
		return star1.getText();
		
	}
	
	public String getcheckText()
	{
		System.out.println(checkboxList3.getText());
		return checkboxList3.getText();
		
	}
	
	public String getcheckText4()
	{
		System.out.println(checkboxList4.getText());
		return checkboxList4.getText();
		
	}
	
	public void getErrorMessage()
	{
		update.click();
		//System.out.println(error.getText());
		
	}
	
	public String getAttributs()
	{
		return driver.findElement(By.xpath("//input[@name='CheckboxList51938']")).getAttribute("disabled");
	}
	
	
	public boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
}
