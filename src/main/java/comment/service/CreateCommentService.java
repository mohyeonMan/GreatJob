package comment.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comment.bean.CommentDTO;
import comment.dao.CommentDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCommentService implements CommentService{
	@Autowired
	private Map<String, CommentDAO> commentDAO;
	
	@Override
	public String execute(Map<String, Object> map) {
		CommentDAO dao = commentDAO.get("commentDAOMyBatis");
		JSONObject object = new JSONObject();

		CommentDTO comment = new CommentDTO();
		comment.setObject((int)map.get("object"));
		comment.setObjectId((int)map.get("objectId"));
		comment.setUserId((int)map.get("userId"));
		comment.setDescription((String)map.get("description"));
		
		if(map.get("parentId") != null) {
			comment.setParentId((int)map.get("parentId"));
			CommentDTO commentPlace = dao.getComment(comment.getParentId());
			if(commentPlace == null) {
				object.put("status", 400);
				return object.toString();
			}
			comment.setCommentLevel(commentPlace.getCommentLevel());
			comment.setCommentOrder(commentPlace.getCommentOrder());
		}
		
		dao.create(comment);
		object.put("status", 200);
		
		return object.toString();
	}

}
