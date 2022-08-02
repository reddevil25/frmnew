package pages.Jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
//import com.sun.tools.sjavac.Log;

import PojoClasses.JobPostingPojo;
import commons.BasePage;
import pages.Home.JobsPage;

public class CreateNewJobPage extends BasePage {

	public CreateNewJobPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

//	HomePage hp = new HomePage(driver);
//	JobsPage jp = new JobsPage(driver);

	SoftAssert sa = new SoftAssert();
	Faker fake = new Faker(new Locale("en-IND"));
	Random rand = new Random();
	@FindBy(xpath = "//div[text()='No options']")
	private WebElement noOptions;
	@FindBy(xpath = "//ul[@id='layout']/a[3]")
	private WebElement jobs;
	@FindBy(xpath = "//div/div[1]/div[1]/ul/li[1]")
	private WebElement published;
	@FindBy(xpath = "//div[@data-job_id]")
	private List<WebElement> allIdsOnPage;
	@FindBy(xpath = "//button[contains(text(),'New')]")
	private WebElement newjob;
	@FindBy(xpath = "//span[contains(text(),'Job')]")
	private WebElement CreateNewJobHeading;

	// Job Title WebElements
	@FindBy(xpath = "//*[text()='Job Title']/following-sibling::input")
	private WebElement jobTitle;
	@FindBy(xpath = "(//*[@class=\"mb-0 py-1 text-danger font_tiny font_medium\"])[1]")
	private WebElement jobTitleError;

	// Department WebElements
	@FindBy(xpath = "//*[text()='Department']/following-sibling::div/div/div/div[2]/input")
	private WebElement dept;
	@FindBy(xpath = "(//*[@class=' css-1wy0on6'])[1]")
	private WebElement deptDropdown;
	@FindBy(xpath = "(//*[@class=\"mb-0 py-1 text-danger font_tiny font_medium\"])[2]")
	private WebElement deptError;

	// Tags WebElements
	@FindBy(xpath = "//span[@class='custom-width1 font_sm font_semibold' and text()='Tags:']/parent::div//div[@class='col-auto d-flex align-items-center']/span")
	private WebElement addTagsButton;
	@FindBy(xpath = "//div[@class='d-inline position-relative']/input[@type='text']")
	private WebElement tagsInputBox;
	@FindBy(xpath = "//span[@class='custom-width1 font_sm font_semibold' and text()='Tags:']/following-sibling::div/div")
	private List<WebElement> tagsAdded;
	@FindBy(css = "div.ml-2.d-flex.align-items-center > svg")
	private WebElement removeTags;
	
	//Skills WebElements
	@FindBy(xpath = "//span[@class='custom-width1 font_sm font_semibold' and text()='Skills:']/following-sibling::div/span")
	private WebElement addSkillsButton;
	@FindBy(xpath = "//span[@class='custom-width1 font_sm font_semibold' and text()='Skills:']/following-sibling::div/span/div/input")
	private WebElement skillsInputBox;
	@FindBy(xpath = "//span[@class='custom-width1 font_sm font_semibold' and text()='Skills:']//parent::div/div/div")
	private List<WebElement> SkillsAdded;
	@FindBy(xpath = "//div[@class='ml-2 d-flex align-items-center']")
	private WebElement removeSkills;
	
	// Job Description and Job Requirement webelements
	@FindBy(xpath = "//body[@id='tinymce']/p")
	private WebElement textArea;
	@FindBy(xpath = "(//*[@class='mb-0 my-1 text-danger font_tiny font_medium'])[1]")
	private WebElement jobDescError;
	@FindBy(xpath = "(//*[@class='mb-0 my-1 text-danger font_tiny font_medium'])[2]")
	private WebElement jobReqError;

	// country webelements
	@FindBy(xpath = "//*[text()='Country']/following-sibling::div/div/div/div[2]/input")
	private WebElement country;
	@FindBy(xpath = "(//*[@class=' css-1wy0on6'])[2]")
	private WebElement countryDropdown;
	@FindBy(xpath = "(//*[@class='mb-0 my-1 text-danger font_tiny font_medium'])[3]")
	private WebElement countryError;

	// state webelements
	@FindBy(xpath = "//*[text()='State']/following-sibling::div/div/div/div[2]/input")
	private WebElement state;
	@FindBy(xpath = "(//*[@class=' css-1wy0on6'])[3]")
	private WebElement stateDropdown;
	@FindBy(xpath = "(//*[@class='mb-0 my-1 text-danger font_tiny font_medium'])[4]")
	private WebElement stateError;

	// city webelements
	@FindBy(xpath = "//*[text()='City']/following-sibling::input")
	private WebElement city;
	@FindBy(xpath = "(//*[@class='mb-0 my-1 text-danger font_tiny font_medium'])[5]")
	private WebElement cityError;

	// pincode webelements
	@FindBy(xpath = "//*[text()='Pincode']/following-sibling::input")
	private WebElement pincode;
	@FindBy(xpath = "(//*[@class='mb-0 my-1 text-danger font_tiny font_medium'])[6]")
	private WebElement pincodeError;

	// job type webelements
	@FindBy(xpath = "//*[text()='Job Type']/following-sibling::div/div/div/div[2]/input")
	private WebElement jobType;
	@FindBy(xpath = "(//*[@class=' css-1wy0on6'])[4]")
	private WebElement jobTypeDropdown;
	@FindBy(xpath = "(//*[@class='mb-0 my-1 text-danger font_tiny font_medium'])[7]")
	private WebElement jobTypeError;

	// category webelements
	@FindBy(xpath = "//*[text()='Category']/following-sibling::div/div/div/div[2]/input")
	private WebElement empCategory;
	@FindBy(xpath = "(//*[@class=' css-1wy0on6'])[5]")
	private WebElement empCategoryDropdown;
	@FindBy(xpath = "(//*[@class='mb-0 my-1 text-danger font_tiny font_medium'])[8]")
	private WebElement empCategoryError;

	// education webelements
	@FindBy(xpath = "//*[text()='Education']/following-sibling::div/div/div/div[2]/input")
	private WebElement education;
	@FindBy(xpath = "(//*[@class=' css-1wy0on6'])[6]")
	private WebElement educationDropdown;
	@FindBy(xpath = "(//*[@class='mb-0 my-1 text-danger font_tiny font_medium'])[9]")
	private WebElement educationError;

