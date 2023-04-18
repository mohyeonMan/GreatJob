package comment.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import comment.dao.CommentDAO;

public class RollBackCommentService implements CommentService{
	@Autowired
	private Map<String, CommentDAO> commentDAO;
	
	@Override
	public String execute(Map<String, Object> map) {
		CommentDAO dao = commentDAO.get("commentDAOMyBatis");
		JSONObject object = new JSONObject();
		int status = 200;
		
		if(map.get("id") != null) {
			dao.rollBack((int)map.get("id"));			
		}else {
			status = 400;
		}
		
		object.put("status", status);
		
		return object.toString();
	}

}
