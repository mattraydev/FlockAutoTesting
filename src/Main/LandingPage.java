package Main;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

@Test
public void landingPageTest() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		
		String home = "//*/div[@id='NavContent']/a/img[@id='Logo']";
		String navigation = "//*/div[@id='NavContent']/*/ul";
		String joinBtn = "//*/ul/a[@href='/developers/sign_up']";
		String loginBtn = "//*/ul/a[@href='/developers/sign_in']";
		String lastSection = "//*/div[@class='main-body']/main/div[last()]";
		String footerBar = "//*/div[@class='footer']/ul/div/li/a";
	
	    driver.get("https://www.findmyflock.com/");
	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    WebElement login = driver.findElement(By.xpath(loginBtn));
		wait.until(ExpectedConditions.elementToBeClickable(login));
	
	//verify nav bar elemetns
	    WebElement homeLogo = driver.findElement(By.xpath(home));
	    assertTrue((homeLogo.isDisplayed())); 
	    WebElement mainNav = driver.findElement(By.xpath(navigation));
	    assertTrue((mainNav.isDisplayed())); 
	    WebElement join = driver.findElement(By.xpath(joinBtn));
	    assertTrue((join.isDisplayed()));
	    String joinText = driver.findElement(By.xpath(joinBtn)).getText();
	    assertEquals(joinText,"JOIN");
	    assertTrue((login.isDisplayed())); 
	    String loginText = driver.findElement(By.xpath(loginBtn)).getText();
	    assertEquals(loginText,"LOGIN");
	//page scroll
	    WebElement testamonials = driver.findElement(By.xpath(lastSection));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", testamonials);
	    WebElement footer = driver.findElement(By.xpath(footerBar));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
	// verify bottom links
	    int social = driver.findElements(By.xpath(footerBar)).size();
	    assertTrue(social == 6);
	    driver.close();  
	}

}
