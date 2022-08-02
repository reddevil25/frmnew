package pages.Jobs;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import PojoClasses.ApplicationFormPojo;
import PojoClasses.ApplicationFormPojo.Job_Screening;
import commons.BasePage;
import pages.LoginPage;
import pages.Home.JobsPage;

public class ApplicationFormPage extends BasePage {

	private static final Logger log = LogManager.getLogger(ApplicationFormPage.class.getName());
	SoftAssert sa = new SoftAssert();
	Random rand = new Random();

	public ApplicationFormPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Create New Job')]")
	private WebElement CreateNewJobHeading;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement applicationform;

	////////// Screening questions webElements

	@FindBy(xpath = "//*[@role='alert']")
	private WebElement alert;
	@FindBy(css = ".Toastify>div>div>button")
	private WebElement closePopup;

	@FindBy(xpath = "//*[@id='Create custom template']")
	private WebElement createCustomTemplateButton;
	@FindBy(xpath = "//input[@placeholder='Add template name']")
	private WebElement customTemplateInput;
	@FindBy(xpath = "//input/following-sibling::button")
	private WebElement saveTemplateButton;
	@FindBy(xpath = "//input")
	private WebElement selectTemplateInput;
	@FindBy(xpath = "//*[@class=' css-15ifuxg']/div")
	private List<WebElement> templatesOptions;
	@FindBy(xpath = "//input/parent::div/preceding-sibling::div")
	private WebElement selectedTemplate;
	@FindBy(xpath = "//div[text()='No options']")
	private WebElement noOptions;
	@FindBy(xpath = "//div[text()='Answer Type']/following-sibling::select")
	private WebElement answerTypeDropdown;

	@FindBy(xpath = "//button[contains(text(),'Add New')]/following-sibling::div//ul/li")
	private List<WebElement> typesOfQuestion;
	@FindBy(xpath = "//div[@draggable='true']/div[1]/div")
	private List<WebElement> screeningQues;
	@FindBy(xpath = "//*/div[3]/div[2]/div[1]/div/div[2]")
	private WebElement screeningque1;
	@FindBy(xpath = "//div[@class='btn-group w-100']/button")
	private WebElement addque;
	@FindBy(xpath = "//div[@draggable='true']/div[2]/button")
	private WebElement editExistingQue;
	@FindBy(xpath = "//header/div[2]/select")
	private WebElement reqOrOpt;
	@FindBy(xpath = "//div[@class='bg_faintgray p-3 my-2']/footer/button[1]")
	private WebElement edit;
	@FindBy(xpath = "//div[@class='d-flex align-items-center']/div/span")
	private WebElement tag;
	@FindBy(xpath = "//li[contains(text(),'Single choice')]")
	private WebElement singlechoiceque;
	@FindBy(xpath = "//li[contains(text(),'Multiple choice')]")
	private WebElement multichoiceque;
	@FindBy(xpath = "//li[contains(text(),'video answer')]")
	private WebElement videoanswer;
	@FindBy(xpath = "//li[contains(text(),'Info box')]")
	private WebElement infobox;
	@FindBy(xpath = "//li[contains(text(),'Legal')]")
	private WebElement legal;

	@FindBy(xpath = "//form/button")
	private WebElement additem;
	@FindBy(xpath = "//form/textarea")
	private WebElement addans;
	@FindBy(xpath = "//form//following-sibling::div/div")
	private List<WebElement> options;
	@FindBy(xpath = "//div/div/header/div[1]/select")
	private WebElement vidanstime;
	@FindBy(xpath = "//footer/div/button[1]")
	private WebElement cancel;
	@FindBy(xpath = "//textarea")
	private WebElement addQueText;
	@FindBy(xpath = "//footer/div/button[3]")
	private WebElement saveQuestion;
	@FindBy(xpath = "//footer/div/button[2]")
	private WebElement saveandaddanother;
	@FindBy(xpath = "//footer/parent::div")
	private WebElement addnewqueform;
	@FindBy(xpath = "//div[@class='quill ']/div[2]/div[10]")
	private WebElement infoboxinput;
	@FindBy(xpath = "//div[@draggable='true']/div[2]/div")
	private WebElement deleteQue;
	@FindBy(xpath = "//div[@id='react-confirm-alert']/div/div/div/div/button[2]")
	private WebElement deleteNo;
	@FindBy(xpath = "//div[@id='react-confirm-alert']/div/div/div/div/button[1]")
	private WebElement deleteYes;
	@FindBy(xpath = "//div[@id='react-confirm-alert']/div/div/div/h1")
	private WebElement deleteAlertHeader;

	@FindBy(xpath = "//*/header/div[1]/select")
	private WebElement queType;
	@FindBy(xpath = "//footer/div/button[1]")
	private WebElement editSave;
	@FindBy(xpath = "//button[contains(text(),'Save Changes')]")
	private WebElement savechanges;
	@FindBy(xpath = "(//div/a/button)[2]")
	private WebElement workflowButton;
	@FindBy(xpath = "//div/ul/li[3]/a")
	private WebElement workflowAtTop;
	@FindBy(xpath = "//*[contains(text(),'Pipeline')]")
	private WebElement pipeline;
	@FindBy(xpath = "//div[@class='bg_faintgray p-3 my-2']/main[2]/div/div/button")
	private WebElement visibiltyoptions;
	@FindBy(xpath = "//div/div[1]/div[2]/span[2]/label")
	private WebElement visibletoselected;
	@FindBy(xpath = "//div[@class='Modal3']")
	private WebElement visibletoselectedform;
	@FindBy(xpath = "//div[@class='Modal3']/parent::div/following-sibling::button")
	private WebElement removeform;
	@FindBy(xpath = "//div[6]/div[2]/div[4]/div/div/div/div[2]")
	private WebElement phonetoggle;
	@FindBy(xpath = "//span[contains(text(),'Phone')]/following-sibling::div/div")
	private WebElement phonecheck;
	@FindBy(xpath = "//div[6]/div[2]/div[3]/div/div/div/div[2]")
	private WebElement phototoggle;
	@FindBy(xpath = "//span[contains(text(),'Photo')]/following-sibling::div/div")
	private WebElement photocheck;
	@FindBy(xpath = "//span[contains(text(),'CV')]/following-sibling::div/div")
	private WebElement cvcheck;
	@FindBy(xpath = "//span[contains(text(),'Cover')]/following-sibling::div/div")
	private WebElement coverlettercheck;
	@FindBy(xpath = "//div[6]/div[2]/div[1]/div/div/div/div[2]")
	private WebElement cvtoggle;
	@FindBy(xpath = "//div[6]/div[2]/div[2]/div/div/div/div[2]")
	private WebElement coverlettertoggle;
	@FindBy(xpath = "//input[@placeholder='Add template Name']")
	private WebElement customeTemplateName;
	@FindBy(xpath = "//input/following-sibling::button")
	private WebElement saveTemplate;
	@FindBy(xpath = "//header[text()='Answer type']")
	private WebElement answerType;
	@FindBy(xpath = "//div[contains(text(),'Added New templete')]")
	private WebElement newTemplateAddedalert;
	@FindBy(xpath = "//*[@role='alert'][text()='Please fill the fields']")
	private WebElement mandFieldError;
	@FindBy(xpath = "//*[@role='alert'][text()='Please write some answers']")
	private WebElement mandAnswerFieldError;

