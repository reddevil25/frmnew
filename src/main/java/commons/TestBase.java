package commons;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import listener.ListenerTest;

@Listeners(ListenerTest.class)
public class TestBase {

	public WebDriver driver;
	public ExcelReader excel;
	public static String fs = FileSystems.getDefault().getSeparator();

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		System.setProperty("configPath", "./env/prod.properties");
		System.setProperty("browserName", "chrome");
		this.driver = createDriver();
		setUpWebDriver(driver);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		if (driver != null) {

			driver.close();
			driver.quit();
		}
	}

	private WebDriver createDriver() {

		String hubUrl = System.getProperty("hubUrl");

		// If the hubUrl is specified use the remote driver, else try to use the local
		// chrome driver.
		if (hubUrl != null) {
			String browserName = System.getProperty("browserName");
			if (browserName == null) {
				throw new RuntimeException("You must specify a browserName");
			}
			try {
				return new RemoteWebDriver(new URL(hubUrl), getOptions(browserName));
			} catch (MalformedURLException e) {
				throw new RuntimeException("The supplied hubUrl: " + hubUrl + " is not a valid url.");
			}
		} else {

			// If we're not using a hub, then attempt to instantiate a local chrome or
			// firefox or IE driver.

			String browserName = System.getProperty("browserName");
			if (browserName == null) {
				throw new RuntimeException("You must specify a browserName");
			}

			
	
			if(browserName.equals("chromeprivate")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver((ChromeOptions) getOptions(browserName));
		}
			
			if (browserName.equals("chromeH")) {
				ChromeOptions options = new ChromeOptions();

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options.setHeadless(true));
			}

			if (browserName.equals("firefoxH")) {
				FirefoxOptions options = new FirefoxOptions();

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(options.setHeadless(true));
			}

			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver((ChromeOptions) getOptions(browserName));
			}

			if (browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver((FirefoxOptions) getOptions(browserName));
			}

			if (browserName.equals("internetexplorer")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver((InternetExplorerOptions) getOptions("internet explorer"));
			}
			return driver;
		}
	}

	private MutableCapabilities getOptions(String browserName) {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browserName);

		if (browserName.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			return options.merge(cap);
		}

		if (browserName.equals("internet explorer")) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			return options.merge(cap);
		}

		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-gpu");
			options.addArguments("--disable-print-preview");
//            options.addArguments("headless");
//            options.addArguments("window-size=1200x600");
			return options.merge(cap);
		}
		if (browserName.equals("chromeprivate")) {
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("disable-gpu");
//			options.addArguments("--disable-print-preview");
            options.addArguments("--incognito");
//            options.addArguments("window-size=1200x600");
			return options.merge(cap);
		}
		
		throw new RuntimeException(browserName + " is an invalid browserName.");
	}

	public String workingDirectory() {
		String configuredWorkingDirectory = System.getProperty("workingDirectory");
		if (configuredWorkingDirectory != null) {
			return configuredWorkingDirectory;
		}
		return System.getProperty("user.dir");
	}

	private static void setUpWebDriver(WebDriver driver) {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Timeouts.PAGE, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(Timeouts.PAGE, TimeUnit.SECONDS);
	}

	@DataProvider(name = "dp")
	public Object[][] getData() {
		excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx");

		return getDataFromExcel(excel,"common");
	}
	
	@DataProvider(name = "dpAsPerMethod")
	public Object[][] getDataAsMethod(Method m) {
		excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx");

		return getDataFromExcel(excel,m.getName());
	}
	public Object[][] getDataFromExcel(ExcelReader excel, String sheetname) {

		String sheet = sheetname;
		int rows = excel.getRowCount(sheet);
		int cols = excel.getColumnCount(sheet);
		Object[][] data = new Object[rows - 1][1];

		for (int rownum = 2; rownum <= rows; rownum++) {
			Hashtable<String, String> table = new Hashtable<String, String>();
			for (int colnum = 0; colnum < cols; colnum++) {
				{table.put(excel.getCellData(sheet, colnum, 1), excel.getCellData(sheet, colnum, rownum));
				data[rownum - 2][0] = table;}
						}
		}
		return data;
	}
	
	
}