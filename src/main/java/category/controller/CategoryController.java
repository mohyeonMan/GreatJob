package category.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import category.service.CategoryService;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "category")
public class CategoryController {
	@Autowired
	private Map<String, CategoryService> serviceMap;
	
	@PostMapping(value = "create")
	public String create(@RequestBody Map<String, Object> map) {
		return serviceMap.get("createCategoryService").execute(map);
	}
	
	@GetMapping(value = "listCategories")
	public String listCategories(@RequestParam Map<String, Object> map) {
		return serviceMap.get("listCategoriesService").execute(map);
	}
	
	@DeleteMapping(value = "delete")
	public String delete(@RequestBody Map<String, Object> map) {
		return serviceMap.get("deleteCategoryService").execute(map);
	}
}
