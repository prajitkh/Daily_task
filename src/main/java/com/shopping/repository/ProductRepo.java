package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Products;

public interface ProductRepo extends JpaRepository<Products, Integer> {

}
