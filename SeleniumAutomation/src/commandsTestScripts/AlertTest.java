package commandsTestScripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AlertTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=null;
		System.setProperty("webdriver.gecko.driver","./src/Utility/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		WebElement submit=driver.findElement(By.xpath("//input[@value='Submit']"));
		submit.click();
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./TestReports/screenshots/new2.PNG"));
		Alert alert=driver.switchTo().alert();
		alert.accept();
		//Thread.sleep(6000);
		File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("./TestReports/screenshots/new3.PNG"));
		
		driver.switchTo().alert().accept();
		driver.close();
		
		

	}

}
