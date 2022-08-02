package pages.Jobs;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import commons.BasePage;
import pages.LoginPage;

public class WorkflowPage extends BasePage {

	private static final Logger log = LogManager.getLogger(WorkflowPage.class.getName());
	SoftAssert sa = new SoftAssert();
	Random rand = new Random();

	public WorkflowPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[text()='Save Changes']")
	private WebElement saveChanges;
	@FindBy(xpath = "//div[3]/div[1]/div[2]/select")
	private WebElement pipelineDropdown;
	@FindBy(xpath = "//select[@class='p-2']/option")
	private List<WebElement> pipelineDropdownopt;
	@FindBy(xpath = "//p[text()='Fixed Stages']/following-sibling::div[1]/div/div/div[2]")
	private List<WebElement> fixedstages;
	@FindBy(xpath = "//div[3]/div[@draggable='true']/div/div[2]")
	private List<WebElement> customeStages;
	@FindBy(xpath = "//*[@id='Delete']")
	private WebElement deleteCustomeStage;
	@FindBy(xpath = "//*[@id='Edit']")
	private WebElement editCustomeStage;
	@FindBy(xpath = "//button[contains(text(),'New')]")
	private WebElement addNewStage;
	@FindBy(xpath = "//input[@class='col-12 p-2 font_sm rounded']")
	private WebElement stageName;
	@FindBy(xpath = "//*[contains(text(),'Apply')]/parent::select")
	private WebElement stageType;
	@FindBy(xpath = "//div/select[2]")
	private WebElement stageTimeLimit;
	@FindBy(xpath = "//button/following-sibling::button[contains(text(),'Save Changes')]")
	private WebElement saveEditedStage;
	@FindBy(xpath = "//button[@class='border common_button font_sm rounded text_darkgray font_medium rounded px-lg-3 px-2 py-1']")
	private WebElement canceladdNewStage;
	@FindBy(xpath = "//div[3]/div[5]/div[4]/div/button")
	private WebElement actions;
	@FindBy(xpath = "//li[@value='email']")
	private WebElement sendemail;
	@FindBy(xpath = "//input[@placeholder='Title']")
	private WebElement emailtitle;
	@FindBy(xpath = "//div[@class='my-1']/div/div[2]/div[1]/p")
	private WebElement emailbody;

	@FindBy(xpath = "//button[2][text()='Add Item']")
	private WebElement additem;
	@FindBy(xpath = "//li[@value='Evaluation request']")
	private WebElement evaluationreq;
	@FindBy(xpath = "//select[@class='py-1 w-75 d-block']")
	private WebElement evaluationform;
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alert;
	@FindBy(xpath = "//ul[@class='navbar-nav']/li[4]/a")
	private WebElement teamAtTop;
	@FindBy(xpath = "//span[contains(text(),'Team')]/parent::button")
	private WebElement teamAtBottom;
	@FindBy(xpath = "//*[text()='Team Members']")
	private WebElement teamMembers;

	@FindBy(xpath = "//div[@role='alert'][contains(text(),'Added New')]")
	private WebElement addedNewTemplateMsg;

	@FindBy(xpath = "//div/a/button/span[text()='Application Form']")
	private WebElement applicationFormButtonAtBot;
	@FindBy(xpath = "//ul[@class='navbar-nav']/li[2]/a")
	private WebElement applicationFormButtonAtTop;

	@FindBy(xpath = "//div[text()='Screening Questions']")
	private WebElement screeningQuestions;
	@FindBy(css = ".Toastify>div>div>button")
	private WebElement closePopup;

	////////////////// Custom template webelements
	@FindBy(xpath = "//*[@id='Create custom template']")
	private WebElement createCustomTemplateButton;
	@FindBy(xpath = "//input[@type='text'][contains(@placeholder,'Create')]")
	private WebElement customTemplateName;
	@FindBy(xpath = "//button[text()='Create template']")
	private WebElement createTemplate;
	@FindBy(xpath = "//*[@id=\"react-select-2-input\"]")
	private WebElement selectTemplate;
	@FindBy(xpath = "//input/parent::div/preceding-sibling::div")
	private WebElement selectedTemplate;
	@FindBy(xpath = "//div[text()='No options']")
	private WebElement noOptions;

	@FindBy(xpath = "//div[@id='react-confirm-alert']/div/div/div/div/button[2]")
	private WebElement deleteNo;
	@FindBy(xpath = "//div[@id='react-confirm-alert']/div/div/div/div/button[1]")
	private WebElement deleteYes;
	@FindBy(xpath = "//div[@id='react-confirm-alert']/div/div/div/h1")
	private WebElement deleteAlertHeader;

