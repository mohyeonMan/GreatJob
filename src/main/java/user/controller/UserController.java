package user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import user.bean.UserDTO;
import user.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping(value = "signIn")
	public void signIn(@ModelAttribute UserDTO user) {
		userService.signIn(user);
	}
	
//	@PostMapping(value = "logIn")
//	public void logIn(@ModelAttribute UserDTO user) {
//		user
//	}
	
	
	
	@GetMapping(value = "getUser")
	public UserDTO getMethodName(@RequestParam int id) {
		return userService.getUser(id);
	}
	
	@PutMapping(value = "edit")
	public void edit(@ModelAttribute UserDTO user) {
		userService.editUser(user);
	}
	
	@DeleteMapping(value = "delete")
	public void delete(@RequestParam int id) {
		userService.deleteUser(id);
	}

	
	

}
