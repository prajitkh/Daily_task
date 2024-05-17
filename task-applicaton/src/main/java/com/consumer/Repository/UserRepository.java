package com.consumer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumer.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
}
