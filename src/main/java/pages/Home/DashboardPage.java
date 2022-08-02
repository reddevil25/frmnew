package pages.Home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import commons.BasePage;

public class DashboardPage extends BasePage{
	
	SoftAssert sa = new SoftAssert();
	private static final Logger log = LogManager.getLogger(DashboardPage.class.getName());

	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='pl-2 font_medium font_sm']")
	private WebElement dashboard;
	@FindBy(xpath = "(//div[@class='box_shadow p-3 mt-3'])[1]")
	private WebElement totalJobs;
	@FindBy(xpath = "(//div[@class='box_shadow p-3 mt-3'])[2]")
	private WebElement publishedJobs;
	@FindBy(xpath = "(//div[@class='box_shadow p-3 mt-3'])[3]")
	private WebElement archivedJobs;
	@FindBy(xpath = "(//div[@class='box_shadow p-3 mt-3'])[4]")
	private WebElement draftJobs;
	@FindBy(css = "g > g:nth-child(1)> g:nth-child(2) > path")
	private WebElement qualifiedCandidates;
	@FindBy(xpath = "//ul[@class='recharts-tooltip-item-list']/li[1]/span[3]")
	private WebElement qualifiedCandidatesCount;
	
	//graph elements for candidate graph
	@FindBy(xpath = "(//div[@class=' css-xhupmv-control'])[1]")
	private WebElement candidatesGraphButton;
	@FindBy(xpath = "//div[@class=' css-1hb1tje-option']")
	private List<WebElement> candidatesGraphDrpOptions;
	@FindBy(xpath = "(//div[@class=' css-qc6sy-singleValue'])[1]")
	private WebElement candidatesDrpField;
	@FindBy(xpath = "//*[@class='box_shadow p-3']/div/div[2]/div/*[local-name()='svg']/*[local-name()='g'][2]/*[local-name()='g']/*[local-name()='g']/*[local-name()='text']")
	private List<WebElement> countOfCandidateDays;
	@FindBy(css = "tspan[x='708.3125']")
	private WebElement recentDate;
	@FindBy(css = "body > div:nth-child(2) > section:nth-child(2) > main:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1) > g:nth-child(4) > g:nth-child(2) > g:nth-child(1) > text:nth-child(2) > tspan:nth-child(1)")
	private WebElement oldDate;
	@FindBy(xpath = "//*[@class='box_shadow p-3']/div/div[2]/div/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g']/*[local-name()='line']")
	private List<WebElement> candidateValue;
	
	
	@FindBy(xpath = "(//div[@class=' css-xhupmv-control'])[2]")
	private WebElement jobsDaysGraphButton;
	@FindBy(xpath = "//div[@class=' css-1hb1tje-option']")
	private List<WebElement> jobsDaysGraphDrpOptions;
	@FindBy(xpath = "(//div[@class=' css-qc6sy-singleValue'])[2]")
	private WebElement jobsDaysDrpField;
	@FindBy(xpath = "(//div[@class=' css-xhupmv-control'])[3]")
	private WebElement jobsStatusGraphButton;
	@FindBy(xpath = "//div[@class=' css-1hb1tje-option']")
	private List<WebElement> jobsStatusGraphDrpOptions;
	@FindBy(xpath = "(//div[@class=' css-qc6sy-singleValue'])[3]")
	private WebElement jobsStatusDrpField;
	
	
	
	public void verifyTotalJobs(String expectedCount) {
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		log.info("Expected count of total jobs: " + expectedCount);
		String actualCount = getText(totalJobs);
		log.info("Actual count of total jobs: " + getText(totalJobs));
		Assert.assertTrue(actualCount.contains(expectedCount), "actual count does not match with total jobs on dashboard page");
	}
	
	//Verify the published jobs are visible on the overview page.
	public void verifyPublishedJobs(String expectedCount) {
		log.info("Expected count of published jobs: " + expectedCount);
		String actualCount = getText(publishedJobs);
		log.info("Actual count of published jobs: " + getText(publishedJobs));
		Assert.assertTrue(actualCount.contains(expectedCount), "actual count does not match with published jobs on dashboard page");
	}
	
    public void verifyArchivedJobs(String expectedCount) {
    	log.info("Expected count of archived jobs: " + expectedCount);
		String actualCount = getText(archivedJobs);
		log.info("Actual count of archived jobs: " + getText(archivedJobs));
		Assert.assertTrue(actualCount.contains(expectedCount), "actual count does not match with archived jobs on dashboard page");
	}
    
    public void verifyDraftJobs(String expectedCount) {
    	log.info("Expected count of draft jobs: " + expectedCount);
		String actualCount = getText(draftJobs);
    	log.info("Actual count of draft jobs: " + getText(draftJobs));
    	Assert.assertTrue(actualCount.contains(expectedCount), "actual count does not match with draft jobs on dashboard page");
	}
	
    public void verifyQualifiedCandidatesInPieChart(String expectedCount) {
    	log.info("Hovering on qualified candidates in pie chart...");
    	new Actions(driver).moveToElement(qualifiedCandidates).perform();
    	/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	log.info("Trying to get tooltip text...");
    	log.info("Qualified candidates visible on pie chart: " + getText(qualifiedCandidatesCount));
    	Assert.assertEquals(getText(qualifiedCandidatesCount), expectedCount, "Count on pie chart does not match expected count");
    }
    
    public void verifyNotQualifiedCandidatesInPieChart(String expectedCount) {
    	
    }
    
    public void verifyNotContactedCandidatesInPieChart(String expectedCount) {
    	
    }
    
    public void verifyNewCandidatesInPieChart(String expectedCount) {
    	
    }
    
    public void verifyCandidatesDropdown(String days) {
    	candidatesDropdown(days);
    	Assert.assertTrue(getText(candidatesDrpField).contains(days), "The selected option is not shown in the drp field");
    }
    
    public void verifyJobsDaysDropdown(String days) {
    	jobsDaysDropdown(days);
    	Assert.assertTrue(getText(jobsDaysDrpField).contains(days), "The selected option is not shown in the drp field");
    }
    
    public void verifyJobsStatusDropdown(String days) {
    	jobsStatusDropdown(days);
    	Assert.assertTrue(getText(jobsStatusDrpField).contains(days), "The selected option is not shown in the drp field");
    }
    
    public void candidatesDropdown(String days) {
    	click(candidatesGraphButton);
        for(WebElement e:candidatesGraphDrpOptions) {
       	 if(getText(e).contains(days)) {
       		 click(e);
       		 break;
       	 }
        }
   	log.info("Selected number of days: " + getText(candidatesDrpField));
    }
    
    public void jobsDaysDropdown(String days) {
    	click(jobsDaysGraphButton);
        for(WebElement e:jobsDaysGraphDrpOptions) {
       	 if(getText(e).contains(days)) {
       		 click(e);
       		 break;
       	 }
        }
   	log.info("Selected number of days: " + getText(jobsDaysDrpField));
    }
    
    public void jobsStatusDropdown(String days) {
    	click(jobsStatusGraphButton);
        for(WebElement e:jobsStatusGraphDrpOptions) {
       	 if(getText(e).contains(days)) {
       		 click(e);
       		 break;
       	 }
        }
   	log.info("Selected number of days: " + getText(jobsStatusDrpField));
    }
    
    public void verifyCandidateGraph(String days) {
    	 
    	candidatesDropdown(days);
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	log.info("Count of days: " + countOfCandidateDays.size());
    	sa.assertTrue(countOfCandidateDays.size() <= 5, "No. of days on graph is more than selected days");
    	int actualCountOfDays = countOfCandidateDays.size(); 
    	
    	LocalDate recentDay = LocalDate.now();
    	String d1 = getDate(recentDay);
    	log.info("Expected Recent date is: " + d1);
    	LocalDate oldDay = recentDay.minusDays(Integer.parseInt(days) - 1);
    	String d2 = getDate(oldDay);
    	log.info("Expected Oldest date is: " + d2);
    	//js.scrollIntoView(recentDate);
    	String actualRecentDate = getTextList(countOfCandidateDays).get(actualCountOfDays - 1);
    	log.info("Actual recent date: " + actualRecentDate);
    	String after = actualRecentDate.replace("th", "");
    	log.info("after replace: " + after);
    	try {
			Date date1=new SimpleDateFormat("dd MMM yy").parse(after);
			log.info("date1: " + date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    /*	int c = Integer.parseInt(actualRecentDate);
    	log.info("c: " + c);*/
    	String actualOldDate = getText(oldDate);
    	log.info("Actual old date: " + actualOldDate);
    	
    	//sa.assertAll();
    	
    }
    
    public void verifyCandidateGraphValue(String days, int createdCandidates) {
    	log.info("Selecting days in dropdown...");
    	candidatesDropdown(days);
    	js.scrollIntoView(oldDate);
    	int count = countOfCandidateDays.size();
    	By target = By.xpath("(//*[@class='box_shadow p-3']/div/div[2]/div/*[local-name()='svg']/*"
    			+ "[local-name()='g']/*[local-name()='g']/*[local-name()='line'])["+ count +"]");
    	//js.scrollIntoView(candidateValue);
    	log.info("Hovering on the graph...");
    	new Actions(driver).moveToElement(driver.findElement(target)).pause(Duration.ofSeconds(2)).perform();
    	try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	LocalDate recentDay = LocalDate.now();
    	String d1 = getDate(recentDay);
    	log.info("Expected Recent date is: " + d1);
    	By value = By.xpath("//p[text()='"+d1+"']/following-sibling::ul/li");
    	int val = Integer.parseInt(getText(driver.findElement(value)).replace("value : ", ""));
    	log.info("Value is: " + val);
    	Assert.assertTrue(val >= createdCandidates);
    	log.info("Hence, graph value is verified as per created candidates");
    }
    
    public void verifyDefaultValueInGraph(String days) {
    	log.info("Number of days by deafult: " + getText(candidatesDrpField));
    	Assert.assertTrue(getText(candidatesDrpField).contains(days), "Default days are not 7");
    }
    
    
    public String getDate(LocalDate day) {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
    	//LocalDate today = LocalDate.now();
    	int date =Integer.parseInt(dtf.format(day));
    	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("d'" + getDayNumberSuffix(date) + " 'MMM yy");
    	//log.info("date: " + dtf1.format(day));
    	return dtf1.format(day);
    }
    
    public static String getDayNumberSuffix(int day) {
	    if (day >= 11 && day <= 13) {
	        return "th";
	    }
	    switch (day % 10) {
	    case 1:
	        return "st";
	    case 2:
	        return "nd";
	    case 3:
	        return "rd";
	    default:
	        return "th";
	    }
	   }
	
    
    
}
