package espl.LA.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

	//ScreenShot,alerts,frames,windows,Sync issue,javascript executor
	
	public static String captureScreenshot(WebDriver driver,String TestcaseName)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/TruLead_"+TestcaseName+getCurrentDateTime()+".png";
		try
		{
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured.........");
		} 
		catch (IOException e) 
		{
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		return screenshotPath;
	}
	
	
	public static String getCurrentDateTime()
	{
	 DateFormat customformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	 
	 Date currentDate=new Date();
	 return customformat.format(currentDate);
	}
	
/*	public static void selectChoicevalues(Webdriver driver,String... value)
	{
		
		
	}*/
	
	public static boolean isAlertPresent(WebDriver driver)//user defined method to check alert is present or not.
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	//if(isAlertPresent()==true)//{driver.switchTo().alert().accept;//this will close the alert}
	
	
	public static String AlertHandle(WebDriver driver)
	{
		Alert alert= driver.switchTo().alert();
		
		String errormessage=alert.getText();
		
		return errormessage;
		
	}
	
	
	//Explicit wait:
	//1. no explicit keyword or method
	//2. Available with WebDriver wait with some Expected conditions.
	//3. specific to element.
	//4. dynamic in nature.
	//5. we should never use implicit and explicit wait together.
	
	public static void mysendKeys(WebDriver driver, WebElement element, int timeout, String value)
	{
		new WebDriverWait(driver,timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout)
	
	{
		new WebDriverWait(driver,timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
