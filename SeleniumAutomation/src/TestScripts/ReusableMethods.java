package TestScripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReusableMethods extends SalesforceBaseClass{
	 public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports extent=null;
	 public static ExtentTest logger=null;
	 
	 
	 public static void enterText (WebElement webElement,String webElementName,String text)
		{
			if (webElement.isDisplayed())
			{		
				webElement.sendKeys(text);
				logger.log(Status.PASS,text+" entered in " +webElementName);		
			}
			else
				logger.log(Status.FAIL, MarkupHelper.createLabel(webElementName+" Text box not found ", ExtentColor.RED));


		}
	 
	 public static void clickElement (WebElement element, String elementName)
		{
			if (element.isDisplayed())
			{
				logger.log(Status.PASS,elementName+" is clicked");
				element.click();
			}
			else
				logger.log(Status.FAIL, MarkupHelper.createLabel( elementName+" is not found", ExtentColor.RED));
		}
	 
	 public static void verifyText(WebElement element,String elementName,String expectedText ) throws IOException
		{
			if (element.isDisplayed())
			{	
				if (element.getText().equals(expectedText))
					logger.log(Status.PASS, MarkupHelper.createLabel( elementName+" is displayed as expected", ExtentColor.GREEN));
				else{
					logger.log(Status.FAIL, MarkupHelper.createLabel( elementName+"is NOT as expected", ExtentColor.RED));
				String imagePath=takeScreenShot();
				logger.addScreenCaptureFromPath(imagePath);
				}
			}
			else
			{
				logger.log(Status.FAIL, MarkupHelper.createLabel( elementName+" not found", ExtentColor.RED));
			}
		}



	 
	public static String takeScreenShot() throws IOException{
		String reportPath=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String curDir=System.getProperty("user.dir");
		String destination=curDir+"/TestReports/screenshots/"+reportPath+"image.PNG";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(destination),true);
		return destination;
	}
	public static void initializeExtentReport(String reportName){
		 String reportPath=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/TestReports/"+reportPath+reportName+".html");
		 extent = new ExtentReports ();
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Host Name", "TekArch");
		 extent.setSystemInfo("Environment", "QA Automation");
		 extent.setSystemInfo("User Name", "Divyashree");
		 
		 htmlReporter.config().setDocumentTitle("My Simple report");
		 htmlReporter.config().setReportName("First execution");
		 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlReporter.config().setTheme(Theme.STANDARD);
	}
	public static ExtentTest createTestScriptReport(String testScriptName){
		logger = extent.createTest("Login_Error_Message_1");
		return logger;
	}
	public static void endExtentReport(){
		extent.flush();
	}

}