	// Verify the functionality of Create Custom Template button beside the Pipeline tab.
	public void verifyCreateCustomTemplateButton() {
		click(createCustomTemplateButton);
		log.info("clicked create custom template button");
		sa.assertTrue(isDisplayed(customTemplateName), "custome template input field missing");
		sa.assertTrue(isDisplayed(createTemplate), "create template button missing");
		sa.assertAll();
		log.info("create custom template button working as expected");
	}

	// Verify the functionality of the Create new template input field
	public void verifyCreateCustomTemplateInputField() {
		click(createCustomTemplateButton);
		log.info("clicking on create template button without entering name in input field to check error");
		click(createTemplate);
		sa.assertTrue(isDisplayed(alert), "mandatory field error not popped up");
		sa.assertTrue(verifyPopup("Add pipeline to the template"),
				"check validation text when custome template input field is kept empty");
		sendKeys(customTemplateName, "Test template ");
		log.info("Entered name in field and clicking on create template button to check error");
		click(createTemplate);
		sa.assertTrue(verifyPopup("New template created"),
				"check validation text after filing custom template input field and clicking on create custom template button");
		sa.assertAll();
		log.info("Create custom template working as expected");
	}

	/**
	 * Method to verify if user is able to create custom pipeline template Method
	 * selects create custom template option from templates dropDown then enters
	 * name of template in name field and then adds one stage and clicks on save
	 */
	// Verify the functionality of the create template button
	public void verifyCreateCustomTemplate() {
		String name = "Test Selenium Stage " + rand.nextInt(100);
		String type = "Interview";
		String valid = "14 days";
		//changed xpath of add stage input field
		createCustomPipeline(name, type, valid);
		Assert.assertTrue(verifyPopup("New template created"), "check validation text after template is created");
		log.info("created new template successfully");
	}

	// Verify the functionality of the Select Template field.
	public void verifySelectTemplate() {
		String name = "Test Selenium Stage " + rand.nextInt(100);
		String type = "Interview";
		String valid = "21 days";
		String tempName = createCustomPipeline(name, type, valid);
		click(closePopup);
		refreshPage();
		selectTemplate(fake.letterify("##########"));
		log.info("Entering random name to check if no options suggestion pops up");
		sa.assertTrue(isDisplayed(noOptions),
				"\"No options\" not poped up after entering option not present in list in search field");
		clearTextbox(selectTemplate);
		selectTemplate(tempName);
		List<String> Stages = Arrays.asList("Applied", "Shortlisted", "Schedule", "Qualified", "Rejected");
		log.info("Stages present in template :" + getStages());
		sa.assertTrue(getStages().contains(name) && getStages().containsAll(Stages));
		sa.assertAll();
		log.info("select template field working as expected successfully");
	}

	public void verifyDefaultStages() {

		List<String> expectedDefaultStages = Arrays.asList("Applied", "Shortlisted", "Schedule", "Qualified",
				"Rejected");
		List<String> actualDefaultStages = getStages();
		log.info("Stages present : " + actualDefaultStages);
		sa.assertTrue(actualDefaultStages.containsAll(expectedDefaultStages), "All default stages not present");
		for (String stage : expectedDefaultStages) {
			sa.assertTrue(isEditable(stage), stage + " Stage Edit option not available");
			sa.assertTrue(isDeletable(stage), stage + " Stage Delete option not available");
		}
		sa.assertAll();
		log.info("Default stages present with edit and delete option");
	}

	// Verify that the pipeline stages can be arranged using drag and drop.
	/**
	 * Method to drag and drop Stages . Method adjusts x and y coordinates by 127
	 * units to accurately grab the webElement
	 */
	public void verifyDragAndDropOfPipelineStage() {
		wait.forAllElementToBeVisible(customeStages);
		log.info("Stages before drag and drop : " + getStages());

		WebElement source = driver.findElement(By.xpath("//*[contains(text(),'Rejected')]"));
		WebElement target = driver.findElement(By.xpath("//*[contains(text(),'Applied')]"));

		int x1 = source.getLocation().getX() + 127;
		int y1 = source.getLocation().getY() + 127;
		int x2 = target.getLocation().getX() + 127;
		int y2 = target.getLocation().getY() + 127;
		dragAndDrop(x1, y1, x2, y2);
		saveChanges.click();
		click(closePopup);
		log.info("Stages after drag and drop : " + getStages());
		sa.assertEquals(getStages().get(0), "Rejected", "drag and drop not done");
		sa.assertEquals(getStages().get(1), "Applied", "drag and drop not done");
		sa.assertAll();
		log.info("Pipeline stages can be dragged and dropped succesufully");
	}

