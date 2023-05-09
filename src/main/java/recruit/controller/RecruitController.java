package recruit.controller;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public String create2(@RequestPart(value = "image", required = false) List<MultipartFile> images,@RequestPart(value = "data") String data) {
		Map<String, Object> map = new HashMap<>();
		if(images != null && !images.isEmpty()) {
			map.put("images", images);
		}
		map.put("data", data);
		return recruitService.get("createRecruitService").execute(map);
	}
	
	@PatchMapping(value = "edit")
	public String edit(@RequestBody Map<String, Object> map) {
		return recruitService.get("editRecruitService").execute(map);
	}
	
	@GetMapping(value = "getRecruit")
	public String getRecruit(@RequestParam Map<String, Object> map) {
		return recruitService.get("getRecruitService").execute(map);
	}

	@GetMapping(value = "listRecruits")
	public String listRecruits(@RequestParam(required = false) Map<String, Object> map) {
		return recruitService.get("listRecruitsService").execute(map);
	}
	
	@DeleteMapping(value = "delete")
	public String delete(@RequestBody Map<String, Object> map) {
		return recruitService.get("deleteRecruitService").execute(map);
	}
	
	@PostMapping(value = "join")
	public String join(@RequestBody Map<String, Object> map) {
		return recruitService.get("joinRecruitService").execute(map);
	}
	
	@DeleteMapping(value = "secede")
	public String secede(@RequestBody Map<String, Object> map) {
		return recruitService.get("secedeRecruitService").execute(map);
	}
}
