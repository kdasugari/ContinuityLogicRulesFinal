package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import functionLib.FunctionLibrary;

public class RadioButtonAndPeoplePickerPage {
	public WebDriver driver;
	Boolean flag;
	
	@FindBy(xpath = "//span[text()='GR All Test - RB']") WebElement grAllTestRB;
    @FindBy(xpath = "//a[@role='tab'][contains(.,'Text Box and People Picker')]") WebElement TextBoxANDPeoplePicker;
	public @FindBy(xpath = "//a[@id='btncreatenewitem174']") WebElement createNewButton;
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Update')])[2]") WebElement updateEle;
	@FindBy(xpath = "//a[text()='Text Box and People Picker']") WebElement textBoxPicker;
	@FindBy(xpath = "//div[@class='jarviswidget scroller-anchor']//..//h2[@title=' Radio Button - Text Box']") WebElement radioButtonPage;
	public @FindBy(xpath = "//input[@data-lookupfieldid='2432']") WebElement textBoxIsRequired;
	public @FindBy(xpath = "//input[@data-lookupfieldid='2433']") WebElement textBoxIsOptional;
	public @FindBy(xpath = "//input[@data-lookupfieldid='2434']") WebElement textBoxIsVisible;
	public @FindBy(xpath = "//input[@data-lookupfieldid='2435']") WebElement textBoxIsHidden;
	//public @FindBy(xpath = "//input[@id='Textbox51756' and @disabled='disabled']") WebElement textBoxIsReadonly_disabled;
	public @FindBy(xpath = "//input[@data-lookupfieldid='2436']") WebElement textBoxIsReadonly_enabled;
	public @FindBy(xpath = "//input[@data-lookupfieldid='2437']") WebElement textBoxIsInvalid;
	public @FindBy(xpath = "//input[@data-lookupfieldid='2438']") WebElement textBoxIsSetTo;
	public @FindBy(xpath = "//span[@id='ui-id-33']") WebElement PeoplePicker1Title;
	public @FindBy(xpath = "//input[@placeholder='Search User Id']") WebElement PeoplePickerSearch;
	public @FindBy(xpath = "//table[@id='lookupfieldformSelectorGrid7800']/tbody/tr") WebElement PeoplePickerSelect;
	public @FindBy(xpath = "//button[contains(text(),'OK')]") WebElement OKButton;
	public @FindBy(xpath = "//button[contains(text(),'Cancel')]") WebElement CancelButton;
	public @FindBy(xpath = "//button[@id='menuBuilderDelete']") WebElement deleteAlert;
	public @FindBy(xpath = "//div[@id='hiddenDataLossAlerterRadioButton41752']") WebElement hideAlert;
	public @FindBy(xpath = "//div[@id='hiddenInvalidAlerterRadioButton71764']") WebElement textInvalidError;
	public @FindBy(xpath = "//span[contains(text(), 'Text box 1')]/../../../../tbody//td/div[contains(text(), '%s')]") WebElement isRequiredTextSearchResult;
	public @FindBy(xpath = "//h2[contains(text(),'Text Box')]/..//button[@class='btn btn-primary updateButton']") WebElement updateBtn;
   	public @FindBy(xpath = "//h2[contains(text(), 'Radio Button - Text Box')]") WebElement radioButtoncheckboxPageTitle;
   	public @FindBy(xpath = "//label[(text()='People Picker 1')]//../span") WebElement astrixVisibleIR;
   	public @FindBy(xpath = "//label[(text()='People Picker 2')]//../span") WebElement astrixVisibleIO;
   	public @FindBy(xpath = "//div[@id='formadminGridDataTable1632582_filter']//input[@class='form-control input-sm']") WebElement textBoxSearch;
   	public @FindBy(xpath = "//table[@id='formadminGridDataTable1632582']/tbody/tr/td[2]/nav/nobr/button[2]") WebElement deleteButton;
   	public @FindBy(xpath = "//table[@id='formadminGridDataTable1632582']/tbody/tr/td[2]/nav/nobr/span/a") WebElement editButton;
   	public @FindBy(xpath = "//div[@class='textoFull']/p") WebElement invalidAlert;
   	public @FindBy(xpath = "//a[@title='Logout']") WebElement logoutButton;
   	public String Actual_text = "Textbox81768";
	//public String updateBtn 		= "$(\"button[class='btn btn-primary updateButton']\")[1].click()";
   	public String backBtn   		= "document.getElementsByClassName('btn btn-default')[16].click()";
	public String radioBtnIR 		= "RadioButton12090";
	public String radioBtnIO		= "RadioButton22093";
	public String radioBtnIV		= "RadioButton32095";
	public String radioBtnIH		= "RadioButton42097";
	public String radioBtnIRO		= "RadioButton52099";
	public String radioBtnIN		= "RadioButton62101";
	public String radioBtnIST		= "RadioButton72105";
	public String errMsgNameIRText1	= "PeoplePicker12432-error";
	public String errMsgNameText2 	= "fllErrorSummaryContainer17424";
	public String errMsgNameIOText1	= "PeoplePicker22433-error";
	public String textBoxIsReadonly_disabled = "//input[@id='Textbox51756' and @disabled='disabled']";
	
	
	public String IsrequiredText 	= "IsRequiredText_"+(new SimpleDateFormat("MMddhhmmss").format(new Date()));
	public String IsoptionalText 	= "IsOptionalText_"+(new SimpleDateFormat("MMddhhmmss").format(new Date()));
	public String IsvisibleText 	= "IsVisibleText_"+(new SimpleDateFormat("MMddhhmmss").format(new Date()));
	public String IsHiddenText 		= "IsHiddenText_"+(new SimpleDateFormat("MMddhhmmss").format(new Date()));
	public String IsReadonlyText 	= "IsReadonlyText_"+(new SimpleDateFormat("MMddhhmmss").format(new Date()));
	public String IsInvalidText 	= "IsInvalidText_"+(new SimpleDateFormat("MMddhhmmss").format(new Date()));
	public String IsSettoText 		= "Yes Is Selected_"+(new SimpleDateFormat("MMddhhmmss").format(new Date()));
	public String IsrequiredTextSearchResult = "//span[contains(text(), 'Text box 1')]/../../../../tbody//td/div[contains(text(), '%s')]";
	public String IsOptionalTextSearchResult = "//span[contains(text(), 'Text box 2')]/../../../../tbody//td/div[contains(text(), '%s')]";
	public String IsVisibleTextSearchResult = "//span[contains(text(), 'Text box 3')]/../../../../tbody//td/div[contains(text(), '%s')]";
	public String IsHiddenTextSearchResult = "//span[contains(text(), 'Text box 4')]/../../../../tbody//td/div[contains(text(), '%s')]";
	public String IsReadOnlyTextSearchResult = "//span[contains(text(), 'Text box 5')]/../../../../tbody//td/div[contains(text(), '%s')]";
	public String IsInvalidTextSearchResult = "//span[contains(text(), 'Text box 7')]/../../../../tbody//td/div[contains(text(), '%s')]";
	public String IsSetToSearchResult = "//span[contains(text(), 'Text box 8')]/../../../../tbody//td/div[contains(text(), '%s')]";
//label[text() = 'Text box 5']//..//span[@style='display: none;'] -- check for * not required
//$x("//label[text() = 'Text box 1']//..//span[@style='display: none;']").length - 0/1
//label[text() = 'Text box 1']//..//span -- Get * for required 

public RadioButtonAndPeoplePickerPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}


