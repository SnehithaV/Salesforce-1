package TestScripts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class AutomationScript extends ReusableMethods{
	@Test
	public static void Login_Error_Message_1() throws InterruptedException, IOException {
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("./src/DataFiles/Configuration.properties"));
		pro.load(reader);
		createTestScriptReport("Login_Error_Message_1");
		String expData="Please enter your password."+"divya";
		IntializeDriver("firefox");
		driver.get(pro.getProperty("salesforceUrl"));
		logger.log(Status.INFO,"salesforce page opened");
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		enterText(username, "username field","User@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		logger.log(Status.INFO,"password field cleared");
		
		WebElement loginButton=driver.findElement(By.id("Login"));
		clickElement(loginButton, "Login Button");
		logger.log(Status.INFO,"login button clicked");
		WebElement actuaError=driver.findElement(By.xpath("//div[@id='error']"));
		verifyText(actuaError, "error message",expData);
		closeDriver();
	}
	@Test
	private static void Login_To_SalesForce_2() {
		
		
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		initializeExtentReport("salesforceTestscriptsReport");
		Login_Error_Message_1();
		endExtentReport();
	}


}