	// experience webelements
	@FindBy(xpath = "//*[text()='Experience']/following-sibling::input")
	private WebElement experience;
	@FindBy(xpath = "(//*[@class='mb-0 my-1 text-danger font_tiny font_medium'])[10]")
	private WebElement experienceError;

	// remote toggle webelements
	@FindBy(xpath = "//input[@name='is_remote']/preceding-sibling::div[2]/div[1]")
	private WebElement remote;
	@FindBy(xpath = "//input[@name='is_remote']/parent::div")
	private WebElement remotecheck;

	// hours per week webelements
	@FindBy(xpath = "(//input[@type='number'])[2]") // *[contains(text(),'Week')]/parent::div/div/p[1]/input
	private WebElement minhour;
	@FindBy(xpath = "(//input[@type='number'])[3]")
	private WebElement maxhour;
	@FindBy(xpath = "//*[@class='d-block mb-0 my-1 text-danger font_tiny font_medium']")
	private WebElement hoursPerWeekError;

	@FindBy(xpath = "//p[contains(text(),'equired')]")
	private List<WebElement> error;
	@FindBy(xpath = "//button[contains(text(),'Save Changes')]")
	private WebElement save;
	@FindBy(xpath = "//button[@class='position-absolute font_medium text-charcoal button_py px-2 text-center']")
	private WebElement saveAndPublish;
	@FindBy(xpath = "//span[@class='px-2 border-left button_py cursor']")
	private WebElement saveArrow;

	@FindBy(xpath = "//a/button[@type='submit']")
	private WebElement applicationFormButton;
	@FindBy(xpath = "//div[contains(text(),'Questions')]")
	private WebElement screeningque;
	@FindBy(xpath = "//*[@id='navbarNavDropdown']/ul/li[3]/a/span")
	private WebElement workflow;
	@FindBy(xpath = "//input[@type='date']")
	private WebElement expiryDate;
	@FindBy(xpath = "//div/ul/li[2]/a")
	private WebElement applicationFormTab;
	@FindBy(css = ".Toastify>div>div>button")
	private WebElement closeError;
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alert;
	@FindBy(css = ".Toastify>div>div>button")
	private WebElement closePopup;

	private static final Logger log = LogManager.getLogger(CreateNewJobPage.class.getName());

//	Verify the functionality of the Job title field on the create job page.
//	Verify an error message is displayed if Job title field is left empty.
	public void verifyJobTitle(String title) {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(jobTitleError), "Job Title is required", "check error text when field left empty");
		setTextBox("Job Title", jobTitle, title);
		clickSave();
		sa.assertTrue(getText(jobTitleError).isEmpty(), "Error still present even after entering value in Title field");
		sa.assertAll();
		log.info("Job title field working as expected");
	}

//	// Verify the functionality of the created job title.
//	public String verifyJobTitleOnCreatedJobCard() {
//
//		JobPostingPojo job = createNewJob("create");
//		log.info("created job ");
//		hp.goToJobs();
//		jp.goToDraftjobs();
//		By byTitleOnCard = By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div/div/div[1]");
//		String titleOnCard = getText(driver.findElement(byTitleOnCard));
//		log.info("checking job title present on card :" + titleOnCard);
//		Assert.assertEquals(titleOnCard, job.getJob_title(), "Wrong job Title is present on card ");
//		log.info("job title present on card of created job");
//		return job.getJob_id();
//	}

	// Verify the dropdown menu displays all the list of departments.
	// Verify error message is displayed when the Department field is not selected.
	// Verify the selected department appears in the department field.
	// Verify users are able to search, update the department's name using the
	// keyboard.
	public void verifyDepartment(String dept1, String dept2, String dept3) { // method to select department
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(deptError), "Job Department is required", "check error text when field left empty");
		log.info("clicking on dropdown to check if dropdown displays");
		click(deptDropdown);
		List<String> opts = getAllOptionsPresent("Department");
		log.info("Options present in dropdown : " + opts);
		sa.assertTrue(opts.contains(dept1), dept1 + " not present in department dropdown");
		sa.assertTrue(opts.contains(dept2), dept2 + " not present in department dropdown");
		sa.assertTrue(opts.contains(dept3), dept3 + " not present in department dropdown");
		setDropDownWithTextBox("Department", dept, dept1);
		clickSave();
		sa.assertEquals(getDropDownValue("Department"), dept1,
				"selected department Not appeared in the department field.");
		sa.assertTrue(getText(deptError).isEmpty(),
				"Error still present even after entering value in Department field");
		log.info("updating department value using keyboard");
		setDropDownWithTextBox("Department", dept, dept2);
		clickSave();
		sa.assertEquals(getDropDownValue("Department"), dept2,
				"updated department Not appeared in the department field.");
		log.info("Entering random value to check No options suggestion");
		sendKeys(dept, "xyz123");
		sa.assertTrue(isDisplayed(noOptions), "No Options suggestion did not show up even after entering random value");
		sa.assertAll();
		log.info("Department field working as expected");
	}

