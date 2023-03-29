package user.controller;


import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
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
	private Map<String, UserService> userService;

	
	@PostMapping(value = "signIn")
	public JSONArray signIn(@RequestBody UserDTO userDTO) {
		Map<String, Object> map = new HashMap<>();
		map.put("user", userDTO);
		return userService.get("userSignInService").execute(map);
	}

	@PostMapping(value = "logIn")
	public JSONArray logIn(@RequestBody Map<String, Object> map) {
		return userService.get("userLogInService").execute(map);
	} 

	@GetMapping(value = "getUser")
	public JSONArray getUser(@RequestBody Map<String,Object> map) {
		return userService.get("getUserService").execute(map);
	}
	
	@GetMapping(value = "getUserCount")
	public JSONArray getUserCount() {
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
