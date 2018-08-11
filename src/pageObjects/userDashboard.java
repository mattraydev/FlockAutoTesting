package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userDashboard {
	
	private static WebElement element = null;
	
	public static WebElement dashboardLink(WebDriver driver){
	    element = driver.findElement(By.xpath("//*/a[@href='/developers/dashboard']"));
	    return element;
	}

}
