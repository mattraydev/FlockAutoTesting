package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class developersSignin {

	private static WebElement element = null;
	
	public static WebElement signinBox(WebDriver driver){
	    element = driver.findElement(By.cssSelector("div.auth-form"));
	    return element;
	}
	
	public static WebElement developerSignup(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/li/a[@href='/developers/sign_up']"));
		return element;
	}
	public static WebElement recruiterSignUp(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/a[@href='/recruiters/sign_up']"));
		return element;
	}
	
	public static WebElement emailInput(WebDriver driver) {
		element = driver.findElement(By.id("developer_email"));
		return element;
	}
	
	public static WebElement passwordInput(WebDriver driver) {
		element = driver.findElement(By.id("developer_password"));
		return element;
	}
	
	public static WebElement signinSubmit(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/input[@type='submit']"));
		return element;
	}
}