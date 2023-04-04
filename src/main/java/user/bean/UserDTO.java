package user.bean;

import java.sql.Timestamp;
import java.util.Iterator;

import lombok.Data;

@Data
public class UserDTO {
	
	private int id;
	private String imageUrl;
	private String name;
	private int[] interests;
	private String description;
	private int point;
	private String email;
	private String phone;
	private String address;
	private int reported;
	private long dateCreated;
	private int type;
	
	
	public String getInterests() {
		if(this.interests == null) {
			return null;
		}else {
			String interestString= "";
			for(int item : this.interests) {
				interestString+=item+",";
			}
			return interestString.substring(0,interestString.length()-1);
		}
	}
	public int[] getInterestsArray() {
		return this.interests;
	}
	
	public void setInterests(String interestString) {
		String[] stringArr = interestString.split(",");
		int[] arr = new int[stringArr.length];
		for(int i=0;i<stringArr.length;i++) {
			arr[i] = Integer.parseInt(stringArr[i]);
		}
		
		this.interests = arr;
	}
	
	public void setInterests(int[] interests) {
		this.interests = interests;
	}

}
