package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import commons.BasePage;
//import pages.Home.JobsPage;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//input[@name='user_email']")
	private WebElement email;
	@FindBy(xpath = "//p[@class='text-danger w-50 errormessage m-0']")
	private WebElement emailError;
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement password;
	@FindBy(xpath = "//p[@class='w-50 text-danger errormessage m-0']")
	private WebElement passwordError;
	@FindBy(xpath = "//div[@class='eye position-absolute cursor']")
	private WebElement eyeIcon;
	@FindBy(xpath = "//button[@name='Log In']")
	private WebElement loginButton;
	@FindBy(xpath = "//span[@class='pl-2 font_medium font_sm' and text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//button[contains(text(),'New')]")
	private WebElement newjob;
	@FindBy(xpath = "//input[@class='job-search']")
	private WebElement search;
	@FindBy(xpath="//ul[@id='layout']/a[3]")
	private WebElement jobs;
	@FindBy(css="#root > section > main > svg > path:nth-child(1)")
	private WebElement collapseButton;
	
	 SoftAssert sa = new SoftAssert();
	private static final Logger lOGGER = LogManager.getLogger(LoginPage.class.getName());

	public LoginPage(WebDriver driver) {
		super(driver);
//		PageFactory.initElements(driver, this);
	}
	
	public void doLogin(String usrname, String pwd) {
		wait.forElementToBeVisible(email);
		email.sendKeys(usrname);
		lOGGER.info("entered email :" + usrname);
		password.sendKeys(pwd);
		lOGGER.info("entered password :" + pwd);
		loginButton.click();
		lOGGER.info("Clicked on Login button");
//		click(collapseButton);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(jobs.isDisplayed());
//		sa.assertTrue(search.isDisplayed(), "Search button not displayed");
		sa.assertAll();
		lOGGER.info("Logged in succesfully...!!!");
		
	}
}