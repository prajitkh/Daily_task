package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Category;
import com.shopping.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping("/categories")
	public String addcategory(@RequestBody Category category) {
		this.categoryService.createCategory(category);
		return "category ADDED";

	}

	@GetMapping("/getdatawithpagination")
	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryService.getAllCategories(pageable);
	}

//	@GetMapping("/{id}")
//	public Category getCategoryById(@PathVariable Long id) {
//		// return categoryService.getCategoryById(id);
//	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}

	@GetMapping("/paged")
	public Page<Category> getAllCategoriesPageable(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return categoryService.getAllCategoriesPageable(page, size);
	}
}
