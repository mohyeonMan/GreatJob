package comment.bean;

import lombok.Data;

@Data
public class CommentDTO {
	private String object;
	private int objectId;
	private int superId;
	private int userId;
	private String userName;
	private String userImageUrl;
	private String description;
	private long dateCreated;
	private long dateModified;
}
