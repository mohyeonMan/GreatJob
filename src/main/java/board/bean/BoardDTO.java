package board.bean;

import lombok.Data;

@Data
public class BoardDTO {
	
	private int id;
	private int categoryId;
	private String categoryName;
	private int userId;
	private String userName;
	private String userImageUrl;
	private String title;
	private String description;
	private long dateCreated;
	private long dateModified;
	private int hit;
}
