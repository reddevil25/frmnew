package pages.Home;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//import com.sun.tools.sjavac.Log;

import PojoClasses.JobPostingPojo;
import commons.BasePage;
import pages.Jobs.CreateNewJobPage;

public class JobsPage extends BasePage {

	public JobsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'New')]")
	private WebElement newjob;
	@FindBy(xpath = "//ul[@id='layout']/a[3]")
	private WebElement jobs;
	@FindBy(xpath = "//input[@name='job_title']")
	private WebElement jobtitle;
	@FindBy(xpath = "//*[contains(text(),'New Job')]")
	private WebElement createnewjobHeader;
	@FindBy(xpath = "//div/div[1]/div[1]/ul/li[2]") //// div[@class='border_bottom pl-n5']/ul/li[2]
	private WebElement draft;
	@FindBy(xpath = "//div/div[1]/div[1]/ul/li[1]") //// div[@class='border_bottom pl-n5']/ul/li[2]
	private WebElement published;
	@FindBy(xpath = "//div/div[1]/div[1]/ul/li[3]") //// div[@class='border_bottom pl-n5']/ul/li[2]
	private WebElement archived;
	@FindBy(css = "#Edit > svg")
	private WebElement edit;
	@FindBy(xpath = "//*[@id='Filters']")
	private WebElement filter;
	@FindBy(xpath = "//div[@class='mt-1 shadow-sm position-absolute bg-white z-index']")
	private WebElement filterPopup;
	@FindBy(xpath = "(//*[name()='path'])[17]")
	private WebElement filterPopupCross;
	@FindBy(xpath = "//div[2]/div[1]/div/li[1]")
	private WebElement titlefilter;
	@FindBy(xpath = "//div[2]/div[1]/div/li[2]")
	private WebElement deptfilter;
	@FindBy(xpath = "//div[2]/div[1]/div/li[3]")
	private WebElement packagefilter;
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement search;
	@FindBy(xpath = "//div[2]/div[1]/span[2]")
	private WebElement selectedfilter;
	@FindBy(xpath = "(//*[name()='path'])[17]")
	private WebElement selectedfilterCross;
	@FindBy(xpath = "//div[@class='job_card']/div/div[1]/div/div[1]")
	private List<WebElement> jobtitles;
	@FindBy(xpath = "//button[@id='Table view']")
	private WebElement tableView;
	@FindBy(xpath = "//*[@id='Card view']")
	private WebElement cardView;
	@FindBy(xpath = "//thead/tr/th")
	private List<WebElement> columnHeadings;
	@FindBy(xpath = "//tbody/tr/td[1]/div/div")
	private List<WebElement> tableViewTitle;
	@FindBy(xpath = "//tbody/tr[1]/td[2]/span")
	private WebElement tableViewCandidate;
	@FindBy(xpath = "//tbody/tr[1]/td[3]/span")
	private WebElement tableViewDept;
	@FindBy(xpath = "//tbody/tr[1]/td[4]/span")
	private WebElement tableViewLocation;
	@FindBy(xpath = "//tbody/tr[1]/td[5]")
	private WebElement tableViewPublishedDate;
	@FindBy(xpath = "//tbody/tr[1]/td[6]")
	private WebElement tableViewExpiryDate;
	@FindBy(xpath = "//tbody/tr/td[7]/div/span")
	private List<WebElement> tableViewActions;
	@FindBy(xpath = "//button[@id='Move to Published']")
	private WebElement moveToPublished;
	@FindBy(xpath = "//button[@id='Save as Draft']")
	private WebElement saveAsDraft;
	@FindBy(xpath = "//*[@id='Archive']")
	private WebElement moveToArchive;
	@FindBy(xpath = "//*[@id='Duplicate']")
	private WebElement duplicateJob;
	@FindBy(xpath = "//div[@class='react-confirm-alert']/div")
	private WebElement confirmationAlert;
	@FindBy(xpath = "//ul[@class='pagination']/li")
	private List<WebElement> pages;

	@FindBy(xpath = "//div[@class='react-confirm-alert']/div/div/button[1]")
	private WebElement yes;
	@FindBy(xpath = "//div[@class='react-confirm-alert']/div/div/button[2]")
	private WebElement no;
	@FindBy(xpath = "//div[@class=' css-xhupmv-control']")
	private WebElement countDropdown;
	@FindBy(xpath = "//div[@class=' css-1d8n9bt']/parent::div")
	private WebElement dropDown;
	@FindBy(xpath = "//div[@class=' css-1hb1tje-option']")
	private List<WebElement> dropDownOptions;

	@FindBy(xpath = "//div[@class='job_card']")
	private List<WebElement> jobCardsCardview;
	@FindBy(xpath = "//tbody/tr")
	private List<WebElement> jobCardsTableView;
	@FindBy(xpath = "//footer/following-sibling::div/img/following-sibling::span")
	private List<WebElement> candidatesInPipeline;
	@FindBy(xpath = "//h5/span/span")
	private WebElement candidateCountOnJobsPageCardView;
	@FindBy(xpath = "//header/following-sibling::div/div[1]/div[1]")
	private WebElement pipelinePageHeading;
	@FindBy(xpath = "//*[@class='job_card']")
	private List<WebElement> jobsOnPage;
	@FindBy(xpath = "//li/a[@rel='prev']")
	private WebElement previousPageButton;
	@FindBy(xpath = "//li/a[@rel='next']")
	private WebElement nextPageButton;
	@FindBy(xpath = "//*[@class='job_card']/div/div[2]/h4")
	private List<WebElement> departmentJobCard;
	@FindBy(css = "#root > section > main > svg > path:nth-child(1)")
	private WebElement collapseButton;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alert;
	@FindBy(css = ".Toastify>div>div>button")
	private WebElement closePopup;

	private static final Logger log = LogManager.getLogger(JobsPage.class.getName());
	CreateNewJobPage cp = new CreateNewJobPage(driver);
