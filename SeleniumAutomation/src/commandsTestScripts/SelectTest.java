package commandsTestScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTest {

	public static void main(String[] args) {
		WebDriver driver=null;
		System.setProperty("webdriver.gecko.driver","./src/Utility/geckodriver.exe");
		driver=new FirefoxDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		WebElement contryList=driver.findElement(By.xpath("//select[@name='country']"));
		Select select=new Select(contryList);
		select.selectByVisibleText("AUSTRIA");
		
		driver.close();
	}

}
