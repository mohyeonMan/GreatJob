package recruit.bean;



import lombok.Data;

@Data
public class RecruitDTO {

	private int id;
	private String title;
	private String description;
	private int categoryId;
	private String categoryName;
	private long dateStart;
	private long dateEnd;
	private String host;
	private int userId;
	private String userName;
	private int maxPersonnel;
	private int currentPersonnel;
	private String address;
	private long dateCreated;
	private long dateModified;
	
//	public long getDateStart() {
//		return dateStart.getTime();
//	}
//
//	public long getDateEnd() {
//		return dateEnd.getTime();
//	}
}
