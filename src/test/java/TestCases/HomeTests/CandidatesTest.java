package TestCases.HomeTests;

import static commons.Configuration.password;
import static commons.Configuration.url;
import static commons.Configuration.username;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PojoClasses.CreateCandidatePojo;
import PojoClasses.JobPostingPojo;
import commons.TestBase;
import pages.LoginPage;
import pages.Home.CandidatesPage;
import pages.Home.HomePage;
import pages.Home.JobsPage;
import pages.Jobs.CreateNewJobPage;

public class CandidatesTest extends TestBase {

	LoginPage lp;
	JobsPage jp;
	CreateNewJobPage cp;
	JobPostingPojo job;
	HomePage hp;

	CandidatesPage cand;

	@BeforeMethod(alwaysRun = true)
	public void openPage() {
		driver.get(url.asString());
		lp = new LoginPage(driver);
		cand = new CandidatesPage(driver);
		jp = new JobsPage(driver);
		cp = new CreateNewJobPage(driver);
		hp = new HomePage(driver);
		lp.doLogin(username.asString(), password.asString());
		hp.goToCandidates();

	}

	@Test(priority = 1, groups = { "candidates" })
	public void verifySearchTest() {
		CreateCandidatePojo candidate = cand.createCandidate();
		hp.goToCandidates();
		cand.verifySearchField(candidate.getFullname());
	}

	@Test(priority = 2, groups = { "candidates" })
	public void verifyNewCandidatesTabTest() {
		hp.goToJobs();
		jp.clickNewJobButton();
		JobPostingPojo job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		hp.goToCandidates();
		CreateCandidatePojo c1 = cand.createCandidate();
		CreateCandidatePojo c2 = cand.createCandidate();
		CreateCandidatePojo c3 = cand.createCandidateAndAssignJob(job.getJob_title());
		List<String> ids = new ArrayList<String>(Arrays.asList(c1.getCandId(),c2.getCandId(),c3.getCandId())) ;
		cand.verifyNewCandidatesTab(ids);
		for(String id:ids) 
			cand.deleteCandidateById(id);
		hp.goToJobs();
		jp.deleteJob(job.getJob_id(), "published");
	}

	@Test(priority = 3, groups = { "candidates" })
	public void verifyQualifiedTabTest() {
		List<String> ids = new ArrayList<String>(Arrays.asList("62821d7a9e305a07b4fa9025","627a19f53993409986780ea5")) ;
		cand.verifyQualifiedCandidatesTab(ids);
	}

	@Test(priority = 4, groups = { "candidates" })
	public void verifyNotQualifiedTabTest() {
		List<String> ids = new ArrayList<String>(Arrays.asList("627b86cf399340998678103f","627a1acd3993409986780f30")) ;
		cand.verifyNotQualifiedCandidatesTab(ids);
	}

	@Test(priority = 5, groups = { "candidates" })
	public void verifyNotContactedCandidatesTabTest() {
		List<String> ids = new ArrayList<String>(Arrays.asList("627a1a063993409986780ec9","627a19f73993409986780ea9")) ;
		cand.verifyNotContactedCandidatesTab(ids);
	}

	@Test(priority = 6, groups = { "candidates" })
	public void verifyFiltersButtonTest() {
		cand.verifyFiltersButton();
	}

	@Test(priority = 7, groups = { "candidates" })
	public void verifyClearFilterTest() {
		cand.verifyClearFilter();
	}

	@Test(priority = 8, groups = { "candidates" })
	public void verifyIndividualCheckboxTest() {
		cand.verifyIndividualCheckbox();
	}

	@Test(priority = 9, groups = { "candidates" })
	public void verifySelectAllCheckboxTest() {
		cand.verifySelectAllCheckbox();
	}

	@Test(priority = 10, groups = { "candidates" })
	public void verifyAddTagsButtonTest() {
		cand.verifyAddTagsButton();
	}
	
	@Test(priority = 11, groups = { "candidates" })
	public void verifyCountOfCandidatesOnAddTagsTest() {
		cand.verifyCountOfCandidatesOnFilterPopup("add tags", 7);
	}