public void navigateToTextBoxAndPeoplePickerPage() throws InterruptedException{
	Thread.sleep(15000);
    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView();", grAllTestRB);
    FunctionLibrary.waitForElement(grAllTestRB);
    grAllTestRB.click();
    FunctionLibrary.waitForElement(TextBoxANDPeoplePicker);
    TextBoxANDPeoplePicker.click();
    System.out.println("after one minute");	
    FunctionLibrary.waitForElement(createNewButton);
    createNewButton.click(); 
    Thread.sleep(10000);
    }

public String selectRadioButton(String radioSel, String name){
	return "$(\"input[value='" + radioSel + "'][name='" + name + "']\").mouseover().click();";
}

public String getText(String name){
	return "return $('#" + name + "').text()";
}

public String asterixVisible(){
//	return "return $x(\"//label[text() = '" + textBoxName + "']//..//span[@style='display: none;']\").length;";
	return "return $(\"span[style='display: inline;']\").text()";
}

public Boolean validateSearchTextBoxResult(String SearchResult, String TextBoxValue) throws InterruptedException{
	textBoxSearch.clear();
	textBoxSearch.sendKeys(TextBoxValue);
	Thread.sleep(4000);

	WebElement textValue = driver.findElement(By.xpath(String.format(SearchResult, TextBoxValue)));
	Thread.sleep(5000);
	flag = FunctionLibrary.isDisplayed(textValue);
	
	return flag;
}


}