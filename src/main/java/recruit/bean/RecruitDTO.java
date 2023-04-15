package recruit.bean;

import lombok.Data;

@Data
public class RecruitDTO {

	private int id;
	private int rn;
	private String title;
	private String description;
	private int categoryId;
	private String categoryName;
	private long dateStart = 1;
	private long dateEnd = 1;
	private String host;
	private int userId;
	private String userName;
	private int maxPersonnel;
	private int currentPersonnel;
	private String address;
	private long dateCreated = 1;
	private long dateModified = 1;

}
