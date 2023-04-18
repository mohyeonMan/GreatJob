package category.service;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import category.bean.CategoryDTO;
import category.dao.CategoryDAOMyBatis;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListCategoriesService implements CategoryService{
	@Autowired
	private CategoryDAOMyBatis categoryDAO;

	@Override
	public String execute(Map<String, Object> map) {
		JSONObject object = new JSONObject();
		int status = 200;
		
		if(map.get("object") != null) {
			int categoryObject = Integer.parseInt((String)map.get("object"));
			List<CategoryDTO> arr = categoryDAO.listCategories(categoryObject);
			object.put("data",new JSONArray(arr));
		}else {
			status = 400;
		}
		
		object.put("status", status);
		
		return object.toString();
	}

}