//	Verify the functionality of the Tag button.
//	Verify that the user can add multiple tags through the Tag button
//	Verify that the tag gets created on pressing enter after adding any input.
//	Verify that the tag gets created by clicking outside the tags box after adding any input.
//	Verify that the tag is removed after clicking on the cross button.
//	Verify the tag box gets closed when users click outside the box.
	public void verifyAddTags(JobPostingPojo job) { // method to add tags

		click(addTagsButton);
		log.info("clicked on Add tags button");
		sa.assertTrue(isDisplayed(tagsInputBox), "text box to enter tags not displayed");
		sendKeys(tagsInputBox, job.getJob_tag().get(0));
		log.info("Pressing Enter button to check if tags get added");
	//	sendKeys(tagsInputBox, Keys.ENTER);
		new Actions(driver).sendKeys(tagsInputBox, Keys.ENTER).perform();
	//	tagsInputBox.sendKeys(Keys.ENTER);
		log.info("Tags present after pressing Enter button : " + getTextList(tagsAdded));
		sa.assertTrue(getTextList(tagsAdded).contains(job.getJob_tag().get(0)),
				"Tag not got added after pressing Enter");
		sendKeys(tagsInputBox, job.getJob_tag().get(1));
		log.info("clicking outside to check if tag gets added and tags box gets closed");
		click(jobTitle);
		log.info("Tags present after clicking outside tags Box : " + getTextList(tagsAdded));
		sa.assertTrue(getTextList(tagsAdded).contains(job.getJob_tag().get(1)),
				"Tag not after clicking outside tags box");
		sa.assertFalse(isDisplayed(tagsInputBox), "Tags box did not get close after clicking outside tags box");
		log.info("clicking on cross button to remove first tag added");
		click(removeTags);
		log.info("Tags present after clicking cross Button : " + getTextList(tagsAdded));
		sa.assertFalse(getTextList(tagsAdded).contains(job.getJob_tag().get(0)),
				"Tag not got removed after clicking on cross button");
		sa.assertTrue(getTextList(tagsAdded).contains(job.getJob_tag().get(1)),
				"All Tags not got removed after clicking on cross button");
		sa.assertAll();
		log.info("Tags field working as expected");

	}
	
	public void verifyAddSkills() {
		click(addSkillsButton);
		log.info("clicked on Add skills button");
		sa.assertTrue(isDisplayed(skillsInputBox), "text box to enter skills not displayed");
		sendKeys(skillsInputBox, "skill 1");
		log.info("Pressing Enter button to check if skill get added");
	//	sendKeys(tagsInputBox, Keys.ENTER);
		new Actions(driver).sendKeys(skillsInputBox, Keys.ENTER).perform();
	//	tagsInputBox.sendKeys(Keys.ENTER);
		log.info("Skills present after pressing Enter button : " + getTextList(SkillsAdded));
		sa.assertTrue(getTextList(SkillsAdded).contains("skill 1"),
				"Skill not got added after pressing Enter");
		sendKeys(skillsInputBox, "skill 2");
		log.info("clicking outside to check if skill gets added and skill box gets closed");
		click(jobTitle);
		log.info("Skills present after clicking outside tags Box : " + getTextList(SkillsAdded));
		sa.assertTrue(getTextList(SkillsAdded).contains("skill 2"),
				"Skill not after clicking outside tags box");
		sa.assertFalse(isDisplayed(skillsInputBox), "Skills box did not get close after clicking outside Skills box");
		log.info("clicking on cross button to remove first skill added");
		click(removeSkills);
		log.info("Skills present after clicking cross Button : " + getTextList(SkillsAdded));
		sa.assertFalse(getTextList(SkillsAdded).contains("skill 1"),
				"Skill not got removed after clicking on cross button");
		sa.assertTrue(getTextList(SkillsAdded).contains("skill 2"),
				"All Skills not got removed after clicking on cross button");
		sa.assertAll();
		log.info("Skills field working as expected");
	}
	
	public void verifyRemoteSlideButton() {
		
	}

	// Verify the functionality of the Job Description field.
	public void verifyJobDescription(String desc) {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(jobDescError), "Job Description is required", "check error text when field left empty");
		log.info("Entering value in Job Description");
		setTextBoxWithinFrame("Job Description", desc);
		clickSave();
		sa.assertEquals(desc, getTextBoxWithinFrame("Job Description"));
		sa.assertTrue(getText(jobDescError).isEmpty(),
				"Error still present even after entering value in Job Description field");
		sa.assertAll();
		log.info("Job Description field working as expected");
	}

	// Verify the functionality of the Job Requirements field.
	public void verifyJobRequirement(String req) {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(jobReqError), "Job Requirement is required", "check error text when field left empty");
		log.info("Entering value in Job Requirement");
		setTextBoxWithinFrame("Job Requirement", req);
		clickSave();
		sa.assertEquals(req, getTextBoxWithinFrame("Job Requirement"));
		sa.assertTrue(getText(jobReqError).isEmpty(),
				"Error still present even after entering value in Job Requirement field");
		sa.assertAll();
		log.info("Job Requirement field working as expected");
	}

	/**
	 * method to verify state dropDown should be blank before any country is
	 * selected so count of state options is zero before selecting any country once
	 * country is selected states options increase as per country
	 * 
	 * @param country which needs to be check for states
	 */
	public void verifyStateWithoutSelectingCountry(String countryName) {
	//	SoftAssert sa = new SoftAssert();
		js.scrollIntoView(state);
//		sa.assertTrue(state.getAttribute("class"));*/
		log.info("checking if state option is enabled/disabled when country is not selected...");
		log.info("state option is enabled: " + stateDropdown.isEnabled());
		sa.assertFalse(stateDropdown.isEnabled(), "state dropdown enabled when country not selected");
		log.info("checking if state option is enabled/disabled when country is selected...");
		sendKeys(country, countryName);
		log.info("state option is enabled: " + stateDropdown.isEnabled());
		sa.assertTrue(stateDropdown.isEnabled(), "state dropdown enabled when country not selected");
		sa.assertAll();
	}

	// Verify the functionality of the Country field on the create job page.
	public void verifyCountry(String c1, String c2, String c3) {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(countryError), "Country Name is required", "check error text when field left empty");
		log.info("clicking on dropdown to check if dropdown displays");
		click(countryDropdown);
		List<String> opts = getAllOptionsPresent("Country");
		log.info("Options present in dropdown : " + opts);
		sa.assertTrue(opts.contains(c1), c1 + " not present in Country dropdown");
		sa.assertTrue(opts.contains(c2), c2 + " not present in Country dropdown");
		sa.assertTrue(opts.contains(c3), c3 + " not present in Country dropdown");
		log.info("selecting/Typing country " + c1);
		setDropDownWithTextBox("Country", country, c1);
		clickSave();
		sa.assertEquals(getDropDownValue("Country"), c1, "selected Country not visible in country field");
		sa.assertTrue(getText(countryError).isEmpty(),
				"Error still present even after entering value in country field");
		log.info("Entering random value to check No options suggestion");
		sendKeys(country, "xyz123");
		sa.assertTrue(isDisplayed(noOptions), "No Options suggestion did not show up even after entering random value");
		sa.assertAll();
		log.info("Country field working as expected");

	}

	// Verify the functionality of the State/Region dropdown field.
	// Verify users can search the name of the states on the State/Region field
	public void verifyState(String CountryName, String s1, String s2, String s3) {
		setDropDownWithTextBox("Country", country, CountryName);
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(stateError), "State Name is required", "check error text when field left empty");
		log.info("clicking on dropdown to check if dropdown displays");
		click(stateDropdown);
		List<String> opts = getAllOptionsPresent("State");
		log.info("Options present in dropdown : " + opts);
		sa.assertTrue(opts.contains(s1), s1 + " not present in State dropdown");
		sa.assertTrue(opts.contains(s2), s2 + " not present in State dropdown");
		sa.assertTrue(opts.contains(s3), s3 + " not present in State dropdown");
		log.info("selecting/Typing state " + s1);
		setDropDownWithTextBox("State", state, s1);
		clickSave();
		sa.assertEquals(getDropDownValue("State"), s1, "selected state not visible in state field");
		sa.assertTrue(getText(countryError).isEmpty(),
				"Error still present even after entering value in state field");
		log.info("Entering random value to check No options suggestion");
		sendKeys(state, "xyz123");
		sa.assertTrue(isDisplayed(noOptions), "No Options suggestion did not show up even after entering random value");
		sa.assertAll();
		log.info("state field working as expected");
	}

	// Verify the State/Region dropdown display the related states of the selected
	// country
	/**
	 * Method accepts country for which states are need to be checked it selects the
	 * country and check if expected states are present in country
	 * 
	 * @param data data from excel country and respective state to check
	 */
	public void verifyStateAsPerCountry(Hashtable<String, String> data) {
		setDropDownWithTextBox("Country", country, data.get("country"));
		sendKeys(state, Keys.SPACE);
		List<String> statesPresentInDropdown = getAllOptionsPresent("State");
		log.info("States present on site dropdown :" + statesPresentInDropdown);
		List<String> Statesfromdata = new ArrayList<String>(
				Arrays.asList(data.get("s1"), data.get("s2"), data.get("s3"), data.get("s4"), data.get("s5")));
		log.info("states expected on site dropdown " + Statesfromdata);
		Assert.assertTrue(statesPresentInDropdown.contains(Statesfromdata.get(0)),
				Statesfromdata.get(0) + " not present in country");
		Assert.assertTrue(statesPresentInDropdown.contains(Statesfromdata.get(1)),
				Statesfromdata.get(1) + " not present in country");
		Assert.assertTrue(statesPresentInDropdown.contains(Statesfromdata.get(2)),
				Statesfromdata.get(2) + " not present in country");
		Assert.assertTrue(statesPresentInDropdown.contains(Statesfromdata.get(3)),
				Statesfromdata.get(3) + " not present in country");
		Assert.assertTrue(statesPresentInDropdown.contains(Statesfromdata.get(4)),
				Statesfromdata.get(4) + " not present in country");

		log.info(Statesfromdata + " present on site ");

	}

	// Verify the functionality of the City field.
	public void verifyCity(String cit) {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(cityError), "City is required", "check error text when kept field blank");
		log.info("Entering numeric value in city field to check error");
		setTextBox("City", city, "12345");
		sa.assertEquals(getText(cityError), "City name must be alphabetic.",
				"check error text when enterd numeric value in field");
		log.info("Entering valid aplhabetical value in city field " + cit);
		setTextBox("City", city, cit);
		clickSave();
		sa.assertEquals(getTextBox("City"), cit, "Entered value not present in field");
		sa.assertTrue(getText(cityError).isEmpty(), "Error still present even after entering valid value in field");
		sa.assertAll();
		log.info("city field working as expected");
	}

	// Verify the functionality of the Pincode field.
