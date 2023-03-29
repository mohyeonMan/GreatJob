package user.bean;

import java.sql.Date;

import lombok.Data;

@Data
public class UserDTO {
	
	private int id;
	private String userId;
	private String password;
	private String imageUrl;
	private String name;
	private String[] interests;
	private String description;
	private int point;
	private String email;
	private String phone;
	private String address;
	private int reported;
	private Date dateCreated;
	private int type;
	
	
	public String getInterests() {
		String interestString= "";
		for(String item : this.interests) {
			interestString+=item+",";
		}
		return interestString.substring(0,interestString.length()-1);
	}
	public String[] getInterestsArray() {
		return this.interests;
	}
	
	public void setInterests(String interestString) {
		this.interests = interestString.split(",");
	}
	
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
}
