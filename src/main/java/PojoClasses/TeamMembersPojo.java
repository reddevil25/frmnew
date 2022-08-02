package PojoClasses;

import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

public class TeamMembersPojo {
	
	
	
	private List<TeamMembers> team_members;
	

	public List<TeamMembers> getTeam_members() {
		return team_members;
	}

	public void setTeam_members(List<TeamMembers> team_members) {
		this.team_members = team_members;
	}
	
	
	
	
	
	public static class TeamMembers{
		
		Faker fake = new Faker(new Locale("en-IND"));
		String Name= fake.name().fullName();
		
		private String userid;
		private String name;
		private String user_email;
		private String role;
		public String getUserid() {
			return userid;
		}
		public void setUserid() {
			this.userid = fake.bothify("????###?#?#????????");
		}
		public String getName() {
			return name;
		}
		public void setName() {
			this.name = Name;
		}
		public String getUser_email() {
			return user_email;
		}
		public void setUser_email() {
			this.user_email = Name.replace(" ", "")+"@"+fake.letterify("????")+".com";
		}
		public String getRole() {
			return role;
		}
		public void setRole() {
			this.role = fake.letterify("??");
		}
		
		
		
	}





	

}
