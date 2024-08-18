package PomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	@FindBy(xpath="//a[@id='dropdownUser1']")
	private WebElement profile;
	
	@FindBy(xpath="//p[text()='Bestseller']/parent::div/child::span/img/parent::span/parent::div/parent::div")
	private WebElement bestSeller;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver,10);
	}
	
	public void clickOnProfile()
	{
		profile.click();
	}
	
	public void clickOnBestSeller()
	{
		bestSeller.click();
	}
}