//	Verify when users enter any special character or wrong Pincode number the same error message is visible. 
	public void verifyPincode(String pin) {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(pincodeError), "Pincode is required", "check error text when kept field blank");
		log.info("Entering alphabatical value in pincode field to check error");
		setTextBox("Pincode", pincode, "axvzvd");
		sa.assertEquals(getText(pincodeError), "Pincode should not contain characters",
				"check error text when entered alphabetical value in field");
		log.info("Entering special characters in pincode field to check error");
		setTextBox("Pincode", pincode, "#$^@#");
		sa.assertEquals(getText(pincodeError), "Pincode should not contain special characters",
				"check error text when entered special characters in field");
		log.info("Entering Decimal value in pincode field to check error");
		setTextBox("Pincode", pincode, "22.54");
		sa.assertEquals(getText(pincodeError), "Pincode should not contain decimals",
				"check error text when entered Decimal value in field");
		log.info("Entering pincode having digits more than 6 to check error");
		setTextBox("Pincode", pincode, "123456789");
		sa.assertEquals(getText(pincodeError), "Pincode should not have more than 6 digits",
				"check error text when entered more than 6 digits in field");
		log.info("Entering valid pincode ");
		setTextBox("Pincode", pincode, pin);
		clickSave();
		sa.assertEquals(getTextBox("Pincode"), pin, "Entered value not present in field");
		sa.assertTrue(getText(pincodeError).isEmpty(), "Error still present even after entering valid value in field");
		sa.assertAll();
		log.info("pincode field working as expected");
	}

	// Verify the functionality of the Job type field.
	public void verifyJobType(String t1, String t2, String unique) {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(jobTypeError), "Employment Type is required", "check error text when field left empty");
		log.info("clicking on dropdown to check if dropdown displays");
		click(jobTypeDropdown);
		List<String> opts = getAllOptionsPresent("Job Type");
		log.info("Options present in dropdown : " + opts);
		sa.assertTrue(opts.contains(t1), t1 + " not present in Job Type dropdown");
		sa.assertTrue(opts.contains(t2), t2 + " not present in Job Type dropdown");
		click(jobTypeDropdown);
		log.info("Entering value, if value not present creating same ");
		setDropDownWithCreateOption("Job Type", jobType, unique);
		clickSave();
		sa.assertEquals(getDropDownValue("Job Type"), unique, "selected value not displayed in field");
		sa.assertTrue(getText(jobTypeError).isEmpty(), "Error still present even after entering valid value");
		sa.assertAll();
		log.info("job type field working as expected");
	}

	// Verify the functionality of the Category field.
	public void verifyEmpCategory(String t1, String t2, String unique) {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(empCategoryError), "Category is required", "check error text when field left empty");
		log.info("clicking on dropdown to check if dropdown displays");
		click(empCategoryDropdown);
		List<String> opts = getAllOptionsPresent("Category");
		log.info("Options present in dropdown : " + opts);
		sa.assertTrue(opts.contains(t1), t1 + " not present in Category dropdown");
		sa.assertTrue(opts.contains(t2), t2 + " not present in Category dropdown");
		click(empCategoryDropdown);
		log.info("Entering value, if value not present creating same ");
		setDropDownWithCreateOption("Category", empCategory, unique);
		clickSave();
		sa.assertEquals(getDropDownValue("Category"), unique, "selected value not displayed in field");
		sa.assertTrue(getText(empCategoryError).isEmpty(), "Error still present even after entering valid value");
		sa.assertAll();
		log.info("Category field working as expected");
	}

