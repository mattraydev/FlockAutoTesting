package userPageNavigation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mainLogin {
@Test
	
	public void landingPageTest() throws InterruptedException {

		//remove before committing !!!!!!!!!!!!!!!
		String accountEmail = "";
		String accountPassword = "";
		
		String loginHomeBtn = "//*/div//ul/a[2]";
		String loginForm = "//*/div[@class='login-form']";
		String emailInput ="//*/input[@type='email']";
		String passwordInput = "//*/input[@type='password']";
		String loginBtn = "//*/input[@type='submit']";
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDriver\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    driver.get("https://www.findmyflock.com/");
	    
	    WebElement header = driver.findElement(By.xpath(loginHomeBtn));
	    wait.until(ExpectedConditions.elementToBeClickable(header));
	    assertTrue((header.isDisplayed())); 
	    header.click();
	    
	    WebElement logForm = driver.findElement(By.xpath(loginForm));
	    assertTrue((logForm.isDisplayed()));
	    WebElement email = driver.findElement(By.xpath(emailInput));
	    email.click();
	    email.sendKeys(accountEmail);
	    WebElement password = driver.findElement(By.xpath(passwordInput));
	    password.click();
	    password.sendKeys(accountPassword);
	    WebElement submit = driver.findElement(By.xpath(loginBtn));
	    submit.click();
	    Thread.sleep(5000);
	    driver.close();  
	}

}