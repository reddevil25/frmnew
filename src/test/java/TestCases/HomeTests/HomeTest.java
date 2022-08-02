package TestCases.HomeTests;

import static commons.Configuration.password;
import static commons.Configuration.url;
import static commons.Configuration.username;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.TestBase;
import pages.LoginPage;
import pages.Home.HomePage;

public class HomeTest extends TestBase {

	LoginPage lp;
	HomePage hp;

	@BeforeMethod(alwaysRun = true)
	public void openPage() {
		driver.get(url.asString());
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.doLogin(username.asString(), password.asString());
	}

	@Test(priority = 1, groups = { "home" })
	public void verifyJobsButtonTest() {
		hp.verifyJobsButton();
	}

	@Test(priority = 2, groups = { "home" })
	public void verifyCandidatesButtonTest() {
		hp.verifyCandidatesButton();
	}
	
	@Test(priority = 3, groups = { "home" })
	public void verifySettingsButtonTest() {
		hp.verifySettingsButton();
	}
}
