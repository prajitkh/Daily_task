package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping.entity.Products;
import com.shopping.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepository;

	public List<Products> getAllProducts() {
		return productRepository.findAll();
	}

	public Products getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	public Products createProduct(Products product) {
		return productRepository.save(product);
	}

	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

	public Page<Products> getAllProductsPageable(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return productRepository.findAll(pageable);
	}
}
