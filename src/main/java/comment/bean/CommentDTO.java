package comment.bean;

import lombok.Data;

@Data
public class CommentDTO {
	private int object;
	private int objectId;
	private int userId;
	private String userName;
	private String userImageUrl;
	private String description;
	private long dateCreated;
	private long dateModified;
	private String commentOrder = null;
	private int commentLevel = 0;
	private int parentId = 0;
	private int status;
}
