package com.shopping.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.shopping.entity.Users;

@Service
public class UserKafkaService {

	@Autowired
	private KafkaTemplate<String, Users> kafkaTemplate;

	public String AddUser(List<Users> users) {

		if (!users.isEmpty()) {
			for (Users users2 : users) {
				kafkaTemplate.send("Users", users2);
				System.out.println("Message publish to kafka topics");
			}
		}
		return "User added successfully thorugh  kafka queue";
	}
}