	@FindBy(xpath = "//div[contains(text(),'Application preferences')]")
	private WebElement Application_preferences;
	@FindBy(xpath = "//div[contains(text(),'Personal information')]")
	private WebElement Personal_preferences;
	@FindBy(xpath = "(//div/a/button)[1]")
	private WebElement jobDetailsButton;
	@FindBy(xpath = "//ul[@class='navbar-nav']/li[1]/a")
	private WebElement jobDetailsTab;

	@FindBy(xpath = "//input[@name='job_title']")
	private WebElement jobTitle;

	//// Profile Field Webelements
	@FindBy(xpath = "//div[4]/div/div/div[@class='mb-2']/div/div")
	private WebElement profileFieldsHeading;
	@FindBy(xpath = "//div[@class='container_box']/following-sibling::button")
	private WebElement addNewProfileField;
	@FindBy(xpath = "//div[text()='Input type']/following-sibling::select")
	private WebElement selectProfileFieldType;
	@FindBy(xpath = "//select/parent::div/preceding-sibling::div/input")
	private WebElement profileFieldInput;
	@FindBy(xpath = "//select/parent::div/parent::div/following-sibling::div/button[contains(text(),'Save')]")
	private WebElement profileFieldsave;
	@FindBy(xpath = "//div[@class='box_shadow mt-4 text-left  py-3 px-4']/div/button[2]")
	private WebElement deleteProfileField;
	@FindBy(xpath = "//div[@class='box_shadow mt-4 text-left  py-3 px-4']/div/button[@id='Edit']")
	private WebElement editProfileField;
	@FindBy(xpath = "//div[4]/div[@draggable='true']/div")
	private List<WebElement> profileFields;
	@FindBy(xpath = "//button[text()='Save Changes']")
	private WebElement saveChanges;
	@FindBy(xpath = "//form/textarea")
	private WebElement Options;
	@FindBy(xpath = "//form/button")
	private WebElement addOption;
	@FindBy(xpath = "//form/following-sibling::div/div/p")
	private List<WebElement> singleChoiceProfileFieldOptions;
	@FindBy(xpath = "//div[@role='alert'][contains(text(),'Mandatory')]")
	private WebElement mandfieldserror;
	@FindBy(xpath = "//div[@role='alert'][contains(text(),'ptions')]")
	private WebElement optionsError;
	@FindBy(xpath = "//div[@class='Toastify__toast-body']")
	private WebElement fieldTypeError;

	////// Confirmation alert
	@FindBy(xpath = "//*[@id='react-confirm-alert']/div/div/div/div/button[1]")
	private WebElement confirmYes;
	@FindBy(xpath = "//*[@id='react-confirm-alert']/div/div/div/div/button[2]")
	private WebElement confirmNo;
	@FindBy(xpath = "//*[@id='react-confirm-alert']/div/div/div/h1")
	private WebElement confirmAlert;

	//////// AUTO CONFIRMATION MAIL WEBELEMENTS
	@FindBy(xpath = "//div[7]/div[1]/div/div[2]")
	private WebElement autoConfirmMailToggle;
	@FindBy(xpath = "//h6/preceding-sibling::div")
	private WebElement autoConfirmMailToggleCheck;
	@FindBy(xpath = "//div[7]/div/input[@type='text']")
	private WebElement autoConfirmationMailSubject;
	@FindBy(xpath = "//div[7]/div/div[@role='application']")
	private WebElement autoConfirmationMailBody;
	@FindBy(xpath = "//body[@id='tinymce']/p")
	private WebElement autoConfirmationMailBodyText;
	@FindBy(xpath = "//*[@role='alert'][contains(text(),'mail subject')]")
	private WebElement mailSubjectError;
	@FindBy(xpath = "//*[@role='alert'][contains(text(),'message')]")
	private WebElement mailBodyError;

	@FindBy(css = ".Toastify>div>div>button")
	private WebElement closeError;

	// Verify the functionality of Create Custom Template button on the Screening
	// questions section.
	public void verifyCreateCustomTemplateButton() {
		click(createCustomTemplateButton);
		log.info("clicked on create custom template button");
		sa.assertTrue(isDisplayed(customTemplateInput), "Input field is missing");
		sa.assertTrue(isDisplayed(saveTemplateButton), "save Template button is missing");
		sa.assertAll();
		log.info("create custom template button working as expected");
	}

//	Verify the functionality of the add template input field when left empty and the save template button is clicked.
//	Verify the functionality of the add template input field when it is filled but the questions are not added.
	public void verifyAddTemplateInputField() {
		click(createCustomTemplateButton);
		log.info("clicked on create custom template button");
		click(saveTemplate);
		log.info("clicked on save template button without entering value in input field to check error");
		log.info("Error popped up as : " + getText(alert));
		sa.assertTrue(isDisplayed(alert), "Error not popped up even if input field is empty");
		sa.assertEquals(getText(alert), "Add screening questions to the template",
				"check error text when input is empty");
		click(closePopup);
		sendKeys(customTemplateInput, "Test custom template");
		log.info("Entered input as :" + "Test custom template");
		click(saveTemplate);
		log.info("clicked on save template button without adding screeing questionsto check error");
		log.info("Error popped up as : " + getText(alert));
		sa.assertTrue(isDisplayed(alert), "Error not popped up even if input field is empty");
		sa.assertEquals(getText(alert), "Add screening questions to the template",
				"check error text when input is empty");
		click(closePopup);
		log.info("Adding screenig question");
		addNewScreenQue("how to perform click opertion?", "Single line");
		click(saveTemplate);
		sa.assertNotEquals(getText(alert), "Add screening questions to the template",
				"Error popped up even after adding screeing questions");
		sa.assertAll();
		log.info("Add Template Input Field working as expected");
	}

	// Verify the functionality of the save template button when the name of
	// template and the questions are added
	public void verifySaveTemplateButton() {
		String name = "Test custom template " + fake.letterify("???");
		click(createCustomTemplateButton);
		log.info("clicked on create custom template button");
		sendKeys(customTemplateInput, name);
		log.info("Entered Template name " + name);
		addNewScreenQue("how to perform click opertion?", "Single line");
		addNewScreenQue("how to perform Right click opertion?", "Single line");
		log.info("Added screenig question");
		click(saveTemplateButton);
		log.info("clicked on save template button");
		sa.assertEquals(getText(alert), "New template created", "check validation text when template is created");
		click(closePopup);
		List<String> templates = getSavedTemplates();
		log.info("Saved templates are : " + templates);
		sa.assertTrue(templates.contains(name), "Saved template not present in list ");
		sa.assertAll();
		log.info("save template button working as expected");
	}

