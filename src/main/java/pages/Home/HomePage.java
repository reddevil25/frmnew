package pages.Home;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import commons.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private static final Logger log = LogManager.getLogger(HomePage.class.getName());
	@FindBy(xpath = "//ul[@id='layout']/a[3]/li")
	private WebElement jobs;
	@FindBy(xpath = "//ul[@id='layout']/a[2]/li")
	private WebElement candidates;
	@FindBy(xpath = "//ul[@id='layout']/a[4]/li")
	private WebElement settings;
	@FindBy(xpath = "//ul[@id='layout']/a[1]/li")
	private WebElement dashboard;

	
	public void verifyJobsButton() {
		click(jobs);
		log.info("clicked on jobs button");
		wait.until(ExpectedConditions.urlContains("jobs"));
		Assert.assertTrue(driver.getCurrentUrl().contains("jobs"),
				"user not navigated to jobs : current URL :" + driver.getCurrentUrl());
		log.info("jobs button working as expected user navigated to jobs page");
	}

	public void verifyCandidatesButton() {
		click(candidates);
		log.info("clicked on candidates button");
		wait.until(ExpectedConditions.urlContains("candidates"));
		Assert.assertTrue(driver.getCurrentUrl().contains("candidates"),
				"user not navigated to candidates : current URL :" + driver.getCurrentUrl());
		log.info("candidates button working as expected user navigated to candidates page");
	}

	public void verifySettingsButton() {
		click(settings);
		log.info("clicked on settings button");
		wait.until(ExpectedConditions.urlContains("account"));
		Assert.assertTrue(driver.getCurrentUrl().contains("account"),
				"user not navigated to settings : current URL :" + driver.getCurrentUrl());
		log.info("settings button working as expected user navigated to settings page");
	}
	
	public void goToJobs() {
		click(jobs);
		log.info("Navigated to jobs page");
	}
	
	public void goToCandidates() {
		click(candidates);
		log.info("Navigated to candidates page");
	}

	public void goToSettings() {
		click(settings);
		log.info("Navigated to settings page");
	}
	
	public void goToDashboard() {
		click(dashboard);
		log.info("Navigated to dashboard page");
	}
	
}
