package recruit.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
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

import com.fasterxml.jackson.core.JsonParser;

import lombok.RequiredArgsConstructor;
import recruit.bean.TestDTO;
import recruit.service.RecruitService;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "recruit")
public class RecruitController {
	@Autowired
	private Map<String, RecruitService> recruitService;

	@PostMapping(value = "multiPart")
	public void multiPart(@RequestParam(value = "file") MultipartFile file,@RequestPart(value = "key", required = false) TestDTO key) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		if(key != null) {
			System.out.println("key = "+key.getKey());			
		}else {
			System.out.println("data is null");
		}
	}
	
	@PostMapping(value = "image")
	public void postMethodName(@RequestBody MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
	}

	
	
	
	
	
	@PostMapping(value = "create")
	public String create(@RequestBody Map<String, Object> map) {
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
	
}
