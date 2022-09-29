package espl.LA.testCases;

import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;
import espl.LA.pageObjects.BaseClass;
import espl.LA.pageObjects.EmployeeBulkUploadPage;
import espl.LA.pageObjects.LoginPage;

public class EmployeeBulkUploadTest extends BaseClass{

		@Test
		public void EmployeeBulkUpload() throws AWTException, InterruptedException 
		
		{
			
			logger=report.createTest("Login to trulead");
			LoginPage lpage=PageFactory.initElements(driver, LoginPage.class);
			
			logger.info("Starting the application");
		    Reporter.log("Start executing Login test",true);
		
		   	excel.ExcelDataProvider("./TestData/TestData.xlsx");
			lpage.loginToApplication(excel.getStringData("Login",1,0),excel.getStringData("Login",1,1));
			
		    Reporter.log("End Login test..",true);
	
		 //----------------------------------------------------------------------------------------------------
     
		     logger=report.createTest("Employee Bulk upload Test");
		     EmployeeBulkUploadPage empbulk=PageFactory.initElements(driver, EmployeeBulkUploadPage.class);
	
	
		     empbulk.UploadEmployees();
		}	
	
}
