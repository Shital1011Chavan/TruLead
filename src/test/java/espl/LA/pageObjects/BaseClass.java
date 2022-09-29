package espl.LA.pageObjects;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import espl.LA.utilities.BrowserFactory;
import espl.LA.utilities.ConfigDataProvider;
import espl.LA.utilities.ExcelDataProvider;
import espl.LA.utilities.ExcelDataProviderNew;
import espl.LA.utilities.Helper;
import espl.LA.utilities.JavaScriptUtil;


public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ExcelDataProviderNew excel1;
	public ConfigDataProvider config;
	
	//for extent report
	public ExtentHtmlReporter extent;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuit()
	{
		 Reporter.log("Seeting up reports and test is getting ready",true);
		 excel=new ExcelDataProvider();
		 excel1=new ExcelDataProviderNew();
		 config=new ConfigDataProvider();
		 
		 extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/TruLead"+Helper.getCurrentDateTime()+".html"));
		 extent.config().setTheme(Theme.DARK);
		 report= new ExtentReports();
		 report.attachReporter(extent);
		 
		 Reporter.log("Seeting done- test can be started..",true);

	}
	
	
	//@Parameters({"browser","url"})
	@BeforeClass
	public void setup()//String browser,String url
	{
		Reporter.log("Trying to start browser and getting application ready",true);

		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
	
		//	driver=BrowserFactory.startApplication(driver,browser,url);//parameter pasing through xml
		
		Reporter.log("browser and application up and running",true);

	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
	    Reporter.log("Test is about to end",true);

		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("TestCase failed is-"+result.getName());
			logger.fail("Exception is-"+result.getThrowable());
			
			
			String ScreenshotPath=Helper.captureScreenshot(driver,result.getName());
			
			logger.addScreenCaptureFromPath(ScreenshotPath);//adding screenshot to report.

			//logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			//capture the screenshot//adding screenshot to the report.
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed");//,MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test Skipped");

		}
		
		report.flush();
		
	    Reporter.log("Test completed >>>Reports Generated",true);

	}
	
	

/*	@AfterClass
	public 	void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}*/
	
	
	
	
	

}
