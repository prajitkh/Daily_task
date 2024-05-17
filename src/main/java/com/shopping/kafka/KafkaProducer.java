package com.shopping.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

//@Component
public class KafkaProducer {

	private static final String TOPIC = "test-topic";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Bean
	public void sendMessage(String message) {
		kafkaTemplate.send(TOPIC, message);
	}
}
