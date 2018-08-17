package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editSkillsPage {
	
	private static WebElement element = null;
	private static List<WebElement> myElements = null;
//skills search box
	public static WebElement searchSkills(WebDriver driver){
	    element = driver.findElement(By.xpath("//*/input[@role='combobox']"));
	    return element;
	}
//list of skills
	public static List<WebElement> skillsList(WebDriver driver) {
		myElements = driver.findElements(By.xpath("//*/div[contains(@class, 'skill-form-list')]"));
		return myElements;
	}
//dropdown menu item 1 from the searchbar
	public static WebElement skillAutocomplete(WebDriver driver) {
		element = driver.findElement(By.id("rbt-menu-item-0"));
		return element;
	}
//skill level slider
	public static WebElement skillSlider(WebDriver driver) {
		element = driver.findElement(By.id("skill-level"));
		return element;
	}
// add to skills button
	public static WebElement addSkillBtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/button[contains(text(), 'Add to your skills')]"));
		return element;
	}
//remove skill button
	public static WebElement removeSkillbtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/div[contains(@class, 'skill-form-list')][last()]/button"));
		return element;
	}
//continue to dashboard button
	public static WebElement continueButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/a[contains(text(), 'Continue')]"));
		return element;
	}
}