	@Test(priority = 12, groups = { "candidates" })
	public void verifyAddTagsFieldTest() {
		cand.verifyAddTagsField("manual", "automation", "both");
	}

	@Test(priority = 13, groups = { "candidates" })
	public void verifySaveButtonOnAddTagsTest() {
		cand.verifySaveButtonOnAddTags();
	}

	@Test(priority = 14, groups = { "candidates" })
	public void verifyCloseButtonOnAddTagsTest() {
		cand.verifyCloseButtonOnAddTags();
	}
	
	@Test(priority = 14, groups = { "candidates" })
	public void verifyCancelButtonOnAddTagsTest() {
		cand.verifyCancelButtonOnAddTags();
	}

	@Test(priority = 15, groups = { "candidates" })
	public void verifyAddTagsFunctionalityTest() {
		hp.goToJobs();
		jp.clickNewJobButton();
		JobPostingPojo job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		hp.goToCandidates();
		CreateCandidatePojo c1 = cand.createCandidate();
		CreateCandidatePojo c2 = cand.createCandidate();
		CreateCandidatePojo c3 = cand.createCandidateAndAssignJob(job.getJob_title());
		List<String> ids = new ArrayList<String>(Arrays.asList(c1.getCandId(),c2.getCandId(),c3.getCandId())) ;
		cand.verifyAddTagsFunctionality(ids);
		/*for(String id:ids) 
			cand.deleteCandidateById(id);*/
		hp.goToJobs();
		jp.deleteJob(job.getJob_id(), "published");
	}
	
	@Test(priority = 16, groups = { "candidates" })
	public void verifySendEmailButtonTest() {
		cand.verifySendEmailButton();
	}
	
	@Test(priority = 17, groups = { "candidates" })
	public void verifyCountOfCandidatesOnSendEmailTest() {
		cand.verifyCountOfCandidatesOnFilterPopup("send email", 4);
	}

	@Test(priority = 18, groups = { "candidates" })
	public void verifyMailSubjetFieldTest() {
		cand.verifyMailSubjetField();
	}

	@Test(priority = 19, groups = { "candidates" })
	public void verifyMailBodyFieldTest() {
		cand.verifyMailBodyField();
	}

	@Test(priority = 20, groups = { "candidates" })
	public void verifySendButtonTest() {
		cand.verifySendButton();
	}

	
	@Test(priority = 21, groups = { "candidates" })
	public void verifySendEmailFunctionalityTest() {
		List<String> ids = new ArrayList<String>(Arrays.asList("62960eba4390ffe3b41e734e","629609a14390ffe3b41e734b","6296095e4390ffe3b41e734a")) ;
		cand.verifySendEmailFunctionality(ids);
	}

	@Test(priority = 14, groups = { "candidates" })
	public void verifyCloseButtonOnSendEmailTest() {
		cand.verifyCloseButtonOnSendEmail();
	}
	
	@Test(priority = 14, groups = { "candidates" })
	public void verifyCancelButtonOnSendEmailTest() {
		cand.verifyCancelButtonOnSendEmail();
	}
	

	@Test(priority = 22, groups = { "candidates" })
	public void verifyCountOfCandidatesOnChangeStatusTest() {
		cand.verifyCountOfCandidatesOnFilterPopup("change status", 0);
	}
	

	@Test(priority = 23, groups = { "candidates" })
	public void verifyChangeStatusFunctionalityTest() {
		hp.goToJobs();
		jp.clickNewJobButton();
		JobPostingPojo job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
		hp.goToCandidates();
		CreateCandidatePojo c1 = cand.createCandidateAndAssignJob(job.getJob_title());
		CreateCandidatePojo c2 = cand.createCandidateAndAssignJob(job.getJob_title());
		CreateCandidatePojo c3 = cand.createCandidateAndAssignJob(job.getJob_title());
		List<String> ids = new ArrayList<String>(Arrays.asList(c1.getCandId(),c2.getCandId(),c3.getCandId())) ;
		cand.verifyChangeStatusFunctionality(ids);
	}
	
