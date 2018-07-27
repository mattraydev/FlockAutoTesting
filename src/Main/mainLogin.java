package Main;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mainLogin {
@Test
	
	public void landingPageTest() throws InterruptedException {
		
		String loginBtn = "//*/div//ul/a[2]";
		String loginForm = "//*/div[@class='login-form']";
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDriver\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    
	    driver.get("https://www.findmyflock.com/");
	    WebElement header = driver.findElement(By.xpath(loginBtn));
	    assertTrue((header.isDisplayed())); 
	    header.click();
	    Thread.sleep(3000);
	    
	    WebElement logForm = driver.findElement(By.xpath(loginForm));
	    assertTrue((logForm.isDisplayed()));
	    driver.close();  
	}

}