	// Verify the functionality of the "Select Template" field.
	public void verifySelectTemplateField() {
		String que1 = "What is tesng?";
		String que2 = "How to use extent reports?";
		String tempName = createScreeningTemplate(que1, que2);
		log.info("Created template to check if it is present in list");
		sendKeys(selectTemplateInput, "######");
		log.info("Entered name which is not present to check No options suggestion");
		sa.assertTrue(isDisplayed(noOptions),
				"No options suggestion not displayed when user tired to select option not present in list");
		clearTextbox(selectTemplateInput);
		log.info("Entering valid teamplate name to check if it is shown in search field");
		sendKeys(selectTemplateInput, tempName.substring(0, 7));
		By option = By.xpath("//*[@class=' css-15ifuxg']/div[text()='" + tempName + "']");
		click(driver.findElement(option));
		log.info("Entered name in select template field and clicked on required option");
		sa.assertEquals(getText(selectedTemplate), tempName,
				"template name not displayed in select template field after selecting");
		sa.assertEquals(getScreenQuestions().get(0), que1,
				"first question does not match with that of present in template");
		sa.assertEquals(getScreenQuestions().get(1), que2,
				"second question does not match with that of present in template");
		sa.assertAll();
		log.info("select Template field working as expected");
	}

	/**
	 * Method to check Screening questions getting displayed as per template Method
	 * first creates one screening template and then selects the same from dropdown
	 * and verifies if questions are same as per template
	 */
	public void verifyScreeningQueAsPerTemp() {
		String que1 = "What is selenium?";
		String que2 = "What is rest assured?";
		log.info("creating template with questions");
		String tempName = createScreeningTemplate(que1, que2);
		selectTemplate(tempName);
		log.info("selected template : " + tempName);
		sa.assertEquals(getText(selectedTemplate), tempName,
				"template name not displayed in select template field after selecting");
		sa.assertEquals(getScreenQuestions().get(0), que1, "first question");
		sa.assertEquals(getScreenQuestions().get(1), que2, "second question");
		sa.assertAll();
		log.info("displayed screening questions as per template");

	}

	// Verify the functionality of ADD NEW button inside the Screening Questions
	// tab.
	public void verifyAddScreeningQuestionButton() {
		click(addque);
		log.info("clicked on Add New button to check if dropdown displays");
		List<String> types = getTextList(typesOfQuestion);
		log.info("Dropdown displayed with question types : " + types);
		sa.assertTrue(types.contains("Text (Single line)"), "Text (Single line) type missing");
		sa.assertTrue(types.contains("Text (Multiple lines)"), "Text (Multiple lines) type missing");
		sa.assertTrue(types.contains("Yes/No"), "Yes/No type missing");
		sa.assertTrue(types.contains("Single choice"), "Single choice type missing");
		sa.assertTrue(types.contains("Multiple choice"), "Multiple choice type missing");
		log.info("Clicked on add screening que");
		WebElement queType = wait
				.forElementToBeVisible(driver.findElement(By.xpath("//li[contains(text(),'Yes/No')]")));
		click(queType);
		log.info("Selected Yes/No type of  question to check if Question Box opens up");
		sa.assertTrue(isDisplayed(addQueText), "question input field missing");
		sa.assertAll();
		log.info("Add button on screening question tab working as expected");
	}

//	Verify the functionality of answer type field inside the dialog box
	public void verifyAnswerTypeField() {
		click(addque);
		log.info("clicked on Add New button");
		WebElement queType = driver.findElement(By.xpath("//li[contains(text(),'Text (Single line)')]"));
		click(queType);
		log.info("Selected Text (Single line) type of  question");
		sa.assertTrue(isDisplayed(addQueText), "question input field missing in Text (Single line) type question");
		sa.assertEquals(getSelectedOption(answerTypeDropdown), "Text (Single line)",
				"selected option Text (Single line) not visible in field ");

		selectvisibletext(answerTypeDropdown, "Text (Multiple lines)");
		log.info("Selected Text (Multiple lines) type of question");
		sa.assertTrue(isDisplayed(addQueText), "question input field missing in Text (Multiple lines) type question");
		sa.assertEquals(getSelectedOption(answerTypeDropdown), "Text (Multiple lines)",
				"selected option Text (Multiple lines) not visible in field ");

		selectvisibletext(answerTypeDropdown, "Yes/No");
		log.info("Selected Yes/No type of question");
		sa.assertTrue(isDisplayed(addQueText), "question input field missing in Yes/No type question");
		sa.assertEquals(getSelectedOption(answerTypeDropdown), "Yes/No",
				"selected option Yes/No not visible in field ");

		selectvisibletext(answerTypeDropdown, "Single choice");
		log.info("Selected Single choice type of question");
		sa.assertEquals(getSelectedOption(answerTypeDropdown), "Single choice",
				"selected option Single choice not visible in field ");
		sa.assertTrue(isDisplayed(addQueText), "question input field missing in Single choice type question");
		sa.assertTrue(isDisplayed(addans), "Answers field missing in Single choice type question");
		sa.assertTrue(isDisplayed(additem), "+ Add button field missing in Single choice type question");

		selectvisibletext(answerTypeDropdown, "Multiple choice");
		log.info("Selected Multiple choice type of question");
		sa.assertEquals(getSelectedOption(answerTypeDropdown), "Multiple choice",
				"selected option Multiple choice not visible in field ");
		sa.assertTrue(isDisplayed(addQueText), "question input field missing in Multiple choice type question");
		sa.assertTrue(isDisplayed(addans), "Answers field missing in Multiple choice type question");
		sa.assertTrue(isDisplayed(additem), "+ Add button field missing in Multiple choice type question");
		sa.assertAll();
		log.info("Answer type field working as expected");
	}

	// Verify The functionality of the question type dropdown
	/**
	 * Method to verify Optional and Required tags on screening questions. Method
	 * first selects optional tag for question and verifies if it is attached to
	 * question then method selects required tag and verifies optional tag is
	 * disappeared from question and Required tag is attached
	 */
	public void verifyQuestionType() {
		SoftAssert sa = new SoftAssert();
		addNewScreenQue("what is abc...?", "Single line");
		log.info("Added screening question ");
		sa.assertEquals(getText(tag), "Required", "by default question type was not set to Required");
		click(editExistingQue);
		log.info("clicked on Edit question, to change type to Optional");
		wait.forElementToBeVisible(reqOrOpt);
		selectvisibletext(reqOrOpt, "Optional");
		log.info("selected optional ");
		click(editSave);
		log.info("clicked on edit/save");
		sa.assertTrue(isDisplayed(tag), "Tag is not displayed on question");
		sa.assertEquals(getText(tag), "Optional",
				"type did not get changed to optional, tag present on question :" + tag.getText());
		click(editExistingQue);
		log.info("clicking on edit options to change again from optional to required tag");
		wait.forElementToBeVisible(reqOrOpt);
		selectvisibletext(reqOrOpt, "Required");
		log.info("selected Required ");
		click(editSave);
		log.info("clicked on edit/save");
		sa.assertTrue(isDisplayed(tag), "Tag is not displayed on question");
		sa.assertEquals(getText(tag), "Required",
				"type did not get changed to Required, tag present on question :" + tag.getText());
		sa.assertAll();
		log.info("Question type optional and Required tags displayed successfully");
	}

