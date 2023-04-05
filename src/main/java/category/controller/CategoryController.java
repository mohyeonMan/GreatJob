package category.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import category.service.CategoryService;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "category")
public class CategoryController {
	@Autowired
	CategoryService service;
	
	@PostMapping(value = "create")
	public String create(@RequestBody Map<String, Object> map) {
		return service.create(map);
	}
	
	@GetMapping(value = "listCategories")
	public String listCategories() {
		return service.listCategories();
	}
	
	@DeleteMapping(value = "delete")
	public String delete(@RequestBody Map<String, Object> map) {
		return service.delete(map);
	}
}
