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

public class BulkUpload360degreeStakeholdersPage {
	
WebDriver ldriver;
	

	WebDriver driver;
	public BulkUpload360degreeStakeholdersPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}

	@FindBy(xpath="//nz-select[@formcontrolname=\"feedback_roles\"]")
	WebElement feedbackroledrp;
	
	@FindBy(xpath="//div[@class='ant-select-item-option-content']")
	List<WebElement> feedbackroleoptions;
	
	@FindBy(xpath="//span[normalize-space()='Yes']")
	WebElement bulkuploadStakeholderradio;
	
	@FindBy(xpath="//button[@class='ant-btn ng-star-inserted']")
	WebElement ClickToUploadButton;
	
	@FindBy(xpath="//div[@class='swal2-html-container']")
	WebElement message;
	
	@FindBy(xpath="//h2[@id='swal2-title']")
	WebElement Messageheading;
	 
	
	
	
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
      		if(stakeholders.equals("Peer"))
      		{
      			Thread.sleep(3000);
      			options.click();
      		}
      		if(stakeholders.equals("Subordinate"))
      		{
      			Thread.sleep(3000);
      			options.click();
      		}
      		if(stakeholders.equals("Manager"))
      		{
      			Thread.sleep(3000);
      			options.click();
      		}
      		
      	}
      	
      }
	public void uploadStakeholders() throws InterruptedException, AWTException
	{
		
		Thread.sleep(5000);
		
		bulkuploadStakeholderradio.click();

		ClickToUploadButton.click();
		
		//Robot class
		
		Robot rb=new Robot();
		rb.delay(2000);
		
		//put path to file in a clipboard(copy)
		StringSelection ss=new StringSelection("C:\\Users\\HP\\Documents\\ESPL\\Automation Excel\\360-degree-feedback (self,peer,sub,man)");
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
		
		
		if(Messageheading.getText().contains("Success!"))
		{
			System.out.println(" message title: "+Messageheading.getText());
			System.out.println(" message body: "+message.getText());

			Assert.assertTrue(true);

		}else
		if(Messageheading.getText().contains("Oops..."))
		{
			System.out.println("Error message title: "+Messageheading.getText());
			System.out.println("Error message body: "+message.getText());
			Assert.assertTrue(false);
			
		}
		
	}

}
