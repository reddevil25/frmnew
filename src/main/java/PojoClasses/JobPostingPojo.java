package PojoClasses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;

public class JobPostingPojo {
	Faker fake = new Faker(new Locale("en-IND"));
	Random rand = new Random();

	private String job_title;
	private String job_id;
	private String job_deptname;
	private String job_description;
	private String job_requirement;
	private List<String> job_tag = new ArrayList<String>();
	private Map<String, String> job_location = new HashMap<String, String>();
	private Map<String, String> job_type = new HashMap<String, String>();
	private boolean is_remote;
	private String publish_Date;
	private String expiry_Date;
	private String popupText;

	int deptindex = rand.nextInt(5);
	String job = fake.letterify("JOB_?????????_SeleniumTest");

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title() {
		this.job_title = job;
	}

	public String getJob_deptname() {
		return job_deptname;
	}

	public void setJob_deptname() {
		String[] department = new String[] { "Business", "Human Resource","Marketing" };

		job_deptname = department[rand.nextInt(3)];

	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description() {
		this.job_description = job + " Decription";
	}

	public String getJob_requirement() {
		return job_requirement;
	}

	public void setJob_requirement() {
		this.job_requirement = job + " Requirement";
	}

	public List<String> getJob_tag() {
		return job_tag;
	}

	public void setJob_tag() {
		job_tag.add(fake.letterify("Selenium_Tag" + rand.nextInt(100)));
		job_tag.add(fake.letterify("Selenium_Tag" + rand.nextInt(100)));
		job_tag.add(fake.letterify("Selenium_Tag" + rand.nextInt(100)));
		job_tag.add(fake.letterify("Selenium_Tag" + rand.nextInt(100)));

	}

	public Map<String, String> getJob_location() {
		return job_location;
	}

	public void setJob_location() {
		String[] countries = new String[] { "Pakistan", "China", "Germany", "United States", "Japan" };
		String[] states = new String[5];
		String[] statescodes = new String[5];
		String countrycode = "";

		int index1 = rand.nextInt(5);
		int index2 = rand.nextInt(5);
		String country = countries[index1];
		if (country.equalsIgnoreCase("Pakistan")) {
			countrycode = "PK";
			states = new String[] { "Punjab", "Azad Kashmir", "Gilgit-Baltistan", "Khyber Pakhtunkhwa", "Sindh" };
//			statescodes = new String[] { "GA", "AS", "BR", "MH", "TG" };
		} else if (country.equalsIgnoreCase("china")) {
			countrycode = "CN";
			states = new String[] { "Beijing", "Fujian", "Gansu", "Guangdong", "Guizhou" };
			statescodes = new String[] { "BJ", "GZ", "HA", "JS", "MO" };
		} else if (country.equalsIgnoreCase("germany")) {
			countrycode = "DE";
			states = new String[] { "Berlin", "Hamburg", "Brandenburg", "Bavaria", "Bremen" };
			statescodes = new String[] { "BE", "HE", "SN", "BY", "MV" };
		} else if (country.equalsIgnoreCase("United States")) {
			countrycode = "US";
			states = new String[] { "Alabama", "Alaska", "Arizona", "California", "Colorado" };
			statescodes = new String[] { "DC", "FL", "ID", "MS", "NM" };
		} else if (country.equalsIgnoreCase("Japan")) {
			countrycode = "JP";
			states = new String[] { "Aomori Prefecture", "Chiba Prefecture", "Ehime Prefecture",
					"Fukui Prefecture", "Fukushima Prefecture" };
			statescodes = new String[] { "02", "34", "03", "42", "11" };
		}

		this.job_location.put("country_code", countrycode);
		this.job_location.put("country_name", country);
		this.job_location.put("state_code", statescodes[index2]);
		this.job_location.put("state_name", states[index2]);
		this.job_location.put("city", fake.letterify("??????"));
		this.job_location.put("pincode", fake.address().zipCode());
	}

	public Map<String, String> getJob_type() {
		return job_type;
	}

	public void setJob_type() {
		String[] emptypes = new String[] { "Full time", "Part time" };
		String[] category = new String[] { "Accounting", "Art & Entertainment", "Agriculture", "Category 1", "Category 2" };
		String[] edu = new String[] { "Associates Degree", "Doctorate", "Certification", "Vocational", "Professional" };
		String[] exp = new String[] { "0-1", "1-3", "3-5", "5-8", "8-11" };
		int emptype = rand.nextInt(2);
		int cat = rand.nextInt(5);
		int hours = rand.nextInt(15) + 2;

		this.job_type.put("employement_type", emptypes[emptype]);
		this.job_type.put("category", category[cat]);
		this.job_type.put("category_id", fake.bothify("####???#?#?#?###????"));
		this.job_type.put("education", edu[cat]);
		this.job_type.put("experience", Integer.toString(rand.nextInt(20)));
		this.job_type.put("min_hours", Integer.toString(hours / 2));
		this.job_type.put("max_hours", Integer.toString(hours));
	}

	public boolean getIs_remote() {
		return is_remote;
	}

	public void setIs_remote() {
		this.is_remote = rand.nextBoolean();
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getPublish_Date() {

		return publish_Date;
	}

	public void setPublish_Date() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);
		this.publish_Date = currentDate;
	}

	public String getExpiry_Date() {
		return expiry_Date;
	}

	public void setExpiry_Date() {
		Random randomDays = ThreadLocalRandom.current();
		LocalDateTime date = LocalDateTime.now().plusDays(randomDays.nextInt(365) + 1);
		DateTimeFormatter dtf = DateTimeFormatter .ofPattern("dd-MM-yyyy");
		String expiryDate = dtf.format(date);
		this.expiry_Date = expiryDate;
	}

	public String getPopupText() {
		return popupText;
	}

	public void setPopupText(String popupText) {
		this.popupText = popupText;
	}

	
}
