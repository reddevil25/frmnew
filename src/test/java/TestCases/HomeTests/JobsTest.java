package TestCases.HomeTests;

import static commons.Configuration.password;
import static commons.Configuration.url;
import static commons.Configuration.username;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PojoClasses.CreateCandidatePojo;
import PojoClasses.JobPostingPojo;
import commons.TestBase;
import pages.LoginPage;
import pages.Home.CandidatesPage;
import pages.Home.DashboardPage;
import pages.Home.JobsPage;
import pages.Jobs.CreateNewJobPage;

public class JobsTest extends TestBase {

	LoginPage lp;
	JobsPage jp;
	CreateNewJobPage cp;
	JobPostingPojo job;
	CandidatesPage CandPage;
	DashboardPage dp;

	@BeforeMethod(alwaysRun = true)
	public void openPage() {

		driver.get(url.asString());
		lp = new LoginPage(driver);
		jp = new JobsPage(driver);
		cp = new CreateNewJobPage(driver);
		dp = new DashboardPage(driver);
		CandPage = new CandidatesPage(driver);
		lp.doLogin(username.asString(), password.asString());
    	jp.goToJobs();

	}

//	@AfterMethod
	public void clearEnvironment() {

		try {
			jp.deleteJob(job.getJob_id(), "draft");
		} catch (Exception e) {
		}
		try {
			jp.deleteJob(job.getJob_id(), "published");
		} catch (Exception e) {
		}
		try {
			jp.deleteJob(job.getJob_id(), "archived");
		} catch (Exception e) {
		}
	}

	@Test(priority = 1, groups = { "home", "jobs", "jobshome" })
	public void verifyClickNewJobButtonTest() {
		jp.verifyClickNewJobButton();
	}
	
	@Test(priority = 1, groups = { "home", "jobs", "jobshome" })
	public void verifyverifySearchFieldAsPerTitleTest() {
		jp.verifySearchFieldAsPerTitle("JOB_iitccmdjz_SeleniumTest", "published");
	}
	
	@Test(priority = 1, groups = { "home", "jobs", "jobshome" })
	public void verifyverifySearchFieldAsPerDeptTest() {
		jp.verifySearchFieldAsPerDepartment("Business", "published");
	}

	@Test(priority = 2, groups = { "home", "jobs", "jobshome" })
	public void verifySearchAsperTitleTestDraftPage() {
		List<String> jobs1 = cp.createJobsInBulk(3, "title", "TitleTest");
		List<String> jobs2 = cp.createJobsInBulk(2, "title", "Empty");
		
		jp.goToJobs();
		jp.verifySearchFieldAsPerTitle("TitleTest", "draft"); // keyword is case sensitive
	
		for(String job : jobs1)
			jp.deleteJob(job, "draft");
		for(String job : jobs2)
			jp.deleteJob(job, "draft");
	}

	@Test(priority = 3, groups = { "home", "jobs", "jobshome" })
	public void verifySearchAsperTitleTestArchivedPage() {
		List<String> jobs1 = cp.createJobsInBulk(3, "title", "TestingSearchAsPerTitle");
		List<String> jobs2 = cp.createJobsInBulk(2, "title", "eqrioeir");

		for(String job : jobs1)
			jp.archiveJob(job, "draft");
		for(String job : jobs2)
			jp.archiveJob(job, "draft");
		jp.goToJobs();
		jp.verifySearchFieldAsPerTitle("TestingSearchAsPerTitle", "archived"); // keyword is case sensitive
		for(String job : jobs1)
			jp.deleteJob(job, "archived");
		for(String job : jobs2)
			jp.deleteJob(job, "archived");
			
	}

	@Test(priority = 4, groups = { "home", "jobs", "jobshome" })
	public void verifySearchAsperTitleTestPublishedPage() {
		List<String> jobs1 = cp.createJobsInBulk(2, "title", "sdgadgadg");
		List<String> jobs2 = cp.createJobsInBulk(2, "title", "eqrioeir");

		jp.publishJobinBulk(jobs1);
		jp.publishJobinBulk(jobs2);
		
		jp.goToJobs();
		jp.verifySearchFieldAsPerTitle("sdgadgadg", "published"); // keyword is case sensitive
		for(String job : jobs1)
			jp.deleteJob(job, "published");
		for(String job : jobs2)
			jp.deleteJob(job, "published");
	}

	@Test(priority = 5, groups = { "home", "jobs", "jobshome" })
	public void verifySearchAsperDepartmentTestDraftPage() {
		List<String> jobs = cp.createJobsInBulk(2, "department", "Products");
		List<String> jobs2 = cp.createJobsInBulk(2, "department", "Services");

		jp.goToJobs();
		jp.verifySearchFieldAsPerDepartment("Products", "draft"); // keyword is case sensitive
		
		for(String job : jobs)
			jp.deleteJob(job, "draft");
		for(String job : jobs2)
			jp.deleteJob(job, "draft");

	
	}
	