	/**
	 * Method to verify if Add new Stage button is working as expected Method checks
	 * that after clicking button Add new stage form opens up with input box of
	 * stage name and dropDown of Stage type and validity
	 */
	//Verify the functionality of Add new button on Pipeline tab.
	public void verifyAddNewStageButton() {
		wait.forElementToBeVisible(addNewStage); // calling method to add new stage
		click(addNewStage);
		log.info("clicked on add new Stage button");
		wait.forElementToBeVisible(stageName);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(stageName.isDisplayed(), "Stagename");
	//	sa.assertTrue(stageType.isDisplayed(), "stageType");
	//	sa.assertTrue(stageTimeLimit.isDisplayed(), "stageTimeLimit");
		sa.assertAll();
		log.info("Add new stage fileds displayed successfully");

	}

	//Verify the functionality of Add new button on Pipeline tab.
	public void verifyAddItemButtonOnAddPipelineTab() {
		click(addNewStage);
		String name = "Test Stage " + fake.letterify("T???");
		log.info("clicked on add new stage");
		sendKeys(stageName, name);
		log.info("entered stage name");
	/*	selectvisibletext(stageType, "Hire");
		log.info("selected stage type");
		selectvisibletext(stageTimeLimit, "14 days");
		log.info("selected stage valid");*/
		click(additem);
		log.info("clicked on add item");
		sa.assertTrue(isDisplayed(alert), "Confrimation message not poped up");
		//changed from equals to true
		sa.assertTrue(verifyPopup("Stage created"), "check validation message after stage is created");
		sa.assertTrue(getStages().contains(name), "newly created Stage not present and saved");
		sa.assertAll();
		log.info("Add item button on add new pipeline tab working as expected");
	}

	
	public void verifyTemplatesFromPipeline() {
		SoftAssert sa = new SoftAssert();
		selectvisibletext(pipelineDropdown, "None");
		log.info("Selecting none template before ");

		wait.forElementToBeVisible(pipelineDropdown);
		log.info(getSelectedOption(pipelineDropdown));
		int templateBeforeSelecting = customeStages.size() + fixedstages.size();
		log.info("custome stages before  selecting : " + customeStages.size());
		log.info("fixed stages before  selecting : " + fixedstages.size());
		log.info("total templates before selecting : " + templateBeforeSelecting);
		selectvisibletext(pipelineDropdown, "Pipeline Small");
		sa.assertTrue(isSelected(pipelineDropdown));
		log.info("Selected pipeline template as : " + getSelectedOption(pipelineDropdown));
		wait.forAllElementToBeVisible(fixedstages);
		int templateAfterSelecting = customeStages.size() + fixedstages.size();
		log.info("total templates after selecting : " + templateAfterSelecting);
		sa.assertTrue(templateBeforeSelecting <= 4);
		sa.assertTrue(templateAfterSelecting > 2);
		sa.assertAll();
		log.info("templates displayed");
	}

	/**
	 * Method to verify stage name field. Method first keeps stage name field blank
	 * and enters value in stage type and stage validity field and clicks on add
	 * item button to verify if mandatory field error appears then method enters
	 * stage name and clicks on add item button and verifies if stage is added or
	 * not
	 */
	public void verifyStageName() {
		click(addNewStage);
		wait.forElementToBeVisible(stageName);
	//	selectvisibletext(stageTimeLimit, "14 days");
	//	log.info("selected stage time limit as 14");
	//	selectvisibletext(stageType, "Phone screen");
	//	log.info("selected stage type as phone screen");
		click(additem);
		log.info("clicking on add item without entering stage name to check error");
		log.info("waiting for mandatory field error to popup");
		log.info("error popped up as " + getText(alert));
		sa.assertTrue(isDisplayed(alert), "alert missing");
		sa.assertEquals(getText(alert), "Mandatory fields are required");
		click(closePopup);
		sendKeys(stageName, "Test Selenium Stage");
		log.info("entering stage name as : " + "Test Selenium Stage");
		log.info("clicking on add item after entering stage name to check error");
		click(additem);
		click(closePopup);
		sa.assertFalse(isDisplayed(alert), "Error present even after all mandatory fields are entered");
		sa.assertTrue(getStages().contains("Test Selenium Stage"), "stage name didnot match :" + getStages());
		sa.assertAll();
		log.info("stage name input box working successfully");
	}

