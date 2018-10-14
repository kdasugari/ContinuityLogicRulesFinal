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
    @FindBy(xpath = "//span[@class='aciTreeText'][contains(.,'GR All Test - RB')]") WebElement GRAllTestMenu;
    @FindBy(xpath = "//a[@role='tab'][contains(.,'Text Box and People Picker')]") WebElement TextBoxANDPeoplePicker;
    @FindBy(xpath = "//a[contains(@id,'btncreatenewitem163')]") WebElement createItem;
 
  
	public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
   public void login(String un, String pw){
	   
	    FunctionLibrary.enterText(UserNameLocator, un);
	    FunctionLibrary.enterText(PasswordLocator, pw);
	    FunctionLibrary.click(LoginLocator);  	
	    driver.manage().window().maximize();
	    FunctionLibrary.waitForElement(GRAllTestMenu);
	    GRAllTestMenu.click();
	    FunctionLibrary.waitForElement(TextBoxANDPeoplePicker);
	    TextBoxANDPeoplePicker.click();
	   // FunctionLibrary factory =new FunctionLibrary();
	    //factory.explicitWait(3600000);
	    System.out.println("after one minute");	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;	
	    js.executeScript("arguments[0].click();", createItem);
	  
    }
}
