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
	private String interest;
	private String description;
	private int point;
	private String email;
	private String phone;
	private String address;
	private int reported;
	private Date dateCreated;
	private String type;
	
}
