package testclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PomClasses.HomePage;
import PomClasses.Profile;
import PomClasses.SignUp;
import qa.base.Basee;
import qa.utility.Utility;

public class testSignUpInProfile extends Basee {

	public WebDriver driver;
	HomePage homePage;
	Profile profile;
	SignUp signUp;
	WebDriverWait wait;
	
	//@Parameters(value="browserName")
	@BeforeTest
	public void openBrowser()
	{
		loadProperties();
		driver = initializeBrowser(prop.getProperty("browserName"));
		wait = new WebDriverWait(driver, 20);
	}
	
	@BeforeClass
	public void pomObjects()
	{
		homePage = new HomePage(driver);
		profile = new Profile(driver);
		signUp = new SignUp(driver);
		driver.get("https://www.starbucks.in/dashboard");
		
	}
	
//	@BeforeMethod
//	public void openApplication()
//	{
//		
//	}
	
	@Test()
	public void checktheProfileUrl()
	{
		 homePage.clickOnProfile();
	        
	        // Wait until the URL is as expected
	         // 10 seconds wait
	        wait.until(ExpectedConditions.urlToBe("https://www.starbucks.in/profile"));
	        
	        // Retrieve the actual URL
	        String actualUrl = driver.getCurrentUrl();
	        String expectedUrl = "https://www.starbucks.in/profile";
	        
	        Assert.assertEquals(actualUrl, expectedUrl);
	}
	//@Test(dataProvider="validCredentialsSupplier")
	@Test(dataProvider="validCredentialsSupplier")
	public void sendDataToLogin(String email,String mob,String creatPass,String confirmPass)
	{
		profile.clickOnLogin();
		profile.clickOnSignUp();
		signUp.sendEmailId(email);
		//signUp.sendMob("2415671239");
		signUp.sendMob(mob);
		signUp.SendCreatePass(creatPass);
		signUp.SendConfirmPass(confirmPass);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("afterMethod");
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() throws IOException
	{
		//Object[][] data = {{"kaido@gmail.com","kaido123"},{"zoro@gmail.com","zoro123"}};
		//return data;
		Object[][] data = Utility.getDataFromexcel("signup");
		return data;
	}
	
//	@AfterClass
//	public void afterClass()
//	{
//		homePage=null;
//		profile=null;
//		signUp=null;
//	}
//	
//	@AfterTest
//	public void afterTest()
//	{
//		System.gc();
//		driver.quit();
//	}
}
