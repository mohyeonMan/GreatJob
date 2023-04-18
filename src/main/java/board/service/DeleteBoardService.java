package board.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.BoardDAO;
import comment.dao.CommentDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteBoardService implements BoardService{
	@Autowired
	private Map<String, BoardDAO> boardDAOMap;
	@Autowired
	private Map<String, CommentDAO> commentDAOMap;
	
	@Override
	public String execute(Map<String, Object> map) {
		BoardDAO boardDAO = boardDAOMap.get("boardDAOMyBatis");
		CommentDAO commentDAO = commentDAOMap.get("commentDAOMyBatis");
		JSONObject object = new JSONObject();
		
		int status = 200;
		
		if(map.get("id") != null) {
			int id = (int)map.get("id");
			
			map.put("object", 0);
			commentDAO.objectDeleted(map);
			boardDAO.delete(id);
			
			if(boardDAO.getBoard(id) != null) {
				status = 500;
			}
		}else {
			status = 400;
		}
		
		object.put("status", status);
		
		return object.toString();
	}
	
	
}