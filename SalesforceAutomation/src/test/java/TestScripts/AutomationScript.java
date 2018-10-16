package TestScripts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class AutomationScript extends ReusableMethods {
	
	public static void Login_Error_Message_1() throws Exception {
		String propertyPath="./src/test/resources/DataFiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		
		createTestScriptReport("Login_Error_Message_1");
		String expData="Please enter your password.";
		IntializeDriver("firefox");
		driver.get(pro.getProperty("salesforceUrl"));
		logger.log(Status.INFO,"salesforce page opened");
		WebElement username=driver.findElement(getLocator("salesforce.login.username",objPro));
		enterText(username, "username field","User@gmail.com");
		WebElement password=driver.findElement(getLocator("salesforce.login.password",objPro));
		password.clear();
		logger.log(Status.INFO,"password field cleared");
		WebElement loginButton=driver.findElement(getLocator("salesforce.login.loginButton",objPro));
		clickElement(loginButton, "Login Button");
		logger.log(Status.INFO,"login button clicked");
		WebElement actuaError=driver.findElement(getLocator("salesforce.login.errorMsg",objPro));
		verifyText(actuaError, "error message",expData);
		closeDriver();
	}
	
	private static void Login_To_SalesForce_2() {
		
		
	}
	
}
