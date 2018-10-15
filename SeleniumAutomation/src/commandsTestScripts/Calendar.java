package commandsTestScripts;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		System.setProperty("webdriver.gecko.driver","./src/Utility/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.clear();
		username.sendKeys("divya.bausa@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		password.sendKeys("Divyashree1");
		WebElement loginButton=driver.findElement(By.id("Login"));
		loginButton.click();
		Thread.sleep(8000);
		//System.out.println(driver.findElement(By.xpath("//div/nav/ul/li")).getText());
		List<WebElement> list=driver.findElements(By.xpath("//div/nav/ul/li"));
		for(WebElement ele:list){
			System.out.println(ele.getText());
		}
		
		driver.close();
	}

}
