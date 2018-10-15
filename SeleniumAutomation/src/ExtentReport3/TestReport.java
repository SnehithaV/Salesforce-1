package ExtentReport3;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import TestScripts.ReusableMethods;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestReport extends ReusableMethods{
	
	 
private static void Login_Error_Message_1() throws InterruptedException, IOException {
	logger = extent.createTest("Login_Error_Message_1");
		String expData="Please enter your password.";
		WebDriver driver=null;
		System.setProperty("webdriver.gecko.driver","./src/Utility/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		logger.log(Status.INFO,"salesforce page opened");
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.clear();
		username.sendKeys("User@gmail.com");
		logger.log(Status.INFO,"useraname entered");
		Thread.sleep(4000);
		
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		logger.log(Status.INFO,"password field cleared");
		System.out.println("entered data in username field is="+username.getAttribute("value"));
		WebElement loginButton=driver.findElement(By.id("Login"));
		loginButton.click();
		logger.log(Status.INFO,"login button clicked");
		WebElement actuaError=driver.findElement(By.xpath("//div[@id='error']"));
		String actaulData=actuaError.getText();
		if(actaulData.equals(expData+"data")){
			 logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed", ExtentColor.GREEN));
			
		}
		else{
			logger.log(Status.FAIL, MarkupHelper.createLabel("Test Case Failed", ExtentColor.RED));
			
			String imagePath=takeScreenShot();
			logger.addScreenCaptureFromPath(imagePath);
		}
		driver.close();
	}
	public static void test2(ExtentTest logger, ExtentReports extent) {
		 logger = extent.createTest("Test TWO");
		 if(1==2){
			 logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
		 logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
		 logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
		 }
		 else
			 logger.log(Status.FATAL,MarkupHelper.createLabel("Test Case has fatal error", ExtentColor.RED));
		 	logger.fail(MarkupHelper.createLabel("Test Case is failed", ExtentColor.RED));

	}
	public static void main(String[] args) throws InterruptedException, IOException {
		
		initializeExtentReport("first");
		 Login_Error_Message_1();
		 test2(logger,extent);
		 extent.flush();
		 System.out.println("completed");
			 
		 
	}

}
