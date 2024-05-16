package com.shopping.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "test-topic", groupId = "group-id")
	public void listen(String message) {
		System.out.println("Received message: " + message);
	}
}
