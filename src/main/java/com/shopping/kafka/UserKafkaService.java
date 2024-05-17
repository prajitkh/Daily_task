package com.shopping.kafka;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.shopping.entity.Users;

@Service("userKafkaService")
@Component
public class UserKafkaService {

	@Autowired
	private KafkaTemplate<String, Users> kafkaTemplate;

	public String AddUser(List<Users> users) {
		System.out.println("add user method");
		try {
			if (!users.isEmpty()) {

				for (Users users2 : users) {
					System.out.println("users2 " + users2.getName());
					kafkaTemplate.send("Users", users2);
					System.out.println("Message publish to kafka topics");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "User added successfully thorugh  kafka queue";
	}

	@PostConstruct
	public void addUser() {
		Users users = new Users();
		users.setName("Prajit");
		SendMessage(users);
	}

	public String SendMessage(Users users) {
		System.out.println("Users");
		kafkaTemplate.send("Users", users);

		return "ok";
	}
}
