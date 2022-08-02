package TestCases.HomeTests;

import static commons.Configuration.password;
import static commons.Configuration.url;
import static commons.Configuration.username;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import PojoClasses.JobPostingPojo;
import commons.TestBase;
import pages.LoginPage;
import pages.Home.CandidatesPage;
import pages.Home.DashboardPage;
import pages.Home.HomePage;
import pages.Home.JobsPage;
import pages.Jobs.CreateNewJobPage;

public class DashboardTest extends TestBase {
	LoginPage lp;
	JobsPage jp;
	CreateNewJobPage cp;
	JobPostingPojo job;
	DashboardPage dp;
	CandidatesPage cand;
	HomePage hp;

	@BeforeMethod(alwaysRun = true)
	public void openPage() {
		driver.get(url.asString());
		lp = new LoginPage(driver);
		cand = new CandidatesPage(driver);
		jp = new JobsPage(driver);
		cp = new CreateNewJobPage(driver);
		dp = new DashboardPage(driver);
		hp = new HomePage(driver);
		lp.doLogin(username.asString(), password.asString());
		
        
	
	}

	@Test(priority = 1, groups = { "dashboard" })
	public void verifyPublishedJobsOnOverviewTest() {
		jp.goToJobs();
	   String count = jp.getJobCount("published");
	   hp.goToDashboard();
	   dp.verifyPublishedJobs(count);
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyArchivedJobsOnOverviewTest() {
		jp.goToJobs();
	   String count = jp.getJobCount("archived");
	   hp.goToDashboard();
	   dp.verifyArchivedJobs(count);
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyDraftJobsOnOverviewTest() {
		jp.goToJobs();
	   String count = jp.getJobCount("draft");
	   hp.goToDashboard();
	   dp.verifyDraftJobs(count);
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyTotalJobsOnOverviewTest() {
		jp.goToJobs();
	//	int count1 =  jp.totalJobCount("draft");
	//	int count2 =  jp.totalJobCount("published");
	//	int count3 =   jp.totalJobCount("archived");
	 //  int count = count1 + count2 + count3;
	 //  String count4 = Integer.toString(count);
	   hp.goToDashboard();
	//   dp.verifyTotalJobs(count4);
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyQualifiedCandidatesInPieChartTest() {
		hp.goToCandidates();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	String count = cand.getCandidateCount("Qualified");
	   hp.goToDashboard();
	  dp.verifyQualifiedCandidatesInPieChart(count);
	   
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyNotQualifiedCandidatesInPieChartTest() {
		
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyNotContactedCandidatesInPieChartTest() {
		
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyNewCandidatesInPieChartTest() {
		
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyCandidatesDropdownTest() {
		hp.goToDashboard();
		dp.verifyCandidatesDropdown("3");
		
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyJobsDaysDropdownTest() {
		hp.goToDashboard();
		dp.verifyJobsDaysDropdown("3");
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyJobsStatusDropdownTest() {
		hp.goToDashboard();
		dp.verifyJobsStatusDropdown("Draft");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyCandidateGraphTest() {
		hp.goToDashboard();
		dp.verifyCandidateGraph("5");
		
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyCandidateValueTest() {
		//cand.createCandidate();
		//cand.createCandidate();
		hp.goToDashboard();
		dp.verifyCandidateGraphValue("5", 2);
		
	}
	
	@Test(priority = 1, groups = { "dashboard" })
	public void verifyDefaultCandidateValueInGraphTest() {
		hp.goToDashboard();
		dp.verifyDefaultValueInGraph("7");
		
	}
	
	@Test
	public void test() {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
	LocalDate recentDay = LocalDate.now();
	LocalDate oldDay = recentDay.minusDays(7);
	System.out.println(dp.getDate(recentDay));
	System.out.println(dp.getDate(oldDay));
	String d1 = dp.getDate(recentDay);
	String d2 = dp.getDate(oldDay);
	System.out.println(d1.compareTo(d2));
	
	
	}
}
