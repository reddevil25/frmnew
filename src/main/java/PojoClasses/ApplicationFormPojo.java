package PojoClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import com.github.javafaker.Faker;

public class ApplicationFormPojo {

	Faker fake = new Faker(new Locale("en-IND"));
	Random rand = new Random();
	private List<Job_Screening> job_screening;

	private Map<String, Boolean> personal_preference = new HashMap<String, Boolean>();
	private Map<String, Boolean> application_preference = new HashMap<String, Boolean>();

	public Map<String, Boolean> getPersonal_preference() {
		return personal_preference;
	}

	public void setPersonal_preference() {
		personal_preference.put("cv_required", rand.nextBoolean());
		personal_preference.put("cover_letter", rand.nextBoolean());
		personal_preference.put("photo", rand.nextBoolean());
		personal_preference.put("phone", rand.nextBoolean());

	}

	public Map<String, Boolean> getApplication_preference() {
		return application_preference;
	}

	public void setApplication_preference() {
		application_preference.put("linked_in", rand.nextBoolean());
		application_preference.put("indeed", rand.nextBoolean());
		application_preference.put("social_media_share", rand.nextBoolean());
		application_preference.put("job_location_share", rand.nextBoolean());
	}

	public List<Job_Screening> getJob_screening() {
		return job_screening;
	}

	public void setJob_screening(List<Job_Screening> job_screening) {
		this.job_screening = job_screening;
	}

	public void removeEntry(String type) {
		if (type.equalsIgnoreCase("question_name"))
			this.getJob_screening().get(0).question_name = "";
		if (type.equalsIgnoreCase("ans_type"))
			this.getJob_screening().get(0).ans_type = "";
		if (type.equalsIgnoreCase("ans_type_details"))
			this.getJob_screening().get(0).ans_type_details = "";
	}

	public static class Job_Screening {
		Faker fake = new Faker(new Locale("en-IND"));
		Random rand = new Random();
		String[] anstype = new String[] { "single line", "multiple lines", "Yes/No"};

		private int question_no;
		private String question_name;
		private String ans_type;
		private String ans_type_details;
		private boolean is_required;

		public int getQuestion_no() {
			return question_no;
		}

		public void setQuestion_no(int question_no) {
			this.question_no = question_no;
		}

		public String getQuestion_name() {
			return question_name;
		}

		public void setQuestion_name() {
			question_name = "Sel_test_what is " + fake.letterify("??????");
		}

		public String getAns_type() {
			return ans_type;
		}

		public void setAns_type() {
			ans_type = anstype[rand.nextInt(3)];
		}

		public String getAns_type_details() {
			return ans_type_details;
		}

		public void setAns_type_details() {
			ans_type_details = "<input type='text' name='single1'>";
		}

		public boolean getIs_required() {
			return is_required;
		}

		public void setIs_required() {
			is_required = rand.nextBoolean();
		}

	}

}
