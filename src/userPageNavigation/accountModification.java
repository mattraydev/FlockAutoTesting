package userPageNavigation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.developersSignin;
import pageObjects.editProfilePage;
import pageObjects.editSkillsPage;
import pageObjects.homePage;
import pageObjects.userDashboard;
import pageObjects.userProfile;
import utility.constant;

public class accountModification {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static int skillsCount;
	public static String fullName;
	
	@Test
	public void userLogin() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckoDriver\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    wait = new WebDriverWait(driver, 10);
	    driver.get(constant.url);
	    
	    wait.until(ExpectedConditions.elementToBeClickable(homePage.loginButton(driver)));
	    homePage.loginButton(driver).click();
	    wait.until(ExpectedConditions.elementToBeClickable(developersSignin.emailInput(driver)));
	    developersSignin.emailInput(driver).click();
	    developersSignin.emailInput(driver).sendKeys(constant.accountEmail);
	    developersSignin.passwordInput(driver).click();
	    developersSignin.passwordInput(driver).sendKeys(constant.accountPassword);
	    developersSignin.signinSubmit(driver).click();  
	}
	
	@Test (dependsOnMethods= {"userLogin"})
	public void userDashboard() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(userDashboard.dashboardLink(driver)));
		userDashboard.userSettings(driver).click();
		userDashboard.devProfile(driver).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(userProfile.profileImage(driver)));
		fullName = userProfile.profileName(driver).getText();
		System.out.println(fullName);
		assertEquals(fullName, constant.userFullName);
		
		assertTrue((userProfile.githubLink(driver).isDisplayed()));
		System.out.println(userProfile.githubLink(driver).getAttribute("href"));
		assertEquals(userProfile.githubLink(driver).getAttribute("href"), constant.fullGithubUrl);

		assertTrue((userProfile.linkedinLink(driver).isDisplayed()));
		System.out.println(userProfile.linkedinLink(driver).getAttribute("href"));
		assertEquals(userProfile.linkedinLink(driver).getAttribute("href"), constant.fullLinkedinUrl);
		
		assertTrue((userProfile.profileAddress(driver).isDisplayed()));
		Iterator<WebElement> iteration = userProfile.skills(driver).iterator();
		while(iteration.hasNext()) {
		    WebElement item = iteration.next();
		    assertTrue((item).isDisplayed());
		}
		skillsCount = userProfile.skillsCount(driver);
		System.out.println(skillsCount);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userProfile.editButton(driver));
		userProfile.editButton(driver).click();
	}
	
	@Test (dependsOnMethods = {"userDashboard"})
	public void editProfile() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(userDashboard.dashboardLink(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(editProfilePage.inputFirstName(driver)));
		editProfilePage.inputFirstName(driver).click();
		editProfilePage.inputFirstName(driver).clear();
		editProfilePage.inputFirstName(driver).sendKeys("Matthew");
		editProfilePage.inputLastName(driver).click();
		editProfilePage.inputLastName(driver).clear();
		editProfilePage.inputLastName(driver).sendKeys("Ray");
		wait.until(ExpectedConditions.elementToBeClickable(editProfilePage.profileAvatar(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(editProfilePage.profileResume(driver)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editProfilePage.githubInput(driver));
		editProfilePage.linkedinInput(driver).click();
		editProfilePage.linkedinInput(driver).clear();
		editProfilePage.linkedinInput(driver).sendKeys(constant.userLinkedIn);
		editProfilePage.githubInput(driver).click();
		editProfilePage.githubInput(driver).clear();
		editProfilePage.githubInput(driver).sendKeys(constant.userGithub);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editProfilePage.continueButton(driver));
		editProfilePage.continueButton(driver).click();
		Thread.sleep(3000);  //fix this later, page load time was slow
	}
	
	@Test (dependsOnMethods = {"editProfile"})
	public void editSkills() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(editSkillsPage.searchSkills(driver)));
		assertTrue((editSkillsPage.skillsList(driver).size() == skillsCount));
		
		editSkillsPage.searchSkills(driver).click();
		editSkillsPage.searchSkills(driver).sendKeys(constant.skillsSearchWord);
		wait.until(ExpectedConditions.elementToBeClickable(editSkillsPage.skillAutocomplete(driver)));
		editSkillsPage.skillAutocomplete(driver).click();
		assertTrue((editSkillsPage.skillSlider(driver).isDisplayed()));
		editSkillsPage.addSkillBtn(driver).click();
		
		assertTrue((editSkillsPage.skillsList(driver).size() == (skillsCount +1)));
		Thread.sleep(500);
		editSkillsPage.removeSkillbtn(driver).click();
		
		assertTrue((editSkillsPage.skillsList(driver).size() == skillsCount));
		editSkillsPage.continueButton(driver).click();
	}
	
	@Test (dependsOnMethods = {"editSkills"})
	public void verifyEdits() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(userDashboard.dashboardLink(driver)));
		userDashboard.userSettings(driver).click();
		userDashboard.devProfile(driver).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(userProfile.profileImage(driver)));
		fullName = userProfile.profileName(driver).getText();
		System.out.println(fullName);
		assertEquals(fullName, constant.userFullName);
		
		assertTrue((userProfile.githubLink(driver).isDisplayed()));
		System.out.println(userProfile.githubLink(driver).getAttribute("href"));
		assertEquals(userProfile.githubLink(driver).getAttribute("href"), constant.fullGithubUrl);

		assertTrue((userProfile.linkedinLink(driver).isDisplayed()));
		System.out.println(userProfile.linkedinLink(driver).getAttribute("href"));
		assertEquals(userProfile.linkedinLink(driver).getAttribute("href"), constant.fullLinkedinUrl);
		
		assertTrue((userProfile.profileAddress(driver).isDisplayed()));
		assertTrue((userProfile.skills(driver).size() == skillsCount));
		userDashboard.userSettings(driver).click();
		userDashboard.logoutButton(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.homeLogo(driver)));
		driver.close();
	}
}
