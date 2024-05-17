package com.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConsumer {

	@Bean
	public ConsumerFactory<Integer, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerProps());
	}

//	@Bean
//	public ConsumerFactory<String, String> consumerFactory() {
//		Map<String, Object> props = new HashMap<>();
//		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, host);
//		props.put(ConsumerConfig.GROUP_ID_CONFIG, "bulkUpload");
//		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		return new DefaultKafkaConsumerFactory<>(props);
//	}

	@Bean
	ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory(
			ConsumerFactory<Integer, String> consumerFactory) {
		ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory);
		return factory;
	}

	private Map<String, Object> consumerProps() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		// ...
		return props;
	}
}
