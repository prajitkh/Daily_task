package com.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.shopping.config.Logger;

@SpringBootApplication
@EnableCaching
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Logger logger = Logger.getLogger();
		Logger loggerq1 = Logger.getLogger();
		Logger loggerq2 = Logger.getLogger();

		System.out.println("Check hashCode " + logger.toString().hashCode());
		System.out.println("loggerq1 " + loggerq1.toString().hashCode());
		System.out.println("loggerq2 " + loggerq2.toString().hashCode());

		logger.log("Starting application...");
		logger.log("Processing data...");
		logger.log("Application finished.");

	}

}