//	Verify the functionality of the Education details field.
	public void verifyEducation(String t1, String t2, String unique) {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(educationError), "Education is required", "check error text when field left empty");
		log.info("clicking on dropdown to check if dropdown displays");
		click(educationDropdown);
		List<String> opts = getAllOptionsPresent("Education");
		log.info("Options present in dropdown : " + opts);
		sa.assertTrue(opts.contains(t1), t1 + " not present in Category dropdown");
		sa.assertTrue(opts.contains(t2), t2 + " not present in Category dropdown");
		click(educationDropdown);
		log.info("Entering value, if value not present creating same ");
		setDropDownWithCreateOption("Education", education, unique);
		clickSave();
		sa.assertEquals(getDropDownValue("Education"), unique, "selected value not displayed in field");
		sa.assertTrue(getText(educationError).isEmpty(), "Error still present even after entering valid value");
		sa.assertAll();
		log.info("Education field working as expected");
	}

	public void verifyExperience(String exp) {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(experienceError), "Experience field is required !",
				"check error text when field left empty");
		setTextBox("Experience", experience, exp);
		clickSave();
		sa.assertTrue(getText(experienceError).isEmpty(),
				"Error still present even after entering value in Title field");
		sa.assertAll();
		log.info("experience field working as expected");
	}

	// Verify the functionality of the Hours Per Week field.
	/**
	 * method first clicks on save without entering value in minimum and maximum
	 * hour field to check if fields cannot be empty error pop up then enter minimum
	 * hour value greater than maximum hour value to check if Max hours must be
	 * greter than Min hours error pop up at last enters right value and checks if
	 * any error still present
	 */
	public void verifyErrorsForHoursPerWeek() {
		log.info("clicking on save by keeping field empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.", "check popup text when field left empty");
		sa.assertEquals(getText(hoursPerWeekError), "Min hours and max hours fields are required.",
				"check error text when field left empty");
		log.info("Entering minimum hour value greater than maximum hour value to check error");
		setMinHour("8");
		setMaxHour("4");
		sa.assertEquals(getText(hoursPerWeekError), "Min Hours can not be greater than max hours !",
				"check the Error not displayed ");
		log.info("Entering valid values");
		setMinHour("2");
		setMaxHour("6");
		sa.assertTrue(getText(hoursPerWeekError).isEmpty(), "error did not disappear even after entering valid values");
		sa.assertEquals(getMinHour(), Integer.toString(2), "check min hour field");
		sa.assertEquals(getMaxHour(), Integer.toString(6), "check max hour field");
		sa.assertAll();
		log.info("min and max hours entries working as expected");

	}

	public void verifyRemoteToogle() {
		getRemoteToggle();
		setRemoteToggle();
		Assert.assertEquals(true, getRemoteToggle(), "Remote toggle not set");
		log.info("Remote button checked");
	}

	// Verify the Functionality of the "Save Changes" button when the form is
	// filled.
	// Verify the Functionality of the "Save Changes" button when the mandatory
	// fields are left empty.
	public String verifySaveChangesButton() {

		log.info("clicking on save changes button by keeping all mandatory fields empty to check error");
		String popupText = clickSave();
		sa.assertEquals(popupText, "Mandatory fields are required.",
				"check popup text when mandatory fields are left empty");
		log.info("Filling all mandatory fields and clicking on save changes button ");
		JobPostingPojo job = createNewJob("create");
		log.info("Popup text when entered all mandatory fields and clicked on save button " + job.getPopupText());
		sa.assertEquals(job.getPopupText(), "Job saved as draft. Publish it to start receiving candidates.",
				"check popup text when all mandatory fields are entered and clicked on save button");
		sa.assertAll();
		log.info("save changes button working as expected");
		return job.getJob_id();
	}
	
	//Verify the functionality of the "Save & Publish" button.
	public String verifySaveJobAndPublishButton() {
		log.info("Filling all mandatory fields and clicking on save changes button ");
		JobPostingPojo job = createNewJob("create");
		log.info("clicking on save and publish button...");
		String popupText = clickSaveAndPublish();
		sa.assertEquals(popupText, "Saved Updates", "popup not matching" + popupText);
		log.info("navigating to jobs page and then to publish page to check if job is published");
		JobsPage jp = new JobsPage(driver);
		jp.goToJobs();
		click(published);
        By jobId = By.xpath("//*[@data-job_id='job_id_"+job.getJob_id()+"']");
        log.info("created job is displayed on publish page: " + isDisplayed(driver.findElement(jobId)));
        sa.assertTrue(isDisplayed(driver.findElement(jobId)), "created job not displayed on publish page");
		sa.assertAll();
		log.info("Hence, save and publish job functionality is verified");
		return job.getJob_id();
	}