	/**
	 * Method to verify stage Type field. Method first keeps stage Type field blank
	 * and enters value in stage name and stage validity field and clicks on add
	 * item button to verify if mandatory field error appears then method enters
	 * stage Type and clicks on add item button . At last method opens newly added
	 * stage to verify stage type as selected
	 */
	public void verifyStageType(String type) {
		click(addNewStage);
		sendKeys(stageName, "Test Selenium Stage");
		log.info("Entering stage name");
		selectvisibletext(stageTimeLimit, "14 days");
		log.info("selected stage valid as 14 days");
		click(additem);
		log.info("clicking on add item without entering stage type to check error");
		log.info("waiting for mandatory field error to popup");
		log.info("error popped up as " + getText(alert));
		sa.assertTrue(isDisplayed(alert), "alert missing");
		sa.assertEquals(getText(alert), "Mandatory fields are required");
		click(closePopup);
		selectvisibletext(stageType, type);
		log.info("selected stage type as " + type);
		log.info("clicking on add item after entering stage Type to check error");
		click(additem);
		click(closePopup);
		sa.assertFalse(isDisplayed(alert), "Error present even after all mandatory fields are entered");
		editStage("Test Selenium Stage");
		sa.assertEquals(getSelectedOption(stageType), type);
		sa.assertAll();
		log.info("stage type working successfully");
	}

	/**
	 * Method to verify stage validity field. Method first keeps stage validity
	 * field blank and enters value in stage name and stage Type field and clicks on
	 * add item button to verify if mandatory field error appears then method enters
	 * stage validity and clicks on add item button . At last method opens newly
	 * added stage to verify stage validity as selected
	 */
	public void verifyStageValidity(String validity) {
		click(addNewStage);
		sendKeys(stageName, "Test Selenium Stage Validity");
		log.info("Entering stage name");
		selectvisibletext(stageType, "Phone screen");
		log.info("selected stage type as phone screen");
		click(additem);
		log.info("clicking on add item without entering stage validity to check error");
		log.info("waiting for mandatory field error to popup");
		log.info("error popped up as " + getText(alert));
		sa.assertTrue(isDisplayed(alert), "alert missing");
		sa.assertEquals(getText(alert), "Mandatory fields are required");
		click(closePopup);
		selectvisibletext(stageTimeLimit, validity);
		log.info("selected stage validity as" + validity);
		click(additem);
		log.info("clicking on add item after entering stage validity to check error");
		click(closePopup);
		sa.assertFalse(isDisplayed(alert), "Error present even after all mandatory fields are entered");
		editStage("Test Selenium Stage Validity");
		sa.assertEquals(getSelectedOption(stageTimeLimit), validity);
		sa.assertAll();
		log.info("stage validity working successfully");
	}

	public void verifyEditDefaultStage() {
		String originalName = getStages().get(rand.nextInt(getStages().size()));
		log.info("Editing stage with name :" + originalName);
		verifyEditStage(originalName, originalName + " Edited");
	}

	public void verifyDeleteDefaultStage() {
		String Name = getStages().get(rand.nextInt(getStages().size()));
		verifyDeleteStage(Name);
	}

	public void verifyEditCustomStage() {
		addNewStage("Stage To Edit", "Hire", "7 days");
		addNewStage("Test Stage", "Offer", "21 days");
		String originalName = "Stage To Edit";
		log.info("Editing stage with name :" + originalName);
		verifyEditStage(originalName, originalName + " Edited");
	}

	public void verifyDeleteCustomStage() {
		addNewStage("Stage To Delete", "Hire", "7 days");
		addNewStage("Test Stage", "Offer", "21 days");
		String originalName = "Stage To Delete";
		log.info("Deleting stage with name :" + originalName);
		verifyDeleteStage(originalName);
	}

	/**
	 * Method to verify cancel button on Add new stage form.
	 */
	public void verifyCancelButtonOnAddNewPipelineTab() {
		boolean check = true;
	//	selectvisibletext(pipelineDropdown, "None");
		wait.forElementToBeVisible(addNewStage);
		addNewStage.click();
		log.info("clicked on add new stage");
		wait.forElementToBeVisible(stageName);
		log.info("add new stage form dispalyed");
		js.scrollDown();
	    click(canceladdNewStage);
		log.info("clicked on cancel button ");
		try {
			if (stageName.isDisplayed())
				log.info("add new stage form didnt disappear after clicking on cancel button");
		} catch (Exception e) {
			check = false;
		}
		Assert.assertFalse(check);
		log.info("add new stage form disappeared after clicking on cancel button");
	}

