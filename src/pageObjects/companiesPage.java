package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class companiesPage {
	
	private static WebElement element = null;
	private static List<WebElement> myElements = null;

//sample jobs	
	public static WebElement recruiterLogin(WebDriver driver){
		element = driver.findElement(By.xpath("//*/a[@href='/recruiters/sign_in']"));
	    return element;
	}
//recruiter sign-up
	public static List<WebElement> recruiterSignup(WebDriver driver) {
		myElements = driver.findElements(By.xpath("//*/a[@href='/recruiters/sign_up']"));
		return myElements;
	}
//contact modal
	public static WebElement contactModal(WebDriver driver){
		element = driver.findElement(By.xpath("//*/button[@data-toggle='modal']"));
		return element;
	}
	
	public static WebElement contactLink(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/div[@class='modal-body']/a"));
		return element;
	}

	public static WebElement modalClose(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/button[@class='close']"));
		return element;
	}
}
