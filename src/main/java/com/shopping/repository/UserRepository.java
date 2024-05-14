package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
}