	public void verifyApplicationFormTab() {
		wait.forElementToBeVisible(applicationFormButtonAtTop);
		click(applicationFormButtonAtTop);
		wait.forElementToBeVisible(screeningQuestions);
		Assert.assertTrue(driver.getCurrentUrl().contains("application-form"),
				"user not navigate to job posting page, current url : " + driver.getCurrentUrl());
		log.info("Application form button at top working as expected");
	}

	public void verifyApplicationFormButton() {
		wait.forElementToBeVisible(applicationFormButtonAtBot);
		click(applicationFormButtonAtBot);
		wait.forElementToBeVisible(screeningQuestions);
		Assert.assertTrue(driver.getCurrentUrl().contains("application-form"),
				"user not navigate to job posting page , current url : " + driver.getCurrentUrl());
		log.info("Application form button at Bottom working as expected");
	}

	public void verifyTeamTab() {
		wait.forElementToBeVisible(teamAtTop);
		click(teamAtTop);
		wait.forElementToBeVisible(teamMembers);
		Assert.assertTrue(driver.getCurrentUrl().contains("team"),
				"user not navigate to Team page, current url : " + driver.getCurrentUrl());
		log.info("Team button at top working as expected");
	}

	public void verifyTeamButton() {
		wait.forElementToBeVisible(teamAtBottom);
		click(teamAtBottom);
		wait.forElementToBeVisible(teamMembers);
		Assert.assertTrue(driver.getCurrentUrl().contains("team"),
				"user not navigate to Team page, current url : " + driver.getCurrentUrl());
		log.info("Team button at bottom working as expected");
	}

	
	
	/**
	 * Method to create custom template
	 * 
	 * @param name  Value can be name of stage user wants to create
	 * @param type  Value can be Apply, Phone screen, Interview, Evaluation, Offer,
	 *              Hire
	 * @param valid Value can be 5,7,14,21 days or No validity
	 * @return returns Name of pipeline created
	 */
	public String createCustomPipeline(String name, String type, String valid) {
		click(createCustomTemplateButton);
		String pipelineName = "Test Pipe Selenium " + rand.nextInt(300);
		sendKeys(customTemplateName, pipelineName);
		log.info("entered name of custome pipeline");
		addNewStage(name, type, valid);
		log.info("added new stage");
		click(createTemplate);
		log.info("clicked on save template");
		return pipelineName;
	}

	/**
	 * Method to add new stage
	 * 
	 * @param name  Value can be name of stage user wants to create
	 * @param type  Value can be Apply, Phone screen, Interview, Evaluation, Offer,
	 *              Hire
	 * @param valid Value can be 5,7,14,21 days or No validity
	 */
	public void addNewStage(String name, String type, String valid) {
		wait.forElementToBeVisible(addNewStage);
		click(addNewStage);
		log.info("clicked on add new stage");
		sendKeys(stageName, name);
		log.info("entered stage name");
	/*	selectvisibletext(stageType, type);
		log.info("selected stage type");
		selectvisibletext(stageTimeLimit, valid);
		log.info("selected stage valid");*/
		click(additem);
		log.info("clicked on add item");
		log.info("Newly added stage " + getStages());
		click(closePopup);
	}

	/**
	 * Method to get list of stages present on page Method first checks if total
	 * stages are greater than 0 if number of stages is greater than 0 then method
	 * returns list of stages else method returns empty list
	 * 
	 * @return List of string type of stage names
	 */

	public List<String> getStages() {
		List<String> Stages = new ArrayList<>();
		try {
			if (customeStages.size() > 0) {
				wait.forAllElementToBeVisible(customeStages);
				for (WebElement w : customeStages)
					Stages.add(w.getText());
			}
		} catch (Exception e) {
		}

		return Stages;
	}

	public void selectTemplate(String name) {
		sendKeys(selectTemplate, name);
		sendKeys(selectTemplate, Keys.ENTER);
	}

