package pages.Jobs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//import com.sun.tools.sjavac.Log;

import commons.BasePage;
import commons.Timeouts;

public class TeamMembersPage extends BasePage {

	public TeamMembersPage(WebDriver driver) {
		super(driver);
	}

	SoftAssert sa = new SoftAssert();
	private static final Logger log = LogManager.getLogger(TeamMembersPage.class.getName());
	Random rand = new Random();

	@FindBy(xpath = "//button[contains(text(),'Save Changes')]")
	private WebElement save;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alert;

	@FindBy(css = ".Toastify>div>div>button")
	private WebElement closePopup;

	@FindBy(xpath = "//button[text()='Add Team Member']")
	private WebElement addTeamMemberButton;

	@FindBy(xpath = "//div[@class=' css-2lc60i']/input")
	private WebElement searchTeamMember;

	@FindBy(xpath = "//div[@class=' css-q6iyfn']/input")
	private WebElement searchTeamMemberEdit;

	@FindBy(xpath = "//div[@class=' css-1wy0on6']")
	private WebElement teamMembersDropdown;

	@FindBy(xpath = "//div[@class=' css-1hb1tje-option']/div/div/div[2]/div[1]")
	private List<WebElement> optionsInDropdown;

	@FindBy(xpath = "//div[@class='col-9']/p[1]")
	private List<WebElement> selectedTeamMembers;

	@FindBy(xpath = "//div[@class='text-right']/button[1]")
	private WebElement addButton;

	@FindBy(xpath = "//div[@class='text-right']/button[2]")
	private WebElement cancelButton;

	@FindBy(xpath = "//div[@class='ml-lg-3 ml-2']/p")
	private List<WebElement> addedTeamMember;

	@FindBy(xpath = "//div[text()='No options']")
	private WebElement noOptions;

	@FindBy(xpath = "//li/div[3]")
	private WebElement crossButton;

	@FindBy(xpath = "//button/span[text()='Stages']")
	private WebElement stagesButton;

	@FindBy(xpath = "//button/span[text()='Social Media']")
	private WebElement socialMediaButton;
	
	@FindBy(xpath = "//li/a/div[text()='Stages']")
	private WebElement stagesTab;

	@FindBy(xpath = "//li/a/div[text()='Social Media']")
	private WebElement socialMediaTab;
		
	

	// Verify the functionality of the Add Team Member button under the team
	// section.
	// Verify an error is displayed if users click on Add button by keeping the
	// search field empty.
	// Verify a successful message is displayed after the team members are added.
	// Verify the added team members are visible on the Team page.
	public void verifyAddTeamMember() {
		click(addTeamMemberButton);
		sa.assertTrue(isDisplayed(searchTeamMember), "search field missing");
		sa.assertTrue(isDisplayed(addButton), "add button is missing");
		log.info("clicking on add button without selecting any team member to check error");
		click(addButton);
		sa.assertTrue(verifyPopup("Please add team member"), "check error text");
		String name = randomMember("");
		selectTeamMember(name);
		click(addButton);
		log.info("clicked on add button to add team member");
		sa.assertTrue(verifyPopup("Team member added"), "check success popup text");
		log.info("Added team members are : " + getTextList(addedTeamMember));
		sa.assertTrue(getTextList(addedTeamMember).contains(name), "Team members not get added ");
		sa.assertAll();
		log.info("Add team member working as expected");
	}

	// Verify the functionality of the search team member field
	// Verify that on selection the members are displayed inside the popup box
	// Verify users can remove the members from the popup using the cross button.
	public void verifySearchTeamMemberField() {
		click(addTeamMemberButton);
		log.info("clicked on add team member button");
		click(teamMembersDropdown);
		sa.assertTrue(isDisplayed(optionsInDropdown.get(0)), "Dropdown not displayed when clicked on search field");
		click(teamMembersDropdown);
		String name1 = randomMember("");
		click(teamMembersDropdown);
		String name2 = randomMember(name1);
		click(teamMembersDropdown);
		selectTeamMember(name1);
		selectTeamMember(name2);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("selected team members : " + getTextList(selectedTeamMembers));
		sa.assertTrue(getTextList(selectedTeamMembers).contains(name1), "Name 1 is missing in selected members");
		sa.assertTrue(getTextList(selectedTeamMembers).contains(name2), "Name 2 is missing in selected members");
		log.info("clicking on cross button to remove selected team member");
		click(crossButton);
		log.info("selected team members after clicking cross button : " + getTextList(selectedTeamMembers));
		sa.assertFalse(getTextList(selectedTeamMembers).contains(name1),
				"Name 1 still present in selected members even after clicking on cross button");
		sa.assertTrue(getTextList(selectedTeamMembers).contains(name2),
				"Name 2 got removed after clicking on cross button on name 1 ");
		log.info("Entering random value to check No options");
		sendKeys(searchTeamMember, "xyz123");
		sa.assertTrue(isDisplayed(noOptions), "No options not popped up");
		click(cancelButton);
		sa.assertAll();
		log.info("Search team member field working as expected");
	}

	// Verify that users can add multiple members at once.
	public void verifyUserCanAddMultipleMembersAtOnce() {
		click(addTeamMemberButton);
		log.info("clicked on add team member button");
		String name1 = randomMember("");
		click(teamMembersDropdown);
		String name2 = randomMember(name1);
		click(teamMembersDropdown);
		selectTeamMember(name1);
		selectTeamMember(name2);
		log.info("selected two team members : " + getTextList(selectedTeamMembers));
		click(addButton);
		log.info("clicked on add button ");
		log.info("Added team members are : " + getTextList(addedTeamMember));
		sa.assertTrue(getTextList(addedTeamMember).contains(name1), "Team member 1 not get added ");
		sa.assertTrue(getTextList(addedTeamMember).contains(name2), "Team member 2 not get added ");
		sa.assertAll();
		log.info("user can add multiple team member At once successfully");
	}

