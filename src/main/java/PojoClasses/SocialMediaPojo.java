package PojoClasses;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.github.javafaker.Faker;

public class SocialMediaPojo {
	Faker fake = new Faker(new Locale("en-IND"));
	
	
	private Map<String,String> social_media_info = new HashMap<>(); 
		public Map<String,String> getSocial_media_info() {
		return social_media_info;
	}
	public void setSocial_media_info() {
		social_media_info.put("title", "RestAssured Social Title "+fake.letterify("??????????"));
		social_media_info.put("description", "RestAssured Social Title "+fake.letterify("??????????"));
		social_media_info.put("image", "http://placeimg.com/640/480");

	}
	
	

}
