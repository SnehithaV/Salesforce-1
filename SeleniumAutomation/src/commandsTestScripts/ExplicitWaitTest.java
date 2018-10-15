package commandsTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTest {

	public static void main(String[] args) {
		WebDriver driver=null;
		
		System.setProperty("webdriver.gecko.driver","./src/Utility/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		WebElement submit=driver.findElement(By.xpath("//input[@value='Submit']"));
		waitExplicitelementToBeClickable(30,submit, driver);
		submit.click();
		driver.close();

	}
	public static void waitExplicitelementToBeClickable(int sec,WebElement ele,WebDriver driver){
		WebDriverWait wait=new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public void waitExplicitVisibilty(int sec,WebElement ele,WebDriver driver){
		WebDriverWait wait=new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

}
