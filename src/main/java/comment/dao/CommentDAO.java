package comment.dao;

import java.util.List;
import java.util.Map;

import comment.bean.CommentDTO;

public interface CommentDAO {

	void create(CommentDTO comment);

	CommentDTO getMaterialFromParent(int parentId);

	List<CommentDTO> listComments(CommentDTO comment);

	void delete(int id);

	CommentDTO getComment(int id);

	void rollBack(int id);

	void update(CommentDTO comment);

	void objectDeleted(Map<String, Object> map);

}
