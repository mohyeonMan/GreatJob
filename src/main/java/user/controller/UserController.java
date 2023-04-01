package user.controller;


import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import user.bean.UserDTO;
import user.service.UserService;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	private Map<String, UserService> userService;


	@PostMapping(value = "logIn")
	public String logIn(@RequestBody Map<String, Object> map) {
		return userService.get("userLogInService").execute(map);
	} 

	@GetMapping(value = "getUser")
	public String getUser(@RequestBody Map<String,Object> map) {
		return userService.get("getUserService").execute(map);
	}
	
	@GetMapping(value = "getUserCount")
	public String getUserCount() {
		Map<String, Object> map = new HashMap<>();
		return userService.get("getUserCountService").execute(map);
	}

//	@PutMapping(value = "edit")
//	public JSONArray edit(@RequestBody Map<String, Object> map) {
//		userService.get("editUserService").execute();
//		JSONArray data = new JSONArray();
//		data.put(false);
//	}

//	@DeleteMapping(value = "delete")
//	public void delete(@RequestParam int id) {
//		userService.deleteUser(id);
//	}

}
