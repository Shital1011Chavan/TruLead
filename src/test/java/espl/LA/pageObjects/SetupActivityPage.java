package espl.LA.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import espl.LA.utilities.Helper;

public class SetupActivityPage {
	
WebDriver ldriver;
	

	WebDriver driver;
	public SetupActivityPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}

	

	
	//--------------Activity SetUp---------------------------------------------------------------
	
		@FindBy(xpath="//input[@formcontrolname='activity_title']")
		WebElement ActivityTitle;
		
		
		@FindBy(xpath="//nz-select[@formcontrolname='level_id']")
		WebElement selectcompetancydropdown;
		
		@FindBy(xpath="//div[@class='ant-select-item-option-content']")
		List<WebElement> selectcompetancyoptions;



		
	
		@FindBy(xpath="//nz-input-number[@formcontrolname='questions_per_page']//input[@class='ant-input-number-input ng-untouched ng-pristine ng-valid']")
		WebElement Qperpage;
			
		@FindBy(xpath="//nz-input-number[@formcontrolname='ideal_interval_seconds']//input[@class='ant-input-number-input ng-untouched ng-pristine ng-valid']")
		WebElement IdealActivityTime;
		
		@FindBy(xpath="//button[@class='ant-btn ant-btn-primary']")
		WebElement save;
		
		@FindBy(xpath="//button[@class='ant-btn ant-btn-primary']//span[normalize-space()='Save']")
		WebElement savecompetancy;
		
		
//-----------Date
		
		
		

		public void LActTitle()    //Enter title
		{
			Helper.mysendKeys(driver, ActivityTitle, 20, "Act123");
		}

		public void selectcompetancy()
		 {
			Helper.clickOn(driver, selectcompetancydropdown, 30);

			
			 System.out.println("Competancy options-"+selectcompetancyoptions);
			
			 for(WebElement option:selectcompetancyoptions)
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
			Helper.clickOn(driver, Qperpage, 20);

			Helper.mysendKeys(driver, Qperpage, 20, "2");
			
		}	
		
		public void ActivityTime()
		{
			Helper.clickOn(driver, IdealActivityTime, 20);
			Helper.mysendKeys(driver, IdealActivityTime,20, "15");
			
		}
		
		public void savebutton()
		{
			Helper.clickOn(driver, save, 20);

		}
		
		
		public void savecompetancy() throws InterruptedException
		{
		
			//Helper.clickOn(driver, savecompetancy,30);
		Thread.sleep(3000);
			savecompetancy.click();
		}
		
		
		
		
		
		
		
		
		
		
		
}