//	Verify the functionality of the Application form button on the Job posting page.
	public JobPostingPojo verifyApplicationFormButton() {
		log.info("checking application form button by not filling mandatory fields ");
		sa.assertFalse(applicationFormButton.isEnabled(),
				"Application form button is acccessible even if mandatory fields are empty");
		log.info("Entering all mandatory field values and clicking on save");
		JobPostingPojo job = createNewJob("create");
		click(applicationFormButton);
		log.info("clicked on application form button");
		sa.assertTrue(driver.getCurrentUrl().contains("application-form"),
				"user not navigated to application form after clicking application form Button");
		sa.assertAll();
		log.info("Application form button working as expected ");
		return job;
	}

	// Verify the Application Form tab is not accessible if the details on the job
	// posting page are not filled and saved.
	public JobPostingPojo verifyApplicationFormTab() {
		log.info("checking application form tab by not filling mandatory fields ");
		sa.assertFalse(applicationFormTab.isEnabled(),
				"Application form tab is acccessible even if mandatory fields are empty");
		log.info("Entering all mandatory field values and clicking on save");
		JobPostingPojo job = createNewJob("create");
		click(applicationFormTab);
		sa.assertTrue(driver.getCurrentUrl().contains("application-form"),
				"user not navigated to application form after clicking application form tab");
		log.info("Application form tab working as expected");
		return job;
	}

	/**
	 * 
	 * Method can be used to create new job or Edit existing job based on action
	 * parameter . Method first creates job info with use of JobPosting Pojo then
	 * enters all values in field like job title , description , requirement etc and
	 * last clicks on save
	 * 
	 * @param action whether to edit or createnewjob
	 * @return jobposting pojo with all info about job
	 */
	public JobPostingPojo createNewJob(String action) {
		JobPostingPojo job = generateJobPostingData();
		wait.forPage();
		setTextBox("Job Title", jobTitle, job.getJob_title());
		setDropDownWithTextBox("Department", dept, job.getJob_deptname());
		setExpiryDate(job.getExpiry_Date());

//		if (action.equalsIgnoreCase("edit"))
//		removeTags();
//		addTags(job.getJob_tag().get(0));
		setTextBoxWithinFrame("Job Description", job.getJob_description());
		setTextBoxWithinFrame("Job Requirement", job.getJob_requirement());
		setDropDownWithTextBox("Country", country, job.getJob_location().get("country_name"));
		setDropDownWithTextBox("State", state, job.getJob_location().get("state_name"));
		setTextBox("City", city, job.getJob_location().get("city"));
		setTextBox("Pincode", pincode, job.getJob_location().get("pincode"));
		if (job.getIs_remote() && action.equalsIgnoreCase("create"))
			setRemoteToggle();
		if (action.equalsIgnoreCase("edit") && getRemoteToggle() == false && job.getIs_remote())
			setRemoteToggle(); // to set toggle to ON while editing if originally it was OFF
		if (action.equalsIgnoreCase("edit") && getRemoteToggle() && job.getIs_remote() == false)
			setRemoteToggle(); // to turn OFF toggle if in editing user wants to remove remote option which was
								// set originally while creating job
		setDropDownWithCreateOption("Job Type", jobType, job.getJob_type().get("employement_type"));
		setDropDownWithCreateOption("Category", empCategory, job.getJob_type().get("category"));
		setDropDownWithCreateOption("Education", education, job.getJob_type().get("education"));
		setTextBox("Experience", experience, job.getJob_type().get("experience"));
		setMinHour(job.getJob_type().get("min_hours"));
		setMaxHour(job.getJob_type().get("max_hours"));
		js.scrollToTopOfPage();

		try {
			job.setPopupText(clickSave());
			log.info("clicked on save");
		} catch (Exception e) {
			job.setPopupText(clickSave());
			log.info("again clicked on save");
		}
		String job_id = driver.getCurrentUrl().substring(driver.getCurrentUrl().lastIndexOf("/") + 1);
//		log.info(driver.getCurrentUrl());
//		log.info(job_id);
		job.setJob_id(job_id);
		if (action.equalsIgnoreCase("edit")) {
			log.info("Title of Edited job : " + job.getJob_title());
		} else if (action.equalsIgnoreCase("create")) {
			log.info("Title of Newly created job : " + job.getJob_title());
		}
		return job;
	}

	public void clickWorkflow() {
		click(workflow);
		log.info("clicked on workflow");
	}

	/**
	 * Method to create bulk jobs for search and pagination test cases
	 * 
	 * @param count   number of jobs to be created
	 * @param type    value can be title or department which needs to added to job
	 * @param keyword value of title or department
	 * @return list on job titles
	 */
	public List<String> createJobsInBulk(int count, String type, String keyword) {

		List<String> jobIds = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			click(jobs);
			click(newjob);
			JobPostingPojo job = generateJobPostingData();
			wait.forPage();
			if (type.equalsIgnoreCase("title"))
				setTextBox("Job Title", jobTitle, keyword + "_" + i);
			else
				setTextBox("Job Title", jobTitle, job.getJob_title());
			if (type.equalsIgnoreCase("department"))
				setDropDownWithTextBox("Department", dept, keyword);
			else
				setDropDownWithTextBox("Department", dept, job.getJob_deptname());
			if (type.equalsIgnoreCase("tags"))
				addTags(keyword);
			setExpiryDate(job.getExpiry_Date());
			setTextBoxWithinFrame("Job Description", job.getJob_description());
			setTextBoxWithinFrame("Job Requirement", job.getJob_requirement());
			setDropDownWithTextBox("Country", country, job.getJob_location().get("country_name"));
			setDropDownWithTextBox("State", state, job.getJob_location().get("state_name"));
			setTextBox("City", city, job.getJob_location().get("city"));
			setTextBox("Pincode", pincode, job.getJob_location().get("pincode"));
//			if (job.getIs_remote())
//				setRemoteToggle();
			setDropDownWithCreateOption("Job Type", jobType, job.getJob_type().get("employement_type"));
			setDropDownWithCreateOption("Category", empCategory, job.getJob_type().get("category"));
			setDropDownWithCreateOption("Education", education, job.getJob_type().get("education"));
			setTextBox("Experience", experience, job.getJob_type().get("experience"));
			setMinHour(job.getJob_type().get("min_hours"));
			setMaxHour(job.getJob_type().get("max_hours"));
			js.scrollToTopOfPage();
			try {
				clickSave();
				log.info("clicked on save");
			} catch (Exception e) {
				clickSave();
				log.info("again clicked on save");
			}
			String job_id = driver.getCurrentUrl().substring(driver.getCurrentUrl().lastIndexOf("/") + 1);
			job.setJob_id(job_id);
			jobIds.add(job_id);
		}
		return jobIds;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void verifyDropDownWithCreateOption(String fieldName, WebElement webelement, String type) {
		wait.forElementToBeVisible(webelement);
		js.scrollIntoView(webelement);
		click(webelement);
		List<String> opts = getAllOptionsPresent(fieldName);
		log.info("Options available : " + opts);
		sendKeys(webelement, type);
		if (opts.contains(type)) {
			new Actions(driver).sendKeys(Keys.TAB).perform();
			log.info("Entering value :" + type + " inside field :" + fieldName);
		} else {
			WebElement create = driver.findElement(By.xpath("//div[contains(text(),'Create')]"));
			click(create);
			log.info("Entering value :" + type + " inside field :" + fieldName);
		}
		click(save);
		log.info("clicking save ");
		js.scrollIntoView(webelement);
		WebElement actualText = driver
				.findElement(By.xpath("//*[text()='" + fieldName + "']/parent::div/div/div/div[1]/div[1]"));
		sa.assertEquals(actualText.getText(), type,
				"input given : " + type + " value present : " + actualText.getText());
		sa.assertAll();
		log.info("Selected " + fieldName + " successfully ");
	}

	/**
	 * Method to add tags in form
	 * 
	 * @param tag expected tag to be added
	 * @return return list of tags added to form
	 */
	public List<String> addTags(String tag) {
		click(addTagsButton);
		log.info("clicked on add tags button");
		sendKeys(tagsInputBox, tag);
		sendKeys(tagsInputBox, Keys.ENTER);
		List<String> Addedtags = getStringListFromWebElementList(tagsAdded);
		return Addedtags;
	}

	public void removeTags() {
		try {
			if (tagsAdded.size() > 0) {
				for (int i = 0; i < tagsAdded.size(); i++)
					log.info("removing tag : " + tagsAdded.get(i).getText());
				click(removeTags);
			}
		} catch (Exception e) {
			log.info("Inside catch after exception : " + e.getClass().getSimpleName());
			log.info("No tags present");
		}

	}
	
	public List<String> addSkills(String skill) {
		click(addSkillsButton);
		log.info("clicked on add skills button");
		sendKeys(skillsInputBox, skill);
		sendKeys(skillsInputBox, Keys.ENTER);
		List<String> AddedSkills = getStringListFromWebElementList(SkillsAdded);
		return AddedSkills;
	}

	public void removeSkills() {
		try {
			if (SkillsAdded.size() > 0) {
				for (int i = 0; i < SkillsAdded.size(); i++)
					log.info("removing tag : " + SkillsAdded.get(i).getText());
				click(removeSkills);
			}
		} catch (Exception e) {
			log.info("Inside catch after exception : " + e.getClass().getSimpleName());
			log.info("No skills present");
		}

	}

	/**
	 * Method to enter values in minimum and maximum hours field and save same
	 * 
	 * @param min value to be entered in minimum hour field
	 * @param max value to be entered in maximum hour field
	 */
	public void enterValueToMinAndMaxHoursField(int mi, int mx) {
		js.scrollIntoView(minhour);
		minhour.sendKeys(Integer.toString(mi));
		log.info("Entering min hour value as " + minhour.getAttribute("value"));
		maxhour.sendKeys(Integer.toString(mx));
		log.info("Entering min hour value as " + maxhour.getAttribute("value"));
		js.scrollIntoView(save);
		click(save);
		js.scrollIntoView(minhour);
		log.info("clicked on save changes");

	}

	public void clickApplicationFormButton() {
		click(applicationFormButton);
	}

	public void goToPage(String pageName) {

		WebElement page = driver.findElement(By.xpath("//ul/li/a/div[contains(text(),'" + pageName + "')]"));
		click(page);
		log.info("Navigating to " + pageName + " page");
	}

	//////////////////////////////////////////////////////////////////////////////
	// GETTERS & SETTERS METHODS //
	////////////////////////////////////////////////////////////////////////////

	public void setMinHour(String mi) {
		js.scrollIntoView(minhour);
		log.info(minhour.getAttribute("value"));
		if (!minhour.getAttribute("value").isEmpty()) {
			while (Integer.parseInt(minhour.getAttribute("value")) > 1) {
				minhour.sendKeys(Keys.ARROW_DOWN);
//				log.info(Integer.parseInt(minhour.getAttribute("value")));
			}
			while (!(minhour.getAttribute("value").equals(mi))) {
				minhour.sendKeys(Keys.ARROW_UP);
//				log.info(Integer.parseInt(minhour.getAttribute("value")));
			}
		} else if (minhour.getAttribute("value").isEmpty()) {
			while (!((minhour.getAttribute("value")).equals(mi))) {
				sendKeys(minhour, Keys.ARROW_UP);
//				log.info(Integer.parseInt(minhour.getAttribute("value")));
			}
		}
		log.info("Set min hour as :" + minhour.getAttribute("value"));
	}
	public void setMaxHour(String mx) {
		js.scrollIntoView(maxhour);
		if (!maxhour.getAttribute("value").isEmpty()) {
			while (Integer.parseInt(maxhour.getAttribute("value")) > 1)
				maxhour.sendKeys(Keys.ARROW_DOWN);
			while (!maxhour.getAttribute("value").equals(mx))
				maxhour.sendKeys(Keys.ARROW_UP);
		} else {
			while (!((maxhour.getAttribute("value")).equals(mx)))
				maxhour.sendKeys(Keys.ARROW_UP);
		}
		log.info("Set max hour as :" + maxhour.getAttribute("value"));
	}
	
	
	public String getMinHour() {
		wait.forElementToBeVisible(minhour);
		return minhour.getAttribute("value");
	}

	public String getMaxHour() {
		wait.forElementToBeVisible(minhour);
		return maxhour.getAttribute("value");
	}

	public List<String> getTags() {
		wait.forAllElementToBeVisible(tagsAdded);
		return getStringListFromWebElementList(tagsAdded);
	}
	
	public List<String> getSkills() {
		wait.forAllElementToBeVisible(SkillsAdded);
		return getStringListFromWebElementList(SkillsAdded);
	}

	public void setRemoteToggle() {
		try {
			remote.click();
		} catch (Exception e) {
			log.info("Inside catch block after exception :" + e.getClass().getSimpleName());
			js.scrollIntoViewAndClick(remote);
		}
//		wait.until(ExpectedConditions.attributeContains(remotecheck, "class", "checked"));
		log.info("clicked on toggle");
	}

	public boolean getRemoteToggle() {
		js.scrollIntoView(remote);
		boolean check = remotecheck.getAttribute("class").contains("checked");
		log.info("Toggle value :" + check);
		return check;
	}

	/**
	 * Method to set dropDown with text option
	 * 
	 * @param fieldName  Value can be Department,Country,State i.e name of field to
	 *                   verified
	 * @param webelement WebElement to be handled
	 * @param value      Value to be entered
	 */
	public List<String> setDropDownWithTextBox(String fieldName, WebElement webelement, String value) {
		js.scrollIntoView(webelement);
//		click(webelement);
		sendKeys(webelement, Keys.SPACE);
//		List<String> opts = getAllOptionsPresent(fieldName);
//		log.info("Options available : " + opts);
//		String value = opts.get(rand.nextInt(opts.size()));
		sendKeys(webelement, value);
		List<String> opts = getAllOptionsPresent(fieldName);
		new Actions(driver).sendKeys(Keys.TAB).perform();
		log.info("Selected " + fieldName + " as :" + value);
		return opts;
	}

	public List<String> getAllOptionsPresent(String fieldName) {
		List<String> opts = new ArrayList<String>();
		By field = By.xpath("//*[text()='" + fieldName + "']/following-sibling::div/div/div/div[2]/input");
		By options = By.xpath("//*[text()='" + fieldName + "']/following-sibling::div/div[2]/div/div");
		wait.forAllElementsToBePresent(options);
		List<WebElement> Options = driver.findElements(options);

		for (int i = 0; i < Options.size(); i++) {
			wait.forElementToBeVisible(Options.get(i));
			opts.add((Options.get(i).getText()));
		}
		return opts;
	}

	/**
	 * Method to set dropDown with text option and also with Create option
	 * 
	 * @param fieldName  Value can be Job Type,Category,Education i.e name of field
	 *                   to verified
	 * @param webelement WebElement to be handled
	 * @param value      Value to be entered
	 */
	public void setDropDownWithCreateOption(String fieldName, WebElement webelement, String value) {
		js.scrollIntoView(webelement);
		sendKeys(webelement, Keys.SPACE);
		List<String> opts = getAllOptionsPresent(fieldName);
		log.info("Options available : " + opts);
		sendKeys(webelement, value);
		if (opts.contains(value)) {
			new Actions(driver).sendKeys(Keys.TAB).perform();
			log.info("Entering value :" + value + " inside field :" + fieldName);
		} else {
			log.info(value + " not present in dropdown so creating same");
			WebElement create = driver.findElement(By.xpath("//div[contains(text(),'Create')]"));
			click(create);
			log.info("Entering value :" + value + " inside field :" + fieldName);
		}
	}

	/**
	 * Method to get text present in field
	 * 
	 * @param fieldName value can be Department, Country, State, Job Type, Category,
	 *                  Education
	 * @return
	 */
	public String getDropDownValue(String fieldName) {

	//	WebElement actualText = wait.forElementToBeVisible(
	//			driver.findElement(By.xpath("//*[text()='" + fieldName + "']/parent::div/div/div/div[1]/div[1]")));
		By actualText = By.xpath("//*[text()='"+fieldName+"']/parent::div/div/div/div[1]/div[1]");
		wait.forElementToBeVisible(driver.findElement(actualText));
		log.info("Text present in " + fieldName + " : " + getText(driver.findElement(actualText)));
		return getText(driver.findElement(actualText));
	}

	public void setTextBox(String fieldName, WebElement webelement, String value) {
		js.scrollIntoView(webelement);
		sendKeys(webelement, value);
		log.info("Entered value " + value + " inside " + fieldName);
	}

	public String getTextBox(String fieldName) {
		By by = By.xpath("//*[text()='" + fieldName + "']/following-sibling::input");
		WebElement actualValue = wait.forElementToBeVisible(driver.findElement(by));
		js.scrollIntoView(actualValue);
		log.info("Text present in " + fieldName + " : " + actualValue.getAttribute("value"));
		return actualValue.getAttribute("value");
	}

	public void setTextBoxWithinFrame(String fieldName, String value) {
		By by = By.xpath("//*[contains(text(),'" + fieldName + "')]/following-sibling::div/div/div/div[2]/div/iframe");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
		sendKeys(textArea, value);
//		wait.until(ExpectedConditions.tex .textToBePresentInElement(textArea, value));
		log.info("Entered text in " + fieldName + " as : " + textArea.getText());
		driver.switchTo().parentFrame();
	}

	public String getTextBoxWithinFrame(String fieldName) {
		String actualText = "";
		By by = By.xpath("//*[contains(text(),'" + fieldName + "')]/following-sibling::div/div/div/div[2]/div/iframe");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
		actualText = textArea.getText();
		driver.switchTo().parentFrame();
		log.info("Text present in " + fieldName + " : " + actualText);
		return actualText;
	}

	public String getExpiryDate() {
		String Date = expiryDate.getAttribute("value");
		String day = Date.substring(0, Date.indexOf("-"));
		String month = Date.substring(Date.indexOf("-"), Date.lastIndexOf("-") + 1);
		String year = Date.substring(Date.lastIndexOf("-") + 1);
		return year + month + day;
	}

	public void setExpiryDate(String Date) {
		sendKeys(expiryDate, Date);
	}

	public String clickSave() {
		click(save);
		String msg = getText(alert);
		log.info("Clicked on save Button, Popup Text : " + msg);
		click(closePopup);
		return msg;
	}
	
	public String clickSaveAndPublish() {
		new Actions(driver).moveToElement(saveArrow).click().perform();
		click(saveAndPublish);
		String msg = getText(alert);
		log.info("Clicked on save  and publish button, Popup Text : " + msg);
		click(closePopup);
		return msg;
	}

	public JobPostingPojo generateJobPostingData() {
		JobPostingPojo step1 = new JobPostingPojo();
		step1.setJob_title();
		step1.setJob_description();
		step1.setJob_requirement();
		step1.setJob_deptname();
		step1.setJob_location();
		step1.setJob_type();
		step1.setJob_tag();
		step1.setIs_remote();
		step1.setPublish_Date();
		step1.setExpiry_Date();
		return step1;
	}
}
