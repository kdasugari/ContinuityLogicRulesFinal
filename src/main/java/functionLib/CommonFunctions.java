package functionLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonFunctions {
	public WebDriver driver;
	
	public CommonFunctions(WebDriver driver)
	{
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	}
//	public static boolean isRequired(WebElement obj,By locator, String expMessage)
//	{
//		JavascriptExecutor js = (JavascriptExecutor)driver;	
//	    js.executeScript("arguments[0].click();", obj);
//		if(!"".equals(expMessage))
//		{		
//			return false;
//		}else
//		return FunctionLibrary.elementExists(locator);		
//	}
	
	
}


