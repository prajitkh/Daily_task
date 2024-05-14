package com.shopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.shopping.entity.Users;
import com.shopping.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Users getUserById(int id) {

		return userRepository.findById(id).orElse(null);
	}

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static final String USER_LIST_KEY = "userList";

	@CacheEvict(value = "userCache", key = "#id")
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

//	@CacheEvict(value = "userCache", key = "'users'")
//	public Users add(Users users) {
//		return userRepository.save(users);
//	}

//	@Cacheable(value = "userCache", key = "'users'")
//	public List<Users> getAllUsers() {
//
//		return userRepository.findAll();
//	}

	public Users add(Users users) {
		Users save = userRepository.save(users);
		// Add user in cache memory using List
		redisTemplate.opsForList().rightPush(USER_LIST_KEY, save);

		return save;

	}

	public List<Users> getAllUsers() {

		if (redisTemplate.hasKey(USER_LIST_KEY)) {
			List<Object> range = redisTemplate.opsForList().range(USER_LIST_KEY, 0, -1);
			return range.stream().map(e -> (Users) e).collect(Collectors.toList());
		} else {
			List<Users> user = userRepository.findAll();

			// ADD IN cache
			CacheUser(user);

			return user;
		}
	}

	private void CacheUser(List<Users> user) {

		for (Users u : user) {
			redisTemplate.opsForList().rightPush(USER_LIST_KEY, u);
		}

	}

}
