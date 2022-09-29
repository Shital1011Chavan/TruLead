package espl.LA.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import espl.LA.pageObjects.AssessmentMenu;
import espl.LA.pageObjects.AssessmentPage;
import espl.LA.pageObjects.BaseClass;
import espl.LA.pageObjects.DatePage;
import espl.LA.pageObjects.LoginPage;
import espl.LA.pageObjects.Setup360ActivityPage;
import espl.LA.pageObjects.BulkUpload360feedbackQuestionsPage;
import espl.LA.pageObjects.ConfigureAssessmentActivityPage;

public class Activity_360degreeTest extends BaseClass {

	
	@Test()
	public void Activity360Test() throws IOException, InterruptedException, AWTException 
	{

		logger=report.createTest("Login to trulead");
		LoginPage lpage=PageFactory.initElements(driver, LoginPage.class);
	
		logger.info("Starting the application");
	    Reporter.log("Start executing Login test",true);

	   	excel.ExcelDataProvider("./TestData/TestData.xlsx");
		lpage.loginToApplication(excel.getStringData("Login",1,0),excel.getStringData("Login",1,1));
		
    
	    if(driver.getTitle().equals("TruleadWeb"))
	    {
	    	Assert.assertTrue(true);
	    	logger.pass("Login sucessfully done");
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	    
	    Reporter.log("End Login test..",true);
//-------------------------------------------------------------------------------------------------------------------
	
		logger=report.createTest("clicking on Setup ");

		AssessmentMenu lrpage=PageFactory.initElements(driver, AssessmentMenu.class);
	
	    Reporter.log("Start clicking on setup ",true);
	    
	    lrpage.SetupLA();
	    
	    if(lrpage.title().equals("Assessment"))
	    {
	    	Assert.assertTrue(true);
	    	logger.pass("clicking on Setup sucessfully done");
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	   
	    Reporter.log("clicking on setup sucessfully done ",true);

//-----------------------------Assessment Page-------------------------------------------------------
	  
	   logger=report.createTest("Creating new Learning assessment");
	  
	   AssessmentPage LearningA =PageFactory.initElements(driver, AssessmentPage.class);
	   logger.info("start creating new learning assessment");
	   Reporter.log("start creating new learning assessment  ",true);
	  
	   Reporter.log("Clicking on + icon ",true);
	   
	   LearningA.ClickPlus();
	   
	   Reporter.log("Entering title of the assessment",true);
	 
	   LearningA.LATitle(config.getAssTitle());
   
	   Reporter.log("selecting start date of the assessment",true);

	   excel1.ExcelDataProviderNew("./TestData/TestData.xlsx");
	  
	   DatePage date =PageFactory.initElements(driver, DatePage.class);
	   
	   date.SelectStartDate(excel1.getCellData("Dates",1, 1),excel1.getCellData("Dates",2,1),excel1.getCellData("Dates",3,1));
	  
	   Reporter.log("selecting End date of the assessment",true);

	   excel1.ExcelDataProviderNew("./TestData/TestData.xlsx");
	  
	   date.SelectEndDate(excel1.getCellData("Dates",1, 3),excel1.getCellData("Dates",2,3),excel1.getCellData("Dates",3,3));
	   
	   Reporter.log("selecting No. of activity of the assessment",true);

	   LearningA.selectNoOfActivity();
	   
	 //  Reporter.log("Clicking on autoenroll",true);

	//   LearningA.autoenroll();
	    
	   Reporter.log("Clicking on proceed to activities button",true);

	   LearningA.ProceedToActivities();
		
	   Reporter.log("End of assessment page",true);
	   logger.info("End of assessment page");

//-----------------------------Configuring 360 Degree Activity------------------------------------------------------
	   
	    logger=report.createTest("Configuring 360 degree activity");
	
	    ConfigureAssessmentActivityPage act1 =PageFactory.initElements(driver, ConfigureAssessmentActivityPage.class);
	   
		Reporter.log("Start Configuring 360 Degree activity",true);
		 

		Reporter.log("Clicking on Activity dropdown",true);
		act1.ActivityDrop();
		
		Reporter.log("Selecting ativity",true);
		act1.SelectActivity(config.get360Act());
		
		Reporter.log("Clicking on save button",true);
		act1.savebutton();
		
		Reporter.log("Clicking on Gear Wheel Icon",true);
		act1.ClickingOnGearWheel();
		
//-----------------------------Setup 360 Degree Activity------------------------------------------------------
		
		 logger=report.createTest("Setup 360 degree activity");
		 
		 Setup360ActivityPage setupact =PageFactory.initElements(driver, Setup360ActivityPage.class);

		 Reporter.log("Entering 360 Activity Title",true);
		 setupact.Act360Title();
		
		 Reporter.log("Selecting competencies",true);
		 setupact.selectcompetancy();
	
		 Reporter.log("Selecting start date",true);
		 date.SelectStartDate(excel1.getCellData("Dates",8, 1),excel1.getCellData("Dates",9,1),excel1.getCellData("Dates",10,1));
		
		 Reporter.log("Selecting end date",true);
		 date.SelectEndDate(excel1.getCellData("Dates",8, 3),excel1.getCellData("Dates",9,3),excel1.getCellData("Dates",10,3));
	
		 Reporter.log("Selecting question per page",true);
		 setupact.Questionperpage();
		
		// Reporter.log("Self and stakeholder radio button",true);
		// setupact.Selfandstakeradio();
		
		 Reporter.log("Selecting feedback Roles",true);
		 setupact.SelectfeedbackRoles();
		 
	     Reporter.log("Clicking on Save",true);
		 setupact.ClickonSave();
		
		 Reporter.log("Setup 360 degree Activity Done",true);
		 
//----------------------------------Setup 360 degree activity questions------------------------------------		 
		 
		 logger=report.createTest("Setup 360 degree activity bulk upload questions");
		 
		 BulkUpload360feedbackQuestionsPage setupfeedbackQ =PageFactory.initElements(driver, BulkUpload360feedbackQuestionsPage.class);

		 Reporter.log("bulk upload 360 degree Activity questions",true);
		 setupfeedbackQ.uploadquestions();
		 
		 Reporter.log("bulk upload 360 degree Activity questions sucessfully done",true);

		 Reporter.log("Assessment with 360 degree activity sucessfully created",true);

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}
}