	// Verify the functionality of the question input field.
	/**
	 * Method to verify if user is able to create Single, Multiple line or Yes/No
	 * type question. Method verifies that Question text box can not be kept empty
	 * it should be filled before saving question
	 * 
	 * @param type value can be Single line OR Multiple line or Yes/No depends on
	 *             which type of question user wants to create
	 *
	 */
	public void verifyAddQuetionOfType(String type) {
		click(addque);
		log.info("Clicked on add screening que");
		wait.forElementToBeVisible(answerType);
		WebElement Type = wait
				.forElementToBeVisible(driver.findElement(By.xpath("//li[contains(text(),'" + type + "')]")));
		click(Type);
		log.info("Selected " + type + " of  question");
		log.info("clicking on save button without entering question to check Error ");
		click(saveQuestion);
		sa.assertTrue(isDisplayed(alert), "mand field error did not pop up");
		sa.assertEquals(getText(alert), "Question field is required.", "Check validation text");
		click(closePopup);
		sendKeys(addQueText, "What is abc?");
		log.info("entering que as : What is abc?");
		click(saveQuestion);
		log.info("clicked on save");
		wait.forAllElementToBeVisible(screeningQues);
		log.info("Screen questions " + getScreenQuestions());
		sa.assertTrue(getScreenQuestions().contains("What is abc?"), "question not getting saved");
		click(editExistingQue);
		log.info("clicked on edit quetion to check question type");
		log.info("question type is :" + getSelectedOption(queType));
		sa.assertTrue(getSelectedOption(queType).contains(type), "Selected option is :" + getSelectedOption(queType));
		sa.assertAll();
		log.info("error popped up without entering question and " + type + " question added successfully");
	}

	// Verify the functionality of the question input field.
	// Verify the functionality of the answers field present in the
	// single/multiple-choice questions
	// Verify the answer field displays the count of the entered choices.
	// Verify the Add button is disabled if the answer field is empty.
	// Verify the functionality of the Add button.
	/**
	 * Method to verify if user is able to create Single choice , Multiple choice
	 * type question. Method verifies that Question text box and Answers field can
	 * not be kept empty it should be filled before saving question
	 * 
	 * @param type value can be Single choice OR Multiple choice depends on which
	 *             type of question user wants to create
	 */
	public void verifyQuestionTypeSingleORMultipleChoice(String type) {
		click(addque);
		log.info("Clicked on add New Button");
		wait.forElementToBeVisible(answerType);
		if (type.equals("Single choice")) {
			click(singlechoiceque);
			log.info("selected single choice que");
		} else if (type.equals("Multiple choice")) {
			click(multichoiceque);
			log.info("selected multiple choice que");
		}
		wait.forElementToBeVisible(addQueText);
		log.info("clicking on save button without entering question to check Error ");
		click(saveQuestion);
		sa.assertTrue(isDisplayed(alert), "mand field error did not pop up");
		sa.assertEquals(getText(alert), "Question field is required.", "Check validation text");
		click(closePopup);
		sendKeys(addQueText, "What is abc?");
		log.info("entering que as : What is abc?");
		log.info("clicking on save button without entering Answers to check Error ");
		click(saveQuestion);
		sa.assertTrue(isDisplayed(alert), "mand field error didnt pop up");
		sa.assertEquals(getText(alert), "Please write some answers", "Check validation text");
		click(closePopup);
		wait.forElementToBeVisible(addans);
		sa.assertFalse(additem.isEnabled(), "+Add was enabled even before entering any options ");
		sa.assertTrue(getAttribute(addans, "placeholder").contains("1"),
				"wrong count at first option : " + getAttribute(addans, "placeholder"));
		sendKeys(addans, "Option a");
		log.info("added options as option a");
		sa.assertTrue(additem.isEnabled(), "+Add was not enabled even after entering any options ");
		click(additem);
		log.info("clicked on add options");
		sa.assertTrue(getAttribute(addans, "placeholder").contains("2"),
				"wrong count at second option : " + getAttribute(addans, "placeholder"));
		sendKeys(addans, "Option b");
		log.info("added options as option b");
		click(additem);
		log.info("clicked on add options");
		wait.forAllElementToBeVisible(options);
		click(saveQuestion);
		log.info("clicked on save");
		sa.assertTrue(getScreenQuestions().contains("What is abc?"), "question not getting saved");
		click(editExistingQue);
		log.info("clicked on edit quetion to check question type");
		log.info("question type is :" + getSelectedOption(queType));
		sa.assertEquals(getSelectedOption(queType), type, "selected question type" + getSelectedOption(queType));
		sa.assertTrue(options.size() > 0, "Options not displayed ");
		sa.assertEquals(getText(options.get(0)), "Option a", "first option didnt match");
		sa.assertEquals(getText(options.get(1)), "Option b", "second option didnt match");
		sa.assertAll();
		log.info(type + " Question added successfully");

	}

	// Verify the functionality of the cancel button.
	/**
	 * Method to verify Cancel button on add new screening question form. method
	 * verifies that total number of questions before and after canceling new
	 * question should be same
	 */
	public void verifyCancelButton() {
		String que = "What is TestNG..?";
		addNewScreenQue("What is selenium?", "Single line");
		log.info("Added question for test purpose");
		int totalquebefore = totalNoOfScreeningQues();
		log.info("Total questions before adding new question : " + totalquebefore);
		click(addque);
		log.info("Clicked on add New Button ");
		click(driver.findElement(By.xpath("//li[contains(text(),'Single line')]")));
		log.info("selected single line type question");
		sendKeys(addQueText, que);
		log.info("entering que as :" + que);
		click(cancel);
		log.info("Clicked on Cancel button");
		sa.assertFalse(isDisplayed(addQueText),
				"Question form did not get closed even after clicking on cancel button");
		int totalqueafter = totalNoOfScreeningQues();
		log.info("Total questions aftr cancelling adding new question : " + totalqueafter);
		sa.assertEquals(totalquebefore, totalqueafter,
				"Number of questions before and after clicking cancel did not match");
		log.info("Total screening questions remain same ");
		log.info("checking if any new question got added or not");
		sa.assertFalse(checkPresenceOfQuestion(que),
				"Cancel button not clicked and Question present in screening question");
		sa.assertAll();
		log.info("Cancel button clicked and question not added ");

	}

	// "Verify the functionality of the Save And Add Another button inside the
	// questions dialog box."
	/**
	 * Method to verify save and Add Another Question button on Add screening
	 * question form. method verifies that newly added question is saved and total
	 * number questions after saving question is greater than that of before saving
	 * question and also new Add question form is opened up
	 */
	public void verifySaveAndAddAnotherQue() {
		String que = "What is testng..?";
		addNewScreenQue("What is selenium?", "Single line");
		log.info("Added question for test purpose");
		int totalquebefore = totalNoOfScreeningQues();
		log.info("Total questions before adding new question : " + totalquebefore);
		click(addque);
		log.info("Clicked on add screening que");
		driver.findElement(By.xpath("//li[contains(text(),'Single line')]")).click();
		sendKeys(addQueText, que);
		log.info("entering que as :" + que);
		click(saveandaddanother);
		log.info("Clicked on save and add another question button");
		int totalqueafter = totalNoOfScreeningQues();
		log.info("Total questions aftr clicking save and adding new question : " + totalqueafter);
		sa.assertTrue(totalquebefore < totalqueafter,
				"New Question did not get add after clicking on save and Add another button");
		log.info("Number of question increased after clicking on save button");
		log.info("checking for presence of newly added question");
		sa.assertEquals(getScreenQuestions().get(1), que,
				"New Question did not get add after clicking on save and Add another button");
		sa.assertTrue(isDisplayed(addnewqueform),
				"New Question form did not appear after clicking on save and Add another button");
		sa.assertTrue(isDisplayed(addQueText), "question input field missing in Form");
		sa.assertEquals(getSelectedOption(answerTypeDropdown), "Text (Single line)",
				"Question type of new question form does not match with previos question type");

		sa.assertAll();
		log.info("New qustion added successfully and another new question form appeared");

	}

