package recruit.bean;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RecruitDTO {

	private int id;
	private String title;
	private String description;
	private int categoryId;
	private String categoryName;
	private Timestamp dateStart;
	private Timestamp dateEnd;
	private String host;
	private int userId;
	private String userName;
	private int maxPersonnel;
	private int currentPersonnel;
	private String address;
	private Timestamp dateCreated;
	private Timestamp dateModified;

	public long getDateStart() {
		return dateStart.getTime();
	}

	public long getDateEnd() {
		return dateEnd.getTime();
	}

	public long getDateCreated() {
		return dateCreated.getTime();
	}

	public long getDateModified() {
		return dateModified.getTime();
	}
}
