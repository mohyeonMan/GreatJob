package recruit.bean;

import java.sql.Date;


import lombok.Data;

@Data
public class RecruitDTO {
	
	private Date dateStart;
	private String host;
	private String description;
	private int currentPersonnel;
	private Date dateEnd;
	private int id;
	private String title;
	private int categoryId;
	private int userId;
	private int maxpPersonnel;
}
