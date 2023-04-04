package category.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import category.dao.CategoryDAOMyBatis;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "category")
public class CategoryController {
	@Autowired
	private CategoryDAOMyBatis dao;
	
	@PostMapping(value = "create")
	public String create(@RequestBody Map<String, Object> map) {
		dao.create((String)map.get("name"));
		return new JSONObject().put("status", 200).toString();
	}
	
	@GetMapping(value = "listCategories")
	public String listCategories() {
		JSONObject object = new JSONObject();
		
		List<Map<String, Object>> arr = dao.listCategories();
		
		if(arr == null) {
			object.put("status", 500);
		}else {
			object.put("categories",new JSONArray(arr));
			object.put("status", 200);
		}
		
		return object.toString();
	}
}
