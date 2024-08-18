package qalisteners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PomClasses.HomePage;
import PomClasses.Profile;
import PomClasses.SignUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import qa.base.Basee;
import qa.utility.ExtentReporter;
import qa.utility.Utility;

public class MyListeners implements ITestListener{

	ExtentReports extentsReports;
	ExtentTest extentTest;
	
	public void onStart(ITestContext context) {
		
		extentsReports = ExtentReporter.generateExtentReport();   
	}
	
	public void onTestStart(ITestResult result) {
		
		extentTest = extentsReports.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName()+"stared execution");
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getName()+"test got successfully executed");
	}

	public void onTestFailure(ITestResult result) {
		
		WebDriver driver=null;
		try {//*****to get driver from that failer class//***** and make sure in testCass dec public WebDriver driver; to get driver here 
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String destinationScreenshotPath = Utility.captureScreenshot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+"got failed");
	}

	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName());
	}
	
	public void onFinish(ITestContext context) {
		
		extentsReports.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);//path of extent report 
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
}