	// Verify the functionality of the Save button.
	/**
	 * Method to verify save button on Add screening question form. method verifies
	 * that newly added question is saved and total number questions after saving
	 * question is greater than that of before saving question
	 */
	public void verifySaveButton() {
		String que = "What is testng...?";
		addNewScreenQue("What is selenium?", "Single line");
		log.info("Added question for test purpose");
		int totalquebefore = totalNoOfScreeningQues();
		log.info("Total questions before adding new question : " + totalquebefore);
		click(addque);
		log.info("Clicked on add screening que");
		click(driver.findElement(By.xpath("//li[contains(text(),'Single line')]")));
		click(saveQuestion);
		log.info("clicked on save without adding mandatory fields to check error");
		sa.assertTrue(isDisplayed(alert), "mand field error did not pop up");
		sa.assertEquals(getText(alert), "Question field is required.", "Check validation text");
		click(closePopup);
		sendKeys(addQueText, que);
		log.info("entering que as :" + que);
		click(saveQuestion);
		log.info("clicked on save button");
		int totalqueafter = totalNoOfScreeningQues();
		log.info("Total questions aftr clicking save Button : " + totalqueafter);
		sa.assertTrue(totalquebefore < totalqueafter, "check total questions before and after adding new question");
		log.info("checking for presence of newly added question");
		sa.assertEquals(getScreenQuestions().get(1), que, "Newly added question not got saved");
		sa.assertAll();
		log.info("save button clicked and new question added ");
	}

	//Verify the functionality of the Edit button on screening questions.
	/**
	 * Method verifies Edit button Screening question. method checks edited question
	 * is present on screen after clicking on save
	 */
	public void verifyEditScreeningQueButton() {
		String que = "How to do abcd?";
		String editedQue = "What is xyz....?";
		addNewScreenQue(que, "Single line");
		log.info("Added question to edit");
		wait.forElementToBeVisible(editExistingQue);
		log.info("screening question before edit " + getScreenQuestions());
		click(editExistingQue);
		log.info("Clicked on edit question button ");
		sendKeys(addQueText, editedQue);
		log.info("edited question text");
		click(editSave);
		log.info("clicked on edit save button");
//			wait.forAllElementToBeVisible(screeningQues);
		sa.assertFalse(checkPresenceOfQuestion(que), "original question still present on screen");
		sa.assertTrue(checkPresenceOfQuestion(editedQue), "edited question not got saved on screen");
		sa.assertAll();
		log.info("Edit question button working succesfully");
	}
	
	//Verify the functionality of the delete button on screening questions.
	/**
	 * Method to verify Delete screening question. method deletes screening question
	 * and verifies that deleted question is not present on screen also verifies
	 * total number of questions is lesser after deleting question than that of
	 * before deleting question
	 */
	public void verifyDeleteButton() {
		wait.forElementToBeVisible(addque);
		String que1 = "What is selenium?";
		String que2 = "What is restassured?";
		addNewScreenQue(que1, "Single line");
		addNewScreenQue(que2, "Single line");
		int totalquebefore = totalNoOfScreeningQues();
		log.info("Total questions before deleting a question : " + totalquebefore);
		click(deleteQue);
		log.info("Deleting question : " + que1);
		sa.assertTrue(getText(deleteAlertHeader).contains("Do you want to delete this question"),"check confirmation header");
		click(deleteNo);
		log.info("clicked on NO to check if question does not get deleted");
		sa.assertEquals(getScreenQuestions().get(0), que1,
				"1st question got deleted even afer clicking NO");
		sa.assertEquals(getScreenQuestions().get(1), que2,
				"2nd question got deleted even afer clicking NO");
		click(deleteQue);
		click(deleteYes);
		log.info("clicked on Yes to check if question get deleted");
		int totalqueafter = totalNoOfScreeningQues();
		log.info("Total questions aftr deleting a question : " + totalqueafter);
		sa.assertTrue(totalquebefore > totalqueafter,"check total question present after deleting question");
		log.info("checking for presence of Deleted question on screen");
		sa.assertFalse(checkPresenceOfQuestion(que1), "Question not deleted still present in screening questions");
		sa.assertTrue(checkPresenceOfQuestion(que2), "2nd Question also got deleted ");
		sa.assertAll();
		log.info("question present : " + getScreenQuestions());
		log.info("Question : " + que1 + " deleted successfully");
	}

	//Verify that the screening questions can be arranged using drag and drop.
		/**
		 * Method to verify if drag and drop of screen questions working as required
		 * method uses autoIT to perform drag and drop manipulates x & y-coordinate by
		 * 127 point to locate webElement exactly
		 */
		public void verifyDragAndDropScreeningQue() {

			addNewScreenQue("how to perform click opertion?", "Single line");
			addNewScreenQue("Explain waits ", "Yes/No");
			addNewScreenQue("What is use of javascriptexecutor", "Yes/No");
			addNewScreenQue("Assertions in testng", "Yes/No");

			WebElement source = driver.findElement(By.xpath("//*[contains(text(),'Explain waits ')]"));
			WebElement target = driver.findElement(By.xpath("//*[contains(text(),'testng')]"));
			log.info("Screen questions before drag and drop :" + getScreenQuestions());
			log.info("source getlocation :" + source.getLocation().getX() + "-------" + source.getLocation().getY());
			log.info("target location :" + target.getLocation().getX() + "-------" + target.getLocation().getY());

			int x1 = source.getLocation().getX() + 127;
			int y1 = source.getLocation().getY() + 127;
			int x2 = target.getLocation().getX() + 127;
			int y2 = target.getLocation().getY() + 127;

			dragAndDrop(x1, y1, x2, y2);
			savechanges.click();
//			refreshPage();
			log.info("Screen questions after drag and drop :" + getScreenQuestions());

			Assert.assertEquals(getScreenQuestions().get(3), "Explain waits ");
			log.info("drag and drop performed successfully");

		}

	
	public void verifyJobDetailsTab() {
		wait.forElementToBeVisible(jobDetailsTab);
		click(jobDetailsTab);
		wait.forElementToBeVisible(jobTitle);
		Assert.assertFalse(driver.getCurrentUrl().contains("application-form"),
				"user not navigate to job posting page, current url : " + driver.getCurrentUrl());
		log.info("Job details tab working as expected");
	}

	public void verifyJobDetailsButton() {
		click(jobDetailsButton);
		wait.forElementToBeVisible(jobTitle);
		Assert.assertFalse(driver.getCurrentUrl().contains("application-form"),
				"user not navigate to job posting page , current url : " + driver.getCurrentUrl());
		log.info("Job posting button at bottom working as expected");
	}

	

