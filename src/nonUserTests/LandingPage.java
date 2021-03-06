package nonUserTests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.homePage;
import utility.constant;

public class LandingPage {

@Test
public void landingPageTest() throws InterruptedException {
	System.setProperty("webdriver.gecko.driver", "C:\\geckoDriver\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	//driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	driver.get(constant.url);
	
	wait.until(ExpectedConditions.elementToBeClickable(homePage.homeLogo(driver)));
	assertTrue((homePage.homeLogo(driver).isDisplayed())); 
	assertTrue((homePage.jobs(driver).isDisplayed()));
	assertTrue((homePage.jobSeekers(driver).isDisplayed()));
	assertTrue((homePage.companies(driver).isDisplayed()));
	assertTrue((homePage.joinButton(driver).isDisplayed()));
	assertTrue((homePage.loginButton(driver).isDisplayed()));
	assertTrue((homePage.homepageBodySections(driver) > 1));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePage.socialIcons(driver));
	assertTrue((homePage.socialIcons(driver).isDisplayed()));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePage.jobs(driver));
	driver.close();
	}

}