	@Test(priority = 14, groups = { "candidates" })
	public void verifyCloseButtonOnChangeStatusTest() {
		cand.verifyCloseButtonOnChangeStatus();
	}
	
//repeated
	/*@Test(priority = 14, groups = { "candidates" })
	public void verifyClearFilterUsingFiltersButtonTest() {
		cand.verifyClearFilterUsingFiltersButton();
	}
	
	@Test(priority = 14, groups = { "candidates" })
	public void verifyClearFilterUsingCrossButtonTest() {
		cand.verifyClearFilterUsingCrossButton();
	}*/
	

	@Test(priority = 24, groups = { "candidates" })
	public void verifyAddCandidateButtonTest() {
		CreateCandidatePojo candidate = cand.verifyAddCandidateButton();
	//	cand.deleteCandidateById(candidate.getCandId());

	}

	@Test(priority = 25, groups = { "candidates" })
	public void verifyProfilePicTest() {
		CreateCandidatePojo candidate = cand.verifyProfilePic();
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 26, groups = { "candidates" })
	public void verifyInitialsInsteadOfProfilePicTest() {
		CreateCandidatePojo candidate = cand.verifyInitialsInsteadOfProfilePic();
	//	cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 27, groups = { "candidates" })
	public void verifyDeleteProfilePicTest() {
	//	CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyDeleteProfilePic();
	//	cand.deleteCandidateById(candidate.getCandId());

	}

	@Test(priority = 28, groups = { "candidates" })
	public void verifyFullnameFieldTest() {
		cand.verifyFullnameField();
	}

	@Test(priority = 29, groups = { "candidates" })
	public void verifyTagsFieldTest() {
		cand.verifyTagsField();
	}

	@Test(priority = 30, groups = { "candidates" })
	public void verifyMobileFieldTest() {
		cand.verifyMobileField();
	}

	@Test(priority = 31, groups = { "candidates" })
	public void verifyEmailFieldTest() {
		cand.verifyEmailField();
	}

	@Test(priority = 32, groups = { "candidates" })
	public void verifyLinksFieldTest() {
		cand.verifyLinksField();
	}

	@Test(priority = 33, groups = { "candidates" })
	public void verifySocialFieldTest() {
		cand.verifySocialField();
	}

	@Test(priority = 34, groups = { "candidates" })
	public void verifySKillsFieldTest() {
		cand.verifySkillField();
	}

	@Test(priority = 35, groups = { "candidates" })
	public void verifySourceFieldTest() {
		cand.verifySourceField();
	}

	@Test(priority = 36, groups = { "candidates" })
	public void verifyCountryFieldTest() {
		cand.verifyCountryField("Nepal");
	}

	@Test(priority = 37, groups = { "candidates" })
	public void verifyStateFieldTest() {
		cand.verifyStateField("Pakistan", "Sindh");
	}

	@Test(priority = 38, groups = { "candidates" })
	public void verifyCityTest() {
		cand.verifyCityField("Pakistan");
	}

	@Test(priority = 39, groups = { "candidates" })
	public void verifyPincodeFieldTest() {
		cand.verifyPincodeField("411018");
	}
	
	@Test(priority = 39, groups = { "candidates" })
	public void verifyCurrentCtcFieldTest() {
		cand.verifyCurrentCtcField("14440");
	}

	@Test(priority = 40, groups = { "candidates" })
	public void verifyUploadResumeButton() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyUploadResumeButton();
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 41, groups = { "candidates" })
	public void verifyUserRedirectedToResumeWhenClickedOnResumeTest() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyUserRedirectedToResumeWhenClickedOnResume();
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 42, groups = { "candidates" })
	public void verifyDeleteResumeButton() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyDeleteResumeButton();
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 43, groups = { "candidates" })
	public void verifyDownloadResumeButton() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyDownloadResumeButton();
	//	cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 44, groups = { "candidates" })
	public void verifyPagesOfResume() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyPagesOfResume();
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 45, groups = { "candidates" })
	public void verifyAssignJobSection() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyAssignJobSection(candidate);
	//	cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 46, groups = { "candidates" })
	public void verifyAssignJobButton() {
		JobPostingPojo job1;
		JobPostingPojo job2;
		jp.goToJobs();
		jp.clickNewJobButton();
		job1 = cp.createNewJob("create");
		jp.publishJob(job1.getJob_id());
		jp.clickNewJobButton();
		job2 = cp.createNewJob("create");
		jp.publishJob(job2.getJob_id());
		CreateCandidatePojo candidate = cand.createCandidate();
	//	cand.createCandidate();
		cand.verifyAssignJob(job1.getJob_title(), job2.getJob_title());
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 47, groups = { "candidates" })
	public void verifyAssignNoOptions() {

		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyAssignNoOptions(candidate);
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 48, groups = { "candidates" })
	public void verifyDifferentCandidateCardsForMultipleJobs() {

		JobPostingPojo job1;
		JobPostingPojo job2;
		jp.goToJobs();
		jp.clickNewJobButton();
		job1 = cp.createNewJob("create");
		jp.publishJob(job1.getJob_id());
		jp.clickNewJobButton();
		job2 = cp.createNewJob("create");
		jp.publishJob(job2.getJob_id());
		hp.goToCandidates();
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyDifferentCandidateCardsForMultipleJobs(job1.getJob_title(), job2.getJob_title(), candidate);
	}

	@Test(priority = 49, groups = { "candidates" })
	public void verifyAssignCrossButton() {
		JobPostingPojo job1;
		JobPostingPojo job2;
		JobPostingPojo job3;
		jp.goToJobs();
		jp.clickNewJobButton();
		job1 = cp.createNewJob("create");
		jp.publishJob(job1.getJob_id());
		jp.clickNewJobButton();
		job2 = cp.createNewJob("create");
		jp.publishJob(job2.getJob_id());
		jp.clickNewJobButton();
		job3 = cp.createNewJob("create");
		jp.publishJob(job3.getJob_id());

		hp.goToCandidates();
		cand.createCandidate();
		cand.verifyAssignCrossButton(job1.getJob_title(), job2.getJob_title(), job3.getJob_title());
	}

