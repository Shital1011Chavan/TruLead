package espl.LA.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import espl.LA.utilities.Helper;
import espl.LA.utilities.JavaScriptUtil;

public class EmployeeBulkUploadPage {

WebDriver ldriver;
	
	WebDriver driver;
	public EmployeeBulkUploadPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	
	@FindBy(xpath="//a[@href='#mailbox']")
	WebElement OrganizationSetup;
	
	@FindBy(xpath="//a[normalize-space()='Employees']")
	WebElement EmployeesMenu;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary']")
	WebElement Import;
	
	@FindBy(xpath="//div[@role='button']//button[@class='ant-btn ng-star-inserted']")
	WebElement SelectFile;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary ng-star-inserted']")
	WebElement StartToUpload;
	
	@FindBy(xpath="//div[@class='swal2-html-container']")
	WebElement message;
	
	@FindBy(xpath="//h2[@id='swal2-title']")
	WebElement oopserror;
	
	public void UploadEmployees() throws AWTException, InterruptedException
	{
		Thread.sleep(3000);
		JavaScriptUtil.scrolltillElement(OrganizationSetup, driver);
		OrganizationSetup.click();
		
		Helper.clickOn(driver, EmployeesMenu, 20);
		Helper.clickOn(driver, Import, 20);
		Helper.clickOn(driver, SelectFile, 20);

		//Robot class
		
				Robot rb=new Robot();
				rb.delay(2000);
				
				//put path to file in a clipboard(copy)
				
				StringSelection ss=new StringSelection("C:\\Users\\HP\\Documents\\ESPL\\Excel\\Employee-BulkUpload-Template (hrbp,pres,talenttest)");
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
				Helper.clickOn(driver, StartToUpload, 10);
				//StartToUpload.click();
			
				Thread.sleep(3000);
				
				
				
				if(oopserror.getText().contains("Oops..."))
				{
					System.out.println("Error message title: "+oopserror.getText());
					System.out.println("Error message body: "+message.getText());
					Assert.assertTrue(false);
					
				}
				else
				{	
					Assert.assertTrue(true);
					
				}
				 
					
					 
				
			
	}
}
