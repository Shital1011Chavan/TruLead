package espl.LA.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import espl.LA.utilities.Helper;

public class LoginPage {
	
	WebDriver ldriver;
	

	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath="//button[contains(text(),'Sign in with Username')]") //Sign in with user name.
	WebElement signInwithUsernamebutton;

	@FindBy(xpath="//input[@type='checkbox']") //checkbox button on popup
	WebElement cbutton;
	
	@FindBy(xpath="//span[contains(text(),'Ok')]")// ok button on popup
	WebElement okbutton;
	
	@FindBy(xpath="//input[@formcontrolname='username']") //username
	WebElement UserName;
	
	@FindBy(id="next_button") // login button
	WebElement loginbutton;
	
	@FindBy(xpath="//input[@formcontrolname='password']") //password
	WebElement Password;
	
	
	@FindBy(xpath="//button[@class='login-form-button login-form-margin ant-btn ant-btn-primary']")
	WebElement button;
	
	
	public void loginToApplication(String uname,String pass)
	{
		signInwithUsernamebutton.click();
		//Helper.clickOn(driver, signInwithUsernamebutton, 20);
		//Helper.clickOn(driver, cbutton, 5);
		cbutton.click();
		Helper.clickOn(driver, okbutton,5);
		
		Helper.mysendKeys(driver, UserName, 10, uname);
		Helper.clickOn(driver, loginbutton, 5);
		Helper.mysendKeys(driver, Password,5, pass);
		
		Helper.clickOn(driver, button,5);	
		
		 if(driver.getTitle().equals("TruleadWeb"))
		    {
		    	Assert.assertTrue(true);
		    }
		    else
		    {
		    	Assert.assertTrue(false);
		    }
		    
	}
}
