package testclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Temp {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.starbucks.in/dashboard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement profile = driver.findElement(By.xpath("//a[@id='dropdownUser1']"));
		profile.click();
		
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login or Sign Up']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",loginButton);
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='username_input']"));
		js.executeScript("arguments[0].value='kaido@gmail.com';", userName);
		
		WebElement pass = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		js.executeScript("arguments[0].value='kaido123';", pass);

		
		
		
		WebElement signUp = driver.findElement(By.xpath("//a[text()='SignUp']"));
		signUp.click();
		
		WebElement emailId = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		emailId.sendKeys("kaido@gmail.com");
		
		WebElement mobNo = driver.findElement(By.xpath("//input[@id='mat-input-3']"));
		mobNo.sendKeys("2456789224");
		
		WebElement createPass = driver.findElement(By.xpath("//input[@id='mat-input-4']"));
		createPass.sendKeys("kaido@gmail.com");
		
		WebElement confirmPass = driver.findElement(By.xpath("//input[@id='mat-input-5']"));
		confirmPass.sendKeys("kaido@gmail.com");
		
//		//testcase continue button is enable
//		WebElement continueButton = driver.findElement(By.xpath("//button[text()='Continue']"));
//		Assert.assertTrue(continueButton.isEnabled());
//		
//		WebElement home = driver.findElement(By.xpath("(//a[text()='Home'])[1]"));		
//		home.click();
//		
//		
//		//WebElement bestSeller = driver.findElement(By.xpath("//p[text()='Bestseller']/parent::div/child::span/img"));
//		WebElement bestSeller = driver.findElement(By.xpath("//p[text()='Bestseller']/parent::div/child::span/img/parent::span/parent::div/parent::div"));
//		bestSeller.click();
//		
//		List<WebElement> namesOfProducts = driver.findElements(By.xpath("//div[@class='card-body']/h3"));
//		List<WebElement> addItems = driver.findElements(By.xpath("//button[text()=' Add Item ']"));
//		
//		//ArrayList<String> addr = new ArrayList<String>();
//		wait.until(ExpectedConditions.invisibilityOfAllElements(namesOfProducts));
//		for(int i=0;i<=namesOfProducts.size();i++)
//		{
//			System.out.println(namesOfProducts.get(1).getText());
//		}
		

		
		
	}
}
