package userPageNavigation;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.developersSignin;
import pageObjects.homePage;
import pageObjects.userDashboard;
import utility.constant;


public class mainLogin {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	@Test
	public void userLogin() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDriver\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    wait = new WebDriverWait(driver, 5);
	    driver.get(constant.url);
	    
	    wait.until(ExpectedConditions.elementToBeClickable(homePage.loginButton(driver)));
	    homePage.loginButton(driver).click();
	    wait.until(ExpectedConditions.elementToBeClickable(developersSignin.emailInput(driver)));
	    developersSignin.emailInput(driver).click();
	    developersSignin.emailInput(driver).sendKeys(constant.accountEmail);
	    developersSignin.passwordInput(driver).click();
	    developersSignin.passwordInput(driver).sendKeys(constant.accountPassword);
	    developersSignin.signinSubmit(driver).click();  
	}

	@Test (dependsOnMethods= {"userLogin"})
	public void userDashboard() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(userDashboard.dashboardLink(driver)));
		assertTrue((userDashboard.dashboardLink(driver).isDisplayed())); 
		//System.out.println("test");
		driver.close();
		
	}
	

}