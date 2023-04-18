package board.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetBoardService implements BoardService{
	@Autowired
	private Map<String, BoardDAO> boardDAO;
	
	@Override
	public String execute(Map<String, Object> map) {
		BoardDAO dao = boardDAO.get("boardDAOMyBatis");
		JSONObject object = new JSONObject();
		int status = 200;
		
		if (map.get("id") != null) {
			int id = (int)map.get("id");
			BoardDTO board = dao.getBoard(id);
			dao.hit(id);
			if(board != null) {
				object.put("data", new JSONObject(board));				
			}else {
				status = 400;
			}
		}else {
			status = 400;
		}
		
		object.put("status", status);
		
		return object.toString();
	}

}
