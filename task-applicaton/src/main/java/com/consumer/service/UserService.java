package com.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumer.Users;

@Service
public class UserService {

	@Autowired
	private com.consumer.Repository.UserRepository userRepository;

	public Users add(Users users) {
		Users save = userRepository.save(users);

		return save;

	}

}
