package comment.service;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comment.bean.CommentDTO;
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
		
		CommentDTO comment = new CommentDTO();
		comment.setObject(Integer.parseInt((String)map.get("object")));
		comment.setObjectId(Integer.parseInt((String)map.get("objectId"));
		
		List<CommentDTO> comments = dao.listComments(comment);
		object.put("data", new JSONArray(comments));
		object.put("status", 200);
		
		return object.toString();
	}

}