	@Test(priority = 6, groups = { "home", "jobs", "jobshome" })
	public void verifySearchAsperDepartmentTestArchivedPage() {
		List<String> jobs1 = cp.createJobsInBulk(2, "department", "Products");
		List<String> jobs2 = cp.createJobsInBulk(2, "department", "Services");

		for(String job : jobs1)
			jp.archiveJob(job, "draft");
		for(String job : jobs2)
			jp.archiveJob(job, "draft");
		
		jp.goToJobs();
		jp.verifySearchFieldAsPerDepartment("Products", "archived"); // keyword is case sensitive
		
		for(String job : jobs1)
			jp.deleteJob(job, "archived");
		for(String job : jobs2)
			jp.deleteJob(job, "archived");
	}
	
	@Test(priority = 7, groups = { "home", "jobs", "jobshome" })
	public void verifySearchAsperDepartmentTestPublishedPage() {
		List<String> jobs1 = cp.createJobsInBulk(2, "department", "Products");
		List<String> jobs2 = cp.createJobsInBulk(2, "department", "Services");

		for(String job : jobs1)
			jp.publishJob(job);
		for(String job : jobs2)
			jp.publishJob(job);
		
		jp.goToJobs();
		jp.verifySearchFieldAsPerDepartment("Products", "published"); // keyword is case sensitive
		
		for(String job : jobs1)
			jp.deleteJob(job, "published");
		for(String job : jobs2)
			jp.deleteJob(job, "published");
	}


//	@Test(priority = 2, groups = { "home", "jobs", "jobshome" })
//	public void verifySearchAsperDepartmentTest() {
////		jp.verifySearchAsperTitle("department","support");
//	}

