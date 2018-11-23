package functionLib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonUtility;

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
	
   public void login(String un, String pw) throws InterruptedException,IOException{	
	   
	   String autoIt_Path = CommonUtility.getProperty("AutoItPath");    	
   	   File autoitFile = new File(autoIt_Path);
   	   autoIt_Path  = autoitFile.getAbsolutePath().replace("\\.","");
   	   System.out.println("driverPath :"+autoIt_Path);	   
	   WebElement ele = driver.findElement(By.id("ContentPlaceHolder1_PassiveSignInButton"));	  
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", ele);
	   System.out.println("..........Autoit is waiting for 25 sceconds...........");
	   String cmd[]=new String[3];
	   cmd[0]=autoIt_Path;
	   cmd[1]=un;
	   cmd[2]=pw;
	   Runtime.getRuntime().exec(cmd);		   
	    driver.manage().window().maximize();
	    Thread.sleep(30000);	    
    }
}