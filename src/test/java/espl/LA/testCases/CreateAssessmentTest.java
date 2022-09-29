package espl.LA.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import espl.LA.pageObjects.BaseClass;
import espl.LA.pageObjects.SetupActivityPage;
import espl.LA.pageObjects.ConfigureAssessmentActivityPage;
import espl.LA.pageObjects.DatePage;
import espl.LA.pageObjects.AssessmentPage;
import espl.LA.pageObjects.AssessmentMenu;
import espl.LA.pageObjects.LoginPage;
import espl.LA.pageObjects.SetupActivityQ;

public class CreateAssessmentTest extends BaseClass{
	

	@Test()
	public void LearningAssessmentTest() throws InterruptedException, IOException 
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
	   
	   Reporter.log("Clicking on autoenroll",true);

	   LearningA.autoenroll();
	    
	   Reporter.log("Clicking on proceed to activities button",true);

	   LearningA.ProceedToActivities();
		
	   Reporter.log("End of assessment page",true);
	   logger.info("End of assessment page");

//------------------------------Configure the assessment Activity------------------------------------------------------
	   
	    logger=report.createTest("Configuring assessment activity");
	
	    ConfigureAssessmentActivityPage act1 =PageFactory.initElements(driver, ConfigureAssessmentActivityPage.class);
	   
		Reporter.log("Start Configuring assessment activity",true);
		 

		Reporter.log("Clicking on Activity dropdown",true);
		act1.ActivityDrop();
		
		Reporter.log("Selecting ativity",true);

		act1.SelectActivity(config.getAssessmentAct());
	
		Reporter.log("Clicking on save button",true);

		act1.savebutton();
		
		Reporter.log("Clicking on gear wheel icon",true);
		 
		act1.ClickingOnGearWheel();
	
		Reporter.log("End of configure assessment activity page",true);

//------------------------------Setup New Learning Activity------------------------------------------------------
		  
		   logger=report.createTest("Setup New Learning Activity");
		   
		   SetupActivityPage setupact =PageFactory.initElements(driver, SetupActivityPage.class);

		   logger.info("Starting to Setup learning activity");

		   Reporter.log("Starting to Setup learning activity",true);

		  
		   Reporter.log("Entering Activity title",true);

		   setupact.LActTitle();  // Activity title
		   
		   Reporter.log("Selecting competancy",true);
		   
		   setupact.selectcompetancy();//Select competancy
		   
		   excel1.ExcelDataProviderNew("./TestData/TestData.xlsx");
		  
		   //Start date
		   Reporter.log("Entering Start date of Activity ",true);
		   
		   date.SelectStartDate(excel1.getCellData("Dates",8, 1),excel1.getCellData("Dates",9,1),excel1.getCellData("Dates",10,1));
		  
		   excel1.ExcelDataProviderNew("./TestData/TestData.xlsx");
		  
		   Reporter.log("Entering End date of Activity ",true);
		   //End date
		   date.SelectEndDate(excel1.getCellData("Dates",8, 3),excel1.getCellData("Dates",9,3),excel1.getCellData("Dates",10,3));
		   	
		   Reporter.log("Entering questions per page",true);
		 
		   setupact.Questionperpage(); //Number of questions
	
		   Reporter.log("Entering Activity time",true);
		 
		   setupact.ActivityTime();
	
		   Reporter.log("Clicking on activity save button ",true);
		
		   setupact.savebutton();
		   
		   Reporter.log("Clicking on  save competancy button ",true);
		  
		   setupact.savecompetancy();
		 
		   Reporter.log("Setup new learning activity done ",true);
		   logger.info("Setup new learning activity done ");

//-------------------------------------Setup questions------------------------------------------------------	
	
		   logger=report.createTest("Setup Activity Questions");

		   SetupActivityQ setupactquestions =PageFactory.initElements(driver, SetupActivityQ.class);
		
		   logger.info("Starting to Setup Activity Questions ");

		   Reporter.log("Starting to Setup Activity Questions ",true);
		
		   Reporter.log("Clicking on competancy dropdown",true);
		  
		   setupactquestions.competancydrp();
		   
		   Reporter.log("Selecting Answer type",true);

		   setupactquestions.AnswerType();
		
		   Reporter.log("Setting question",true);

		   setupactquestions.SetQuestion();
		  // setupactquestions.setNoOfCorrectOption();
		
		   Reporter.log("Setting choice",true);

		   setupactquestions.setChoice1();
		 //  setupactquestions.AddChoiceButton();
		  

		  setupactquestions.setChoice2();
		   setupactquestions.setScore2();
		 
		   Reporter.log("Clicking on save button",true);


		   setupactquestions.SaveButton();
		  
		   Reporter.log("Setting up questions done",true);
		   logger.info("Setting up questions done");


	}	
}	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   

