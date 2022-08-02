package pages.Home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import PojoClasses.CreateCandidatePojo;
import PojoClasses.JobPostingPojo;
import commons.BasePage;
import pages.Jobs.CreateNewJobPage;

public class CandidatesPage extends BasePage {

	public CandidatesPage(WebDriver driver) {
		super(driver);
	}

	SoftAssert sa = new SoftAssert();
	JobsPage jp = new JobsPage(driver);
	CreateNewJobPage cp = new CreateNewJobPage(driver);
	HomePage hp = new HomePage(driver);

	private static final Logger log = LogManager.getLogger(CandidatesPage.class.getName());
//	@FindBy(xpath = "//ul[@id='layout']/a[2]")
//	private WebElement candidates;
	@FindBy(xpath = "//div/li[1]")
	private WebElement candidateHeading;

	/////////////// Add Candidate Form webElements////////////
	//////////////////////////////////////////////////////////
	@FindBy(xpath = "//button") // button[text()='+ Add Candidates']
	private WebElement addCandidate;
//	@FindBy(xpath = "//button[text()='Add Manually']")
//	private WebElement addManually;
	@FindBy(xpath = "//div[@class='pt-3 pb-0 container-fluid']")
	private WebElement addCandidateForm;
	@FindBy(xpath = "//div/ul/li[1]/a/span[text()='Overview']")
	private WebElement overviewTab;
	@FindBy(xpath = "//div/ul/li[2]/a/span[text()='Docs']")
	private WebElement docsTab;
	@FindBy(xpath = "//*[@class='navbar-nav py-2']/li[2]")
	private WebElement docsCount;
	@FindBy(xpath = "//div/ul/li[3]/a/span[text()='Notes']")
	private WebElement notesTab;
	@FindBy(xpath = "//*[@class='navbar-nav py-2']/li[3]")
	private WebElement notesCount;
	@FindBy(xpath = "//div/ul/li[4]/a/span[text()='Email']")
	private WebElement emailTab;
	@FindBy(xpath = "//*[@class='navbar-nav py-2']/li[4]")
	private WebElement emailCount;
	@FindBy(xpath = "//label[@for='image']/div/img")
	private WebElement profilePic;
	@FindBy(xpath = "//label/div/img")
	private WebElement uploadedProfilePic;
	@FindBy(css = "#Delete > svg")
	private WebElement deleteProfilePic;
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement fullName;
	@FindBy(xpath = "//div/div[1]/div[6]/p")
	private WebElement fullNameError;
	@FindBy(xpath = "//span[text()='Tags']/following-sibling::div/input")
	private WebElement tags;
	@FindBy(xpath = "//span[text()='Tags']/following-sibling::div/div/div[1]")
	private List<WebElement> tagsAdded;
	@FindBy(xpath = "//span[text()='Tags']/following-sibling::div/div/div[2]")
	private WebElement clearTagButton;
	@FindBy(xpath = "//span[text()='Mobile']/following-sibling::div/input")
	private WebElement mobile;
	@FindBy(xpath = "//span[text()='Mobile']/following-sibling::div/div/div[1]")
	private List<WebElement> mobileAdded;
	@FindBy(xpath = "//span[text()='Mobile']/following-sibling::div/div/div[2]")
	private WebElement clearMobileButton;
	@FindBy(xpath = "//*[text()='Mobile']/parent::div/following-sibling::div[2]/p")
	private WebElement mobileError;
	@FindBy(xpath = "//span[text()='Email']/following-sibling::div/input")
	private WebElement email;
	@FindBy(xpath = "//span[text()='Email']/following-sibling::div/div/div[1]")
	private List<WebElement> emailAdded;
	@FindBy(xpath = "//span[text()='Email']/following-sibling::div/div/div[2]")
	private WebElement clearEmailButton;
	@FindBy(xpath = "//*[text()='Email']/parent::div/following-sibling::div[2]/p")
	private WebElement emailError;
	@FindBy(xpath = "//span[text()='Links']/following-sibling::div/input")
	private WebElement links;
	@FindBy(xpath = "//span[text()='Links']/following-sibling::div/div/div[1]")
	private List<WebElement> linksAdded;
	@FindBy(xpath = "//span[text()='Links']/following-sibling::div/div/div[2]")
	private WebElement clearLinksButton;
	@FindBy(xpath = "//*[text()='Links']/parent::div/following-sibling::div[2]/p")
	private WebElement linksError;
	@FindBy(xpath = "//span[text()='Social']/following-sibling::div/input")
	private WebElement social;
	@FindBy(xpath = "//span[text()='Social']/following-sibling::div/div/div[1]")
	private List<WebElement> socialAdded;
	@FindBy(xpath = "//span[text()='Social']/following-sibling::div/div/div[2]")
	private WebElement clearSocialButton;
	@FindBy(xpath = "//span[text()='Skill']/following-sibling::div/input")
	private WebElement skills;
	@FindBy(xpath = "//span[text()='Skill']/following-sibling::div/div/div[1]")
	private List<WebElement> skillsAdded;
	@FindBy(xpath = "//span[text()='Skill']/following-sibling::div/div/div[2]")
	private WebElement clearSkillButton;
	@FindBy(xpath = "//span[text()='Source']/following-sibling::div/input")
	private WebElement source;
	@FindBy(xpath = "//span[text()='Source']/following-sibling::div/div/div[1]")
	private List<WebElement> sourceAdded;
	@FindBy(xpath = "//span[text()='Source']/following-sibling::div/div/div[2]")
	private WebElement clearSourceButton;
	@FindBy(xpath = "//*[text()='Country']/following-sibling::div/div/div/div[2]/input")
	private WebElement country;
	@FindBy(xpath = "//*[text()='Country']/following-sibling::div/div/div/div/input")
	private WebElement countryBox;
	@FindBy(xpath = "//*[text()='Country']/parent::div/div/div/div[1]/div[1]")
	private WebElement selectedCountry;
	@FindBy(xpath = "//*[contains(@class,' css-1hb1tje-option')]")
	private List<WebElement> countryOptions;
	@FindBy(xpath = "//*[text()='State']/following-sibling::div/div/div/div[2]/input")
	private WebElement state;
	@FindBy(xpath = "//*[text()='State']/parent::div/div/div/div[1]/div[1]")
	private WebElement selectedState;
	@FindBy(xpath = "//*[contains(@class,' css-1hb1tje-option')]")
	private List<WebElement> stateOptions;
	@FindBy(xpath = "//*[text()='State']/following-sibling::div/div/div/div/input")
	private WebElement stateBox;
	@FindBy(xpath = "//div[text()='City']/following-sibling::input[@type='text']")
	private WebElement city;
	@FindBy(xpath = "//p[@class='mb-0 my-1 text-danger font_tiny font_medium' and contains(text(),'City')]")
	private WebElement cityError;
	@FindBy(xpath = "(//input[@type='text'])[5]")
	private WebElement pincode;
	@FindBy(xpath = "//p[@class='mb-0 my-1 text-danger font_tiny font_medium' and contains(text(),'Pincode')]")
	private WebElement pincodeError;
	@FindBy(xpath = "//input[@type='number']")
	private WebElement currentCTC;
	@FindBy(xpath = "//div[text()='No options']")
	private WebElement noOptions;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveCandidate;
	@FindBy(xpath = "//*[@class='Toastify']/div[1]/div/div[1]")
	private WebElement candAddedMsg;

	/////// Candidates docs webelement

	@FindBy(xpath = "//span/label")
	private WebElement docsUpload;
	@FindBy(xpath = "//div[@class='row']/div[@class='col-3']")
	private WebElement uploadedDoc;

