package espl.LA.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

public static WebDriver startApplication(WebDriver driver,String browserName,String appURL)
{
	if(browserName.equals("Chrome"))
		{
			//System.setProperty("webdriver.chrome.driver","./NewDrivers/chromedriver.exe");
		     
		     WebDriverManager.chromedriver().setup();

			 driver= new ChromeDriver();//Invoke the browser
		
		}else
	
		
		{
			System.out.println("We do not support this browser");
		}
	
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(appURL);
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//implicitly wait-- is always applied globally-- is available for all the web elements for which driver is interacting.
	// it can be change anywhere and at any time in your code.
	return driver;
	
	
}

public static void quitBrowser(WebDriver driver)
{
	driver.quit();
}
}
