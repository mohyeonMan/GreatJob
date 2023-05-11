package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import board.service.BoardService;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "board")
public class BoardController {
	@Autowired
	private Map<String, BoardService> boardService;
	
	@PostMapping(value = "create")
	public String create(@RequestPart(value = "image",required = false) List<MultipartFile> images,
			@RequestPart(value = "data") String data) {
		Map<String, Object> map = new HashMap<>();
		if(images != null && !images.isEmpty()) {
			map.put("images", images);
		}
		map.put("data", new JSONObject(data));
		return boardService.get("createBoardService").execute(map);		
	}
	
	@PatchMapping(value = "edit")
	public String edit(@RequestBody Map<String, Object> map) {
		return boardService.get("editBoardService").execute(map);
	}
	
	@GetMapping(value = "getBoard")
	public String getRecruit(@RequestParam Map<String, Object> map) {
		return boardService.get("getBoardService").execute(map);
	}
	
	@GetMapping(value = "listBoards")
	public String listRecruits(@RequestParam(required = false) Map<String, Object> map) {
		return boardService.get("listBoardsService").execute(map);
	}
	
	@DeleteMapping(value = "delete")
	public String delete(@RequestBody Map<String, Object> map) {
		return boardService.get("deleteBoardService").execute(map);
	}
	
	
	
}
