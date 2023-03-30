package recruit.bean;

import java.sql.Date;


import lombok.Data;

@Data
public class RecruitDTO {
	
	private int id;
	private String title;
	private String description;
	private int categoryId;
	private Date dateStart;
	private Date dateEnd;
	private String host;
	private int userId;
	private int maxpPersonnel;
	private int currentPersonnel;
}
