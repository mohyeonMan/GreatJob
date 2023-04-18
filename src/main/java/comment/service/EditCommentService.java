package comment.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import comment.bean.CommentDTO;
import comment.dao.CommentDAO;

public class EditCommentService implements CommentService{
	@Autowired
	private Map<String, CommentDAO> commentDAO;
	
	@Override
	public String execute(Map<String, Object> map) {
		CommentDAO dao = commentDAO.get("commentDAOMyBatis");
		JSONObject object = new JSONObject();
		int status = 200;
		
		CommentDTO replaceComment = new CommentDTO();
		if(map.get("id") != null && map.get("description") != null) {
			replaceComment.setId((int)map.get("id"));
			replaceComment.setDescription((String)map.get("description"));
			dao.update(replaceComment);
		}else {
			status = 400;
		}
		
		object.put("status", status);
		
		return object.toString();
	}

}