/*	@Test(priority = 50, groups = { "candidates" })
	public void verifySaveAssignedJob() {
		cand.verifySavedAssignedJob();
	}*/

	@Test(priority = 51, groups = { "candidates" })
	public void verifyOtherTabs() {
		String candId = cand.verifyOtherTabs();
		//cand.deleteCandidateById(candId);
	}

	@Test(priority = 52, groups = { "candidates" })
	public void verifyDocsTab() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyDocsTab();
	//	cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 53, groups = { "candidates" })
	public void verifyDocsUploadFiles() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyDocsUploadButton();
	//	cand.deleteCandidateById(candidate.getCandId());

	}

	@Test(priority = 54, groups = { "candidates" })
	public void verifyDocsDeleteFiles() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyDocsDeleteFiles(candidate);
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 55, groups = { "candidates" })
	public void verifyDocsDownloadFiles() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyDocsDownloadFiles(candidate);
		// cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 56, groups = { "candidates" })
	public void verifyNotesTab() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyNotesTab();
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 57, groups = { "candidates" })
	public void verifyAddNoteButtonAndNoteTitleAndDescriptionField() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyAddNoteButtonAndNoteTitleAndDescriptionField();
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 58, groups = { "candidates" })
	public void verifyNotesTime() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyNotesTime();
	//	cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 59, groups = { "candidates" })
	public void verifyNoteBook() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyNoteBook();
	//	cand.deleteCandidateById(candidate.getCandId());
	}


	@Test(priority = 60, groups = { "candidates" })
	public void verifyEditNote() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyEditNote();
	//	cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 61, groups = { "candidates" })
	public void verifyDeleteNote() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyDeleteNote();
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 62, groups = { "candidates" })
	public void verifyEmailTab() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyEmailTab();
	//	cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 63, groups = { "candidates" })
	public void verifyComposeButton() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyComposeButton();
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 64, groups = { "candidates" })
	public void verifyEmailTo() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyEmailTo();
	//	cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 65, groups = { "candidates" })
	public void verifyEmailBodyField() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyEmailBody();
		//cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 66, groups = { "candidates" })
	public void verifyEmailAttachFile() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyEmailAttachFile();
		cand.deleteCandidateById(candidate.getCandId());
	}

	@Test(priority = 67, groups = { "candidates" })
	public void verifyEmailCancelButton() {
		CreateCandidatePojo candidate = cand.createCandidate();
		cand.verifyEmailCancelButton();
	//	cand.deleteCandidateById(candidate.getCandId());
	}

