package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {

	private static WebElement element = null;
	private static int num = 0;
//flock home logo
	public static WebElement homeLogo(WebDriver driver){
	    element = driver.findElement(By.id("Logo"));
	    return element;
	}
//navbar jobs tab
	public static WebElement jobs(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/a[@href='/jobsamples']"));
		return element;
	}
//navbar job seekers tab
	public static WebElement jobSeekers(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/li/a[@href='/developers/sign_in']"));
		return element;
	}
//navbar companies tab
	public static WebElement companies(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/a[@href='/pages/pricing']"));
		return element;
	}
//join button in middle
	public static WebElement joinButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/ul/a[@href='/developers/sign_up']"));
		return element;
	}
//login button in middle
	public static WebElement loginButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/ul/a[@href='/developers/sign_in']"));
		return element;
	}
//bottom body section
	public static int homepageBodySections(WebDriver driver) {
		num = driver.findElements(By.xpath("//*/main/div")).size();
		return num;
	}
//footer social buttons
	public static WebElement socialIcons(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/a[@class='social-icon']"));
		return element;
	}
}