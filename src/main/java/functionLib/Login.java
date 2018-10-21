package functionLib;

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
    }
}