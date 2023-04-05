package user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
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

	@PostMapping(value = "getUser")
	public String getUser(@RequestBody Map<String, Object> map) {
		return userService.get("getUserService").execute(map);
	}

	@GetMapping(value = "getUserCount")
	public String getUserCount() {
		Map<String, Object> map = new HashMap<>();
		return userService.get("getUserCountService").execute(map);
	}

	@PatchMapping(value = "edit")
	public String edit(@RequestBody Map<String, Object> map) {
		return userService.get("editUserService").execute(map);
	}

	@DeleteMapping(value = "delete")
	public String delete(@RequestBody Map<String, Object> map) {
		return userService.get("deleteUserService").execute(map);
	}
	
	@PatchMapping(value = "rollBack")
	public String rollback(@RequestBody Map<String, Object> map) {
		return userService.get("rollBackUserService").execute(map);
	}
	@GetMapping(value = "listUsers")
	public String listUsers(@RequestParam(required = false)Map<String, Object> map) {
		return userService.get("listUsersService").execute(map);
	}

}
