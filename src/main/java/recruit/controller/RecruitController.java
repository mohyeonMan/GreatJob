package recruit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import recruit.service.RecruitService;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "recruit")
public class RecruitController {
	@Autowired
	private Map<String, RecruitService> recruitService;

	@PostMapping(value = "create")
	public String create(@RequestBody Map<String, Object> map) {
		return recruitService.get("createRecruitService").execute(map);
	}

	@GetMapping(value = "listRecruits")
	public String listRecruits(@RequestBody(required = false) Map<String, Object> map) {
		return recruitService.get("listRecruitsService").execute(map);
	}
}
