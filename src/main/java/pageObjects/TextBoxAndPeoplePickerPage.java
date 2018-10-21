package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import functionLib.FunctionLibrary;

public class TextBoxAndPeoplePickerPage {
	public WebDriver driver;
	@FindBy(xpath = "//span[text()='GR All Test - RB']")
	WebElement grAllTestRB;
    @FindBy(xpath = "//a[@role='tab'][contains(.,'Text Box and People Picker')]")
	WebElement TextBoxANDPeoplePicker;
	@FindBy(xpath = "//a[@id='btncreatenewitem163']")
	WebElement createNewButton;
	@FindBy(xpath = "(//input[contains(@value,'NO')])[1]") WebElement noRadiobuttonLocator;
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Update')])[2]") WebElement updateEle;
	//@FindBy(xpath = "(//span[@class='required'][contains(.,'*')])[14]") WebElement astricEle;
	//	String  astricxpath = "(//span[@class='required'][contains(.,'*')])[14]";
	@FindBy(xpath = "(//input[contains(@value,'NEITHER')])[1]") WebElement neitherRadiobuttonLocator;
	//	@FindBy(xpath = "//label[text()='Radio Button 1']//..//input[@value='YES']") WebElement yesRadiobuttonLocator;
	@FindBy(xpath = "//a[text()='Text Box and People Picker']") WebElement textBoxPicker;
	//@FindBy(xpath = "//a[@role='tab'][contains(.,'Text Box and People Picker')]")
	//@FindBy(xpath = "//a[@role='tab'][contains(.,'GR All Test - RB')]")
	//span[@class='aciTreeText'][contains(.,'GR All Test - RB')]
	//@FindBy(xpath = "//span[@class='aciTreeText'][contains(.,'GR All Test - RB')]")
	@FindBy(xpath = "//*[@id='formentrycontainer163_ENTITY_0']//following-sibling::button[@class='btn btn-primary updateButton']") WebElement updateButton;
	//	@FindBy(xpath = "//label[text()='Radio Button 1']//..//input[@value='YES']") WebElement yesRadiobuttonLocator;
	@FindBy(xpath = "(//label[text()='Radio Button 1']//..//input[@value='YES']//..//..)[1]") WebElement yesRadiobuttonLocator;
	@FindBy(xpath = "//div[@class='jarviswidget scroller-anchor']//..//h2[@title=' Radio Button - Text Box']") WebElement radioButtonPage;

	public String backBtn   		= "document.getElementsByClassName('btn btn-default')[16].click()";
	public String updateBtn 		= "$(\"button[class='btn btn-primary updateButton']\")[1].click()";
	public String radioBtn 			= "RadioButton11743";
	public String errMsgNameText1	= "Textbox11744-error";
	public String textBox1 			= "Text box 1";
	

//label[text() = 'Text box 5']//..//span[@style='display: none;'] -- check for * not required
//$x("//label[text() = 'Text box 1']//..//span[@style='display: none;']").length - 0/1
//label[text() = 'Text box 1']//..//span -- Get * for required 

public TextBoxAndPeoplePickerPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}


public void navigateToTextBoxAndPeoplePickerPage() throws InterruptedException{
    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView();", grAllTestRB);
    FunctionLibrary.waitForElement(grAllTestRB);
    grAllTestRB.click();
    FunctionLibrary.waitForElement(TextBoxANDPeoplePicker);
    TextBoxANDPeoplePicker.click();
    System.out.println("after one minute");	
    FunctionLibrary.waitForElement(createNewButton);
    createNewButton.click(); 
    Thread.sleep(20000);
    System.out.println("Waiting..................one minute");
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

}