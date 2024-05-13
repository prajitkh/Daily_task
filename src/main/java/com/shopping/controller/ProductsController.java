package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Products;
import com.shopping.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductsController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public String addProduct(@RequestBody Products products) {
		this.productService.createProduct(products);
		return "Proudct ADDED";

	}

	@GetMapping("/{id}")
	public Products getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}

	@PostMapping
	public Products createProduct(@RequestBody Products product) {
		return productService.createProduct(product);
	}

	@DeleteMapping("dele/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}

	@GetMapping("/products/paged")
	public Page<Products> getAllProductsPageable(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return productService.getAllProductsPageable(page, size);
	}

}
