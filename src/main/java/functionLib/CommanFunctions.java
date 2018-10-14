package functionLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommanFunctions {
	public WebDriver driver;
	
	public CommanFunctions(WebDriver driver)
	{
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	}
	public boolean isRequired(WebElement obj,By locator, String expMessage)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;	
	    js.executeScript("arguments[0].click();", obj);
		if(!"".equals(expMessage))
		{
		
			return false;
		}else
		return FunctionLibrary.elementExists(locator);
		
	}
	
	
	
}
