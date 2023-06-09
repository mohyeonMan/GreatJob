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
public class EditBoardService implements BoardService{
	@Autowired
	private Map<String, BoardDAO> boardDAO;

	@Override
	public String execute(Map<String, Object> map) {
		BoardDAO dao = boardDAO.get("boardDAOMyBatis");
		JSONObject object = new JSONObject();
		int status = 200;
		
		if(map.get("id") != null
		&& map.get("categoryId") != null
		&& map.get("title") != null
		&& map.get("description") != null) {
			BoardDTO replaceBoard = parseValue(map);
			
			if(dao.update(replaceBoard) == 0) {
				status = 500;
			}
		}else {
			status = 400;
		}
		
		object.put("status",status);
		
		return object.toString();
	}

	private BoardDTO parseValue(Map<String, Object> map) {
		BoardDTO board = new BoardDTO();
		board.setId((int)map.get("id"));
		board.setCategoryId((int)map.get("categoryId"));
		board.setTitle((String)map.get("title"));
		board.setDescription((String)map.get("description"));
		
		return board;
	}
	
}
