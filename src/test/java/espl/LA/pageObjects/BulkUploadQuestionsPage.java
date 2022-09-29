package espl.LA.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import espl.LA.utilities.Helper;

public class BulkUploadQuestionsPage {

	WebDriver ldriver;
	
	WebDriver driver;
	public BulkUploadQuestionsPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	
	@FindBy(xpath="//button[@class='ant-btn ng-star-inserted']")
	WebElement ClickToUploadButton;
	
	@FindBy(xpath="//nz-table-selection[@class='ant-table-selection']//input[@type='checkbox']")
	WebElement Selectallbulkquestions;	
			
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary ng-star-inserted']")
	WebElement okbutton;
	
	@FindBy(xpath="//button[@nztype='primary']")
	WebElement Savebutton;
	
	public void uploadquestions() throws InterruptedException, AWTException
	{
		Thread.sleep(5000);
		//JavaScriptUtil.clickbyjs(ClickToUploadButton, driver);
		//ClickToUploadButton.click();
		Helper.clickOn(driver, ClickToUploadButton,30);
		
		//Robot class
		
		Robot rb=new Robot();
		rb.delay(2000);
		
		//put path to file in a clipboard(copy)
		StringSelection ss=new StringSelection("C:\\Users\\HP\\Documents\\ESPL\\Automation Excel\\Assessment questions");
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
		
		Selectallbulkquestions.click();
		
		okbutton.click();
		
		Savebutton.click();
	}
}
