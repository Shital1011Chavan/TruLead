package espl.LA.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import espl.LA.utilities.Helper;

public class DatePage {
	
WebDriver ldriver;
	

	WebDriver driver;
	public DatePage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}

	
	//-------------Activity Start Date column---------------------------------------------------

	@FindBy(xpath="//nz-date-picker[@formcontrolname='start_date']")
	WebElement StartDatecol;
	
	@FindBy(xpath="//button[@title='Choose a year']")
	WebElement Year;
	
	@FindBy(xpath="//button[@title='Next year (Control + right)']")
	WebElement NextYear;
	
	@FindBy(xpath="//button[@title='Choose a month']")
	WebElement Month;
	
	@FindBy(xpath="//button[@title='Next month (PageDown)']")
	WebElement NextMonth;
	
	@FindBy(xpath="//table[@role='grid']//td//div[@aria-disabled='false']")
	List<WebElement> AllDates;
	
	@FindBy(xpath="//div[@class='ant-picker-content']//ul[1]/li/div")
	List<WebElement>Hours;

	@FindBy(xpath="//div[@class='ant-picker-content']//ul[2]/li/div")
	List<WebElement>Minutes;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	WebElement okbutton;
	//----------------------------------End date column------------------------------------------------------
	@FindBy(xpath="//nz-date-picker[@formcontrolname='end_date']")
	WebElement EndDatecol;
	
	@FindBy(xpath="//button[@title='Choose a year']")
	WebElement Year1;
	
	@FindBy(xpath="//button[@title='Next year (Control + right)']")
	WebElement NextYear1;
	
	@FindBy(xpath="//button[@title='Choose a month']")
	WebElement Month1;
	
	@FindBy(xpath="//button[@title='Next month (PageDown)']")
	WebElement NextMonth1;
	
	@FindBy(xpath="//table[@role='grid']//td//div[@aria-disabled='false']")
	List<WebElement> AllDates1;
	
	@FindBy(xpath="//div[@class='ant-picker-content']//ul[1]/li/div")
	List<WebElement>Hours1;

	@FindBy(xpath="//div[@class='ant-picker-content']//ul[2]/li/div")
	List<WebElement>Minutes1;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	WebElement okbutton1;
	//----------------------------------------------------------------------------------------------------
	
	public void SelectStartDate(String exyear, String exmonth,String exdate) //Select start date
	{
		Helper.clickOn(driver, StartDatecol, 20); //Click on start date column

		
		while(true)             //select year
		{
			String year=Year.getText();
			
			System.out.println("expected year-"+exyear);
			System.out.println("actual year-"+year);

			
			if(year.equals(exyear))
				break;
			else
				Helper.clickOn(driver, NextYear, 20); 
		}
		
		while(true)             // select month
		{
			String month=Month.getText();


			System.out.println("expected month-"+exmonth);
			System.out.println("actual month-"+month);
			
			if(month.equalsIgnoreCase(exmonth.trim()))
				break;
			else
				Helper.clickOn(driver, NextMonth, 20); 
		}

	for(WebElement date:AllDates) //select date
		{
			String dt=date.getText();
			
			System.out.println("selected date:"+dt);

			if(dt.equals(exdate.trim()))
			{
				Helper.clickOn(driver, date, 20); 
				
				break;
			}
		}
		
	/*	for(WebElement hour:Hours)
		{
			String hr=hour.getText();
			
			if(hr.equals(exhour))
			{
				hour.click();
			}
		}
		
		for(WebElement minutes:Minutes)
		{
			String min1=minutes.getText();
			System.out.println("minutes"+min1);
			if(min1.equals(exminutes))
			{
				minutes.click();
			}
		}*/
		
		Helper.clickOn(driver, okbutton, 20); 
			
	}
	
	public void SelectEndDate(String Eexyear, String Eexmonth,String Eexdate)//Select End date
	{
		{
			Helper.clickOn(driver, EndDatecol, 20); //Click on start date column

		  
			
			while(true)             //select year
			{
				String year=Year1.getText();
				
				if(year.equals(Eexyear.trim()))
					break;
				else
					Helper.clickOn(driver, NextYear1, 20);
			
			}
			
			while(true)             // select month
			{
				String month=Month1.getText();
					
				if(month.equalsIgnoreCase(Eexmonth.trim()))
					break;
				else
					Helper.clickOn(driver, NextMonth1, 20);
					
			}
	
			for(WebElement date:AllDates1) //select date
			{
				String dt=date.getText();
				if(dt.equals(Eexdate.trim()))
				{
					Helper.clickOn(driver, date, 20);
				
					break;
				}
			}
			
		/*	for(WebElement hour:Hours1)
			{
				String hr=hour.getText();
				
				if(hr.equals(Eexhour))
				{
					hour.click();
				}
			}
			
			for(WebElement minutes:Minutes1)
			{
				String min2=minutes.getText();
				
				if(min2.equals(Eexminutes))
				{
					minutes.click();
				}
			}*/
			Helper.clickOn(driver, okbutton1, 20);
			
		}
	}

}