//	HomePage hp = new HomePage(driver);

	// Verify the functionality of the created job title.
	// Verify the functionality of the selected department.
	// Verify the functionality of the selected country.
	// Verify the functionality of the selected state.
	public void verfiyCardView(JobPostingPojo job, String page) {

		boolean flag = true;
		SoftAssert sa = new SoftAssert();
		selectPage(page);
		WebElement title = wait.forElementToBeVisible(driver
				.findElement(By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div[1]/div/div[1]")));
		WebElement edit = wait.forElementToBeVisible(driver
				.findElement(By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div[1]/div/div[2]")));
		WebElement dept = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div[2]/h4")));
		WebElement button = wait.forElementToBeVisible(
				driver.findElement(By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div[2]/button")));
		WebElement location = wait.forElementToBeVisible(driver
				.findElement(By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div[4]/h5/span[2]")));
		List<WebElement> actions = wait.forAllElementToBeVisible(driver
				.findElements(By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div[4]/div/span")));
		String department = getText(dept);
		String exactDepartment = "";
		if (job.getIs_remote())
			exactDepartment = department.substring(0, department.length() - 10);
		else
			exactDepartment = department;

		String exactLocation = job.getJob_location().get("state_name") + " - "
				+ job.getJob_location().get("country_code");
		log.info(exactLocation);
		sa.assertEquals(getText(title), job.getJob_title());
		sa.assertEquals(getAttribute(edit, "id"), "Edit", "check edit button");
		sa.assertEquals(exactDepartment, job.getJob_deptname(), "check dept ");
		sa.assertEquals(getText(location), exactLocation);
		if (job.getIs_remote()) {
			WebElement remote = wait.forElementToBeVisible(driver
					.findElement(By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div[2]/h4/span")));
			sa.assertEquals(getText(remote), "Remote Job");
		}
		if (!job.getIs_remote()) {

			WebElement remote = wait.forElementToBeVisible(driver
					.findElement(By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div[2]/h4/span")));
			sa.assertFalse(isDisplayed(remote), "check remote ");
		}
		if (page.equalsIgnoreCase("draft")) {
			sa.assertEquals(getAttribute(button, "id"), "Publish this job");
			sa.assertEquals(getAttribute(actions.get(0), "id"), "Duplicate");
			sa.assertEquals(getAttribute(actions.get(1), "id"), "Archive");
			sa.assertEquals(getAttribute(actions.get(2), "id"), "Delete");
		}
		if (page.equalsIgnoreCase("published")) {
			sa.assertEquals(getAttribute(button, "id"), "Save as Draft");
			sa.assertEquals(getAttribute(actions.get(0), "id"), "Pipeline");
			sa.assertEquals(getAttribute(actions.get(1), "id"), "Duplicate");
			sa.assertEquals(getAttribute(actions.get(2), "id"), "Archive");
			sa.assertEquals(getAttribute(actions.get(3), "id"), "Delete");
		}
		if (page.equalsIgnoreCase("archived")) {
			sa.assertEquals(button.getAttribute("id"), "Save as Draft");
			sa.assertEquals(getAttribute(actions.get(0), "id"), "Duplicate");
			sa.assertEquals(getAttribute(actions.get(1), "id"), "Delete");
		}
		sa.assertAll();
		log.info("Card view on " + page + " page working as expected");
	}

	public void verifyClickNewJobButton() {
		click(jobs);
		log.info("Navigating to Jobs page");
		click(newjob);
		log.info("Clicked on newjobbutton");
		Assert.assertTrue(isDisplayed(createnewjobHeader));
		log.info("Moved to Create new jobs Page succesfully");
	}

	public void goToSavedJob1() {
		click(draft);
		log.info("clicked on Draft jobs");
		click(edit);
		log.info("clicked on edit saved job");
	}

	public void goToDraftjobs() {
		click(draft);
		log.info("Navigated to Draft Jobs");
	}

	public void goToJobs() {
		click(jobs);
	}

	/**
	 * Method verifies that table view button works as expected ie all jobs are
	 * arranged in table view.
	 * 
	 * @param job  job created
	 * @param page value can be Published, Draft, Archived depends on where button
	 *             needs to verified
	 */
	// Verify the full name of the selected country is visible on the "Table View"
	// job cards.
	public void verifyTableViewButton(JobPostingPojo job, String page) {
		SoftAssert sa = new SoftAssert();
		selectPage(page);
		click(tableView);
		log.info("clicked on table view button");
		wait.forAllElementToBeVisible(columnHeadings);
		List<String> Columns = getStringListFromWebElementList(columnHeadings);
		if (page.equalsIgnoreCase("published")) {
		sa.assertEquals(Columns.toString(),
				"[Title, Candidate, Department, Location, Published Date, Expiry Date, Actions]");
		}
		else if(page.equalsIgnoreCase("draft")) {
			sa.assertEquals(Columns.toString(),
					"[Title, Candidate, Department, Location, Draft Date, Expiry Date, Actions]");
		}
		else if(page.equalsIgnoreCase("archived")) {
			sa.assertEquals(Columns.toString(),
					"[Title, Candidate, Department, Location, Archived Date, Expiry Date, Actions]");
		}
		sa.assertEquals(getText(tableViewTitle.get(0)), job.getJob_title());
		sa.assertEquals(getText(tableViewDept), job.getJob_deptname());
		sa.assertEquals(getText(tableViewLocation), job.getJob_location().get("country_name"));
		sa.assertEquals(getText(tableViewPublishedDate), getDate(job.getPublish_Date()));
		sa.assertEquals(getText(tableViewExpiryDate), getDate(job.getExpiry_Date()));

		if (page.equalsIgnoreCase("published")) {
			sa.assertEquals(getAttribute(tableViewActions.get(0), "id"), "Pipeline");
			sa.assertEquals(getAttribute(tableViewActions.get(1), "id"), "Edit");
			sa.assertEquals(getAttribute(tableViewActions.get(2), "id"), "Duplicate");
			sa.assertEquals(getAttribute(tableViewActions.get(3), "id"), "Archive");
			sa.assertEquals(getAttribute(tableViewActions.get(4), "id"), "Draft");
			sa.assertEquals(getAttribute(tableViewActions.get(5), "id"), "Delete");
		} else if (page.equalsIgnoreCase("draft")) {
			sa.assertEquals(getAttribute(tableViewActions.get(0), "id"), "Edit");
			sa.assertEquals(getAttribute(tableViewActions.get(1), "id"), "Duplicate");
			sa.assertEquals(getAttribute(tableViewActions.get(2), "id"), "Publish");
			sa.assertEquals(getAttribute(tableViewActions.get(3), "id"), "Archive");
			sa.assertEquals(getAttribute(tableViewActions.get(4), "id"), "Delete");
		} else if (page.equalsIgnoreCase("archived")) {
			sa.assertEquals(getAttribute(tableViewActions.get(0), "id"), "Edit");
			sa.assertEquals(getAttribute(tableViewActions.get(1), "id"), "Duplicate");
			sa.assertEquals(getAttribute(tableViewActions.get(2), "id"), "Draft");
			sa.assertEquals(getAttribute(tableViewActions.get(3), "id"), "Delete");
		}
		sa.assertAll();
		log.info("Table view button of " + page + " page working as expected");
		click(cardView); // navigating again to delete job
	}

	public void verifyPipelineButtonOnPublishedJobsCardView(String jobtitle, List<String> candidates) {
		verifyPipelineButton("published", "card", jobtitle, candidates);
	}

	public void verifyPipelineButtonOnPublishedJobsTableView(String jobtitle, List<String> candidates) {
		verifyPipelineButton("published", "table", jobtitle, candidates);
	}

	public void verifyPipelineButtonOnDraftJobsCardView(String jobtitle, List<String> candidates) {
		verifyPipelineButton("draft", "card", jobtitle, candidates);
	}

	public void verifyPipelineButtonOnDraftJobsTableView(String jobtitle, List<String> candidates) {
		verifyPipelineButton("draft", "table", jobtitle, candidates);
	}

//	public void verifyJobCountDropdownOnPublishedPage() {
//		SoftAssert sa = new SoftAssert();
//		jobs.click();
//		draft.click();
//		refreshPage();
//		int jobCountCardViewExpected = 50;
//		int jobCountTableViewExpected = 25;
//		int jobCountCardViewActual = jobCountDropdown("card" , jobCountCardViewExpected);
//		sa.assertTrue(jobCountCardViewActual==jobCountCardViewExpected ||jobCountCardViewActual<jobCountCardViewExpected,
//				"actual count found "+jobCountCardViewActual);
//		int jobCountTableViewActual = jobCountDropdown("card" , jobCountTableViewExpected);
//		sa.assertTrue(jobCountTableViewActual==jobCountTableViewExpected ||jobCountTableViewActual<jobCountTableViewExpected,
//				"actual count found "+jobCountTableViewActual);
//	}

	public void verifyJobCountDropdown(String page, String view, int expected) {
		int actual = 0;
		click(jobs);
		selectPage(page);
		selectView(view);
		js.scrollIntoView(countDropdown);
	//	selectvisibletext(countDropdown, Integer.toString(expected));
		click(countDropdown);
		for(WebElement e:dropDownOptions){
			if(getText(e).equals(expected)) {
				click(e);
				break;
			}
		}
		if (view.equalsIgnoreCase("card")) {
			wait.forAllElementToBeVisible(jobCardsCardview);
			actual = jobCardsCardview.size();
		} else if (view.equalsIgnoreCase("table")) {
			wait.forAllElementToBeVisible(jobCardsTableView);
			actual = jobCardsTableView.size();
		}
		log.info("Jobs count on " + page + " page " + view + " view is :" + actual + " and expected was " + expected);
		Assert.assertTrue(actual == expected || actual < expected);
		log.info("Job count dropdown working as required");
		click(jobs);

	}

	/**
	 * The Method verifies that Next page button is disabled on last page and
	 * Previous page button is disabled on first page. The Method also verifies
	 * total job count is equal or less than total pages multiplied by jobs count
	 * kept in dropDown Method first navigates to last page by clicking on next page
	 * button till user reaches last page then navigates to first page by clicking
	 * on Previous page button till user reaches first page
	 * 
	 * @param jobsKeptOnPage value can be 10, 25, 50, 100 DropDown value at bottom
	 *                       of page
	 * @param page           value can be published, draft, archived depends on
	 *                       pagination needs to be checked on which page
	 */
	public void verifyPagination(int jobsKeptOnPage, String page) {
		click(jobs);
		selectPage(page);
		SoftAssert sa = new SoftAssert();
		wait.forAllElementToBeVisible(pages);
	//	selectvisibletext(countDropdown, Integer.toString(jobsKeptOnPage));
		click(countDropdown);
		for(WebElement e:dropDownOptions) {
			if(getText(e).equals(jobsKeptOnPage)) {
				click(e);
				break;
			}
		}
		int pageCountforNextButton = 1;
		int jobCountforNextButton = 0;

		while (!getAttribute(nextPageButton, "aria-disabled").equals("true")) {
			pageCountforNextButton++;
			wait.forAllElementToBeVisible(jobsOnPage);
			jobCountforNextButton = jobCountforNextButton + jobsOnPage.size();
			wait.forElementToBeVisible(nextPageButton);
			js.scrollIntoViewAndClick(nextPageButton);
		}
		String lastPage = getAttribute(
				wait.forElementToBeVisible(driver.findElement(By.xpath("//*[@class='page-item active']/a"))),
				"aria-label");
		jobCountforNextButton = jobCountforNextButton + jobsOnPage.size();
		log.info("Jobs kept per page on dropdown :" + jobsKeptOnPage);
		log.info("Total pages :" + pageCountforNextButton);
		log.info("Total jobs present on page :" + jobCountforNextButton);
		sa.assertTrue(jobCountforNextButton <= (pageCountforNextButton * jobsKeptOnPage),
				"job count does not match expcted jobs count as per number of pages");
		sa.assertTrue(lastPage.contains(Integer.toString(pageCountforNextButton)),
				"page count and last page number did not match");
		sa.assertTrue(getAttribute(nextPageButton, "aria-disabled").equals("true"),
				"Next page button not disabeld on last page");

		log.info(">>>>>>>>>>>> Details for Previous button check <<<<<<<<<<<<<<<");

		int pageCountforPreviousButton = 1;
		int jobCountforPreviousButton = 0;

		while (!getAttribute(previousPageButton, "aria-disabled").equals("true")) {
			pageCountforPreviousButton++;
			wait.forAllElementToBeVisible(jobsOnPage);
			jobCountforPreviousButton = jobCountforPreviousButton + jobsOnPage.size();
			wait.forElementToBeVisible(previousPageButton);
			js.scrollIntoViewAndClick(previousPageButton);
		}
		String firstPage = getAttribute(
				wait.forElementToBeVisible(driver.findElement(By.xpath("//*[@class='page-item active']/a"))),
				"aria-label");
		jobCountforPreviousButton = jobCountforPreviousButton + jobsOnPage.size();
		log.info("Jobs kept per page on dropdown :" + jobsKeptOnPage);
		log.info("Total pages :" + pageCountforPreviousButton);
		log.info("Total jobs present on page :" + jobCountforPreviousButton);
		sa.assertTrue(jobCountforPreviousButton <= (pageCountforPreviousButton * jobsKeptOnPage),
				"job count does not match expcted jobs count as per number of pages");
		sa.assertTrue(firstPage.contains(Integer.toString(1)), "page count and last page number did not match");
		sa.assertTrue(previousPageButton.getAttribute("aria-disabled").equals("true"),
				"Previous page button not disabeld on last page");
		sa.assertEquals(jobCountforPreviousButton, jobCountforNextButton, "job count did not match");
		sa.assertEquals(pageCountforPreviousButton, pageCountforNextButton, "page count did not match");
		sa.assertAll();
		log.info("pagination working on " + page + " page as expected");

	}

	////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Method to perform action of job to publish ,draft, duplicate, delete or
	 * archive as per requirement
	 * 
	 * @param state    Value can be publish, archive, duplicate, delete, draft
	 *                 depends on what action needs to perform on job
	 * @param jobtitle Title of job for which actions needs to be performed
	 * @param view     Value can be card or table depends on view
	 * @param confirm  Value can be yes or no if yes then action is performed if
	 *                 value is no then action is cancelled
	 * @return returns message of confirmation pop up about action
	 */

	public String doAction(String state, String jobid, String view, String confirm) {
		String confirmationMessage = "";
		//////////////////// for publishing job ///////////////////////////////
		if (state.equalsIgnoreCase("publish")) { /// for publishing job
			wait.forElementToBeVisible(published);
			if (view.equalsIgnoreCase("card")) {
				By publish = By.xpath("//*[@data-job_id='job_id_" + jobid + "']/div/div[2]/button");
				click(wait.forElementToBeVisible(driver.findElement(publish)));
			
			} else if (view.equalsIgnoreCase("table")) {
				By publish = By.xpath("//*[@data-job_id='job_id_" + jobid + "']/td[7]/div/span[@id='Publish']");
				click(wait.forElementToBeVisible(driver.findElement(publish)));
			}
		}
		////////////////////// to Archive Job///////////////////////////////////
		else if (state.equalsIgnoreCase("archive")) { // for archiving job
			wait.forElementToBeVisible(moveToArchive);
			if (view.equalsIgnoreCase("card")) {
				By archive = By.xpath("//*[@data-job_id='job_id_" + jobid + "']/div/div[4]/div/span[@id='Archive']");
				click(wait.forElementToBeVisible(driver.findElement(archive)));
			} else if (view.equalsIgnoreCase("table")) {
				By archive = By.xpath("//*[@data-job_id='job_id_" + jobid + "']/td[7]/div/span[@id='Archive']");
				click(wait.forElementToBeVisible(driver.findElement(archive)));
			}
			////////////////////// to Duplicate Job///////////////////////////////////
		} else if (state.equalsIgnoreCase("duplicate")) { // to duplicate job
			wait.forElementToBeVisible(duplicateJob);
			if (view.equalsIgnoreCase("card")) {
				By duplicate = By
						.xpath("//div[@data-job_id='job_id_" + jobid + "']/div/div[4]/div/span[@id='Duplicate']");
				click(wait.forElementToBeVisible(driver.findElement(duplicate)));
			} else if (view.equalsIgnoreCase("table")) {
				log.info("inside table loop to click on edit button");
				By duplicate = By.xpath("//tr[@data-job_id='job_id_" + jobid + "']/td[7]/div/span[@id='Duplicate']");
				click(wait.forElementToBeVisible(driver.findElement(duplicate)));
			}
		}
		////////////////////// to Delete Job///////////////////////////////////
		else if (state.equalsIgnoreCase("delete")) {
			wait.forElementToBeVisible(draft);
			if (view.equalsIgnoreCase("card")) {
				By delete = By.xpath("//*[@data-job_id='job_id_" + jobid + "']/div/div[4]/div/span[@id='Delete']");
				click(wait.forElementToBeVisible(driver.findElement(delete)));
			} else if (view.equalsIgnoreCase("table")) {
				log.info("inside table loop to click on edit button");
				By delete = By.xpath("//*[@data-job_id='job_id_" + jobid + "']/td[7]/div/span[@id='Delete']");
				click(wait.forElementToBeVisible(driver.findElement(delete)));
			}
		}
		////////////////////// to Draft Job///////////////////////////////////
		else if (state.equalsIgnoreCase("draft")) {
			wait.forElementToBeVisible(draft);
			if (view.equalsIgnoreCase("card")) {
				By draft = By.xpath("//*[@data-job_id='job_id_" + jobid + "']/div/div[2]/button");
				click(wait.forElementToBeVisible(driver.findElement(draft)));
			} else if (view.equalsIgnoreCase("table")) {
				log.info("inside table loop to click on edit button");
				By draft = By.xpath("//*[@data-job_id='job_id_" + jobid + "']/td[7]/div/span[@id='Draft']");
				click(wait.forElementToBeVisible(driver.findElement(draft)));
			}
		}
		log.info("clicked on " + state + " button");
		wait.forElementToBeVisible(confirmationAlert);
		confirmationMessage = getText(confirmationAlert);
		log.info("confirmation popped up ");

		if (confirm.equalsIgnoreCase("yes")) {
			click(yes);
			log.info("clicked on yes to " + state + " job ");
		} else if (confirm.equalsIgnoreCase("no")) {
			click(no);
			log.info("clicked on No to " + state + " job ");
		}
		return confirmationMessage;

	}

	/**
	 * Method to verify edit job button. Method first edits existing job and then
	 * reopens edited job and verify each field is saved while editing
	 * 
	 * @param page Value can be published, draft, archived depends on where edit
	 *             button needs to be verified
	 * @param view value can be Card or Table depends on view
	 * @param job  Job that is getting edited
	 * @return job id of edited job
	 */
	public String verifyEditJob(String page, String view, JobPostingPojo job) {
		CreateNewJobPage cp1 = new CreateNewJobPage(driver);
		SoftAssert sa = new SoftAssert();
		click(jobs);
		selectPage(page); // navigating to page where action needs to be done
		refreshPage(); // refreshing page to locate newly created job
		selectView(view); // selecting view type
		if (view.equalsIgnoreCase("card")) {
			wait.forElementToBeVisible(edit);
			By orginalJobEdit = By
					.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div/div/div[@id='Edit']");
			click(wait.forElementToBeVisible(driver.findElement(orginalJobEdit)));
		} else if (view.equalsIgnoreCase("table")) {
			wait.forElementToBeVisible(edit);
			By orginalJobEdit = By
					.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/td[7]/div/span[@id='Edit']");
			click(wait.forElementToBeVisible(driver.findElement(orginalJobEdit)));
		}
		log.info("clicked on Edit job");
		JobPostingPojo editedJob = cp.createNewJob("edit"); // using create new job method to change values of existing
															// job
		log.info("edited job");
		click(jobs);
		selectPage(page); // navigating to page type again to check if job edited or Not
		refreshPage(); // refreshing page to locate newly created job
		refreshPage();
//		wait.forTextToBePresentInElementValue(jobtitles.get(0), editedJob.getJob_title());
		By EditedJobEdit = By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div/div/div[@id='Edit']");
		click(wait.forElementToBeVisible(driver.findElement(EditedJobEdit)));
		log.info("Opening job again to verify if changes are saved");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	wait.forPage(5);
		sa.assertEquals(cp1.getTextBox("Job Title"), editedJob.getJob_title());
		sa.assertEquals(cp1.getExpiryDate(), editedJob.getExpiry_Date());
		sa.assertEquals(cp1.getDropDownValue("Department"), editedJob.getJob_deptname());
		sa.assertEquals(cp1.getTextBoxWithinFrame("Job Description"), editedJob.getJob_description());
		sa.assertEquals(cp1.getTextBoxWithinFrame("Job Requirement"), editedJob.getJob_requirement());
//		sa.assertTrue(cp1.getTags().contains(editedJob.getJob_tag().get(0)));

		sa.assertEquals(cp1.getDropDownValue("Country"), editedJob.getJob_location().get("country_name"));
		sa.assertEquals(cp1.getDropDownValue("State"), editedJob.getJob_location().get("state_name"));
		sa.assertNotEquals(cp1.getTextBox("City"), job.getJob_location().get("city"));
		sa.assertNotEquals(cp1.getTextBox("City"), job.getJob_location().get("pincode"));
		if (editedJob.getIs_remote())
			sa.assertEquals(cp1.getRemoteToggle(), true,
					"Remote was set while editing but found NOT set while crosschecking");
		if (!editedJob.getIs_remote())
			sa.assertEquals(cp1.getRemoteToggle(), false,
					"Remote was not set while editing but found set while crosschecking");
		sa.assertEquals(cp1.getDropDownValue("Job Type"), editedJob.getJob_type().get("employement_type"));
		sa.assertEquals(cp1.getDropDownValue("Category"), editedJob.getJob_type().get("category"));
		sa.assertEquals(cp1.getDropDownValue("Education"), editedJob.getJob_type().get("education"));
		sa.assertEquals(cp1.getTextBox("Experience"), editedJob.getJob_type().get("experience"));
		sa.assertEquals(cp1.getMinHour(), editedJob.getJob_type().get("min_hours").toString());
		sa.assertEquals(cp1.getMaxHour(), editedJob.getJob_type().get("max_hours").toString());
		sa.assertAll();
		log.info("edit button on " + page + " page and " + view + " view working as expected");
		// log.info(editedJob.getJob_title());
		click(jobs); // navigating back to jobs page to delete job after work is done
		selectPage(page);
		return editedJob.getJob_id();
	}

	public void verifyDuplicateJob(String page, String view, JobPostingPojo job) {
		// customized xpath to duplicate specific job
		SoftAssert sa = new SoftAssert();
		click(jobs);
		selectPage(page); // navigating to page where action needs to be done
		refreshPage(); // refreshing page to locate newly created job
		selectView(view); // selecting view type
		doAction("duplicate", job.getJob_id(), view, "no");
		if (view.equalsIgnoreCase("card")) {
			log.info("Jobs on page : " + getStringListFromWebElementList(jobtitles));
			sa.assertFalse(getStringListFromWebElementList(jobtitles).contains(job.getJob_title() + " [Copy]"),
					"job present on" + page);
		} else if (view.equalsIgnoreCase("table")) {
			log.info("Jobs on page : " + getStringListFromWebElementList(tableViewTitle));
			sa.assertFalse(getStringListFromWebElementList(tableViewTitle).contains(job.getJob_title() + " [Copy]"),
					"job present on" + page);
		}
		String confirmationMsg = doAction("duplicate", job.getJob_id(), view, "yes");
		refreshPage();
		wait.forElementToBeVisible(duplicateJob);
		By EditedJobEdit = By.xpath(
				"//*[contains(text(),'" + job.getJob_title() + " [Copy]" + "')]/following-sibling::div[@id='Edit']");
		click(wait.forElementToBeVisible(driver.findElement(EditedJobEdit))); // clicking on duplicated job to check
																				// entries in job
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		log.info(cp.getJobtitle());
		sa.assertTrue(confirmationMsg.contains("Duplicate"), confirmationMsg);
		sa.assertEquals(cp.getTextBox("Job Title"), job.getJob_title() + " [Copy]");
		sa.assertEquals(cp.getTextBoxWithinFrame("Job Description"), job.getJob_description());
		sa.assertEquals(cp.getTextBoxWithinFrame("Job Requirement"), job.getJob_requirement());

		sa.assertEquals(cp.getDropDownValue("Department"), job.getJob_deptname());
//		sa.assertTrue(cp.getTags().contains(job.getJob_tag().get(0)));
//		sa.assertTrue(cp.getTags().contains(job.getJob_tag().get(1)));
		sa.assertEquals(cp.getDropDownValue("Country"), job.getJob_location().get("country_name"));
		sa.assertEquals(cp.getDropDownValue("State"), job.getJob_location().get("state_name"));
		sa.assertEquals(cp.getTextBox("City"), job.getJob_location().get("city"));
		sa.assertEquals(cp.getTextBox("Pincode"), job.getJob_location().get("pincode"));
		if (job.getIs_remote())
			sa.assertEquals(cp.getRemoteToggle(), true);
		if (!job.getIs_remote())
			sa.assertEquals(cp.getRemoteToggle(), false);
		sa.assertEquals(cp.getDropDownValue("Job Type"), job.getJob_type().get("employement_type"));
		sa.assertEquals(cp.getDropDownValue("Category"), job.getJob_type().get("category"));
		sa.assertEquals(cp.getDropDownValue("Education"), job.getJob_type().get("education"));
		sa.assertEquals(cp.getTextBox("Experience"), job.getJob_type().get("experience"));
		sa.assertEquals(cp.getMinHour(), job.getJob_type().get("min_hours").toString());
		sa.assertEquals(cp.getMaxHour(), job.getJob_type().get("max_hours").toString());
		sa.assertAll();
		log.info("Duplicate button on " + page + " page and " + view + " view working as expected");
		click(jobs); // navigating back to jobs page to delete job after work is done
		selectPage(page);
		refreshPage();
	}

	/**
	 * Method to verify if Archive job button working as expected. Method verifies
	 * following things 1.After clicking on "No" on confirmation pop up job should
	 * remain on same page it should NOT be moved to Archived 2.After clicking on
	 * "Yes" on confirmation pop up job should be moved to Archived and should NOT
	 * be present on page where it was initially 3.Method verifies all entries on
	 * job like title description requirement location type with original job
	 * 
	 * @param page Value can be Draft or Published where job is currently present
	 * @param view value can be card or Table view on which button needs to be
	 *             verified
	 * @param job  JobPostingPojo object
	 */
	public void verifyArchiveJob(String page, String view, JobPostingPojo job) {
		click(jobs);
		SoftAssert sa = new SoftAssert();
		selectPage(page); // navigating to page where action needs to be done
		refreshPage(); // refreshing page to locate newly created job
		selectView(view); // selecting view type
		doAction("archive", job.getJob_id(), view, "no");
		if (view.equalsIgnoreCase("card")) {
			log.info("Jobs on page : " + getListOfJobIds("card"));
			sa.assertTrue(getListOfJobIds("card").contains(job.getJob_id()), "job not present on" + page);
		} else if (view.equalsIgnoreCase("table")) {
			log.info("Jobs on page : " + getListOfJobIds("table"));
			sa.assertTrue(getListOfJobIds("table").contains(job.getJob_id()), "job not present on" + page);
		}
		String confirmationMsg = doAction("archive", job.getJob_id(), view, "yes");
		refreshPage();
		wait.forElementToBeVisible(archived);
		if (view.equalsIgnoreCase("card"))
			sa.assertFalse(getListOfJobIds("card").contains(job.getJob_id()),
					"job still present on " + page + " page even after moved to Archived");
		if (view.equalsIgnoreCase("table"))
			sa.assertFalse(getListOfJobIds("table").contains(job.getJob_id()),
					"job still present on " + page + " page even after moved to Archived");

		archived.click(); // navigating to archived jobs to check if job present there
		refreshPage();

		By EditedJobEdit = By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div/div/div[@id='Edit']");
		click(wait.forElementToBeVisible(driver.findElement(EditedJobEdit))); // clicking on Archived job to check
																				// entries in job
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sa.assertTrue(confirmationMsg.contains("Archive"), confirmationMsg + "dosent have archive word in it");
		sa.assertEquals(cp.getTextBox("Job Title"), job.getJob_title());
		sa.assertEquals(cp.getExpiryDate(), job.getExpiry_Date());
		sa.assertEquals(cp.getTextBoxWithinFrame("Job Description"), job.getJob_description());
		sa.assertEquals(cp.getTextBoxWithinFrame("Job Requirement"), job.getJob_requirement());

		sa.assertEquals(cp.getDropDownValue("Department"), job.getJob_deptname());
//		sa.assertTrue(cp.getTags().contains(job.getJob_tag().get(0)));
//		sa.assertTrue(cp.getTags().contains(job.getJob_tag().get(1)));
		if (job.getIs_remote())
			sa.assertEquals(cp.getRemoteToggle(), true);
		if (!job.getIs_remote())
			sa.assertEquals(cp.getRemoteToggle(), false);
		sa.assertEquals(cp.getDropDownValue("Country"), job.getJob_location().get("country_name"));
		sa.assertEquals(cp.getDropDownValue("State"), job.getJob_location().get("state_name"));
		sa.assertEquals(cp.getTextBox("City"), job.getJob_location().get("city"));
		sa.assertEquals(cp.getTextBox("Pincode"), job.getJob_location().get("pincode"));
		sa.assertEquals(cp.getDropDownValue("Job Type"), job.getJob_type().get("employement_type"));
		sa.assertEquals(cp.getDropDownValue("Category"), job.getJob_type().get("category"));
		sa.assertEquals(cp.getDropDownValue("Education"), job.getJob_type().get("education"));
		sa.assertEquals(cp.getTextBox("Experience"), job.getJob_type().get("experience"));
		sa.assertEquals(cp.getMinHour(), job.getJob_type().get("min_hours").toString());
		sa.assertEquals(cp.getMaxHour(), job.getJob_type().get("max_hours").toString());
		sa.assertAll();
		log.info("Archive button on " + page + " page and " + view + " view working as expected");
		click(jobs); // navigating back to jobs page to delete job after work is done
		click(archived); // navigating to archived to delete job
		refreshPage();

	}

	/**
	 * Method to verify if Draft job button working as expected. Method verifies
	 * following things 1.After clicking on "No" on confirmation pop up job should
	 * remain on same page it should NOT be moved to Draft 2.After clicking on "Yes"
	 * on confirmation pop up job should be moved to Draft and should NOT be present
	 * on page where it was initially 3.Method verifies all entries on job like
	 * title description requirement location type with original job
	 * 
	 * @param page Value can be Archived or Published where job is currently present
	 * @param view value can be card or Table view on which button needs to be
	 *             verified
	 * @param job  JobPostingPojo object
	 */
	public void verifyDraftJob(String page, String view, JobPostingPojo job) {
		click(jobs);
		SoftAssert sa = new SoftAssert();
		selectPage(page); // navigating to page where action needs to be done
		refreshPage(); // refreshing page to locate newly created job
		selectView(view); // selecting view type
		doAction("draft", job.getJob_id(), view, "no");
		if (view.equalsIgnoreCase("card")) {
			log.info("Jobs on page : " + getListOfJobIds("card"));
			sa.assertTrue(getListOfJobIds("card").contains(job.getJob_id()), "job not present on" + page);
		} else if (view.equalsIgnoreCase("table")) {
			log.info("Jobs on page : " + getListOfJobIds("table"));
			sa.assertTrue(getListOfJobIds("table").contains(job.getJob_id()), "job not present on" + page);
		}
		String confirmationMsg = doAction("draft", job.getJob_id(), view, "yes");
		wait.forElementToBeVisible(archived);
		refreshPage();
		if (view.equalsIgnoreCase("card"))
			sa.assertFalse(getListOfJobIds("card").contains(job.getJob_id()),
					"job still present on " + page + " page even after moved to draft");
		if (view.equalsIgnoreCase("table"))
			sa.assertFalse(getListOfJobIds("table").contains(job.getJob_id()),
					"job still present on " + page + " page even after moved to draft");

		click(draft); // navigating to draft jobs to check if job present there
		refreshPage();

		By EditedJobEdit = By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div/div/div[@id='Edit']");
		click(wait.forElementToBeVisible(driver.findElement(EditedJobEdit))); // clicking on Archived job to check
																				// entries in job
		/*try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		sa.assertTrue(confirmationMsg.contains("Draft"), confirmationMsg + "dosent have draft word in it");
		sa.assertEquals(cp.getTextBox("Job Title"), job.getJob_title());
		sa.assertEquals(cp.getExpiryDate(), job.getExpiry_Date());
		sa.assertEquals(cp.getTextBoxWithinFrame("Job Description"), job.getJob_description());
		sa.assertEquals(cp.getTextBoxWithinFrame("Job Requirement"), job.getJob_requirement());

		sa.assertEquals(cp.getDropDownValue("Department"), job.getJob_deptname());
//		sa.assertTrue(cp.getTags().contains(job.getJob_tag().get(0)));
//		sa.assertTrue(cp.getTags().contains(job.getJob_tag().get(1)));
		if (job.getIs_remote())
			sa.assertEquals(cp.getRemoteToggle(), true);
		if (!job.getIs_remote())
			sa.assertEquals(cp.getRemoteToggle(), false);

		sa.assertEquals(cp.getDropDownValue("Country"), job.getJob_location().get("country_name"));
		sa.assertEquals(cp.getDropDownValue("State"), job.getJob_location().get("state_name"));
		sa.assertEquals(cp.getTextBox("City"), job.getJob_location().get("city"));
		sa.assertEquals(cp.getTextBox("Pincode"), job.getJob_location().get("pincode"));
		sa.assertEquals(cp.getDropDownValue("Job Type"), job.getJob_type().get("employement_type"));
		sa.assertEquals(cp.getDropDownValue("Category"), job.getJob_type().get("category"));
		sa.assertEquals(cp.getDropDownValue("Education"), job.getJob_type().get("education"));
		sa.assertEquals(cp.getTextBox("Experience"), job.getJob_type().get("experience"));
		sa.assertEquals(cp.getMinHour(), job.getJob_type().get("min_hours").toString());
		sa.assertEquals(cp.getMaxHour(), job.getJob_type().get("max_hours").toString());
		sa.assertAll();

		log.info("Draft button on " + page + " page and " + view + " view working as expected");
		click(jobs); // navigating back to jobs page to delete job after work is done
		click(draft); // navigating to draft to delete job
		refreshPage();
	}

	/**
	 * Method to verify if Publish job button working as expected. Method verifies
	 * following things 1.After clicking on "No" on confirmation pop up job should
	 * remain on same page it should NOT be moved to Published 2.After clicking on
	 * "Yes" on confirmation pop up job should be moved to Published and should NOT
	 * be present on page where it was initially 3.Method verifies all entries on
	 * job like title description requirement location type with original job
	 * 
	 * @param page Value can be Archived or Draft where job is currently present
	 * @param view value can be card or Table view on which button needs to be
	 *             verified
	 * @param job  JobPostingPojo object
	 */
	public void verifyPublishJob(String page, String view, JobPostingPojo job) {
		click(jobs);
		SoftAssert sa = new SoftAssert();
		selectPage(page); // navigating to page where action needs to be done
		refreshPage(); // refreshing page to locate newly created job
		selectView(view); // selecting view type
		doAction("publish", job.getJob_id(), view, "no");
		if (view.equalsIgnoreCase("card")) {
			log.info("Jobs on page : " + getListOfJobIds("card"));
			sa.assertTrue(getListOfJobIds("card").contains(job.getJob_id()), "job not present on" + page);
		} else if (view.equalsIgnoreCase("table")) {
			log.info("Jobs on page : " + getListOfJobIds("table"));
			sa.assertTrue(getListOfJobIds("table").contains(job.getJob_id()), "job not present on" + page);
		}

		String confirmationMsg = doAction("publish", job.getJob_id(), view, "yes");
		wait.forElementToBeVisible(published);
		refreshPage();
		if (view.equalsIgnoreCase("card"))
			sa.assertFalse(getListOfJobIds("card").contains(job.getJob_id()),
					"job still present on " + page + " page even after publishing");
		if (view.equalsIgnoreCase("table"))
			sa.assertFalse(getListOfJobIds("table").contains(job.getJob_id()),
					"job still present on " + page + " page even after publishing");
		published.click(); // navigating to published jobs to check if job present there
		refreshPage();

		By EditedJobEdit = By.xpath("//*[@data-job_id='job_id_" + job.getJob_id() + "']/div/div/div/div[@id='Edit']");
		click(wait.forElementToBeVisible(driver.findElement(EditedJobEdit))); // clicking on Archived job to check
																				// entries in job
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		sa.assertTrue(confirmationMsg.contains("Publish"), confirmationMsg + "dosent have publish word in it");
		sa.assertEquals(cp.getTextBox("Job Title"), job.getJob_title());
		sa.assertEquals(cp.getExpiryDate(), job.getExpiry_Date());
		sa.assertEquals(cp.getTextBoxWithinFrame("Job Description"), job.getJob_description());
		sa.assertEquals(cp.getTextBoxWithinFrame("Job Requirement"), job.getJob_requirement());
		sa.assertEquals(cp.getDropDownValue("Department"), job.getJob_deptname());
//		sa.assertTrue(cp.getTags().contains(job.getJob_tag().get(0)));
//		sa.assertTrue(cp.getTags().contains(job.getJob_tag().get(1)));
		if (job.getIs_remote())
			sa.assertEquals(cp.getRemoteToggle(), true);
		if (!job.getIs_remote())
			sa.assertEquals(cp.getRemoteToggle(), false);
		sa.assertEquals(cp.getDropDownValue("Country"), job.getJob_location().get("country_name"));
		sa.assertEquals(cp.getDropDownValue("State"), job.getJob_location().get("state_name"));
		sa.assertEquals(cp.getTextBox("City"), job.getJob_location().get("city"));
		sa.assertEquals(cp.getTextBox("Pincode"), job.getJob_location().get("pincode"));
		sa.assertEquals(cp.getDropDownValue("Job Type"), job.getJob_type().get("employement_type"));
		sa.assertEquals(cp.getDropDownValue("Category"), job.getJob_type().get("category"));
		sa.assertEquals(cp.getDropDownValue("Education"), job.getJob_type().get("education"));
		sa.assertEquals(cp.getTextBox("Experience"), job.getJob_type().get("experience"));
		sa.assertEquals(cp.getMinHour(), job.getJob_type().get("min_hours").toString());
		sa.assertEquals(cp.getMaxHour(), job.getJob_type().get("max_hours").toString());
		sa.assertAll();

		log.info("Publish button on " + page + " page and " + view + " view working as expected");
		click(jobs); // navigating back to jobs page to delete job after work is done
		click(published); // navigating to draft to delete job
		refreshPage();
	}

	/**
	 * Method to verify if Delete job button working as expected. Method verifies
	 * following things 1.After clicking on "No" on confirmation pop up job should
	 * NOT get deleted and remain on same page 2.After clicking on "Yes" on
	 * confirmation pop up job should get Deleted
	 * 
	 * @param page Value can be Published, Archived or Draft where job is currently
	 *             present
	 * @param view value can be card or Table view on which button needs to be
	 *             verified
	 * @param job  JobPostingPojo object
	 */
	public void verifyDeleteJob(String page, String view, JobPostingPojo job) {
		click(jobs);
		SoftAssert sa = new SoftAssert();
		selectPage(page); // navigating to page where action needs to be done
		refreshPage(); // refreshing page to locate newly created job
		selectView(view); // selecting view type
		doAction("delete", job.getJob_id(), view, "no");
		if (view.equalsIgnoreCase("card")) {
			log.info("Jobs on page : " + getListOfJobIds("card"));
			sa.assertTrue(getListOfJobIds("card").contains(job.getJob_id()), "job not present on" + page);
		} else if (view.equalsIgnoreCase("table")) {
			log.info("Jobs on page : " + getListOfJobIds("table"));
			sa.assertTrue(getListOfJobIds("table").contains(job.getJob_id()), "job not present on" + page);
		}
		String confirmationMsg = doAction("delete", job.getJob_id(), view, "yes");
		refreshPage();
		wait.forAllElementToBeVisible(jobtitles);
		sa.assertFalse(getListOfJobIds("card").contains(job.getJob_id()),
				"job did not delete " + job.getJob_id() + " jobs on screen " + getListOfJobIds("Card"));
		sa.assertTrue(confirmationMsg.contains("Delete"), confirmationMsg);
		sa.assertAll();
		log.info("Delete button on " + page + " page and " + view + " view working as expected");
	}

	/**
	 * Method to navigate to particular page
	 * 
	 * @param page value can be Published, Draft or Archived
	 */
	public void selectPage(String page) {
		if (page.equalsIgnoreCase("draft")) {
			click(draft);
			log.info("navigated to Draft jobs");
		} else if (page.equalsIgnoreCase("archived")) {
			click(archived);
			log.info("navigated to Archived jobs");
		} else if (page.equalsIgnoreCase("published")) {
			click(published);
			log.info("navigated to published jobs");
		}
	}

	public void selectView(String view) {
		if (view.equalsIgnoreCase("table")) {
			tableView.click();
			log.info("clicking on table view button");
			wait.forAllElementToBeVisible(columnHeadings);
		}
	}

	/**
	 * Method to delete job created
	 * 
	 * @param jobid id of job to be deleted
	 * @param page  value can be Published ,draft, archived page on which job is
	 *              present
	 */
	public void deleteJob(String jobid, String page) {
//		hp.goToJobs();
		click(jobs);
		log.info("navigated to jobs page");
		selectPage(page);
		By delete = By.xpath("//*[@data-job_id='job_id_" + jobid + "']/div/div[4]/div/span[@id='Delete']");
		click(wait.forElementToBeVisible(driver.findElement(delete)));
		click(confirmationAlert);
		click(yes);
		log.info("deleted job " + jobid);
		click(closePopup);

	}

	public void deleteJobinBulk(List<String> jobid, String page) {
		for (String id : jobid) {
			click(jobs);
			log.info("navigated to jobs page");
			selectPage(page);
			By delete = By.xpath("//*[@data-job_id='job_id_" + id + "']/div/div[4]/div/span[@id='Delete']");
			click(wait.forElementToBeVisible(driver.findElement(delete)));
			click(confirmationAlert);
			click(yes);
			log.info("deleted job ");
		}
	}

	public void deleteJobByTitle(String jobtitle, String page) {
		click(jobs);
		log.info("navigated to jobs page");
		selectPage(page);
		By delete = By.xpath("//*[contains(text(),'" + jobtitle
				+ "')]/parent::div/parent::div/following-sibling::div[3]/div/span[@id='Delete']");
		click(wait.forElementToBeVisible(driver.findElement(delete)));
		wait.forElementToBeVisible(confirmationAlert);
		click(confirmationAlert);
		click(yes);
		log.info("deleted job ");

	}

	public void editJob(String jobid) {
		click(jobs);
		click(draft);
		By edit = By.xpath("//*[@data-job_id='job_id_" + jobid + "']/div/div/div/div[@id='Edit']");
		click(wait.forElementToBeVisible(driver.findElement(edit)));
		log.info("Clicked on Edit job button");
	}

	/**
	 * Method to Publish job created
	 * 
	 * @param jobid id of job to be Published
	 */
	public void publishJob(String jobid) {
		click(jobs);
		log.info("navigating to jobs page");
		selectPage("draft");
		doAction("publish", jobid, "card", "yes");
		refreshPage();
	}

	public void publishJobinBulk(List<String> jobid) {
		for (String id : jobid) {
			click(jobs);
			log.info("navigating to jobs page");
			selectPage("draft");
			doAction("publish", id, "card", "yes");
			refreshPage();
		}
	}

	/**
	 * Method to Archive job created
	 * 
	 * @param jobid id of job to be Archived
	 * @param page  value can be Published or Draft where job is currently present
	 */
	public void archiveJob(String jobid, String page) {
		click(jobs);
		log.info("navigating to jobs page");
		selectPage(page);
		doAction("archive", jobid, "card", "yes");
		refreshPage();
	}

	/**
	 * Method to Draft job created
	 * 
	 * @param jobid id of job to be moved to Draft
	 * @param page  value can be Published or Archived where job is currently
	 *              present
	 */
	public void draftJob(String title) {
		click(jobs);
		log.info("navigating to jobs page");
		selectPage("published");
		doAction("draft", title, "card", "yes");
		refreshPage();
	}

	/**
	 * Method use to verify search function as per title. Method first enters
	 * keyword in search field and verify all listed jobs contain keyword in its
	 * title. then method clears search field to verify all jobs are restored
	 * 
	 * @param keyword value can be anything which needs to be searched.
	 * @param page    value can be published, draft, archived based on where search
	 *                operation needs to get verify
	 */
	public void verifySearchFieldAsPerTitle(String keyword, String page) {
		boolean check = true;
		SoftAssert sa = new SoftAssert();
		selectPage(page);
		log.info("navigating to page :" + page);
		click(filter);
		log.info("clicked on Filter option");
		log.info("filter popup is displayed: " + isDisplayed(filterPopup));
		sa.assertTrue(isDisplayed(filterPopup), "filter popup not displayed");
		log.info("text in the popup: " + getText(filterPopup));
		sa.assertTrue(getText(filterPopup).contains("Title"), "Title keyword not displayed in the popup");
		sa.assertTrue(getText(filterPopup).contains("Department"), "Department keyword not displayed in the popup");
		click(filterPopupCross);
		log.info("clicked on filter popup cross button to check if the filter popup closes...");
		log.info("filter popup displayed after clicking cross button: " + isDisplayed(filterPopup));
		sa.assertFalse(isDisplayed(filterPopup), "filter popup displayed even after clicking cross button");
		click(filter);
		log.info("clicked on Filter option again");
		click(titlefilter);
		log.info("Trying to Select title as filter ");
		log.info("Selected filter as : " + getText(selectedfilter));
		sa.assertEquals(getText(selectedfilter), "Title", "Selected filter does not contain 'Title' ");
		sendKeys(search, keyword);
		log.info("Searching jobs having keyword as :" + keyword);
		sendKeys(search, Keys.ENTER);

		List<String> titlesAfterSearch = new ArrayList<String>();
		wait.forAllElementsToBePresent(By.xpath("//div[@class='job_card']/div/div[1]/div"));

		titlesAfterSearch = getStringListFromWebElementList(jobtitles);
		log.info("Jobs after searching as per title containing " + keyword + " : " + titlesAfterSearch);
		for (String s : titlesAfterSearch) {
			if (!s.contains(keyword))
				check = false;
		}
		sa.assertTrue(check, "Job titles not containing keyword :" + titlesAfterSearch);
		click(selectedfilterCross);
		log.info("selected filter displayed after clicking cross button: " + (isDisplayed(selectedfilter)));
		sa.assertFalse(isDisplayed(selectedfilter), "filter visible even after clicking cross button");
	//	refreshPage();
		log.info("search field as per Title working as expected");
	}

	/**
	 * Method use to verify search function as per Department . Method first enters
	 * keyword in search field and verify all listed jobs contain keyword in its
	 * title. then method clears search field to verify all jobs are restored
	 * 
	 * @param keyword value can be anything which needs to be searched.
	 * @param page    value can be published, draft, archived based on where search
	 *                operation needs to get verify
	 */
	public void verifySearchFieldAsPerDepartment(String keyword, String page) {
		boolean check = true;
		SoftAssert sa = new SoftAssert();
		selectPage(page);
		log.info("navigating to page :" + page);
		click(filter);
		log.info("clicked on Filter option");
		log.info("filter popup is displayed: " + isDisplayed(filterPopup));
		sa.assertTrue(isDisplayed(filterPopup), "filter popup not displayed");
		log.info("text in the popup: " + getText(filterPopup));
		sa.assertTrue(getText(filterPopup).contains("Title"), "Title keyword not displayed in the popup");
		sa.assertTrue(getText(filterPopup).contains("Department"), "Department keyword not displayed in the popup");
		click(filterPopupCross);
		log.info("clicked on filter popup cross button to check if the filter popup closes...");
		log.info("filter popup displayed after clicking cross button: " + isDisplayed(filterPopup));
		sa.assertFalse(isDisplayed(filterPopup), "filter popup displayed even after clicking cross button");
		click(filter);
		log.info("clicked on Filter option again");
		click(deptfilter);
		log.info("Trying to Select department as filter ");
		log.info("Selected filter as : " + getText(selectedfilter));
		sa.assertEquals(getText(selectedfilter), "Department", "Selected filter does not contain 'Department' ");
		sendKeys(search, keyword);
		log.info("Searching jobs having keyword as :" + keyword);
		sendKeys(search, Keys.ENTER);

		List<String> departmentsAfterSearch = new ArrayList<String>();
		wait.forAllElementsToBePresent(By.xpath("//*[@class='job_card']/div/div[2]/h4"));

		for (WebElement w : departmentJobCard) {
			if (getText(w).contains("Remote Job"))
				departmentsAfterSearch.add(getText(w).replace("Remote Job", ""));
			else
				departmentsAfterSearch.add(getText(w));
		}
		log.info(
				"departments after searching as per department containing " + keyword + " : " + departmentsAfterSearch);
		for (String s : departmentsAfterSearch) {
			if (!s.equalsIgnoreCase(keyword))
				check = false;
		}
		log.info("Departments after search : " + departmentsAfterSearch);
		sa.assertTrue(check, "Department not contains keyword :" + departmentsAfterSearch);
		click(selectedfilterCross);
		log.info("selected filter displayed after clicking cross button: " + (isDisplayed(selectedfilter)));
		sa.assertFalse(isDisplayed(selectedfilter), "filter visible even after clicking cross button");
	//	refreshPage();
		log.info("search field as per Department working as expected");
	}

	public void clickNewJobButton() {
		wait.forElementToBeVisible(jobs);
		click(jobs);
		log.info("Navigating to Jobs page");
		click(newjob);
		log.info("Clicked on newjobbutton");
	}

	/**
	 * Method verifies Pipeline button opens pipeline page for respective job
	 * candidate count on jobs page and candidate count on pipeline page . names of
	 * candidate assigned to job and names present on pipeline page of respective
	 * job
	 * 
	 * @param page       Value can be published or draft based on state of job
	 * @param view       Value can be card or table based on which pipeline button
	 *                   needs to be verified
	 * @param JobTitle   Value is Title of job for which pipeline button needs to be
	 *                   verified
	 * @param candidates List of Candidate names assigned to job
	 */
	public void verifyPipelineButton(String page, String view, String JobTitle, List<String> candidates) {
		SoftAssert sa = new SoftAssert();
		selectPage(page);

		if (view.equalsIgnoreCase("card")) {
			By candidateCount = By
					.xpath("//*[text()='" + JobTitle + "']/parent::div/following-sibling::div[3]/h5/span/span");
			int countOnJobsPage = Integer.parseInt(driver.findElement(candidateCount).getText());
			log.info("Count on job card : " + countOnJobsPage);

			By pipeline = By.xpath("//*[contains(text(),'" + JobTitle
					+ "')]/parent::div/following-sibling::div[3]/div/span[@id='Pipeline']");
			driver.findElement(pipeline).click();
			wait.forAllElementToBeVisible(candidatesInPipeline);
			String pipelineHeading = pipelinePageHeading.getText();

			int countOnPipelinePage = candidatesInPipeline.size();
			log.info("Count on pipeline page :" + countOnPipelinePage);
			List<String> CandidatesOnPipelinePage = getStringListFromWebElementList(candidatesInPipeline);
			sa.assertEquals(pipelineHeading, JobTitle.toUpperCase(), "check pipeline heading");
			sa.assertEquals(countOnPipelinePage, countOnJobsPage, "check canddiate count in logs");
			sa.assertTrue(CandidatesOnPipelinePage.contains(candidates.get(0)), "Candidates assigned not matching");
			sa.assertTrue(CandidatesOnPipelinePage.contains(candidates.get(1)), "Candidates assigned not matching");
			sa.assertAll();

		} else if (view.equalsIgnoreCase("table")) {
			selectView(view);
			By candidateCount = By
					.xpath("//*[text()='" + JobTitle + "']/parent::div/parent::td/following-sibling::td[1]");
			int countOnJobsPage = Integer.parseInt(driver.findElement(candidateCount).getText());
			log.info("Count on jobs page   : " + countOnJobsPage);

			By pipeline = By.xpath("//*[@title='" + JobTitle
					+ "']/parent::div/parent::td/following-sibling::td[6]/div/span[@id='PipeLine']");
			driver.findElement(pipeline).click();
			wait.forAllElementToBeVisible(candidatesInPipeline);
			String pipelineHeading = pipelinePageHeading.getText();
			int countOnPipelinePage = candidatesInPipeline.size();
			log.info("Count on pipeline page :" + countOnPipelinePage);
			List<String> CandidatesOnPipelinePage = getStringListFromWebElementList(candidatesInPipeline);
			sa.assertEquals(pipelineHeading, JobTitle.toUpperCase(), "check pipeline heading");
			sa.assertEquals(countOnPipelinePage, countOnJobsPage, "check canddiate count in logs");
			sa.assertTrue(CandidatesOnPipelinePage.contains(candidates.get(0)), "Candidates assigned not matching");
			sa.assertTrue(CandidatesOnPipelinePage.contains(candidates.get(1)), "Candidates assigned not matching");
			sa.assertAll();

		}
	}

	public List<String> getListOfJobIds(String view) {

		List<String> jobIds = new ArrayList<String>();

		if (view.equalsIgnoreCase("card")) {
			for (WebElement w : jobCardsCardview)
				jobIds.add(w.getAttribute("data-job_id").substring(7));
		} else if (view.equalsIgnoreCase("table")) {
			for (WebElement w : jobCardsTableView)
				jobIds.add(w.getAttribute("data-job_id").substring(7));
		}
		return jobIds;
	}

	/**
	 * Method to get date in format eg 02 Feb, 2022
	 * 
	 * @param date String Date which needs to be converted to format
	 * @return String formatted date
	 */
	public String getDate(String date) {

		String[] months = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };

		int month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.lastIndexOf("-")));

		date = date.substring(0, date.indexOf("-")) + " " + months[month - 1] + ", "
				+ date.substring(date.lastIndexOf("-") + 1);

		return date;
	}

	public void goToPipeline(String jobId) {
		goToJobs();
		By pipeline = By.xpath("//*[@data-job_id='job_id_" + jobId + "']/div/div[4]/div/span[@id='Pipeline']");
		//driver.findElement(pipeline).click();
		click(driver.findElement(pipeline));
	}

	public String getJobCount(String pages) {
		if (pages.equalsIgnoreCase("published")) {
			click(published);
			log.info("Navigated to published jobs");
		} else if (pages.equalsIgnoreCase("draft")) {
			click(draft);
			log.info("Navigated to draft jobs");
		} else if (pages.equalsIgnoreCase("archived")) {
			click(archived);
			log.info("Navigated to archived jobs");
		}
		log.info(getAttribute(nextPageButton, "aria-disabled"));
		// selectvisibletext(countDropdown, "100");
		click(dropDown);
		for (WebElement e : dropDownOptions) {
			if (getText(e).equals("100")) {
				click(e);
				break;
			}
		}
		log.info("No. of jobs on page are: " + getText(dropDown));

		int count = 0;
		while (getAttribute(nextPageButton, "aria-disabled").equals("false")) {
			click(nextPageButton);
			count++;
		}
		log.info("count of pages is:" + count);
		int jobsCountOnLastPage = jobsOnPage.size();
		log.info("count of jobs on last page is:" + jobsCountOnLastPage);
		int totalJobsCount = (100 * count) + jobsCountOnLastPage;
		log.info("Total jobs: " + totalJobsCount);
		return Integer.toString(totalJobsCount);

	}
}
