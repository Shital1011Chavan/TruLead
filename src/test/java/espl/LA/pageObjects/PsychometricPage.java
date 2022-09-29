package espl.LA.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import espl.LA.utilities.Helper;

public class PsychometricPage {
	
WebDriver ldriver;
	

	WebDriver driver;
	public PsychometricPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}

	@FindBy(xpath="//input[@formcontrolname='activity_title']")
	WebElement psychometricTitle;
	
	@FindBy(xpath="//nz-select[@formcontrolname='level_id']")
	WebElement selectLevels;
	
	@FindBy(xpath="//div[@class='ant-select-item-option-content']")
	List<WebElement> selectLeveloptions;

	@FindBy(xpath="//nz-select[@nzplaceholder='Select Competencies']")
	WebElement competancydrp;
	
	@FindBy(xpath="//nz-option-item[@Class='ant-select-item ant-select-item-option ng-star-inserted']")
	List<WebElement> compoptions;

	@FindBy(xpath="//div[@class='ant-upload']")
	WebElement ClickToUploadButton;
	
	@FindBy(xpath="//div[@class='swal2-html-container']")
	WebElement message;
	
	@FindBy(xpath="//h2[@id='swal2-title']")
	WebElement Messageheading;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary']")
	WebElement SaveButton;

	@FindBy(xpath="//nz-table-selection[@class='ant-table-selection']//input[@type='checkbox']")
	WebElement Selectallbulkquestions;	
			
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary ng-star-inserted']")
	WebElement okbutton;
	
	public void PsychometricTitle()  //Click on plus icon
	{
		Helper.mysendKeys(driver, psychometricTitle, 20, "psychometricTest");;
		
	}
	
	public void selectLevel()
	 {
		Helper.clickOn(driver, selectLevels, 30);

		
		 for(WebElement option:selectLeveloptions)
		 {
			System.out.println("Competancy options:: "+ option.getText());
		
			if(option.getText().equals("Competency"))
			{
				Helper.clickOn(driver, option, 30);

			}
		 }
	 }
	
	public void SelectCompetency()
	{
		Helper.clickOn(driver,competancydrp,20);
	
		
		for(WebElement opt:compoptions)
		{
			String compname= opt.getAttribute("title");
			
			if(compname.equals("Collaboration"))
			{
				Helper.clickOn(driver, opt, 30);
			}
			
		}
		
	}

		public void ClickOnSave()
		{
			SaveButton.click();
		}
	
		public void ClickToUpload() throws InterruptedException, AWTException
			{
				
				Thread.sleep(3000);
				ClickToUploadButton.click();
				
				//Robot class
						
			
				Robot rb=new Robot();
				rb.delay(2000);
				
				//put path to file in a clipboard(copy)
				StringSelection ss=new StringSelection("C:\\Users\\HP\\Documents\\ESPL\\Automation Excel\\Psychometric-BulkUpload-Template (talentbcd)");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
				
				//CTRL+V
				rb.keyPress(KeyEvent.VK_CONTROL);//press on control key
				rb.keyPress(KeyEvent.VK_V);//press on control key
				rb.delay(2000);

				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);
				rb.delay(2000);

				//Enter
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(3000);
				
				 Selectallbulkquestions.click();
					
				 okbutton.click();
					
			
				
				
	}
	 
	
	
	 
}
