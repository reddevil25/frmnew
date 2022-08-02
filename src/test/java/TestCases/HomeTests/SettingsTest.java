package TestCases.HomeTests;

import static commons.Configuration.password;
import static commons.Configuration.url;
import static commons.Configuration.username;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PojoClasses.JobPostingPojo;
import commons.TestBase;
import pages.LoginPage;
import pages.Home.CandidatesPage;
import pages.Home.HomePage;
import pages.Home.JobsPage;
import pages.Home.SettingsPage;
import pages.Jobs.CreateNewJobPage;

public class SettingsTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	SettingsPage sp;

	@BeforeMethod(alwaysRun = true)
	public void openPage() {
		driver.get(url.asString());
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		sp = new SettingsPage(driver);
		lp.doLogin(username.asString(), password.asString());
		hp.goToSettings();

	}

	@Test(priority = 1, groups = { "settings" })
	public void verifyMyAccountTabTest() {
		sp.verifyMyAccountTab();
	}

	@Test(priority = 2, groups = { "settings" })
	public void verifyProfileTabTest() {
		sp.verifyProfileTab();
	}
	
	@Test(priority = 3, groups = { "settings" })
	public void verifyEditProfileButtonTest() {
		sp.verifyEditProfileButton();
	}
	
	@Test(priority = 4, groups = { "settings" })
	public void verifyProfilePhotoFieldOnEditProfileTest() {
		sp.verifyProfilePhotoFieldOnEditProfile();
	}
	
	@Test(priority = 5, groups = { "settings" })
	public void verifyFirstNameFieldOnEditProfileTest() {
		sp.verifyFirstNameFieldOnEditProfile();
	}
	
	@Test(priority = 6, groups = { "settings" })
	public void verifyLastNameFieldOnEditProfileTest() {
		sp.verifyLastNameFieldOnEditProfile();
	}
	
	
	@Test(priority = 7, groups = { "settings" })
	public void verifyEmailFieldOnEditProfileTest() {
		sp.verifyEmailFieldOnEditProfile();
	}
	
	@Test(priority = 8, groups = { "settings" })
	public void verifyContactNumberFieldOnEditProfileTest() {
		sp.verifyContactNumberFieldOnEditProfile();
	}
	
	@Test(priority = 8, groups = { "settings" })
	public void verifySkillsOnEditProfileTest() {
		sp.verifySkillsOnEditProfile();
	}
	
	@Test(priority = 8, groups = { "settings" })
	public void verifySaveButtonOnEditProfileTest() {
		sp.verifySaveButtonOnEditProfile();
	}
	
	@Test(priority = 9, groups = { "settings" })
	public void verifyEmailSignatureBoxTest() {
		sp.verifyEmailSignatureBox();
	}
	
	@Test(priority = 10, groups = { "settings" })
	public void verifyEmailSignatureBoxEditAndSaveTest() {
		sp.verifyEmailSignatureBoxEditAndSave();
	}
	
	@Test(priority = 11, groups = { "settings" })
	public void verifyCompanyTabTest() {
		sp.verifyCompanyTab();
	}
	
	@Test(priority = 12, groups = { "settings" })
	public void verifyCompanySettingsTabTest() {
		sp.verifyCompanySettingsTab();
	}

	@Test(priority = 13, groups = { "settings" })
	public void verifycompanyAddButtonTest() {
		sp.verifyCompanyAddButton();
	}
	
	@Test(priority = 14, groups = { "settings" })
	public void verifyCompanyNameFieldTest() {
		sp.verifyCompanyNameField();
	}
	
	@Test(priority = 15, groups = { "settings" })
	public void verifyCompanyDescriptionFieldTest() {
		sp.verifyCompanyDescriptionField();
	}
	
	@Test(priority = 16, groups = { "settings" })
	public void verifyCompanyPhoneNumberFieldTest() {
		sp.verifyCompanyPhoneNumberField();
	}
	
	@Test(priority = 17, groups = { "settings" })
	public void verifyCompanyCityFieldTest() {
		sp.verifyCompanyCityField();
	}
	
	@Test(priority = 18, groups = { "settings" })
	public void verifyCompanyZipCodeFieldTest() {
		sp.verifyCompanyZipCodeField();
	}
	
	@Test(priority = 19, groups = { "settings" })
	public void verifyCompanyCountryDropdownTest() {
		sp.verifyCompanyCountryDropdown();
	}
	
	@Test(priority = 20, groups = { "settings" })
	public void verifyCompanyStateDropdownTest() {
		sp.verifyCompanyStateDropdown();
	}

	@Test(priority = 21, groups = { "settings" })
	public void verifyCompanyDomainTest() {
		sp.verifyCompanyDomainField();
	}	
	
	@Test(priority = 22, groups = { "settings" })
	public void verifyEditCompanyDetailsTest() {
		sp.verifyEditCompanyDetails();
	}	
	
	@Test(priority = 22, groups = { "settings" })
	public void verifyAddCompanyPopupCancelButtonTest() {
		sp.verifyAddCompanyPopupCancelButton();
	}	
	
	@Test(priority = 23, groups = { "settings" })
	public void verifyTeamMembersTabTest() {
		sp.verifyTeamMembersTab();
	}
	
	@Test(priority = 24, groups = { "settings" })
	public void verifyCreateTabTest() {
		sp.verifyCreateTab();
	}	
	
	@Test(priority = 25, groups = { "settings" })
	public void verifyFirstNameTest() {
		sp.verifyFirstName();
	}	
	
	@Test(priority = 26, groups = { "settings" })
	public void verifyLastNameTest() {
		sp.verifyLastName();
	}	
	
	@Test(priority = 27, groups = { "settings" })
	public void verifyCreateEmailTest() {
		sp.verifyCreateEmail();
	}	

	@Test(priority = 28, groups = { "settings" })
	public void verifyCreatePhoneNumberTest() {
		sp.verifyCreatePhoneNumber();
	}	
	
	@Test(priority = 29, groups = { "settings" })
	public void verifyCreateRoleTest() {
		sp.verifyCreateRole();
	}	
	
	@Test(priority = 29, groups = { "settings" })
	public void verifyNewTeamMemberPopupCancelButtonTest() {
		sp.verifyNewTeamMemberPopupCancelButton();
	}	
	

	@Test(priority = 29, groups = { "settings" })
	public void verifyNewTeamMemberPopupCloseButtonTest() {
		sp.verifyNewTeamMemberPopupCloseButton();
	}	
	
	@Test(priority = 30, groups = { "settings" })
	public void verifyInviteTabTest() {
		sp.verifyInviteTab();
	}	
	

	@Test(priority = 31, groups = { "settings" })
	public void verifySendInviteToFieldTest() {
		sp.verifySendInviteToField();
	}	
	
	@Test(priority = 31, groups = { "settings" })
	public void verifyAllTeamMembersTabTest() {
		sp.verifyAllTeamMembersTabFunctionality();
	}	
	

	@Test(priority = 31, groups = { "settings" })
	public void verifyPendingInvitesTabTest() {
		sp.verifyPendingInvitesTabFunctionality();
	}	
	
	@Test(priority = 31, groups = { "settings" })
	public void verifySendEmailTabTest() {
		sp.verifySendEmailTabFunctionality();
	}	
	
}
