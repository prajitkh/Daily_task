package com.shopping.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.shopping.entity.Users;

@Configuration
@EnableKafka
public class KafkaProducerConfig {

	@Bean
	public ProducerFactory<String, Users> factory() {
		Map<String, Object> map = new HashMap<>();
		map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9003");
		map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<String, Users>(map);

	}

	@Bean(name = "kafkatemplate")
	public KafkaTemplate<String, Users> kafkaTemplate() {
		System.err.println("Configuartion class");
		return new KafkaTemplate<>(factory());
	}

}
