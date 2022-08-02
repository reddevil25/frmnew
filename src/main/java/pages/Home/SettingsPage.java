package pages.Home;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import commons.BasePage;

public class SettingsPage extends BasePage {

	public SettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	SoftAssert sa = new SoftAssert();
	private static final Logger log = LogManager.getLogger(SettingsPage.class.getName());
	// My account webElements
	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement myAccount;
	@FindBy(xpath = "//div[@class='d-flex  justify-content-start settings_navigation mx-n5 px-5 mb-2 text-right']/li[1]")
	private WebElement profileTab;
	@FindBy(xpath = "//div[@class='d-flex  justify-content-start settings_navigation mx-n5 px-5 mb-2 text-right']/li[2]")
	private WebElement notificationTab;
	@FindBy(xpath = "//div[@class='d-flex  justify-content-start settings_navigation mx-n5 px-5 mb-2 text-right']/li[3]")
	private WebElement companiesTab;

	// Profile WebElements
	@FindBy(xpath = "//*[@class='ml-3']/span")
	private WebElement userName;
	@FindBy(xpath = "//*[@class='ml-3']/div/span")
	private WebElement userRole;
	@FindBy(xpath = "//*[@class='d-flex align-items-center']/div/img")
	private WebElement userImage;
	@FindBy(xpath = "(//*[@class='d-flex']/button)[1]")
	private WebElement editProfile;
	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@name='first_name']/parent::div/following-sibling::p")
	private WebElement firstNameError;
	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@name='last_name']/parent::div/following-sibling::p")
	private WebElement lastNameError;
	@FindBy(xpath = "//input[@name='user_email']")
	private WebElement email;
	@FindBy(xpath = "//input[@name='user_email']/parent::div/following-sibling::p")
	private WebElement emailError;
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phone;
	@FindBy(xpath = "//input[@name='phone']/parent::div/following-sibling::p")
	private WebElement phoneError;
	@FindBy(xpath = "//div[text()='Skills']/following-sibling::input")
	private WebElement skills;
	@FindBy(xpath = "//*[@class='col-12 d-flex justify-content-center']/label/div/img")
	private WebElement profilePhoto;
	@FindBy(xpath = "//span[@id='Delete']")
	private WebElement deleteProfilePhoto;
	@FindBy(xpath = "//label[@id='Edit']")
	private WebElement editProfilePhoto;
	@FindBy(xpath = "//div[@class='d-flex justify-content-end']/button[1]")
	private WebElement editProfileCancel;
	@FindBy(xpath = "//div[@class='d-flex justify-content-end']/button[2]")
	private WebElement editProfileSave;
	@FindBy(xpath = "//span[@class='text-blue font_semibold']")
	private WebElement nameOnUserProfile;
	@FindBy(xpath = "//div[@class='d-flex align-items-center']/div/img")
	private WebElement profilePhotoOnUserProfile;
	// input[@name='user_email']
	
	@FindBy(xpath = "//div[@class=' col-lg-5 col-11 box_shadow ml-lg-3 ml-2 p-4 flex-1']")
	private WebElement emailSignatureBox;	
	@FindBy(xpath = "//body[@id='tinymce']")
	private WebElement emailSignatureBoxBody;	
	@FindBy(xpath = "//button[@class='blue_button_hover font_sm text-white font_medium px-4 my-2 py-1 cursor']")
	private WebElement emailSignatureBoxEdit;
	
	//company tab elements
	@FindBy(xpath = "//a[text()='Company']")
	private WebElement companyTab;	
	@FindBy(xpath = "//li[@class=' font_semibold mr-lg-4 mr-3 d-flex align-items-center text_darkgray font_sm cursor  py-2 active-tab']")
	private WebElement companySettingsTab;	
	@FindBy(xpath = "//li[@class='font_semibold mr-lg-4 mr-3 d-flex align-items-center text_darkgray font_sm cursor py-2 ' and text()='Team members']")
	private WebElement TeamMembersTab;
	@FindBy(xpath = "//li[@class='font_semibold mr-lg-4 mr-3 d-flex align-items-center text_darkgray font_sm cursor py-2 ' and text()='Hiring roles']")
	private WebElement HiringRolesTab;	
	@FindBy(xpath = "//button[@class='border bg-blue text-white font_medium px-3 py-1 mb-2 font_sm border-0 blue_button_hover mt-3']")
	private WebElement companySettingsAddButton;	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement companySettingsSaveButton;
	@FindBy(xpath = "//header/p")
	private WebElement addCompanyPopup;
	@FindBy(xpath = "//button[@class='common_button font_sm bg-lightGrey text_darkgray px-3 py-1 ']")
	private WebElement addCompanyCancel;
	@FindBy(xpath = "//div[@class='ml-3']")
	private List<WebElement> companyCards;	
	@FindBy(xpath = "//input[@class='label-and-input-box font_sm text_darkgray line-height  custom_class font_sm mh-38 border_bottom']")
	private WebElement addCompanyName;	
	@FindBy(xpath = "//div[@class='text-danger font_tiny' and contains(text(),'Company name')]")
	private WebElement addCompanyNameError;
	@FindBy(xpath = "//textarea")
	private WebElement addCompanyDesc;
	@FindBy(xpath = "//div[@class='text-danger font_tiny' and contains(text(),'description')]")
	private WebElement addCompanyDescError;
	@FindBy(xpath = "//input[@class='border-0 font_sm text_gray p-1 bg-transparent']")
	private WebElement addPhoneNumber;
	@FindBy(xpath = "//div[@class='font_tiny font_medium text_gray mr-2']")
	private List<WebElement> addedPhoneNumber;
	@FindBy(xpath = "//div[@class='text-danger font_tiny' and contains(text(),'Phone')]")
	private WebElement phoneNumberRequiredError;
	@FindBy(xpath = "//div[@class='text-danger font_tiny' and contains(text(),'digits')]")
	private WebElement phoneNumberEnterDigitsError;
	@FindBy(xpath = "//div[@class='text-danger font_tiny' and contains(text(),'valid')]")
	private WebElement phoneNumberNotValidError;
	@FindBy(xpath = "//div[text()='City']/following-sibling::input")
	private WebElement addCity;
	@FindBy(xpath = "//div[@class='text-danger font_tiny' and contains(text(),'City')]")
	private WebElement cityError;
	@FindBy(xpath = "//div[text()='PIN code']/following-sibling::input")
	private WebElement addZipCode;
	@FindBy(xpath = "//div[@class='text-danger font_tiny' and contains(text(),'Pincode')]")
	private WebElement zipCodeError;
	@FindBy(xpath = "(//div[@class=' css-1wy0on6'])[1]")
	private WebElement countryDrpButton;
	@FindBy(xpath = "//div[@class=' css-1hb1tje-option']")
	private List<WebElement> countryDrpOptions;
	@FindBy(xpath = "(//div[@class=' css-1d8n9bt'])[1]")
	private WebElement countryDrpField;
	@FindBy(xpath = "//div[@class='text-danger font_tiny' and contains(text(),'Country')]")
	private WebElement countryError;
	@FindBy(xpath = "(//div[@class=' css-1wy0on6'])[2]")
	private WebElement stateDrpButton;
	@FindBy(xpath = "//div[@class=' css-1hb1tje-option']")
	private List<WebElement> stateDrpOptions;
	@FindBy(xpath = "(//div[@class=' css-1d8n9bt'])[2]")
	private WebElement stateDrpField;
	@FindBy(xpath = "//div[@class='text-danger font_tiny' and contains(text(),'State')]")
	private WebElement stateError;
	@FindBy(xpath = "//div[text()='Domain']/following-sibling::input")
	private WebElement addDomain;
	@FindBy(xpath = "//div[@class='text-danger font_tiny' and contains(text(),'Domain')]")
	private WebElement domainError;
	@FindBy(xpath = "//*[local-name()='svg'][@class='positioning text-success']")
	private WebElement domainCheckmark;
	@FindBy(xpath = "(//span[@class='d-block text-blue font_sm font_semibold my-1 '])[1]")
	private WebElement cardCompanyDesc;
	@FindBy(xpath = "(//span[@class='d-block my-1 font_semibold font_tiny'])[1]")
	private WebElement cardCompanyName;
	@FindBy(xpath = "(//span[@class='d-block my-1 font_semibold font_tiny'])[2]")
	private WebElement cardCompanyCountry;
	@FindBy(xpath = "(//img[@class='shadow-sm '])[1]")
	private WebElement cardLogo;
	@FindBy(xpath = "(//button[@class='common_button bg-lightGrey text_darkgray m-1 editpadding fw-normal p-1 pl-2 pr-4 font_tiny text-center border-0 d-flex align-items-center'])[1]")
	private WebElement cardEdit;
	@FindBy(xpath = "(//button[@class='common_button bg-lightGrey text_darkgray m-1 font_tiny text-center border-0 p-1 px-2 d-flex justify-content-start align-items-center'])[1]")
	private WebElement cardDelete;
	@FindBy(xpath = "//li[text()='Team members']")
	private WebElement teamMembersTab;
	@FindBy(xpath = "//button[text()='All Team Members']")
	private WebElement allTeamMembers;
	@FindBy(xpath = "//tbody/tr")
	private List<WebElement> allTeamMembersList;
	@FindBy(xpath = "//button[text()='Pending Invites']")
	private WebElement pendingInvites;
	@FindBy(xpath = "//tbody/tr")
	private List<WebElement> pendingInvitesList;
	@FindBy(xpath = "//button[text()='Send Email']")
	private WebElement sendEmail;
	@FindBy(xpath = "//div[@class='w-75 mx-auto p-4  my-4 border']")
	private WebElement sendEmailBox;
	@FindBy(xpath = "//select")
	private WebElement sendEmailTo;
	@FindBy(xpath = "(//input)[1]")
	private WebElement sendEmailTitle;
	@FindBy(xpath = "//body[@id]")
	private WebElement sendEmailBody;
	@FindBy(xpath = "(//button)[20]")
	private WebElement sendEmailSendButton;
	@FindBy(xpath = "(//button)[19]")
	private WebElement sendEmailCancelButton;
	@FindBy(xpath = "//label")
	private WebElement sendEmailAttachFile;
	@FindBy(xpath = "(//button)[1]")
	private WebElement addNewTeamMember;
	@FindBy(xpath = "//button[text()='Invite']")
	private WebElement inviteButton;
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createTab;
	@FindBy(xpath = "//input[@placeholder='Enter First Name']")
	private WebElement createFirstName;
	@FindBy(xpath = "//p[@class='font_sm text-danger' and contains(text(),'First')]")
	private WebElement createFirstNameError;
	@FindBy(xpath = "//input[@placeholder='Enter Last Name']")
	private WebElement createLastName;
	@FindBy(xpath = "//p[@class='font_sm text-danger' and contains(text(),'Last')]")
	private WebElement createLastNameError;
	@FindBy(xpath = "//input[@placeholder='Enter Email']")
	private WebElement createEmail;
	@FindBy(xpath = "//p[@class='font_sm text-danger' and contains(text(),'email')]")
	private WebElement createEmailError;
	@FindBy(xpath = "//input[@placeholder='Enter Phone Number']")
	private WebElement createPhoneNumber;
	@FindBy(xpath = "//div[text()='Phone no.']/parent::div/following-sibling::div/p")
	private WebElement createPhoneNumberError;
	@FindBy(xpath = "//div[@class=' css-xhupmv-control']")
	private WebElement createRole;
	@FindBy(xpath = "//p[@class='font_sm text-danger' and contains(text(),'roles')]")
	private WebElement createRoleError;
	@FindBy(xpath = "//div[@class=' css-1hb1tje-option']")
	private List<WebElement> roleOptions;
	@FindBy(xpath = "//div[@class=' css-1hwfws3']")
	private WebElement createRoleField;
	@FindBy(xpath = "(//button[text()='Create'])[2]")
	private WebElement createButton;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath = "//button[@class='react-responsive-modal-closeButton']")
	private WebElement popupCloseButton;
	@FindBy(xpath = "//div[@class='react-responsive-modal-modal']")
	private WebElement newTeamMemberPopup;
	@FindBy(xpath = "//span[contains(text(),'invite')]/following-sibling::div/input")
	private WebElement sendInviteTo;
	@FindBy(xpath = "//div[@class='label-and-input-box w-100 d-flex flex-wrap']")
	private WebElement sendInviteToField;
	@FindBy(xpath = "//p[contains(text(),'email')]")
	private WebElement sendInviteToError;
	@FindBy(xpath = "//div[@class='cursor d-flex align-items-center text-danger']")
	private WebElement emailCrossButton;
	@FindBy(xpath = "//button[text()='Send']")
	private WebElement sendInviteButton;
	@FindBy(xpath = "//span[@class='font_semibold text-capitalize text_darkgray font_tiny ml-2']")
	private List<WebElement> firstNameOnCard;
	/*@FindBy(xpath = )
	private WebElement editButtonOnCard;*/	
	
	//pop up elements
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alert;
	@FindBy(css = ".Toastify>div>div>button")
	private WebElement closePopup;

	

	// Verify the functionality of the "My Account" tab.
	public void verifyMyAccountTab() {
		click(myAccount);
		log.info("clicked on my account tab");
		sa.assertTrue(isDisplayed(profileTab), "profile sub category is missing");
		sa.assertTrue(isDisplayed(notificationTab), "notification sub category is missing");
		sa.assertTrue(isDisplayed(companiesTab), "companies sub category is missing");
		sa.assertAll();
		log.info("my account tab is working as expected and all sub categories are visible");
	}

	// Verify the functionality of the "Profile" tab.
	public void verifyProfileTab() {
		click(myAccount);
		click(profileTab);
		log.info("navigated to profile tab");
		sa.assertTrue(isDisplayed(userName), "User name field missing in profile tab");
		sa.assertTrue(isDisplayed(userRole), "User role field missing in profile tab");
		sa.assertTrue(isDisplayed(userImage), "User Image field missing in profile tab");
		sa.assertTrue(getAttribute(userImage, "src").contains("https://core-staging.appsierra.xyz/files"),
				"User image is not visible in profile tab");
		sa.assertAll();
		log.info("profile tab is working as expected and it has all requrired info about user");
	}

	// Verify the functionality of the "Edit Profile" button on the "Profile" tab.
	// Verify all the inputs are present on the edit profile fields.
	public void verifyEditProfileButton() {
		click(myAccount);
		click(profileTab);
		log.info("navigated to profile tab");
		click(editProfile);
		log.info("clicked on edit profile Button");
		sa.assertTrue(isDisplayed(firstName), "firstname field is missing");
		sa.assertTrue(isDisplayed(lastName), "lastname field is missing");
		sa.assertTrue(isDisplayed(email), "email field is missing");
		sa.assertTrue(isDisplayed(phone), "phone field is missing");
		sa.assertTrue(isDisplayed(skills), "skills field is missing");
		sa.assertTrue(isDisplayed(editProfileCancel), "cancel button is missing");
		sa.assertTrue(isDisplayed(editProfileSave), "save button is missing");
		sa.assertAll();
		log.info("Edit profile button working as expected");
	}