	/**
	 * method to check if edit option is visible for corresponding stage
	 * 
	 * @param stage name of stage for which edit option needs to be checked
	 * @return returns True if edit option present OR returns False if edit option
	 *         not present
	 */
	public boolean isEditable(String stage) {
		boolean flag = false;
		By defaultEdit = By.xpath("//div[text()='" + stage + "']/following-sibling::div/button[@id='Edit']");
		try {
			WebElement edit = driver.findElement(defaultEdit);
			flag = isDisplayed(edit);
		} catch (Exception e) {
			log.info("Web Element not present");
		}
		return flag;
	}

	/**
	 * method to check if Delete option is visible for corresponding stage
	 * 
	 * @param stage name of stage for which Delete option needs to be checked
	 * @return returns True if Delete option present OR returns False if Delete
	 *         option not present
	 */
	public boolean isDeletable(String stage) {
		boolean flag = false;
		By defaultDelete = By.xpath("//div[text()='" + stage + "']/following-sibling::div/button[@id='Delete']");
		try {
			WebElement delete = driver.findElement(defaultDelete);
			flag = isDisplayed(delete);
		} catch (Exception e) {
			log.info("Web Element not present");
		}
		return flag;
	}

	public void verifyEditStage(String originaleName, String updatedName) {
		editStage(originaleName);
	//	String originalType = getSelectedOption(stageType);
	//	String originalValid = getSelectedOption(stageTimeLimit);
	//	String editedType = getUpdatedStageType(originalType);
	//	String editedValid = getUpdatedStageValid(originalValid);
		log.info("Original stage name :" + originaleName);
	//	log.info("Original stage type :" + originalType);
	//	log.info("Original stage valid :" + originalValid);
		clearTextbox(stageName);
		sendKeys(stageName, updatedName);
		log.info("Edited name " + getText(stageName));
	//	selectvisibletext(stageType, editedType);
	//	log.info("edited stage type to : " + editedType);
	//	selectvisibletext(stageTimeLimit, editedValid);
	//	log.info("edited stage Valid to : " + editedValid);
		click(saveEditedStage);
		sa.assertTrue(isDisplayed(alert), "edit confirmation not popped up");
		sa.assertEquals(getText(alert), "Saved updates", "check confirmation text");
		click(closePopup);
		click(saveChanges);
		click(closePopup);
		refreshPage();
		sa.assertTrue(getStages().contains(updatedName), "Edited Stage name missing " + getStages());
		editStage(originaleName + " Edited");
	//	sa.assertEquals(getSelectedOption(stageTimeLimit), editedValid);
	//	sa.assertEquals(getSelectedOption(stageType), editedType);
		sa.assertAll();
		log.info("Edited Stage successfully");

	}

	public void verifyDeleteStage(String name) {

		deleteStage(name);
		log.info("Deleting stage : " + name);
		sa.assertTrue(getText(deleteAlertHeader).contains("Delete stage"), "check alert header");
		click(deleteNo);
		log.info("clicking on NO option to check stage does not get deleted");
		log.info("stages Present " + getStages());
		sa.assertTrue(getStages().contains(name), "stage got deleted even after clicking on NO");
		deleteStage(name);
		log.info("Deleting stage : " + name);
		click(deleteYes);
		log.info("clicking on Yes option to check stage gets deleted");
		log.info("stages Present " + getStages());
		sa.assertFalse(getStages().contains(name), "stage did not get deleted even after clicking on Yes");
		sa.assertAll();
		log.info("Stage delete working as expected");

	}

	public void editStage(String stage) {
		By Edit = By.xpath("//div[text()='" + stage + "']/following-sibling::div/button[@id='Edit']");
		WebElement editStage = driver.findElement(Edit);
		click(editStage);
	}

	public void deleteStage(String stage) {
		By delete = By.xpath("//div[text()='" + stage + "']/following-sibling::div/button[@id='Delete']");
		WebElement deleteStage = driver.findElement(delete);
		click(deleteStage);
	}

	public String getUpdatedStageType(String originalType) {

		String updatedType = "";
		List<String> types = new ArrayList<String>(
				Arrays.asList("Apply", "Phone screen", "Interview", "Offer", "Evaluation", "Hire"));

		types.remove(originalType);
		updatedType = types.get(rand.nextInt(types.size() - 1));

		return updatedType;
	}

	public String getUpdatedStageValid(String originalType) {

		String updatedValid = "";
		List<String> validity = new ArrayList<String>(
				Arrays.asList("5 days", "7 days", "14 days", "21 days", "No validity"));

		validity.remove(originalType);
		updatedValid = validity.get(rand.nextInt(validity.size() - 1));

		return updatedValid;
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
