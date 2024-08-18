package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='mat-input-2']")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@id='mat-input-3']")
	private WebElement mobNo;
	
	@FindBy(xpath="//input[@id='mat-input-4']")
	private WebElement createPass;
	
	@FindBy(xpath="//input[@id='mat-input-5']")
	private WebElement confirmPass;
	
	public SignUp(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void sendEmailId(String eml)
	{
		//emailId.sendKeys("kaido@gmail.com");
		emailId.sendKeys(eml);
	}
	
	public void sendMob(String mob)
	{
		//mobNo.sendKeys("2456789224");
		mobNo.sendKeys(mob);
	}
	
	public void SendCreatePass(String cpass)
	{
		//createPass.sendKeys("kaido@gmail.com");
		createPass.sendKeys(cpass);
	}
	
	public void SendConfirmPass(String ccpass)
	{
		//confirmPass.sendKeys("kaido@gmail.com");
		confirmPass.sendKeys(ccpass);
	}
}
