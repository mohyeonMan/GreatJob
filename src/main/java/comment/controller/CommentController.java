package comment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comment.service.CommentService;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "comment")
public class CommentController {
	@Autowired
	private Map<String, CommentService> serviceMap;
	
	@PostMapping(value = "create")
	public String create(@RequestBody Map<String, Object> map) {
		return serviceMap.get("createCommentService").execute(map);
		
	}
	
	@GetMapping(value = "listComments")
	public String listComments(@RequestParam Map<String, Object> map){
		return serviceMap.get("listCommentsService").execute(map);
	}
	
	@DeleteMapping(value = "delete")
	public String delete(@RequestBody Map<String, Object> map) {
		return serviceMap.get("deleteCommentService").execute(map);
	}
	
}
