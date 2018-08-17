package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userProfile {
	
	private static WebElement element = null;
	private static List<WebElement> myElements = null;
	private static int myInt;
//profile image
	public static WebElement profileImage(WebDriver driver){
	    element = driver.findElement(By.xpath("//*/div[contains(@class, 'avatar-lg')]/img"));
	    return element;
	}
//profile User name
	public static WebElement profileName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/div[contains(@class, 'user-info')]/h5"));
		return element;
	}
//profile github link
	public static WebElement githubLink(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/div[contains(@class, 'user-info')]/a[contains(@href, 'github')]"));
		return element;
	}
//profile linkedIn link
	public static WebElement linkedinLink(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/div[contains(@class, 'user-info')]/a[contains(@href, 'linkedin')]"));
		return element;
	}
//profile address
	public static WebElement profileAddress(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/div[contains(@class, 'user-info')]/p"));
		return element;
	}
//skills list
	public static List<WebElement> skills(WebDriver driver) {
		myElements = driver.findElements(By.xpath("//*/table[1]/tbody/tr"));
		return myElements;
	}
//skills number
	public static int skillsCount(WebDriver driver) {
		myInt = driver.findElements(By.xpath("//*/table[1]/tbody/tr")).size();
		return myInt;
	}
//edit button
	public static WebElement editButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/a[contains(@class, 'btn') and contains(text() ,'Edit')]"));
		return element;
	}
}