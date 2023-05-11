 package board.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import lombok.RequiredArgsConstructor;
import recruit.service.S3Manager;

@Service
@RequiredArgsConstructor
public class CreateBoardService implements BoardService{
	@Autowired
	private Map<String, BoardDAO> boardDAO;
	@Autowired
	private S3Manager s3Manager;
	
	@Override
	public String execute(Map<String, Object> map) {
		BoardDAO dao = boardDAO.get("boardDAOMyBatis");
		JSONObject object = new JSONObject();
		int status = 200;
		
		BoardDTO board = parseValue((JSONObject)map.get("data"));
		
		if (map.get("images") != null) {
			String imageUrls = s3Manager.UploadGetUrl((ArrayList<MultipartFile>) map.get("images"));
			board.setImageUrl(imageUrls);
		}
		
		dao.create(board);
		
		object.put("status", status);
		
		return object.toString();
	}
	
	private BoardDTO parseValue(JSONObject data) {
		BoardDTO board = new BoardDTO();
		board.setUserId((int)data.get("userId"));
		board.setCategoryId((int)data.get("categoryId"));
		board.setTitle((String)data.get("title"));
		board.setDescription((String)data.get("description"));
		
		return board;
	}
	
	

}
