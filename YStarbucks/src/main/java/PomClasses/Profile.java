package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile {
	
	WebDriver driver;
	WebDriverWait wait;
		
	@FindBy(xpath="//button[text()='Login or Sign Up']")
	private WebElement LogIn;
	
	@FindBy(xpath="//input[@id='username_input']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='mat-input-1']")
	private WebElement pass;
	
	@FindBy(xpath="//a[text()='SignUp']")
	private WebElement signUp;
	
	public Profile(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	public void clickOnLogin()
	{
		LogIn.click();
	}
	public void sendUserName(String userN)
	{
		userName.sendKeys(userN);
	}
	public void sendPass(String pas)
	{
		pass.sendKeys(pas);
	}
	
	public void clickOnSignUp()
	{
		signUp.click();
	}

	
}