	// Verify users can remove the popup box by clicking outside the box.
	public void VerifyUserCanRemovePopupBoxByClickingOutsideTheBox() {
		click(addTeamMemberButton);
		log.info("clicked on add team member button");
		sa.assertTrue(isDisplayed(searchTeamMember),
				"search team member field not showed after clicking on add team member button");
		log.info("clicking outside popup box to check if it gets removed");
		click(save);
		sa.assertFalse(isDisplayed(searchTeamMember), "Popup box not got removed after clicking outsite popup box");
		sa.assertAll();
		log.info("users can remove the popup box by clicking outside the box successfully");
	}

	// Verify users cannot add the same team members again.
	public void VerifyUserCanNotAddSameTeamMembersAgain() {
		click(addTeamMemberButton);
		log.info("clicked on add team member button");
		String name1 = randomMember("");
		click(teamMembersDropdown);
		selectTeamMember(name1);
		log.info("Trying to select same team member again to check error ");
		click(teamMembersDropdown);
		selectTeamMember(name1);
		sa.assertTrue(verifyPopup("Team member already added."),
				"check error text while selecting arledy selected team member");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(addButton);
	/*	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		click(closePopup);
		log.info("Added team members are : " + getTextList(addedTeamMember));
		click(addTeamMemberButton);
		log.info("clicked on add team member button again to try adding already added team member");
		click(teamMembersDropdown);
		selectTeamMember(name1);
		sa.assertTrue(verifyPopup("Team member already added."),
				"check error text while selecting arledy added team member");
		click(cancelButton);
		sa.assertAll();
		log.info("users cannot add the same team members again");
	}

//	Verify the functionality of the delete option on the team page.
	public void VerifyDeleteOptionOnTeamPage() {
		click(addTeamMemberButton);
		log.info("clicked on add team member button");
		String name1 = randomMember("");
		click(teamMembersDropdown);
		String name2 = randomMember(name1);
		click(teamMembersDropdown);
		selectTeamMember(name1);
		selectTeamMember(name2);
		log.info("selected two team members : " + getTextList(selectedTeamMembers));
		click(addButton);
		log.info("clicked on add button ");
		click(closePopup);
		log.info("trying to delete team memeber : " + name1);
		By byDelete = By
				.xpath("//p[text()='" + name1 + "']/parent::div/parent::div/following-sibling::div[@id='Delete']");
		click(driver.findElement(byDelete));
		sa.assertTrue(verifyPopup("Team member removed"), "check popup text when team member is removed");
		sa.assertFalse(getTextList(addedTeamMember).contains(name1), name1 + " member did not get delete");
		sa.assertTrue(getTextList(addedTeamMember).contains(name2),
				name2 + " member get delete while deleting " + name1);
		log.info("Team members after delete are : " + getTextList(addedTeamMember));
		sa.assertAll();
		log.info("User can delete team member successfully");

	}

	public void verifySocialMediaButton() {
		log.info("clicking on social media button");
		click(socialMediaButton);
		Assert.assertTrue(driver.getCurrentUrl().contains("social-media"), "Not navigated to social media page");
		log.info("social media button working as expexted");
	}
	
	public void verifySocialMediaTab() {
		log.info("clicking on social media tab");
		click(socialMediaTab);
		Assert.assertTrue(driver.getCurrentUrl().contains("social-media"), "Not navigated to social media page");
		log.info("social media Tab working as expexted");
	}
	
	public void verifyStagesButton() {
		log.info("clicking on Stages button");
		click(stagesButton);
		Assert.assertTrue(driver.getCurrentUrl().contains("work-flow"), "Not navigated to Stages page");
		log.info("Stages button working as expexted");
	}
	
	public void verifyStagesTab() {
		log.info("clicking on Stages tab");
		click(stagesTab);
		Assert.assertTrue(driver.getCurrentUrl().contains("work-flow"), "Not navigated to Stages page");
		log.info("Stages Tab working as expexted");
	}

	///////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	public void selectTeamMember(String name) {
//		click(addTeamMemberButton);
		log.info("clicked on add team member button");
		sendKeys(searchTeamMember, name);
		String fname = name.substring(0, name.indexOf(" "));
		String lname = name.substring(name.indexOf(" ") + 1);

		By nameBy = By.xpath("//div[@class=' css-1hb1tje-option']/div/div/div[2]/div[1][text()='" + fname
				+ "'][text()='" + lname + "']");
		click(wait.forElementToBeVisible(driver.findElement(nameBy)));
//		searchTeamMember.sendKeys(Keys.ENTER);
//		sendKeys(searchTeamMember, Keys.ENTER);
	/*	try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		log.info("Selected team member : " + name);
	}

	public boolean verifyPopup(String expectedText) {
		boolean flag = false;
		log.info("Text present in popup :" + getText(alert));
		if (getText(alert).contains(expectedText))
			flag = true;
		click(closePopup);
		return flag;
	}

	public String randomMember(String name) {
		String teamMember = "";
		click(teamMembersDropdown);
		List<String> options = getTextList(optionsInDropdown);
		log.info("options available : " + options);
		int index = 0;
		teamMember = options.get(rand.nextInt(options.size()));
		while (name.equalsIgnoreCase(teamMember)) {
			teamMember = options.get(index);
			index++;
		}
//		click(teamMembersDropdown);
		return teamMember;
	}

}
