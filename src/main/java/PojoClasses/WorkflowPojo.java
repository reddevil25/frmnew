package PojoClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import com.github.javafaker.Faker;

public class WorkflowPojo {

	Faker fake = new Faker(new Locale("en-IND"));
	Random rand = new Random();
	private List<Pipelines> pipelines;
	private boolean auto_confirmation_mail;
	private String mail_body;
	private List<ProfileField> profile_field;
	
	
	
	
	
	
	public List<Pipelines> getPipelines() {
		return pipelines;
	}


	public void setPipelines(List<Pipelines> pipelines) {
		this.pipelines = pipelines;
	}


	public boolean getAuto_confirmation_mail() {
		return auto_confirmation_mail;
	}


	public void setAuto_confirmation_mail() {
		auto_confirmation_mail = rand.nextBoolean();
	}


	public String getMail_body() {
		return mail_body;
	}


	public void setMail_body() {
		mail_body = fake.letterify("RestAssuredTestEmail ??????? ?????????? ??????????");
	}


	public List<ProfileField> getProfile_field() {
		return profile_field;
	}


	public void setProfile_field(List<ProfileField> profile_field) {
		this.profile_field = profile_field;
	}
	
	
	public void removeEntry(String type) {

		if (type.equalsIgnoreCase("Stage_name"))
			this.getPipelines().get(0).stage_name="";
		else if (type.equalsIgnoreCase("profile_name"))
			this.getProfile_field().get(0).name="";

	
	}	


	public static class Pipelines{
		
		
		Faker fake = new Faker(new Locale("en-IND"));
		Random rand = new Random();

		
		private int stage_serial;
		private String stage_name;
		private String stage_type;
		private String stage_valid;
		private List<Actions> action;
		private String type;

		String[] stagetype = new String[] { "Apply", "Phone screen", "Interview", "Evaluation","Offer","Hire" };
		String stagename= stagetype[rand.nextInt(6)];
		String[] stagevalid = new String[] { "5","7","14","21"};
		
		public int getStage_serial() {
			return stage_serial;
		}
		public void setStage_serial(int stage_serial) {
			this.stage_serial = stage_serial;
		}
		public String getStage_name() {
			return stage_name;
		}
		public void setStage_name() {
			this.stage_name = stagename + fake.letterify(" Rest_assured ???????");
		}
		public String getStage_type() {
			return stage_type;
		}
		public void setStage_type() {
			this.stage_type = stagename;
		}
		public String getStage_valid() {
			return stage_valid;
		}
		public void setStage_valid() {
			this.stage_valid = stagevalid[rand.nextInt(4)];
		}
		public List<Actions> getAction() {
			return action;
		}
		public void setAction(List<Actions> action) {
			this.action = action;
		}
		public String getType() {
			return type;
		}
		public void setType() {
			this.type = "custom";
		}

		
		
	}
	
	
	public static class Actions {
		Faker fake = new Faker(new Locale("en-IND"));

		private String type;
		private Map<String , String> details=new HashMap<>();
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Map<String , String> getDetails() {
			return details;
		}
		public void setDetails() {
			this.details.put("email", fake.internet().emailAddress());
		}
		
	}
	
	public static class ProfileField{
		
		Random rand = new Random();

		String[] profiletype = new String[] { "yes/no", "single", "multiple", "address","gender","date of birth","nationality","skills" };
		String ptype = profiletype[rand.nextInt(8)];
		private int serial;
		private String name;
		private String type;
		public int getSerial() {
			return serial;
		}
		public void setSerial(int serial) {
			this.serial = serial;
		}
		public String getName() {
			return name;
		}
		public void setName() {
			this.name = "RestAssured_Test-Date "+ptype;
		}
		public String getType() {
			return type;
		}
		public void setType() {
			this.type = ptype;
		}
		
	}
}
