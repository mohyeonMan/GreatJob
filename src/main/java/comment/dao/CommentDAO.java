package comment.dao;

import java.util.List;

import comment.bean.CommentDTO;

public interface CommentDAO {

	void create(CommentDTO comment);

	CommentDTO getComment(int parentId);

	List<CommentDTO> listComments(CommentDTO comment);

}
