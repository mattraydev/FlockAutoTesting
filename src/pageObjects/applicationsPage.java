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

}
