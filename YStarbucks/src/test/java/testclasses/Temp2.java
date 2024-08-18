package testclasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Temp2 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.starbucks.in/dashboard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement bestSeller = driver.findElement(By.xpath("//p[text()='Bestseller']/parent::div/child::span/img/parent::span/parent::div/parent::div"));
		bestSeller.click();
		
		//List<WebElement> namesOfProducts = driver.findElements(By.xpath("//div[@class='card-body']/h3"));
		List<WebElement> addItems = driver.findElements(By.xpath("//button[text()=' Add Item ']"));
		
		//ArrayList<String> addr = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h3")));
        try {
            for (int i = 0; ; i++) {
                List<WebElement> namesOfProducts = driver.findElements(By.xpath("//div[@class='card-body']/h3"));
                if (i >= namesOfProducts.size()) {
                    break;
                }
                // Print product names
                System.out.println(namesOfProducts.get(i).getText());
                if(namesOfProducts.get(i).getText().equalsIgnoreCase("Caffe Americano"))
                {
                	addItems.get(i).click();
                }
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException caught: " + e.getMessage());
        }

	}
	
}
