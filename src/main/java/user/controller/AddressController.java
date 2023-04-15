package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
@CrossOrigin
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "address")
public class AddressController {
	@GetMapping(value = "DaumAPI")
	public String addressAPI() {
		return "/WEB-INF/addressAPI.jsp";
	}
}
