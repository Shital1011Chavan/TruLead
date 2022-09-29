package espl.LA.pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import espl.LA.utilities.Helper;

public class AssessmentPage {
	
	
WebDriver ldriver;
	

	WebDriver driver;
	public AssessmentPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	
	@FindBy(xpath="//a[@title='Create New']") //+ symbol Learning Assessment.
	WebElement Plusbutton;

	@FindBy(xpath="//input[@formcontrolname='title']")
	WebElement LAtitle;
	
	//Date
	
	@FindBy(xpath="//input[@class='ant-input-number-input ng-untouched ng-pristine ng-valid']")
	WebElement NoOfActivity;
	
	
	@FindBy(xpath="//input[@type='radio'])[3]")
	WebElement autoenroll;
	
	@FindBy(xpath="//span[contains(text(),'Select Employees')]")
	WebElement SelectEmpbutton;
	
	@FindBy(xpath="//div[@class='ant-table-content']//table//tbody//tr")
	List<WebElement> employees;
	
	@FindBy(xpath="//nz-pagination[@class='ant-table-pagination ant-table-pagination-right ant-pagination ng-star-inserted']//li[@class='ant-pagination-item ant-pagination-item-active ng-star-inserted']")
	WebElement ActivePage;
	
	@FindBy(xpath="//a[normalize-space()='2']")
	WebElement page;
	
	@FindBy(xpath="//li[@title='Next Page']//button[@class='ant-pagination-item-link ng-star-inserted']")
	WebElement paginationnextbutton;
			
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary ng-star-inserted']")
	WebElement okbut;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to Activities')]")
	WebElement ProceedToActivitiesbutton;
	
	
	
	@FindBy(xpath="//td[normalize-space()='pre360ass']//following::td[5]//a[2]")
	WebElement PublishReportButton;
	
	
	public void ClickPlus()  //Click on plus icon
	{
		Helper.clickOn(driver, Plusbutton, 10);
		
	}

	public void LATitle(String AssTitle)    //Enter title
	{
		Helper.mysendKeys(driver, LAtitle, 20, AssTitle);
		
	}

	

	public void selectNoOfActivity()//Select number of activities.
	{
		Helper.clickOn(driver, NoOfActivity,5);
		Helper.mysendKeys(driver, NoOfActivity, 20, "1");
		
	}
	
	public void SelectEmployees()// Select Employees
	{
		Helper.clickOn(driver, SelectEmpbutton, 20);
		
		
	}

	public void empbychoice()
	{
		while(true)
		{
			System.out.println("Active Page Number : "+ActivePage.getText());
			
			int NoofEmps=employees.size();
			System.out.println("No. of Employees" +NoofEmps);
		//	ActivePage.click();
			for(WebElement emp:employees)
			{
				String empls=emp.getText();
				System.out.println(empls);
			}
			
			Helper.clickOn(driver, paginationnextbutton, 20);
	
		}
	
	}
	
	public void ok()
	{
		Helper.clickOn(driver, okbut,20);
	}
	
	public void autoenroll()
	{
		Helper.clickOn(driver, autoenroll,20);

	}
	
	public void ProceedToActivities()//Click on proceed to activities button
	{
		Helper.clickOn(driver, ProceedToActivitiesbutton,30);
	}
	
    public void getalert()
    {
	   Alert alert= driver.switchTo().alert();
	   System.out.println(alert.getText());
    }


}






