package espl.LA.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import espl.LA.pageObjects.BaseClass;
import espl.LA.pageObjects.LoginPage;



public class LoginTest extends BaseClass {

	
	@Test(dataProvider="LoginData")
	public void loginApp(String username,String pass) 
	{
		logger=report.createTest("Login to Trulead....");
		LoginPage lpage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting the application");
	    Reporter.log("Start executing test..",true);

	    System.out.println("login test");
	//	excel.ExcelDataProvider("./TestData/TestData.xlsx");
	//	lpage.loginToApplication(excel.getStringData("Login",1,0),excel.getStringData("Login",1,1));
		
	    lpage.loginToApplication(username, pass); //by using data provider method.
	    
	    if(driver.getTitle().equals("TruleadWeb"))
	    {
	    	Assert.assertTrue(true);
	    	logger.pass("Login sucessfully done");
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
		
	}

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		excel1.ExcelDataProviderNew("./TestData/TestData.xlsx");
		int rownum= excel1.getRowCount("Login");
		int colcount= excel1.getCellCount("Login", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=excel1.getCellData("Login",i,j);//1,0
			}
		}
		
		return logindata;
	}
	
	
	
}
