package comment.dao;

import comment.bean.CommentDTO;

public interface CommentDAO {

	void create(CommentDTO comment);

	CommentDTO getComment(int parentId);

}
