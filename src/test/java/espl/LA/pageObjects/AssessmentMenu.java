package espl.LA.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import espl.LA.utilities.Helper;

public class AssessmentMenu {
	
WebDriver ldriver;
	

	WebDriver driver;
	public AssessmentMenu(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	

	@FindBy(xpath="//span[normalize-space()='Assessment']") //Assessment
	WebElement AssessmentMenu;


	@FindBy(xpath="//a[@href='/learning-assessment']") //Setup
	WebElement Setup;
	
	@FindBy(xpath="//h3[normalize-space()='Assessment']")
	WebElement LApagetitle;
	
	public void SetupLA()  
	{
		Helper.clickOn(driver, AssessmentMenu,15);
		Helper.clickOn(driver, Setup, 15);
		
	}	

	public String title()
	{
		String title1=LApagetitle.getText();
		return title1;
	}
	
	
	
	
	
}
