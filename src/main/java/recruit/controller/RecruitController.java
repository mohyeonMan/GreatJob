package recruit.controller;

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

import lombok.RequiredArgsConstructor;
import recruit.service.RecruitService;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "recruit")
public class RecruitController {
	@Autowired
	private Map<String, RecruitService> recruitService;

	@PostMapping(value = "multiPart")
	public void multiPart(@RequestPart(value = "image") List<MultipartFile> file,@RequestPart(value = "data", required = false) String key) {
		for(int i=0;i<file.size();i++) {
			System.out.println(file.get(i).getOriginalFilename());
			System.out.println(file.get(i).getContentType());
		}
		
		if(key != null) {
			System.out.println("key = "+new JSONObject(key).toString());			
		}else {
			System.out.println("key is null");
		}
	}
	
//	@PostMapping(value = "multiPart2")
//	public void multiPart2(@RequestParam(value = "file") List<MultipartFile> g,@RequestBody(required = false) Map<String, Object> key) {
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getContentType());
//		if(key != null) {
//			System.out.println("key = "+key.entrySet());			
//		}else {
//			System.out.println("key is null");
//		}
//	}
	
	@PostMapping(value = "image")
	public void postMethodName(@RequestBody MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
	}

	
	
	
	
	
	@PostMapping(value = "create")
	public String create(@RequestBody Map<String, Object> map) {
		return recruitService.get("createRecruitService").execute(map);
	}
	
	@PostMapping(value = "create2")
	public String create2(@RequestPart(value = "image", required = false) List<MultipartFile> images,@RequestPart(value = "data") String data) {
		Map<String, Object> map = new HashMap<>();
		if(images != null && !images.isEmpty()) {
			map.put("images", images);			
		}
		map.put("data", data);
		return recruitService.get("createRecruitService2").execute(map);
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