	@Test(priority = 8, groups = { "home", "jobs", "jobshome" })
	public void verifyCardViewOnDraftPageTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.goToJobs();
		jp.verfiyCardView(job, "draft");
		jp.deleteJob(job.getJob_id(), "draft");

	}

	@Test(priority = 9, groups = { "home", "jobs", "jobshome" })
	public void verifyCardViewOnPublishedPageTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.goToJobs();
		jp.publishJob(job.getJob_id());
		jp.verfiyCardView(job, "published");
		jp.deleteJob(job.getJob_id(), "published");
	}

	@Test(priority = 10, groups = { "home", "jobs", "jobshome" })
	public void verifyCardViewOnArchivedPageTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.goToJobs();
		jp.archiveJob(job.getJob_id(), "draft");
		jp.verfiyCardView(job, "archived");
		jp.deleteJob(job.getJob_id(), "archived");
	}

	@Test(priority = 11, groups = { "home", "jobs", "jobshome" })
	public void verifyTableViewButtonOnDraftPageTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.goToJobs();
		jp.verifyTableViewButton(job, "draft");
		jp.deleteJob(job.getJob_id(), "draft");
	}

	@Test(priority = 12, groups = { "home", "jobs", "jobshome" })
	public void verifyTableViewButtonOnPublishedPageTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.goToJobs();
		jp.publishJob(job.getJob_id());
		jp.verifyTableViewButton(job, "published");
		jp.deleteJob(job.getJob_id(), "published");
	}

	@Test(priority = 13, groups = { "home", "jobs", "jobshome" })
	public void verifyTableViewButtonOnArchivedPageTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.goToJobs();
		jp.archiveJob(job.getJob_id(), "draft");
		jp.verifyTableViewButton(job, "archived");
		jp.deleteJob(job.getJob_id(), "archived");

	}

	@Test(priority = 14, groups = { "home", "jobs", "jobshome" })
	public void verifyPublishButtonOnDraftJobsPageCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.verifyPublishJob("draft","card",job);
		jp.deleteJob(job.getJob_id(), "published");
	}

	@Test(priority = 15, groups = { "home", "jobs", "jobshome" })
	public void verifyPublishButtonOnDraftJobsPageTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.verifyPublishJob("draft","table",job);
		jp.deleteJob(job.getJob_id(), "published");
	}

	@Test(priority = 16, groups = { "home", "jobs", "jobshome" })
	public void verifyDraftButtonOnPublishedJobsPageCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		jp.verifyDraftJob("published","card",job);
		jp.deleteJob(job.getJob_id(), "draft");
	}

	@Test(priority = 17, groups = { "home", "jobs", "jobshome" })
	public void verifyDraftButtonOnPublishedJobsPageTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		jp.verifyDraftJob("published","table",job);
		jp.deleteJob(job.getJob_id(), "draft");
	}

	@Test(priority = 18, groups = { "home", "jobs", "jobshome" })
	public void verifyDraftButtonOnArchivedJobsPageCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.archiveJob(job.getJob_id(),"draft");
		jp.verifyDraftJob("archived","card",job);
		jp.deleteJob(job.getJob_id(), "draft");
	}
	
	

	@Test(priority = 19, groups = { "home", "jobs", "jobshome" })
	public void verifyDraftButtonOnArchivedJobsPageTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.archiveJob(job.getJob_id(),"draft");
		jp.verifyDraftJob("archived","table",job);
		jp.deleteJob(job.getJob_id(), "draft");
	}

	@Test(priority = 20, groups = { "home", "jobs", "jobshome" })
	public void verifyEditJobButtonOnDraftJobPagesCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		String jobId = jp.verifyEditJob("draft", "card", job);
		jp.deleteJob(jobId, "draft");
	}

	@Test(priority = 21, groups = { "home", "jobs", "jobshome" })
	public void verifyEditJobButtonOnDraftJobPagesTableView() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		String jobId = jp.verifyEditJob("draft", "table", job);
		jp.deleteJob(jobId, "draft");
	}

	@Test(priority = 22, groups = { "home", "jobs", "jobshome" })
	public void verifyEditJobButtonOnPublishedJobPagesCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		String jobId = jp.verifyEditJob("published", "card", job);
		jp.deleteJob(jobId, "published");

	}

	@Test(priority = 23, groups = { "home", "jobs", "jobshome" })
	public void verifyEditJobButtonOnPublishedJobPagesTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		String jobId = jp.verifyEditJob("published", "table", job);
		jp.deleteJob(jobId, "published");

	}

	@Test(priority = 24, groups = { "home", "jobs", "jobshome" })
	public void verifyEditJobButtonOnArchivedJobPagesCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.archiveJob(job.getJob_id(),"draft");
		String title = jp.verifyEditJob("archived","card",job);
		jp.deleteJob(title, "archived");

	}

	@Test(priority = 25, groups = { "home", "jobs", "jobshome" })
	public void verifyEditJobButtonOnArchivedJobPagesTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.archiveJob(job.getJob_id(),"draft");
		String title = jp.verifyEditJob("archived","table",job);
		jp.deleteJob(title, "archived");

	}

	@Test(priority = 26, groups = { "home", "jobs", "jobshome" })
	public void verifyDuplicateButtonOnDraftjobsCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.verifyDuplicateJob("Draft","card",job);
		jp.deleteJobByTitle(job.getJob_title() + " [Copy]", "draft");
		jp.deleteJob(job.getJob_id(), "draft");
	}

	@Test(priority = 27, groups = { "home", "jobs", "jobshome" })
	public void verifyDuplicateButtonOnDraftjobsTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.verifyDuplicateJob("Draft","table",job);
		jp.deleteJobByTitle(job.getJob_title() + " [Copy]", "draft");
		jp.deleteJob(job.getJob_id(), "draft");
	}

	@Test(priority = 28, groups = { "home", "jobs", "jobshome" })
	public void verifyDuplicateButtonOnPublishedjobsCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		jp.verifyDuplicateJob("published","card",job);
		jp.deleteJobByTitle(job.getJob_title() + " [Copy]", "published");
		jp.deleteJob(job.getJob_id(), "published");
		}

	@Test(priority = 29, groups = { "home", "jobs", "jobshome" })
	public void verifyDuplicateButtonOnPublishedjobsTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		jp.verifyDuplicateJob("published","table",job);
		jp.deleteJobByTitle(job.getJob_title() + " [Copy]", "published");
		jp.deleteJob(job.getJob_id(), "published");
		}

	@Test(priority = 30, groups = { "home", "jobs", "jobshome" })
	public void verifyDuplicateButtonOnArchivedjobsCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.archiveJob(job.getJob_id(),"draft");
		jp.verifyDuplicateJob("archived","card",job);
		jp.deleteJobByTitle(job.getJob_title() + " [Copy]", "archived");
		jp.deleteJob(job.getJob_id(), "archived");
		}

	@Test(priority = 31, groups = { "home", "jobs", "jobshome" })
	public void verifyDuplicateButtonOnArchivedjobsTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.archiveJob(job.getJob_id(),"draft");
		jp.verifyDuplicateJob("archived","table",job);
		jp.deleteJobByTitle(job.getJob_title() + " [Copy]", "archived");
		jp.deleteJob(job.getJob_id(), "archived");
		}

	@Test(priority = 32, groups = { "home", "jobs", "jobshome" })
	public void verifyArchiveButtonOnDraftjobsCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.verifyArchiveJob("draft","card",job);
		jp.deleteJob(job.getJob_id(), "archived");
	}

	@Test(priority = 33, groups = { "home", "jobs", "jobshome" })
	public void verifyArchiveButtonOnDraftjobsTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.verifyArchiveJob("draft","table",job);
		jp.deleteJob(job.getJob_id(), "archived");
	}

	@Test(priority = 34, groups = { "home", "jobs", "jobshome" })
	public void verifyArchiveButtonOnPublishedjobsCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		jp.verifyArchiveJob("published","card",job);
		jp.deleteJob(job.getJob_id(), "archived");
	}

	@Test(priority = 35, groups = { "home", "jobs", "jobshome" })
	public void verifyArchiveButtonOnPublishedjobsTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		jp.verifyArchiveJob("published","table",job);
		jp.deleteJob(job.getJob_id(), "archived");
	}

	@Test(priority = 36, groups = { "home", "jobs", "jobshome" })
	public void verifyJobCountDropdownOnPublishedPageTest() {
		jp.verifyJobCountDropdown("published", "card", 25);
		jp.verifyJobCountDropdown("published", "table", 50);

	}

	@Test(priority = 37, groups = { "home", "jobs", "jobshome" })
	public void verifyJobCountDropdownOnArchivedPageTest() {
		jp.verifyJobCountDropdown("archived", "card", 10);
		jp.verifyJobCountDropdown("archived", "table", 100);

	}

	@Test(priority = 38, groups = { "home", "jobs", "jobshome" })
	public void verifyJobCountDropdownOnDraftPageTest() {
		jp.verifyJobCountDropdown("draft", "card", 100);
		jp.verifyJobCountDropdown("draft", "table", 25);

	}

	@Test(priority = 39, groups = { "home", "jobs", "jobshome" })
	public void verifyDeleteButtonOnDraftjobsCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.verifyDeleteJob("draft","card",job);
	}

	@Test(priority = 40, groups = { "home", "jobs", "jobshome" })
	public void verifyDeleteButtonOnDraftjobsTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.verifyDeleteJob("draft","table",job);
	}

	@Test(priority = 41, groups = { "home", "jobs", "jobshome" })
	public void verifyDeleteButtonOnPublishedjobsCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		jp.verifyDeleteJob("published","card",job);
	}

	@Test(priority = 42, groups = { "home", "jobs", "jobshome" })
	public void verifyDeleteButtonOnPublishedjobsTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		jp.verifyDeleteJob("published","table",job);
	}

	@Test(priority = 43, groups = { "home", "jobs", "jobshome" })
	public void verifyDeleteButtonOnArchivedjobsCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.archiveJob(job.getJob_id(),"draft");
		jp.verifyDeleteJob("archived","card",job);
		}

	@Test(priority = 44, groups = { "home", "jobs", "jobshome" })
	public void verifyDeleteButtonOnArchivedjobsTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.archiveJob(job.getJob_id(),"draft");
		jp.verifyDeleteJob("archived","table",job);
		}

	@Test(priority = 45, groups = { "home", "jobs", "jobshome" })
	public void verifyPipelineButtonOnPublishedJobsCardViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		CreateCandidatePojo cand1 = CandPage.createCandidateAndAssignJob(job.getJob_title());
		CreateCandidatePojo cand2 = CandPage.createCandidateAndAssignJob(job.getJob_title());
		jp.goToJobs();
		jp.verifyPipelineButtonOnPublishedJobsCardView(job.getJob_title(),
				Arrays.asList(cand1.getFullname(), cand2.getFullname()));
		jp.deleteJob(job.getJob_title(), "published");
		CandPage.deleteCandidate(cand1.getFullname());
		CandPage.deleteCandidate(cand2.getFullname());
	}

	@Test(priority = 46, groups = { "home", "jobs", "jobshome" })
	public void verifyPipelineButtonOnPublishedJobsTableViewTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_title());
		CreateCandidatePojo cand1 = CandPage.createCandidateAndAssignJob(job.getJob_title());
		CreateCandidatePojo cand2 = CandPage.createCandidateAndAssignJob(job.getJob_title());
		jp.goToJobs();
		jp.verifyPipelineButtonOnPublishedJobsTableView(job.getJob_title(),
				Arrays.asList(cand1.getFullname(), cand2.getFullname()));
		jp.deleteJob(job.getJob_title(), "published");
//		CandPage.deleteCandidate(cand1.getFullname());
//		CandPage.deleteCandidate(cand2.getFullname());
	}

	
	@Test(priority = 47, groups = { "home", "jobs", "jobshome" })
	public void verifyPaginationOnArchivedJobsTest() {
//		jp.goToJobs();
		jp.verifyPagination(25, "archived");
	}

	@Test(priority = 48, groups = { "home", "jobs", "jobshome" })
	public void verifyPaginationOnDraftJobsTest() {
//		jp.goToJobs();
		jp.verifyPagination(100, "draft");
	}

	@Test(priority = 49, groups = { "home", "jobs", "jobshome" })
	public void verifyPaginationOnPublishedJobsTest() {
//		jp.goToJobs();
		jp.verifyPagination(10, "published");
	}
	

}
