package pages.Jobs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import commons.BasePage;

public class SocialMediaPage extends BasePage {

	public SocialMediaPage(WebDriver driver) {
		super(driver);
	}

	SoftAssert sa = new SoftAssert();
	private static final Logger log = LogManager.getLogger(SocialMediaPage.class.getName());

	@FindBy(xpath = "//div[3]/div/input[1]")
	private WebElement title;
	@FindBy(xpath = "//*[@id='tinymce']/p")
	private WebElement description;
	@FindBy(xpath = "//input[@type='file']/following-sibling::label")
	private WebElement uploadImageButton;
	@FindBy(xpath = "//div[@class='w-100']/img")
	private WebElement image;
	@FindBy(xpath = "//input[@type='file']/following-sibling::span")
	private WebElement deleteImage;
	@FindBy(xpath = "//iframe[@title='Rich Text Area']")
	private WebElement descriptionFrame;
	@FindBy(xpath = "//ul[@class='navbar-nav']/li[4]/a")
	private WebElement teamAtTop;
	@FindBy(xpath = "//span[contains(text(),'Team')]/parent::button")
	private WebElement teamAtBottom;
	@FindBy(xpath = "//*[text()='Team Members']")
	private WebElement teamMembers;

	public void verifyTitle() {
		wait.forElementToBeVisible(title);
		sendKeys(title, "This is xyz");
		log.info("Entering title as This is xyz");
		Assert.assertEquals(title.getAttribute("value"), "This is xyz");
		log.info("Entered title as : " + title.getAttribute("value"));
	}

	public void verifyDescription() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
		sendKeys(description, "This is abcd");
		log.info("Entering description as This is abcd");
		Assert.assertEquals(description.getText(), "This is abcd");
		log.info("Entered description as : " + description.getText());
		driver.switchTo().parentFrame();
	}

	public void verifyuploadImageButton() {
		SoftAssert sa = new SoftAssert();
		click(uploadImageButton);
		String imagePath = System.getProperty("user.dir") + "\\src\\test\\resources\\SocialMediaImage.jpg";
		int ExitValue = uploadFile(imagePath);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				log.info(image.getAttribute("src"));
		sa.assertTrue(!image.getAttribute("src").contains("no-image"),"Image url "+image.getAttribute("src"));
		sa.assertTrue(deleteImage.isDisplayed(),"Delete image button");
		sa.assertAll();
		log.info("Image uploaded successfully");
	}

	public void verifyDeleteImageButton() {
		//SoftAssert sa = new SoftAssert();
		wait.forElementToBeVisible(uploadImageButton);
		uploadImageButton.click();
		String imagePath = System.getProperty("user.dir") + "\\src\\test\\resources\\SocialMediaImage.jpg";
		uploadFile(imagePath);
	/*	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		click(deleteImage);
		wait.until(ExpectedConditions.attributeContains(image, "src", "/static/media/upload_img.928c9b10.png"));
		log.info(image.getAttribute("src"));

		Assert.assertTrue(image.getAttribute("src").contains("upload_img"));
//		sa.assertTrue(deleteImage.isDisplayed());
	//	sa.assertAll();
		log.info("Image uploaded successfully");
	}

	public void verifyTeamButtonAtTop() {
		wait.forElementToBeVisible(teamAtTop);
		click(teamAtTop);
		wait.forElementToBeVisible(teamMembers);
		Assert.assertTrue(driver.getCurrentUrl().contains("team"),
				"user not navigate to Team page, current url : "+driver.getCurrentUrl());
		log.info("Team button at top working as expected");
	}

	public void verifyTeamButtonAtBottom() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.forElementToBeVisible(teamAtBottom);
		click(teamAtBottom);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.forElementToBeVisible(teamMembers);
		Assert.assertTrue(driver.getCurrentUrl().contains("team"),
				"user not navigate to Team page, current url : "+driver.getCurrentUrl());
		log.info("Team button at bottom working as expected");
	}


}
