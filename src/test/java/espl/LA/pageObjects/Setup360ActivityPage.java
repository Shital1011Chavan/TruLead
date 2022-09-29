package espl.LA.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import espl.LA.utilities.Helper;

public class Setup360ActivityPage {


	WebDriver ldriver;
	

	WebDriver driver;
	public Setup360ActivityPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	
	//--------------Activity SetUp---------------------------------------------------------------
	
			@FindBy(xpath="//input[@formcontrolname='activity_title']")
			WebElement ActivityTitle;
			
			
			@FindBy(xpath="//nz-select[@formcontrolname='level_id']")
			WebElement selectLevels;
			
			@FindBy(xpath="//div[@class='ant-select-item-option-content']")
			List<WebElement> selectlevelsoptions;

			@FindBy(xpath="//nz-input-number[@formcontrolname='questions_per_page']//input[@class='ant-input-number-input ng-untouched ng-pristine ng-valid']")
			WebElement Questionperpage;
				
			//--spider chart report configuration------------------------
			
			@FindBy(xpath="(//input[@type='radio'])[1]")
			WebElement selfandotherstkeradio;
			
			@FindBy(xpath="//nz-select[@formcontrolname=\"feedback_roles\"]")
			WebElement feedbackroledrp;
			
			@FindBy(xpath="//div[@class='ant-select-item-option-content']")
			List<WebElement> feedbackroleoptions;
			
			@FindBy(xpath="//button[@class='ant-btn ant-btn-primary']")
			WebElement savebutton;
		
			@FindBy(xpath="//button[@nztype='primary']")
			WebElement savecompetancybutton;
			
			
			public void Act360Title()    //Enter title
			{
				Helper.mysendKeys(driver, ActivityTitle, 20, "Act123");
			}

			public void selectcompetancy()
			 {
				Helper.clickOn(driver, selectLevels, 30);

				
				 for(WebElement option:selectlevelsoptions)
				 {
					System.out.println("Competancy options:: "+ option.getText());
				
					if(option.getText().equals("Competency"))
					{
						Helper.clickOn(driver, option, 30);

					}
				 }
			 }

			public void Questionperpage() //Select number of questions per page.
			{
				Helper.clickOn(driver, Questionperpage, 20);

				Helper.mysendKeys(driver, Questionperpage, 20, "2");
				
			}	

            public void Selfandstakeradio()
            {
            	selfandotherstkeradio.click();
            }

            public void SelectfeedbackRoles() throws InterruptedException
            {
            	feedbackroledrp.click();
            	
            	for(WebElement options:feedbackroleoptions)
            	{
            		System.out.println("Feedback roles options: "+ options.getText());
            		
            		String stakeholders =options.getText();
            		
            		if(stakeholders.equals("Self"))
            		{
            			Thread.sleep(3000);
            			options.click();
            		}
            		
            		
            	}
            	
            }

            public void ClickonSave()
            {
            	savebutton.click();
            	Helper.clickOn(driver, savecompetancybutton, 10);
            //	savecompetancybutton.click();
            }

}
//&& (options.getText().equals("Manager"))&&(options.getText().equals("Peer")))