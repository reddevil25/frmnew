package PojoClasses;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;


public class ScreeningQuestionsTemplatePojo {
	
	Faker fake = new Faker(new Locale("en-IND"));
	private String temp_name;
	private List<Screening> screening ;

	
	public String getTemp_name() {
		return temp_name;
	}

	public void setTemp_name() {
		this.temp_name = "ScreenTemp_"+fake.numerify("##")+"_RestAssured";
	}

	public List<Screening> getScreening() {
		return screening;
	}

	public void setScreening(List<Screening> screening) {
		this.screening = screening;
	}
	
	
	
	
	public static class Screening{
		Faker fake = new Faker(new Locale("en-IND"));
		Random rand = new Random();
		String[] anstype = new String[] { "single", "multiple", "radio", "dropdown", };


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
			question_name = "What is "+fake.letterify("??????");
		}
		public String getAns_type() {
			return ans_type;
		}
		public void setAns_type() {
			ans_type=anstype[rand.nextInt(4)]; 
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
