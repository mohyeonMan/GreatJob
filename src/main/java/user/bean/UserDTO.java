package user.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
	
	private int id;
	private String imageUrl;
	private String name;
	private List<Integer> interests;
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
	public List<Integer> getInterestsArray() {
		return this.interests;
	}
	
	public void setInterests(String interestString) {
		String[] stringArr = interestString.split(",");
		List<Integer> list = new ArrayList<>();
		for(String str : stringArr) {
			list.add(Integer.parseInt(str));
		}
		
		this.interests = list;
	}
	
	public void setInterests(List<Integer> interests) {
		this.interests = interests;
	}

}
