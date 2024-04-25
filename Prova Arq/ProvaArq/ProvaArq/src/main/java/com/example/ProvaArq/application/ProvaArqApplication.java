package com.example.ProvaArq.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories("com.example.ProvaArq.repository")
public class ProvaArqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaArqApplication.class, args);
	}

}
