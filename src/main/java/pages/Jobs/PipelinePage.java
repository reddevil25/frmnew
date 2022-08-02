package pages.Jobs;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import PojoClasses.CreateCandidatePojo;
import commons.BasePage;
import pages.Home.CandidatesPage;
import pages.Home.JobsPage;

public class PipelinePage extends BasePage {

	public PipelinePage(WebDriver driver) {
		super(driver);
	}

	SoftAssert sa = new SoftAssert();
	private static final Logger log = LogManager.getLogger(PipelinePage.class.getName());
	CandidatesPage cp = new CandidatesPage(driver);
	JobsPage jp = new JobsPage(driver);

	@FindBy(xpath = "//button[text()='Add Candidate']")
	private WebElement addCandidateButton;

	@FindBy(xpath = "//div/div/div/span[@class='ml-2 font_sm']")
	private WebElement candidateName;

	@FindBy(xpath = "//*[@draggable='true']/div/img")
	private WebElement candidateProfilePic;

	@FindBy(xpath = "//div/div/div/span[@class='ml-2 font_sm']")
	private List<WebElement> candidatesPresent;

	@FindBy(xpath = "//*[@draggable='true']/following-sibling::div[2]")
	private WebElement evaluationStatusBar;

	@FindBy(xpath = "//*[@draggable='true']/following-sibling::div/p[2]")
	private WebElement evaluation;

	@FindBy(xpath = "//li[@id='Created on']/span")
	private WebElement createdOn;

	@FindBy(xpath = "//*[@id='Add a note']/div/button")
	private WebElement addNoteButton;

	@FindBy(xpath = "//input[@name='title']")
	private WebElement noteTitle;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement noteDescription;

	@FindBy(xpath = "//li[@id='Add a note']/div/div/div/following-sibling::div/button[text()='Save']")
	private WebElement saveNote;

	@FindBy(xpath = "//li[@id='Add a note']/span")
	private WebElement noteCount;

	@FindBy(xpath = "//div[@id='Move candidate']/button")
	private WebElement moveCandidateDropdownButton;

	@FindBy(xpath = "//div[@class='dropdown-menu py-0 show']")
	private WebElement moveCandidateDropdown;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alert;

	@FindBy(css = ".Toastify>div>div>button")
	private WebElement closePopup;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveCandidate;
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement fullName;

	// Verify the functionality of the Add candidate button in the job's pipeline.
	public void verifyAddCandidateButton(String job) {
		click(addCandidateButton);
		log.info("clicked on add candidate button");
		sa.assertTrue(driver.getCurrentUrl().contains("/candidates/candidate/overview"),
				"check url user not navigated to add candidates page");
		CreateCandidatePojo candidate = cp.createCandidate();
		jp.goToJobs();
		jp.goToPipeline(job);
		log.info(getTextList(candidatesPresent));
		sa.assertTrue(getTextList(candidatesPresent).contains(candidate.getFullname()), "candidate name not present");
		log.info("created " + candidate.getFullname());
		sa.assertAll();
//functionality under development, job should get assigned already.
		log.info("user  navigated to add candidate page successfully");
	}

	// Verify the candidate's count is displayed on the side of the stage names
	// (headers).
	/**
	 * Method to verify count of candidates present on side of stage name in
	 * Brackets matches actual candidates present in stage
	 * 
	 * @param stage Value can be Applied, Qualified, Offer, Hire, Shortlisted,
	 *              Rejected depends on which stage count needs to be checked
	 */
	public void verifyCountDisplayedOnSideOfStage(String stage) {
		By candidates = By
				.xpath("//*[contains(text(),'" + stage + "')]/parent::div/following-sibling::div/div/div/span");
		int countInStage = wait.forAllElementToBeVisible(driver.findElements(candidates)).size();
		log.info("Actual candidates present in " + stage + " stage : " + countInStage);
		By countOnSideOfStage = By
				.xpath("//div[text()='"+ stage +"']/span[@class='Application_count']");
		String countOnSide = getText(wait.forElementToBeVisible(driver.findElement(countOnSideOfStage)));
		log.info(countOnSide);
		int count = Integer.parseInt(countOnSide);
		log.info("count on present on side of " + stage + " stage name : " + count);
		Assert.assertEquals(countInStage, count);
		log.info("Count present on side of " + stage + "stage matches with actual number candidates present in " + stage
				+ " stage");
	}

