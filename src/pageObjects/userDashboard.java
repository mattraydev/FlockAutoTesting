package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userDashboard {
	
	private static WebElement element = null;
	private static List<WebElement> myElements = null;
	private static int myInt;
	private static String myString;
	
//dashboard
	public static WebElement dashboardLink(WebDriver driver){
	    element = driver.findElement(By.xpath("//*/a[@href='/developers/dashboard']"));
	    return element;
	}
//matched jobs tab
	public static WebElement matchedJobs(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/a[contains(text(), 'Matched Jobs')]"));
		return element;
	}
// applications tab
	public static WebElement applications(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/a[contains(text(), 'Applications')]"));
		return element;
	}
//job details
	public static List<WebElement> jobDetails(WebDriver driver) {
		myElements = driver.findElements(By.xpath("//*/a[contains(text(), 'Details')]"));
		return myElements;
	}
//filter select
	public static WebElement accordianFilter(WebDriver driver) {
		element = driver.findElement(By.id("filter"));
		return element;
	}
//filter accordian item
	public static WebElement benifits(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/form[@id='filter']/div[1]/div/button"));
		return element;
	}
//checkbox filters
	public static List<WebElement> benefitsCheckboxes(WebDriver driver) {
		myElements = driver.findElements(By.xpath("//*/div[@id='benefitsCollapse']/div/label/input"));
		return myElements;
	}
//first checkbox filter  (subset of the above element)
	public static WebElement firstCheckbox(WebDriver driver) {
		element = driver.findElement(By.xpath("//*/div[@id='benefitsCollapse']/div/label[1]/input"));
		return element;
	}
//list of jobs 
	public static List<WebElement> listOfJobs(WebDriver driver) {
		myElements = driver.findElements(By.xpath("//*/div[contains(@class, 'matched-jobs')]/div"));
		return myElements;
	}
//count of jobs
	public static int jobsCount(WebDriver driver) {
		myString = driver.findElement(By.xpath("//*/div[contains(@class, 'matched-jobs')]/p[2]")).getText();
		String arr[] = myString.split(" ");
		String first = arr[0];
		myInt = Integer.parseInt(first);
		return myInt;
	}
}
