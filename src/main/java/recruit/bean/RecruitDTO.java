package recruit.bean;

import java.sql.Date;


import lombok.Data;

@Data
public class RecruitDTO {
	
	private int id;
	private String title;
	private String description;
	private int categoryId;
	private String categoryName;
	private Date dateStart;
	private Date dateEnd;
	private String host;
	private int userId;
	private String userName;
	private int maxPersonnel;
	private int currentPersonnel;
	private String address;
	private Date dateCreated;
	private Date dateModified;
}
