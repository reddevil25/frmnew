package PojoClasses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import com.github.javafaker.Faker;
//import com.sun.tools.sjavac.Log;

public class CreateCandidatePojo {
//	private List<Candidate_Stage> applied_jobs;
	Random rand = new Random();
	Faker fake = new Faker(new Locale("en-IND"));

	private String candId;
	private List<String> jobs = new ArrayList<>();
	private String profile_pic;
	private String fullname;
	private List<String> tags = new ArrayList<>();
	private List<String> mobile = new ArrayList<>();
	private List<String> email = new ArrayList<>();
	private List<String> links = new ArrayList<>();
	private List<String> social = new ArrayList<>();
	private List<String> skills = new ArrayList<>();
	private List<String> source = new ArrayList<>();

	private String currentCTC;

	private Map<String, String> location = new HashMap<String, String>();
	private String createdOnForGrid;
	private String createdOnForCard;

	private String resumeId;
	private String resumeName;
	private String docId;
	private String docName;
	private String noteTitle;
	private String noteDesc;
	private String popupMsg;
//	private String[]profile_fields= new String[3];
//	private List<Assets>assets;

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String id) {
		this.profile_pic = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname() {
		fullname = fake.name().fullName().replaceAll("I", "");
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags() {
		String[] tag1 = new String[] { "junior tester", "tag1", "fresher", };
		String[] tag2 = new String[] { "experienced", "automation", "manual" };
		String[] tag3 = new String[] { "Java", "python", "Appium" };
		tags.add(tag1[rand.nextInt(3)]);
		tags.add(tag2[rand.nextInt(3)]);
		tags.add(tag3[rand.nextInt(3)]);
	}

	public List<String> getMobile() {
		return mobile;
	}

	public void setMobile() {
		mobile.add(fake.numerify("##########"));
		mobile.add(fake.numerify("##########"));
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail() {
		email.add(fake.internet().emailAddress());
		email.add(fake.internet().emailAddress());

	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks() {
		links.add(fake.internet().url());
		links.add(fake.internet().url());
		links.add(fake.internet().url());
	}

	public List<String> getSocial() {
		return social;
	}

	public void setSocial() {
		String[] socials = new String[] { "indeed", "LinkedIn", "Facebook", "Twitter" };

		social.add(socials[1]);
		social.add(socials[2]);
		social.add(socials[3]);
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills() {
		String[] skill1 = new String[] { "C++", "C#", "Ruby" };
		String[] skill2 = new String[] { "HTML", "Selenium", "RESTAPI" };
		String[] skill3 = new String[] { "Java", "python", "Appium" };
		skills.add(skill1[rand.nextInt(3)]);
		skills.add(skill2[rand.nextInt(3)]);
		skills.add(skill3[rand.nextInt(3)]);
	}

	public List<String> getSource() {
		return source;
	}

	public void setSource() {
		source.add(fake.letterify("??????"));
		source.add(fake.letterify("??????"));
		source.add(fake.letterify("??????"));

	}

	/**
	 * 
	 * @return returns HashMap having keys "country_name","state_name,","city","pincode","address" and their respective values
	 */
	public Map<String, String> getLocation() {
		return location;
	}

	public void setLocation() {
		String[] countries = new String[] { "Pakistan", "China", "Germany", "United States", "Japan" };
		String[] states = new String[5];
		int index1 = rand.nextInt(5);
		int index2 = rand.nextInt(5);
		String country = countries[index1];
		if (country.equalsIgnoreCase("Pakistan")) {
			states = new String[] { "Punjab", "Azad Kashmir", "Gilgit-Baltistan", "Khyber Pakhtunkhwa", "Sindh" };
//			statescodes = new String[] { "GA", "AS", "BR", "MH", "TG" };
		} else if (country.equalsIgnoreCase("china")) {
			states = new String[] { "Beijing", "Guizhou", "Henan", "Jiangsu", "Macau" };
		} else if (country.equalsIgnoreCase("germany")) {
			states = new String[] { "Berlin", "Hesse", "Saxony", "Bavaria", "Mecklenburg-Vorpommern" };
		} else if (country.equalsIgnoreCase("United States")) {
			states = new String[] { "District of Columbia", "Florida", "Idaho", "Massachusetts", "New Mexico" };
		} else if (country.equalsIgnoreCase("Japan")) {
			states = new String[] { "Aomori Prefecture", "Hiroshima Prefecture", "Iwate Prefecture",
					"Nagasaki Prefecture", "Saitama Prefecture" };
		}

		location.put("country_name", country);
		location.put("state_name", states[index2]);
		location.put("city", fake.address().cityName());
		location.put("pincode", fake.address().zipCode());
		location.put("address", fake.address().fullAddress());
	}
	
	
		public String getCurrentCTC() {
		return currentCTC;
	}

	public void setCurrentCTC() {
		this.currentCTC = fake.numerify("##");
	}

	public String getCandId() {
		return candId;
	}

	public void setCandId(String candId) {
		this.candId = candId;
	}

	public List<String> getJobs() {
		return jobs;
	}

	public void setJobs(List<String> jobs) {
		this.jobs = jobs;
	}

	public String getCreatedOnForGrid() {
		return createdOnForGrid;
	}

	public void setCreatedOnForGird() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);
		this.createdOnForGrid = currentDate;
	}

	public String getCreatedOnForCard() {
		return createdOnForCard;
	}

	public void setCreatedOnForCard() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);
		this.createdOnForCard = currentDate.toLowerCase();
	}

	public String getResumeId() {
		return resumeId;
	}

	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteDesc() {
		return noteDesc;
	}

	public void setNoteDesc(String noteDesc) {
		this.noteDesc = noteDesc;
	}

	public String getPopupMsg() {
		return popupMsg;
	}

	public void setPopupMsg(String popupMsg) {
		this.popupMsg = popupMsg;
	}

}
