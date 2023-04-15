package comment.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comment.dao.CommentDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListCommentsService implements CommentService{
	@Autowired
	private Map<String, CommentDAO> commentDAO;

	@Override
	public String execute(Map<String, Object> map) {
		CommentDAO dao = commentDAO.get("commentDAOMyBatis");
		JSONObject object = new JSONObject();
		
		
		
		return null;
	}

}