	/**
	 * Method to verify Add options button working as expected in Single or Multiple
	 * Choice questions. Method verifies user is able to add options to answers
	 * 
	 * @param type value can be Single choice or Multiple choice depends on which
	 *             type of question need to check
	 */
	public void verifyChoiceAddButton(String type) {
		wait.forElementToBeVisible(addque);
		addque.click();
		log.info("Clicked on add screening que");
		if (type.equals("Single choice")) {
			wait.forElementToBeVisible(singlechoiceque);
			singlechoiceque.click();
			log.info("selected single choice que");
		} else if (type.equals("Multiple choice")) {
			wait.forElementToBeVisible(multichoiceque);
			multichoiceque.click();
			log.info("selected multiple choice que");
		}
		
		wait.forElementToBeVisible(addQueText);
		addQueText.sendKeys("What is abc?");
		wait.forElementToBeVisible(addans);
		addans.sendKeys("option A");
		log.info("added options as option a");
		additem.click();
		log.info("clicked on add options");
		wait.forElementToBeVisible(addans);
		addans.sendKeys("option B");
		log.info("added options as option B");
		additem.click();
		log.info("clicked on add options");
		wait.forAllElementToBeVisible(options);
		sa.assertTrue(options.size() > 0, "Options not displayed ");
		sa.assertEquals(options.get(0).getText(), "Option a", "first option didnt match");
		sa.assertEquals(options.get(1).getText(), "Option b", "second option didnt match");
		sa.assertAll();
		log.info("Add choice button working successful");
		log.info("options displayed are:" + options.get(0).getText() + " " + options.get(1).getText());

	}

	public void verifyCVRequired() {
		verifyToggle(cvtoggle, cvcheck, "CV/Resume ");
	}

	public void verifyCoverLetterRequired() {
		verifyToggle(coverlettertoggle, coverlettercheck, "cover letter");

	}

	public void verifyPhotoRequired() {
		verifyToggle(phototoggle, photocheck, "Photo");
	}

	public void verifyPhoneRequired() {
		verifyToggle(phonetoggle, phonecheck, "Phone");
	}

	public void verifyWorkflowButtonAtBottom() {
		wait.forElementToBeVisible(workflowButton);
		click(workflowButton);
		Assert.assertTrue(driver.getCurrentUrl().contains("work-flow"),
				"user not navigated to work flow page , current url " + driver.getCurrentUrl());
		log.info("workflow button at bottom working as expected");
	}

	public void verifyWorkflowButtonAtTop() {
		wait.forElementToBeVisible(workflowAtTop);
		click(workflowAtTop);
		Assert.assertTrue(driver.getCurrentUrl().contains("work-flow"),
				"user not navigated to work flow page , current url " + driver.getCurrentUrl());
		log.info("workflow button at top working as expected");

	}

