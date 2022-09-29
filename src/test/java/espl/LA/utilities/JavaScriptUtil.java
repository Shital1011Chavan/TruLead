package espl.LA.utilities;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	//Draw border and take ScreenShot

	public static void drawBorder(WebElement element,WebDriver driver) throws IOException
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
	
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	//Get the title of the page
	
	public static String gettitle(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		String title=js.executeScript("return document.title;").toString();
		return title;
		
	}

	//Click action
	
	public static void clickbyjs(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();",element);
		
	}
	
	//Refresh browser by js
	
	
	public static void refresh(WebDriver driver) 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
		
	}
		
	//Generate alert	
	public static void generatealert(WebDriver driver,String message) 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
		
	}	
		
	//Scroll down complete page
	public static void scrollDown(WebDriver driver) 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	
	//scroll down using pixel
	public static void scrolldownusingby(WebDriver driver) 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}	
	
	//Scroll till the element
	public static void scrolltillElement(WebElement element,WebDriver driver) 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	//Scroll up the page
	public static void scrollUp(WebDriver driver) 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}	
		
		
	//Zoom the page
	public static void Zoom(WebDriver driver) 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='50%'");
	}	
		
		

}
