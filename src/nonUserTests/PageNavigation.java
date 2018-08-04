package nonUserTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.homePage;
import pageObjects.jobSamplesPage;

public class PageNavigation {

@Test
	public void navigationCheck() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		wait.until(ExpectedConditions.elementToBeClickable(homePage.homeLogo(driver)));
		assertTrue((homePage.homeLogo(driver).isDisplayed())); 
		assertTrue((homePage.jobs(driver).isDisplayed()));
		assertTrue((homePage.jobSeekers(driver).isDisplayed()));
		assertTrue((homePage.companies(driver).isDisplayed()));
		assertTrue((jobSamplesPage.jobSample(driver).size() > 1));


	/*
		
		navEmployers.click();
	//employers tab
		WebElement navDevelopers = driver.findElement(By.xpath(developersTab));
		wait.until(ExpectedConditions.elementToBeClickable(navDevelopers));
		WebElement employersBody = driver.findElement(By.xpath(employersSection));
		assertTrue((employersBody.isDisplayed()));
		navDevelopers.click();
	//developersTab
		WebElement navHome =  driver.findElement(By.xpath(homeTab));
		wait.until(ExpectedConditions.elementToBeClickable(navHome));
		String loginMessage = driver.findElement(By.xpath(loginText)).getText();
		System.out.println(loginMessage);
		assertEquals(loginMessage, "LOG IN TO YOUR ACCOUNT");
		WebElement signUpDev = driver.findElement(By.xpath(devSignUp));
		signUpDev.click();
		String signupMessage = driver.findElement(By.xpath(loginText)).getText();
		System.out.println(signupMessage);
		assertEquals(signupMessage, "CREATE YOUR ACCOUNT");
		//new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath(homeTab)));
		//improve this later!?!
		WebElement navHome2 =  driver.findElement(By.xpath(homeTab));
		navHome2.click();
	//home page
		driver.close();  
		
		
	*/
	}
}
