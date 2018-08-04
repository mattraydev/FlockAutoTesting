package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class jobSamplesPage {
	
	private static List<WebElement> myElements = null;

//sample jobs	
	public static List<WebElement> jobSample(WebDriver driver){
		myElements = driver.findElements(By.cssSelector("div.job-sample"));
	    //element = driver.findElement(By.cssSelector("div.job-sample"));
	    return myElements;
	}
	
	
	
}
