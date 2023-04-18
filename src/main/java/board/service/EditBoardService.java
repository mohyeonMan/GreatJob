package board.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import lombok.RequiredArgsConstructor;
import recruit.bean.RecruitDTO;

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
		
		BoardDTO replaceBoard = parseValue(map);
		
		dao.update(replaceBoard);
		
		BoardDTO changedBoard = dao.getBoard((int)map.get("id"));
		
		if(replaceBoard == null || changedBoard == null) {
			status = 400;
		}else {
			if(!compareBoard(replaceBoard, changedBoard)) {
				status = 500;
			}
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
	
	private boolean compareBoard(BoardDTO board1, BoardDTO board2) {
		return (
				board1.getId() == board2.getId()
			&&	board1.getTitle().equals(board2.getTitle())
			&&	board1.getDescription().equals(board2.getDescription())
			&&	board1.getCategoryId() == board2.getCategoryId()
		);
	}
}