	// Verify the candidate cards can be dragged and dropped to different stages
	// with a successful message.
	public void verifyCandidateCardDragAndDrop(String sourceStage, String targetStage, String candidate) {

		By s = By.xpath("//*[contains(text(),'" + sourceStage + "')]/parent::div/following-sibling::div/div/div/span");
		List<WebElement> sourceCandidates = wait.forAllElementToBeVisible(driver.findElements(s));

		

		log.info(
				"candidates present in " + sourceStage + " stage before drag and drop" + getTextList(sourceCandidates));
		log.info("trying to drag and drop " + candidate + " from " + sourceStage + " to " + targetStage);

		By sourceBy = By.xpath("//*[text()='" + candidate + "']/parent::div");

		WebElement source = wait.forElementToBeVisible(driver.findElement(sourceBy));
		By targetBy = By.xpath("//*[@class='px-2']/preceding-sibling::div/div[text()='" + targetStage + "']");
		WebElement target = wait.forElementToBePresent(targetBy);

		log.info("source getlocation :" + source.getLocation().getX() + "-------" + source.getLocation().getY());
		log.info("target location :" + target.getLocation().getX() + "-------" + target.getLocation().getY());

		int x1 = source.getLocation().getX() + 127;
		int y1 = source.getLocation().getY() + 127;
		int x2 = target.getLocation().getX() + 75;
		int y2 = target.getLocation().getY() + 175;
		Duration d = Duration.ofSeconds(2);
//		new Actions(driver).moveToElement(source, x1, y1).clickAndHold(source).moveByOffset(x2, y2).pause(d).release().perform();
		dragAndDrop(x1, y1, x2, y2);
		sa.assertTrue(verifyPopup("Stage changed"), "check popup text after stage is changed");
		/*try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		By t = By.xpath("//*[contains(text(),'" + targetStage + "')]/parent::div/following-sibling::div/div/div/span");
		List<WebElement> targetCandidates = wait.forAllElementToBeVisible(driver.findElements(t));

	//	log.info("candidates present in " + sourceStage + " stage after drag and drop" + getTextList(sourceCandidates));
		log.info("candidates present in " + targetStage + " stage after drag and drop" + getTextList(targetCandidates));
		//sa.assertFalse(getTextList(sourceCandidates).contains(candidate),
		//		"candidate still present in " + sourceStage + " stage");
		sa.assertTrue(getTextList(targetCandidates).contains(candidate),
				"candidate not moved to " + targetStage + " stage");
		sa.assertAll();
		log.info("Dragged and Droped " + candidate + " candidate from " + sourceStage + " to " + targetStage);
		log.info("Drag and Drop candidate card working as expected");
	}

	// Verify the candidate's card display the image of the candidate.
	public void verifyImageOfCandidateonCard(String profilePic) {
		String src = getAttribute(candidateProfilePic, "src");
		String ProfilePicIdOnCard = src.substring(src.lastIndexOf("/") + 1);
		log.info("Actual profile picture of candidate : " + profilePic);
		log.info("profile pic of candidate present on card: " + ProfilePicIdOnCard);

		Assert.assertEquals(profilePic, ProfilePicIdOnCard,
				"Profile pic did not match on card Or Profile pic not present");

	}

	// Verify the candidate's card display the name of the candidate.
	public void verifyNameOfCandidateOnCard(String candName) {
		sa.assertTrue(isDisplayed(candidateName), "Name is not displayed");
		sa.assertEquals(getText(candidateName), candName, "Name does not match");
		sa.assertAll();
		log.info("Candidates name displayed successfully");
	}

	// Verify the candidate's card display the evaluation percentage of the
	// candidate.
	public void verifyEvaluationPercentageOnCard() {

		log.info("evaluation when candidate in Applied stage :" + getText(evaluation));
		log.info("evaluation Status Bar for Applied stage : " + getAttribute(evaluationStatusBar, "title"));
		sa.assertEquals("25%", getText(evaluation), "Check Applied Evaluation");
		sa.assertTrue(getAttribute(evaluationStatusBar, "title").contains("25%"), "check status bar for Applied stage");
		log.info("changing stage to Shortlisted ");
		changeStage("Shortlisted");
		log.info("evaluation when candidate in Shortlisted stage :" + getText(evaluation));
		log.info("evaluation Status Bar for Shortlisted stage : " + getAttribute(evaluationStatusBar, "title"));
		sa.assertEquals("50%", getText(evaluation), "Check Shortlisted Evaluation");
		sa.assertTrue(getAttribute(evaluationStatusBar, "title").contains("50%"),
				"check status bar for Shortlisted stage");
		log.info("changing stage to Schedule ");
		changeStage("Schedule");
		log.info("evaluation when candidate in Schedule stage :" + getText(evaluation));
		log.info("evaluation Status Bar for Schedule stage : " + getAttribute(evaluationStatusBar, "title"));
		sa.assertEquals("75%", getText(evaluation), "Check Shortlisted Evaluation");
		sa.assertTrue(getAttribute(evaluationStatusBar, "title").contains("75%"),
				"check status bar for Schedule stage");
		log.info("changing stage to Qualified ");
		changeStage("Qualified");
		log.info("evaluation when candidate in Qualified stage :" + getText(evaluation));
		log.info("evaluation Status Bar for Qualified stage : " + getAttribute(evaluationStatusBar, "title"));
		sa.assertEquals("100%", getText(evaluation), "Check Shortlisted Evaluation");
		sa.assertTrue(getAttribute(evaluationStatusBar, "title").contains("100%"),
				"check status bar for Qualified stage");
		log.info("changing stage to Rejected ");
		changeStage("Rejected");
		log.info("evaluation Status Bar for Rejected stage : " + getAttribute(evaluationStatusBar, "title"));
		sa.assertTrue(getAttribute(evaluationStatusBar, "title").contains("-1%"),
				"check status bar for Rejected stage");
		sa.assertAll();
		log.info("Evaluation working as expected");
	}

	// Verify the candidate's card displays the time of the creation of the card.
	public void verifyTimeOfCreation(CreateCandidatePojo cand) {
		log.info("Actual created on time of candidate : " + cand.getCreatedOnForCard());
		By createdOn = By.xpath("//*[text()='" + cand.getFullname()
				+ "']/parent::div/following-sibling::div/li[@id='Created on']/span");
		String createdOnTimeOnCard = getText(wait.forElementToBeVisible(driver.findElement(createdOn)));
		log.info("Created on time on card : " + createdOnTimeOnCard);
		Assert.assertEquals(createdOnTimeOnCard, cand.getCreatedOnForCard(), "created on time not match");
		log.info("Time of Creation matched succesfully");
	}

	// Verify the functionality of the note button on the pipeline page.
	public void verifyNoteButton() {
		log.info("clicking on add note button");
		click(addNoteButton);
		sa.assertTrue(isDisplayed(noteTitle), "Note title field missing");
		sa.assertTrue(isDisplayed(noteDescription), "Note Description field missing");
		sa.assertTrue(isDisplayed(saveNote), "save Note Button missing");
		log.info("clicking on save button without adding note title to check error");
		click(saveNote);
		sa.assertTrue(verifyPopup("Please write note title"), "check popup text when title was not added");
		sendKeys(noteTitle, "Test note title");
		sa.assertEquals(getAttribute(noteTitle, "value"), "Test note title", "check note title entered");
		log.info("clicking on save button without adding note Description to check error");
		click(saveNote);
		sa.assertTrue(verifyPopup("Please write note title and description"),
				"check popup text when description was not added");
		sendKeys(noteDescription, "Test note description");
		sa.assertEquals(getText(noteDescription), "Test note description", "check note Description entered");
		log.info("clicking on save to check if note gets added");
		click(saveNote);
		sa.assertTrue(verifyPopup("Note added"), "check popup text after note is added");
		sa.assertEquals(getText(noteCount), "1", "note count not increased after note added");
		sa.assertAll();
		log.info("add note button working as expected");
	}

//	Verify that the note button displays the count of the notes on the pipeline page.
	public void verifyCountOfNotesAdded() {
		click(addNoteButton);
		sendKeys(noteTitle, "Test note title");
		sendKeys(noteDescription, "Test note description");
		click(saveNote);
		click(closePopup);
		log.info("added first note added :" + getText(noteCount));
		sa.assertEquals(getText(noteCount), "1", "check count when first note added");
		
		click(addNoteButton);
		sendKeys(noteTitle, "Test note title 2");
		sendKeys(noteDescription, "Test note description 2");
		click(saveNote);
		click(closePopup);
		log.info("added second note added :" + getText(noteCount));
		sa.assertEquals(getText(noteCount), "2", "check count when second note added");
		
		sa.assertAll();
		log.info("Note count working as expected");
	}

	public void verifyEditCandidateButton(String candName, String candId, String jobId) {

		By edit = By
				.xpath("//span[text()='"+candName+"']/parent::div/following-sibling::div[@class='mx-2 py-1 d-flex align-items-center w-50 justify-content-between gap_lg']/following-sibling::footer/li[@id='Edit']");
		click(wait.forElementToBeVisible(driver.findElement(edit)));
		log.info("clicked on Edit of candidate " + candName);
		sa.assertTrue(driver.getCurrentUrl().contains(candId + "/overview"),
				"user not navigated to candidate edit page " + driver.getCurrentUrl()); 
		fullName.clear();
	/*	try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		sendKeys(fullName, "Edit can");
		click(saveCandidate);
		jp.goToJobs();
		jp.goToPipeline(jobId);
		sa.assertTrue(isDisplayed(candidateName), "Name is not displayed");
		sa.assertEquals(getText(candidateName), "Edit Can", "Name does not match");
		sa.assertAll();
		log.info("Edit candidate button working as expected");

	}

	public void verifyMoveCandidateDropdown(String stage, String candidate) {
		click(moveCandidateDropdownButton);
		sa.assertTrue(isDisplayed(moveCandidateDropdown), "Dropdown not displayed when clicked on button");
		WebElement stageToBeMoved = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//div[@class='dropdown-menu py-0 show']/p[text()='" + stage + "']")));
		click(stageToBeMoved);
		sa.assertTrue(verifyPopup("Stage changed"), "check popup text when stage changed");
		By c = By.xpath("//*[contains(text(),'" + stage + "')]/parent::div/following-sibling::div/div/div/span");
		List<WebElement> candidates = wait.forAllElementToBeVisible(driver.findElements(c));
		List<String> candidateNames = getTextList(candidates);
		log.info("candidates present in " + stage + " stage " + candidateNames);
		sa.assertTrue(candidateNames.contains(candidate), "candidate not moved to " + stage);
		sa.assertAll();
		log.info("moved " + candidate + " to " + stage + " stage");
		log.info("moved candidate dropdown working as expected");
	}

	///////////////////////////////////////////////////////////////////////////////////////////

	public void changeStage(String stage) {
		click(moveCandidateDropdownButton);
		WebElement stageToBeMoved = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//div[@class='dropdown-menu py-0 show']/p[text()='" + stage + "']")));
		click(stageToBeMoved);
		click(closePopup);
	}

	public boolean verifyPopup(String expectedText) {
		boolean flag = false;
		log.info("Text present in popup :" + getText(alert));
		if (getText(alert).contains(expectedText))
			flag = true;
		click(closePopup);
		return flag;
	}

}
