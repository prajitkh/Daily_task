package com.shopping.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Bean
	LettuceConnectionFactory connectionFactory() {

		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
		redisConfig.setHostName("127.0.0.1");
		redisConfig.setPort(6379);
		LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(redisConfig);
		connectionFactory.setTimeout(1000);

		return connectionFactory;

	}

	@Bean
	RedisTemplate<String, Object> redisTemplate() {

		RedisTemplate<String, Object> template = new RedisTemplate<>();
		RedisSerializer<String> stringSerilizer = new StringRedisSerializer();
		GenericJackson2JsonRedisSerializer jdkSerializationRedisSerializer = new GenericJackson2JsonRedisSerializer();

		template.setConnectionFactory(connectionFactory());
		template.setKeySerializer(stringSerilizer);
		template.setHashKeySerializer(stringSerilizer);
		template.setValueSerializer(jdkSerializationRedisSerializer);
		template.setHashValueSerializer(jdkSerializationRedisSerializer);
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();

		return template;
	}

}
