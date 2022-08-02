package PojoClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import com.github.javafaker.Faker;
//import com.sun.tools.sjavac.Log;



public class AddCandidateManuallyPojo {
//	private List<Candidate_Stage> applied_jobs;
	
	private List<String> jobs = new ArrayList<>();

	private List<String> email = new ArrayList<>();
	private String fullname;
	private Map<String,Object> location = new HashMap<String,Object>();
	private List<String> skills = new ArrayList<>();
	private List<String> tags = new ArrayList<>();
	
	private List<String> mobile = new ArrayList<>();
	private List<String> social = new ArrayList<>();
	private List<String> source = new ArrayList<>();
//	private String[]profile_fields= new String[3];
	private String profile_pic;
//	private List<Assets>assets;
	private List<String> links = new ArrayList<>();
	Random rand = new Random();
	Faker fake = new Faker(new Locale("en-IND"));

	
//	public List<Candidate_Stage> getCandidate_stage() {
//		return applied_jobs;
//	}
//
//	public void setCandidate_stage(List<Candidate_Stage> candidate_stage) {
//		this.applied_jobs = candidate_stage;
//	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail() {
	email.add(fake.internet().emailAddress());
	email.add(fake.internet().emailAddress());

	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname() {
		
		fullname = fake.name().fullName()+" Selenium";
	}

	public Map<String, Object> getLocation() {
		return location;
	}

	public void setLocation() {
		String[] countries = new String[] { "India", "China","Germany","United States","Japan" };
		String[] states= new String [5];

		int index1 = rand.nextInt(5);
		int index2 = rand.nextInt(5);
		String country = countries[index1];
		if (country.equalsIgnoreCase("india"))
		{
			states = new String[] { "Goa", "Assam", "Bihar", "Maharashtra", "Telangana" };
		}else if (country.equalsIgnoreCase("china"))
		{
			states = new String[] { "Beijing", "Guizhou", "Henan", "Jiangsu", "Macau" };
		}else if (country.equalsIgnoreCase("germany"))
		{
			states = new String[] { "Berlin", "Hesse", "Saxony", "Bavaria", "Mecklenburg-Vorpommern" };
		}else if (country.equalsIgnoreCase("United States"))
		{
			states = new String[] { "District of Columbia", "Florida", "Idaho", "Massachusetts", "New Mexico" };
		}else if (country.equalsIgnoreCase("Japan"))
		{
			states = new String[] { "Aomori Prefecture", "Hiroshima Prefecture", "Iwate Prefecture", "Nagasaki Prefecture", "Saitama Prefecture" };
		}

		
		location.put("country_name", country);
		location.put("state_name", states[index2]);
		location.put("city", fake.address().cityName());
		location.put("pincode", fake.address().zipCode());
		location.put("address", fake.address().fullAddress());
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills() {
		String[] skill = new String[] {"C++","C#","Ruby","HTML","Selenium","RESTAPI","Java","python","Appium"};
		for(int i =0;i<3;i++)
		{
			skills.add(skill[rand.nextInt(9)]);
		}
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags() {
		String[] tag = new String[] {"junior tester","tag1","fresher","experienced","automation","manual","Java","python","Appium"};
		for(int i =0;i<3;i++)
		{
			tags.add(tag[rand.nextInt(9)]);
		}

	}

	public List<String> getMobile() {
		return mobile;
	}

	public void setMobile() {
		mobile.add(fake.numerify("##########"));
		mobile.add(fake.numerify("##########"));
	}

	public List<String> getSocial() {
		return social;
	}

	public void setSocial() {
		String[] tag = new String[] {"indeed","LinkedIn","Facebook","Twitter"};
		for(int i =0;i<2;i++)
		{
			social.add(tag[rand.nextInt(4)]);
		}
}

	public List<String> getSource() {
		return source;
	}

	public void setSource() {
		source.add(fake.letterify("??????"));
		source.add(fake.letterify("??????"));
	}

//	public String[] getProfile_fields() {
//		return profile_fields;
//	}

//	public void setProfile_fields() {
//		this.profile_fields[0] = "Address : "+fake.address().fullAddress();
//		this.profile_fields[1] = "Birth date : "+fake.date().birthday().toString();
//		this.profile_fields[2] = "Gender : "+fake.bothify("??");
//
//	}

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic() {
		this.profile_pic = "https://picsum.photos/25/25";
	}

//	public List<Assets> getAssets() {
//		return assets;
//	}

//	public void setAssets(List<Assets> assets) {
//		this.assets = assets;
//	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks() {
		links.add(fake.internet().url());
		links.add(fake.internet().url());
	}

	public List<String> getJobs() {
		return jobs;
	}

	public void setJobs(String job) {
		jobs.add(job);
	}

//	
//
//	public static class Candidate_Stage{
//		Random rand = new Random();
//
//		private String job_id;
//		private String stage;
//		public String getJob_id() {
//			return job_id;
//		}
//		public void setJob_id(String jobid) {
//			
//			
//			this.job_id = jobid;
//		}
//		public String getStage() {
//			return stage;
//		}
//		public void setStage() {
//			int index = rand.nextInt(5);
//			String[] stages = new String[] {"applied","shortlisted","schedule","qualified","rejected"};
//			this.stage = stages[index];
//		}
//		
//	}
	
//	public static class Assets{
//		
//		
//		private String url;
//		private String type;
//		public String getUrl() {
//			return url;
//		}
//		public void setUrl(String url) {
//			this.url = url;
//		}
//		public String getType() {
//			return type;
//		}
//		public void setType(String type) {
//			this.type = type;
//		}
//		
//	}
	
	public static class AddCandidate {
		
		public static AddCandidateManuallyPojo addCandidate() {
			
			AddCandidateManuallyPojo cand = new AddCandidateManuallyPojo();
			
					cand.setFullname();
					cand.setTags();
					cand.setMobile();
					cand.setEmail();
					cand.setLinks();
					cand.setSocial();
					cand.setSource();
					cand.setSkills();
					cand.setLocation();
										
					return cand;
		}
		
		
		
		
	}
}
