package category.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import category.dao.CategoryDAOMyBatis;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteCategoryService implements CategoryService{
	@Autowired
	private CategoryDAOMyBatis categoryDAO;

	@Override
	public String execute(Map<String, Object> map) {
		JSONObject object = new JSONObject();
		int status = 200;
		
		if(map.get("id") != null) {
			categoryDAO.delete((int)map.get("id"));			
		}else {
			status = 400;
		}
		
		object.put("status", status);
		
		return object.toString();
	}
	
	
}