	/**
	 * Method to drag and drop Stages . Method adjusts x and y coordinates by 127
	 * units to accurately grab the webElement
	 */
	public void verifyDragAndDropProfileFields() {
		addProfileField("Single-line text", "Test Single Line");
		click(closePopup);
		addProfileField("Multi-line text", "Test Multi Line");
		click(closePopup);
		addProfileField("Date", "Test Date");
		click(closePopup);
		addProfileField("Yes/no", "Test Yes No");
		click(closePopup);
		wait.forAllElementToBeVisible(profileFields);
		log.info("Profile fields before drag and drop : " + getStringListFromWebElementList(profileFields));
		
		WebElement source = driver.findElement(By.xpath("//*[contains(text(),'Test Yes No')]"));
		WebElement target = driver.findElement(By.xpath("//*[contains(text(),'Test Date')]"));
		int x1 = source.getLocation().getX() + 127;
		int y1 = source.getLocation().getY() + 127;
		int x2 = target.getLocation().getX() + 127;
		int y2 = target.getLocation().getY() + 127;
	//	js.scrollToTopOfPage();
		dragAndDrop(x1, y1, x2, y2);
	/*	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		click(saveChanges);
		click(closePopup);
		List<String> ProflieFields = getStringListFromWebElementList(profileFields);
		log.info("Profile fields after drag and drop : " + ProflieFields);
		sa.assertEquals(ProflieFields.get(2), "Test Yes No", "drag and drop not done");
		sa.assertEquals(ProflieFields.get(3), "Test Date", "drag and drop not done");
		sa.assertAll();
		log.info("Drag and drop of Profile fields successful :");

	}

	public void clickWorkflowButton() {
		wait.forElementToBeVisible(workflowButton);
		click(workflowButton);
		if (driver.getCurrentUrl().contains("work-flow"))
			log.info("clicked and workflow button and navigated to workflow page successfully");
	}
//
//
//	
//	

	// methods used repeatedly

	/**
	 * Method to add new Screening question.
	 * 
	 * @param que  Text of question to be added
	 * @param type value can be Single line, Multiple lines or Yes/No Type of
	 *             Question need to be added
	 */

	public void addNewScreenQue(String que, String type) {
		click(addque);
		log.info("Clicked on add screening que");
//		wait.forElementToBeVisible(answerType);
		WebElement queType = driver.findElement(By.xpath("//li[contains(text(),'" + type + "')]"));
		click(queType);
		log.info("Selected " + type + " of  question");
		wait.forElementToBeVisible(addQueText);
		addQueText.sendKeys(que);
		log.info("entering que as :" + que);
		click(saveQuestion);
		log.info("clicked on save");
		wait.forAllElementToBeVisible(screeningQues);
		List<String> ScreeningQuetions = getScreenQuestions();
		log.info("Screen questions " + ScreeningQuetions);

	}

	/**
	 * Method to get total screening questions present on screen at moment
	 * 
	 * @return integer count of questions present on screen
	 */
	public int totalNoOfScreeningQues() {
		int total = 0;
		if (screeningQues.size() > 0) {
			try {
				wait.forAllElementToBeVisible(screeningQues);
				total = screeningQues.size();
			} catch (Exception e) {
			}
		}
		return total;
	}

	/**
	 * Method to get list of questions present on screen
	 * 
	 * @return List of String type having questions in it
	 */
	public List<String> getScreenQuestions() {
		wait.forAllElementToBeVisible(screeningQues);
		List<String> ScreeningQuetions = new ArrayList<String>();
		if (screeningQues.size() >= 1) {
			for (WebElement w : screeningQues)
				ScreeningQuetions.add(w.getText().replace("Required", "").replace("Optional", "")); // added this//
																									// replace to
																									// avoid// tags that
																									// were// getting
																									// added to//
																									// question text
		}
		return ScreeningQuetions;

	}

	/**
	 * Method used to verify if Question passed as parameter is present in screening
	 * questions Method save all screening questions present on screen in list and
	 * then verifies if required question is present in it
	 * 
	 * @param text of question that needs to be checked for presence
	 * @return Returns True if question is present on screen else False if question
	 *         is not present
	 */

	public boolean checkPresenceOfQuestion(String que) {
		List<String> questions = new ArrayList<String>();
		boolean check = false;
		int count = totalNoOfScreeningQues();
		if (count >= 1) {
			wait.forAllElementToBeVisible(screeningQues);
			for (WebElement e : screeningQues) {
				questions.add(e.getText().replace("Required", "").replace("Optional", ""));
				if (e.getText().contains(que))
					check = true;
			}
			log.info("Questions present on screen : " + questions);
		}
		return check;
	}

	/**
	 * Method to create custom template of screening question Method selects Create
	 * Custom template option from Templates DropDown then it enters random name in
	 * custom template name field method then creates screening questions in
	 * template and clicks on save
	 * 
	 * @param que1 text of question that needs to be added in custom template
	 * @param que2 text of question that needs to be added in custom template
	 * @return String Name of custom template created
	 */
	public String createScreeningTemplate(String que1, String que2) {
		String name = "Test temp selenium " + rand.nextInt(300);
		click(createCustomTemplateButton);
		log.info("clicked on create custom template button");
		sendKeys(customTemplateInput, name);
		log.info("Entered Template name " + name);
		addNewScreenQue(que1, "Single line");
		addNewScreenQue(que2, "Yes/No");
		click(saveTemplateButton);
		log.info("clicked on save template");
		click(closePopup);
		return name;
	}

	/**
	 * Method to verify if toggle button is working as expected Method checks if
	 * toggle is already set if it is already set then it is kept in set mode If
	 * toggle is not in set mode then method sets the toggle to ON
	 * 
	 * @param button  WebElement of Toggle button
	 * @param checked WebElement of Toggle checked
	 * @param name    Name of Toggle button value can be CV/Resume, Cover letter,
	 *                Photo, Phone.
	 */
	public void verifyToggle(WebElement button, WebElement checked, String name) {
		wait.forElementToBeVisible(button);
		if (getAttribute(checked, "class").contains("checked"))
			log.info(name + " toggle already checked");
		else {
			click(button);
			log.info("clicked on " + name + " toggle");
		}
		Assert.assertTrue(getAttribute(checked, "class").contains("checked"), name + "toggle has problem");
		log.info("clicked on " + name + " toggle successfully");
	}

	/////////////////////////////////////////////////////////////////////
	////////////////////// PROFILE FIELD METHODS ////////////////////////
	////////////////////////////////////////////////////////////////////

	public void verifyAddNewProfileField(String type, String text) {
		List<String> fieldsAfteradd = addProfileField(type, text);
		Assert.assertTrue(fieldsAfteradd.contains(text));
	}

	public void verifyAddNewButtonProfileField() {
		wait.forElementToBeVisible(profileFieldsHeading);
		click(addNewProfileField);
		log.info("clicked on Add New Profile Field");
		wait.forElementToBeVisible(profileFieldInput);
		sa.assertTrue(selectProfileFieldType.isDisplayed(), "Profile field type field missing");
		sa.assertTrue(profileFieldInput.isDisplayed(), "Profile field input field missing");
		sa.assertAll();
		log.info("Clicked on Add New button and all fields are present");
	}

	public void verifyProfileFieldNameAndType() {
		wait.forElementToBeVisible(profileFieldsHeading);
		click(addNewProfileField);
		click(profileFieldsave);
		log.info("clicked on Save button to check mandatory field error");
		log.info("Error popped up : " + getText(mandfieldserror));
		sa.assertTrue(getText(mandfieldserror).contains("Mandatory"), "wrong error validation check logs for error");
		click(closeError);
		sendKeys(profileFieldInput, "Test Text");
		log.info("entered value in profile field name");
		click(profileFieldsave);
		log.info("clicked on Save button to check error");
		log.info("Error popped up : " + getText(fieldTypeError));
		sa.assertTrue(getText(fieldTypeError).contains("Input type"), "wrong error validation check logs for error");
		click(closeError);
		selectvisibletext(selectProfileFieldType, "Date");
		click(profileFieldsave);
		sa.assertFalse(isDisplayed(mandfieldserror), "Mandatory field error still present ");
		sa.assertFalse(isDisplayed(fieldTypeError), "Field type error still present");
		sa.assertAll();
		log.info("Profile field name and Type working as expected");
	}

	/**
	 * Method to add profile field
	 * 
	 * @param type Value can be Single-line text, Multi-line text, Yes/no, Date
	 * @param text Input to be entered in field
	 * @return List of Profile fields present on screen
	 */
	public List<String> addProfileField(String type, String text) {
		wait.forElementToBeVisible(profileFieldsHeading);
		click(addNewProfileField);
		log.info("clicked on Add New Profile Field");
		selectvisibletext(selectProfileFieldType, type);
		log.info("selecting profile field type as " + getSelectedOption(selectProfileFieldType));
		sendKeys(profileFieldInput, text);
		log.info("entered text as : " + profileFieldInput.getAttribute("value"));
		click(profileFieldsave);
		log.info("clicked on Save button");
		wait.forAllElementToBeVisible(profileFields);
		List<String> fieldsAfteradd = getStringListFromWebElementList(profileFields);
//		for (WebElement e : profileFields)
//			fieldsAfteradd.add(e.getText());
		log.info("Profile fields after adding new field :" + fieldsAfteradd);
		return fieldsAfteradd;

	}

	public void verifyDeleteProfileFieldButton() {
		addProfileField("Yes/no", "Test Yes No");
		click(closePopup);
		addProfileField("Date", "Test Date");
		click(closePopup);
		wait.forAllElementToBeVisible(profileFields);
		click(deleteProfileField);
		log.info("Deleting profile field");
		//wait.forElementToBeVisible(profileFieldsHeading);
		log.info(getText(confirmAlert));
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		sa.assertEquals(getText(confirmAlert), "Delete field?",
				"Delete Alert heading not correct :" + getText(confirmAlert));
		click(confirmNo);
		log.info("Clicked on No option to check if field does not get deleted");
		sa.assertTrue(getStringListFromWebElementList(profileFields).contains("Test Yes No"),
				"profile field got deleted even after clicking on NO option on Delete Alert");
		click(deleteProfileField);
		log.info("Deleting profile field");
		click(confirmYes);
		log.info("Clicked on Yes option to check if field get deleted");
		List<String> fieldsAfterDelete = getStringListFromWebElementList(profileFields);
		log.info("Proflie fields after deleting : " + fieldsAfterDelete);
		sa.assertTrue(!fieldsAfterDelete.contains("Test Yes No"), "profile field not deleted");
		sa.assertTrue(fieldsAfterDelete.size() == 1, "profile fields more than one");
		sa.assertAll();
		log.info("Profile field deleted , profile field present are :" + fieldsAfterDelete);
	}

	public void verifyEditProfileField() {
		addProfileField("Yes/no", "Test Yes No ");
		click(editProfileField);
		log.info("clicked on edit field");
		wait.forElementToBeVisible(profileFieldInput);
		selectvisibletext(selectProfileFieldType, "Date");
		log.info("edited profile field type as " + getSelectedOption(selectProfileFieldType));
		sendKeys(profileFieldInput, "Test Date Edited");
		log.info("edited text as : " + profileFieldInput.getAttribute("value"));
		click(profileFieldsave);
		log.info("clicked on +Save button");
		List<String> fieldsAfterEdit = getStringListFromWebElementList(profileFields);
		sa.assertEquals(fieldsAfterEdit.get(0), "Test Date Edited");
		click(closePopup);
		wait.forElementToBeClickable(editProfileField);
		click(editProfileField);
		sa.assertEquals(getSelectedOption(selectProfileFieldType), "Date");
		sa.assertAll();
		log.info("Profile fields after editing field successfully :" + fieldsAfterEdit);

	}

	public void verifySingleChoiceProfileField(String fieldName, String option1, String option2, String option3) {
		SoftAssert sa = new SoftAssert();
		wait.forElementToBeVisible(profileFieldsHeading);
		click(addNewProfileField);
		log.info("clicked on Add New Profile Field");
		selectvisibletext(selectProfileFieldType, "Single choice");
		log.info("selecting profile field type as " + getSelectedOption(selectProfileFieldType));
		sendKeys(profileFieldInput, fieldName);
		log.info("entered text as : " + profileFieldInput.getAttribute("value"));
		sa.assertFalse(addOption.isEnabled(), " Options Add button is Enable even there are no Options entered");
		click(profileFieldsave);
		log.info("clicking on save without entering Choices to check error");
		wait.forElementToBeVisible(optionsError);
		log.info("Error popped up as :" + optionsError.getText());
		sa.assertTrue(optionsError.getText().contains("write some options"),
				"profile field Choices error is wrong check log");
		click(closeError);
		sa.assertTrue(Options.getAttribute("placeholder").contains("1"),
				"Options count wrong " + Options.getAttribute("placeholder"));
		sendKeys(Options, option1);
		log.info("Entered choice : " + option1);
		click(addOption);
		log.info(Options.getAttribute("placeholder"));
		sa.assertTrue(Options.getAttribute("placeholder").contains("2"),
				"Options count wrong " + Options.getAttribute("placeholder"));
		sendKeys(Options, option2);
		click(addOption);
		log.info("Clicked on Add button");
		click(profileFieldsave);
		sa.assertFalse(isDisplayed(mandfieldserror), "Mandatory field error still present ");
		sa.assertFalse(isDisplayed(optionsError), "Options error still present");
		log.info("clicking on save to save field");
		click(editProfileField);
		sa.assertEquals(getSelectedOption(selectProfileFieldType), "Single choice", "Field type wrong");

		sa.assertEquals(profileFieldInput.getAttribute("value"), fieldName, "Field name wrong");
		sa.assertTrue(getStringListFromWebElementList(singleChoiceProfileFieldOptions).contains(option1),
				"error in Options available");
		sa.assertTrue(getStringListFromWebElementList(singleChoiceProfileFieldOptions).contains(option2),
				"error in Options available");
		sa.assertAll();
		log.info("Single Choice Profile Field working as expected");

	}

	////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////// AUTO CONFIRMATON MAIL
	//////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////

	public void verifyAutoConfirmationMailToggle() {
		SoftAssert sa = new SoftAssert();
		wait.forElementToBeVisible(autoConfirmMailToggleCheck);
		sa.assertTrue(!autoConfirmMailToggleCheck.getAttribute("class").contains("checked"),
				"Toggle was alredy ON before setting in to ON");
		sa.assertFalse(isDisplayed(autoConfirmationMailSubject), "Mail subject was already present before toggle");
		sa.assertFalse(isDisplayed(autoConfirmationMailBody), "Mail Body was already present before toggle");
		log.info("Toggle is OFF before clicking : "
				+ !autoConfirmMailToggleCheck.getAttribute("class").contains("checked"));
		click(autoConfirmMailToggle);
		log.info("clicked on toggle to set it to ON");
		sa.assertTrue(autoConfirmMailToggleCheck.getAttribute("class").contains("checked"),
				"Toggle NOT set to ON even after setting it to ON");
		sa.assertTrue(isDisplayed(autoConfirmationMailSubject), "Mail subject NOT present After toggle");
		sa.assertTrue(isDisplayed(autoConfirmationMailBody), "Mail Body NOT present after toggle");
		sa.assertAll();
		log.info("Auto Confirmation Mail Toggle working as expected");
	}

	public void verifyAutoConfirmationMailSubject(String subject) {
		click(autoConfirmMailToggle);
		wait.forElementToBeVisible(autoConfirmationMailSubject);
		click(savechanges);
		log.info("clicking on save to check if mandatory field error popps up");
		log.info("error popped up as : " + getText(mailSubjectError));
		
		sa.assertTrue(isDisplayed(mailSubjectError), "Mail subjet kept empty still no error popped up");
		click(closeError);
		setAutoConfirmationMailSubject(subject);
		log.info("Entered value in subject field : " + getAutoConfirmationMailSubject());
		setAutoConfirmationMailBodyText("Test body");
		click(savechanges);
		log.info("clicking on save to check if mandatory field error popps up");
		sa.assertEquals(getAutoConfirmationMailSubject(), subject);
//		log.info(isDisplayed(mailSubjectError));
		sa.assertFalse(isDisplayed(mailSubjectError), "Mail subject filled still error present");
		sa.assertAll();
		log.info("auto Confirmation Mail Subject field working as expected");
	}

	public void verifyAutoConfirmationMailBody(String body) {
		click(autoConfirmMailToggle);
		wait.forElementToBeVisible(autoConfirmationMailSubject);
		click(savechanges);
		log.info("clicking on save to check if mandatory field error popps up");
		log.info("error popped up as : " + getText(mailBodyError));
		sa.assertTrue(isDisplayed(mailBodyError), "Mail subjet kept empty still no error popped up");
		click(closeError);
		setAutoConfirmationMailBodyText(body);
		log.info("Entered value in Body field : " + getAutoConfirmationMailBodyText());
		setAutoConfirmationMailSubject("Test Subject");
		click(savechanges);
		log.info("clicking on save to check if mandatory field error popps up");
		sa.assertEquals(getAutoConfirmationMailBodyText(), body);
		log.info(isDisplayed(mailSubjectError));
		sa.assertFalse(isDisplayed(mailSubjectError), "Mail Body filled still error present");
		sa.assertAll();
		log.info("auto Confirmation Mail Body field working as expected");
	}

	public String getAutoConfirmationMailSubject() {
		return autoConfirmationMailSubject.getAttribute("value");
	}

	public void setAutoConfirmationMailSubject(String subject) {
		sendKeys(autoConfirmationMailSubject, subject);
	}

	public String getAutoConfirmationMailBodyText() {
		driver.switchTo().frame(0);
		String body = getText(autoConfirmationMailBodyText);
		driver.switchTo().parentFrame();
		return body;
	}

	public void setAutoConfirmationMailBodyText(String body) {
		driver.switchTo().frame(0);
		sendKeys(autoConfirmationMailBodyText, body);
		driver.switchTo().parentFrame();
	}

	public List<String> getSavedTemplates() {
		List<String> options = new ArrayList<>();
		WebElement dropdown = driver.findElement(By.xpath("(//div[1]/div[2]/div/div/div/div[2])[2]"));
		click(dropdown);
//		log.info("Total "+templatesOptions.size());
		options = getTextList(templatesOptions);
//		options = getTextList(templatesOptions);
		return options;
	}

	public void selectTemplate(String tempName) {
		clearTextbox(selectTemplateInput);
		sendKeys(selectTemplateInput, tempName);
		By option = By.xpath("//*[@class=' css-15ifuxg']/div[text()='" + tempName + "']");
		driver.findElement(option).click();
	}

}
