package functionLib;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonUtility;

public class FunctionLibrary {
	public static WebDriver driver;

    public static WebDriver launchBrowser() throws IOException {
        String baseUrl = CommonUtility.getProperty("url");
        System.out.println("launching Chrome browser");
    	String driverPath = CommonUtility.getProperty("ChromeDriverPath");
    	System.out.println("URL....."+baseUrl);
//    	String path = System.getProperty("user.dir");   
//    	E:\Project\Git\ContinuityLogicRulesFinal
//    	String driverPath = path + "\\driverfolder\\chromedriver.exe"; 
    	System.setProperty("webdriver.chrome.driver", driverPath);
    	
    	driver = new ChromeDriver();
    	//driver = new FirefoxDriver(); 
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
    	return driver;
    }
    
	public static String getTitle() {
        String actualTitle = driver.getTitle();
	    return actualTitle;
    }
    
    public static void enterText(WebElement obj, String val){
    	obj.sendKeys(val);
    }
    
    public static void click(WebElement obj){
    	obj.click();
    }
    
    public static Boolean isDisplayed(WebElement obj){
    	try{
    		return obj.isDisplayed();
    	}catch(Exception e) {
            return false;
        }
    }
    
    public static void draganDrop(WebElement From, WebElement To){
        Actions act=new Actions(driver);					
        act.dragAndDrop(From, To).build().perform();
    }
    
    
    public static void waitForElement(WebElement obj){
 		WebDriverWait wait = new WebDriverWait(driver, 200);
 		wait.until(ExpectedConditions.visibilityOf(obj));
    }
    
    public static boolean elementExists(By locator)
    {
        return !driver.findElements(locator).isEmpty();
    }
      	
        
   	public static void closeBrowser(){
	driver.quit();
	}
   	 public void explicitWait(int time)
   	 {
   		 try
   		 {
   		   wait(time);
   		 }catch(InterruptedException e)
   		 {
   			 
   		 }
   	 }
    public static String getFormattedDate(){
        Calendar cal=Calendar.getInstance();
        cal.setTime(new Date());
        int day=cal.get(Calendar.DATE);
        if(!((day>10) && (day<19))) {
            switch (day % 10) {
                case 1:  
                    return new SimpleDateFormat("EEEE, MMMM d'st', yyyy h").format(cal.getTime());
                case 2:  
                    return new SimpleDateFormat("EEEE, MMMM d'nd', yyyy h").format(cal.getTime());
                case 3:  
                    return new SimpleDateFormat("EEEE, MMMM d'rd', yyyy h").format(cal.getTime());
                default: 
                    return new SimpleDateFormat("EEEE, MMMM d'th', yyyy h").format(cal.getTime());
            }
        }
        			return new SimpleDateFormat("EEEE, MMMM d'th', yyyy h").format(cal.getTime());
    }

}
