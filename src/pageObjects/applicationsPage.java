package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class applicationsPage {
	
	private static WebElement element = null;
	
	public static WebElement applicationForm(WebDriver driver){
	    element = driver.findElement(By.id("new_application"));
	    return element;
	}
	
	public static WebElement uploadButton(WebDriver driver) {
		element = driver.findElement(By.id("application_developer_resumes"));
		return element;
	}
	
	public static WebElement sendApplicationButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/form[@id='new_application']/input[@type='submit']"));
		return element;
	}
	
	public static WebElement backButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/a[contains(text(), '< Back')]"));
		return element;
	}
}
