package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Users;
import com.shopping.kafka.UserKafkaService;
import com.shopping.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserKafkaService kafkaService;

	@GetMapping("/users/{id}")
	public Users getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@PostMapping("/users")
	public Users add(@RequestBody Users users) {
		return userService.add(users);
	}

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	// add users through Kafka

	@PostMapping(value = "/add")
	public String addUser(@RequestBody List<Users> users) {
		System.out.println("user services ");
		kafkaService.AddUser(users);

		return "user added ";

	}

}