//	Verify the previously uploaded photo is visible on the "Profile Photo" field.
//	Verify the functionality of the "Profile Photo" field.
//	Verify the functionality of the "Delete" button under the profile photo field.
//	Verify the deleted image is not visible on the field.
//	Verify an "Edit" button is visible after the image is deleted.
	public void verifyProfilePhotoFieldOnEditProfile() {
		String profilePicPath = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "Assets" + fs + "ASLogo.png";

		click(myAccount);
		click(profileTab);
		log.info("navigated to profile tab");
		click(editProfile);
		log.info("clicked on edit profile Button");
		sa.assertTrue(isDisplayed(profilePhoto), "profile photo field not present on page");
		sa.assertTrue(getAttribute(profilePhoto, "src").contains("https://core-staging.appsierra.xyz/files"),
				"Uploaded photo not visible on Profile photo field ");
		String originalPic = getAttribute(profilePhoto, "src");
//		log.info(originalPic);
		click(profilePhoto);
		log.info("clicked on profile photo field to upload profile photo");
		uploadFile(profilePicPath);
		while (getAttribute(profilePhoto, "src").equals(originalPic)) {
//			log.info("waiting for new photo to be uploaded");
		}
		String uploadedPic = getAttribute(profilePhoto, "src");
		sa.assertFalse(getAttribute(profilePhoto, "src").equals(originalPic),
				"Newly uploaded profile photo not visible at profile photo field");
		log.info("clicking on delete profile photo to delete profile photo");
		click(deleteProfilePhoto);
	/*	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		while (getAttribute(profilePhoto, "src").equals(uploadedPic)) {
//			log.info("waiting for photo to be deleted");
		}
		String picPresentAfterDelete = getAttribute(profilePhoto, "src");
		log.info(picPresentAfterDelete);
		sa.assertFalse(getAttribute(profilePhoto, "src").equals(uploadedPic),
				"profile photo not get deleted still visible at profile photo field");
		sa.assertTrue(isDisplayed(editProfilePhoto),
				"edit profile photo option not displayed after deleting profile photo");

		sa.assertAll();
		log.info("Uploaded Photo Visible On Profile Photo Field");
	}

	// Verify the functionality of the "First Name" field.
//	Verify if the first name field is left empty an error message is displayed.
	public void verifyFirstNameFieldOnEditProfile() {
		click(myAccount);
		click(profileTab);
		log.info("navigated to profile tab");
		click(editProfile);
		log.info("clicked on edit profile Button");
		clearTextbox(firstName);
		log.info("clicking on save button by keeping first name field empty to check error");
		click(editProfileSave);
		log.info("Error : " + getText(firstNameError));
		sa.assertEquals(getText(firstNameError), "First name is required",
				"check error text when firstname field kept empty");
		sendKeys(firstName, "Brenda");
		click(editProfileSave);
		log.info("entered value in firstname field and clicked on save to check for error");
		click(closePopup);
		click(editProfile);
		sa.assertFalse(isDisplayed(firstNameError),
				"Error still present even after entering value in first name field");
		sa.assertEquals(getAttribute(firstName, "value"), "Brenda",
				"expected firstname not match with actual firstname ");
		sa.assertAll();
		log.info("first name field on edit profile popup working as expected");
	}

//	Verify the functionality of the "Last Name" field.
//	Verify if the last name field is left empty an error message is displayed.
	public void verifyLastNameFieldOnEditProfile() {
		click(myAccount);
		click(profileTab);
		log.info("navigated to profile tab");
		click(editProfile);
		log.info("clicked on edit profile Button");
		clearTextbox(lastName);
		log.info("clicking on save button by keeping last name field empty to check error");
		click(editProfileSave);
		log.info("Error : " + getText(lastNameError));
		sa.assertEquals(getText(lastNameError), "Last name is required",
				"check error text when last Name field kept empty");
		sendKeys(lastName, "Leuschke");
		click(editProfileSave);
		log.info("entered value in lastName field and clicked on save to check for error");
		click(closePopup);
		click(editProfile);
		sa.assertTrue(getText(lastNameError).isEmpty(),
				"Error still present even after entering value in last name field");
		sa.assertEquals(getAttribute(lastName, "value"), "Leuschke",
				"expected lastname not match with actual lastname ");
		sa.assertAll();
		log.info("last name field on edit profile popup working as expected");
	}

	public void verifyEmailFieldOnEditProfile() {
		click(myAccount);
		click(profileTab);
		log.info("navigated to profile tab");
		click(editProfile);
		log.info("clicked on edit profile Button");
		log.info("Trying to edit email field by entering new value abce@a.com");
		email.sendKeys("abce@a.com");
		log.info("value present inside email field after Trying to edit email field : " + getAttribute(email, "value"));
		sa.assertFalse(getAttribute(email, "value").contains("abce@a.com"),
				"Email got edited after entering new value inside field");
		sa.assertEquals(getAttribute(email, "value"), "devuser@pitchnhire.com",
				"Email got edited after entering new value inside field");
		sa.assertTrue(getText(emailError).isEmpty(), "Error still present even after entering value in email field");
		sa.assertAll();
		log.info("email field on edit profile popup working as expected");
	}

//	Verify the functionality of the "Contact No" field.
//	Verify an error message is displayed if the number field is empty.
//	Verify an error message is displayed if users enter an invalid contact number.
//	Verify the length of the mobile number is limited to 10 digits. 
//	Verify the contact no field should accept only numbers.
	public void verifyContactNumberFieldOnEditProfile() {
		click(myAccount);
		click(profileTab);
		log.info("navigated to profile tab");
		click(editProfile);
		log.info("clicked on edit profile Button");
		clearTextbox(phone);
		log.info("clicking on save by keeping contact number field empty to check error");
		click(editProfileSave);
		log.info("Error : " + getText(phoneError));
		sa.assertEquals(getText(phoneError), "Mobile is required",
				"check error text when Contact number field kept empty");
		log.info("Entering special character and alphabets in contact number field to check error");
		sendKeys(phone, "%$##ABCSDf");
		click(editProfileSave);
		log.info("Error : " + getText(phoneError));
		sa.assertEquals(getText(phoneError), "Please enter digits.",
				"check error text when entered special chars and alphabets in contact number field");
		log.info("Entering contact number having digits more than 10 to check error");
		sendKeys(phone, "99988887774562");
		click(editProfileSave);
		log.info("Error : " + getText(phoneError));
		sa.assertEquals(getText(phoneError), "Please enter valid mobile number.",
				"check error text when entered more than 10 digits in contact number field");
		log.info("Entering valid contact number to check error");
		sendKeys(phone, "8380821232");
		click(editProfileSave);
		log.info("Error displayed: " + isDisplayed(phoneError));
		//sa.assertTrue(getText(phoneError).isEmpty(), "Error still present even after entering value in phone field");
		sa.assertEquals(isDisplayed(phoneError), false, "Error still present even after entering value in phone field");
		log.info("clicking on edit again to open popup to check if number given is valid...");
		click(editProfile);
		sa.assertEquals(getAttribute(phone, "value"), "8380821232", "expcted contact number did not match with actual");
		sa.assertAll();
		log.info("contact number field on edit profile popup working as expected");
	}
	
	public void verifySkillsOnEditProfile() {
		click(myAccount);
		click(profileTab);
		log.info("navigated to profile tab");
		click(editProfile);
		log.info("clicked on edit profile Button");
		log.info("passing multiple skills in input...");
		sendKeys(skills,"Hindi");
		skills.sendKeys(" Eng");
		sa.assertEquals(getAttribute(skills, "value"), "Hindi Eng", "expcted skills did not match with actual");
		log.info("removing skill 'Eng'...");
		skills.sendKeys(Keys.BACK_SPACE);
		skills.sendKeys(Keys.BACK_SPACE);
		skills.sendKeys(Keys.BACK_SPACE);
		click(editProfileSave);
		log.info("clicking on edit again to open popup to check if skill given is visible...");
		click(editProfile);
		sa.assertEquals(getAttribute(skills, "value"), "Hindi ", "expcted skills did not match with actual");
		sa.assertAll();
		log.info("Skills field on edit profile popup working as expected");
	}
	
	public void verifySaveButtonOnEditProfile() {
		String profilePicPath = System.getProperty("user.dir") + fs + "src" + fs + "test" + fs + "resources" + fs
				+ "Assets" + fs + "ASLogo.png";
		
		click(myAccount);
		click(profileTab);
		log.info("navigated to profile tab");
		click(editProfile);
		log.info("clicked on edit profile Button");
		log.info("uploading a profile photo...");
		uploadFile(profilePicPath);
		String photoOnEditProfile = getAttribute(profilePhoto, "src");
		log.info("photo on edit profile: " + photoOnEditProfile);
		sendKeys(firstName, "Bren");
		click(editProfileSave);
		log.info("entered value in firstname field and clicked on save");
		sa.assertEquals(getText(alert), "Edit Successfully", "check alert");
		click(editProfile);
		log.info("clicking on edit profile button again to check if edited details are visible or not");
		sa.assertEquals(getAttribute(firstName, "value"), "Bren", "edited first name not visible");
		sa.assertEquals(getAttribute(profilePhoto, "src"), photoOnEditProfile, "edited photo not visible");
		click(editProfileSave);
		log.info("checking if the edited details are visible on the user profile or not");
		log.info("name on user profile: " + getText(nameOnUserProfile));
		sa.assertTrue(getText(nameOnUserProfile).contains("Bren"),"edited first name not visible");
		log.info("photo on user profile: " + getAttribute(profilePhotoOnUserProfile, "src"));
		sa.assertEquals(getAttribute(profilePhotoOnUserProfile, "src"), photoOnEditProfile ,"edited first name not visible");
		sa.assertAll();
	}

	//"Verify the "Email Signature" box is present on the  “Accounts -> Profile” page
	//Verify the functionality of the "Email Signature" box.
	public void verifyEmailSignatureBox() {
		log.info("checking if we are on 'accounts' tab or not...");
		log.info("Accounts tab is present: " + isDisplayed(myAccount));
		sa.assertEquals(isDisplayed(myAccount), true, "not on my account tab");
		log.info("checking if we are on 'profile' subcategory or not...");
		log.info("Profile subcat is present: " + isDisplayed(profileTab));
		sa.assertEquals(isDisplayed(profileTab), true, "not on profile subcat");
		log.info("checking for visibility of email signature box...");
		log.info("Email signature box is present: " + isDisplayed(emailSignatureBox));
		sa.assertEquals(isDisplayed(emailSignatureBox), true, "box not visible");
		log.info("checking for body field in box to provide input...");
		By iframe = By.xpath("//iframe[@class='tox-edit-area__iframe']");
		driver.switchTo().frame(driver.findElement(iframe));
		log.info("body field in box is present: " + isDisplayed(emailSignatureBoxBody));
		sa.assertEquals(isDisplayed(emailSignatureBoxBody), true, "body field in box not visible");
		driver.switchTo().defaultContent();
		sa.assertAll();
		log.info("Hence, email signature box is verified");
	}
	
	//Verify the "Edit" button is present in the "Email Signature" box.
	//Verify the functionality of the "Edit" button.
	//Verify the field and tools is not accessible if users fail to press the "Edit" button.
	//Verify a "Save" button is displayed when users click on the "Edit" button.
	//Verify the functionality of the "Save" button.
	public void verifyEmailSignatureBoxEditAndSave() {
		log.info("Email signature box is present: " + isDisplayed(emailSignatureBox));
	    log.info("Checking if edit button in the box is visible or not...");
	    log.info("Edit button is present: " + isDisplayed(emailSignatureBoxEdit));
		sa.assertEquals(isDisplayed(emailSignatureBoxEdit), true, "edit button not present in the box");
		log.info("Checking if the body field is accessible or not if we do not click the edit button...");
		By iframe = By.xpath("//iframe[@class='tox-edit-area__iframe']");
		driver.switchTo().frame(driver.findElement(iframe));
		log.info("body field in box is present: " + isDisplayed(emailSignatureBoxBody));
		//doubt
	    log.info("is body field enabled?: " + getAttribute(emailSignatureBoxBody, "contenteditable"));
	    sa.assertEquals(getAttribute(emailSignatureBoxBody, "contenteditable"), "false" ,"body field is enabled even when edit button not clicked");
		driver.switchTo().defaultContent();
		log.info("Checking if the body field is accessible when clicked on edit button...");
		log.info("clicking on edit button");
		click(emailSignatureBoxEdit);
		driver.switchTo().frame(driver.findElement(iframe));
		log.info("body field in box is present: " +isDisplayed(emailSignatureBoxBody));
		sendKeys(emailSignatureBoxBody, "testing body");
		log.info("text in input field when clicked edit button: " + getText(emailSignatureBoxBody));
		sa.assertTrue(getText(emailSignatureBoxBody).contains("testing body"), "body field not got input even when clicked the edit button");
		driver.switchTo().defaultContent();
		log.info("checking if save button is displayed in place of edit button after we clicked edit and edited the field...");
		// edit and save both have same class hence element is same for both
		log.info("Save button is displayed: " + isDisplayed(emailSignatureBoxEdit));
		sa.assertEquals(isDisplayed(emailSignatureBoxEdit), true, "save button not displayed");
		log.info("clicking on save button");
		click(emailSignatureBoxEdit);
		sa.assertTrue(getText(alert).contains("Edit Successfully"), "check alert");
		log.info(getText(alert));
		log.info("checking if the edited info is saved in the field after we save using save button...");
		driver.switchTo().frame(driver.findElement(iframe));
		log.info("text in input field when clicked save button: " + getText(emailSignatureBoxBody));
		sa.assertTrue(getText(emailSignatureBoxBody).contains("testing body"), "body field does not contain the edited info");
		driver.switchTo().defaultContent();
		sa.assertAll();
		log.info("Hence, email signature box edit and save functionality is verified");
		
	}
	
	public void verifyNotificationsTab( ) {
		click(myAccount);
		click(notificationTab);
		log.info("navigated to notifications tab");
	}
	
	public void verifyCompaniesTab() {
		click(myAccount);
		click(companiesTab);
		log.info("navigated to companies tab");
		setCompanyDetails();
	}
	
	//Verify the functionality of the "Company" tab beside the "My Profile" tab.
	public void verifyCompanyTab() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("checking if the respected tabs are present under company tab...");
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		sa.assertEquals(isDisplayed(companySettingsTab), true, "company settings tab not displayed");
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		sa.assertEquals(isDisplayed(TeamMembersTab), true, "team memebers tab not displayed");
		log.info("Hiring Roles tab is present: " +  isDisplayed(HiringRolesTab));
		sa.assertEquals(isDisplayed(HiringRolesTab), true, "Hiring Roles tab not displayed");
		sa.assertAll();
		log.info("Hence, company tab is verified");
	}
	
	//Verify the functionality of the "Company Settings" tab.
	//Verify the added companies are displayed on the "Company Settings" page.
	//Verify all the details of the companies are present on the company cards.
	public void verifyCompanySettingsTab() {	
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("checking if add button is present or not...");
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		sa.assertEquals(isDisplayed(companySettingsAddButton), true, "Hiring Roles tab not displayed");
		log.info("creating a company card...");
		setCompanyDetails();
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		click(companySettingsSaveButton);
		//sa.assertTrue(verifyPopup(""), fs);
	/*	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		log.info("checking if company card created by us is present in the tab with appropriate details or not...");
		log.info("company description on the card is: " + getText(cardCompanyDesc));
		sa.assertEquals(getText(cardCompanyDesc), getCompanyDesc(), "company desc on card not matching");
		log.info("company name on the card is: " + getText(cardCompanyName));
		sa.assertEquals(getText(cardCompanyName), getCompanyName(), "company name on card not matching");
		log.info("company country on the card is: " + getText(cardCompanyCountry));
		sa.assertEquals(getText(cardCompanyCountry), getCountry(), "company country on card not matching");
		log.info("logo on card is present: " + isDisplayed(cardLogo));
		sa.assertEquals(isDisplayed(cardLogo), true, "card logo not displayed");
		log.info("edit button on card is present: " + isDisplayed(cardEdit));
		sa.assertEquals(isDisplayed(cardEdit), true, "card edit button not displayed");
		log.info("delete button on card is present: " + isDisplayed(cardDelete));
		sa.assertEquals(isDisplayed(cardDelete), true, "card delete button not displayed");
		sa.assertAll();
	}
	
	//Verify the functionality of the "Add" button.	
	public void verifyCompanyAddButton() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		click(companySettingsAddButton);
		log.info("clicked on add button to open company details popup");
		log.info("verifying all input fields are present in the pop up...");
		log.info("add company name input field present: " + isDisplayed(addCompanyName));
		sa.assertEquals(isDisplayed(addCompanyName), true, "add company name input field not displayed");
		log.info("add company description input field present: " + isDisplayed(addCompanyDesc));
		sa.assertEquals(isDisplayed(addCompanyDesc), true, "add company desc input field not displayed");
		log.info("add phone number input field present: " + isDisplayed(addPhoneNumber));
		sa.assertEquals(isDisplayed(addPhoneNumber), true, "add phone number input field not displayed");
		log.info("add city input field present: " + isDisplayed(addCity));
		sa.assertEquals(isDisplayed(addCity), true, "add city input field not displayed");
		log.info("add zip code input field present: " + isDisplayed(addZipCode));
		sa.assertEquals(isDisplayed(addZipCode), true, "add zip code input field not displayed");
		log.info("country dropdown button present: " + isDisplayed(countryDrpButton));
		sa.assertEquals(isDisplayed(countryDrpButton), true, "country Drp Button not displayed");
		log.info("state dropdown button present: " + isDisplayed(stateDrpButton));
		sa.assertEquals(isDisplayed(stateDrpButton), true, "state Drp Button not displayed");
		sa.assertAll();
	}
	
	//Verify the functionality of the "Company Name" field.
	public void verifyCompanyNameField() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		click(companySettingsAddButton);
		log.info("clicked on add button to open company details popup");
		log.info("verifying add company name input field...");
		log.info("add company name input field present: " + isDisplayed(addCompanyName));
		sa.assertEquals(isDisplayed(addCompanyName), true, "add company name input field not displayed");
		log.info("giving empty input to add company name field...");
		setCompanyName("");
		click(companySettingsSaveButton);
		log.info("add company name error is: " + getText(addCompanyNameError));
		sa.assertEquals(getText(addCompanyNameError), "Company name is required", "add company name error not matching");
		sa.assertEquals(getCompanyName(), "","add company name field is not empty");
		log.info("giving proper value to the field...");
		setCompanyName("Test Company Name 1234");
		sa.assertFalse(isDisplayed(addCompanyNameError), "add company name error displayed even after entering valid input");
		sa.assertEquals(getCompanyName(), "Test Company Name 1234","passed input not present in add company name field");
		sa.assertAll();
	}
	
	//Verify the functionality of the "Street" field.
	public void verifyCompanyDescriptionField() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		click(companySettingsAddButton);
		log.info("clicked on add button to open company details popup");
		log.info("verifying add company description input field...");
		log.info("add company description input field present: " + isDisplayed(addCompanyDesc));
		sa.assertEquals(isDisplayed(addCompanyDesc), true, "add company desc input field not displayed");
		log.info("giving empty input to add company desc field...");
		setCompanyDesc("");
		click(companySettingsSaveButton);
		log.info("add company desc error is: " + getText(addCompanyDescError));
		sa.assertEquals(getText(addCompanyDescError), "Company description is required", "add company desc error not matching");
		sa.assertEquals(getCompanyDesc(), "","add company desc field is not empty");
		log.info("giving proper value to the field...");
		setCompanyDesc("Company desc test1234");
		sa.assertEquals(getCompanyDesc(),"Company desc test1234", "passed input not present in add company desc field");
		sa.assertAll();
	}
	
	//Verify the functionality of the "Phone Number" field.
	//Verify the length of the phone number is limited to 10 digits.
	public void verifyCompanyPhoneNumberField() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		click(companySettingsAddButton);
		log.info("clicked on add button to open company details popup");
		log.info("verifying phone number functionality...");
		log.info("add phone number input field present: " + isDisplayed(addPhoneNumber));
		sa.assertEquals(isDisplayed(addPhoneNumber), true, "add phone number input field not displayed");
		log.info("giving empty input to add phone number  field...");
		setPhoneNumber("");
		click(companySettingsSaveButton);
		log.info("add phone number error is: " + getText(phoneNumberRequiredError));
		sa.assertEquals(getText(phoneNumberRequiredError),"Phone number is required", "add phone number error not matching");
		//sa.assertEquals(getPhoneNumber().get(0), "[]","phone number field is not empty");
		//sa.assertFalse(isDisplayed(addedPhoneNumber), "phone number added even after giving empty input");
		sa.assertTrue(isDisplayed(addPhoneNumber), "phone input not visible even after not adding any input");
		log.info("entering characters instead of numbers in phone no. input field...");
		setPhoneNumber("adgajdh#@");
	//	log.info("phone number error message displayed: " + isDisplayed(phoneNumberError));
		log.info("error message displayed is: " + getText(phoneNumberEnterDigitsError));
		sa.assertEquals(getText(phoneNumberEnterDigitsError), "Please enter digits.", " phone number error message not displayed");
		log.info("entering more than 10 digits in phone no. input field...");
		setPhoneNumber("9891234569999");
	//	log.info("phone number error message displayed: " + isDisplayed(phoneNumberNotValidError));
		log.info("error message displayed is: " + getText(phoneNumberNotValidError));
		sa.assertEquals(getText(phoneNumberNotValidError),"Please enter valid mobile number.", " phone number error message not displayed");
		log.info("entering proper 10 digits number in phone no. input field...");
		setPhoneNumber("1234567890");
		sa.assertFalse(isDisplayed(phoneNumberRequiredError) ,"phone required error present after valid input");
		sa.assertFalse(isDisplayed(phoneNumberEnterDigitsError) ,"enter digits error present after valid input");
		sa.assertFalse(isDisplayed(phoneNumberNotValidError) ,"phone not valid error present after valid input");
		sa.assertEquals(getPhoneNumber().get(0), "1234567890" , "passed input not present in add phone no. field");
		sa.assertAll();
	}
	
	//Verify the functionality of the "City" field.
	public void verifyCompanyCityField() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		click(companySettingsAddButton);
		log.info("clicked on add button to open company details popup");
		log.info("verifying add city field...");
		log.info("add city input field present: " + isDisplayed(addCity));
		sa.assertEquals(isDisplayed(addCity), true, "add city input field not displayed");
		log.info("giving empty input to add city  field...");
		setCity("");
		click(companySettingsSaveButton);
		log.info("add city error is: " + getText(cityError));
		sa.assertEquals(getText(cityError),"City is required", "add city error not matching");
		sa.assertEquals(getCity(), "","city field is not empty");
		log.info("entering numbers in add city field...");
		setCity("1234");
		log.info("city error message displayed: " + isDisplayed(cityError));
		log.info("error message displayed is: " + getText(cityError));
		sa.assertEquals(getText(cityError),"City name must be alphabetic.", "city error message not displayed");
		log.info("entering name of city in add city field...");
		setCity("Mumbai");
		sa.assertEquals(getCity(),"Mumbai", "passed input not present in add city field");
		sa.assertAll();
	}
	
	//Verify the functionality of the "Zip code" field.
	//Verify the length of the zip code is limited to 6 digits.
	public void verifyCompanyZipCodeField() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		click(companySettingsAddButton);
		log.info("clicked on add button to open company details popup");
		log.info("verifying add zip code field...");
		log.info("add zip code input field present: " + isDisplayed(addZipCode));
		sa.assertEquals(isDisplayed(addZipCode), true, "add zip code input field not displayed");
		log.info("giving empty input to add zip code  field...");
		setZipcode("");
		click(companySettingsSaveButton);
		log.info("add zip code error is: " + getText(zipCodeError));
		sa.assertEquals(getText(zipCodeError),"Pincode is required", "add zip code error not matching");
		sa.assertEquals(getZipcode(), ""," zip code field is not empty");
		log.info("entering characters in add zip code field...");
		setZipcode("abcd");
		log.info("zip code error message displayed: " + isDisplayed(zipCodeError));
		log.info("error message displayed is: " + getText(zipCodeError));
		sa.assertEquals(getText(zipCodeError), "Pincode should not contain characters", "zip code error message not displayed");
		log.info("entering more than 6 digits in add zip code field...");
		setZipcode("401101111");
		log.info("zip code error message displayed: " + isDisplayed(zipCodeError));
		log.info("error message displayed is: " + getText(zipCodeError));
		sa.assertEquals(getText(zipCodeError), "Pincode should not have more than 6 digits", "zip code error message not displayed");
		log.info("entering proper zipcode in add zip code field...");
		setZipcode("401109");
		sa.assertEquals(getZipcode(),"401109", "passed input not present in add zip code field");
		sa.assertAll();
	}
	
	//Verify the functionality of the "Country" dropdown field.
	public void verifyCompanyCountryDropdown() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		click(companySettingsAddButton);
		log.info("clicked on add button to open company details popup");
		log.info("verifying country dropdown...");
		log.info("country dropdown button present: " + isDisplayed(countryDrpButton));
		sa.assertEquals(isDisplayed(countryDrpButton), true, "country Dropdown Button not displayed");
		log.info("selecting no country from the dropdown...");
		click(companySettingsSaveButton);
		log.info("add country error is: " + getText(countryError));
		sa.assertEquals(getText(countryError),"Country name is required", "add country error not matching");
		sa.assertEquals(getCountry(), "Select country","country selected in country field");
		log.info("selecting 'Brazil' from country dropdown");
		setCountry("Brazil");
	    sa.assertEquals(getCountry(), "Brazil", "selected country not visible in the field");
	    sa.assertAll();
	}
	
	//Verify the functionality of the "State/Region dropdown" field.
	public void verifyCompanyStateDropdown() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		click(companySettingsAddButton);
		log.info("clicked on add button to open company details popup");
		log.info("verifying state dropdown...");
		log.info("Selecting a country...");
		setCountry("Brazil");
		log.info("state dropdown button present: " + isDisplayed(stateDrpButton));
		sa.assertEquals(isDisplayed(stateDrpButton), true, "state Drp Button not displayed");
		log.info("selecting no state from the dropdown...");
		click(companySettingsSaveButton);
		log.info("add state error is: " + getText(stateError));
		sa.assertEquals(getText(stateError),"State name is required", "add state error not matching");
		sa.assertEquals(getState(), "Select state/region","state selected in state field");
		log.info("selecting 'Bahia' from state dropdown");
		setState("Bahia");
		sa.assertEquals(getState(), "Bahia", "selected state not visible in the field");
		sa.assertAll();
	}
	
	    public void verifyCompanyDomainField() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		click(companySettingsAddButton);
		log.info("clicked on add button to open company details popup");
		log.info("domain field present: " + isDisplayed(addDomain));
		sa.assertEquals(isDisplayed(addDomain), true, "domain field not displayed");
		log.info("giving no input to domain field...");
		click(companySettingsSaveButton);
		log.info("domain error is: " + getText(domainError));
		sa.assertEquals(getText(domainError),"Enter Valid Domain Name !", "add domain error not matching");
		sa.assertEquals(getDomain(), "","passed input present in domain field");
		log.info("giving an already existing domain name as input...");
		setDomain("abcd.com");
		sa.assertEquals(getDomain(), "abcd.com", "passed input not visible in the field");
		sa.assertTrue(isDisplayed(domainError), "domain error not displayed even after entering existing domain");
		sa.assertEquals(getText(domainError),"Domain abcd.com is not available", "add domain error not matching");
		sa.assertFalse(isDisplayed(domainCheckmark), "checkmark visible on entering existing domain name");
		log.info("giving proper domain name...");
		setDomain("test.com");
		while(isDisplayed(domainError)) {
			//log.info("waiting for domain error to be not displayed...");
		}
		sa.assertEquals(getDomain(), "test.com", "passed input not visible in the field");
		sa.assertFalse(isDisplayed(domainError), "domain error displayed even after entering valid domain");
		sa.assertTrue(isDisplayed(domainCheckmark), "checkmark not visible on entering valid domain name");
		sa.assertAll();
	}
	    
	    public void verifyAddCompanyPopupCancelButton() {
	    	log.info("navigating to Company tab...");
			click(companyTab);
			log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
			log.info("add button present: " + isDisplayed(companySettingsAddButton));
			click(companySettingsAddButton);
			log.info("clicked on add button to open company details popup");
			log.info("popup displayed: " + isDisplayed(addCompanyPopup));
			sa.assertTrue(isDisplayed(addCompanyPopup), "popup not displayed");
			click(addCompanyCancel);
		/*	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//wait.forInvisibilityOfElement(addCompanyPopup);
			while(isDisplayed(addCompanyPopup)) {
				//log.info("waiting for invisibility of add company popup...");
			}
			log.info("clicked on cancel button to close company details popup");
			log.info("popup displayed: " + isDisplayed(addCompanyPopup));
			sa.assertFalse(isDisplayed(addCompanyPopup), "popup displayed even after clicking cancel button");
			sa.assertAll();
			
	    }
	
	//Verify the functionality of the "Edit" button on the company cards.
	//Verify the functionality of the "Edit Company Details" popup box.
	public void verifyEditCompanyDetails() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Company settings tab is present: " +  isDisplayed(companySettingsTab));
		log.info("checking if add button is present or not...");
		log.info("add button present: " + isDisplayed(companySettingsAddButton));
		sa.assertEquals(isDisplayed(companySettingsAddButton), true, "Hiring Roles tab not displayed");
		log.info("creating a company card...");
		setCompanyDetails();
	//	wait.forElementToBeClickable(companySettingsSaveButton);
		click(companySettingsSaveButton);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(cardEdit);
		log.info("editing company details...");
		log.info("company name is: " + getCompanyName());
		setCompanyName("edit company test 1234");
		log.info("company name after edit is: " + getCompanyName());
		sa.assertEquals(getCompanyName(), "edit company test 1234", "edited company name not matching");
		log.info("company description is: " + getCompanyDesc());
		setCompanyDesc("edit company desc test 1234");
		log.info("company description after edit is: " + getCompanyDesc());
		sa.assertEquals(getCompanyDesc(), "edit company desc test 1234", "edited company desc not matching");
		log.info("company phone number is: " + getPhoneNumber());
		setPhoneNumber("4567891012");
		log.info("company phone number after edit is: " + getPhoneNumber());
		sa.assertEquals(getPhoneNumber(), "4567891012", "edited company phone number not matching");
		log.info("company city is: " + getCity());
		setCity("Bangalore");
		log.info("company city after edit is: " + getCity());
		sa.assertEquals(getCity(), "Bangalore", "edited company city not matching");
		log.info("company zip code is: " + getZipcode());
		setZipcode("401100");
		log.info("company zip code after edit is: " + getZipcode());
		sa.assertEquals(getZipcode(), "401100", "edited company zip code not matching");
		log.info("company country is: " + getCountry());
		setCountry("India");
		log.info("company country  after edit is: " + getCountry());
		sa.assertEquals(getCountry(), "India", "edited company country not matching");
		log.info("company state is: " + getState());
		setState("Goa");
		log.info("company state after edit is: " + getCountry());
		sa.assertEquals(getState(), "Goa", "edited company state not matching");
		log.info("company domain is: " + getDomain());
		setDomain("newtest.com");
		log.info("company domain after edit is: " + getDomain());
		sa.assertEquals(getDomain(), "newtest,com", "edited company domain not matching");
		click(companySettingsSaveButton);
		sa.assertAll();
		log.info("Hence edit functionality is verified");
	}
	
	//Verify the functionality of the "Team members" tab.
	//Verify the functionality of the "New Team Member" button.
	public void verifyTeamMembersTab() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		log.info("all team members sub tab is present: " + isDisplayed(allTeamMembers));
		sa.assertEquals(isDisplayed(allTeamMembers), true, "all team members tab not displayed");
		//for list checking, create one new team member and then check if it is present or not.
		log.info("all team members list: " + getTextList(allTeamMembersList));
		log.info("pending invites sub tab is present: " + isDisplayed(pendingInvites));
		sa.assertEquals(isDisplayed(pendingInvites), true, "pending invites tab not displayed");
		click(pendingInvites);
		//for list checking, create one new team member and then don't send invite and check if it is present or not.
		log.info("pending invites list: " + getTextList(pendingInvitesList));
		log.info("send email sub tab is present: " + isDisplayed(sendEmail));
		sa.assertEquals(isDisplayed(sendEmail), true, "send email tab not displayed");
		click(sendEmail);
		log.info("send email box is present: " + isDisplayed(sendEmailBox));
		sa.assertEquals(isDisplayed(sendEmailBox), true, "send email box not displayed");
		log.info("send email to dropdown/field present: " + isDisplayed(sendEmailTo));
		sa.assertEquals(isDisplayed(sendEmailTo), true, "send email to not displayed");
		log.info("send email title field present: " + isDisplayed(sendEmailTitle));
		sa.assertEquals(isDisplayed(sendEmailTitle), true, "send email title not displayed");
		By iframe = By.xpath("//iframe");
		driver.switchTo().frame(driver.findElement(iframe));
		log.info("send email body field present: " + isDisplayed(sendEmailBody));
		sa.assertEquals(isDisplayed(sendEmailBody), true, "send email body not displayed");
		driver.switchTo().defaultContent();
		log.info("send email send button present: " + isDisplayed(sendEmailSendButton));
		sa.assertEquals(isDisplayed(sendEmailSendButton), true, "send email send button not displayed");
		log.info("send email cancel button present: " + isDisplayed(sendEmailCancelButton));
		sa.assertEquals(isDisplayed(sendEmailCancelButton), true, "send email cancel button not displayed");
		log.info("send email attach file button present: " + isDisplayed(sendEmailAttachFile));
		sa.assertEquals(isDisplayed(sendEmailAttachFile), true, "send email attach file button not displayed");
		log.info("add new team member button is present: " + isDisplayed(addNewTeamMember));
		sa.assertEquals(isDisplayed(addNewTeamMember), true, "add new team member button not displayed");
		click(addNewTeamMember);
		log.info("invite button is present: " + isDisplayed(inviteButton));
		sa.assertEquals(isDisplayed(inviteButton), true, "invite button not displayed");
		log.info("create tab is present: " + isDisplayed(createTab));
		sa.assertEquals(isDisplayed(createTab), true, "create button not displayed");
		sa.assertAll();
		log.info("Hence, team members tab is verified");
	}
	
	//Verify the functionality of the "Create" tab.
	public void verifyCreateTab() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		click(addNewTeamMember);
		click(createTab);
		log.info("first name field present: " + isDisplayed(createFirstName));
		sa.assertEquals(isDisplayed(createFirstName), true, "first name field not visible");
		log.info("last name field present: " + isDisplayed(createLastName));
		sa.assertEquals(isDisplayed(createLastName), true, "last name field not visible");
		log.info("email field present: " + isDisplayed(createEmail));
		sa.assertEquals(isDisplayed(createEmail), true, "email field not visible");
		log.info("phone number field present: " + isDisplayed(createPhoneNumber));
		sa.assertEquals(isDisplayed(createPhoneNumber), true, "phone number field not visible");
		log.info("role dropdown present: " + isDisplayed(createRole));
		sa.assertEquals(isDisplayed(createRole), true, "role dropdown not visible");
		log.info("create button present: " + isDisplayed(createButton));
		sa.assertEquals(isDisplayed(createButton), true, "create button not visible");
		sa.assertAll();
		log.info("Hence, create tab is verified");
	}
	
	//Verify the functionality of the "First" and "Last" name fields.
	public void verifyFirstName() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		click(addNewTeamMember);
		click(createTab);
		log.info("first name field present: " + isDisplayed(createFirstName));
		sa.assertEquals(isDisplayed(createFirstName), true, "first name field not visible");
		log.info("passing blank input...");
		setFirstName("");
		click(createButton);
		sa.assertEquals(getFirstName(),"", "first name not matching");
		log.info("error is: " + getText(createFirstNameError));
		sa.assertEquals(getText(createFirstNameError), "First_name is required", "first name error not matching");
		log.info("passing proper first name as input...");
		setFirstName("Test first name");
		sa.assertEquals(getFirstName(),"Test first name", "first name not matching");
		sa.assertFalse(isDisplayed(createFirstNameError), "error displayed even after passing valid input");
		sa.assertAll();
	}
	
	//Verify the functionality of the "First" and "Last" name fields.
	public void verifyLastName() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		click(addNewTeamMember);
		click(createTab);
		log.info("last name field present: " + isDisplayed(createLastName));
		sa.assertEquals(isDisplayed(createLastName), true, "last name field not visible");
		log.info("passing blank input...");
		setLastName("");
		click(createButton);
		sa.assertEquals(getLastName(),"", "last name not matching");
		log.info("error is: " + getText(createLastNameError));
		sa.assertEquals(getText(createLastNameError), "Last_name is required", "last name error not matching");
		log.info("passing proper last name as input...");
		setLastName("Test last name");
		sa.assertEquals(getLastName(),"Test last name", "last name not matching");
		sa.assertFalse(isDisplayed(createLastNameError), "error displayed even after passing valid input");
		sa.assertAll();
	}
	//Verify the functionality of the "Email" field.
	public void verifyCreateEmail() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		click(addNewTeamMember);
		click(createTab);
		log.info("email field present: " + isDisplayed(createEmail));
		sa.assertEquals(isDisplayed(createEmail), true, "email field not visible");
		log.info("passing blank input...");
		setEmail("");
		click(createButton);
		sa.assertEquals(getEmail(),"", "email not matching");
		log.info("error is: " + getText(createEmailError));
		sa.assertEquals(getText(createEmailError), "User_email is required", "email required error not matching");
		log.info("passing invalid email...");
		setEmail("abc123.in");
		sa.assertEquals(getEmail(),"abc123.in", "email not matching");
		log.info("error is: " + getText(createEmailError));
		sa.assertEquals(getText(createEmailError), "Please enter valid email", "email not valid error not matching");
		log.info("passing proper input...");
		setEmail("test@gmail.com");
		sa.assertEquals(getEmail(),"test@gmail.com", "email not matching");
		sa.assertFalse(isDisplayed(createEmailError), "email error visible even after passing valid input");
		sa.assertAll();
	}
	
	public void verifyCreatePhoneNumber() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		click(addNewTeamMember);
		click(createTab);
		log.info("phone number field present: " + isDisplayed(createPhoneNumber));
		sa.assertEquals(isDisplayed(createPhoneNumber), true, "phone number field not visible");
		log.info("passing blank input...");
		setCreatePhoneNumber("");
		click(createButton);
		sa.assertEquals(getCreatePhoneNumber(),"", "phone number not empty");
		log.info("error is: " + getText(createPhoneNumberError));
		sa.assertEquals(getText(createPhoneNumberError), "Phone is required", "phone required error not visible");
	    log.info("passing greater than 10 digit number...");
	    setCreatePhoneNumber("12345678901111");
	    sa.assertEquals(getCreatePhoneNumber(),"12345678901111", "phone number not matching");
	    log.info("error is: " + getText(createPhoneNumberError));
		sa.assertEquals(getText(createPhoneNumberError), "Please enter valid mobile number.", "phone length error not visible");
	    log.info("passing characters...");
	    setCreatePhoneNumber("abcdtest");
	    sa.assertEquals(getCreatePhoneNumber(),"abcdtest", "phone number not matching");
	    log.info("error is: " + getText(createPhoneNumberError));
		sa.assertEquals(getText(createPhoneNumberError), "Please enter digits.", "enter digits error not visible");
		log.info("passing proper input...");
		setCreatePhoneNumber("1234567890");
		sa.assertEquals(getCreatePhoneNumber(),"1234567890", "phone number not matching");
		sa.assertFalse(isDisplayed(createPhoneNumberError), "error displayed even after passing valid input");
		sa.assertAll();
	}
	
	public void verifyCreateRole() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		click(addNewTeamMember);
		click(createTab);
		log.info("role dropdown present: " + isDisplayed(createRole));
		sa.assertEquals(isDisplayed(createRole), true, "role dropdown not visible");
		log.info("selecting no role...");
		//setCreateRole("");
		click(createButton);
		sa.assertEquals(getCreateRole(),"Select", "role not empty");
		log.info("error is: " + getText(createRoleError));
		sa.assertEquals(getText(createRoleError), "User_roles is required", "role required error not matching");
		log.info("selecting a role...");
		setCreateRole("Principal Identity Consultant");
		sa.assertEquals(getCreateRole(),"Principal Identity Consultant", "role not empty");
		sa.assertAll();
	}
	
	public void verifyNewTeamMemberPopupCancelButton() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		click(addNewTeamMember);
		click(createTab);
		log.info("popup displayed: " + isDisplayed(newTeamMemberPopup));
		sa.assertTrue(isDisplayed(newTeamMemberPopup),"popup not displayed");
		log.info("cancel button displayed: " + isDisplayed(cancelButton));
		sa.assertTrue(isDisplayed(cancelButton), "cancel button not displayed in popup");
		log.info("clicking on cancel button...");
		click(cancelButton);
		while(isDisplayed((newTeamMemberPopup))){
			//log.info("waiting for invisibilty of popup...");
		}
		sa.assertFalse(isDisplayed(newTeamMemberPopup),"popup displayed even after clicking cancel button");
		log.info("popup displayed: " + isDisplayed(newTeamMemberPopup));
		sa.assertAll();
	}
	

	public void verifyNewTeamMemberPopupCloseButton() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		click(addNewTeamMember);
		click(createTab);
		sa.assertTrue(isDisplayed(newTeamMemberPopup),"popup not displayed");
		log.info("popup displayed: " + isDisplayed(newTeamMemberPopup));
		sa.assertTrue(isDisplayed(popupCloseButton), "cancel button not displayed in popup");
		log.info("close button displayed: " + isDisplayed(popupCloseButton));
		log.info("clicking on close button...");
		click(popupCloseButton);
		while(isDisplayed((newTeamMemberPopup))){
			//log.info("waiting for invisibilty of popup...");
		}
		sa.assertFalse(isDisplayed(newTeamMemberPopup),"popup displayed even after clicking cancel button");
		log.info("popup displayed: " + isDisplayed(newTeamMemberPopup));
		sa.assertAll();
	}
	
	public void verifyInviteTab() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		click(addNewTeamMember);
		click(inviteButton);
		log.info("role dropdown present: " + isDisplayed(createRole));
		sa.assertEquals(isDisplayed(createRole), true, "role dropdown not visible");
		log.info("send invite to field present: " + isDisplayed(sendInviteTo));
		sa.assertEquals(isDisplayed(sendInviteTo), true, "send invite to field not visible");
		sa.assertAll();
		log.info("Hence, invite tab is verified");
	}
	
	//Verify the functionality of the "Send Invite To" field.
	public void verifySendInviteToField() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		click(addNewTeamMember);
		click(inviteButton);
	/*	log.info("passing empty input...");
		//setSendInviteToField("");
		click(sendInviteButton);
		sa.assertTrue(verifyPopup("Add at least one email"), "check popup");
		sa.assertEquals(getSendInviteToField(),"", "field not empty");
		log.info("passing invalid email...");
		setSendInviteToField("abc@");
		sa.assertEquals(getText(sendInviteToError), "Please enter valid email","invalid email error not matching");
		//sa.assertEquals(getSendInviteToField(),"abc@", "field not having appropriate input");*/
		log.info("passing proper email as input...");
		setSendInviteToField("Test@gmail.com");
		sa.assertEquals(getSendInviteToField(),"Test@gmail.com", "email not matching");
	//	sa.assertFalse(isDisplayed(sendInviteToError), "error displayed even after passing valid input");
		log.info("passing second proper email as input...");
		setSendInviteToField("Test2@gmail.com");
		sa.assertTrue(getSendInviteToField().contains("Test2@gmail.com"), "email2 not matching");
	//	sa.assertFalse(isDisplayed(sendInviteToError), "error displayed even after passing valid input");
		log.info("clearing one email using cross button...");
		click(emailCrossButton);
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sa.assertFalse(getSendInviteToField().contains("Test2@gmail.com"),"email2 visible even after clicking cross button");
		sa.assertAll();
		
	}
	
	public void verifyAllTeamMembersTabFunctionality() {
		log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
		createNewTeamMember();
		log.info("first name on card: " + getTextList(firstNameOnCard).get(0));
		By edit = By.xpath("//tr[@data-job_id='job_id_62cff440a4f7eb8b39fed495']/td[4]/div/span");
	//	click(editButtonOnCard);
		log.info(getFirstName());
		
		
	}
	
   public void verifyPendingInvitesTabFunctionality() {
		
	}
   
   public void verifySendEmailTabFunctionality() {
	   log.info("navigating to Company tab...");
		click(companyTab);
		log.info("Team members tab is present: " +  isDisplayed(TeamMembersTab));
		click(teamMembersTab);
	}
	
	public void setCompanyDetails() {
		click(companyTab);
		click(companySettingsAddButton);
		setCompanyName("Test Company Name 1234");
		setCompanyDesc("Company desc test1234");
		setPhoneNumber("1234567890");
		setCity("Mumbai");
		setZipcode("401109");
		setCountry("Brazil");
		setState("Bahia");
		setDomain("www.test.com");
	}
	
	public void setCompanyName(String companyName) {
		log.info("entering input in add company name field: " + companyName);
		sendKeys(addCompanyName, companyName);
	}
	
	public String getCompanyName() {
		log.info("text in add company name field: " + getAttribute(addCompanyName, "value"));
		return getAttribute(addCompanyName, "value");
	}
	
	public void setCompanyDesc(String companyDesc) {
		
		log.info("entering input in add company desc field:" + companyDesc);
		sendKeys(addCompanyDesc, companyDesc);
	}
	
	public String getCompanyDesc() {
		log.info("text in add company desc field: " + getAttribute(addCompanyDesc, "value"));	
		return getAttribute(addCompanyDesc, "value");
	}
	
	public void setPhoneNumber(String phoneNumber) {
		log.info("entering value in phone no. field: " + phoneNumber);
		sendKeys(addPhoneNumber, phoneNumber);
		sendKeys(addPhoneNumber, Keys.ENTER);
	}
	
	public List<String> getPhoneNumber() {
		log.info("text in add phone number field: " + getTextList(addedPhoneNumber));	
		return getTextList(addedPhoneNumber);
	}
	
	public void setCity(String city) {
		log.info("entering value in city field: " + city);
		sendKeys(addCity, city);
	}
	
	public String getCity() {
		log.info("text in add city field is: " + getAttribute(addCity, "value"));
		return getAttribute(addCity, "value");
	}
	
	public void setZipcode(String zipCode) {
		log.info("entering value in zip code field: " + zipCode);
		sendKeys(addZipCode, zipCode);
	}
	
	public String getZipcode() {
		log.info("text in add zip code field: " + getAttribute(addZipCode, "value"));
		return  getAttribute(addZipCode, "value");
	}
	
	public void setCountry(String country) {
		click(countryDrpButton);
         for(WebElement e:countryDrpOptions) {
       	 if(getText(e).contains(country)) {
       		 click(e);
       		 break;
       	 }
        }
	}
	
	public String getCountry() {
		log.info("Selected country: " + getText(countryDrpField));
		return getText(countryDrpField);
	}
	
	public void setState(String state) {
		click(stateDrpButton);
        for(WebElement e:stateDrpOptions) {
       	 if(getText(e).contains(state)) {
       		 click(e);
       		 break;
       	 }
        }
	}
	
	public String getState() {
		 log.info("Selected state: " + getText(stateDrpField));
		 return getText(stateDrpField);
	}
	
	public void setDomain(String domain) {
		log.info("entering value in domain field: " + domain);
		sendKeys(addDomain, domain);
	}
	
	public String getDomain() {
		log.info("text in add domain field: " + getAttribute(addDomain, "value"));	
		return getAttribute(addDomain, "value");
	}
	
	public void setFirstName(String firstName) {
		log.info("entering value in first name field: " + firstName);
		sendKeys(createFirstName, firstName);
	}
	
	public String getFirstName() {
		log.info("text in first name field: " + getAttribute(createFirstName, "value"));	
		return getAttribute(createFirstName, "value");
	}
	
	public void setLastName(String lastName) {
		log.info("entering value in last name field: " + lastName);
		sendKeys(createLastName, lastName);
	}
	
	public String getLastName() {
		log.info("text in last name field: " + getAttribute(createLastName, "value"));	
		return getAttribute(createLastName, "value");
	}
	
	public void setEmail(String email) {
		log.info("entering value in email field: " + email);
		sendKeys(createEmail, email);
	}
	
	public String getEmail() {
		log.info("text in email field: " + getAttribute(createEmail, "value"));	
		return getAttribute(createEmail, "value");
	}
	
	public void setCreatePhoneNumber(String phone) {
		log.info("entering value in phone number field: " + phone);
		sendKeys(createPhoneNumber, phone);
	}
	
	public String getCreatePhoneNumber() {
		log.info("text in phone number field: " + getAttribute(createPhoneNumber, "value"));	
		return getAttribute(createPhoneNumber, "value");
	}
	
	public void setCreateRole(String role) {
		click(createRole);
		wait.forAllElementToBeVisible(roleOptions);
        for(WebElement e:roleOptions) {
      	 if(getText(e).contains(role)) {
      		 click(e);
      		 break;
      	 }
       }
	}
	
	public String getCreateRole() {
		log.info("Selected role: " + getText(createRole));
		return getText(createRole);
	}
	
	public void setSendInviteToField(String inviteTo) {
		log.info("entering value in send invite field: " + inviteTo);
		sendKeys(sendInviteTo, inviteTo);
		sendKeys(sendInviteTo, Keys.ENTER);
	}
	

	public String getSendInviteToField() {
		log.info("value passed to the field: " + getText(sendInviteToField));
		return getText(sendInviteToField);
	}
	
	public boolean verifyPopup(String expectedText) {
		boolean flag = false;
		log.info("Text present in popup :" + getText(alert));
		if (getText(alert).contains(expectedText))
			flag = true;
		click(closePopup);
		return flag;
	}
	
	public void createNewTeamMember() {
		click(addNewTeamMember);
		click(createTab);
		setFirstName("TestFirstName");
		setLastName("TestLastName");
		setEmail("test1@gmail.com");
		setCreatePhoneNumber("1234567890");
		setCreateRole("Principal Identity Consultant");
		click(createButton);
		
	}
	
	}

