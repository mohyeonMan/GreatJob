package category.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import category.bean.CategoryDTO;
import category.dao.CategoryDAOMyBatis;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCategoryService implements CategoryService{
	@Autowired
	private CategoryDAOMyBatis categoryDAO;

	@Override
	public String execute(Map<String, Object> map) {
		JSONObject object = new JSONObject();
		int status = 200;
		
		if(map.get("name") != null && map.get("object") != null) {
			CategoryDTO category = new CategoryDTO();
			category.setName((String)map.get("name"));
			category.setObject((int)map.get("object"));
			categoryDAO.create(category);
		}else {
			status = 400;
		}
		
		object.put("status", status);
		
		return object.toString();
	}
	
	

}