//
	@Test(priority = 68, groups = { "candidates" })
	public void verifyCandidateDetails() {

		CreateCandidatePojo candidate = cand.createCandidateAndAssignJob("JOB_oqmqpldpl_SeleniumTest");
		cand.verifyCandidatesDetalis(candidate);

	}
	
	
//	doubt(from excel) - 37 42 43 44 46-49 63 64 69-72 75-77 90 97 101-102 104 108 docsupload doubt
	
	//failed tests doubts- 2-5,15,21,23,25,55,68,69
	
	
	@Test(priority = 69, groups = { "candidates" })
	public void verifyEditCandidateFunctionalityTest() {

		cand.verifyEditCandidateFunctionality();

	}
	
	@Test(priority = 70, groups = { "candidates" })
	public void verifyPaginationTest() {

		cand.verifyPagination(10, "new");

	}
	
	@Test(priority = 71, groups = { "candidates" })
	public void verifyRejectCandidateFunctionalityTest() {
		hp.goToJobs();
		jp.clickNewJobButton();
		JobPostingPojo job = cp.createNewJob("create");
		jp.publishJob(job.getJob_id());
        CreateCandidatePojo candidate = cand.createCandidateAndAssignJob(job.getJob_title());
      //  hp.goToCandidates();
		cand.verifyRejectCandidateFunctionality(candidate.getCandId(), job.getJob_id(),"Applied","Rejected",candidate.getFullname());

	}
	

//	@Test(priority = 1, groups = { "candidates" })
//	public void verifySelectCheckboxTest()  {
//		cand.verifySelectCheckbox();
//	}

//	@Test(priority = 1, groups = { "candidates","trial" })
//	public void verifyAddTagsCancelButtonTest()  {
//		cand.verifyAddTagsCancelButton();
//	}
//	
	/*@Test(priority = 1, groups = { "candidates", "abcd" })
	public void addCandiate() {
//		jp.clickNewJobButton();
//		job = cp.createNewJob("create");
//		jp.publishJob(job.getJob_title());
//		cand.goToCandidates();
//		cand.addCandidateManually(job);
//		jp.deleteJob(job.getJob_title(), "published");
	}*/

	@Test
	public void verifyDeleteCandidateTest() {
		jp.clickNewJobButton();
		job = cp.createNewJob("create");
		jp.publishJob(job.getJob_title());
		hp.goToCandidates();
		cand.verifyDeleteCandidate(job);
		jp.deleteJob(job.getJob_title(), "published");
	}

	@Test
	public void trial() {
		hp.goToCandidates();
		Map<String, String> asset = new HashMap<>();
		String pic = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "profilePic.jpg";
		String resume = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "sample.pdf";
		String doc = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "sample2.pdf";
		asset.put("profilepic", pic);
		asset.put("resume", resume);
		asset.put("doc", doc);
		asset.put("notetitle", "Test Note Title");
		asset.put("notedesc", "Test Note Desc");

		System.out.println(asset);
		CreateCandidatePojo c = cand.createFullCandidate(asset);

		Map<String, String> asset1 = new HashMap<>();
		String pic1 = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "profilePic2.png";
		String resume1 = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "sampleResume.pdf";
		String doc1 = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs + "sample3.pdf";
		asset1.put("profilepic", pic1);
		asset1.put("resume", resume1);
		asset1.put("doc", doc1);
		asset1.put("notetitle", "Test Note Title Edited");
		asset1.put("notedesc", "Test Note Desc Edited");

		hp.goToCandidates();

		CreateCandidatePojo edited = cand.editFullCandidate(asset1, c);

	}

}
