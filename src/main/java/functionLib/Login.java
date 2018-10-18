package functionLib;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
   public WebDriver driver;

    @FindBy(id = "UserName") WebElement UserNameLocator;  
    @FindBy(id = "Password") WebElement PasswordLocator;  
    @FindBy(xpath = "//button[@type='submit'][contains(.,'Login')]") WebElement LoginLocator; 
    @FindBy(xpath="//span[@class='walkme-action-destroy-1 wm-close-link']") WebElement WelcomeClose;
	@FindBy(xpath = "//span[text()='GR All Test - RB']") WebElement grAllTestRB;
    @FindBy(xpath = "//a[@role='tab'][contains(.,'Text Box and People Picker')]") WebElement TextBoxANDPeoplePicker;
	@FindBy(xpath = "//a[@id='btncreatenewitem163']") WebElement createNewButton;
 
  
	public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
   public void login(String un, String pw) throws InterruptedException{
	   
	    FunctionLibrary.enterText(UserNameLocator, un);
	    FunctionLibrary.enterText(PasswordLocator, pw);
	    FunctionLibrary.click(LoginLocator);  	
	    driver.manage().window().maximize();
	    Thread.sleep(30000);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", grAllTestRB);
	    FunctionLibrary.waitForElement(grAllTestRB);
	    grAllTestRB.click();
	    FunctionLibrary.waitForElement(TextBoxANDPeoplePicker);
	    TextBoxANDPeoplePicker.click();
	    System.out.println("after one minute");	
	    FunctionLibrary.waitForElement(createNewButton);
	    createNewButton.click(); 
	    Thread.sleep(30000);
	    System.out.println("Waiting..................one minute");
    }
}
