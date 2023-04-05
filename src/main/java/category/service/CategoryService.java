package category.service;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import category.dao.CategoryDAOMyBatis;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	@Autowired
	private CategoryDAOMyBatis dao;
	
	public String create(@RequestBody Map<String, Object> map) {
		dao.create((String)map.get("name"));
		return new JSONObject().put("status", 200).toString();
	}
	
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

	public String delete(Map<String, Object> map) {
		dao.delete((int)map.get("id"));
		return new JSONObject().put("status", 200).toString();
	}
}
