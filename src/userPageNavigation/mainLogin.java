package userPageNavigation;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import java.util.Iterator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.developersSignin;
import pageObjects.homePage;
import pageObjects.userDashboard;
import pageObjects.applicationsPage;
import utility.constant;

public class mainLogin {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static int jobCount;
	
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
		wait.until(ExpectedConditions.elementToBeClickable(userDashboard.matchedJobs(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(userDashboard.applications(driver)));
		jobCount = userDashboard.jobDetails(driver).size();
		System.out.println(jobCount);
		
		Iterator<WebElement> iteration = userDashboard.jobDetails(driver).iterator();
		while(iteration.hasNext()) {
		    WebElement item = iteration.next();
		    wait.until(ExpectedConditions.elementToBeClickable(item));
		}
		
		assertTrue((userDashboard.accordianFilter(driver).isDisplayed()));
		userDashboard.benifits(driver).click();
		assertTrue((userDashboard.jobsCount(driver) == jobCount));
		userDashboard.firstCheckbox(driver).click();
		
		Thread.sleep(500); //short wait for the page to update
		assertTrue((userDashboard.jobDetails(driver).size() < jobCount));
		userDashboard.jobDetails(driver).get(0).click();
	}
	
	@Test (dependsOnMethods= {"userDashboard"})
	public void jobExample() throws InterruptedException {
		assertTrue((applicationsPage.applicationForm(driver).isDisplayed()));
		wait.until(ExpectedConditions.elementToBeClickable(applicationsPage.uploadButton(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(applicationsPage.sendApplicationButton(driver)));
		applicationsPage.backButton(driver).click();
	}
	
	@Test (dependsOnMethods= {"jobExample"})
	public void logout() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(userDashboard.userSettings(driver)));
		userDashboard.userSettings(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(userDashboard.logoutButton(driver)));
		userDashboard.logoutButton(driver).click();
		driver.close();
	}
}