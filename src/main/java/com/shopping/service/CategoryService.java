package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping.entity.Category;
import com.shopping.repository.CategoryRepo;

@Service

public class CategoryService {

	// Example of field injection
	// @Autowired
	CategoryRepo categoryRepository;

	// Example of constructor injection
	@Autowired
	public CategoryService(CategoryRepo repo) {
		this.categoryRepository = repo;
	}

	// Example of setter injection
	// @Autowired
//	public setCategoryService(CategoryRepo repo, CategoryRepo s) {
//		this.categoryRepository = repo;
//	}

	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public void deleteCategory(Long id) {
		categoryRepository.delete(null);
	}

	public Page<Category> getAllCategoriesPageable(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return categoryRepository.findAll(pageable);
	}
}
