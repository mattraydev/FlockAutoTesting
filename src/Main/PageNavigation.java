package Main;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageNavigation {

@Test
	public void navigationCheck() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String loginBtn = "//*/ul/a[@href='/developers/sign_in']";
		String jobsTab = "//*/a[@href='/jobsamples']";
		String employersTab = "//*/a[@href='/pages/pricing']";
		String jobsSection = "//*/div[@class='job-samples-page']";
		String developersTab = "//*/a[@href='/developers/sign_in']";
		String employersSection = "//*/main/div[@class='container']";
		String homeTab = "//*[@id='NavContent']/a[@href='/']";
		String devSignUp = "//*/main/*//a[@href='/developers/sign_up']";
		String loginText = "//*/div[@class='login-form']/h4";
		
	//landing page
		driver.get("https://www.findmyflock.com/");
	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    WebElement login = driver.findElement(By.xpath(loginBtn));
		wait.until(ExpectedConditions.elementToBeClickable(login));
		WebElement jobs = driver.findElement(By.xpath(jobsTab));
		jobs.click();
	//jobs page
		WebElement navEmployers = driver.findElement(By.xpath(employersTab));
		wait.until(ExpectedConditions.elementToBeClickable(navEmployers));
		WebElement jobsPageBody = driver.findElement(By.xpath(jobsSection));
		assertTrue((jobsPageBody.isDisplayed()));
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
	}
}
