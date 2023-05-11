package board.service;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.bean.BoardQueryOption;
import board.dao.BoardDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListBoardsService implements BoardService{
	@Autowired
	private Map<String, BoardDAO> boardDAO;
	
	@Override
	public String execute(Map<String, Object> map) {
		BoardDAO dao = boardDAO.get("boardDAOMyBatis");
		JSONObject object = new JSONObject();
		
		BoardQueryOption option = parseValue(map);

		List<BoardDTO> boards = dao.listBoards(option);
		object.put("data", new JSONArray(boards));
		object.put("status", 200);
		
		return object.toString();
	}
	
	private BoardQueryOption parseValue(Map<String, Object> map) {
		BoardQueryOption option = new BoardQueryOption();
		if(map != null) {
			if(map.get("categoryId") != null) {
				option.setCategoryId((String)map.get("categoryId"));				
			}
			if(map.get("keyword") != null) {
				option.setKeyword((String)map.get("keyword"));				
			}
			if(map.get("sort") != null) {
				option.setSort((String)map.get("sort")); 
			}
			if (map.get("startItem") != null) {
				option.setStartItem(Integer.parseInt((String)map.get("startItem")));
			}
			if (map.get("itemAmount") != null) {
				option.setItemAmount(Integer.parseInt((String)map.get("itemAmount")));
			}
		}
		
		return option;
	}

	
}
