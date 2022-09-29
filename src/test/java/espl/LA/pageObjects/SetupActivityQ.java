package espl.LA.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import espl.LA.utilities.Helper;

public class SetupActivityQ {

WebDriver ldriver;
	

	WebDriver driver;
	public SetupActivityQ(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	
	@FindBy(xpath="//nz-select[@formcontrolname='question_competency_id']")
	WebElement competancydrp;
	
	@FindBy(xpath="//nz-option-item[@Class='ant-select-item ant-select-item-option ng-star-inserted']")
	List<WebElement> compoptions;

	
	@FindBy(xpath="//nz-select[@formcontrolname='answer_type']")
	WebElement AnswerType;
	
	@FindBy(xpath="//nz-option-item[@title='MCQ']")
	WebElement mcq;
	
	@FindBy(xpath="//div[@class='ql-editor ql-blank']")
	WebElement Question;
	
	@FindBy(xpath="//nz-input-number[@formcontrolname='choices_count']")
	WebElement NoOfCorrectOption;

	
	@FindBy(xpath="//input[@class='ant-input ant-input-lg ng-untouched ng-pristine ng-invalid ng-star-inserted'][1]")
	WebElement choice1;
	
	@FindBy(xpath="//nz-input-number[@formcontrolname='score']")
	WebElement Score;
	
	@FindBy(xpath="//a[@title='Add']")
	WebElement AddChoiceButton;
	
	@FindBy(xpath="//input[@class='ant-input ant-input-lg ng-untouched ng-pristine ng-invalid ng-star-inserted'][2]")
	WebElement choice2;

	
	@FindBy(xpath="//button[@nztype='primary']")
	WebElement SaveButton;
	
	
	public void competancydrp()
	{
		Helper.clickOn(driver, competancydrp, 10);
	
		
		for(WebElement opt:compoptions)
		{
			String compname= opt.getAttribute("title");
			
			if(compname.equals("Collaboration"))
			{
				opt.click();
			}
		}
		
	}
	

	public void AnswerType()
	{
		Helper.clickOn(driver, AnswerType, 5);
		Helper.clickOn(driver, mcq, 5);
	}
	
	public void SetQuestion()
	{
		Helper.mysendKeys(driver, Question, 10, "Question1?");
		
	}
	
	public void setNoOfCorrectOption()
	{
		Helper.mysendKeys(driver, NoOfCorrectOption, 10, "1");
		
	}
	
	public void setChoice1()
	{
		Helper.mysendKeys(driver, choice1, 10, "Choice1");
		
	}
	
	public void setScore1()
	{
		Helper.mysendKeys(driver, Score, 10, "5");
		
	}
	
	public void AddChoiceButton()
	{
		Helper.clickOn(driver, AddChoiceButton,10);
		
	}

	public void setChoice2()
	{
		Helper.mysendKeys(driver, choice2, 10, "Choice2");
		
	}
	
	public void setScore2()
	{
		Helper.mysendKeys(driver, Score, 10, "3");
		
	}
	
	
	public void SaveButton()
	{
		Helper.clickOn(driver, SaveButton,10);

		
	}
}
