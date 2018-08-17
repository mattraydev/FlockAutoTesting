package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class applicationsPage {
	
	private static WebElement element = null;
//mesage to job for application	
	public static WebElement applicationForm(WebDriver driver){
	    element = driver.findElement(By.id("new_application"));
	    return element;
	}
//upload resume button
	public static WebElement uploadButton(WebDriver driver) {
		element = driver.findElement(By.id("application_developer_resumes"));
		return element;
	}
//submit application button
	public static WebElement sendApplicationButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/form[@id='new_application']/input[@type='submit']"));
		return element;
	}
//back button
	public static WebElement backButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/a[contains(text(), '< Back')]"));
		return element;
	}
}