package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editProfilePage {
	
	private static WebElement element = null;
	
//first name input field
	public static WebElement inputFirstName(WebDriver driver){
	    element = driver.findElement(By.id("developer_first_name"));
	    return element;
	}
// last name input field
	public static WebElement inputLastName(WebDriver driver) {
		element = driver.findElement(By.id("developer_last_name"));
		return element;
	}
//upload profile image
	public static WebElement profileAvatar(WebDriver driver) {
		element = driver.findElement(By.id("developer_avatar"));
		return element;
	}
// profile resume
	public static WebElement profileResume(WebDriver driver) {
		element = driver.findElement(By.id("developer_resumes"));
		return element;
	}
// linkedIn input field
	public static WebElement linkedinInput(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/input[@name='developer[linkedin_url]']"));
		return element;
	}
// github input field
	public static WebElement githubInput(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/input[@name='developer[github_url]']"));
		return element;
	}
//continue button
	public static WebElement continueButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/input[@name='commit']"));
		return element;
	}
}