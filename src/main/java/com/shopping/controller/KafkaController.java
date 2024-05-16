package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.kafka.KafkaProducer;

@RestController
public class KafkaController {

	@Autowired
	private KafkaProducer kafkaProducer;

	@GetMapping("/kafka")
	public String sendRequest(@RequestBody String value) {
		kafkaProducer.sendMessage(value);
		return "Message send succesfully";
	}
}
