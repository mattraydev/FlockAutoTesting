package nonUserTests;

import java.util.Iterator;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.companiesPage;
import pageObjects.developersSignin;
import pageObjects.homePage;
import pageObjects.jobSamplesPage;

public class PageNavigation {

@Test
	public void navigationCheck() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("https://www.findmyflock.com/");
		wait.until(ExpectedConditions.elementToBeClickable(homePage.jobs(driver)));
		homePage.jobs(driver).click();
//jobs page		
		wait.until(ExpectedConditions.elementToBeClickable(homePage.homeLogo(driver)));
		assertTrue((homePage.homeLogo(driver).isDisplayed())); 
		assertTrue((homePage.jobs(driver).isDisplayed()));
		assertTrue((homePage.jobSeekers(driver).isDisplayed()));
		assertTrue((homePage.companies(driver).isDisplayed()));
		assertTrue((jobSamplesPage.jobSample(driver).size() > 1));
		homePage.companies(driver).click();
//companies page
		wait.until(ExpectedConditions.elementToBeClickable(homePage.homeLogo(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(companiesPage.recruiterLogin(driver)));
		
		Iterator<WebElement> iteration = companiesPage.recruiterSignup(driver).iterator();
		while(iteration.hasNext()) {
		    WebElement item = iteration.next();
		    wait.until(ExpectedConditions.elementToBeClickable(item));
		}
		assertTrue((companiesPage.contactModal(driver).isDisplayed())); 
		companiesPage.contactModal(driver).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(companiesPage.contactLink(driver)));
		companiesPage.modalClose(driver).click();
		Thread.sleep(3000); // fix this later, animation time need to finish
		wait.until(ExpectedConditions.elementToBeClickable(homePage.jobSeekers(driver)));
		homePage.jobSeekers(driver).click();
//job seekers page
		assertTrue((developersSignin.signinBox(driver).isDisplayed()));
		wait.until(ExpectedConditions.elementToBeClickable(companiesPage.recruiterLogin(driver)));
		developersSignin.developerSignup(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(developersSignin.recruiterSignUp(driver)));
		homePage.homeLogo(driver).click();
		driver.close();  
	}
}
