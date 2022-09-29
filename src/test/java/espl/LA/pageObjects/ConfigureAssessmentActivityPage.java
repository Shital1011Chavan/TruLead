package espl.LA.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import espl.LA.utilities.Helper;

public class ConfigureAssessmentActivityPage {
	
	WebDriver ldriver;
	

	WebDriver driver;
	public ConfigureAssessmentActivityPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	
	@FindBy(xpath="//nz-select[@formcontrolname='selectedActivity']")
	WebElement SelectActdrop;
	
	@FindBy(xpath="//div[@class='ant-select-item-option-content']")
	List<WebElement> selectacts;
	
	@FindBy(xpath="//button//span[normalize-space()='Save']")
	WebElement Savebutton;

	@FindBy(xpath="//i[@class='ri-settings-5-fill text-primary text-small']")
	WebElement Gearwheel;
	
	
	public void ActivityDrop()  
	{
		Helper.clickOn(driver, SelectActdrop,20);


	}

	public void SelectActivity(String activity)  
	{
		for(WebElement acts :selectacts)
		{
			System.out.println("Acts:"+acts.getText());
			
			if(acts.getText().equals(activity))
			{
				acts.click();
				
			}
		}
	}
	
	public void savebutton()
	{
		Helper.clickOn(driver, Savebutton,10);
		//Savebutton.click();

	}
	
	public void ClickingOnGearWheel()
	{
		Helper.clickOn(driver, Gearwheel, 20);
		//Gearwheel.click();
	}
	

}