	@FindBy(xpath = "//div[@class='react-confirm-alert']/div")
	private WebElement deleteCandidateConfirmation;
	@FindBy(xpath = "//div[@class=' css-nwjfc']/input")
	private WebElement assignJobs;
//	@FindBy(xpath="//div[@class='pt-3 pb-0 container-fluid']")
//	private WebElement addCandidateForm;
	@FindBy(xpath = "//div[@class='react-confirm-alert']/div/div/button[1]")
	private WebElement yesDelete;
	@FindBy(xpath = "//div[@class='react-confirm-alert']/div/div/button[2]")
	private WebElement noDelete;
	@FindBy(xpath = "//input[@type='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(id = "Actions")
	private WebElement actionsButton;
	@FindBy(xpath = "//div[@class='position-relative']/button")
	private List<WebElement> actions;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelAddTags;
	@FindBy(xpath = "//td/span[2]")
	private List<WebElement> candidatesList;
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alert;
	@FindBy(css = ".Toastify>div>div>button")
	private WebElement closePopup;

	/////////////// Candidate Grid webElements////////////
	//////////////////////////////////////////////////////////

	@FindBy(xpath = "//div/ul[contains(@class,'py-2')]/li[1]")
	private WebElement newCandidates;
	@FindBy(xpath = "//div/ul[contains(@class,'py-2')]/li[2]/span")
	private WebElement qualifiedCandidates;
	@FindBy(xpath = "//div/ul[contains(@class,'py-2')]/li[3]/span")
	private WebElement notQualifiedCandidates;
	@FindBy(xpath = "//div/ul[contains(@class,'py-2')]/li[4]")
	private WebElement notContactedCandidates;
	@FindBy(xpath = "//td[1]/div/span")
	private List<WebElement> candidateNames;
	@FindBy(xpath = "//*[@class='d-flex d-lg-none']//tbody/tr/td[3]")
	private List<WebElement> stages;
	@FindBy(xpath = "//div[@class='d-flex align-items-center w-100']/parent::td[1]")
	private List<WebElement> candidateIds;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement search;

	/////////////// Filter webElements////////////
	//////////////////////////////////////////////////////////
	@FindBy(xpath = "//span[@id='Filters']")
	private WebElement filter;
	@FindBy(css = "div.align-self-center.d-flex.align-items-center > svg")
	private WebElement clearFilterCross;

	@FindBy(xpath = "//span[@id='Filters']/following-sibling::div/div[2]/button")
	private WebElement addTags;
	@FindBy(xpath = "//span[@id='Filters']/following-sibling::div/div[3]/button")
	private WebElement sendEmail;
	@FindBy(xpath = "//span[@id='Filters']/following-sibling::div/div[4]/button")
	private WebElement changeStatus;
	@FindBy(xpath = "//td/div/input[@id='0']")
	private WebElement firstCheckbox;
	@FindBy(xpath = "//th/input")
	private WebElement selectAll;
	@FindBy(xpath = "//td/div/input")
	private List<WebElement> allCheckbox;
	@FindBy(xpath = "//header/h4")
	private WebElement actionHeader;
	@FindBy(xpath = "(//header/div)[2]")
	private WebElement candidatesCountOnPopup;
	@FindBy(xpath = "//*[@class='react-tag-input']/input")
	private WebElement addTagInput;
	@FindBy(xpath = "//*[@class='react-tag-input']/div/div[1]")
	private List<WebElement> tagsAddedToField;
	@FindBy(xpath = "//*[@class='react-tag-input']/div/div[2]")
	private WebElement clearTag;
	@FindBy(xpath = "//header/following-sibling::div/div[2]/button[2]")
	private WebElement addTagsSave;
	@FindBy(xpath = "//header/following-sibling::div/div[2]/button[1]")
	private WebElement addTagsCancel;
	@FindBy(xpath = "//main/following-sibling::button")
	private WebElement closeButton;
	@FindBy(xpath = "//*[text()='Subject']/following-sibling::input")
	private WebElement mailSubject;
	@FindBy(xpath = "//body[@id='tinymce']/p")
	private WebElement mailBody;
	@FindBy(xpath = "//iframe[contains(@id,'tiny-react')]")
	private WebElement mailBodyFrame;

	@FindBy(xpath = "//div/div[3]/button[text()='Send']")
	private WebElement sendButton;
	@FindBy(xpath = "//button[@class='text_darkgray px-2 font_sm common_button  py-1']")
	private WebElement sendEmailCancel;
	@FindBy(xpath = "//header/following-sibling::div/div[1]/p")
	private WebElement mailSubjectError;
	@FindBy(xpath = "//header/following-sibling::div/div[2]/p")
	private WebElement mailBodyError;

	@FindBy(xpath = "//*[@class='d-flex flex-wrap my-2']/div")
	private List<WebElement> changeStatusStages;
	@FindBy(xpath = "//*[@class='d-flex flex-wrap my-2']/div[@id='qualified']")
	private WebElement changeStatusQualified;
	@FindBy(xpath = "//*[@class='d-flex flex-wrap my-2']/div[@id='rejected']")
	private WebElement changeStatusRejected;

	// Overview web elements

	@FindBy(xpath = "//label[@for='file-resume']")
	private WebElement uploadResumeButton;

	@FindBy(xpath = "//div[@class='react-pdf__Document m-0']")
	private WebElement resumePreview;

	@FindBy(xpath = "//span[text()='Resume']/following-sibling::div/a")
	private WebElement uploadedResume;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	private WebElement deleteResumeButton;

	@FindBy(xpath = "//button[normalize-space()='Download']")
	private WebElement downloadResumeButton;

	@FindBy(xpath = "//button[@class='px-3 py-1 font_sm font_medium blue_button_hover common_button bg-blue text-white']")
	private WebElement saveResumeButton;
	@FindBy(xpath = "//*[@class='react-pdf__Page']")
	private WebElement resumePage;
	@FindBy(xpath = "//button[text()='Next Page']/preceding-sibling::p")
	private WebElement resumePagesCount;
	@FindBy(xpath = "//button[@class='btn font_sm font_medium hoverblack']")
	private WebElement nextPageResumeButton;
	@FindBy(xpath = "//button[@class='btn font_sm font_semibold hoverblack mr-2']")
	private WebElement prevPageResumeButton;
	@FindBy(xpath = "//div[@class='col-12 w-100 mb-0 my-1 text-danger font_tiny font_medium']")
	private WebElement uploadResumeError;

	@FindBy(xpath = "//*[text()='Assign Job']/following-sibling::div/div/div/div[2]/input")
	private WebElement assignJobInput;
	@FindBy(xpath = "//*[text()='Job assignments']/following-sibling::div/div/div/div/input")
	private WebElement assignJobInputBox;

	@FindBy(xpath = "//span[text()='Job assignments']/following-sibling::div/div//following-sibling::div[@class=' css-11ei81s-indicatorContainer']")
	private WebElement assign;

	@FindBy(xpath = "//div[@class=' css-1hb1tje-option']")
	private List<WebElement> assignOptions;

	@FindBy(xpath = "(//div[@class=' css-1wy0on6'])[3]")
	private WebElement assignNewJob;

	@FindBy(xpath = "//div[@class='css-xb97g8']")
	private WebElement assignCrossButton;

	@FindBy(xpath = "//div[@class=' css-1hwfws3']")
	private WebElement assignJobField;

	@FindBy(xpath = "//div[@class='css-12jo7m5']")
	private List<WebElement> selectedJob;

	@FindBy(xpath = "//div[@class=' css-1hwfws3']")
	private WebElement selectedJobs;

	@FindBy(xpath = "(//button[text()='Save'])[2]")
	private WebElement saveButtonForJob;

	@FindBy(xpath = "//button[@class='px-3 py-1 align-self-end blue_button_hover font_sm font_medium bg-blue text-white mt-3']")
	private WebElement saveAssignButton;

	@FindBy(xpath = "(//input)[15]")
	private WebElement assignInput;

	// Docs web elements

	@FindBy(xpath = "//div[@class='text-center']/div")
	private List<WebElement> docsPresent;

	@FindBy(xpath = "//div[@class='text-center']/div")
	private WebElement docPresent;

	@FindBy(xpath = "//label[@for='docs']")
	private WebElement docsUploadFilesButton;

	@FindBy(xpath = "//small[@class='font_sm text-danger font_medium']")
	private WebElement docsUploadFilesError;

	@FindBy(xpath = "//div[@id='Delete']")
	private WebElement docsDeleteFilesButton;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement docsDeleteFilesYesButton;

	@FindBy(xpath = "//div[@class='bg_faintgray commontooltip common-tooltip-right mt-1 d-flex align-items-center justify-content-center cursor rounded-circle']")
	private WebElement docsDownloadFilesButton;

	@FindBy(xpath = "")
	private WebElement docId;

	@FindBy(xpath = "//span[text()='Docs']/parent::a/parent::li")
	private WebElement docsCounts;

	// Notes tab elements
	@FindBy(xpath = "(//li[@class='mr-3 nav-item text_darkgray font_semibold text-decoration-none position-relative candidateHeaderDocs'])[2]")
	private WebElement notesCounts;

	@FindBy(xpath = "//button[@class='font_sm bg-blue border-0 px-lg-3 px-2 button_py text-white font_medium blue_button_hover']")
	private WebElement addNotesButton;

	@FindBy(xpath = "//div[@class='p-2 mt-2 box_shadow d-flex flex-column overflow-hidden bg-light box-shadow position-absolute']")
	private WebElement addNotesPopup;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement notesTitle;

	@FindBy(xpath = "//li[@class='mb-1 text_darkgray font_medium word-break line_height']")
	private List<WebElement> allNotesTitle;

	@FindBy(xpath = "//li[@class='mb-1 text_darkgray font_medium word-break line_height']")
	private WebElement singleNotesTitle;

	@FindBy(xpath = "//li[@class='text_darkgray word-break font_sm']")
	private List<WebElement> allNotesDesc;

	@FindBy(xpath = "//li[@class='text_darkgray word-break font_sm']")
	private WebElement singleNotesDesc;

	@FindBy(xpath = "//div[@class='shadow-sm pt-3 candidate-note-card align-self-stretched']")
	private WebElement noteBook;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	private WebElement notesDesc;

	@FindBy(xpath = "//*[@class='d-flex justify-content-end']/button[1]")
	private WebElement notesSaveButton;

	@FindBy(xpath = "//span[@class='ml-1 font_tiny align-self-center font_medium text_darkgray']")
	private WebElement noteTime;

	@FindBy(xpath = "//li[@class='p-0 ml-auto border-0 p-1 cursor rounded-0 font_tiny font_medium']")
	private WebElement noteEdit;

	@FindBy(xpath = "//li[@class='p-0 border-0 cursor text-danger p-1 rounded-0 font_tiny font_medium']")
	private WebElement noteDelete;

	@FindBy(xpath = "//button[@class='bg-blue text-white px-4 py-1 commonHoverEffect font_sm border-0 ']")
	private WebElement noteDeleteButton;

	@FindBy(xpath = "//button[@class='common_button border-0  px-4 py-1 bg_darkgray font_sm']")
	private WebElement noteDeleteCancelButton;

	// Email tab elements
	@FindBy(xpath = "//span[normalize-space()='Email']")
	private WebElement emailTabButton;

	@FindBy(xpath = "//button[normalize-space()='Compose']")
	private WebElement composeButton;

	@FindBy(xpath = "//select[@class='ml-lg-3 ml-2 border-0 p-1']")
	private WebElement emailToButton;

	@FindBy(xpath = "//input[@placeholder='Title']")
	private WebElement emailTitleField;

	@FindBy(xpath = "//body[@class='mce-content-body ']")
	private WebElement emailBodyField;

	@FindBy(xpath = "//iframe[@title='Rich Text Area']")
	private WebElement iFrame;

	@FindBy(xpath = "//div[@class='text_darkgray font_medium']")
	private WebElement emailAttachFileButton;

	@FindBy(xpath = "//button[@class='font_sm  text_dark p-1 px-lg-3 px-2 font_medium common_button bg_lightgray']")
	private WebElement emailCancelButton;

	@FindBy(xpath = "//div[@class=' css-xhupmv-control']")
	private WebElement countDropdown;
	@FindBy(xpath = "//div[@class=' css-1d8n9bt']/parent::div")
	private WebElement dropDown;
	@FindBy(xpath = "//div[@class=' css-1hb1tje-option']")
	private List<WebElement> dropDownOptions;
	@FindBy(xpath = "//li/a[@rel='prev']")
	private WebElement previousPageButton;
	@FindBy(xpath = "//li/a[@rel='next']")
	private WebElement nextPageButton;
	@FindBy(xpath = "//span[@class='common-title-class position-relative flex-1']")
	private List<WebElement> candsOnPage;
	@FindBy(xpath = "//button[text()='Reject']")
	private WebElement rejectButton;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement rejectCancelButton;

	public void verifyNewCandidatesTab(List<String> candidates) {
		List<String> candidateIdsOnTab = getCandidates("new");
		List<String> stagesOnTab = getTextList(stages);
		log.info("candidates present on tab : " + candidateIdsOnTab);
		log.info("stages present on tab : " + stagesOnTab);
		for (String cand : candidates)
			sa.assertTrue(candidateIdsOnTab.contains(cand), cand + " candidate is missing");
		for (String s : stagesOnTab) {
			boolean flag = s.equalsIgnoreCase("Applied") || s.equalsIgnoreCase("NA");
			sa.assertTrue(flag, "check stages column");
		}
		sa.assertAll();
		log.info("New candidates tab working as expected");
	}

	public void verifyQualifiedCandidatesTab(List<String> candidates) {
		List<String> candidateIdsOnTab = getCandidates("qualified");
		List<String> stagesOnTab = getTextList(stages);
		log.info("candidates present on tab : " + candidateIdsOnTab);
		log.info("stages present on tab : " + stagesOnTab);
		for (String cand : candidates)
			sa.assertTrue(candidateIdsOnTab.contains(cand), cand + " candidate is missing");
		for (String s : stagesOnTab)
			sa.assertEquals(s, "Qualified", "check stages column");
		sa.assertAll();
		log.info("Qualified candidates tab working as expected");
	}

	public void verifyNotQualifiedCandidatesTab(List<String> candidates) {
		List<String> candidateIdsOnTab = getCandidates("notqualified");
		List<String> stagesOnTab = getTextList(stages);
		log.info("candidates present on tab : " + candidateIdsOnTab);
		log.info("stages present on tab : " + stagesOnTab);
		for (String cand : candidates)
			sa.assertTrue(candidateIdsOnTab.contains(cand), cand + " candidate is missing");
		for (String s : stagesOnTab)
			sa.assertEquals(s, "Rejected", "check stages column");
		sa.assertAll();
		log.info("Not Qualified candidates tab working as expected");
	}

	public void verifyNotContactedCandidatesTab(List<String> candidates) {
		List<String> candidateIdsOnTab = getCandidates("notcontacted");
		List<String> stagesOnTab = getTextList(stages);
		log.info("candidates present on tab : " + candidateIdsOnTab);
		log.info("stages present on tab : " + stagesOnTab);
		for (String cand : candidates)
			sa.assertTrue(candidateIdsOnTab.contains(cand), cand + " candidate is missing");
		for (String s : stagesOnTab)
			sa.assertEquals(s, "Shortlisted", "check stages column");
		sa.assertAll();
		log.info("Not Contacted candidates tab working as expected");
	}

	public void verifyFiltersButton() {
		click(filter);
		sa.assertTrue(isDisplayed(addTags), "add tags option Not displayed");
		sa.assertTrue(isDisplayed(sendEmail), "send Email option Not displayed");
		sa.assertTrue(isDisplayed(changeStatus), "change Status option Not displayed");
		sa.assertAll();
		log.info("Filter button working as expected");

	}

	public void verifyClearFilter() {
		click(filter);
		log.info("clicked on filter button to open filters options");
		sa.assertTrue(isDisplayed(addTags), "add tags option Not displayed");
		sa.assertTrue(isDisplayed(sendEmail), "send Email option Not displayed");
		sa.assertTrue(isDisplayed(changeStatus), "change Status option Not displayed");
		click(filter);
		log.info("clicked on filter button to close filters options");
		sa.assertFalse(isDisplayed(addTags), "add tags option displayed even after closing filter");
		sa.assertFalse(isDisplayed(sendEmail), "send Email option displayed even after closing filter");
		sa.assertFalse(isDisplayed(changeStatus), "change Status option displayed even after closing filter");
		click(filter);
		log.info("clicked on filter button to open filters options to verify cross button");
		sa.assertTrue(isDisplayed(addTags), "add tags option Not displayed again for cross button");
		sa.assertTrue(isDisplayed(sendEmail), "send Email option Not displayed again for cross button");
		sa.assertTrue(isDisplayed(changeStatus), "change Status option Not displayed again for cross button");
		click(clearFilterCross);
		log.info("clicked on cross button to close filters options");
		sa.assertFalse(isDisplayed(addTags), "add tags option displayed even after cliking cross button of filter");
		sa.assertFalse(isDisplayed(sendEmail), "send Email option displayed even after cliking cross button of filter");
		sa.assertFalse(isDisplayed(changeStatus),
				"change Status option displayed even after cliking cross button of filter");
		sa.assertAll();
	}

	public void verifyIndividualCheckbox() {
		log.info("checking checkbox before selecting : " + firstCheckbox.isSelected());
		sa.assertFalse(firstCheckbox.isSelected(), "check box was selected before any clicking");
		click(firstCheckbox);
		log.info("clicking on checkbox to select");
		log.info("checking checkbox after selecting : " + firstCheckbox.isSelected());
		sa.assertTrue(firstCheckbox.isSelected(), "check box was Not selected even after clicking");
		click(firstCheckbox);
		log.info("clicking again on checkbox to Deselect");
		log.info("checking checkbox after Deselecting  : " + firstCheckbox.isSelected());
		sa.assertFalse(firstCheckbox.isSelected(), "check box was selected even after Deselecting ");
		sa.assertAll();
		log.info("Individual checkbox working as expected");
	}

	public void verifySelectAllCheckbox() {

		log.info("checking checkboxes before selecting Select All checkbox: ");
		sa.assertFalse(selectAll.isSelected(), "Select All checkbox was selected before any activity");
		for (int i = 0; i < allCheckbox.size(); i++)
			sa.assertFalse(allCheckbox.get(i).isSelected(),
					i + "th check box was selected before selecting Select All checkbox");
		click(selectAll);
		log.info("clicking on Select All checkbox ");
		log.info("checking checkboxes after selecting Select All checkbox");
		for (int i = 0; i < allCheckbox.size(); i++)
			sa.assertTrue(allCheckbox.get(i).isSelected(),
					i + "th check box was Not selected even After selecting Select All checkbox");
		sa.assertTrue(selectAll.isSelected(),
				"Select All checkbox was Not selected even After selecting Select All checkbox");
		click(selectAll);
		log.info("clicking again on Select All checkbox to Deselect");
		log.info("checking checkbox after Deselecting Select All checkbox");
		sa.assertFalse(selectAll.isSelected(), "Select All check box was selected even after Deselecting");
		for (int i = 0; i < allCheckbox.size(); i++)
			sa.assertFalse(allCheckbox.get(i).isSelected(), i + "th check box was selected even after Deselecting ");

		sa.assertAll();
		log.info("select All checkbox working as expected");
	}

	// Verify the functionality of the Add Tags button.
	public void verifyAddTagsButton() {
		doAction("add tags");
		sa.assertTrue(getText(actionHeader).contains("Tag"), "Check header of popup of Add Tags button");
		sa.assertTrue(isDisplayed(addTagInput), "Add tags input field missing");
		sa.assertAll();
		log.info("Add tags button working as expected");
	}

	// Verify the count of the selected candidates is visible inside add tags pop-up
	// Verify the count of the selected candidate's count is displayed inside the
	// send email popup
	public void verifyCountOfCandidatesOnFilterPopup(String type, int count) {
		int actualCount = 0;
		selectCandidates(count);
		log.info("selected " + count + " candidates ");
		if (type.equalsIgnoreCase("add tags"))
			doAction(type);
		if (type.equalsIgnoreCase("send Email"))
			doAction(type);
		if (type.equalsIgnoreCase("change status"))
			doAction(type);
		log.info("Actual count present on " + type + " popup :" + getText(candidatesCountOnPopup).substring(0, 1));
		actualCount = Integer.parseInt(getText(candidatesCountOnPopup).substring(0, 1));
		Assert.assertEquals(count, actualCount, "Count on " + type + "popup did not match with selected candidates");
		log.info("Count of candidates on " + type + " popup match with number of candidates selected");
	}

//	Verify the functionality of the Add Tag field.
//	Verify the tags are not saved to the field if users fail to press enter button.
//	Verify users can clear the tag by clicking on the cross button inside the tag.
//	Verify users can clear the tag by using the backspace button.
	public void verifyAddTagsField(String tag1, String tag2, String tag3) {
		selectCandidates(6);
		doAction("add tags");
		sendKeys(addTagInput, tag1);
		sendKeys(addTagInput, Keys.ENTER);
		sendKeys(addTagInput, tag2);
		sendKeys(addTagInput, Keys.ENTER);
		sendKeys(addTagInput, tag3);
		sendKeys(addTagInput, Keys.ENTER);
		List<String> tagsAdded = getStringListFromWebElementList(tagsAddedToField);
		log.info("Added tags :" + tagsAdded);
		sa.assertTrue(tagsAdded.contains(tag1), tag1 + " tag missing");
		sa.assertTrue(tagsAdded.contains(tag2), tag2 + " tag missing");
		sa.assertTrue(tagsAdded.contains(tag3), tag3 + " tag missing");
		sendKeys(addTagInput, Keys.BACK_SPACE);
		log.info("Pressed Backspace button to remove last tag");
		List<String> tagsAddedAfterBackSpace = getStringListFromWebElementList(tagsAddedToField);
		log.info("Tags after pressing backspace :" + tagsAddedAfterBackSpace);
		sa.assertTrue(tagsAddedAfterBackSpace.contains(tag1), tag1 + " tag missing after pressing backspace");
		sa.assertTrue(tagsAddedAfterBackSpace.contains(tag2), tag2 + " tag missing after pressing backspace");
		sa.assertFalse(tagsAddedAfterBackSpace.contains(tag3),
				tag3 + " tag Still present even after pressing backspace");
		click(clearTag);
		log.info("Removing first tag using cross button");
		List<String> tagsAfterRemovingFirstTag = getStringListFromWebElementList(tagsAddedToField);
		log.info("Tags after pressing cross button :" + tagsAfterRemovingFirstTag);
		sa.assertFalse(tagsAfterRemovingFirstTag.contains(tag1),
				tag1 + " tag Still present even after clicking on cross button");
		sa.assertTrue(tagsAfterRemovingFirstTag.contains(tag2), tag2 + " tag missing after clicking cross button");
		sa.assertFalse(tagsAfterRemovingFirstTag.contains(tag3),
				tag3 + " tag Still present after clicking cross button");
		sa.assertAll();
		log.info("Add Tags field working as expected");
	}

	// Verify the save button is disabled if the candidates are not selected.
//	Verify the save button is disabled if the field is empty.
	public void verifySaveButtonOnAddTags() {
		doAction("add tags");
		sendKeys(addTagInput, "Test Tag");
		sendKeys(addTagInput, Keys.ENTER);
		log.info("checking save button without selecting any candidates ");
		log.info("Status of save button without selecting any candidates : " + addTagsSave.isEnabled());
		sa.assertFalse(addTagsSave.isEnabled(), "Save button enabled even without adding candidates");
		click(clearTag);
		click(addTagsCancel);
		log.info("cancelling add tags to add candidates ");
		selectCandidates(5);
		log.info("Selected 5 candidates ");
		click(addTags);
		log.info("checking save button without adding any tags ");
		log.info("Status of save button without adding any tags : " + addTagsSave.isEnabled());
		sa.assertFalse(addTagsSave.isEnabled(), "Save button enabled even without adding Tags");
		sendKeys(addTagInput, "Test Tag1");
		// addTagInput.sendKeys(Keys.ENTER);
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		// sendKeys(addTagInput, Keys.ENTER);
		sendKeys(addTagInput, "Test Tag2");
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// addTagInput.sendKeys(Keys.ENTER);
		// sendKeys(addTagInput, Keys.ENTER);
		log.info("checking save button After selecting candidates and adding tags ");
		log.info("Status of save button After selecting candidates and adding tags  : " + addTagsSave.isEnabled());
		sa.assertTrue(addTagsSave.isEnabled(), "Save button Disabled even After selecting candidates and adding tags");
		sa.assertAll();
		log.info("save button on add tags working as expected");
	}

	// Verify users can close the pop-up by clicking on the cross button inside the
	// pop-up.
	public void verifyCloseButtonOnAddTags() {
		doAction("add tags");
		click(closeButton);
		log.info("clicked on close(cross) Button");
		// wait.forInvisibilityOfElement(actionHeader);
		while (isDisplayed(actionHeader)) {
			// log.info(waiting for actionHeader to get closed);
		}
		Assert.assertFalse(isDisplayed(actionHeader),
				"Add tags filed still present even after clicking on cross Button");
		log.info("Close Button On Add Tags working as expected");
	}

	// Verify the functionality of the Cancel button.
	public void verifyCancelButtonOnAddTags() {
		doAction("add tags");
		click(addTagsCancel);
		log.info("clicked on cancel Button");
		// wait.forInvisibilityOfElement(actionHeader);
		while (isDisplayed(actionHeader)) {
			// log.info("waiting for actionHeader to get closed");
		}
		Assert.assertFalse(isDisplayed(actionHeader),
				"Add tags filed still present even after clicking on Cancel Button");
		log.info("Cancel Button On Add Tags working as expected");
	}

	// Verify a confirmation message is shown after saving the tags.
	public void verifyAddTagsFunctionality(List<String> candidates) {
		for (String cand : candidates)
			selectCandidateById(cand);
		log.info("selected candidate for adding tags to it " + candidates);
		doAction("add tags");
		sendKeys(addTagInput, "Test Tag1");
		sendKeys(addTagInput, Keys.ENTER);
		sendKeys(addTagInput, "Test Tag2");
		sendKeys(addTagInput, Keys.ENTER);
		log.info("added two test tags");
		click(addTagsSave);
		sa.assertTrue(verifyPopup("Tags Added"), "check validation text after tags are added");
		log.info("clicked on save on add tags popup");
		for (String cand : candidates) {
			editCandidateById(cand);
			sa.assertTrue(getTags().contains("Test Tag1"), "Test Tag1 did not get add to candidate " + cand);
			sa.assertTrue(getTags().contains("Test Tag2"), "Test Tag1 did not get add to candidate " + cand);
			hp.goToCandidates();
		}
		sa.assertAll();
		log.info("add tags functionality working as expected");
	}

	// Verify the functionality of the Send Email button inside the filters option.
	public void verifySendEmailButton() {
		click(filter);
		click(sendEmail);
		log.info("clicked on send email button");
		sa.assertTrue(getText(actionHeader).contains("email"), "check header of popup");
		sa.assertTrue(isDisplayed(mailSubject), "Mail subject field not displayed");
		driver.switchTo().frame(mailBodyFrame);
		sa.assertTrue(isDisplayed(mailBody), "Mail body field not displayed");
		driver.switchTo().parentFrame();
		sa.assertAll();
		log.info("Send email button working as expected");
	}

	// Verify the functionality of the subject field.
	public void verifyMailSubjetField() {
		selectCandidates(5);
		doAction("send email");
		log.info("clicked on send email filter");
		sa.assertTrue(getText(mailSubjectError).isEmpty(),
				"Error present before clicking on send button : " + getText(mailSubjectError));
		click(sendButton);
		log.info("clicked on send button without entering mail subject to check error");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sa.assertFalse(getText(mailSubjectError).isEmpty(),
				"Error not popped up even after keeping mail subject blank : " + getText(mailSubjectError));
		sa.assertEquals(getText(mailSubjectError), "This field is required",
				" wrong error text : " + getText(mailSubjectError));
		sendKeys(mailSubject, "Test email subject");
		click(sendButton);
		sa.assertTrue(getText(mailSubjectError).isEmpty(),
				"Error still present even after entering value in mail subject : " + getText(mailSubjectError));
		sa.assertEquals(getAttribute(mailSubject, "value"), "Test email subject",
				"Wrong subject got entered in field :" + getAttribute(mailSubject, "value"));
		sa.assertAll();
		log.info("mail subject field working as expected");

	}

//Verify the functionality of the Body field.
	public void verifyMailBodyField() {
		selectCandidates(5);
		doAction("send email");
		log.info("clicked on send email filter");
		sa.assertTrue(getText(mailBodyError).isEmpty(),
				"Error present before clicking on send button : " + getText(mailBodyError));
		click(sendButton);
		log.info("clicked on send button without entering mail body to check error");
		sa.assertFalse(getText(mailBodyError).isEmpty(),
				"Error not popped up even after keeping mail body blank : " + getText(mailBodyError));
		sa.assertEquals(getText(mailBodyError), "This field is required",
				" wrong error text : " + getText(mailBodyError));
		driver.switchTo().frame(mailBodyFrame);
		sendKeys(mailBody, "Test email body");
		driver.switchTo().parentFrame();
		click(sendButton);
		sa.assertTrue(getText(mailBodyError).isEmpty(),
				"Error still present even after entering value in mail body : " + getText(mailBodyError));
		driver.switchTo().frame(mailBodyFrame);
		sa.assertEquals(getText(mailBody), "Test email body", "Wrong body got entered in field :" + getText(mailBody));
		driver.switchTo().parentFrame();
		sa.assertAll();
		log.info("mail body field working as expected");
	}

	// Verify the send button is disabled if no candidate is selected.
	public void verifySendButton() {
		doAction("send email");
		log.info("clicked on send email filter without selecting candidates to check send button status : "
				+ sendButton.isEnabled());
		sa.assertFalse(sendButton.isEnabled(), "Send button enabled even without selecting candidates");
		click(closeButton);
		selectCandidates(4);
		log.info("selected candidates");
		click(sendEmail);
		// wait.forElementToBeVisible(sendButton);
		log.info("clicked on send email filter after selecting candidates to check send button status : "
				+ sendButton.isEnabled());
		sa.assertTrue(sendButton.isEnabled(), "Send button Still disabled even after selecting candidates");
		sa.assertAll();
		log.info("send button is disabled and enabled before and after selecting candidates");
	}

	// Verify the functionality of the Send button.
//	Verify a confirmation message is displayed after sending the email.
	public void verifySendEmailFunctionality(List<String> candidates) {
		for (String cand : candidates)
			selectCandidateById(cand);
		log.info("selected candidate for sending email to it " + candidates);
		doAction("send email");
		sendKeys(mailSubject, "Test Subject");
		log.info("Entered value in mail subject");
		driver.switchTo().frame(mailBodyFrame);
		sendKeys(mailBody, "Test Body");
		log.info("Entered value in mail body");
		driver.switchTo().parentFrame();
		click(sendButton);
		log.info("clicked on send email button");
		Assert.assertTrue(verifyPopup("Email Sent"), "check validation text after email is sent");
		log.info("send email functionality working as expected");

	}

	// Verify the functionality of the cross button inside the popup.
	public void verifyCloseButtonOnSendEmail() {
		doAction("send email");
		click(closeButton);
		log.info("clicked on close(cross) Button");
		// wait.forInvisibilityOfElement(actionHeader);
		while (isDisplayed(actionHeader)) {
			// log.info("waiting for actionHeaderto be closed");
		}
		Assert.assertFalse(isDisplayed(actionHeader),
				"Send email field still present even after clicking on cross Button");
		log.info("Close Button On Send Email working as expected");
	}

	// Verify the functionality of the Cancel button.
	public void verifyCancelButtonOnSendEmail() {
		doAction("send email");
		click(sendEmailCancel);
		log.info("clicked on cancel Button");
		// wait.forInvisibilityOfElement(actionHeader);
		while (isDisplayed(actionHeader)) {
			// log.info("waiting for actionHeaderto be closed");
		}
		Assert.assertFalse(isDisplayed(actionHeader),
				"Send email field still present even after clicking on Cancel Button");
		log.info("Cancel Button On Send Email working as expected");
	}

	public void verifyChangeStatusFunctionality(List<String> candidates) {
		selectCandidateById(candidates.get(0));
		selectCandidateById(candidates.get(1));
		selectCandidateById(candidates.get(2));
		log.info("selected candidates whose stage needs to be updated");
		doAction("change status");
		log.info("clicked on change status action");
		List<String> stagesPresent = getTextList(changeStatusStages);
		log.info("stages present on popup : " + stagesPresent);
		log.info("clicking on qualified stage to update stage to qualified");
		click(changeStatusQualified);
		List<String> qualfiedCandidates = getCandidates("qualified");
		sa.assertTrue(qualfiedCandidates.contains(candidates.get(0)), "1st candidate is missing");
		sa.assertTrue(qualfiedCandidates.contains(candidates.get(1)), "2nd candidate is missing");
		sa.assertTrue(qualfiedCandidates.contains(candidates.get(2)), "3rd candidate is missing");

		selectCandidateById(candidates.get(0));
		selectCandidateById(candidates.get(1));
		selectCandidateById(candidates.get(2));
		log.info("selected candidates whose stage needs to be updated");
		doAction("change status");
		log.info("clicking on rejected stage to update stage to rejected");
		click(changeStatusRejected);
		List<String> rejectedCandidates = getCandidates("notqualified");
		sa.assertTrue(rejectedCandidates.contains(candidates.get(0)), "1st candidate is missing");
		sa.assertTrue(rejectedCandidates.contains(candidates.get(1)), "2nd candidate is missing");
		sa.assertTrue(rejectedCandidates.contains(candidates.get(2)), "3rd candidate is missing");

		sa.assertAll();

	}

	// Verify the functionality of the cross button inside the popup.
	public void verifyCloseButtonOnChangeStatus() {
		doAction("change status");
		click(closeButton);
		log.info("clicked on close(cross) Button");
		// wait.forInvisibilityOfElement(actionHeader);
		while (isDisplayed(actionHeader)) {
			// log.info("waiting for invisibility of actionHeader");
		}
		Assert.assertFalse(isDisplayed(actionHeader),
				"Change status field still present even after clicking on cross Button");
		log.info("Close Button On Add Tags working as expected");
	}

	// repeated
	/*
	 * public void verifyClearFilterUsingFiltersButton() { click(filter);
	 * log.info("clicked on Filter button"); By filterOptionsPresent =
	 * By.xpath("//span[@id='Filters']/following-sibling::div[@class='d-flex']");
	 * log.info("filters option displayed: " +
	 * isDisplayed(driver.findElement(filterOptionsPresent)));
	 * log.info(getText(driver.findElement(filterOptionsPresent)));
	 * sa.assertTrue(isDisplayed(driver.findElement(filterOptionsPresent)),
	 * "filters options not displayed");
	 * sa.assertTrue(getText(driver.findElement(filterOptionsPresent)).
	 * contains("Add tags"), "filters options does not contain add tags option");
	 * sa.assertTrue(getText(driver.findElement(filterOptionsPresent)).
	 * contains("Send Email"),
	 * "filters options does not contain send email option");
	 * sa.assertTrue(getText(driver.findElement(filterOptionsPresent)).
	 * contains("Change Stage"),
	 * "filters options does not contain change stage option"); click(filter);
	 * log.info("clicked on Filter button again"); //
	 * wait.forInvisibilityOfElement(driver.findElement(filterOptionsPresent));
	 * sa.assertFalse(isDisplayed(driver.findElement(filterOptionsPresent))
	 * ,"filters options present even after clicking filter button");
	 * log.info("filters option displayed: " +
	 * isDisplayed(driver.findElement(filterOptionsPresent)));
	 * 
	 * }
	 * 
	 * public void verifyClearFilterUsingCrossButton() { click(filter);
	 * log.info("clicked on Filter button"); By filterOptionsPresent =
	 * By.xpath("//span[@id='Filters']/following-sibling::div[@class='d-flex']");
	 * log.info("filters option displayed: " +
	 * isDisplayed(driver.findElement(filterOptionsPresent)));
	 * log.info(getText(driver.findElement(filterOptionsPresent)));
	 * sa.assertTrue(isDisplayed(driver.findElement(filterOptionsPresent)),
	 * "filters options not displayed");
	 * sa.assertTrue(getText(driver.findElement(filterOptionsPresent)).
	 * contains("Add tags"), "filters options does not contain add tags option");
	 * sa.assertTrue(getText(driver.findElement(filterOptionsPresent)).
	 * contains("Send Email"),
	 * "filters options does not contain send email option");
	 * sa.assertTrue(getText(driver.findElement(filterOptionsPresent)).
	 * contains("Change Stage"),
	 * "filters options does not contain change stage option");
	 * click(clearFilterCross); log.info("clicked on cross button"); //
	 * wait.forInvisibilityOfElement(driver.findElement(filterOptionsPresent));
	 * sa.assertFalse(isDisplayed(driver.findElement(filterOptionsPresent))
	 * ,"filters options present even after clicking filter button");
	 * log.info("filters option displayed: " +
	 * isDisplayed(driver.findElement(filterOptionsPresent))); sa.assertAll(); }
	 */

	public CreateCandidatePojo verifyProfilePic() {
		CreateCandidatePojo cand = generateCandidateData();
		click(addCandidate);
		/*
		 * log.info("uploading a pdf instead of image..."); String path2 =
		 * System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources"
		 * + fs + "sample.pdf"; String id2 = uploadProfilePic(path2);
		 * cand.setProfile_pic(id2); log.info("uploaded profile pic : " + id2);
		 * sa.assertFalse(getAttribute(profilePic, "src").contains(id2),
		 * "pdf got uploaded");
		 */
		log.info("uploading an image...");
		String path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "profilePic.jpg";
		/*
		 * try { Thread.sleep(15000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		String id = uploadProfilePic(path);
		cand.setProfile_pic(id);
		log.info("uploaded profile pic : " + id);
		setFullName(cand.getFullname());
		setMobile(cand.getMobile());
		setEmail(cand.getEmail());
		click(saveCandidate);
		click(closePopup);
		cand.setCandId(getCandidateId());
		hp.goToCandidates();
		WebElement profilePic = wait.forElementToBeVisible(
				driver.findElement(By.xpath("(//td[@id='" + cand.getCandId() + "']/div/img)[2]")));
		log.info("profile pic present on site : " + getAttribute(profilePic, "src"));
		sa.assertTrue(getAttribute(profilePic, "src").contains(id),
				"profile field not added or wrong profile pic added");
		sa.assertAll();
		log.info("profile pic uploaded successfully");
		return cand;
	}

	public CreateCandidatePojo verifyInitialsInsteadOfProfilePic() {
		CreateCandidatePojo cand = generateCandidateData();
		click(addCandidate);
		String fullname = cand.getFullname();
		setFullName(fullname);
		log.info("Name of Candidate : " + fullname);
		String f = fullname.substring(0, 1);
		String l = fullname.substring(fullname.lastIndexOf(" ") + 1, fullname.lastIndexOf(" ") + 2);
		log.info("initials : " + f + l);
		setMobile(cand.getMobile());
		setEmail(cand.getEmail());
		log.info("clicked on save without adding profile picture");
		click(saveCandidate);
		click(closePopup);
		cand.setCandId(getCandidateId());
		hp.goToCandidates();
//		click(candidates);
		WebElement profilePic = wait
				.forElementToBeVisible(driver.findElement(By.xpath("//td[@id='" + cand.getCandId() + "']/div/div")));
		log.info("profile pic present on site : " + getText(profilePic));
		Assert.assertEquals(getText(profilePic), f + l, "Wrong initials");
		log.info("Candidate initials are shown as expected");
		return cand;
	}

	public void verifyDeleteProfilePic() {
		click(addCandidate);
		String path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "profilePic.jpg";
		String id = uploadProfilePic(path);
		log.info("uploaded profile pic : " + id);
		new Actions(driver).moveToElement(deleteProfilePic).click(deleteProfilePic).perform();
		String src = getAttribute(profilePic, "src");
		Assert.assertFalse(src.contains(id), "profile pic not deleted : " + src);
		log.info("profile pic deleted successfully");
	}

	public CreateCandidatePojo verifyAddCandidateButton() {
		CreateCandidatePojo cand = createCandidate();
		hp.goToCandidates();
		editCandidateById(cand.getCandId());
		log.info("reopening candidate by edit option to check if candidate created as expected");
		sa.assertEquals(getFullName(), cand.getFullname());
		sa.assertEquals(getMobile(), cand.getMobile());
		sa.assertEquals(getEmail(), cand.getEmail());
		sa.assertAll();
		log.info("Create candidate button working as expcted");
		return cand;
	}

	public void verifyFullnameField() {
		click(addCandidate);
		log.info("clicked on add candidate button");
		click(saveCandidate);
		log.info("clicked on save candidate button without entering fullname to check error");
		sa.assertTrue(isDisplayed(fullNameError), "fullname mandatory error not displayed");
		sa.assertEquals(getText(fullNameError), "Full Name is required", "check mandatrory error text");
		setFullName("Test Fullname");
		click(saveCandidate);
		log.info("clicked on save candidate button after entering fullname to check error");
		sa.assertFalse(isDisplayed(fullNameError), "fullname mandatory error displayed even after entering it");
		sa.assertEquals(getFullName(), "Test Fullname", "full name text does not match");
		sa.assertAll();
		log.info("full name field working as expected");
	}

	public void verifyTagsField() {

		click(addCandidate);
		log.info("clicked on add candidate button");
		setTags(Arrays.asList("Tag1", "Tag2", "Tag3"));
		log.info("Entered tags " + getTags());
		sa.assertTrue(getTags().contains("Tag1"), "tag1 is missing " + getTags());
		sa.assertTrue(getTags().contains("Tag2"), "tag2 is missing " + getTags());
		sa.assertTrue(getTags().contains("Tag3"), "tag3 is missing " + getTags());
		sendKeys(tags, Keys.BACK_SPACE);
		log.info("Removing tag using backspace button");
		log.info("tags present after backspace " + getTags());
		sa.assertFalse(getTags().contains("Tag3"), "tag3 is still present after backspace " + getTags());
		click(clearTagButton);
		log.info("Removing tag using cross/clear button");
		log.info("tags present after cross button press " + getTags());
		sa.assertFalse(getTags().contains("Tag1"), "tag1 is still present after cross button " + getTags());
		sa.assertAll();
		log.info("Tags field working as expected");
	}

	public void verifyMobileField() {
		click(addCandidate);
		log.info("clicked on add candidates button");
		click(saveCandidate);
		log.info("clicked on save candidates button to check mandatory field error for mobile number field");
		sa.assertTrue(isDisplayed(mobileError), "Error not displayed even after field is kept empty");
		sa.assertEquals(getText(mobileError), "Mobile field is required.", "check error text ");
		setMobile(Arrays.asList("test"));
		log.info("Entering alphabets in mobile field to check error");
		sa.assertTrue(isDisplayed(mobileError), "Error not displayed even after alphabets entered");
		sa.assertEquals(getText(mobileError), "Please enter digits.", "check error text ");
		clearTextbox(mobile);
		setMobile(Arrays.asList("976758"));
		log.info("Entering 6 digits in mobile number to check error");
		sa.assertTrue(isDisplayed(mobileError), "Error not displayed even after 6 digits entered");
		sa.assertEquals(getText(mobileError), "Please enter valid mobile number.", "check error text ");
		clearTextbox(mobile);
		setMobile(Arrays.asList("98220929248382"));
		log.info("Entering 14 digits in mobile number to check error ");
		sa.assertTrue(isDisplayed(mobileError), "Error not displayed even after 14 digits entered");
		sa.assertEquals(getText(mobileError), "Please enter valid mobile number.", "check error text ");
		clearTextbox(mobile);
		setMobile(Arrays.asList("9822092924", "9767581156"));
		log.info("entered valid mobile numbers " + getMobile());
		// log.info(mobileError.isDisplayed());
		// log.info(isDisplayed(mobileError));
		boolean flag = isDisplayed(mobileError);
		log.info(flag);
		sa.assertFalse(flag, "Error displayed even after valid mobile numbers enterd : ");
		sendKeys(mobile, Keys.BACK_SPACE);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("pressed backspace to remove mobile ");
		log.info("mobile numbers after backspace button press : " + getMobile());
		sa.assertFalse(getMobile().contains("9767581156"), "number still present even after backspace ");
		click(clearMobileButton);
		log.info("clicked cross button to remove mobile ");
		log.info("mobile numbers after cross button press : " + getMobile());
		sa.assertTrue(getMobile().size() == 0, "number still present even after cross button press ");

		sa.assertAll();
		log.info("Mobile field working as expected");
	}

	public void verifyEmailField() {
		click(addCandidate);
		log.info("clicked on add candidate button");
		click(saveCandidate);
		log.info("clicked on save candidates button to check mandatory field error for Email field");
		sa.assertTrue(isDisplayed(emailError), "Error not displayed even after field is kept empty");
		sa.assertEquals(getText(emailError), "Email field is required.", "check error text ");
		sendKeys(email, "123Test");
		log.info("Entered invalid email id to check error");
		sa.assertTrue(isDisplayed(emailError), "invalid email error not popped up");
		sa.assertEquals(getText(emailError), "Please enter valid email", "check email error text");
		clearTextbox(email);
		String email1 = fake.internet().emailAddress();
		String email2 = fake.internet().emailAddress();
		String email3 = fake.internet().emailAddress();
		setEmail(Arrays.asList(email1, email2, email3));
		log.info("Entered email id " + getEmail());
		sa.assertFalse(isDisplayed(emailError), "Error displayed even after valid email Ids enterd : ");
		sa.assertTrue(getEmail().contains(email1), email1 + " is missing " + getEmail());
		sa.assertTrue(getEmail().contains(email2), email2 + " is missing " + getEmail());
		sa.assertTrue(getEmail().contains(email3), email3 + " is missing " + getEmail());
		sendKeys(email, Keys.BACK_SPACE);
		log.info("Removing email using backspace button");
		log.info("emails present after backspace " + getEmail());
		sa.assertFalse(getEmail().contains(email3), email3 + " is still present after backspace " + getEmail());
		click(clearEmailButton);
		log.info("Removing email using cross/clear button");
		log.info("email present after cross button press " + getEmail());
		sa.assertFalse(getEmail().contains(email1), email1 + " is still present after cross button " + getEmail());
		sa.assertAll();
		log.info("Email field working as expected");
	}

	public void verifyLinksField() {
		click(addCandidate);
		log.info("clicked on add candidate button");
		sendKeys(links, "123Test");
		log.info("Entered invalid link to check error");
		sa.assertTrue(isDisplayed(linksError), "invalid links error not popped up");
		sa.assertEquals(getText(linksError), "You have entered an invalid link!", "check links error text");
		clearTextbox(links);
		String link1 = fake.internet().url();
		String link2 = fake.internet().url();
		String link3 = fake.internet().url();
		setLinks(Arrays.asList(link1, link2, link3));
		log.info("Entered links  " + getLinks());
		sa.assertFalse(isDisplayed(linksError),
				"Error displayed even after valid links enterd : " + getText(linksError));
		sa.assertTrue(getLinks().contains(link1), link1 + " is missing " + getLinks());
		sa.assertTrue(getLinks().contains(link2), link2 + " is missing " + getLinks());
		sa.assertTrue(getLinks().contains(link3), link3 + " is missing " + getLinks());
		sendKeys(links, Keys.BACK_SPACE);
		log.info("Removing links using backspace button");
		log.info("links present after backspace " + getLinks());
		sa.assertFalse(getLinks().contains(link3), link3 + " is still present after backspace " + getLinks());
		click(clearLinksButton);
		log.info("Removing links using cross/clear button");
		log.info("links present after cross button press " + getLinks());
		sa.assertFalse(getLinks().contains(link1), link1 + " is still present after cross button " + getLinks());
		sa.assertAll();
		log.info("links field working as expected");
	}

	public void verifySocialField() {
		click(addCandidate);
		setSocial(Arrays.asList("LinkedIn", "FB", "Twitter"));
		log.info("Entered Social  " + getSocial());
		sa.assertTrue(getSocial().contains("LinkedIn"), "LinkedIn is missing " + getSocial());
		sa.assertTrue(getSocial().contains("FB"), "FB is missing " + getSocial());
		sa.assertTrue(getSocial().contains("Twitter"), "Twitter is missing " + getSocial());
		sendKeys(social, Keys.BACK_SPACE);
		log.info("Removing Social using backspace button");
		log.info("Social present after backspace " + getSocial());
		sa.assertFalse(getSocial().contains("Twitter"), "Twitter is still present after backspace " + getSocial());
		click(clearSocialButton);
		log.info("Removing Social using cross/clear button");
		log.info("Social present after cross button press " + getSocial());
		sa.assertFalse(getSocial().contains("LinkedIn"), "LinkedIn is still present after cross button " + getSocial());
		sa.assertAll();
		log.info("Social field working as expected");
	}

	public void verifySkillField() {
		click(addCandidate);
		setSkills(Arrays.asList("Manual", "Automation", "Java"));
		log.info("Entered Skill  " + getSkills());
		sa.assertTrue(getSkills().contains("Manual"), "Manual is missing " + getSkills());
		sa.assertTrue(getSkills().contains("Automation"), "Automation is missing " + getSkills());
		sa.assertTrue(getSkills().contains("Java"), "Java is missing " + getSkills());
		sendKeys(skills, Keys.BACK_SPACE);
		log.info("Removing Skill using backspace button");
		log.info("Skill present after backspace " + getSkills());
		sa.assertFalse(getSkills().contains("Java"), "Java is still present after backspace " + getSkills());
		click(clearSkillButton);
		log.info("Removing Skill using cross/clear button");
		log.info("Skill present after cross button press " + getSkills());
		sa.assertFalse(getSkills().contains("Manual"), "Manual is still present after cross button " + getSkills());
		sa.assertAll();
		log.info("Skill field working as expected");
	}

	public void verifySourceField() {
		click(addCandidate);
		setSource(Arrays.asList("Manual", "Automation", "Java"));
		log.info("Entered Source  " + getSource());
		sa.assertTrue(getSource().contains("Manual"), "Manual is missing " + getSource());
		sa.assertTrue(getSource().contains("Automation"), "Automation is missing " + getSource());
		sa.assertTrue(getSource().contains("Java"), "Java is missing " + getSource());
		sendKeys(source, Keys.BACK_SPACE);
		log.info("Removing Source using backspace button");
		log.info("Source present after backspace " + getSource());
		sa.assertFalse(getSource().contains("Java"), "Java is still present after backspace " + getSource());
		click(clearSourceButton);
		log.info("Removing Source using cross/clear button");
		log.info("Source present after cross button press " + getSource());
		sa.assertFalse(getSource().contains("Manual"), "Manual is still present after cross button " + getSource());
		sa.assertAll();
		log.info("Source field working as expected");

	}

	public void verifyCountryField(String c) {
		click(addCandidate);
		setCountry(c);
		log.info("Entered country : " + c);
		sa.assertEquals(c, getText(selectedCountry), "Selected country not displayed in text box");
		clearTextbox(countryBox);
		sendKeys(country, "afafac");
		log.info("Entering random value in country field to check No options suggestion");
		sa.assertTrue(isDisplayed(noOptions), "No option not shown even after random value : " + getText(noOptions));
		sa.assertAll();
		log.info("Country field working as expected");
	}

	public void verifyStateField(String c, String s) {
		click(addCandidate);
		log.info("checking if state field is disable when Country is not selected");
		sa.assertFalse(state.isEnabled(), "State is Enabled even without selecting country");
		setCountry(c);
		log.info("Entered country : " + c);
		sa.assertTrue(state.isEnabled(), "State is Not Enabled even After selecting country");
		setState(s);
		log.info("Entered State : " + s);
		sa.assertEquals(s, getText(selectedState), "Selected State not displayed in text box");
		clearTextbox(stateBox);
		sendKeys(state, "afafac");
		log.info("Entering random value in state field to check No options suggestion");
		sa.assertTrue(isDisplayed(noOptions), "No option not shown even after random value : " + getText(noOptions));
		sa.assertAll();
		log.info("state field working as expected");
	}

	// Verify the city field is not accepting any numbers, special characters, or
	// any such combination.
	public void verifyCityField(String c) {
		click(addCandidate);
		setCity("1234");
		log.info("entering numbers in the city field...");
		log.info("present city: " + getCity());
		log.info("city error displayed: " + isDisplayed(cityError));
		sa.assertTrue(isDisplayed(cityError), "city error not displayed");
		sa.assertEquals(getText(cityError), "City name must be alphabetic.", "city error not matching");
		setCity("@#$");
		log.info("entering special characters in the city field...");
		log.info("present city: " + getCity());
		log.info("city error displayed: " + isDisplayed(cityError));
		sa.assertTrue(isDisplayed(cityError), "city error not displayed");
		sa.assertEquals(getText(cityError), "City name must be alphabetic.", "city error not matching");
		setCity(c);
		sa.assertEquals(c, getCity(), "city not matching");
		sa.assertAll();
		log.info("city field working as expected");

	}

	// Verify the functionality of the Pincode field.
	public void verifyPincodeField(String p) {
		click(addCandidate);
		setPincode("abcd");
		log.info("entering characters in the pin code field...");
		log.info("pin code error displayed: " + isDisplayed(pincodeError));
		sa.assertTrue(isDisplayed(pincodeError), "pin code error not displayed");
		// sa.assertEquals(getText(pincodeError), "", "pin code error not matching" );
		setPincode("@#$");
		log.info("entering special characters in the pin code field...");
		log.info("pin code error displayed: " + isDisplayed(pincodeError));
		sa.assertTrue(isDisplayed(pincodeError), "pin code error not displayed");
		// sa.assertEquals(getText(pincodeError), "", "pin code error not matching" );
		setPincode(p);
		log.info("entering valid pincode...");
		sa.assertEquals(p, getPincode());
		sa.assertAll();
		log.info("Pincode field working as expected");
	}

	// Verify the functionality of the "Current CTC" field.
	public void verifyCurrentCtcField(String c) {
		click(addCandidate);
		setCurrentCTC("abc");
		sa.assertEquals("", getCurrentCTC(), "current ctc is different from entered ctc");
		log.info("entering characters in ctc...");
		setCurrentCTC(c);
		log.info("entering valid ctc...");
		sa.assertEquals(c, getCurrentCTC(), "current ctc is different from entered ctc");
		sa.assertAll();
		log.info("Current Ctc field working as expected");
	}

	// Verify the Resume Upload button is present inside the preview section.
	public void verifyUploadResumeButton() {
		log.info("uploading resume with size more than 1 mb");
		String path2 = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "5mbSample.pdf";
		click(uploadResumeButton);
		uploadFile(path2);
		// sa.assertFalse(verifyPopup("Resume uploaded"), "check validation text after
		// resume is uploaded");
		sa.assertFalse(isDisplayed(uploadedResume), "uploaded resume visible even when size greater than 1mb");
		sa.assertFalse(isDisplayed(resumePreview), "Resume preview displyaed when size greater than 1mb");
		sa.assertTrue(isDisplayed(uploadResumeError), "error not displayed");
		sa.assertEquals(getText(uploadResumeError), "File size must under 1 MB", "error not matching");
		log.info("uploading resume with size less than 1 mb");
		String path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "sampleResume.pdf";
		click(uploadResumeButton);
		uploadFile(path);
		sa.assertTrue(verifyPopup("Resume uploaded"), "check validation text after resume is uploaded");
		clickSave();
		sa.assertEquals(getText(uploadedResume), "sampleResume.pdf",
				"wrong resume uploaded :" + getText(uploadedResume));
		sa.assertTrue(isDisplayed(resumePreview), "Resume preview not displyaed");
		sa.assertEquals(getAttribute(docsCount, "id"), "1",
				"docs count not updated after uploading resume : count : " + getAttribute(docsCount, "id"));
		sa.assertAll();
		log.info("Resume upload button working as expected");
	}

	public void verifyUserRedirectedToResumeWhenClickedOnResume() {
		String parentWindow = driver.getWindowHandle();
		String path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "sampleResume.pdf";
		String id = uploadResume(path);
		log.info("uploaded resume");
		click(uploadedResume);
		switchToWindow(parentWindow);
		Assert.assertTrue(driver.getCurrentUrl().contains(id),
				"user navigated to wrong doucment check url of redirected tab");
		driver.close();
		driver.switchTo().window(parentWindow);
		log.info("User Successfully Redirected To Resume When Clicked On Resume");
	}

	public void verifyDeleteResumeButton() {
		log.info("checking Delete resume button is disbaled before uploading resume");
		sa.assertFalse(deleteResumeButton.isEnabled(), "Delete resume button was enabled even before uploading resume");
		String path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "sampleResume.pdf";
		uploadResume(path);
		log.info("uploaded resume");
		log.info("checking Delete resume button is Enabled After uploading resume");
		sa.assertTrue(deleteResumeButton.isEnabled(), "Delete resume button was Disabled even after uploading resume");
		sa.assertTrue(isDisplayed(deleteResumeButton), "Delete resume button not present");
		log.info("clicking On Delete button ");
		click(deleteResumeButton);
		log.info("clicking On No button to check if resume does not get deleted ");
		click(noDelete);
		sa.assertTrue(isDisplayed(uploadedResume),
				"Resume got deleted even after clicking on NO button on confirmation");
		click(deleteResumeButton);
		log.info("clicking On Yes button to check if resume gets deleted ");
		click(yesDelete);
		sa.assertTrue(verifyPopup("Resume deleted"), "check validation text after resume is deleted");
		sa.assertFalse(isDisplayed(resumePreview), "Resume still present even after delete");
		sa.assertFalse(isDisplayed(uploadedResume), "Resume still present even after delete");
		sa.assertAll();
		log.info("resume deleted successfully");
	}

	public void verifyDownloadResumeButton() {
		String parentWindow = driver.getWindowHandle();
		String path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "sampleResume.pdf";
		log.info("Checking if download resume button is disbaled before uploading any resume");
		sa.assertFalse(downloadResumeButton.isEnabled(),
				"Download resume button is Enabled even before uploading resume");
		String id = uploadResume(path);
		click(downloadResumeButton);
		switchToWindow(parentWindow);
		Assert.assertTrue(driver.getCurrentUrl().contains(id),
				"user navigated to wrong doucment check url of redirected tab");
		driver.close();
		driver.switchTo().window(parentWindow);
		log.info("Download resume button working as expected");
	}

	public void verifyPagesOfResume() {
		String path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "sampleResume.pdf";
		uploadResume(path);
		log.info("uploaded resume");
		String pageCount = getText(resumePagesCount).substring(10);
		log.info("Total pages of resume are : " + pageCount);
		sa.assertEquals(pageCount, "13", "wrong count of resume pages : " + pageCount);
		click(nextPageResumeButton);
		log.info("clicked on next page button , current page number is :"
				+ getAttribute(resumePage, "data-page-number"));
		sa.assertEquals(getAttribute(resumePage, "data-page-number"), "2", "Next page button not working ");
		click(nextPageResumeButton);
		log.info("clicked again on next page button , current page number is :"
				+ getAttribute(resumePage, "data-page-number"));
		sa.assertEquals(getAttribute(resumePage, "data-page-number"), "3", "Next page button not working ");
		click(prevPageResumeButton);
		log.info("clicked on previous page button , current page number is :"
				+ getAttribute(resumePage, "data-page-number"));
		sa.assertEquals(getAttribute(resumePage, "data-page-number"), "2", "previous page button not working ");
		click(prevPageResumeButton);
		log.info("clicked again on previous page button , current page number is :"
				+ getAttribute(resumePage, "data-page-number"));
		sa.assertEquals(getAttribute(resumePage, "data-page-number"), "1", "previous page button not working ");
		sa.assertAll();
		log.info("resume pages count displayed and next and previous page button working as expected");
	}

	public void verifyAssignJobSection(CreateCandidatePojo cand) {
		click(saveCandidate);
		log.info("Checking if 'assign field' is displayed or not...");
		sa.assertTrue(isDisplayed(assign), "Assign field is not displayed");
		log.info("assign field is displayed: " + isDisplayed(assign));
		/*
		 * log.info("Checking if 'save assign' button is displayed or not...");
		 * sa.assertTrue(isDisplayed(saveAssignButton), "Assign button not displayed");
		 * log.info("save assign button is displayed: " +
		 * isDisplayed(saveAssignButton));
		 */
		sa.assertAll();
		log.info("Hence, assign job section is verified");
	}

	// Verify the functionality of the Assign Job field.
	public void verifyAssignJob(String job1_name, String job2_name) {
		// createCandidate();
		click(saveCandidate);
		log.info("Assigning job 1...");
		click(assign);
		assignJob(job1_name);
		sa.assertTrue(getText(alert).matches("Saved updates"), "Job 1 not assigned");
		log.info("Job 1: " + getText(alert));
		click(closePopup);
		sa.assertTrue(getText(assignJobField).contains(job1_name), "Job1 name missing " + getText(assignJobField));
		log.info("Assigned job is: " + getText(assignJobField));
		log.info("Assigning job 2...");
		click(assignNewJob);
		assignJob(job2_name);
		sa.assertTrue(getText(alert).matches("Saved updates"), "Job 2 not assigned");
		log.info("Job 2: " + getText(alert));
		sa.assertTrue(getText(assignJobField).contains(job2_name), "Job2 name missing " + getText(assignJobField));
		log.info("Assigned job is: " + getText(assignJobField));
		sa.assertAll();
		log.info("Assign job functionality verified");
	}

	public void verifyAssignNoOptions(CreateCandidatePojo cand) {
		click(saveCandidate);
		click(closePopup);
		log.info("Giving input as 'xyz123' to verify no options are displayed on giving an invalid input...");
		sendKeys(assignInput, "xyz123");
		Assert.assertTrue(isDisplayed(noOptions), "Options are displayed even after entering invalid input");
		log.info("Options not displayed: " + isDisplayed(noOptions));

	}

	public void verifyDifferentCandidateCardsForMultipleJobs(String job1_name, String job2_name,
			CreateCandidatePojo candidate) {
		click(assign);
		log.info("Assigning job1...");
		assignJob(job1_name);
		sa.assertTrue(getText(alert).matches("Saved updates"), "Job1 not added");
		log.info("Job1: " + getText(alert));
		click(closePopup);
		log.info("Assigned job is: " + getText(assignJobField));
		click(assignNewJob);
		log.info("Assigning job2...");
		assignJob(job2_name);
		sa.assertTrue(getText(alert).matches("Saved updates"), "Job2 not added");
		log.info("Job2: " + getText(alert));
		click(closePopup);
		log.info("Assigned job is: " + getText(assignJobField));
		// click(saveCandidate);
		// click(closePopup);
		log.info("Checking if multiple cards are created for the assigned jobs on the candidate page...");
		hp.goToCandidates();
		By cand1 = By.xpath("//span[@id='" + job1_name + "']/parent::td/preceding-sibling::td");
		String id1 = getAttribute(wait.forElementToBeVisible(driver.findElement(cand1)), "id");
		log.info("expected Id1 " + candidate.getCandId());
		log.info("actual Id1 " + id1);
		sa.assertEquals(id1, candidate.getCandId(), "Id 1 not matching");
		By cand2 = By.xpath("//span[@id='" + job2_name + "']/parent::td/preceding-sibling::td");
		String id2 = getAttribute(wait.forElementToBeVisible(driver.findElement(cand2)), "id");
		log.info("expected Id2 " + candidate.getCandId());
		log.info("actual Id2 " + id2);
		sa.assertEquals(id2, candidate.getCandId(), "Id 2 not matching");
		sa.assertAll();
		log.info("Hence, Multiple cards are created with the assigned jobs. on candidates page");

	}

	// Verify a specific input can be cleared using the cross button.
	public void verifyAssignCrossButton(String job1_name, String job2_name, String job3_name) {

		click(assign);
		log.info("Assigning job1...");
		assignJob(job1_name);
		log.info("Assigned job is: " + getText(assignJobField));
		click(assignNewJob);
		log.info("Assigning job2...");
		assignJob(job2_name);
		log.info("Assigned jobs are: " + getText(assignJobField));
		click(assignNewJob);
		log.info("Assigning job3...");
		assignJob(job3_name);
		log.info("Assigned jobs are: " + getText(assignJobField));
		log.info("Removing job1 by using cross button");
		assignCross(job1_name);
		sa.assertFalse(getText(assignJobField).contains(job1_name), "Job1 visible even after applying cross");
		log.info("Assigned job is: " + getText(assignJobField));
		log.info("Removing job2 by using back space key");
		sendKeys(assignInput, Keys.BACK_SPACE);
		sa.assertFalse(getText(assignJobField).contains(job3_name), "Job3 visible even after applying cross");
		log.info("Assigned job is: " + getText(assignJobField));
		sa.assertTrue(getText(assignJobField).contains(job2_name), "Job2 not visible ");
		sa.assertAll();
		log.info("Hence, assign cross functionality and back space functionality are verified");
	}

	// Verify the functionality of the Assign button.
	public void verifySavedAssignedJob() {
		createCandidate();
		click(assign);
		assignJob("Princip");
		log.info("Assigned job is: " + getText(assignJobField));
		click(assignNewJob);
		assignJob("Internal Markets");
		log.info("Assigned job is: " + getText(assignJobField));
		click(saveAssignButton);
		Assert.assertTrue(getText(alert).matches("Job Assigned"));
		log.info("Alert is: " + getText(alert));
	}

	// Verify that the Docs, Notes, and Email tabs are not accessible if the
	// candidate form is not filled.
	public String verifyOtherTabs() {
		click(addCandidate);
		log.info("Checking if other tabs are enabled or disabled before filling details...");
		sa.assertTrue(docsTab.isEnabled(), "Docs tab was enabled before entering the candidate details");
		sa.assertTrue(notesTab.isEnabled(), "notes tab was enabled before entering the candidate details");
		sa.assertTrue(emailTab.isEnabled(), "email tab was enabled before entering the candidate details");
		CreateCandidatePojo cand = createCandidate();
		log.info("Checking if other tabs are enabled or disabled after filling details...");
		sa.assertTrue(docsTab.isEnabled(), "Docs tab was disabled even after entering the candidate details");
		sa.assertTrue(notesTab.isEnabled(), "notes tab was disabled even after entering the candidate details");
		sa.assertTrue(emailTab.isEnabled(), "email tab was disabled even afterentering the candidate details");
		sa.assertAll();
		log.info("Successfully checked other tabs ");
		return cand.getCandId();
	}

	// Verify the functionality of the Docs tab.
	public void verifyDocsTab() {
		log.info("Checking if docsUploadFiles button is visible after clicking on docs tab or not...");
		click(docsTab);
		Assert.assertTrue(isDisplayed(docsUploadFilesButton));
		log.info("upload files button is displayed:" + isDisplayed(docsUploadFilesButton));
		log.info("Docs tab verified");
	}

	// Verify the count of the documents is visible on the Docs tab.
	// Verify the functionality of the Upload Files button.
	// Verify the uploaded document is visible on the document page.
	public void verifyDocsUploadButton() {
		// trying to upload file more than 1 MB size
		By doc = By.xpath("//div[@class='text-center']/div");
		String path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "5mbSample.pdf";
		log.info("Uploading doc having size more than 1 mb");
		click(docsTab);
		click(docsUploadFilesButton);
		uploadFile(path);
		log.info("Docs present" + getTextList(docsPresent));
		sa.assertTrue(isDisplayed(docsUploadFilesError),
				"No error displyaed while adding file with size more than 1 MB");
		sa.assertEquals(getText(docsUploadFilesError), "File size must under 1 MB",
				"check error text when trying to upload file size greater than 1 mb");
		sa.assertFalse(isDisplayed(docPresent), "File uploaded despite size more than 1 mb");

		// trying to upload file less than 1 mb size
		path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "sample.pdf";
		log.info("Uploading doc having size less than 1 mb");
		click(docsUploadFilesButton);
		uploadFile(path);
		sa.assertTrue(verifyPopup("Document added."), "check validation text after uploading document");
		log.info("Docs present" + getTextList(docsPresent));
		sa.assertEquals(getText(docPresent), "sample.pdf", " Doc not uploaded ");
		path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "sample2.pdf";
		log.info("Uploading 2nd file to check if user can add mutliple docs");
		click(docsUploadFilesButton);
		uploadFile(path);
		wait.forNumberOfElementsToBeMoreThan(doc, 1);
		log.info("Docs present" + getTextList(docsPresent));
		sa.assertTrue(getTextList(docsPresent).contains("sample2.pdf"), " 2nd Doc not uploaded ");
		log.info("Checking visibilty of docs counts on docs tab");
		sa.assertEquals(getAttribute(docsCounts, "id"), "2", "check count present on docs tab");
		log.info("Count of docs: " + getAttribute(docsCounts, "id"));
		sa.assertAll();
		log.info("user can add multiple docs and count of docs present on tab successfully");
	}

	// Verify the functionality of the delete option.
	public void verifyDocsDeleteFiles(CreateCandidatePojo cand) {
		String path = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "sample2.pdf";
		uploadDoc(path);
		// wait.forNumberOfElementsToBeMoreThan(docs, 0);
		new Actions(driver).moveToElement(docsDeleteFilesButton).click(docsDeleteFilesButton).perform();
		log.info("Clicking on 'no' button to check if doc does not get deleted");
		click(noDelete);
		sa.assertTrue(isDisplayed(docPresent), "Docs not present even after clicking no button");
		new Actions(driver).moveToElement(docsDeleteFilesButton).click(docsDeleteFilesButton).perform();
		log.info("Clicking on 'yes' button to delete the doc");
		click(docsDeleteFilesYesButton);
		sa.assertTrue(verifyPopup("Document deleted"), "Check validation text after deleting doc");
		sa.assertFalse(isDisplayed(docPresent), "Docs present even after deleting");
		sa.assertAll();
		log.info("Hence,  document delete functionality is verified");
//				Assert.assertTrue(getText(alert).matches("Document deleted"));
//				log.info(alert.getText());
	}

	public void verifyDocsDownloadFiles(CreateCandidatePojo cand) {
		By docs = By.xpath("//div[@class='text-center']/div");
		String path1 = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "sample.pdf";
		uploadDoc(path1);
		wait.forNumberOfElementsToBeMoreThan(docs, 0);
		log.info("Docs present" + getTextList(docsPresent));
		new Actions(driver).moveToElement(docsDownloadFilesButton).click(docsDownloadFilesButton).perform();

	}

	// Verify the functionality of the Notes tab.
	// Verify the functionality of the Add Notes button.
	public void verifyNotesTab() {
		log.info("Clicking on 'notes' tab...");
		click(notesTab);
		sa.assertTrue(driver.getCurrentUrl().contains("notes"), "URL does not match");
		sa.assertTrue(isDisplayed(addNotesButton), "add notes button not displayed");
		sa.assertAll();
		log.info("Navigated to Notes tab successfully");
	}

//	Verify the functionality of the Add Notes button.
//	Verify the functionality of Title field.
//	Verify the functionality of the Description field.
//	Verify the functionality of the Save button.
//	Verify an error message is displayed if the fields are empty.
	public void verifyAddNoteButtonAndNoteTitleAndDescriptionField() {
		click(notesTab);
		log.info("navigated to notes tab");
		click(addNotesButton);
		sa.assertTrue(isDisplayed(notesTitle), "Note Title field not displyaed after clicking on add note button");
		sa.assertTrue(isDisplayed(notesDesc), "Note description field not displyaed after clicking on add note button");
		log.info("clicked on add notes tab");
		log.info("clicking on save note button without adding note title and description to check error");
		click(notesSaveButton);
		sa.assertTrue(verifyPopup("Please write note title and description."),
				"check validation text when Note title and description field kept empty");
		sendKeys(notesDesc, "Test Note Descritpion");
		log.info("clicking on save note button without adding note title to check error");
		click(notesSaveButton);
		sa.assertTrue(verifyPopup("Please write note title and description."),
				"check validation text when Note title field kept empty");
		clearTextbox(notesDesc);
		sendKeys(notesTitle, "Test Note Title");
		log.info("clicking on save note button without adding note description to check error");
		click(notesSaveButton);
		sa.assertTrue(verifyPopup("Please write note title and description."),
				"check validation text when Note description field kept empty");
		sendKeys(notesDesc, "Test Note Description");
		log.info("clicking on save note button by entering value in both note Title and description ");
		click(notesSaveButton);
		sa.assertTrue(verifyPopup("Note added."), "check validation after note is successfully added");
		sa.assertEquals(getText(singleNotesTitle), "Test Note Title",
				"check value entered in Note title after note is created");
		sa.assertEquals(getText(singleNotesDesc), "Test Note Description",
				"check value entered in Note Description after note is created");
		sa.assertAll();
		log.info("title and description field on Notes working as expected");
	}

	// Verify the time is visible inside the created note.
	public void verifyNotesTime() {
		addNote("Test Note Title", "Test Note Desc");
		log.info("Time present inside note : " + getText(noteTime));
		Assert.assertEquals(getText(noteTime), ("a few sec ago"), "check created Time on note");
		log.info("Notes time is verified");
	}

	// Verify the created note is visible on the jobs page.
	public void verifyNoteBook() {
		addNote("Note Title Test", "Note Desc Test");
		log.info("Verifying note is present in the form of notebook...");
		sa.assertTrue(isDisplayed(noteBook));
		log.info("Notebook is displayed:" + isDisplayed(noteBook));
		log.info("Verifying title and desciption in the notebook...");
		sa.assertEquals(getText(singleNotesTitle), ("Note Title Test"), "Title not matching");
		log.info("Title is: " + getText(singleNotesTitle));
		sa.assertEquals(getText(singleNotesDesc), ("Note Desc Test"), "Description not matching");
		log.info("Description is: " + getText(singleNotesDesc));
		sa.assertAll();
		log.info("Verification of notebook is done");
	}

	// Verify the functionality of the Edit button.
	// Verify the edited note is visible on the notes page.
	public void verifyEditNote() {
		addNote("Test Note Title", "Test Note Desc");
		log.info("Title of note before edit is: " + getText(singleNotesTitle));
		log.info("Description of note before edit is: " + getText(singleNotesDesc));
		click(noteEdit);
		log.info("Clicked on edit note");
		sendKeys(notesTitle, "Test Note Title Edited");
		sendKeys(notesDesc, "Test Note Desc Edited");
		log.info("clicking on save note after editing note");
		click(notesSaveButton);
		sa.assertTrue(verifyPopup("Saved updates"), "check validation text after editing note");
		sa.assertEquals(getText(singleNotesTitle), "Test Note Title Edited", "Note title not got edited");
		sa.assertEquals(getText(singleNotesDesc), "Test Note Desc Edited", "Note description not got edited");
		log.info("Title of note after editing is: " + getText(singleNotesTitle));
		log.info("Description of note after editing is: " + getText(singleNotesDesc));
		sa.assertAll();
		log.info("edit note functionality is verified");
	}

	// Verify the functionality of the Delete button.
	public void verifyDeleteNote() {
		log.info("Creating first note ");
		addNote("Test Note Title One", "Test Note Desc One");
		log.info("Creating second note ");
		addNote("Test Note Title Two", "Test Note Desc Two");
		log.info("Notes present before deleting : " + getTextList(allNotesTitle));
		log.info("clicking on delete note button");
		click(noteDelete);
		log.info("Clicking cancel to not delete note to check if note does not get deleted");
		click(noteDeleteCancelButton);
		sa.assertTrue(getTextList(allNotesTitle).contains("Test Note Title One"),
				"note got deleted even after clicking on Cancel button");
		log.info("clicking on delete note button ");
		click(noteDelete);
		click(noteDeleteButton);
		log.info("Clicking delete button to check if note gets deleted");
		sa.assertFalse(getTextList(allNotesTitle).contains("Test Note Title One"),
				"first note did not get delete even after deleting");
		sa.assertTrue(getTextList(allNotesTitle).contains("Test Note Title Two"),
				"second note also got deleted after deleting first note");
		log.info("Notes present after deleting : " + getTextList(allNotesTitle));
		sa.assertAll();
		log.info("note delete functionality is verified");
	}

	// Verify the functionality of the Email tab.
	public void verifyEmailTab() {
		// createCandidate();
		click(emailTabButton);
		Assert.assertTrue(isDisplayed(composeButton));
		log.info("Compose button is displayed: " + isDisplayed(composeButton));
		log.info("Email tab is verified");
	}

	// Verify the functionality of the Compose button.
	public void verifyComposeButton() {
		// createCandidate();
		click(emailTabButton);
		click(composeButton);
		log.info("Compose button clicked");
		sa.assertTrue(isDisplayed(emailToButton), "To is not displayed");
		log.info("The emailTo button is displayed: " + isDisplayed(emailToButton));
		sa.assertTrue(isDisplayed(emailTitleField), "Title field is not displayed");
		log.info("The title field is displayed: " + isDisplayed(emailTitleField));
		driver.switchTo().frame(iFrame);
		sa.assertTrue(isDisplayed(emailBodyField), "Body field is not displayed");
		log.info("The body field is displayed: " + isDisplayed(emailBodyField));
		driver.switchTo().defaultContent();
		sa.assertAll();
		log.info("Compose button is verified");
	}

	// Verify the functionality of the To dropdown field.
	public void verifyEmailTo() {
		// createCandidate();
		click(emailTabButton);
		click(composeButton);
		click(emailToButton);
		Select toOptions = new Select(emailToButton);
		toOptions.selectByVisibleText("ojassingh@gmail.com");
		Assert.assertTrue(getText(emailToButton).contains("ojas"));
		log.info("Recepient selected is: " + getText(emailToButton));
		log.info(" email To is verified");

	}

	// Verify the functionality of the Body field.
	public void verifyEmailBody() {
		// createCandidate();
		click(emailTabButton);
		click(composeButton);
		driver.switchTo().frame(iFrame);
		click(emailBodyField);
		sendKeys(emailBodyField, "Testing body field");
		Assert.assertTrue(getText(emailBodyField).contains("Testing body field"));
		log.info("Text in the body field is: " + getText(emailBodyField));
		driver.switchTo().defaultContent();
		log.info("email body is verified");
	}

	// Verify the functionality of the Attach file button
	public void verifyEmailAttachFile() {
		createCandidate();
		click(emailTabButton);
		click(composeButton);
		click(emailAttachFileButton);
		uploadFile(
				(System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "NewResume.docx"));

	}

	// Verify the functionality of the Cancel button.
	public void verifyEmailCancelButton() {
		// createCandidate();
		click(emailTabButton);
		click(composeButton);
		click(emailCancelButton);
		Assert.assertTrue(isDisplayed(composeButton), "Email not cancelled");
		log.info("Email cancelled: " + isDisplayed(composeButton));
		log.info("email cancel button is verified");
	}

	public void verifyCandidatesDetalis(CreateCandidatePojo cand) {
		log.info("Details of created candidate " + cand.getFullname() + " " + cand.getJobs() + " "
				+ cand.getCreatedOnForGrid());
		hp.goToCandidates();
		log.info("details present on card");
		Map<String, String> details = getCandidateDetails(cand.getCandId());
		log.info("details present on card : " + details);
		sa.assertEquals(details.get("name"), cand.getFullname());
		sa.assertEquals(details.get("jobtitle"), cand.getJobs().get(0));
		sa.assertEquals(details.get("stage"), "Applied");
		sa.assertEquals(details.get("createon"), cand.getCreatedOnForGrid());
		sa.assertEquals(details.get("action1"), "Edit");
		sa.assertEquals(details.get("action2"), "Delete");
		sa.assertAll();
	}

	public void verifyEditCandidateFunctionality() {
		Map<String, String> originalAsset = new HashMap<>();
		String pic = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "profilePic.jpg";
		String resume = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets"
				+ fs + "sample.pdf";
		String doc = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets" + fs
				+ "sample2.pdf";

		originalAsset.put("profilepic", pic);
		originalAsset.put("resume", resume);
		originalAsset.put("doc", doc);
		originalAsset.put("notetitle", "Test Note Title Original");
		originalAsset.put("notedesc", "Test Note Desc Original");
		originalAsset.put("job", "Consulting Administrator");

		CreateCandidatePojo originalCand = createFullCandidate(originalAsset);

		Map<String, String> editedAsset = new HashMap<>();
		String editedPic = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets"
				+ fs + "profilePic2.png";
		String editedResume = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "Assets" + fs + "sampleResume.pdf";
		String editedDoc = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "Assets"
				+ fs + "sample3.pdf";
		editedAsset.put("profilepic", editedPic);
		editedAsset.put("resume", editedResume);
		editedAsset.put("doc", editedDoc);
		editedAsset.put("notetitle", "Test Note Title Edited");
		editedAsset.put("notedesc", "Test Note Desc Edited");
		originalAsset.put("job", "International Orchestrator");

		CreateCandidatePojo editedCand = editFullCandidate(editedAsset, originalCand);

		hp.goToCandidates();
		editCandidateById(originalCand.getCandId());
		log.info("Reopening same candidate to check edited fields got saved or not");
		sa.assertTrue(getAttribute(profilePic, "src").contains(editedCand.getProfile_pic()),
				"Profile pic not got edited");
		sa.assertEquals(getFullName(), editedCand.getFullname(), "full name not got edited");
		sa.assertEquals(getTags(), editedCand.getTags(), "Tags not got edited");
		sa.assertEquals(getMobile(), editedCand.getMobile(), "Mobile not got edited");
		sa.assertEquals(getEmail(), editedCand.getEmail(), "email not got edited");
		sa.assertEquals(getLinks(), editedCand.getLinks(), "Links not got edited");
		sa.assertEquals(getSocial(), editedCand.getSocial(), "Social not got edited");
		sa.assertEquals(getSkills(), editedCand.getSkills(), "Skills not got edited");
		sa.assertEquals(getSource(), editedCand.getSource(), "Source not got edited");
		sa.assertEquals(getCountry(), editedCand.getLocation().get("country_name"), "Country not got edited");
		sa.assertEquals(getState(), editedCand.getLocation().get("state_name"), "State not got edited");
		sa.assertEquals(getCity(), editedCand.getLocation().get("city"), "city not got edited");
		sa.assertEquals(getPincode(), editedCand.getLocation().get("pincode"), "pincode not got edited");
		sa.assertEquals(getCurrentCTC(), editedCand.getCurrentCTC(), "Current CTC not got edited");
		sa.assertEquals(getText(assignJobField), editedCand.getJobs().get(0), "Job not got edited");
		sa.assertTrue(getAttribute(uploadedResume, "href").contains(editedCand.getResumeId()), "Resume not got edited");

		click(notesTab);
		sa.assertTrue(getTextList(allNotesTitle).contains(editedCand.getNoteTitle()),
				"edited note title not present : " + getTextList(allNotesTitle));
		sa.assertTrue(getTextList(allNotesDesc).contains(editedCand.getNoteDesc()),
				"edited note Desc not present : " + getTextList(allNotesDesc));

		sa.assertAll();

	}

	public void verifySearchField(String keyword) {
		sendKeys(search, keyword);
		/*
		 * try { Thread.sleep(70000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		wait.forNumberOfElementsToBeMoreThan(By.xpath(getXpathFromWebelement(candidateNames.get(0))), 0);
		List<String> names = new ArrayList<>();

		for (WebElement w : candidateNames) {
			names.add(w.getAttribute("id"));
			log.info(w.getAttribute("id"));
			// log.info(names);
		}
		log.info(names);

	}

	public void verifyDeleteCandidate(JobPostingPojo job) {
		SoftAssert sa = new SoftAssert();
		CreateCandidatePojo candidate = createCandidate();
		refreshPage();
		String candName = candidate.getFullname().substring(4).toLowerCase();
		By delete = By.xpath(
				"//*[contains(text(),'" + candName + "')]/parent::td/following-sibling::td[4]/div/span[@id='Delete']");
		wait.forElementToBeVisible(driver.findElement(delete)).click();
		log.info("clicked on delete candidate");
		wait.forElementToBeVisible(deleteCandidateConfirmation);
		noDelete.click();
		log.info("clicking on No to check if it cancels deletion of candidate");
		wait.forElementToBeVisible(alert);
		sa.assertTrue(alert.getText().contains("ancel"), alert.getText());
		List<String> candidatesBeforeDelete = getStringListFromWebElementList(candidatesList);
		log.info(candidatesBeforeDelete);
		sa.assertTrue(candidatesBeforeDelete.contains(candName), "candidate not present in Before delete list");
		wait.forElementToBeVisible(driver.findElement(delete)).click();
		log.info("clicked on delete candidate");
		yesDelete.click();
		log.info("clicking on Yes to delete  candidate");
		wait.forElementToBeVisible(alert);
		sa.assertTrue(alert.getText().contains("elete"), alert.getText());
		List<String> candidatesAfterDelete = getStringListFromWebElementList(candidatesList);
		log.info(candidatesAfterDelete);
		sa.assertFalse(candidatesAfterDelete.contains(candidate.getFullname()),
				"candidate present in After delete list");
		sa.assertNotEquals(candidatesBeforeDelete, candidatesAfterDelete);
		sa.assertAll();
		log.info("deleted candidate :" + candidate.getFullname());

	}

	public void verifyPagination(int candsKeptOnPage, String page) {

		click(countDropdown);
		for (WebElement e : dropDownOptions) {
			if (getText(e).equals(candsKeptOnPage)) {
				click(e);
				break;
			}
		}

		int pageCountforNextButton = 1;
		int candCountforNextButton = 0;

		while (!getAttribute(nextPageButton, "aria-disabled").equals("true")) {
			pageCountforNextButton++;
			wait.forAllElementToBeVisible(candsOnPage);
			candCountforNextButton = candCountforNextButton + candsOnPage.size();
			wait.forElementToBeVisible(nextPageButton);
			js.scrollIntoViewAndClick(nextPageButton);
		}

		String lastPage = getAttribute(
				wait.forElementToBeVisible(driver.findElement(By.xpath("//*[@class='page-item active']/a"))),
				"aria-label");
		candCountforNextButton = candCountforNextButton + candsOnPage.size();
		log.info("Cands kept per page on dropdown :" + candsKeptOnPage);
		log.info("Total pages :" + pageCountforNextButton);
		log.info("Total cands present on page :" + candCountforNextButton);
		sa.assertTrue(candCountforNextButton <= (pageCountforNextButton * candsKeptOnPage),
				"cand count does not match expcted cand count as per number of pages");
		sa.assertTrue(lastPage.contains(Integer.toString(pageCountforNextButton)),
				"page count and last page number did not match");
		sa.assertTrue(getAttribute(nextPageButton, "aria-disabled").equals("true"),
				"Next page button not disabeld on last page");

		log.info(">>>>>>>>>>>> Details for Previous button check <<<<<<<<<<<<<<<");

		int pageCountforPreviousButton = 1;
		int jobCountforPreviousButton = 0;

		while (!getAttribute(previousPageButton, "aria-disabled").equals("true")) {
			pageCountforPreviousButton++;
			wait.forAllElementToBeVisible(candsOnPage);
			jobCountforPreviousButton = jobCountforPreviousButton + candsOnPage.size();
			wait.forElementToBeVisible(previousPageButton);
			js.scrollIntoViewAndClick(previousPageButton);

			String firstPage = getAttribute(
					wait.forElementToBeVisible(driver.findElement(By.xpath("//*[@class='page-item active']/a"))),
					"aria-label");
			jobCountforPreviousButton = jobCountforPreviousButton + candsOnPage.size();
			log.info("Cands kept per page on dropdown :" + candsKeptOnPage);
			log.info("Total pages :" + pageCountforPreviousButton);
			log.info("Total cands present on page :" + jobCountforPreviousButton);
			sa.assertTrue(jobCountforPreviousButton <= (pageCountforPreviousButton * candsKeptOnPage),
					"cand count does not match expcted jobs count as per number of pages");
			sa.assertTrue(firstPage.contains(Integer.toString(1)), "page count and last page number did not match");
			sa.assertTrue(previousPageButton.getAttribute("aria-disabled").equals("true"),
					"Previous page button not disabeld on last page");
			sa.assertEquals(jobCountforPreviousButton, candCountforNextButton, "cand count did not match");
			sa.assertEquals(pageCountforPreviousButton, pageCountforNextButton, "page count did not match");
			sa.assertAll();
			log.info("pagination working on " + page + " page as expected");

		}
	}

	public void verifyRejectCandidateFunctionality(String candId, String jobId, String appliedOnCard, String rejectedOnCard, String fullname) {
		hp.goToJobs();
		jp.goToPipeline(jobId);
		List<WebElement> namesOnAppliedPipelineCard = wait.forAllElementToBeVisible(
				driver.findElements(By.xpath("//div[text()='"+appliedOnCard+"']/parent::div/parent::div/div[@class='px-2']/div/div/span")));
	//	List<WebElement> namesOnRejectedPipelineCard = wait.forAllElementToBeVisible(
	//			driver.findElements(By.xpath("//div[text()='"+rejectedOnCard+"']/parent::div/parent::div/div[@class='px-2']/div/div/span")));
		log.info("list of candidates on applied stage before rejecting: "+ getTextList(namesOnAppliedPipelineCard));
	//	log.info("list of candidates on rejected stage before rejecting: "+ getTextList(namesOnRejectedPipelineCard));
		sa.assertTrue(getTextList(namesOnAppliedPipelineCard).contains(fullname), "Applied stage does not contain cand name");
	//	sa.assertFalse(getTextList(namesOnRejectedPipelineCard).contains(fullname), "Rejected stage contains cand name before rejecting");
		hp.goToCandidates();
		WebElement stage = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//td[@id='"+candId+"']/following-sibling::td[2]")));
		String stageBeforeReject = getText(stage);
		log.info("stage before rejecting: "+ stageBeforeReject);
		rejectCandidateById(candId);
		click(rejectCancelButton);
		rejectCandidateById(candId);
		click(rejectButton);
		sa.assertTrue(verifyPopup("Stage Changed"), "check popup");
	/*	try {
			Thread.sleep(90000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String stageAfterReject = getText(stage);
		log.info("stage after rejecting: "+ stageAfterReject);
		sa.assertEquals(stageBeforeReject, stageAfterReject,"stages not matching");
		hp.goToJobs();
		jp.goToPipeline(jobId);
		log.info("list of candidates on applied stage after rejecting: "+ getTextList(namesOnAppliedPipelineCard));
		//log.info("list of candidates on rejected stage after rejecting: "+ getTextList(namesOnRejectedPipelineCard));
		sa.assertFalse(getTextList(namesOnAppliedPipelineCard).contains(fullname), "Applied stage contains cand name even after rejecting");
		//sa.assertTrue(getTextList(namesOnRejectedPipelineCard).contains(fullname), "Rejected stage does not contain cand name after rejecting");
		sa.assertAll();
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Method to click on Filter action
	 * 
	 * @param act values can be add tags , send email or change status depending on
	 *            which action needs to be done
	 */
	public void doAction(String act) {
		click(filter);
		log.info("clicked on Filter button");
		if (act.equalsIgnoreCase("add tags")) {
			click(addTags);
			log.info("clicked on " + act);
		} else if (act.equalsIgnoreCase("send email")) {
			click(sendEmail);
			log.info("clicked on " + act);
		} else if (act.equalsIgnoreCase("change status")) {
			click(changeStatus);
			log.info("clicked on " + act);
		}
	}

	public CreateCandidatePojo createCandidate() {
		hp.goToCandidates();
		CreateCandidatePojo cand = generateCandidateData();
		log.info("Creating candidate with name : " + cand.getFullname());
		click(addCandidate);
		String profilePicPath = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "Assets" + fs + "profilePic.jpg";
		String profilePicId = uploadProfilePic(profilePicPath);
		setFullName(cand.getFullname());
		setMobile(cand.getMobile());
		setEmail(cand.getEmail());
		String msg = clickSave();
		String candId = getCandidateId();
		cand.setCandId(candId);
		cand.setPopupMsg(msg);
		cand.setProfile_pic(profilePicId);
		return cand;
	}

	public void deleteCandidate(String CandName) {
		hp.goToCandidates();
		By delete = By
				.xpath("// *[text()='" + CandName + "']/parent::td/following-sibling::td[4]/div/span[@id='Delete']");
		wait.forElementToBeVisible(driver.findElement(delete));
		driver.findElement(delete).click();
		wait.forElementToBeVisible(deleteCandidateConfirmation);
		yesDelete.click();
//		yesDelete.getLocation().getX();
		log.info("deleted candidate :" + CandName);
	}

//	public void goToCandidates() {
//
//		wait.forElementToBeVisible(candidates);
//		candidates.click();
//		log.info("navigated to candidates page");
//	}

	public void selectCandidates(int count) {
		int index = 0;
		for (WebElement w : allCheckbox) {
			if (index == count)
				break;
			click(w);
			index++;
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////// SETTERS &
	////////////////////////////////////////////////////////////////////////////////////////// GETTERS////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////

	public String getFullName() {
		log.info("Fullname present : " + getAttribute(fullName, "value"));
		return getAttribute(fullName, "value");
	}

	public void setFullName(String fullname) {
		sendKeys(fullName, fullname);
		log.info("Entered full name : " + fullname);
	}

	public List<String> getTags() {
		log.info("Tags present : " + getTextList(tagsAdded));
		return getTextList(tagsAdded);
	}

	public void setTags(List<String> tag) {
		for (String s : tag) {
			sendKeys(tags, s);
			sendKeys(tags, Keys.ENTER);
		}
		log.info("Added tags : " + tag);
	}

	public List<String> getMobile() {
		log.info("Mobile Nos present : " + getTextList(mobileAdded));
		return getTextList(mobileAdded);
	}

	public void setMobile(List<String> mobileNos) {

		for (String s : mobileNos) {
			sendKeys(mobile, s);
			sendKeys(mobile, Keys.ENTER);
		}
		log.info("Added Mobile numbers : " + mobileNos);
	}

	public List<String> getEmail() {
		log.info("email Ids present : " + getTextList(emailAdded));
		return getTextList(emailAdded);
	}

	public void setEmail(List<String> emailId) {
		for (String s : emailId) {
			sendKeys(email, s);
			sendKeys(email, Keys.ENTER);
		}
		log.info("Added email Ids : " + emailId);
	}

	public List<String> getSocial() {
		log.info("Socials present : " + getTextList(socialAdded));
		return getTextList(socialAdded);
	}

	public void setSocial(List<String> socials) {
		for (String s : socials) {
			sendKeys(social, s);
			sendKeys(social, Keys.ENTER);
		}
		log.info("Added Socials : " + socials);
	}

	public List<String> getSkills() {
		log.info("Skills present : " + getTextList(skillsAdded));
		return getTextList(skillsAdded);
	}

	public void setSkills(List<String> skill) {
		for (String s : skill) {
			sendKeys(skills, s);
			sendKeys(skills, Keys.ENTER);
		}
		log.info("Added skills : " + skill);
	}

	public List<String> getLinks() {
		log.info("Links present : " + getTextList(linksAdded));
		return getTextList(linksAdded);
	}

	public void setLinks(List<String> link) {
		for (String s : link) {
			sendKeys(links, s);
			sendKeys(links, Keys.ENTER);
		}
		log.info("Added links : " + link);
	}

	public List<String> getSource() {
		log.info("Sources present : " + getTextList(sourceAdded));
		return getTextList(sourceAdded);
	}

	public void setSource(List<String> sources) {
		for (String s : sources) {
			sendKeys(source, s);
			sendKeys(source, Keys.ENTER);
		}
		log.info("Added Sources : " + sources);
	}

	public String getCountry() {
		log.info("country present : " + getText(selectedCountry));
		return getText(selectedCountry);
	}

	public void setCountry(String co) {
		sendKeys(country, co);
		sendKeys(countryBox, Keys.TAB);
		log.info("Selected Country : " + co);
	}

	public String getState() {
		log.info("state present : " + getText(selectedState));
		return getText(selectedState);
	}

	public void setState(String co) {
		sendKeys(state, co);
		sendKeys(stateBox, Keys.TAB);
		log.info("Selected State : " + co);
	}

	public String getCity() {
		log.info("city present : " + getAttribute(city, "value"));
		return getAttribute(city, "value");
	}

	public void setCity(String cityName) {
		sendKeys(city, cityName);
		log.info("Entered City : " + cityName);
	}

	public String getPincode() {
		log.info("Pincode present : " + getAttribute(pincode, "value"));
		return getAttribute(pincode, "value");
	}

	public void setCurrentCTC(String CurrentCTC) {
		sendKeys(currentCTC, CurrentCTC);
		log.info("Entered CurrentCTC : " + CurrentCTC);
	}

	public String getCurrentCTC() {
		log.info("CurrentCTC present : " + getAttribute(currentCTC, "value"));
		return getAttribute(currentCTC, "value");
	}

	public void setPincode(String pin) {
		sendKeys(pincode, pin);
		log.info("Entered pincode : " + pin);
	}

	public CreateCandidatePojo createCandidateAndAssignJob(String job) {
		CreateCandidatePojo cand = createCandidate();
		sendKeys(assignInput, job);
		wait.forAllElementToBeVisible(assignOptions);
		sendKeys(assignJobInputBox, Keys.TAB);
		// click(saveButtonForJob);
		// click(closePopup);
		// cand.setJobs(Arrays.asList(job));
		click(saveCandidate);
		click(closePopup);
		return cand;
	}

	/**
	 * 
	 * @param assets HashMap with keys profilepic, resume, doc, notetitle, notedesc
	 *               and its respective values will be path of profilpic, resume,
	 *               doc files and text to be entered in notetitle and notedesc
	 * @return Pojo object containing all details of created candidate
	 */
	public CreateCandidatePojo createFullCandidate(Map<String, String> assets) {
		hp.goToCandidates();
		CreateCandidatePojo cand = generateCandidateData();
		click(addCandidate);
		log.info("Creating candidate with name : " + cand.getFullname());
		String profilePic = uploadProfilePic(assets.get("profilepic"));
		log.info("Added profile pic : " + profilePic);
		cand.setProfile_pic(profilePic);
		setFullName(cand.getFullname());

		setTags(cand.getTags());
		setMobile(cand.getMobile());
		setEmail(cand.getEmail());
		setLinks(cand.getLinks());
		setSocial(cand.getSocial());
		setSkills(cand.getSkills());
		setSource(cand.getSource());
		setCountry(cand.getLocation().get("country_name"));
		setState(cand.getLocation().get("state_name"));
		setCity(cand.getLocation().get("city"));
		setPincode(cand.getLocation().get("pincode"));
		setCurrentCTC(cand.getCurrentCTC());
		click(saveCandidate);
		cand.setPopupMsg(getText(alert));
		click(closePopup);
		String candId = getCandidateId();
		cand.setCandId(candId);

		click(assign);
		assignJob(assets.get("job"));
		cand.setJobs(Arrays.asList(assets.get("job")));
		log.info("Assigned job : " + getText(assignJobField));

		String resume = uploadResume(assets.get("resume"));
		cand.setResumeId(resume);
		cand.setResumeName(getText(uploadedResume));
		clickSave();

		click(docsTab);
		String doc = uploadDoc(assets.get("doc"));
		cand.setDocId(doc);
		cand.setDocName(getText(docPresent));

		click(notesTab);
		String note = addNote(assets.get("notetitle"), assets.get("notedesc"));
		cand.setNoteTitle(note.substring(0, note.indexOf(":")));
		cand.setNoteDesc(note.substring(note.indexOf(":") + 1));

		click(overviewTab);
		click(saveCandidate);
		click(closePopup);

		return cand;
	}

	/**
	 * * @param assets HashMap with keys profilepic, resume, doc, notetitle,
	 * notedesc and its respective values will be path of profilpic, resume, doc
	 * files and text to be entered in notetitle and notedesc
	 * 
	 * @param cand object having info about original candidate
	 * @return
	 */
	public CreateCandidatePojo editFullCandidate(Map<String, String> assets, CreateCandidatePojo cand) {
		hp.goToCandidates();
		CreateCandidatePojo originalCand = cand;
		editCandidateById(originalCand.getCandId());
		CreateCandidatePojo editedCand = generateCandidateData();
		editedCand.setCandId(originalCand.getCandId());
		log.info("Original name present before edit : " + getFullName());
		log.info("Editing candidate with name : " + editedCand.getFullname());

		String editedprofilePic = uploadProfilePic(assets.get("profilepic"));
		while (getAttribute(profilePic, "src").contains(originalCand.getProfile_pic())) {
			log.info("waiting till edited profile pic gets uploaded");
		}
		log.info("Added profile pic : " + editedprofilePic);
		editedCand.setProfile_pic(editedprofilePic);

		setFullName(editedCand.getFullname());

		click(clearTagButton);
		click(clearTagButton);
		click(clearTagButton);
		setTags(editedCand.getTags());
		click(clearMobileButton);
		click(clearMobileButton);
		setMobile(editedCand.getMobile());
		click(clearEmailButton);
		click(clearEmailButton);
		setEmail(editedCand.getEmail());
		click(clearLinksButton);
		click(clearLinksButton);
		click(clearLinksButton);
		setLinks(editedCand.getLinks());
		click(clearSocialButton);
		click(clearSocialButton);
		click(clearSocialButton);
		setSocial(editedCand.getSocial());
		click(clearSkillButton);
		click(clearSkillButton);
		click(clearSkillButton);
		setSkills(editedCand.getSkills());
		click(clearSourceButton);
		click(clearSourceButton);
		click(clearSourceButton);
		setSource(editedCand.getSource());
		setCountry(editedCand.getLocation().get("country_name"));
		setState(editedCand.getLocation().get("state_name"));
		setCity(editedCand.getLocation().get("city"));
		setPincode(editedCand.getLocation().get("pincode"));
		setCurrentCTC(editedCand.getCurrentCTC());
		click(saveCandidate);
		click(closePopup);
		String editedCandId = getCandidateId();
		editedCand.setCandId(editedCandId);

		click(assignCrossButton);
		log.info("removing existing job and adding new job");
		click(assign);
		assignJob(assets.get("job"));
		log.info("Assigned job : " + getText(assignJobField));

		editedCand.setJobs(Arrays.asList(assets.get("job")));

		click(deleteResumeButton);
		click(docsDeleteFilesYesButton);
		click(closePopup);
		String resume = uploadResume(assets.get("resume"));
		editedCand.setResumeId(resume);
		editedCand.setResumeName(getText(uploadedResume));
		clickSave();
//		click(docsTab);
//		String originalDoc = 
//		By by = By.xpath("//*[@id='B Sc Marksheet.pdf']/parent::div/following-sibling::div/div[@id='Delete']");
//		
//		new Actions(driver).moveToElement(docsDeleteFilesButton).click(docsDeleteFilesButton).perform();
//		click(docsDeleteFilesYesButton);

//		click(closePopup);
//		log.info("deleted existing doc to add new one");
//		String doc = uploadDoc(assets.get("doc"));
//		editedCand.setDocId(doc);
//		editedCand.setDocName(getText(docPresent));

		click(notesTab);
		click(noteDelete);
		click(noteDeleteButton);
		click(closePopup);
		log.info("deleted existing Note to add new one");
		String note = addNote(assets.get("notetitle"), assets.get("notedesc"));
		editedCand.setNoteTitle(note.substring(0, note.indexOf(":")));
		editedCand.setNoteDesc(note.substring(note.indexOf(":") + 1));

		click(overviewTab);
		click(saveCandidate);
		editedCand.setPopupMsg(getText(alert));
		click(closePopup);

//		54321321
		return editedCand;
	}

	public void selectCandidateById(String id) {
		By candidate = By.xpath("//td[@id='" + id + "']/div/input");
		click(wait.forElementToBeVisible(driver.findElement(candidate)));
	}

	public void selectCandidateByName(String name) {
		By candidate = By.xpath("//span[@id='" + name + "']/preceding-sibling::input");
		click(wait.forElementToBeVisible(driver.findElement(candidate)));
	}

	public void changeStatus(List<String> candidates, String stageName) {
		for (String s : candidates) {
			selectCandidateByName(s);
		}
		doAction("change status");
		By stage = By.xpath("//div[@id='" + stageName + "']");
		click(wait.forElementToBeVisible(driver.findElement(stage)));
		click(closePopup);
	}

	public static CreateCandidatePojo generateCandidateData() {

		CreateCandidatePojo cand = new CreateCandidatePojo();
		cand.setFullname();
		cand.setTags();
		cand.setMobile();
		cand.setEmail();
		cand.setLinks();
		cand.setSocial();
		cand.setSource();
		cand.setSkills();
		cand.setLocation();
		cand.setCurrentCTC();
		cand.setCreatedOnForCard();
		cand.setCreatedOnForGird();

		return cand;
	}

	public String uploadResume(String path) {
//		createCandidate();
		click(uploadResumeButton);
		uploadFile(path);
		String href = getAttribute(uploadedResume, "href");
		String fileId = href.substring(href.lastIndexOf("/") + 1);
		log.info("uploaded resume Id : " + fileId);
		log.info("uploaded resume name : " + getText(uploadedResume));
		click(closePopup);
		return fileId;
	}

	public Map<String, String> getCandidateDetails(String candId) {
		Map<String, String> details = new HashMap<>();

		WebElement name = wait
				.forElementToBeVisible(driver.findElement(By.xpath("//td[@id='" + candId + "']/div/span")));
		WebElement jobTitle = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//td[@id='" + candId + "']/following-sibling::td/span")));
		WebElement stage = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//td[@id='" + candId + "']/following-sibling::td[2]")));
		WebElement createdOn = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//td[@id='" + candId + "']/following-sibling::td[3]")));
		WebElement action1 = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//td[@id='" + candId + "']/following-sibling::td[4]/div/span[1]")));
		WebElement action2 = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//td[@id='" + candId + "']/following-sibling::td[4]/div/span[2]")));

		details.put("name", getAttribute(name, "id"));
		details.put("jobtitle", getAttribute(jobTitle, "id"));
		details.put("stage", getText(stage));
		details.put("createon", getText(createdOn));
		details.put("action1", getAttribute(action1, "id"));
		details.put("action2", getAttribute(action2, "id"));
		return details;
	}

	public void editCandidateById(String candId) {

		WebElement edit = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//td[@id='" + candId + "']/following-sibling::td[4]/div/span[1]")));
		click(edit);
	}
	
	public void rejectCandidateById(String candId) {

		WebElement edit = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//td[@id='" + candId + "']/following-sibling::td[4]/div/span[3]")));
		click(edit);
	}

	public String uploadProfilePic(String path) {
		click(profilePic);
		uploadFile(path);
		wait.until(
				ExpectedConditions.attributeContains(profilePic, "src", "https://core-staging.pitchnhire.com/files"));
		String src = getAttribute(profilePic, "src");
		String id = src.substring(src.lastIndexOf("/") + 1);
		return id;
	}

	public String getCandidateId() {
//		refreshPage();
		String url = driver.getCurrentUrl();
		String candId = url.substring(0, url.lastIndexOf("/"));
		candId = candId.substring(candId.lastIndexOf("/") + 1);
		return candId;
	}

	public void deleteCandidateById(String candId) {
		hp.goToCandidates();
		/*
		 * try { Thread.sleep(90000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		WebElement delete = wait.forElementToBeVisible(
				driver.findElement(By.xpath("(//td[@id='" + candId + "']/following-sibling::td[4]/div/span[2])[2]")));
		click(delete);
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		click(yesDelete);
		List<String> candidateIdsOnTab = getAttributeList(candidateIds, "id");
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		if (!candidateIdsOnTab.contains(candId))
			log.info("Deleted candidate with Id : " + candId);
		else if (candidateIdsOnTab.contains(candId)) {
			log.info("candidate not deleted: " + candidateIdsOnTab);
		}

	}

	public String uploadDoc(String path) {
		String docName = path.substring(path.lastIndexOf("\\") + 1);
		log.info("uploading doc : " + docName);
		click(docsTab);

		click(docsUploadFilesButton);
		uploadFile(path);
		while (!getTextList(docsPresent).contains(docName)) {
			log.info("docs present : " + getTextList(docsPresent));
		}
		String id = "";
		log.info("Uploaded doc Id : " + id);
		log.info("Uploaded doc name : " + getTextList(docsPresent).get(getTextList(docsPresent).size() - 1));
		click(closePopup);
		return id;
	}

	public boolean verifyPopup(String expectedText) {
		boolean flag = false;
		log.info("Text present in popup :" + getText(alert));
		if (getText(alert).contains(expectedText))
			flag = true;
		click(closePopup);
		return flag;
	}

	public String getCandidateCount(String page) {
		String count = "";
		if (page.contains("Qualified")) {
			log.info("Qualified candidates count: " + getText(qualifiedCandidates));
			count = getText(qualifiedCandidates);
		} else if (page.contains("Not Qualified")) {
			log.info("Not qualified candidates count: " + getText(notQualifiedCandidates));
			count = getText(notQualifiedCandidates);
		} else if (page.contains("Not Contacted")) {
			log.info("Not contacted candidates count: " + getText(notContactedCandidates));
			count = getText(notContactedCandidates);
		} else if (page.contains("New")) {
			log.info("New candidates count: " + getText(newCandidates));
			count = getText(newCandidates);
		}
		return count;

	}

	public String addNote(String title, String desc) {
		click(notesTab);
		log.info("navigated to notes tab");
		click(addNotesButton);
		sendKeys(notesTitle, title);
		log.info("Entered Note title : " + title);
		sendKeys(notesDesc, desc);
		log.info("Entered Note description : " + desc);
		click(notesSaveButton);
		String noteAdded = getText(singleNotesTitle) + ":" + getText(singleNotesDesc);
		log.info("added note :" + noteAdded);
		click(closePopup);
		return noteAdded;
	}

	public String clickSave() {
		click(saveCandidate);
		String msg = getText(alert);
		click(closePopup);
		return msg;
	}

	public void assignCross(String cancelJob) {
		// for (WebElement e : selectedJob) {
		// wait.forElementToBeVisible(assignJobField);
		// while(isDisplayed(assignJobField)) {
		if (getText(assignJobField).contains(cancelJob)) {
			click(assignCrossButton);

		}
	}

	public void assignJob(String job) {
		wait.forAllElementToBeVisible(assignOptions);
		for (WebElement e : assignOptions) {
			if (e.getText().contains(job)) {
				e.click();
				break;
			}
		}
		// clickSave();
		click(saveCandidate);
	}

	/**
	 * Method to get list of Ids of candidates present on respective tab
	 * 
	 * @param type value can be "new","qualified","notqualified","notcontacted"
	 * @return list of Ids of candidates present on respective tab
	 */
	public List<String> getCandidates(String type) {
		hp.goToCandidates();
		wait.forAllElementToBeVisible(stages);
		if (type.equalsIgnoreCase("new"))
			click(newCandidates);
		else if (type.equalsIgnoreCase("qualified"))
			click(qualifiedCandidates);
		else if (type.equalsIgnoreCase("notqualified"))
			click(notQualifiedCandidates);
		else if (type.equalsIgnoreCase("notcontacted"))
			click(notContactedCandidates);
		wait.forAllElementToBeVisible(stages);
		List<String> candidateIdsOnTab = getAttributeList(candidateIds, "id");

		return candidateIdsOnTab;
	}

	public void goToTab(String type) {

	}

}